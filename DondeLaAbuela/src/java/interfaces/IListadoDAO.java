package interfaces;

import java.util.List;

public interface IListadoDAO <General>{
    
    public List<General> readAll(String rut);
    
}
