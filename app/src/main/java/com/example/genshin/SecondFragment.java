package com.example.genshin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.genshin.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null) {
            Personaje personaje = (Personaje) args.getSerializable("item");

            if (personaje != null) {
                actualizarinfo(personaje);
            }
        }
    }
    private void actualizarinfo(Personaje personaje) {
        Log.d("infopjs", personaje.toString());

        binding.detPersonajeNombre.setText(personaje.getNombre());
        binding.detPersonajeElemento.setText(personaje.getElemento());
        binding.detPersonajeTipoArma.setText(personaje.getTipoarma());
        if (personaje.getRareza() == 4){
            binding.detPersonajeRareza.setText("⭐⭐⭐⭐");
        } else {
            binding.detPersonajeRareza.setText("⭐⭐⭐⭐⭐");
        }
        String urlImagenGacha = personaje.getImgGacha();
        Glide.with(getContext()).load(urlImagenGacha).into(binding.detPersonajeImagen);
        if (binding.detPersonajeTipoArma.getText().equals("Espada Ligera")){
            Glide.with(getContext()).load(R.drawable.iconoespadaligera).into(binding.detImagenTipoArma);
        } else if (binding.detPersonajeTipoArma.getText().equals("Arco")){
            Glide.with(getContext()).load(R.drawable.arco).into(binding.detImagenTipoArma);
        } else if(binding.detPersonajeTipoArma.getText().equals("Lanza")){
            Glide.with(getContext()).load(R.drawable.lanza).into(binding.detImagenTipoArma);
        } else if(binding.detPersonajeTipoArma.getText().equals("Mandoble")){
            Glide.with(getContext()).load(R.drawable.mandoble).into(binding.detImagenTipoArma);
        } else if (binding.detPersonajeTipoArma.getText().equals("Catalizador")){
            Glide.with(getContext()).load(R.drawable.catalizador).into(binding.detImagenTipoArma);
        }

        if (binding.detPersonajeElemento.getText().equals("Pyro")){
            Glide.with(getContext()).load(R.drawable.pyro).into(binding.detImagenElemento);
        } else if (binding.detPersonajeElemento.getText().equals("Anemo")){
            Glide.with(getContext()).load(R.drawable.anemo).into(binding.detImagenElemento);
        } else if (binding.detPersonajeElemento.getText().equals("Cryo")){
            Glide.with(getContext()).load(R.drawable.cryo).into(binding.detImagenElemento);
        } else if (binding.detPersonajeElemento.getText().equals("Dendro")){
            Glide.with(getContext()).load(R.drawable.dendro).into(binding.detImagenElemento);
        } else if (binding.detPersonajeElemento.getText().equals("Electro")){
            Glide.with(getContext()).load(R.drawable.electro).into(binding.detImagenElemento);
        } else if (binding.detPersonajeElemento.getText().equals("Geo")) {
            Glide.with(getContext()).load(R.drawable.geo).into(binding.detImagenElemento);
        } else if (binding.detPersonajeElemento.getText().equals("Hydro")) {
            Glide.with(getContext()).load(R.drawable.hydro).into(binding.detImagenElemento);
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}