package com.sijuc.model;
public class Usuario {
    private int idUser;
    private String nombUser;
    private String passUser;
    private String tipoUser;
    private Persona idPe;
    private Persona persona;

    @Override
    public String toString() {
        return String.format("%s[idUser=%d]", getClass().getSimpleName(), getIdUser());
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idUser;
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
        final Usuario other = (Usuario) obj;
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    
    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombUser() {
        return nombUser;
    }

    public void setNombUser(String nombUser) {
        this.nombUser = nombUser;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public Persona getIdPe() {
        return idPe;
    }

    public void setIdPe(Persona idPe) {
        this.idPe = idPe;
    }
}
