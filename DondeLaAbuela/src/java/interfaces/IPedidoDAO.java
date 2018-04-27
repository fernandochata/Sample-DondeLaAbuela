package interfaces;

import java.util.List;

public interface IPedidoDAO <General>{
    
    public boolean create(General aux);
    
    public List<General> readAll(String rut);
    
}
