package modelo;

public class VehiculoVista {

    private int idv;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private String cliente;

    public VehiculoVista() {
        this.idv = 0;
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.tipo = "";
        this.cliente = "";
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "VehiculoVista{" + "idv=" + idv + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tipo=" + tipo + ", cliente=" + cliente + '}';
    }

}