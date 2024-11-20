package com.example.genshin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.List;

public class adaptador extends ArrayAdapter<Personaje> {
    public adaptador(Context context, int resource, List<Personaje> pjs) {
        super(context, resource, pjs);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Personaje personaje = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.fragment_listapag1_personajes_genshin, parent, false);
        }

        TextView nombrepj = convertView.findViewById(R.id.personajeNombre);
        TextView rarezapj = convertView.findViewById(R.id.personajeRareza);
        ImageView fotopj = convertView.findViewById(R.id.personajeImagen);

        nombrepj.setText(personaje.getNombre());
        if (personaje.getRareza() == 4){
            rarezapj.setText(personaje.getRareza() + " ⭐⭐⭐⭐");
        } else {
            rarezapj.setText(personaje.getRareza() + " ⭐⭐⭐⭐⭐");
        }
        String urlicono = personaje.getIcono();
        Glide.with(getContext()).load(urlicono).into(fotopj);
        return convertView;
    }
}
