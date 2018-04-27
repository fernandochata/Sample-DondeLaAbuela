package dto;

public class PedidoDTO {
    
    private int idPedido;
    private String rutCliente;
    private int plato;
    private int bebida;
    private int despacho;
    private int total;
    private String fechaHora;

    public PedidoDTO() {
    }

    public PedidoDTO(int idPedido, String rutCliente, int plato, int bebida, int despacho, int total, String fechaHora) {
        this.idPedido = idPedido;
        this.rutCliente = rutCliente;
        this.plato = plato;
        this.bebida = bebida;
        this.despacho = despacho;
        this.total = total;
        this.fechaHora = fechaHora;
    }

    public PedidoDTO(String rutCliente, int plato, int bebida, int despacho, int total, String fechaHora) {
        this.rutCliente = rutCliente;
        this.plato = plato;
        this.bebida = bebida;
        this.despacho = despacho;
        this.total = total;
        this.fechaHora = fechaHora;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public int getPlato() {
        return plato;
    }

    public void setPlato(int plato) {
        this.plato = plato;
    }

    public int getBebida() {
        return bebida;
    }

    public void setBebida(int bebida) {
        this.bebida = bebida;
    }

    public int getDespacho() {
        return despacho;
    }

    public void setDespacho(int despacho) {
        this.despacho = despacho;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
}
