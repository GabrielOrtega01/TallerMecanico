package modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class FacturaCliente {

    private String cliente;
    private String documento;
    private String direccion;
    private String correo;
    private String placa;
    private String libreta_repuestos_utilizados;
    private int costo_mano_de_obra;
    private int preciounitario;
    private int cantidad;
    private float iva;
    private BigDecimal total;
    private LocalDate fecha;
    private LocalTime hora;
    private String mecanico;
    private int idf;
    private String administrador;

    public FacturaCliente() {
        this.cliente = "";
        this.documento = "";
        this.direccion = "";
        this.correo = "";
        this.placa = "";
        this.libreta_repuestos_utilizados = "";
        this.costo_mano_de_obra = 0;
        this.preciounitario = 0;
        this.cantidad = 0;
        this.iva = 0;
        this.total = BigDecimal.ZERO;
        this.fecha = LocalDate.parse("1900-01-01");
        this.hora = LocalTime.parse("00:00:00");
        this.mecanico = "";
        this.idf = 0;
        this.administrador = "";
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getAdministrador() {
        return administrador;
    }

    public void setAdministrador(String administrador) {
        this.administrador = administrador;
    }

    @Override
    public String toString() {
        return "FacturaCliente{" + "cliente=" + cliente + ", documento=" + documento + ", direccion=" + direccion + ", correo=" + correo + ", placa=" + placa + ", libreta_repuestos_utilizados=" + libreta_repuestos_utilizados + ", costo_mano_de_obra=" + costo_mano_de_obra + ", preciounitario=" + preciounitario + ", cantidad=" + cantidad + ", iva=" + iva + ", total=" + total + ", fecha=" + fecha + ", hora=" + hora + ", mecanico=" + mecanico + ", idf=" + idf + ", administrador=" + administrador + '}';
    }

}
