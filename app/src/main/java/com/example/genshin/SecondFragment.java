package com.example.genshin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

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
            Personaje pokemon = (Personaje) args.getSerializable("item");

            if (pokemon != null) {
                //updateUi(pokemon);
            }
        }
    }
    private void actualizarinfo(Personaje personaje) {
        Log.d("infopjs", personaje.toString());

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}