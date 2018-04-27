package dao;

import conexion.Conexion;
import dto.ClienteDTO;
import interfaces.IGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements IGeneral<ClienteDTO> {
    
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO Clientes (rut, clave, nombre, apPaterno, apMaterno, direccion, numeracion, comuna, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM Clientes WHERE rut = ?";
    private static final String SQL_UPDATE = "UPDATE Clientes SET clave = ?, nombre = ?, apPaterno = ?, apMaterno = ?, direccion = ?, numeracion = ?, comuna = ?, telefono = ? WHERE rut = ?";
    private static final String SQL_READ = "SELECT * FROM Clientes WHERE rut = ?";
    private static final String SQL_READALL = "SELECT * FROM Clientes";
    
    private static final Conexion con = Conexion.saberEstado();
    
    @Override
    public boolean create(ClienteDTO aux) {
        
        try {          
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setString(1, aux.getRut());
            ps.setString(2, aux.getClave());
            ps.setString(3, aux.getNombre());
            ps.setString(4, aux.getApPaterno());
            ps.setString(5, aux.getApMaterno());
            ps.setString(6, aux.getDireccion());
            ps.setInt(7, aux.getNumeracion());
            ps.setString(8, aux.getComuna());
            ps.setInt(9, aux.getTelefono());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ClienteDTO aux) {
        try {           
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, aux.getClave());
            ps.setString(2, aux.getNombre());
            ps.setString(3, aux.getApPaterno());
            ps.setString(4, aux.getApMaterno());
            ps.setString(5, aux.getDireccion());
            ps.setInt(6, aux.getNumeracion());
            ps.setString(7, aux.getComuna());
            ps.setInt(8, aux.getTelefono());
            ps.setString(9, aux.getRut());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();;
        }
        return false;
    }

    @Override
    public ClienteDTO read(Object key) {
        ResultSet res;
        ClienteDTO cliente = null;
        try {
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            while (res.next()) {
                cliente = new ClienteDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8), res.getInt(9));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return cliente;
    }

    @Override
    public ArrayList<ClienteDTO> readAll() {
        ArrayList<ClienteDTO> clientes = null;
        try {
            clientes = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                clientes.add(new ClienteDTO(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7), res.getString(8), res.getInt(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }   
}