<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Trabajos</title>
        <style>
            table, th, td 
            {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <%
                Usuario user=null;
                String estadoSesion="off";

                HttpSession sesion = request.getSession(true);

                user=(Usuario)sesion.getAttribute("usuario");
                estadoSesion=(String) sesion.getAttribute("estadoSesion");   

                if(estadoSesion == null )
                {
                    response.sendRedirect("MensajeError.jsp?mensaje=Error, ingresar como trabajador&retorno=index.jsp");
                }       
               else{
                    //Usuario válido
                    // ¿tiene nivel de acceso?
                    switch(user.getTipoUsuario())
                    {
                        case 1:
                            break;
                        case 2:
                            break;
                        default:
                            response.sendRedirect("CerrarSesion.jsp");
                            break;
                    }
                }
         %>
        <%
              int numeroTrabajos;
              String rut;
              numeroTrabajos= (Integer) sesion.getAttribute("numeroTrabajosMod");
              rut=request.getParameter("rut");
         %>
        <h1>Ingresar Trabajos Anteriores</h1>
        <form action="ControladorRegistrarTrabajos" method="POST" >
            <%
                for (int i = 1;i <= numeroTrabajos;i++) 
                {%>
        <table>
                <thead>
                <tr>
                        <th>Rut Empleado
                        <th>Cargo
                        <th>Empresa
                        <th>Fecha de Contratación
                        <th>Fecha de Partida
                </tr>
                </thead>
                <tbody><%
                            out.println("<tr>");
                            out.println("<td>" + rut + "</td>");
                            out.println("<td><input type='text' name='cargo"+i+"' required=''></td>");
                            out.println("<td><input type='text' name='empresa"+i+"' required=''></td>");
                            out.println("<td><input type='date' name='fechaInicio"+i+"' required=''></td>");
                            out.println("<td><input type='date' name='fechaFin"+i+"' required=''></td>");
                            out.println("</tr>");
                        
                    
                            %>
                </tbody><br>
                    
        </table><br><%}%><br>
            <button type="submit" name="opcion" value="Cargar">Agregar</button>
        </form>     
    </body>
</html>
