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
import com.example.anitamarin.adogtame.DetallePagoActivity;
import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.adapters.CatalogoAdapter;
import com.example.anitamarin.adogtame.adapters.DonacionesAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentDonacionesBinding;
import com.example.anitamarin.adogtame.util.Data;

/**
 * A simple {@link Fragment} subclass.
 */
public class DonacionesFragment extends Fragment implements DonacionesAdapter.onFundacionesListener {

    FragmentDonacionesBinding binding;
    DonacionesAdapter adapter;

    public static DonacionesFragment instance() {
        return new DonacionesFragment();
    }

    public DonacionesFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_donaciones, container, false);
        adapter = new DonacionesAdapter(getLayoutInflater(null), Data.getFundaciones(), this);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    @Override
    public void onFundacionClick(int position) {
        Intent intent = new Intent(getActivity(), DetallePagoActivity.class);
        intent.putExtra("pos", position);
        startActivity(intent);
    }
}
