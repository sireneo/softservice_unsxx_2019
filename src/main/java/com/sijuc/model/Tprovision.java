package com.sijuc.model;

public class Tprovision {
    private int idProv;
    private String nombProv;
    private String fechaProv;
    private int nroProv;
    private Persona idPe;

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    public String getNombProv() {
        return nombProv;
    }

    public void setNombProv(String nombProv) {
        this.nombProv = nombProv;
    }

    public String getFechaProv() {
        return fechaProv;
    }

    public void setFechaProv(String fechaProv) {
        this.fechaProv = fechaProv;
    }

    public int getNroProv() {
        return nroProv;
    }

    public void setNroProv(int nroProv) {
        this.nroProv = nroProv;
    }

    public Persona getIdPe() {
        return idPe;
    }

    public void setIdPe(Persona idPe) {
        this.idPe = idPe;
    }
    
    
}
