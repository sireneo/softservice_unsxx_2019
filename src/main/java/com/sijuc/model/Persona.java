package com.sijuc.model;

import java.io.Serializable;

public class Persona implements Serializable{
    private int idPe;
    private String nombPe;
    private String apellPe;
    private String ciPe;
    private String feNacPe;
    private int edadPe;
    private String luNacPe;
    ///por relacion de tablas y clases 
    private Tprovision provis = new Tprovision();

    public Tprovision getProvis() {
        return provis;
    }

    public void setProvis(Tprovision provis) {
        this.provis = provis;
    }
    
    @Override
    public String toString() {
        return String.format("%s[idPe=%d]", getClass().getSimpleName(), getIdPe());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idPe;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (this.idPe != other.idPe) {
            return false;
        }
        return true;
    }
    

    public int getIdPe() {
        return idPe;
    }

    public void setIdPe(int idPe) {
        this.idPe = idPe;
    }

    public String getNombPe() {
        return nombPe;
    }

    public void setNombPe(String nombPe) {
        this.nombPe = nombPe;
    }

    public String getApellPe() {
        return apellPe;
    }

    public void setApellPe(String apellPe) {
        this.apellPe = apellPe;
    }

    public String getCiPe() {
        return ciPe;
    }

    public void setCiPe(String ciPe) {
        this.ciPe = ciPe;
    }

    public String getFeNacPe() {
        return feNacPe;
    }

    public void setFeNacPe(String feNacPe) {
        this.feNacPe = feNacPe;
    }

    public int getEdadPe() {
        return edadPe;
    }

    public void setEdadPe(int edadPe) {
        this.edadPe = edadPe;
    }

    public String getLuNacPe() {
        return luNacPe;
    }

    public void setLuNacPe(String luNacPe) {
        this.luNacPe = luNacPe;
    }
    
    
}
