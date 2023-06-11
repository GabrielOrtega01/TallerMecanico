package modelo;

public class Repuesto {

    private int idr;
    private String repuesto;
    private String tipo_repuesto;
    private int preciounitario;
    private float iva;

    public Repuesto() {
        this.idr = 0;
        this.repuesto = "";
        this.tipo_repuesto = "";
        this.preciounitario = 0;
        this.iva = 0;
    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public String getTipo_repuesto() {
        return tipo_repuesto;
    }

    public void setTipo_repuesto(String tipo_repuesto) {
        this.tipo_repuesto = tipo_repuesto;
    }

    public int getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(int preciounitario) {
        this.preciounitario = preciounitario;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Repuesto{" + "idr=" + idr + ", repuesto=" + repuesto + ", tipo_repuesto=" + tipo_repuesto + ", preciounitario=" + preciounitario + ", iva=" + iva + '}';
    }

}
