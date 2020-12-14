package modelo;

public class Carga {
    private int id_carga;
    private String rutEmpleado;
    private String Nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String parentesco;
    
    public Carga()
    {
        id_carga = 0;
        rutEmpleado = null;
        Nombre = null;
        apellidoPaterno = null;
        apellidoMaterno = null;
        parentesco = null;
    }        
    
    public Carga(int id_carga, String rutEmpleado, String Nombre, String apellidoPaterno, String apellidoMaterno, String parentesco) {
        this.id_carga = id_carga;
        this.rutEmpleado = rutEmpleado;
        this.Nombre = Nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.parentesco = parentesco;
    }

    public int getId_carga() {
        return id_carga;
    }

    public void setId_carga(int id_carga) {
        this.id_carga = id_carga;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }
}
