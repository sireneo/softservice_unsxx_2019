package com.sijuc.model;

import java.io.Serializable;

public class Tacademico implements Serializable{
    private int idTac;
    private String nombTac;
    private String fechaTac;
    private int nroTacCara;
    private int nroTacAtras;
    private Persona idPe;

    public int getIdTac() {
        return idTac;
    }

    public void setIdTac(int idTac) {
        this.idTac = idTac;
    }

    public String getNombTac() {
        return nombTac;
    }

    public void setNombTac(String nombTac) {
        this.nombTac = nombTac;
    }

    public String getFechaTac() {
        return fechaTac;
    }

    public void setFechaTac(String fechaTac) {
        this.fechaTac = fechaTac;
    }

    public int getNroTacCara() {
        return nroTacCara;
    }

    public void setNroTacCara(int nroTacCara) {
        this.nroTacCara = nroTacCara;
    }

    public int getNroTacAtras() {
        return nroTacAtras;
    }

    public void setNroTacAtras(int nroTacAtras) {
        this.nroTacAtras = nroTacAtras;
    }

    public Persona getIdPe() {
        return idPe;
    }

    public void setIdPe(Persona idPe) {
        this.idPe = idPe;
    }
    
}
