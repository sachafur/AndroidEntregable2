package com.example.sasha.entregable2;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.sasha.entregable2.receta.Receta;
import com.example.sasha.entregable2.receta.RecetaAmpliacion;
import com.example.sasha.entregable2.receta.RecetaAmpliacionActivity;
import com.example.sasha.entregable2.receta.RecetasFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RecetasFragment.NotificadorReceta {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragmentACargar = null;
        switch (item.getItemId()) {
            case R.id.recetas_nav:
                fragmentACargar = new RecetasFragment();
                break;
            case R.id.about_us:
                fragmentACargar = new AboutUsFragment();
                break;
        }
        cargarFragment(fragmentACargar);
        drawerLayout.closeDrawers();
        return true;
    }


    public void cargarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.fragment_container, fragment).commit();
    }

    @Override
    public void notificar(Receta receta) {
        Intent intent = new Intent(this, RecetaAmpliacionActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(RecetaAmpliacion.RECETA_KEY, receta);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

