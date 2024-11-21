package com.example.genshin;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonajeDAO {
    @Query("select * from Personaje")
    LiveData<List<Personaje>> getPersonajes();

    @Insert
    void anadirpj(Personaje personaje);

    @Insert
    void anadirpjs(List<Personaje> personajes);

    @Delete
    void borrarPersonaje(Personaje personaje);

    @Query("DELETE FROM Personaje")
    void borrarPersonajes();
}
