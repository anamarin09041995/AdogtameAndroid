package com.example.anitamarin.adogtame;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.anitamarin.adogtame.databinding.ActivityMainBinding;
import com.example.anitamarin.adogtame.fragments.CatalogoFragment;
import com.example.anitamarin.adogtame.fragments.DonacionesFragment;
import com.example.anitamarin.adogtame.fragments.SeguimientoFragment;
import com.example.anitamarin.adogtame.fragments.VoluntariadoFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ActivityMainBinding binding;
    int content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        content = R.id.navigation_catalogo;
        if(savedInstanceState != null){
            content = savedInstanceState.getInt("content");
        }
        setContent(content);
        binding.bottomNavigation.setOnNavigationItemSelectedListener(this);
    }

    public void putFragment(int container, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(container, fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        setContent(item.getItemId());
        return true;
    }

    void setContent(int navItem){
        content = navItem;
        switch (navItem) {
            case R.id.navigation_catalogo:
                getSupportActionBar().setTitle(R.string.title_catalogo);
                putFragment(R.id.container, CatalogoFragment.instance());
                break;
            case R.id.navigation_donaciones:
                getSupportActionBar().setTitle(R.string.title_donaciones);
                putFragment(R.id.container, DonacionesFragment.instance());
                break;
            case R.id.navigation_seguimiento:
                getSupportActionBar().setTitle(R.string.title_seguimiento);
                putFragment(R.id.container, SeguimientoFragment.instance());
                break;
            case R.id.navigation_voluntariado:
                getSupportActionBar().setTitle(R.string.title_voluntariado);
                putFragment(R.id.container, VoluntariadoFragment.instance());
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("content", content);
        super.onSaveInstanceState(outState);
    }
}
