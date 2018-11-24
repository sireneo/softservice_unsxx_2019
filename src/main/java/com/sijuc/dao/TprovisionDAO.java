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

public class TprovisionDAO extends DAO{
        
    public void registrar(Persona per, Tprovision prov, Folio fol) throws Exception{
        Connection cn = DAO.getConnection();

        try {
            
            cn.setAutoCommit(false);
            
            PreparedStatement st;
            st = cn.prepareStatement("INSERT INTO Persona (nombPe,apellPe,ciPe,feNacPe,edadPe,luNacPe) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1, per.getNombPe());
            st.setString(2, per.getApellPe());
            st.setString(3, per.getCiPe());
            st.setString(4, per.getFeNacPe());
            st.setInt(5, per.getEdadPe());
            st.setString(6, per.getLuNacPe());
           st.executeUpdate();
                       
            ResultSet generatedKeys = st.getGeneratedKeys();
            int idGene = 0;
            if (generatedKeys.next()) { 
                 idGene = generatedKeys.getInt(1);
                System.out.println("Clave generada = " + idGene);
            }
             st.close();
          
            PreparedStatement st2;
            st2 = cn.prepareStatement("INSERT INTO Tprovision (nombProv, fechaProv, nroProv, idPe) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st2.setString(1, prov.getNombProv());
            st2.setString(2, prov.getFechaProv());
            st2.setInt(3, prov.getNroProv());
            st2.setInt(4, idGene);
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
    public List<Persona> listar() throws Exception{
        List<Persona> lista;
        ResultSet rs;
         Connection cn = DAO.getConnection();
        try {
           // this.Conectar();
           PreparedStatement stm = cn.prepareStatement("select nombPe, apellPe, ciPe, tp.idProv, tp.nombProv, tp.nroProv, tp.fechaProv from Persona join Tprovision as tp on Persona.idPe=tp.idPe");
           rs = stm.executeQuery();
            lista = new ArrayList();
            
            while(rs.next()){
                Persona prov = new Persona();
               //prov.getPerson().setIdPe(rs.getInt("idPe"));
               // prov.getPerson().setNombPe(rs.getString("nombPe"));
                //prov.getPerson().setApellPe(rs.getString("apellPe"));
               // prov.getPerson().setCiPe(rs.getString("ciPe"));
                prov.getProvis().setIdProv(rs.getInt("idProv"));
                prov.getProvis().setNombProv(rs.getString("nombProv"));
                prov.getProvis().setFechaProv(rs.getString("fechaProv"));
                prov.getProvis().setNroProv(rs.getInt("nroProv"));
               lista.add(prov);
                System.out.print(lista);
            }
            rs.close();
        } catch (Exception e) {
           cn.rollback();
           throw e;
            
        }finally{
            this.Cerrar();
        }
        return lista;
        
    }
    //union de las listas
    
      
    public Persona leerID(Persona per) throws Exception{
        Persona pers = null;
        ResultSet rs;
        Connection cn = DAO.getConnection();
       try {
            //this.Conectar();
            PreparedStatement st = cn.prepareStatement("select * from Persona where idPe = ?");
            st.setInt(1, per.getIdPe());
            rs = st.executeQuery();
            while (rs.next()){
                pers = new Persona();
                pers.setIdPe(rs.getInt("idPe"));
                pers.setNombPe(rs.getString("nombPe"));
                pers.setApellPe(rs.getString("apellPe"));
                pers.setCiPe(rs.getString("ciPe"));
                pers.setFeNacPe(rs.getString("feNacPe"));
                pers.setEdadPe(rs.getInt("edadPe"));
                pers.setLuNacPe(rs.getString("luNacPe"));
                //System.out.println("hola:" + pers.getNombPe());
            }
        } catch (Exception e) {
            throw e;
            
        }finally{
            this.Cerrar();
        }
        return pers;
    }
    public void modificar(Persona per) throws Exception{
           Connection cn = DAO.getConnection();
        try {
           // this.Conectar();
            PreparedStatement st = cn.prepareStatement("UPDATE Persona SET nombPe = ?, apellPe = ?, ciPe = ?, feNacPe = ?,edadPe = ?, luNacPe = ? WHERE idPe = ?");
            st.setString(1, per.getNombPe());
            st.setString(2, per.getApellPe());
            st.setString(3, per.getCiPe());
            st.setString(4, per.getFeNacPe());
            st.setInt(5, per.getEdadPe());
            st.setString(6, per.getLuNacPe());
            st.setInt(7, per.getIdPe());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    public void eliminar(Persona per) throws Exception{
         Connection cn = DAO.getConnection();
       try {
            //this.Conectar();
            PreparedStatement st = cn.prepareStatement("DELETE FROM Persona WHERE idPe = ?");
            st.setInt(1, per.getIdPe());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
            
} 
