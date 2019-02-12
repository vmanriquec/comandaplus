package com.example.comandaplus.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.comandaplus.R;
import com.example.comandaplus.modelo.Dashboardpedido;


import java.util.List;

public class Adaptadordashboard extends RecyclerView.Adapter<Adaptadordashboard.AdaptadorViewHolder> {
    private Context mainContext;
    String foto;
    SharedPreferences prefs;
    String FileName ="myfile";
    private List<Dashboardpedido> items;


    public Adaptadordashboard(List<Dashboardpedido> items, Context contexto){
        this.mainContext=contexto;
        this.items=items;
          }
    static class AdaptadorViewHolder extends RecyclerView.ViewHolder{
        protected TextView totalpedido;
        protected TextView totalentradas;
        protected TextView totalsalidas;
        protected TextView nombrealmacen;
        protected TextView totalneto;


        public AdaptadorViewHolder(View v){
            super(v);
            this.totalentradas=(TextView) v.findViewById(R.id.totalentradas);
            this.totalsalidas=(TextView) v.findViewById(R.id.totalsalidas);
            this.totalpedido=(TextView) v.findViewById(R.id.totalpedidos);
            this.totalneto=(TextView) v.findViewById(R.id.totalneto);
            this.nombrealmacen=(TextView) v.findViewById(R.id.txtcardalmacen);

        }
    }
    @Override
    public Adaptadordashboard.AdaptadorViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tarjetaalmacenes,viewGroup,false);
        return new Adaptadordashboard.AdaptadorViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final Adaptadordashboard.AdaptadorViewHolder viewHolder, final int position) {
        final Dashboardpedido item = items.get(position);

        viewHolder.totalentradas.setText(String.valueOf(item.getTotalentradas()));
        viewHolder.totalpedido.setText(String.valueOf(item.gettotalpedidos()));
        viewHolder.totalsalidas.setText(String.valueOf(item.getTotalsalidas()));
        viewHolder.totalneto.setText(String.valueOf((item.getTotalentradas()+(item.gettotalpedidos())-item.getTotalsalidas())));
        viewHolder.nombrealmacen.setText(item.getNombrealm());


    }




    @Override
    public int getItemCount() {
        return items.size();
    }
}
