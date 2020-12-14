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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import modelo.Empleo;
import modelo.Persona;

/**
 *
 * @author Carlo
 */
public class EmpleoDAO {
        
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
    
    
    public static boolean  agregar(Empleo empleo) throws SQLException
    {
        //método que agrega un empleo a la BD
        conectar();    
        state.executeUpdate("INSERT INTO empleo VALUES("+0+
                ",'"+empleo.getRutEmpleado()+
                "','"+empleo.getCargo()+
                "','"+empleo.getArea()+
                "','"+empleo.getDepartamento()+
                "','"+empleo.getFechaInicio()+
                "','"+empleo.getFechaFin()+"');");
        connect.close();
        return true;
    }
    
    
    public static ArrayList<Persona> filtrar(int op, String cargo, String area, String departamento, String genero) throws SQLException
    {
        conectar();    
        ResultSet result = state.executeQuery("SELECT * FROM empleo;");
        ArrayList<Empleo> arreglo = new ArrayList();
        ArrayList<Persona> arreglito = new ArrayList();
        Persona persona;
        if(op > 0)
        {
            switch(op){
                case 1:
                        result = state.executeQuery("SELECT * FROM empleo WHERE cargo='"+cargo+"';");
                        break;
                case 2:
                        result = state.executeQuery("SELECT * FROM empleo WHERE area='"+area+"';");
                        break;
                case 3:
                        result = state.executeQuery("SELECT * FROM empleo WHERE cargo='"+cargo+"' AND area='"+area+"';");
                        break;
                case 4:
                        result = state.executeQuery("SELECT * FROM empleo WHERE departamento='"+departamento+"';");
                        break;
                case 5:
                        result = state.executeQuery("SELECT * FROM empleo WHERE cargo='"+cargo+"' AND departamento='"+departamento+"';");
                        break;
                case 6:
                        result = state.executeQuery("SELECT * FROM empleo WHERE departamento='"+departamento+"' AND area='"+area+"';");
                        break;
                case 7:
                        result = state.executeQuery("SELECT * FROM empleo WHERE departamento='"+departamento+"' AND area='"+area+"' AND cargo='"+cargo+"';");
                        break;
            }
            while(result.next())
            {
                Empleo empleo = new Empleo();
                empleo.setId_empleado((int)result.getObject(1));
                empleo.setRutEmpleado((String)result.getObject(2));
                empleo.setCargo((String)result.getObject(3));
                empleo.setArea((String)result.getObject(4));
                empleo.setDepartamento((String)result.getObject(5));
                empleo.setFechaInicio((String)result.getObject(6));
                empleo.setFechaFin((String)result.getObject(7));
                arreglo.add(empleo);
            }
            if(genero != null)
            {
                for(Empleo empleo:arreglo)
                {
                    if(PersonaDAO.buscarGenero(empleo.getRutEmpleado()).equals(genero))
                    {
                        persona = PersonaDAO.buscar(empleo.getRutEmpleado());
                        arreglito.add(persona);
                    }
                }
            }
            else
            {
                for(Empleo empleo:arreglo)
                {
                    persona = PersonaDAO.buscar(empleo.getRutEmpleado());
                    arreglito.add(persona);
                }
            }
        }
        else
        {
            if(genero != null)
            {
                while(result.next())
                {
                    Empleo empleo = new Empleo();
                    empleo.setId_empleado((int)result.getObject(1));
                    empleo.setRutEmpleado((String)result.getObject(2));
                    empleo.setCargo((String)result.getObject(3));
                    empleo.setArea((String)result.getObject(4));
                    empleo.setDepartamento((String)result.getObject(5));
                    empleo.setFechaInicio((String)result.getObject(6));
                    empleo.setFechaFin((String)result.getObject(7));
                    arreglo.add(empleo);
                }
                for(Empleo empleo:arreglo)
                {
                    if(PersonaDAO.buscarGenero(empleo.getRutEmpleado()).equals(genero))
                    {
                        persona = PersonaDAO.buscar(empleo.getRutEmpleado());
                        arreglito.add(persona);
                    }
                }
            }
        }
        return arreglito;
    }
    
    public static String buscarCargo(String rut) throws SQLException
    {
        //método que regresa a Persona con nombre de Persona inidicado
        conectar();    
        Empleo empleo = new Empleo();
        ResultSet result = state.executeQuery("SELECT * FROM empleo WHERE rutEmpleado='"+rut+"';");
        while(result.next())
        {
            empleo.setId_empleado((int)result.getObject(1));
            empleo.setRutEmpleado((String)result.getObject(2));
            empleo.setCargo((String)result.getObject(3));
            empleo.setArea((String)result.getObject(4));
            empleo.setDepartamento((String)result.getObject(5));
            empleo.setFechaInicio((String)result.getObject(6));
            empleo.setFechaFin((String)result.getObject(7));
        }
        connect.close();
        return empleo.getCargo();
    }  
    
    public static boolean  eliminar(String rut) throws SQLException
    {
        boolean estado=false;
        conectar();
        String fechaFin=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        state.executeUpdate("UPDATE empleo SET fechaFin = '"+fechaFin+"' WHERE rutEmpleado='"+rut+"' AND fechaFin='N/R';");
        connect.close();
        estado = true;
        return estado;         
    }  
}
