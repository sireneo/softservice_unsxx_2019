package com.sijuc.dao;

import com.sijuc.model.Folio;
import com.sijuc.model.Persona;
import com.sijuc.model.Tprovision;
import com.sijuc.model.Usuario;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import org.primefaces.context.RequestContext;

public class TprovisionDAO extends DAO{
        
    public void registrar(Persona per, Tprovision prov, Folio fol) throws Exception{
        Connection cn = DAO.getConnection();

        try {
            
            cn.setAutoCommit(false);
            
            PreparedStatement st;
            st = cn.prepareStatement("INSERT INTO Persona (nombPe,apellPe,ciPe,feNacPe,edadPe,luNacPe,univPe) VALUES (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1, per.getNombPe());
            st.setString(2, per.getApellPe());
            st.setString(3, per.getCiPe());
            st.setString(4, per.getFeNacPe());
            st.setInt(5, per.getEdadPe());
            st.setString(6, per.getLuNacPe());
            st.setString(7, per.getUnivPe());
           st.executeUpdate();
                       
            ResultSet generatedKeys = st.getGeneratedKeys();
            int idGene = 0;
            if (generatedKeys.next()) { 
                 idGene = generatedKeys.getInt(1);
                System.out.println("Clave generada = " + idGene);
            }
             st.close();
          
            PreparedStatement st2;
            st2 = cn.prepareStatement("INSERT INTO Tprovision (nombProv, fechaProv, nroProv, tipoDoc, idPe) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st2.setString(1, prov.getNombProv());
            st2.setString(2, prov.getFechaProv());
            st2.setInt(3, prov.getNroProv());
            st2.setString(4, prov.getTipoDoc());
            st2.setInt(5, idGene);
            st2.executeUpdate();
            
            ResultSet generaKeys = st2.getGeneratedKeys();
            int idFoli = 0;
            if (generaKeys.next()) { 
                 idFoli = generaKeys.getInt(1);
                //System.out.println("Clave generada = " + idFoli);
            }
           PreparedStatement st3 = cn.prepareStatement("INSERT INTO Folio (nroFolio, nroLibro, nroExpe, fechaExpe, idProv) VALUES (?,?,?,?,?)");
            st3.setInt(1, fol.getNroFolio());
            st3.setInt(2, fol.getNroLibro());
            st3.setInt(3, fol.getNroExpe());
            st3.setString(4, fol.getFechaExpe());
            st3.setInt(5, idFoli);
            st3.executeUpdate();
            
            st3.close();
            cn.commit();
           } catch (Exception e) {
            cn.rollback();
            throw e;
            
        }finally{
            this.Cerrar();
        }
    }
} 
