package com.sijuc.dao;

import com.sijuc.model.Folio;
import com.sijuc.model.Persona;
import com.sijuc.model.Tprovision;
import com.sijuc.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.builder.NavigationCaseBuilder;
import org.primefaces.context.RequestContext;

public class PersonaDAO {

    public void registrar(Persona per, Usuario user) throws Exception {
        Connection cn = DAO.getConnection();

        try {

            cn.setAutoCommit(false);
            PreparedStatement st = cn.prepareStatement("INSERT INTO Persona (nombPe,apellPe,ciPe,feNacPe,edadPe,luNacPe,univPe) VALUES (?,?,?,?,?,?,?)");
            st.setString(1, per.getNombPe());
            st.setString(2, per.getApellPe());
            st.setString(3, per.getCiPe());
            st.setString(4, per.getFeNacPe());
            st.setInt(5, per.getEdadPe());
            st.setString(6, per.getLuNacPe());
            st.setString(7, per.getUnivPe());
            st.executeUpdate();
            st.close();

            PreparedStatement st2 = cn.prepareStatement("select LAST_INSERT_ID() FROM Persona limit 1");
            ResultSet rs;
            rs = st2.executeQuery();
            int idUser = 0;
            while (rs.next()) {
                idUser = rs.getInt(1);
            }
            rs.close();

            PreparedStatement st3 = cn.prepareStatement("INSERT INTO Usuario (nombUser,passUser,tipoUser,idPe) VALUES (?,?,?,?)");
            st3.setString(1, user.getNombUser());
            st3.setString(2, user.getPassUser());
            st3.setString(3, user.getTipoUser());
            st3.setInt(4, idUser);
            st3.executeUpdate();
            st3.close();

            cn.commit();
        } catch (Exception e) {
            cn.rollback();
            throw e;

        } finally {
            cn.close();
        }
    }

    public List<Persona> listar() throws Exception {
        List<Persona> lista;
        Connection cn = DAO.getConnection();
        ResultSet rs;
        try {
            //this.Conectar();
            PreparedStatement stm = cn.prepareStatement("select nombPe,apellPe,ciPe,feNacPe,univPe,u.nombUser,u.tipoUser from Persona join Usuario as u on Persona.idPe=u.idPe");
            rs = stm.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {
                Persona per = new Persona();
                per.setNombPe(rs.getString("nombPe"));
                per.setApellPe(rs.getString("apellPe"));
                per.setCiPe(rs.getString("ciPe"));
                per.setFeNacPe(rs.getString("feNacPe"));
                per.setUnivPe(rs.getString("univPe"));
                
                per.getUser().setNombUser(rs.getString("nombUser"));
                per.getUser().setTipoUser(rs.getString("tipoUser"));
                lista.add(per);
                
            }
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
        return lista;
    }

    public Persona leerID(Persona per) throws Exception {
        Persona pers = null;
        ResultSet rs;
        Connection cn = DAO.getConnection();
        try {
            //this.Conectar();
            PreparedStatement st = cn.prepareStatement("select * from Persona where idPe = ?");
            st.setInt(1, per.getIdPe());
            rs = st.executeQuery();
            while (rs.next()) {
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

        } finally {
            cn.close();
        }
        return pers;
    }

    public void modificar(Persona per) throws Exception {
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
        } finally {
            cn.close();
        }
    }

    public void eliminar(Persona per) throws Exception {
        Connection cn = DAO.getConnection();

        try {
            // this.Conectar();
            PreparedStatement st = cn.prepareStatement("DELETE FROM Persona WHERE idPe = ?");
            st.setInt(1, per.getIdPe());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
        }
    }

    public List<Persona> listaprov() throws Exception {
        List<Persona> lista;
        ResultSet rs;
        Connection cn = DAO.getConnection();
        try {
            //this.Conectar();
            PreparedStatement stm = cn.prepareStatement(" select nombPe, apellPe, ciPe, univPe, tp.idProv, tp.nombProv, tp.nroProv, tp.fechaProv, tp.tipoDoc, fo.nroExpe, fo.fechaExpe  from Persona join Tprovision as tp on Persona.idPe=tp.idPe join Folio as fo on tp.idProv=fo.idProv");
            rs = stm.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Persona pe = new Persona();
                pe.setNombPe(rs.getString("nombPe"));
                pe.setApellPe(rs.getString("apellPe"));
                pe.setCiPe(rs.getString("ciPe"));
                pe.setUnivPe(rs.getString("univPe"));

                pe.getProvis().setIdProv(rs.getInt("idProv"));
                pe.getProvis().setNombProv(rs.getString("nombProv"));
                pe.getProvis().setFechaProv(rs.getString("fechaProv"));
                pe.getProvis().setNroProv(rs.getInt("nroProv"));
                pe.getProvis().setTipoDoc(rs.getString("tipoDoc"));

                pe.getProvis().getFolio().setNroExpe(rs.getInt("nroExpe"));
                pe.getProvis().getFolio().setFechaExpe(rs.getString("fechaExpe"));

                lista.add(pe);
                //System.out.print("nombres;" + rs.getString("nombPe"));
                
            }
            rs.close();
        } catch (Exception e) {
            cn.rollback();
            throw e;

        } finally {
            cn.close();
        }
        return lista;
    }

    //metodo para verificar si el titulo es veridico
    public void verificartitulo(Persona per) throws Exception {
        //List<Persona> lista;
        ResultSet rs;
        Connection cn = DAO.getConnection();
        try {
            PreparedStatement stm = cn.prepareStatement("select nombPe, apellPe, ciPe, tp.nombProv, tp.fechaProv, fo.nroExpe from Persona join Tprovision as tp on Persona.idPe=tp.idPe join Folio as fo on tp.idProv=fo.idProv where fo.nroExpe = ?");
            stm.setInt(1, per.getProvis().getFolio().getNroExpe());
            rs = stm.executeQuery();

            if (rs.next()) {
                rs = stm.executeQuery();
                while (rs.next()) {
                    Persona pe = new Persona();
                    pe.setNombPe(rs.getString("nombPe"));
                    pe.setApellPe(rs.getString("apellPe"));
                    pe.setCiPe(rs.getString("ciPe"));

                    pe.getProvis().setNombProv(rs.getString("nombProv"));
                    pe.getProvis().setFechaProv(rs.getString("fechaProv"));
                   
                    pe.getProvis().getFolio().setNroExpe(rs.getInt("nroExpe"));
                   
                    System.out.println("folio: " + rs.getString("nroExpe"));
                RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Titulo Verifcado", "Nombres: "
                                             + rs.getString("nombPe")+" "+rs.getString("apellPe")+"<br/>Titulo: "+rs.getString("nombProv")
                                             + "<br/>Nro.: "+rs.getInt("nroExpe")+"  Fecha Emision: "+rs.getString("fechaProv")));
                                                
                }
                rs.close();
                
            } else {
                RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Datos Erroneos", "Titulo inexistente !!!"));
            }
        } catch (Exception e) {
            cn.rollback();
            throw e;

        } finally {
            cn.close();
        }
        //return lista;
    }

}
