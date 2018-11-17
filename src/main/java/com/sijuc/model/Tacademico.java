package com.sijuc.model;

public class Tacademico {
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
