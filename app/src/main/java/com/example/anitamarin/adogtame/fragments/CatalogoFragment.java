package com.example.anitamarin.adogtame.fragments;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.DetalleCatalogoActivity;
import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.adapters.CatalogoAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentCatalogoBinding;
import com.example.anitamarin.adogtame.util.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogoFragment extends Fragment implements CatalogoAdapter.onMascotasListener {

    FragmentCatalogoBinding binding;
    CatalogoAdapter adapter;

    public static CatalogoFragment newInstance() {
        return new CatalogoFragment();
    }

    public CatalogoFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_catalogo, container, false);
        adapter = new CatalogoAdapter(getLayoutInflater(null), Data.getMascotas(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onMascotasClick(int position) {
        Intent intent = new Intent(getActivity(), DetalleCatalogoActivity.class);
        startActivity(intent);
    }

}
