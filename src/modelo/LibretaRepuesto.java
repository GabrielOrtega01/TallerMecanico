package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class LibretaRepuesto {

    private String mecanico;
    private String placa;
    private String libreta_repuestos_utilizados;
    private int costo_mano_de_obra;
    private int preciounitario;
    private int cantidad;
    private float iva;
    private BigDecimal total;
    private LocalDate fecha;
    private LocalTime hora;

    public LibretaRepuesto() {
        this.mecanico = "";
        this.placa = "";
        this.libreta_repuestos_utilizados = "";
        this.costo_mano_de_obra = 0;
        this.preciounitario = 0;
        this.cantidad = 0;
        this.iva = 0;
        this.total = BigDecimal.ZERO;
        this.fecha = LocalDate.parse("1900-01-01");
        this.hora = LocalTime.parse("00:00:00");
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getLibreta_repuestos_utilizados() {
        return libreta_repuestos_utilizados;
    }

    public void setLibreta_repuestos_utilizados(String libreta_repuestos_utilizados) {
        this.libreta_repuestos_utilizados = libreta_repuestos_utilizados;
    }

    public int getCosto_mano_de_obra() {
        return costo_mano_de_obra;
    }

    public void setCosto_mano_de_obra(int costo_mano_de_obra) {
        this.costo_mano_de_obra = costo_mano_de_obra;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "LibretaRepuesto{" + "mecanico=" + mecanico + ", placa=" + placa + ", libreta_repuestos_utilizados=" + libreta_repuestos_utilizados + ", costo_mano_de_obra=" + costo_mano_de_obra + ", preciounitario=" + preciounitario + ", cantidad=" + cantidad + ", iva=" + iva + ", total=" + total + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
    
}
