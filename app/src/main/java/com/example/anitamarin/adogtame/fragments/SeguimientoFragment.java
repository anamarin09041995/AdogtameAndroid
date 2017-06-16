package com.example.anitamarin.adogtame.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.App;
import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.adapters.SeguimientoAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentSeguimientoBinding;
import com.example.anitamarin.adogtame.models.Mascotas;
import com.example.anitamarin.adogtame.models.MascotasDao;
import com.example.anitamarin.adogtame.models.Users;
import com.example.anitamarin.adogtame.net.SeguimientoClient;
import com.example.anitamarin.adogtame.util.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeguimientoFragment extends Fragment implements SeguimientoAdapter.onMascotasListener {

    SeguimientoAdapter adapter;
    FragmentSeguimientoBinding binding;
    MascotasDao dao;
    SeguimientoClient client;

    public static SeguimientoFragment instance() {
        return new SeguimientoFragment();
    }


    public SeguimientoFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_seguimiento, container, false);
        adapter = new SeguimientoAdapter(getLayoutInflater(null), Data.mascotas, this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        //dao = App.session.getMascotasDao();


        client = App.retrofit.create(SeguimientoClient.class);


        return binding.getRoot();

    }

    @Override
    public void onResume() {
        super.onResume();
        loadSeguimiento();
    }

    public void loadSeguimiento(){


    }

    /*@Override
    public void onResume() {
        super.onResume();
        List<Mascotas> data = dao.loadAll();
        adapter.setData(data);
    }*/

    @Override
    public void onMascotasClick(int position) {

    }
}
