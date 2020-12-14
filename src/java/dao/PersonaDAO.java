package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Persona;

public class PersonaDAO {
        
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
    
    public static boolean revisarRut(String rut) throws SQLException
    {
        //método que se encarga de revisar si existe un Persona con el rut inidicado
        Persona user = new Persona();
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM persona WHERE rut='"
                           +rut+"';");
        while(result.next())
        {
            user.setRut((String)result.getObject(1));
            user.setNombre((String)result.getObject(2));
            user.setApellidoPaterno((String)result.getObject(3));
            user.setApellidoMaterno((String)result.getObject(4));
            user.setFechaCreacion((String)result.getObject(5));
            user.setEstado((int)result.getObject(6));
            if(user.getRut().equals(rut))
            {
                //el rut ya ha sido registrado previamente
                connect.close();
                return false;
            }
        }
        connect.close();
        return true;
     }
    
    public static boolean  agregar(Persona persona) throws SQLException
    {
        //método que agrega un Persona a la BD
        boolean estado=false;
        if(!revisarRut(persona.getRut()))
        {
            return estado;
        }
        conectar();
        state.executeUpdate("INSERT INTO persona VALUES('"+persona.getRut()+
                "','"+persona.getNombre()+
                "','"+persona.getApellidoPaterno()+
                "','"+persona.getApellidoMaterno()+
                "','"+persona.getFechaCreacion()+
                "','"+persona.getGenero()+
                "',"+persona.getEstado()+");");
        connect.close();
        estado = true;
        return estado;
    }
    
    public static Persona buscar(String rut) throws SQLException
    {
        //método que regresa a Persona con nombre de Persona inidicado
        Persona user = new Persona();
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM persona WHERE rut='"+rut+"';");
        while(result.next())
        {
            user.setRut((String)result.getObject(1));
            user.setNombre((String)result.getObject(2));
            user.setApellidoPaterno((String)result.getObject(3));
            user.setApellidoMaterno((String)result.getObject(4));
            user.setFechaCreacion((String)result.getObject(5));
            user.setGenero((String)result.getObject(6));
            user.setEstado((int)result.getObject(7));
        }
        connect.close();
        return user;
    }    
    
    public static ArrayList<Persona> getArreglo() throws SQLException
    {
        //Se encarga de recuperar en un ArrayList objetos a partir del ResultSet
        conectar();
        ArrayList<Persona> arreglo = new ArrayList();
        ResultSet result = state.executeQuery("SELECT * FROM persona");
        while(result.next())
        {
            Persona user = new Persona();
            user.setRut((String)result.getObject(1));
            user.setNombre((String)result.getObject(2));
            user.setApellidoPaterno((String)result.getObject(3));
            user.setApellidoMaterno((String)result.getObject(4));
            user.setFechaCreacion((String)result.getObject(5));
            user.setGenero((String)result.getObject(6));
            user.setEstado((int)result.getObject(7));
            arreglo.add(user);
        }
        connect.close();
        return arreglo;
    }  
    
    public static boolean  eliminar(String rut) throws SQLException
    {
        boolean estado=false;
        conectar();
        state.executeUpdate("UPDATE persona SET estado = 3 WHERE rut='"+rut+"';");
        connect.close();
        estado = true;
        return estado;         
    }
    
    public static String buscarGenero(String rut) throws SQLException
    {
        //método que regresa a Persona con nombre de Persona inidicado
        Persona user = new Persona();
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM persona WHERE rut='"+rut+"';");
        while(result.next())
        {
            user.setRut((String)result.getObject(1));
            user.setNombre((String)result.getObject(2));
            user.setApellidoPaterno((String)result.getObject(3));
            user.setApellidoMaterno((String)result.getObject(4));
            user.setFechaCreacion((String)result.getObject(5));
            user.setGenero((String)result.getObject(6));
            user.setEstado((int)result.getObject(7));
        }
        connect.close();
        return user.getGenero();
    }    
}