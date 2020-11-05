package modelo;

public class Usuario {
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int tipoUsuario;  //1 admin, 2 RRHH, 3 trabajador, 0 error
    private String cargo;
    private String username;
    private String password;
    private int estado;  //1 activo, 0 inactivo, 3 eliminado...etc
    private int numeroCargas;
    private String contactoEmergencia;
    private String ultimoTrabajo;

    public Usuario()
    {
        rut = null;
        nombre = null;
        apellidoPaterno = null;
        apellidoMaterno = null;
        tipoUsuario = 0;
        cargo = null;
        username = null;
        password = null;
        estado = 0;
        numeroCargas=0;
        contactoEmergencia="";
        ultimoTrabajo="";
    }
    
    public Usuario(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, int tipoUsuario, String cargo, String username, String password, int estado, int numeroCargas, String contactoEmergencia, String ultimoTrabajo) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoUsuario = tipoUsuario;
        this.cargo = cargo;
        this.username = username;
        this.password = password;
        this.estado = estado;
        this.numeroCargas = numeroCargas;
        this.contactoEmergencia = contactoEmergencia;
        this.ultimoTrabajo = ultimoTrabajo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getNumeroCargas() {
        return numeroCargas;
    }

    public void setNumeroCargas(int numeroCargas) {
        this.numeroCargas = numeroCargas;
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        this.contactoEmergencia = contactoEmergencia;
    }

    public String getUltimoTrabajo() {
        return ultimoTrabajo;
    }

    public void setUltimoTrabajo(String ultimoTrabajo) {
        this.ultimoTrabajo = ultimoTrabajo;
    }
}