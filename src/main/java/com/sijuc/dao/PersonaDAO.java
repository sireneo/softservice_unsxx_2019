package com.sijuc.dao;

import com.sijuc.model.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO extends DAO{
    public void registrar(Persona per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO Persona (nombPe,apellPe,ciPe,feNacPe,edadPe,luNacPe) VALUES (?,?,?,?,?,?)");
            st.setString(1, per.getNombPe());
            st.setString(2, per.getApellPe());
            st.setString(3, per.getCiPe());
            st.setString(4, per.getFeNacPe());
            st.setInt(5, per.getEdadPe());
            st.setString(6, per.getLuNacPe());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    public List<Persona> listar() throws Exception{
        List<Persona> lista;
        ResultSet rs;
        try {
            this.Conectar();
           // PreparedStatement st = this.getCn().prepareCall("SELECT * FROM modeldb.Persona");
           PreparedStatement stm = this.getCn().prepareStatement("select * from Persona");
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
    try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("select * from Persona where idPe = ?");
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
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE Persona SET nombPe = ?, apellPe = ?, ciPe = ?, feNacPe = ?,edadPe = ?, luNacPe = ? WHERE idPe = ?");
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
            
} 
