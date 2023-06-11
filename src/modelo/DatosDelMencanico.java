package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class DatosDelMencanico {

    private String documento;
    private String mecanico;
    private String direccion;
    private String telefono;
    private String especialidad;
    private String nivel_educativo;
    private String experiencia;
    private LocalDate fecha;
    private LocalTime hora;
    private String contrasena;
    
    public DatosDelMencanico() {
        this.documento = "";
        this.mecanico = "";
        this.direccion = "";
        this.telefono = "";
        this.especialidad = "";
        this.nivel_educativo = "";
        this.experiencia = "";
        this.fecha = LocalDate.parse("1900-01-01");
        this.hora = LocalTime.parse("00:00:00");
        this.contrasena = "";
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "DatosDelMencanico{" + "documento=" + documento + ", mecanico=" + mecanico + ", direccion=" + direccion + ", telefono=" + telefono + ", especialidad=" + especialidad + ", nivel_educativo=" + nivel_educativo + ", experiencia=" + experiencia + ", fecha=" + fecha + ", hora=" + hora + ", contrasena=" + contrasena + '}';
    }

}