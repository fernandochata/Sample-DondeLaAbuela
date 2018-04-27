package interfaces;

import java.util.List;

public interface IGeneral <General>{

    public boolean create(General aux);

    public boolean delete(Object key);

    public boolean update(General aux);
    
    public General read(Object key);

    public List<General> readAll(); 
}
