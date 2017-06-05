package com.example.anitamarin.adogtame;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.anitamarin.adogtame.databinding.ActivityMainBinding;
import com.example.anitamarin.adogtame.fragments.CatalogoFragment;
import com.example.anitamarin.adogtame.fragments.DonacionesFragment;
import com.example.anitamarin.adogtame.fragments.SeguimientoFragment;
import com.example.anitamarin.adogtame.fragments.VoluntariadoFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private Fragment fragment;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.frame_layout, new CatalogoFragment()).commit();

        binding.bottomNavigation.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        switch (item.getItemId()) {
                            case R.id.navigation_catalogo:
                                fragment = new CatalogoFragment();
                                break;
                            case R.id.navigation_donaciones:
                                fragment = new DonacionesFragment();
                                break;
                            case R.id.navigation_seguimiento:
                                fragment = new SeguimientoFragment();
                                break;
                            case R.id.navigation_voluntariado:
                                fragment = new VoluntariadoFragment();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, fragment).commit();
                        return true;
                    }
                });

    }
}
