package com.example.genshin;

import android.util.Log;

import java.util.function.Consumer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MetodosPjs {
    public void getPersonaje(int id, Consumer<Personaje> callback) {
        LlamarApi llamada = new LlamarApi();
        Call<Personaje> call = llamada.genshinAPI.getPersonaje(id);

        call.enqueue(new Callback<Personaje>() {
            @Override
            public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Personaje pj = response.body();
                    callback.accept(pj);
                } else {
                    Log.e("error", "No va");
                    callback.accept(null);
                }
            }

            @Override
            public void onFailure(Call<Personaje> call, Throwable t) {
                Log.d("error", "no va");
            }
        });
    }
}
