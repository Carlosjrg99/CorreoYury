package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContactoDAO {
        
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
    
    public static void agregarContacto(String rut, String numeroTelefonico, String nombre, String apellidoPaterno, String apellidoMaterno) throws SQLException
    {
        //método que agrega carga a un usuario existente
        conectar();
        state.executeUpdate("INSERT INTO contacto VALUES("+0+
                ",'"+rut+
                "','"+numeroTelefonico+
                "','"+nombre+
                "','"+apellidoPaterno+
                "','"+apellidoMaterno+"');");
        connect.close();
    }
       
    public static int getNumeroContactos(String rut) throws SQLException
    {
        int numeroContactos = 0;
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM trabajo WHERE rutEmpleado='"+rut+"';");
        while(result.next())
        {
            numeroContactos++;
        }
        connect.close();
        return numeroContactos;
    }  
    
    public static boolean  eliminar(String rut) throws SQLException
    {
        boolean estado=false;
        conectar();
        state.executeUpdate("DELETE FROM contacto WHERE rutEmpleado='"+rut+"';");
        connect.close();
        estado = true;
        return estado;         
    }
}
