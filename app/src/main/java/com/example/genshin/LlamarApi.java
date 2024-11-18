package com.example.genshin;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LlamarApi {
    final String URL_BASE = "https://nmcbbfuvnvwujptstkzz.supabase.co/rest/v1/";

    Retrofit retrofit = new Retrofit.Builder().baseUrl(URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();

    InterfazApi genshinAPI = retrofit.create(InterfazApi.class);
}
