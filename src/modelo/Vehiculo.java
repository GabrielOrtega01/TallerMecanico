package modelo;

public class Vehiculo {

    private int idv;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private int cliente_idc;

    public Vehiculo() {
        this.idv = 0;
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.tipo = "";
        this.cliente_idc = 0;
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

    public int getCliente_idc() {
        return cliente_idc;
    }

    public void setCliente_idc(int cliente_idc) {
        this.cliente_idc = cliente_idc;
    }

    @Override
    public String toString() {
        return "Vehículo{" + "idv=" + idv + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tipo=" + tipo + ", cliente_idc=" + cliente_idc + '}';
    }
}
