package com.example.stockify.entidades;

public class Producto {

    private int idProd;
    private String codigo;
    private String standNuevo;
    private String descr;



    public int getIdProd() {return idProd; }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getStandNuevo() {
        return standNuevo;
    }

    public void setStandNuevo(String standNuevo) {
        this.standNuevo = standNuevo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
