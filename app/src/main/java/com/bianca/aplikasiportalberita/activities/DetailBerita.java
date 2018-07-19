package com.bianca.aplikasiportalberita.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bianca.aplikasiportalberita.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailBerita extends AppCompatActivity {

    //variable penampung
    public static final String EXTRA_JUDUL = "judul";
    public static final String EXTRA_GAMBAR_BERITA = "gambar";
    public static final String EXTRA_TGL_POSTING = "tgl_posting";
    public static final String EXTRA_PENULIS = "penulis";
    public static final String EXTRA_ISI_BERITA = "isi";





    @BindView(R.id.iv_gambar_detail)
    ImageView ivGambarBerita;
    @BindView(R.id.tv_tgl_posting_detail)
    TextView tvTglPostingDetail;
    @BindView(R.id.tv_penulis_detail)
    TextView tvPenulisDetail;
    @BindView(R.id.wvContent_berita)
    WebView wvContentBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        ButterKnife.bind(this);

        showBeritaDetail();

    }

    @SuppressLint("SetJavaScriptEnabled")
    private void showBeritaDetail(){

        String judul = getIntent().getStringExtra(EXTRA_JUDUL);
        String tglPosting = getIntent().getStringExtra(EXTRA_TGL_POSTING);
        String tvPenulis = getIntent().getStringExtra(EXTRA_PENULIS);
        String isiBerita = getIntent().getStringExtra(EXTRA_ISI_BERITA);
        String imageBerita = getIntent().getStringExtra(EXTRA_GAMBAR_BERITA);

        getSupportActionBar().setTitle(judul);

        tvTglPostingDetail.setText(tglPosting);
        tvPenulisDetail.setText(tvPenulis);

        Picasso.get().load(imageBerita).into(ivGambarBerita);

        wvContentBerita.getSettings().setJavaScriptEnabled(true);
        wvContentBerita.loadData(isiBerita, "text/html; charset=utf-8", "UTF-8");




    }
}
