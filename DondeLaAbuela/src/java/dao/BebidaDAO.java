package dao;

import conexion.Conexion;
import dto.BebidaDTO;
import interfaces.IGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BebidaDAO implements IGeneral<BebidaDTO> {
    
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO Bebidas (idBebida, nombre, precio) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Bebidas WHERE idBebida = ?";
    private static final String SQL_UPDATE = "UPDATE Bebidas SET nombre = ?, precio = ? WHERE idBebida = ?";
    private static final String SQL_READ = "SELECT * FROM Bebidas WHERE idBebida = ?";
    private static final String SQL_READALL = "SELECT * FROM Bebidas";
    
    private static final Conexion con = Conexion.saberEstado();
    
    @Override
    public boolean create(BebidaDTO aux) {
        
        try {          
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, aux.getIdBebida());
            ps.setString(2, aux.getNombre());
            ps.setInt(3, aux.getPrecio());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BebidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        try {         
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setInt(1, key.hashCode());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BebidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(BebidaDTO aux) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, aux.getNombre());
            ps.setInt(2, aux.getPrecio());
            ps.setInt(3, aux.getIdBebida());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BebidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();;
        }
        return false;
    }

    @Override
    public BebidaDTO read(Object key) {
        ResultSet res;
        BebidaDTO bebida = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, key.hashCode());
            res = ps.executeQuery();
            while (res.next()) {
                bebida = new BebidaDTO(res.getInt(1), res.getString(2), res.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BebidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return bebida;
    }

    @Override
    public ArrayList<BebidaDTO> readAll() {
        ArrayList<BebidaDTO> bebidas = null;
        try {
            bebidas = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                bebidas.add(new BebidaDTO(res.getInt(1), res.getString(2), res.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BebidaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bebidas;
    }   
}