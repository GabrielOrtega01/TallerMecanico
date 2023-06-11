package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class ItemCmbObservacion {

    private int ido;
    private String observacion;
    private LocalDate fecha;
    private LocalTime hora;
    private int vehiculo_idv;
    private int mecanico_idm;

    public ItemCmbObservacion() {
    }

    public ItemCmbObservacion(int ido, String observacion, LocalDate fecha, LocalTime hora, int vehiculo_idv, int mecanico_idm) {
        this.ido = ido;
        this.observacion = observacion;
        this.fecha = fecha;
        this.vehiculo_idv = vehiculo_idv;
        this.mecanico_idm = mecanico_idm;
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

    public int getVehiculo_idv() {
        return vehiculo_idv;
    }

    public void setVehiculo_idv(int vehiculo_idv) {
        this.vehiculo_idv = vehiculo_idv;
    }

    public int getMecanico_idm() {
        return mecanico_idm;
    }

    public void setMecanico_idm(int mecanico_idm) {
        this.mecanico_idm = mecanico_idm;
    }

    @Override
    public String toString() {
        return observacion;
    }

}
