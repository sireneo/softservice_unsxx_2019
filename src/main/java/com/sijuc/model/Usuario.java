package com.sijuc.model;
public class Usuario {
    private int idUser;
    private String nombUser;
    private String tipoUser;
    private Persona idPe;

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
