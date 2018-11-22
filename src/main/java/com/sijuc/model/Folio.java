package com.sijuc.model;

import java.io.Serializable;

public class Folio implements Serializable{
  private int idTi;
  private int nroFolio;
  private int nroLibro;
  private int nroExpe;
  private String fechaExpe;
  private Persona idProv;

    public int getIdTi() {
        return idTi;
    }

    public void setIdTi(int idTi) {
        this.idTi = idTi;
    }

    public int getNroFolio() {
        return nroFolio;
    }

    public void setNroFolio(int nroFolio) {
        this.nroFolio = nroFolio;
    }

    public int getNroLibro() {
        return nroLibro;
    }

    public void setNroLibro(int nroLibro) {
        this.nroLibro = nroLibro;
    }

    public int getNroExpe() {
        return nroExpe;
    }

    public void setNroExpe(int nroExpe) {
        this.nroExpe = nroExpe;
    }

    public String getFechaExpe() {
        return fechaExpe;
    }

    public void setFechaExpe(String fechaExpe) {
        this.fechaExpe = fechaExpe;
    }

    public Persona getIdProv() {
        return idProv;
    }

    public void setIdProv(Persona idProv) {
        this.idProv = idProv;
    }
  
}
