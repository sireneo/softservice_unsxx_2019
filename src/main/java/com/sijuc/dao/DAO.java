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
                Class.forName("org.mariadb.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mariadb://h7xe2knj2qb6kxal.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/xomhmx9n32253lbc","w4ikmq88ekxwwusb", "p5ujwra3wfiss1c4");
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
