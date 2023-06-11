package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ObservacionVista {

    private int ido;
    private String observacion;
    private LocalDate fecha;
    private LocalTime hora;
    private String placa;
    private String mecanico;

    public ObservacionVista() {
        this.ido = 0;
        this.observacion = "";
        this.fecha = LocalDate.parse("1900-01-01");
        this.hora = LocalTime.parse("00:00:00");
        this.placa = "";
        this.mecanico = "";
    }

    public int getIdo() {
        return ido;
    }

    public void setIdo(int ido) {
        this.ido = ido;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    @Override
    public String toString() {
        return "ObservacionVista{" + "ido=" + ido + ", observacion=" + observacion + ", fecha=" + fecha + ", hora=" + hora + ", placa=" + placa + ", mecanico=" + mecanico + '}';
    }

}
