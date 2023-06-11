package modelo;

public class Reparacion {

    private int idrepa;
    private int cantidad;
    private int mano_obra;
    private int observacion_ido;
    private int repuesto_idr;
    private int mecanico_idm2;

    public Reparacion() {
        this.idrepa = 0;
        this.cantidad = 0;
        this.mano_obra = 0;
        this.observacion_ido = 0;
        this.repuesto_idr = 0;
        this.mecanico_idm2 = 0;
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

    public int getObservacion_ido() {
        return observacion_ido;
    }

    public void setObservacion_ido(int observacion_ido) {
        this.observacion_ido = observacion_ido;
    }

    public int getRepuesto_idr() {
        return repuesto_idr;
    }

    public void setRepuesto_idr(int repuesto_idr) {
        this.repuesto_idr = repuesto_idr;
    }

    public int getMecanico_idm2() {
        return mecanico_idm2;
    }

    public void setMecanico_idm2(int mecanico_idm2) {
        this.mecanico_idm2 = mecanico_idm2;
    }

    @Override
    public String toString() {
        return "Reparación{" + "idrepa=" + idrepa + ", cantidad=" + cantidad + ", mano_obra=" + mano_obra + ", observacion_ido=" + observacion_ido + ", repuesto_idr=" + repuesto_idr + ", mecanico_idm2=" + mecanico_idm2 + '}';
    }
}
