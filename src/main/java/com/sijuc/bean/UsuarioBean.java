/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sijuc.bean;

import com.sijuc.dao.UsuarioDAO;
import com.sijuc.model.Usuario;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.net.URISyntaxException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import com.sijuc.bean.SessionUtils;
import com.sijuc.model.Persona;

//@Named(value = "usuarioBean")
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {

    //private Usuario  usuario = new Usuario();
    private String nombUser;
    private String passUser;
    private HttpSession SessionUtils;

    public String getNombUser() {
        return nombUser;
    }

    public void setNombUser(String nombUser) {
        this.nombUser = nombUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }
    public void limpiar(){
        setNombUser(" ");
        setPassUser(" ");
        
    }
    
    public String validarcuenta() throws IOException, URISyntaxException, Exception{
        boolean valid;
        valid = UsuarioDAO.validate(nombUser, passUser);
	if (valid) {
           //HttpSession session = SessionUtils.getSession();
                return "principal.xhtml";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Datos Incorrectos!!",
                            "Por favor vuelva a introducir nuevamente"));
            limpiar();
            return "index.xhmtl?faces-redirect=true";
        }
        
    }
    public void timeout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
        //return "index.xhtml";
    }
}
