package com.example.comandaplus.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
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
import com.example.comandaplus.modelo.Detallepedido;
import com.example.comandaplus.modelo.Productos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;


public class Adaptadormaestraproducto extends RecyclerView.Adapter<Adaptadormaestraproducto.AdaptadorViewHolder> {
    private Context mainContext;
    String foto;
    SharedPreferences prefs;
    String FileName ="myfile";
    private List<Productos> items;
    ArrayList<Detallepedido> detallepedido=new ArrayList<>();
    Detallepedido objdetallepedido;

    public Adaptadormaestraproducto(List<Productos> items, Context contexto){
        this.mainContext=contexto;
        this.items=items;
        prefs = contexto.getApplicationContext().getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String idalmacenactiv = prefs.getString("idalmacenactivo", "");


    }
    static class AdaptadorViewHolder extends RecyclerView.ViewHolder{
        protected TextView productonombre;
        protected TextView idproducto;
        protected TextView productoprecio;
        protected TextView productoingredientes,stockp;
        protected ImageView productoimagen;
        protected TextView cantidadpedida;
        protected CheckBox michek;
        protected LinearLayout masmenos;
        protected Button mas,botonok;
        protected Button menos;

        public AdaptadorViewHolder(View v){
            super(v);
            this.productonombre=(TextView) v.findViewById(R.id.productonombrep);
            this.productoprecio=(TextView) v.findViewById(R.id.productopreciop);
            this.idproducto=(TextView) v.findViewById(R.id.idproductop);
            this.cantidadpedida=(TextView) v.findViewById(R.id.contidadpedida);
            this.productoingredientes=(TextView) v.findViewById(R.id.productoingredientesp);
            this.productoimagen=(ImageView) v.findViewById(R.id.productoimagenp);
            this.stockp=(TextView) v.findViewById(R.id.stockp);

        }
    }
    @Override
    public Adaptadormaestraproducto.AdaptadorViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tarjetamaestraprod,viewGroup,false);
        return new Adaptadormaestraproducto.AdaptadorViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final Adaptadormaestraproducto.AdaptadorViewHolder viewHolder, final int position) {
        final Productos item = items.get(position);
        viewHolder.itemView.setTag(item);
        viewHolder.productonombre.setText(item.getNombreproducto());
        viewHolder.productoingredientes.setText(item.getIngredientes());
        viewHolder.productoprecio.setText("S/. "+ String.valueOf(item.getPrecventa()));
        viewHolder.idproducto.setText(String.valueOf(item.getIdproducto()));
        viewHolder.stockp.setText("Stock: "+ String.valueOf(item.getEstadoproducto()));

        //viewHolder.michek.setVisibility(View.GONE);
        //viewHolder.cantidadpedida.setVisibility(View.GONE);

/*asignar imagen desde url*/
        foto=item.getDescripcion().toString();

        Picasso.with(mainContext.getApplicationContext()) .load(foto).transform(new CropSquareTransformation()).resize(200, 200)
                .into( viewHolder.productoimagen);

        viewHolder.productoimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast ImageToast = new Toast(mainContext.getApplicationContext());
                LinearLayout toastLayout = new LinearLayout(mainContext.getApplicationContext());
                toastLayout.setOrientation(LinearLayout.VERTICAL);

                ImageView image = new ImageView(mainContext.getApplicationContext());
                TextView text = new TextView(mainContext.getApplicationContext());
                foto=item.getDescripcion().toString();

                Picasso.with(mainContext.getApplicationContext()) .load(foto).transform(new CropSquareTransformation())
                        .resize(350, 350)
                        .into( image);
                text.setText(item.getIngredientes());
                text.setTextColor(Color.RED);
                text.setBackgroundColor(Color.WHITE);
                text.setGravity(12);
                toastLayout.addView(image);
                toastLayout.addView(text);
                ImageToast.setView(toastLayout);
                ImageToast.setGravity (Gravity.TOP | Gravity.LEFT, 40, 40);
                ImageToast.setDuration(Toast.LENGTH_LONG);
                ImageToast.show();


                ImageToast.getView().setPadding( 20, 100, 20, 20);



            }
        });



        /*si esta check activo para aumentar cantidad*/



        prefs = mainContext.getApplicationContext().getSharedPreferences(FileName, Context.MODE_PRIVATE);
        String idalmacenactiv = prefs.getString("idalmacenactivo", "");
        int i= Integer.parseInt("1");




    }
    @Override
    public int getItemCount() {
        return items.size();
    }
}

