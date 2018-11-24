package com.sijuc.dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.bytebuddy.asm.Advice;

public class UsuarioDAO extends DAO{
    
     public static boolean validate(String user, String password) throws URISyntaxException, Exception {
        Connection cn = DAO.getConnection();
         PreparedStatement ps = null;
         try {
            ps = cn.prepareStatement("Select nombUser, passUser from Usuario where nombUser = ? and passUser = ?");
            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
            cn.close();
        }
        return false;
                       
    }

    
}
