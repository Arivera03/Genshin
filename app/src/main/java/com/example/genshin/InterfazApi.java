package com.example.genshin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InterfazApi {
    @GET("Personajes?id=eq.{id}&apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im5tY2JiZnV2bnZ3dWpwdHN0a3p6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzE2NjEzNDIsImV4cCI6MjA0NzIzNzM0Mn0.ffeva3a3PBmqH4cL1PvyN_7JIXv1-80bP7y-iX5UTew")
    Call<Personaje> getPersonaje(@Path("id") int id);
}
