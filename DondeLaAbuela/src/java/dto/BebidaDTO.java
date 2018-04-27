package dto;

public class BebidaDTO {
    
    private int idBebida;
    private String nombre;
    private int precio;

    public BebidaDTO() {
    }

    public BebidaDTO(int idBebida, String nombre, int precio) {
        this.idBebida = idBebida;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
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
