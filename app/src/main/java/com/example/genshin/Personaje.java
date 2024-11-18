package com.example.genshin;

public class Personaje {
    public String nombre;
    public int id;
    public String elemento;
    public String tipoarma;
    public int rareza;

    public Personaje(){

    }

    public Personaje(String n, int id, String e, String ta, int r){
        this.nombre = n;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
