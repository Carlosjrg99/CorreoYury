package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

public class UsuarioDAO 
{    
    private static Connection connect;
    private static Statement state;
    private static int sw=0;
    
    public static void conectar()
    {
        //método que conecta con BD
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/correo_yury","root",null);
            state = connect.createStatement();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static int getSW()
    {
        //método que recupera estado
         return sw;
    }
    
    public static Usuario login(String usuario,String pass) throws SQLException
    {
        //método que se encarga de validar el usuario y la contraseña
        Usuario user = new Usuario();
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM usuario WHERE username='"
                           +usuario+"' AND password='"+pass+"';");
        while(result.next())
        {
            user.setUsername((String)result.getObject(1));
            user.setRutEmpleado((String)result.getObject(2));
            user.setPassword((String)result.getObject(3));
            user.setTipoUsuario((int)result.getObject(4));
        }
        connect.close();
        return user;
     }
    
    public static ArrayList<Usuario> getArreglo(ResultSet result) throws SQLException
    {
        //Se encarga de recuperar en un ArrayList objetos a partir del ResultSet
        ArrayList<Usuario> arreglo = new ArrayList();
        while(result.next())
        {
            Usuario user = new Usuario();
            user.setRut((String)result.getObject(1));
            user.setNombre((String)result.getObject(2));
            user.setApellidoPaterno((String)result.getObject(3));
            user.setApellidoMaterno((String)result.getObject(4));
            user.setTipoUsuario((int)result.getObject(5));
            user.setCargo((String)result.getObject(6));
            user.setUsername((String)result.getObject(7));
            user.setPassword((String)result.getObject(8));
            user.setEstado((int)result.getObject(9));
            user.setNumeroCargas((int)result.getObject(10));
            user.setContactoEmergencia((String)result.getObject(11));
            user.setUltimoTrabajo((String)result.getObject(12));
            arreglo.add(user);
        }
        return arreglo;
    }
    
    public static String revisionUsuario(String nombre, String apellido) throws SQLException
    {
        //método que se encarga de crear un usuario único a partir del nombre y apellido
        ArrayList<Usuario> alUsuarios = new ArrayList();
        String username="";
        String usernamecito;
        int i=0;
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM usuario");
        alUsuarios = getArreglo(result);
        username = nombre.charAt(0)+apellido;
        username = username.toLowerCase();
        for(Usuario usuarito : alUsuarios)
        {
            usernamecito = username+i;
            if(usuarito.getUsername().equals(usernamecito))
                {
                    i++;
                }
        }
        username = username+i;
        return username;
    }
    
     public static boolean revisarRut(String rut) throws SQLException
    {
        //método que se encarga de revisar si existe un usuario con el rut inidicado
        Usuario user = new Usuario();
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM usuario WHERE rut='"
                           +rut+"';");
        while(result.next())
        {
            user.setRut((String)result.getObject(1));
            user.setNombre((String)result.getObject(2));
            user.setApellidoPaterno((String)result.getObject(3));
            user.setApellidoMaterno((String)result.getObject(4));
            user.setTipoUsuario((int)result.getObject(5));
            user.setCargo((String)result.getObject(6));
            user.setUsername((String)result.getObject(7));
            user.setPassword((String)result.getObject(8));
            user.setEstado((int)result.getObject(9));
            user.setNumeroCargas((int)result.getObject(10));
            user.setContactoEmergencia((String)result.getObject(11));
            user.setUltimoTrabajo((String)result.getObject(12));
            if(user.getRut().equals(rut))
            {
                //el rut ya ha sido registrado con otro usuario
                connect.close();
                return false;
            }
        }
        connect.close();
        return true;
     }
    
    public static boolean  agregar(Usuario usuario) throws SQLException
    {
        //método que agrega un usuario a la BD
        boolean estado=false;
        if(!revisarRut(usuario.getRut()))
        {
            return estado;
        }
        conectar();
        state.executeUpdate("INSERT INTO usuario VALUES('"+usuario.getRut()+
                "',"+usuario.getTipoUsuario()+
                ",'"+usuario.getUsername()+
                "','"+usuario.getPassword()+"');");
        connect.close();
        estado = true;
        return estado;
    }
    
    public static Usuario buscar(String usuario) throws SQLException
    {
        //método que regresa a usuario con nombre de usuario inidicado
        Usuario user = new Usuario();
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM usuario WHERE username='"+usuario+"';");
        while(result.next())
        {
            user.setUsername((String)result.getObject(1));
            user.setRutEmpleado((String)result.getObject(2));
            user.setPassword((String)result.getObject(3));
            user.setTipoUsuario((int)result.getObject(4));
        }
        connect.close();
        return user;
    }
    
    
    
    public static boolean  modificar(Usuario usuario, String password) throws SQLException
    {
        //método que permite modificar los datos en la BD de un trabajador
        boolean estado=false;
        /*int numCargas = cargas + CargaDAO.getNumeroCargas(usuario.getRutEmpleado());
        int numContactos = contactos + ContactoDAO.getNumeroContactos(usuario.getRutEmpleado());*/
        conectar();/*
        if(contacto > 0)
        {
            state.executeUpdate("UPDATE usuario SET contactoEmergencia='"
                    +contacto+"' WHERE rut='"+usuario.getRut()+"';");
            estado = true;
        }*/
        if(!password.isEmpty())
        {
            state.executeUpdate("UPDATE usuario SET password='"
                    +password+"' WHERE username='"+usuario.getUsername()+"';");
            estado = true;
        }
        /*if(cargas > 0)
        {
            state.executeUpdate("UPDATE usuario SET numeroCargas='"
                    +numCargas+"' WHERE rut='"+usuario.getRut()+"';");
            estado = true;
        }*/
        connect.close();
        return estado;         
    }  
}