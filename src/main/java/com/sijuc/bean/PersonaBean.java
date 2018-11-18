package com.sijuc.bean;

import com.sijuc.dao.PersonaDAO;
import com.sijuc.model.Persona;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean 
@SessionScoped
public class PersonaBean implements Serializable{
//     private static final long serialVersionUID = 8799656478674716638L;

    private Persona persona = new Persona();
    private  List<Persona> lstpersona;
    private List<Persona> leerID;
    

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
    public void registrar() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.registrar(persona);
          // FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informe", "Datos Registrados.");
           //PrimeFaces.current().dialog().showMessageDynamic(message);
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
    
  /** public void listar(){
        Persona ps = new Persona();
        ps.setNombPe("santos");
        ps.setApellPe("juchasara");
        ps.setCiPe("445566 PO");
        ps.setFeNacPe("12/12/1998");
        ps.setEdadPe(2);
        ps.setLuNacPe("llallagua");
        lstpersona.add(ps);
     
     * @param per
     * @throws java.lang.Exception}**/
    public void leerID(Persona per) throws Exception{
        PersonaDAO dao;
        Persona temp;
        try {
            dao = new PersonaDAO();
            temp = dao.leerID(per);
            if (temp != null){
                this.persona =  temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void modificar() throws Exception{
        PersonaDAO dao;
        try {
            dao = new PersonaDAO();
            dao.modificar(persona);
            this.listar();
          // FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informe", "Datos Registrados.");
           //PrimeFaces.current().dialog().showMessageDynamic(message);
        } catch (Exception e) {
            throw e;
        }
    }
}
