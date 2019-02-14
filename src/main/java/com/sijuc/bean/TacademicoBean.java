package com.sijuc.bean;

import com.sijuc.dao.PersonaDAO;
import com.sijuc.dao.TacademicoDAO;
import com.sijuc.model.Folio;
import com.sijuc.model.Persona;
import com.sijuc.model.Tacademico;
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
public class TacademicoBean implements Serializable{
    //private static final long serialVersionUID = 8799656478674716638L;

    private Persona persona = new Persona();
    private Usuario usuario = new Usuario();
    private Tacademico academico = new Tacademico();
    private Folio folio = new Folio();

    public Tacademico getAcademico() {
        return academico;
    }

    public void setAcademico(Tacademico academico) {
        this.academico = academico;
    }
    
    private  List<Persona> lstpersona;
    private List<Persona> leerID;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    
    public List<Persona> getLeerID() {
        return leerID;
    }

    public void setLeerID(List<Persona> leerID) {
        this.leerID = leerID;
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
                this.regacademico();
                this.limpiar();
            break;
            case "Modificar":
                this.modificar();
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
        
        this.academico.setIdTac(0);
        this.academico.setNombTac("");
        this.academico.setFechaTac("");
        this.academico.setNroTacCara(0);
        this.academico.setNroTacAtras(0);
        this.academico.setIdPe(persona);
       
    }
    
    //registrando datos al persona provison y folio
    private void regacademico() throws Exception{
        TacademicoDAO dao;
        try {
            dao = new TacademicoDAO();
            dao.registrar(persona, academico);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    private void modificar() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.modificar(persona);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void listar() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            lstpersona = dao.listar();
          } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerID(Persona per) throws Exception{
        PersonaDAO dao;
        Persona temp;
        try {
            dao = new PersonaDAO();
            temp = dao.leerID(per);
            if (temp != null){
                this.persona =  temp;
                this.accion = "Modificar";
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(Persona per) throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.eliminar(per);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
}
