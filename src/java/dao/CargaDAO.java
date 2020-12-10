/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Carlo
 */
public class CargaDAO {
        
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
    
    public static void agregarCarga(String rut, String nombre, String apellidoPaterno, String apellidoMaterno) throws SQLException
    {
        //método que agrega carga a un usuario existente
        conectar();
        state.executeUpdate("INSERT INTO carga VALUES("+0+
                ",'"+rut+
                "','"+nombre+
                "','"+apellidoPaterno+
                "','"+apellidoMaterno+"');");
        connect.close();
    }
    
    public static int getNumeroCargas(String rut) throws SQLException
    {
        int numeroCargas = 0;
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM carga WHERE rutEmpleado='"+rut+"';");
        while(result.next())
        {
            numeroCargas++;
        }
        connect.close();
        return numeroCargas;
    }  
    
    public static boolean  eliminar(String rut) throws SQLException
    {
        boolean estado=false;
        conectar();
        state.executeUpdate("DELETE FROM carga WHERE rutEmpleado='"+rut+"';");
        connect.close();
        estado = true;
        return estado;         
    }
}