package modelo;

public class Empleo {
    private int id_empleado;
    private String rutEmpleado;
    private String cargo;
    private String area;
    private String departamento;
    private String fechaInicio;
    private String fechaFin;

    public Empleo() 
    {
        id_empleado = 0;
        rutEmpleado = null;
        cargo = null;
        area = null;
        departamento = null;
        fechaInicio = null;
        fechaFin = null;
    }

    public Empleo(int id_empleado, String rutEmpleado, String cargo, String area, String departamento, String fechaInicio, String fechaFin) {
        this.id_empleado = id_empleado;
        this.rutEmpleado = rutEmpleado;
        this.cargo = cargo;
        this.area = area;
        this.departamento = departamento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
