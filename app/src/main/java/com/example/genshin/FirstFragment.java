package com.example.genshin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;

import com.example.genshin.databinding.FragmentFirstBinding;



public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Personaje> pjs = new ArrayList<>();

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        int id = 1;
        int ultimaid = 88;
        llamarPjs(id, ultimaid);
    }
    private void llamarPjs(int id, int uid) {
        if (id > uid){
            Toast.makeText(getContext(),"Generado", Toast.LENGTH_SHORT).show();
        } else {
            MetodosPjs metodospjs = new MetodosPjs();

            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                metodospjs.getPersonaje((id), Personaje -> {
                    if (Personaje != null) {
                        getActivity().runOnUiThread(() -> {
                            pjs.add(Personaje);
                            llamarPjs(id + 1, uid);
                        });
                    } else {
                        getActivity().runOnUiThread(() ->
                                Toast.makeText(getContext(), "Error al cargar el Pokémon con ID " + id, Toast.LENGTH_SHORT).show()
                        );
                    }
                });
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}