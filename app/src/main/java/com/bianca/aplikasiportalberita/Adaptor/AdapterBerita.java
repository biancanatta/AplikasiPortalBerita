package com.bianca.aplikasiportalberita.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bianca.aplikasiportalberita.MainActivity;
import com.bianca.aplikasiportalberita.MyConstant;
import com.bianca.aplikasiportalberita.R;
import com.bianca.aplikasiportalberita.Response.BeritaItem;
import com.bianca.aplikasiportalberita.activities.DetailBerita;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Bianca on 18/07/2018.
 */


public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder> {
    Context context;
    List<BeritaItem> listBerita;

    public AdapterBerita(Context context, List<BeritaItem> listBerita) {
        this.context = context;
        this.listBerita = listBerita;
    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemberita, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.tvJudulBerita.setText(listBerita.get(position).getJudulBerita());
        holder.tvPenulis.setText(listBerita.get(position).getPenulis());
        holder.tvTglPosting.setText(listBerita.get(position).getTanggalPosting());

        final String images = MyConstant.URL_API_IMAGES + listBerita.get(position).getFoto();
        Picasso.get().load(images).into(holder.ivBerita);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move = new Intent(context, DetailBerita.class );
                move.putExtra(DetailBerita.EXTRA_JUDUL, listBerita.get(position).getJudulBerita());
                move.putExtra(DetailBerita.EXTRA_GAMBAR_BERITA, images);
                move.putExtra(DetailBerita.EXTRA_ISI_BERITA, listBerita.get(position).getIsiBerita());
                move.putExtra(DetailBerita.EXTRA_PENULIS, listBerita.get(position).getPenulis());
                move.putExtra(DetailBerita.EXTRA_TGL_POSTING, listBerita.get(position).getTanggalPosting());

                context.startActivity(move);


            }
        });


    }

    @Override
    public int getItemCount() {
        return listBerita.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_berita)
        ImageView ivBerita;
        @BindView(R.id.tv_judul_berita)
        TextView tvJudulBerita;
        @BindView(R.id.tv_tgl_posting)
        TextView tvTglPosting;
        @BindView(R.id.tv_penulis)
        TextView tvPenulis;

        public ViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
