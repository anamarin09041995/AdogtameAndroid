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

    public interface onFundacionesListener{
        void onFundacionClick(int position);
    }

    List<Fundaciones> data;
    LayoutInflater inflater;
    onFundacionesListener listener;

    public VoluntariadoAdapter(LayoutInflater inflater, List<Fundaciones> data, onFundacionesListener listener) {
        this.data = data;
        this.inflater = inflater;
        this.listener = listener;
    }

    @Override
    public VoluntariadoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_voluntariado, parent, false);
        return new VoluntariadoHolder(v);
    }

    @Override
    public void onBindViewHolder(VoluntariadoHolder holder, int position) {
        holder.binding.setFundacion(data.get(position));
        holder.binding.card.setTag(position);
        holder.binding.setHandler(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void onItemClick(int position){
        listener.onFundacionClick(position);
    }

    public void setData(List<Fundaciones> data){
        this.data = data;
        notifyDataSetChanged();
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
