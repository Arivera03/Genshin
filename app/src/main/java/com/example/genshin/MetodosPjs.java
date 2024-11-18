package com.example.genshin;

import android.util.Log;

import java.util.List;
import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MetodosPjs {
    private static final String API_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5tY2JiZnV2bnZ3dWpwdHN0a3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE2NjEzNDIsImV4cCI6MjA0NzIzNzM0Mn0.ffeva3a3PBmqH4cL1PvyN_7JIXv1-80bP7y-iX5UTew";

    public void getPersonaje(int id, Consumer<Personaje> callback) {
        LlamarApi llamada = new LlamarApi();
        String idFilter = "eq." + id;

        Call<List<Personaje>> call = llamada.genshinAPI.getPersonaje(idFilter, API_KEY);

        call.enqueue(new Callback<List<Personaje>>() {
            @Override
            public void onResponse(Call<List<Personaje>> call, Response<List<Personaje>> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().isEmpty()) {
                    Personaje pj = response.body().get(0);
                    callback.accept(pj);
                } else {
                    Log.e("error", "Este id (" + id + ") no va");
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call<List<Personaje>> call, Throwable t) {
                Log.e("error", "No va esto");
                callback.accept(null);
            }
        });
    }
}
