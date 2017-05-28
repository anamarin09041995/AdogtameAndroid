package com.example.anitamarin.adogtame.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.databinding.TemplateDonacionesBinding;
import com.example.anitamarin.adogtame.models.Fundaciones;

import java.util.List;

/**
 * Created by Anita Marin on 27/05/2017.
 */

public class DonacionesAdapter extends RecyclerView.Adapter<DonacionesAdapter.DonacionesHolder> {

    LayoutInflater inflater;
    List<Fundaciones> data;

    public DonacionesAdapter(LayoutInflater inflater, List<Fundaciones> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public DonacionesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_donaciones, parent, false);
        return new DonacionesHolder(v);
    }

    @Override
    public void onBindViewHolder(DonacionesHolder holder, int position) {
        holder.binding.setFundacion(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //region ViewHolders
    static class DonacionesHolder extends RecyclerView.ViewHolder{

        TemplateDonacionesBinding binding;

        public DonacionesHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion


}
