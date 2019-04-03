package com.example.comandaplus.Realm;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;
public class Crudetallepedido {

    private final static int calculateIndex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Detallepedidorealm.class).max("id");
        int nextId;
        if(currentIdNum == null){
            nextId = 0;
        }else {
            nextId = currentIdNum.intValue()+1;
        }
        return nextId;
    }

public final static void  Disminuirdetalle (final Detallepedidorealm Detallepedidorealm){
        Realm y=Realm.getDefaultInstance();
        Detallepedidorealm miobjeto=y.where(Detallepedidorealm.class).equalTo("idproductorealm", Detallepedidorealm.getIdproductorealm()).findFirst();
        if  (y!=null){

            int anterior =miobjeto.getCantidadrealm();
            if (anterior==0) {
            }else{

                y.beginTransaction();
                miobjeto.setCantidadrealm(anterior-1);
                   miobjeto.setSubtotal(miobjeto.getSubtotal()-miobjeto.getPrecventarealm());
                y.insertOrUpdate(miobjeto);
                y.commitTransaction();
            }


        }else{

            Log.d("dato","no hay mas a disminuir ");
        }



}

    public final static void addDetallepedidorealm(final Detallepedidorealm Detallepedidorealm){
        Realm realm = Realm.getDefaultInstance();
        Detallepedidorealm aversiescierto = realm.where(Detallepedidorealm.class).equalTo("idproductorealm", Detallepedidorealm.getIdproductorealm()).findFirst();
        if(aversiescierto != null){
            realm.beginTransaction();
            int anterior =aversiescierto.getCantidadrealm();
            aversiescierto.setCantidadrealm(anterior+1);
            aversiescierto.setSubtotal(Detallepedidorealm.getCantidadrealm()*Detallepedidorealm.getPrecventarealm());
            realm.insertOrUpdate(aversiescierto);
            realm.commitTransaction();
            Log.d("TAG", "cantidaantifus: " + aversiescierto.getCantidadrealm() + " subtotal: " + aversiescierto.getSubtotal() + " caidadnurva: " + Detallepedidorealm.getCantidadrealm()+"    idproducto   "+Detallepedidorealm.getIdproductorealm());
        }
else{


            realm.executeTransaction(new Realm.Transaction(){
                @Override
                public void execute(Realm realm){
                    int index = Crudetallepedido.calculateIndex();
                    Detallepedidorealm realmDetallepedidorealm = realm.createObject(Detallepedidorealm.class, index);
                    realmDetallepedidorealm.setIdproductorealm(Detallepedidorealm.getIdproductorealm());
                    realmDetallepedidorealm.setCantidadrealm(Detallepedidorealm.getCantidadrealm());
                    realmDetallepedidorealm.setNombreproductorealm(Detallepedidorealm.getNombreproductorealm());
                    realmDetallepedidorealm.setPrecventarealm(Detallepedidorealm.getPrecventarealm());
                    realmDetallepedidorealm.setIdpedido(Detallepedidorealm.getIdpedido());
                    realmDetallepedidorealm.setSubtotal(Detallepedidorealm.getSubtotal());
                }
            });
            Log.d("TAG","se creara por primera vez el detalle" );

        }
getAllDetallepedidorealm();

    }
    public final static List<Detallepedidorealm> getAllDetallepedidorealm(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Detallepedidorealm> Detallepedidorealms = realm.where(Detallepedidorealm.class).findAll();
        for(Detallepedidorealm Detallepedidorealm: Detallepedidorealms){
            Log.d("TAG", "id: " + Detallepedidorealm.getId() + " Nombre: " + Detallepedidorealm.getNombreproductorealm() + " precio: " + Detallepedidorealm.getPrecventarealm());

            for(int i = 0; i <Detallepedidorealm.getProductoRealms().size(); i++){
                Log.d("TAG", "id: " + Detallepedidorealm.getProductoRealms().get(i).getNombreproducto());
            }
        }
        return Detallepedidorealms;
    }
    public final static Detallepedidorealm getDetallepedidorealmByName(String name){
        Realm realm = Realm.getDefaultInstance();
        Detallepedidorealm Detallepedidorealm = realm.where(Detallepedidorealm.class).equalTo("nombreproductorealm", name).findFirst();
        if(Detallepedidorealm != null){
            Log.d("TAG", "ida: " + Detallepedidorealm.getId() + " Nombre: " + Detallepedidorealm.getNombreproductorealm() + " precio: " + Detallepedidorealm.getPrecventarealm());
        }
        return Detallepedidorealm;
    }
    public final static Detallepedidorealm getDetallepedidorealmById(int id){
        Realm realm = Realm.getDefaultInstance();
        Detallepedidorealm Detallepedidorealm = realm.where(Detallepedidorealm.class).equalTo("id", id).findFirst();
        if(Detallepedidorealm != null){
            Log.d("TAG", "ido: " + Detallepedidorealm.getId() + " Nombre: " + Detallepedidorealm.getNombreproductorealm() + " Email: " + Detallepedidorealm.getCantidadrealm());
        }
        return Detallepedidorealm;
    }
    public final static void updateDetallepedidorealmById(int id,
             int cantidadrealm,
             Double precventarealm,
             String nombreproductorealm,
             String imagenrealm,
             int idalmacenrealm){

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Detallepedidorealm Detallepedidorealm = realm.where(Detallepedidorealm.class).equalTo("id", id).findFirst();
        Detallepedidorealm.setCantidadrealm(cantidadrealm);
        Detallepedidorealm.setPrecventarealm(precventarealm);
        Detallepedidorealm.setNombreproductorealm(nombreproductorealm);
        Detallepedidorealm.setImagenrealm(imagenrealm);
        Detallepedidorealm.setIdalmacenrealm(idalmacenrealm);




        realm.insertOrUpdate(Detallepedidorealm);
        realm.commitTransaction();
        if(Detallepedidorealm != null){
            Log.d("TAG", "id: " + Detallepedidorealm.getId() + " Nombre: " + Detallepedidorealm.getNombreproductorealm() + " xcantidad: " + Detallepedidorealm.getCantidadrealm());
        }
    }

    public final static void deleteDetallepedidorealmById(int id){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Detallepedidorealm Detallepedidorealm = realm.where(Detallepedidorealm.class).equalTo("id", id).findFirst();
        Detallepedidorealm.deleteFromRealm();
        realm.commitTransaction();
    }

    public final static void deleteAllDetallepedidorealm(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.delete(Detallepedidorealm.class);
        //realm.deleteAll();
        realm.commitTransaction();

        //realm.deleteAll();
        //realm.commitTransaction();
    }



}
