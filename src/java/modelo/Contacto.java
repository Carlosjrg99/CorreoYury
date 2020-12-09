package modelo;

public class Contacto {
    private int id_contacto;
    private String rutEmpleado;
    private String numeroTelefonico;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Contacto() 
    {
        id_contacto = 0;
        rutEmpleado = null;
        numeroTelefonico = null;
        nombre = null;
        apellidoPaterno = null;
        apellidoMaterno = null;
    }

    public Contacto(int id_contacto, String rutEmpleado, String numeroTelefonico, String nombre, String apellidoPaterno, String apellidoMaterno) 
    {
        this.id_contacto = id_contacto;
        this.rutEmpleado = rutEmpleado;
        this.numeroTelefonico = numeroTelefonico;
        this.nombre= nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getId_contacto() {
        return id_contacto;
    }

    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getNombreContacto() {
        return nombre;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombre= nombreContacto;
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
    
    
}
