package com.sijuc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    public void Conectar () throws Exception{
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/modeldb", "root", "jehova");
            
        } catch (Exception e) {
            System.out.println("Error -->"+ e.getMessage());
            throw e;

        }   
    }
    public void Cerrar() throws Exception{
        try {
            if (cn != null){
                if (cn.isClosed() == false){
                    cn.close();
                }
            }
                
        } catch (SQLException e) {
            throw e;
        }
    }
}
