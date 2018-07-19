package com.bianca.aplikasiportalberita.Network;

import com.bianca.aplikasiportalberita.Response.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Bianca on 18/07/2018.
 */

public interface ApiService {

    //get tampil-berita.php
    @GET("tampil_berita.php")
    Call<ResponseBerita> getShowAllBerita();


}
