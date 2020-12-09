package modelo;

public class Usuario {
    private String username;
    private String rutEmpleado;
    private int tipoUsuario;  //1 admin, 2 RRHH, 3 trabajador, 0 error
    private String password;

    public Usuario()
    {
        username = null;
        rutEmpleado = null;
        tipoUsuario = 0;
        password = null;
    }
    
    public Usuario(String username, String rutEmpleado, int tipoUsuario, String password) {
        this.username = username;
        this.rutEmpleado = rutEmpleado;
        this.tipoUsuario = tipoUsuario;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}