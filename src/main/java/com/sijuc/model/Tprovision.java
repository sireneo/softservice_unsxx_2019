package com.sijuc.model;

import java.io.Serializable;

public class Tprovision implements Serializable{
    private int idProv;
    private String nombProv;
    private String fechaProv;
    private int nroProv;
    private Persona idPe;
    //private Folio folio;
    private Persona person;
    
    public Persona getPerson() {
        return person;
    }

    public void setPerson(Persona person) {
        this.person = person;
    }
        
   /* public Folio getFolio() {
        return folio;
    }

    public void setFolio(Folio folio) {
        this.folio = folio;
    }
    */
    
    @Override
    public String toString() {
        return "Tprovision{" + "idProv=" + idProv + '}';
    }
       

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
