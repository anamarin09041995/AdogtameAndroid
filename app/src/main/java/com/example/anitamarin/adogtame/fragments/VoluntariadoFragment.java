package com.example.anitamarin.adogtame.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.adapters.DonacionesAdapter;
import com.example.anitamarin.adogtame.adapters.VoluntariadoAdapter;
import com.example.anitamarin.adogtame.databinding.FragmentVoluntariadoBinding;
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


    public VoluntariadoFragment() {
        // Required empty public constructor
    }


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

    }
}
