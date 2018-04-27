package dto;

public class ListadoDTO {    
    private int codigo;
    private String plato;
    private String bebida;
    private String entrega;
    private int telefono;
    private String comuna;
    private String ingreso;
    private int total;

    public ListadoDTO() {
    }

    public ListadoDTO(int codigo, String plato, String bebida, String entrega, int telefono, String comuna, String ingreso, int total) {
        this.codigo = codigo;
        this.plato = plato;
        this.bebida = bebida;
        this.entrega = entrega;
        this.telefono = telefono;
        this.comuna = comuna;
        this.ingreso = ingreso;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getIngreso() {
        return ingreso;
    }

    public void setIngreso(String ingreso) {
        this.ingreso = ingreso;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    
}
