package modelo;

import java.time.LocalDateTime;

public class DatosPersonaVehiculo {

    private String nombre;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String tipo;
    private LocalDateTime fecha;

    public DatosPersonaVehiculo() {
        this.nombre = "";
        this.placa = "";
        this.marca = "";
        this.modelo = "";
        this.color = "";
        this.tipo = "";
        this.fecha = LocalDateTime.parse("1900-01-01t00:00:00");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "DatosPersonaVehículo{" + "nombre=" + nombre + ", placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", tipo=" + tipo + ", fecha=" + fecha + '}';
    }

}
