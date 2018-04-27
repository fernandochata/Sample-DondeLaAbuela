package dao;

import conexion.Conexion;
import dto.PedidoDTO;
import interfaces.IPedidoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAO implements IPedidoDAO<PedidoDTO>{
    
    PreparedStatement ps;
    
    private static final String SQL_INSERT = "INSERT INTO Pedidos (rutCliente, plato, bebida, despacho, total, fechaHora) values (?,?,?,?,?,?)";
    private static final String SQL_READALL = "SELECT * FROM Pedidos WHERE rutCliente = ?";
    
    private static final Conexion con = Conexion.saberEstado();
    

    @Override
    public boolean create(PedidoDTO aux) {
        
        try {          
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            
            ps.setString(1, aux.getRutCliente());
            ps.setInt(2, aux.getPlato());
            ps.setInt(3, aux.getBebida());
            ps.setInt(4, aux.getDespacho());
            ps.setInt(5, aux.getTotal());
            ps.setString(6, aux.getFechaHora());
            
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }
    
    @Override
    public ArrayList<PedidoDTO> readAll(String rut) {
        ArrayList<PedidoDTO> pedidos = null;
        try {
            pedidos = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ps.setString(1, rut);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                pedidos.add(new PedidoDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getInt(6), res.getString(7)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedidos;
    }
    

}