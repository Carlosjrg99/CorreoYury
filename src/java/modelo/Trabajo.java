package modelo;

public class Trabajo {
    private int id_trabajo;
    private String rutEmpleado;
    private String cargo;
    private String empresa;
    private String fechaInicio;
    private String fechaFin;

    public Trabajo() 
    {
        id_trabajo = 0;
        rutEmpleado = null;
        cargo = null;
        empresa = null;
        fechaInicio = null;
        fechaFin = null;
    }

    public Trabajo(int id_trabajo, String rutEmpleado, String cargo, String empresa, String fechaInicio, String fechaFin) 
    {
        this.id_trabajo = id_trabajo;
        this.rutEmpleado = rutEmpleado;
        this.cargo = cargo;
        this.empresa = empresa;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId_trabajo() {
        return id_trabajo;
    }

    public void setId_trabajo(int id_trabajo) {
        this.id_trabajo = id_trabajo;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
}
