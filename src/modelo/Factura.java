package modelo;

public class Factura {

    private int idf;
    private String administrador;
    private int reparacion_idrepa;

    public Factura() {
        this.idf = 0;
        this.administrador = "";
        this.reparacion_idrepa = 0;
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

    public int getReparacion_idrepa() {
        return reparacion_idrepa;
    }

    public void setReparacion_idrepa(int reparacion_idrepa) {
        this.reparacion_idrepa = reparacion_idrepa;
    }

    @Override
    public String toString() {
        return "Factura{" + "idf=" + idf + ", administrador=" + administrador + ", reparacion_idrepa=" + reparacion_idrepa + '}';
    }

}
