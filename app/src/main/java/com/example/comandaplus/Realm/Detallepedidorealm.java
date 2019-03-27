package com.example.comandaplus.Realm;

import com.example.comandaplus.modelo.Detallepedido;

import io.realm.RealmList;
import io.realm.annotations.PrimaryKey;
import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Detallepedidorealm extends RealmObject{
      @PrimaryKey
    public int id;

    private int idpedido;
    private int cantidadrealm;
    private Double precventarealm;
    private String nombreproductorealm;
    private String imagenrealm;
    private int idalmacenrealm;
    private int idproductorealm;
    private RealmList<ProductoRealm> productoRealms;
    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    private Double subtotal;
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }





    public RealmList<ProductoRealm> getProductoRealms() {
        return productoRealms;
    }

    public void setProductoRealms(RealmList<ProductoRealm> productoRealms) {
        this.productoRealms = productoRealms;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public int getIdproductorealm() {
        return idproductorealm;
    }

    public void setIdproductorealm(int idproductorealm) {
        this.idproductorealm = idproductorealm;
    }

    public int getCantidadrealm() {
        return cantidadrealm;
    }

    public void setCantidadrealm(int cantidadrealm) {
        this.cantidadrealm = cantidadrealm;
    }

    public Double getPrecventarealm() {
        return precventarealm;
    }

    public void setPrecventarealm(Double precventarealm) {
        this.precventarealm = precventarealm;
    }

    public String getNombreproductorealm() {
        return nombreproductorealm;
    }

    public void setNombreproductorealm(String nombreproductorealm) {
        this.nombreproductorealm = nombreproductorealm;
    }

    public String getImagenrealm() {
        return imagenrealm;
    }

    public void setImagenrealm(String imagenrealm) {
        this.imagenrealm = imagenrealm;
    }

    public int getIdalmacenrealm() {
        return idalmacenrealm;
    }

    public void setIdalmacenrealm(int idalmacenrealm) {
        this.idalmacenrealm = idalmacenrealm;
    }





}
