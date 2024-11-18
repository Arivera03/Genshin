package com.example.genshin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfazApi {
    @GET("Personajes")
    Call<List<Personaje>> getPersonaje(@Query("id") String id, @Query("apikey") String apikey);
}
