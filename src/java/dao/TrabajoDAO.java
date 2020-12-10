package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Trabajo;

public class TrabajoDAO {
        
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
    
    public static boolean  agregar(Trabajo trabajo) throws SQLException
    {
        //método que agrega un usuario a la BD
        conectar();
        state.executeUpdate("INSERT INTO trabajo VALUES("+0+
                ",'"+trabajo.getRutEmpleado()+
                "','"+trabajo.getCargo()+
                "','"+trabajo.getEmpresa()+
                "','"+trabajo.getFechaInicio()+
                "','"+trabajo.getFechaFin()+"');");
        connect.close();
        return true;
    }
        
    public static int getNumeroTrabajos(String rut) throws SQLException
    {
        int numeroTrabajos = 0;
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM trabajo WHERE rutEmpleado='"+rut+"';");
        while(result.next())
        {
            numeroTrabajos++;
        }
        connect.close();
        return numeroTrabajos;
    }
}
