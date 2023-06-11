package modelo;

public class ReparacionVista {

    private int idrepa;
    private int cantidad;
    private int mano_obra;
    private String observacion;
    private String repuesto;
    private String mecanico;

    public ReparacionVista() {
        this.idrepa = 0;
        this.cantidad = 0;
        this.mano_obra = 0;
        this.observacion = "";
        this.repuesto = "";
        this.mecanico = "";
    }

    public int getIdrepa() {
        return idrepa;
    }

    public void setIdrepa(int idrepa) {
        this.idrepa = idrepa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getMano_obra() {
        return mano_obra;
    }

    public void setMano_obra(int mano_obra) {
        this.mano_obra = mano_obra;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "ReparacionVista{" + "idrepa=" + idrepa + ", cantidad=" + cantidad + ", mano_obra=" + mano_obra + ", observacion=" + observacion + ", repuesto=" + repuesto + ", mecanico=" + mecanico + '}';
    }

}