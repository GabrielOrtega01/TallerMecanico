package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ListaRepuesto {

    private String repuesto;
    private int cantidad;
    private int preciounitario;
    private int mano_obra;
    private float iva;
    private BigDecimal total;
    private LocalDateTime fecha;

    public ListaRepuesto() {
        this.repuesto = "";
        this.cantidad = 0;
        this.preciounitario = 0;
        this.mano_obra = 0;
        this.iva = 0;
        this.total = BigDecimal.ZERO;
        this.fecha = LocalDateTime.parse("1900-01-01t00:00:00");
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public int getMano_obra() {
        return mano_obra;
    }

    public void setMano_obra(int mano_obra) {
        this.mano_obra = mano_obra;
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ListaRepuesto{" + "repuesto=" + repuesto + ", cantidad=" + cantidad + ", preciounitario=" + preciounitario + ", mano_obra=" + mano_obra + ", iva=" + iva + ", total=" + total + ", fecha=" + fecha + '}';
    }

}
