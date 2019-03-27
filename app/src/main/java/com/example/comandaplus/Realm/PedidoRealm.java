package com.example.comandaplus.Realm;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PedidoRealm  extends RealmObject {
    @PrimaryKey
    private int idpedido;
    private int idcliente;
    private int idmesa;
    private Double totalpedido;
    private String estadopedido ;
    private String descripcionpedido;
    private Date fechapedido;
    private int idusuario;
    private int idalmacen;
    private String idfacebook ;
    private RealmList<Detallepedidorealm> detallepedidorealms;



    public String getDescripcionpedido() {
        return descripcionpedido;
    }

    public void setDescripcionpedido(String descripcionpedido) {
        this.descripcionpedido = descripcionpedido;
    }


    public RealmList<Detallepedidorealm> getDetallepedidorealms() {
        return detallepedidorealms;
    }

    public void setDetallepedidorealms(RealmList<Detallepedidorealm> detallepedidorealms) {
        this.detallepedidorealms = detallepedidorealms;
    }


    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdmesa() {
        return idmesa;
    }

    public void setIdmesa(int idmesa) {
        this.idmesa = idmesa;
    }

    public Double getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(Double totalpedido) {
        this.totalpedido = totalpedido;
    }

    public String getEstadopedido() {
        return estadopedido;
    }

    public void setEstadopedido(String estadopedido) {
        this.estadopedido = estadopedido;
    }

    public Date getFechapedido() {
        return fechapedido;
    }

    public void setFechapedido(Date fechapedido) {
        this.fechapedido = fechapedido;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public String getIdfacebook() {
        return idfacebook;
    }

    public void setIdfacebook(String idfacebook) {
        this.idfacebook = idfacebook;
    }


}
