package com.example.anitamarin.adogtame.adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anitamarin.adogtame.R;
import com.example.anitamarin.adogtame.databinding.TemplateVoluntariadoBinding;
import com.example.anitamarin.adogtame.models.Fundaciones;

import java.util.List;

/**
 * Created by Anita Marin on 27/05/2017.
 */

public class VoluntariadoAdapter extends RecyclerView.Adapter<VoluntariadoAdapter.VoluntariadoHolder>{

    List<Fundaciones> data;
    LayoutInflater inflater;

    public VoluntariadoAdapter(List<Fundaciones> data, LayoutInflater inflater) {
        this.data = data;
        this.inflater = inflater;
    }

    @Override
    public VoluntariadoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_voluntariado, parent, false);
        return new VoluntariadoHolder(v);
    }

    @Override
    public void onBindViewHolder(VoluntariadoHolder holder, int position) {
        holder.binding.setFundacion(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //region ViewHolders
    static class VoluntariadoHolder extends RecyclerView.ViewHolder{

        TemplateVoluntariadoBinding binding;

        public VoluntariadoHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
    //endregion
}
