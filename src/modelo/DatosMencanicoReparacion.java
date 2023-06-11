package modelo;

import java.time.LocalDateTime;

public class DatosMencanicoReparacion {

    private String mecanico;
    private String nivel_educativo;
    private String experiencia;
    private LocalDateTime fecha;

    public DatosMencanicoReparacion() {
        this.mecanico = "";
        this.nivel_educativo = "";
        this.experiencia = "";
        this.fecha = LocalDateTime.parse("1900-01-01t00:00:00");
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public String getNivel_educativo() {
        return nivel_educativo;
    }

    public void setNivel_educativo(String nivel_educativo) {
        this.nivel_educativo = nivel_educativo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "DatosDelMencanico{" + "mecanico=" + mecanico + ", nivel_educativo=" + nivel_educativo + ", experiencia=" + experiencia + ", fecha=" + fecha + '}';
    }

}
