package com.bianca.aplikasiportalberita.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bianca.aplikasiportalberita.MyConstant.URL_API;

/**
 * Created by Bianca on 18/07/2018.
 */

public class ConfigRetrofit {

    public static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static ApiService getInstance(){
        return setInit().create(ApiService.class);

    }
}
