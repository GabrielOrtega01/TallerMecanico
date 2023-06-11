package modelo;

public class Mecanico {

    private int idm;
    private String documento;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String especialidad;
    private String nivel_educativo;
    private String experiencia;
    private String contrasena;

    public Mecanico() {
        this.idm = 0;
        this.documento = "";
        this.nombre = "";
        this.apellido = "";
        this.direccion = "";
        this.telefono = "";
        this.especialidad = "";
        this.nivel_educativo = "";
        this.experiencia = "";
        this.contrasena = "";;
    }

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Mecanico{" + "idm=" + idm + ", documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", especialidad=" + especialidad + ", nivel_educativo=" + nivel_educativo + ", experiencia=" + experiencia + ", contrasena=" + contrasena + '}';
    }
}
