package com.sijuc.bean;

import com.sijuc.dao.PersonaDAO;
import com.sijuc.model.Persona;
import com.sijuc.model.Tprovision;
import com.sijuc.model.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean 
@ViewScoped
public class PersonaBean implements Serializable{

    private Persona persona = new Persona();
    private Usuario usuario = new Usuario();

    private  List<Persona> lstpersona;
    private List<Persona> leerID;
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
                this.registrar();
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
        
        this.usuario.setIdUser(0);
        this.usuario.setNombUser("");
        this.usuario.setPassUser("");
        this.usuario.setTipoUser("");
        this.usuario.setIdPe(persona);
        this.persona.getProvis().getFolio().setNroExpe(0);
        
     
    }
    private void registrar() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.registrar(persona, usuario);
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
    //lista de persona, titulo rpovison, y folio
    public void listarprov() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            lstpersona = dao.listaprov();
          } catch (Exception e) {
            throw e;
        }
    }
    //lista verificacion de titulos
        public void verificar() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.verificartitulo(persona);
            this.limpiar();
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
