package dto;

public class PlatoDTO {
    
    private int idPlato;
    private String nombre;
    private int precio;

    public PlatoDTO() {
    }

    public PlatoDTO(int idPlato, String nombre, int precio) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

   
}
