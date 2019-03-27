package com.example.comandaplus.adapter;



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comandaplus.R;
import com.example.comandaplus.modelo.Productos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.AdaptadorViewHolder> {
    private Context mainContext;
    private ArrayList<Productos> itemsListo;
    private Context mContext;

    String foto;
    public SectionListDataAdapter(Context context, ArrayList<Productos> itemsListo) {
        this.itemsListo = itemsListo;
        this.mContext = context;
    }

    @Override
    public AdaptadorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_single_card, null);
        AdaptadorViewHolder mh = new AdaptadorViewHolder(v);
        return mh;
    }
    //final Adaptadorproductos.AdaptadorViewHolder viewHolder, final int position
    //SingleItemRowHolder holder, int i)
    @Override
    public void onBindViewHolder(AdaptadorViewHolder viewHolder, int ii) {
         Productos iteme = itemsListo.get(ii);



        viewHolder.itemView.setTag(iteme);
        viewHolder.tvTitle.setText(iteme.getNombreproducto());
        viewHolder.productoingredientes.setText(iteme.getIngredientes());
        viewHolder.productoprecio.setText(String.valueOf(iteme.getPrecventa()));
        viewHolder.idproducto.setText(String.valueOf(iteme.getIdproducto()));
        //viewHolder.michek.setVisibility(View.GONE);
        //viewHolder.cantidadpedida.setVisibility(View.GONE);
        viewHolder.masmenos.setVisibility(View.GONE);
        viewHolder.botonok.setVisibility(View.GONE);
        /*asignar imagen desde url*/
        foto=iteme.getDescripcion().toString();

        Picasso.with(mainContext.getApplicationContext()) .load(foto).transform(new CropCircleTransformation()).resize(100, 100)
                .into( viewHolder.itemImage);

    }

    @Override
    public int getItemCount() {
        return (null != itemsListo ? itemsListo.size() : 0);
    }

    public class AdaptadorViewHolder extends RecyclerView.ViewHolder {






        protected TextView tvTitle;
        protected TextView idproducto;
        protected TextView productoprecio;
        protected TextView productoingredientes;
        protected ImageView itemImage;
        protected TextView cantidadpedida;
        protected CheckBox michek;
        protected LinearLayout masmenos;
        protected Button mas,botonok;
        protected Button menos;






        public AdaptadorViewHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            this.itemImage = (ImageView) view.findViewById(R.id.itemImage);
            this.productoprecio=(TextView) view.findViewById(R.id.productoprecios);
            this.idproducto=(TextView) view.findViewById(R.id.idproductos);
            this.cantidadpedida=(TextView) view.findViewById(R.id.cantidadpedidas);
            this.productoingredientes=(TextView) view.findViewById(R.id.productoingredientess);
            this.masmenos=(LinearLayout)view.findViewById(R.id.masmenoss);
            this.mas=(Button)view.findViewById(R.id.plus_buttons);
            this.menos=(Button)view.findViewById(R.id.menos_buttons);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}