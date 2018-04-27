package dao;

import conexion.Conexion;
import dto.ComunaDTO;
import interfaces.IGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComunaDAO implements IGeneral<ComunaDTO>{
    
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO Comunas (codigo, nombre) VALUES (?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Comunas WHERE codigo = ?";
    private static final String SQL_UPDATE = "UPDATE Comunas SET nombre = ? WHERE codigo = ?";
    private static final String SQL_READ = "SELECT * FROM Comunas WHERE codigo = ?";
    private static final String SQL_READALL = "SELECT * FROM Comunas";
    
    private static final Conexion con = Conexion.saberEstado();
    
    @Override
    public boolean create(ComunaDTO aux) {
        
        try {          
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, aux.getCodigo());
            ps.setString(2, aux.getNombre());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        try {         
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ComunaDTO aux) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, aux.getNombre());
            ps.setString(2, aux.getCodigo());   
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();;
        }
        return false;
    }

    @Override
    public ComunaDTO read(Object key) {
        ResultSet res;
        ComunaDTO comuna = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                comuna = new ComunaDTO(res.getString(1), res.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return comuna;
    }

    @Override
    public ArrayList<ComunaDTO> readAll() {
        ArrayList<ComunaDTO> comunas = null;
        try {
            comunas = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                comunas.add(new ComunaDTO(res.getString(1), res.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComunaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comunas;
    }
    
}
