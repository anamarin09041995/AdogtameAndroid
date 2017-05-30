package com.example.anitamarin.adogtame.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.databinding.TemplateSeguimientoBinding;
import com.example.anitamarin.adogtame.models.Mascotas;

import java.util.List;

/**
 * Created by Anita Marin on 27/05/2017.
 */

public class SeguimientoAdapter extends RecyclerView.Adapter<SeguimientoAdapter.SeguimientoHolder>{

    List<Mascotas> data;
    LayoutInflater inflater;

    public SeguimientoAdapter(List<Mascotas> data, LayoutInflater inflater) {
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public SeguimientoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_seguimiento, parent, false);
        return new SeguimientoHolder(v);
    }

    @Override
    public void onBindViewHolder(SeguimientoHolder holder, int position) {
        holder.binding.setMascota(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //region ViewHolders
    static class SeguimientoHolder extends RecyclerView.ViewHolder{

        TemplateSeguimientoBinding binding;

        public SeguimientoHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion
}
