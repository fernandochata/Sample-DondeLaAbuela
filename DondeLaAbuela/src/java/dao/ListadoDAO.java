package dao;

import conexion.Conexion;
import dto.ListadoDTO;
import interfaces.IListadoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListadoDAO implements IListadoDAO<ListadoDTO>{
    
    PreparedStatement ps;
    
    private static final String SQL_READALL = "Select p.idPedido as Codigo, pl.nombre as Plato, b.nombre as Bebida, CASE p.despacho WHEN 0 THEN 'Retiro en Tienda' WHEN 1 THEN CONCAT(c.direccion,' #' , c.numeracion) END as Entrega, c.telefono as Telefono, co.nombre as Comuna, p.fechaHora as Ingreso, p.total as Total from pedidos p join clientes c on p.rutCliente = c.rut join comunas co on co.codigo = c.comuna join platos pl on pl.idPlato = p.plato join bebidas b on b.idBebida = p.bebida where c.rut = ? ORDER by p.idPedido";
    
    private static final Conexion con = Conexion.saberEstado();
    
    @Override
    public ArrayList<ListadoDTO> readAll(String rut) {
        ArrayList<ListadoDTO> listado = null;
        try {
            listado = new ArrayList<>();            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            ps.setString(1, rut);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                listado.add(new ListadoDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5), res.getString(6), res.getString(7), res.getInt(8)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listado;
    }
}
