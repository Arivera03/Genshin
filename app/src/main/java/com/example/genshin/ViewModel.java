package com.example.genshin;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.chromium.base.task.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ViewModel extends AndroidViewModel {
    private final Application app;
    private final AppDatabase appDatabase;
    private final PersonajeDAO movieDao;
    private LiveData<List<Personaje>> personajes;

    public ViewModel(Application application) {
        super(application);

        this.app = application;
        this.appDatabase = AppDatabase.getDatabase(
                this.getApplication());
        this.movieDao = appDatabase.getPersonajeDao();
    }

    public LiveData<List<Personaje>> getPersonajes() {
        return movieDao.getPersonajes();
    }


    public void reload() {
        RefreshDataTask task = new RefreshDataTask();
        //task.execute();
    }

    private class RefreshDataTask extends AsyncTask<Void> {
        protected Void doInBackground(Void... voids) {

            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(
                    app.getApplicationContext()
            );
            String pais = preferences.getString("pais", "es");
            String tipusConsulta = preferences.getString(
                    "tipus_consulta", "vistes"
            );

            InterfazApi api = new InterfazApi() {
                @Override
                public Call<List<Personaje>> getPersonaje(String id, String apikey) {
                    return null;
                }
            };
            ArrayList<Personaje> result;


            movieDao.borrarPersonajes();

            return null;
        }

        @Override
        protected Void doInBackground() {
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {

        }
    }

}
