package com.example.anitamarin.adogtame.fragments;



import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.anitamarin.adogtame.App;
import com.example.anitamarin.adogtame.R;

import com.example.anitamarin.adogtame.adapters.VoluntariadoAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentVoluntariadoBinding;
import com.example.anitamarin.adogtame.models.Fundaciones;
import com.example.anitamarin.adogtame.net.FundacionesClient;
import com.example.anitamarin.adogtame.util.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoluntariadoFragment extends Fragment implements VoluntariadoAdapter.onFundacionesListener {

    FragmentVoluntariadoBinding binding;
    VoluntariadoAdapter adapter;
    FundacionesClient client;

    public static VoluntariadoFragment instance() {
        return new VoluntariadoFragment();
    }


    public VoluntariadoFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_voluntariado, container, false);
        adapter = new VoluntariadoAdapter(getLayoutInflater(null), new ArrayList<Fundaciones>(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));

        client = App.retrofit.create(FundacionesClient.class);

        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadFundaciones();
    }

    public void loadFundaciones(){
        Call<List<Fundaciones>> request = client.all();
        request.enqueue(new Callback<List<Fundaciones>>() {
            @Override
            public void onResponse(Call<List<Fundaciones>> call, Response<List<Fundaciones>> response) {
                if(response.isSuccessful()){
                    Data.fundaciones = response.body();
                    adapter.setData(Data.fundaciones);
                }
            }

            @Override
            public void onFailure(Call<List<Fundaciones>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onFundacionClick(int position) {

        Fundaciones fundacion = Data.fundaciones.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // set title
        builder.setTitle(getString(R.string.title_alerta_voluntariado, fundacion.getNombre()));

        // set dialog message
        builder
                .setMessage(getString(R.string.mensaje_alerta_voluntariado, fundacion.getHorario()))
                .setCancelable(false)
                .setPositiveButton(R.string.ok,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = builder.create();
        // show it
        alertDialog.show();
    }
}

