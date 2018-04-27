package dao;

import conexion.Conexion;
import dto.PlatoDTO;
import interfaces.IGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlatoDAO implements IGeneral<PlatoDTO> {
    
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO Platos (idPlato, nombre, precio) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Platos WHERE idPlato = ?";
    private static final String SQL_UPDATE = "UPDATE Platos SET nombre = ?, precio = ? WHERE idPlato = ?";
    private static final String SQL_READ = "SELECT * FROM Platos WHERE idPlato = ?";
    private static final String SQL_READALL = "SELECT * FROM Platos";
    
    private static final Conexion con = Conexion.saberEstado();
    
    @Override
    public boolean create(PlatoDTO aux) {
        
        try {          
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, aux.getIdPlato());
            ps.setString(2, aux.getNombre());
            ps.setInt(3, aux.getPrecio());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(PlatoDTO aux) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, aux.getNombre());
            ps.setInt(2, aux.getPrecio());
            ps.setInt(3, aux.getIdPlato());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();;
        }
        return false;
    }

    @Override
    public PlatoDTO read(Object key) {
        ResultSet res;
        PlatoDTO plato = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setInt(1, key.hashCode());
            res = ps.executeQuery();
            while (res.next()) {
                plato = new PlatoDTO(res.getInt(1), res.getString(2), res.getInt(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return plato;
    }

    @Override
    public ArrayList<PlatoDTO> readAll() {
        ArrayList<PlatoDTO> platos = null;
        try {
            platos = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            //ps.setInt(1, key.hashCode());
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                platos.add(new PlatoDTO(res.getInt(1), res.getString(2), res.getInt(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return platos;
    }
}
