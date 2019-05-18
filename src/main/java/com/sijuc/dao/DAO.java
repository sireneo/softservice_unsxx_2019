package com.sijuc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private Connection cn;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
      public static Connection getConnection() { 
          try {
                Class.forName("org.mariadb.jdbc.Driver").newInstance();
                //Connection con = DriverManager.getConnection("jdbc:mariadb://h7xe2knj2qb6kxal.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/xomhmx9n32253lbc?user=w4ikmq88ekxwwusb&password=p5ujwra3wfiss1c4");
                Connection con = DriverManager.getConnection("jdbc:mariadb://192.168.1.7:3306/tesisdb?user=maxscale&password=jehova");
                
                System.out.println("conexion exitosa");
                return con;
          } catch (Exception ex) {
                 System.out.println("Database.getConnection() Error -->"+ ex.getMessage());
                 return null;
          }
    }  
    /**
    public static Connection getConnection() throws URISyntaxException, SQLException {
        URI jdbUri = new URI(System.getenv("JAWSDB_MARIA_URL"));
        String username = jdbUri.getUserInfo().split(":")[0];
        String password = jdbUri.getUserInfo().split(":")[1];
        String port = String.valueOf(jdbUri.getPort());
        String jdbUrl = "jdbc:mysql://" + jdbUri.getHost() + ":" + port + jdbUri.getPath();
        return DriverManager.getConnection(jdbUrl, username, password);
        
    }**/

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }

        } catch (SQLException e) {
            throw e;
        }
    }
}
