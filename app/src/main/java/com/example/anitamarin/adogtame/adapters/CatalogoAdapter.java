package com.example.anitamarin.adogtame.adapters;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.DetalleCatalogoActivity;
import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.databinding.TemplateCatalogoBinding;
import com.example.anitamarin.adogtame.models.Mascotas;

import java.util.List;

/**
 * Created by Anita Marin on 27/05/2017.
 */

public class CatalogoAdapter extends RecyclerView.Adapter<CatalogoAdapter.CatalogoHolder>{

    LayoutInflater inflater;
    List<Mascotas> data;


    public CatalogoAdapter(LayoutInflater inflater, List<Mascotas> data) {
        this.inflater = inflater;
        this.data = data;
    }

    @Override
    public CatalogoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_catalogo, parent, false);
        return new CatalogoHolder(v);
    }

    @Override
    public void onBindViewHolder(CatalogoHolder holder, int position) {
        holder.binding.setMascota(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //region ViewHolders
    static class CatalogoHolder extends RecyclerView.ViewHolder{

        TemplateCatalogoBinding binding;

        public CatalogoHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion


}
