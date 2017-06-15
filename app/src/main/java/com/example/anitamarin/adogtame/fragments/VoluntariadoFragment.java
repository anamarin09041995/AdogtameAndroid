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


import com.example.anitamarin.adogtame.R;

import com.example.anitamarin.adogtame.adapters.VoluntariadoAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentVoluntariadoBinding;
import com.example.anitamarin.adogtame.models.Fundaciones;
import com.example.anitamarin.adogtame.util.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoluntariadoFragment extends Fragment implements VoluntariadoAdapter.onFundacionesListener {

    FragmentVoluntariadoBinding binding;
    VoluntariadoAdapter adapter;

    public static VoluntariadoFragment instance() {
        return new VoluntariadoFragment();
    }


    public VoluntariadoFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_voluntariado, container, false);
        adapter = new VoluntariadoAdapter(getLayoutInflater(null), Data.getFundaciones(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onFundacionClick(int position) {

        Fundaciones fundacion = Data.getFundaciones().get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // set title
        builder.setTitle("Fundación " + fundacion.getNombre());

        // set dialog message
        builder
                .setMessage("Gracias por ser parte del cambio. Nuestros horarios son: " + fundacion.getHorario())
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

