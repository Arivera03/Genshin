package com.example.genshin;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Personaje implements Serializable {
    @SerializedName("Nombre")
    public String nombre;
    @SerializedName("id")
    public int ID;
    @SerializedName("Elemento")
    public String elemento;
    @SerializedName("TipoArma")
    public String tipoarma;
    @SerializedName("Rareza")
    public int rareza;

    public Personaje(){

    }

    public Personaje(String n, int id, String e, String ta, int r){
        this.nombre = n;
        this.ID = id;
        this.elemento = e;
        this.tipoarma = ta;
        this.rareza = r;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getTipoarma() {
        return tipoarma;
    }

    public void setTipoarma(String tipoarma) {
        this.tipoarma = tipoarma;
    }

    public int getRareza() {
        return rareza;
    }

    public void setRareza(int rareza) {
        this.rareza = rareza;
    }
}
