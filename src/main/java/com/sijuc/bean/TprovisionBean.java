package com.sijuc.bean;

import com.sijuc.dao.PersonaDAO;
import com.sijuc.dao.TprovisionDAO;
import com.sijuc.model.Folio;
import com.sijuc.model.Persona;
import com.sijuc.model.Tprovision;
import com.sijuc.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean 
@ViewScoped
public class TprovisionBean implements Serializable{
   
    private Persona persona = new Persona();
    private Usuario usuario = new Usuario();
    private Tprovision provision = new Tprovision();
    private Folio folio = new Folio();
    
    private  List<Persona> lstpersona;
    private List<Tprovision> lstprovision;

    public List<Tprovision> getLstprovision() {
        return lstprovision;
    }

    public void setLstprovision(List<Tprovision> lstprovision) {
        this.lstprovision = lstprovision;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tprovision getProvision() {
        return provision;
    }

    public void setProvision(Tprovision provision) {
        this.provision = provision;
    }

    public Folio getFolio() {
        return folio;
    }

    public void setFolio(Folio folio) {
        this.folio = folio;
    }
   
    //mejora la presentacion de navegacion de los botones
    private String accion;
    
    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.limpiar();//limpia los campos de texto
        this.accion = accion;
    }
    
    public List<Persona> getLstpersona() {
        return lstpersona;
    }

    public void setLstpersona(List<Persona> lstpersona) {
        this.lstpersona = lstpersona;
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    //metodo para controlar los botones de registrar y modefiicar
    public void operar() throws Exception{
        switch (accion){
            case "Registrar":
                this.regprovision();
                this.limpiar();
            break;
            case "Modificar":
                //this.modificar();
                this.limpiar();
            break;
        }
    }
    
    //metodo para limpiar los campos
    public void limpiar(){
        this.persona.setIdPe(0);
        this.persona.setNombPe("");
        this.persona.setApellPe("");
        this.persona.setCiPe("");
        this.persona.setFeNacPe("");
        this.persona.setEdadPe(0);
        this.persona.setLuNacPe("");
        this.persona.setUnivPe("");
        
        this.provision.setIdProv(0);
        this.provision.setFechaProv("");
        this.provision.setNroProv(0);
        this.provision.setIdPe(persona);
        
        this.folio.setIdTi(0);
        this.folio.setNroFolio(0);
        this.folio.setNroLibro(0);
        this.folio.setNroExpe(0);
        this.folio.setFechaExpe("");
        this.folio.setIdProv(provision);
    }
    
    //registrando datos al persona provison y folio
    private void regprovision() throws Exception{
        TprovisionDAO dao;
        try {
            dao = new TprovisionDAO();
            dao.registrar(persona, provision, folio);
            
        } catch (Exception e) {
            throw e;
        }
    }
}
