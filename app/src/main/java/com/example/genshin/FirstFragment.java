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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;

import com.example.genshin.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private ArrayList<Personaje> pjs = new ArrayList<>();
    private ArrayAdapter<Personaje> adapter;
    private boolean generar = true;


    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        pjs = new ArrayList<>();
        adapter = new adaptador(getContext(), R.layout.fragment_listapag1_personajes_genshin, pjs);
        binding.listaPersonajes.setAdapter(adapter);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppDatabase db = AppDatabase.getDatabase(getContext());

        db.getPersonajeDao().getPersonajes().observe(getViewLifecycleOwner(), personajes -> {
            pjs.clear();
            pjs.addAll(personajes);
            adapter.notifyDataSetChanged();
        });

        binding.listaPersonajes.setOnItemClickListener((adapter, fragment, i, l) -> {
            Personaje pj = (Personaje) adapter.getItemAtPosition(i);
            Bundle args = new Bundle();
            args.putSerializable("item", pj);
            generar = false;

            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment, args);
        });
    }

//    private void llamarPjs(int id, int uid) {   // Método para llamar a la api a traves de metodospjs con el getPersonaje haciendo un call
//        if (id > uid) {
//            Toast.makeText(getContext(), "Generado", Toast.LENGTH_SHORT).show();
//        } else {
//            MetodosPjs metodospjs = new MetodosPjs();
//
//            ExecutorService executor = Executors.newSingleThreadExecutor();
//            executor.execute(() -> {
//                metodospjs.getPersonaje((id), personaje -> {    // Usamos el metodo para obtener a los personajes por su id
//                    if (personaje != null) { //  Si el personaje que agarra no es null entonces genera el personaje
//                        ExecutorService executordb = Executors.newSingleThreadExecutor();
//                        executordb.execute(() -> {
//                            getActivity().runOnUiThread(() -> {
//                                pjs.add(personaje);     // Añadimos a la lista de personajes el personaje por la id que agarre
//                                adapter.notifyDataSetChanged(); // Notificamos al adaptador de que la array se ha modificado
//                                if (generar) {
//                                    llamarPjs(id + 1, uid);     //  Usamos recursividad
//                                }
//                            });
//                        });
//                    } else {    // Si no saltará un error y te notificará la id que ha fallado
//                        getActivity().runOnUiThread(() ->
//                                Toast.makeText(getContext(), "Error al cargar el Pokémon con ID " + id, Toast.LENGTH_SHORT).show()
//                        );
//                    }
//                });
//            });
//        }
//    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}