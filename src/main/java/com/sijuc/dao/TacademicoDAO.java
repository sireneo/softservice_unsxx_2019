package com.sijuc.dao;

import com.sijuc.model.Folio;
import com.sijuc.model.Persona;
import com.sijuc.model.Tacademico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TacademicoDAO extends DAO{
        
    public void registrar(Persona per, Tacademico academ) throws Exception{
        Connection cn = DAO.getConnection();

        try {
            //this.Conectar();
            cn.setAutoCommit(false);
            
            PreparedStatement st;
            st = this.getCn().prepareStatement("INSERT INTO Persona (nombPe,apellPe,ciPe,feNacPe,edadPe,luNacPe) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1, per.getNombPe());
            st.setString(2, per.getApellPe());
            st.setString(3, per.getCiPe());
            st.setString(4, per.getFeNacPe());
            st.setInt(5, per.getEdadPe());
            st.setString(6, per.getLuNacPe());
           st.executeUpdate();

            ResultSet generatedKeys = st.getGeneratedKeys();
            int idGenPe = 0;
            if (generatedKeys.next()) { 
                idGenPe = generatedKeys.getInt(1);
                System.out.println("Clave generada = " + idGenPe);
            }
             st.close();
                       
            PreparedStatement st2;
            st2 = this.getCn().prepareStatement("INSERT INTO Tacademico (nombTac, fechaTac, nroTacCara, nroTacAtras, idPe) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st2.setString(1, academ.getNombTac());
            st2.setString(2, academ.getFechaTac());
            st2.setInt(3, academ.getNroTacCara());
            st2.setInt(4, academ.getNroTacAtras());
            st2.setInt(5, idGenPe);
            st2.executeUpdate();
            
            st2.close();
            
            /**
            ResultSet generaKeys = st2.getGeneratedKeys();
            int idFoli = 0;
            if (generaKeys.next()) { 
                 idFoli = generaKeys.getInt(1);
                System.out.println("Clave generada = " + idFoli);
            }
            /**
            ResultSet rs1 =  st2.getGeneratedKeys();
            long idFolio;
            while (rs1.next()) {
               idFolio = rs.getLong(1);
                System.out.println("Clave generada = " + idFolio);
            }
           // rs1.close();
            st2.close();
            
           PreparedStatement st3 = this.getCn().prepareStatement("INSERT INTO Folio (nroFolio, nroLibro, nroExpe, fechaExpe, idProv) VALUES (?,?,?,?,?)");
            st3.setInt(1, fol.getNroFolio());
            st3.setInt(2, fol.getNroLibro());
            st3.setInt(3, fol.getNroExpe());
            st3.setString(4, fol.getFechaExpe());
            st3.setInt(5, idFoli);
            st3.executeUpdate();
            
            st3.close();
            **/          
            this.getCn().commit();
            
        } catch (Exception e) {
            this.getCn().rollback();
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
            //this.Conectar();
           PreparedStatement stm = cn.prepareStatement("select * from Persona");
           rs = stm.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Persona per = new Persona();
                per.setIdPe(rs.getInt("idPe"));
                per.setNombPe(rs.getString("nombPe"));
                per.setApellPe(rs.getString("apellPe"));
                per.setCiPe(rs.getString("ciPe"));
                per.setEdadPe(rs.getInt("edadPe"));
                per.setFeNacPe(rs.getString("feNacPe"));
                per.setLuNacPe(rs.getString("luNacPe"));
                             
                lista.add(per);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
        return lista;
    }
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
            //this.Conectar();
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
