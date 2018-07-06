package com.example.sasha.entregable2.receta;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sasha.entregable2.R;
import com.example.sasha.entregable2.receta.RecetaAmpliacion;

public class RecetaAmpliacionActivity extends AppCompatActivity {
    private RecetaAmpliacion recetaAmpliacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta_ampliacion);

        Bundle bundle = getIntent().getExtras();
        recetaAmpliacion = new RecetaAmpliacion();
        recetaAmpliacion.setArguments(bundle);
        cargarFragment(recetaAmpliacion);

    }

    private void cargarFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ampliacion_container, fragment);
        fragmentTransaction.commit();
    }
}
