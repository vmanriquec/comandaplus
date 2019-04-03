/*
 * Copyright (c) 2016 Lung Razvan
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.example.comandaplus;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.comandaplus.Realm.CrudUsuarios;
import com.example.comandaplus.Realm.UsuariosRealm;
import com.example.comandaplus.adapter.Adaptadormaestraproducto;
import com.example.comandaplus.modelo.Productos;
import com.example.comandaplus.modelo.SectionDataModel;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

import static android.content.Context.MODE_PRIVATE;
import static com.facebook.FacebookSdk.getApplicationContext;


public class FragmentD  extends Fragment implements View.OnClickListener, RecyclerView.OnItemTouchListener {
    ArrayList<SectionDataModel> allSampleData;
    // @BindView(view.R.id.totalsoles)
    TextView totalsoles;
    // @BindView(R.id.totalsoles)


    RecyclerView myRecyclerView;
    @BindView(R.id.maestraproductos)
    RecyclerView maestraproductos;
    Unbinder unbinder;
    //@BindView(R.id.maestraproductos)

    private View view;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    ArrayList<Productos> people = new ArrayList<>();
    private String[] strArrData = {"No Suggestions"};


    ArrayList<String> mylist = new ArrayList<String>();
    SharedPreferences prefs;
    String face, FileName = "myfile", nombre, almacenactivosf, claveusuario, idalmacensf, idalmacenactivo, almacenactivo;
    ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layoutmaestrasproduc, container, false);

        prefs = getActivity().getSharedPreferences(FileName, MODE_PRIVATE);
        face = prefs.getString("facebook", "");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(mMessageReceiver,new IntentFilter("custom-message"));
        MultiAutoCompleteTextView myMultiAutoCompleteTextView
                = (MultiAutoCompleteTextView) view.findViewById(
                R.id.multiAutoCompleteTextView);
// Obtener el Recycler PRODUCTOS
        recycler = (RecyclerView) view.findViewById(R.id.maestraproductos);
        totalsoles=(TextView)view.findViewById(R.id.totalsoles);
        int numberOfColumns = 6;
        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);


        new FragmentD.traerproductosporidalmacenidfamilia().execute("1","4");
        ImageView toto = view.findViewById(R.id.imagendefacebook);

        UsuariosRealm u = CrudUsuarios.getUsuariosRealmByidusuario(0);


        String  imgUrl = "https://graph.facebook.com/"+u.getIdfacebook()+"/picture?type=large";
        Log.d("dato","eeeso"+u.getIdfacebook());
        Picasso.with(getApplicationContext()) .load(imgUrl).transform(new CropCircleTransformation()).resize(50, 50)
                .into(toto);

        return view;
    }

    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent
            String ItemNamemas = intent.getStringExtra("mas");
            String ItemNamemenos = intent.getStringExtra("menos");

            Double totalsoles2 = Double.parseDouble(totalsoles.getText().toString());

            if (ItemNamemas != null) {
                Double nuevovalormas = Double.valueOf(ItemNamemas);
                totalsoles.setText(String.valueOf(Double.parseDouble(totalsoles.getText().toString()) + nuevovalormas));
            }
            if (ItemNamemenos != null) {
                Double nuevovalormenos = Double.valueOf(ItemNamemenos);
                if (totalsoles2 - nuevovalormenos > 0) {
                    totalsoles.setText(String.valueOf(Double.parseDouble(totalsoles.getText().toString()) - nuevovalormenos));
                }
            }
        }
    };

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    @Override
    public void onClick(View v) {

    }


    private class traerproductosporidalmacenidfamilia extends AsyncTask<String, String, String> {

        HttpURLConnection conne;
        URL url = null;
        ArrayList<Productos> listaalmaceno = new ArrayList<Productos>();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();


        }

        @Override
        protected String doInBackground(String... params) {

            try {
                url = new URL("http://sodapop.space/sugest/apitraerproductosporfamiliaalmacen.php");
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {
                conne = (HttpURLConnection) url.openConnection();
                conne.setReadTimeout(15000);
                conne.setConnectTimeout(10000);
                conne.setRequestMethod("POST");
                conne.setDoInput(true);
                conne.setDoOutput(true);

                // Append parameters to URL


                Uri.Builder builder = new Uri.Builder()

                        .appendQueryParameter("idalmacen", params[0])
                        .appendQueryParameter("idfamilia", params[1]);

                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conne.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conne.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }
            try {
                int response_code = conne.getResponseCode();
                if (response_code == HttpURLConnection.HTTP_OK) {
                    InputStream input = conne.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);

                    }
                    return (

                            result.toString()


                    );

                } else {
                    return ("Connection error");
                }
            } catch (IOException e) {
                e.printStackTrace();

                return e.toString();
            } finally {
                conne.disconnect();
            }
        }


        @Override
        protected void onPostExecute(String result) {

            people.clear();


            ArrayList<String> dataList = new ArrayList<String>();
            Productos meso;
            if (result.equals("no rows")) {
                Toast.makeText(FragmentD.this.getActivity(), "no existen datos a mostrar", Toast.LENGTH_LONG).show();

            } else {

                try {


                    JSONArray jArray = new JSONArray(result);


                    for (int i = 0; i < jArray.length(); i++) {
                        JSONObject json_data = jArray.optJSONObject(i);

                        meso = new Productos(json_data.getInt("idproducto"), json_data.getString("nombreproducto"), json_data.getString("estadoproducto"), json_data.getString("ingredientes"), json_data.getDouble(("precventa")), json_data.getString("descripcion"));
                        people.add(meso);

                    }
                    strArrData = dataList.toArray(new String[dataList.size()]);


                    adapter = new Adaptadormaestraproducto(people, getActivity().getApplicationContext());
                    recycler.setLayoutManager(new GridLayoutManager(FragmentD.this.getActivity(), 2));

                    recycler.setAdapter(adapter);


                } catch (JSONException e) {

                }

            }

        }

    }


}
