package com.bianca.aplikasiportalberita;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bianca.aplikasiportalberita.Adaptor.AdapterBerita;
import com.bianca.aplikasiportalberita.Network.ApiService;
import com.bianca.aplikasiportalberita.Response.BeritaItem;
import com.bianca.aplikasiportalberita.Response.ResponseBerita;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.bianca.aplikasiportalberita.Network.ConfigRetrofit.getInstance;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.my_recycler_view)
    RecyclerView myRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        showBerita();

    }
    private void showBerita() {
        //siapin request ke url database
        ApiService service = getInstance();

        //kirim request ke url database
        Call<ResponseBerita> beritaCall = service.getShowAllBerita();
        beritaCall.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                //buat kondisi
                if (response.isSuccessful()) {
                    Log.d("TAG", response.body().toString());
                    List<BeritaItem> berita = response.body().getBerita();
                    boolean status = response.body().isStatus();

                    if (status) {
                        AdapterBerita adapter = new AdapterBerita(MainActivity.this, berita);
                        myRecyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(MainActivity.this, "Eror", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Eror", Toast.LENGTH_SHORT).show();
                t.printStackTrace();

            }
        });

    }
}

