<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar cargas</title>
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
              int numeroCargas;
              String rut;
              numeroCargas=Integer.valueOf(request.getParameter("numeroCargas"));
              rut=request.getParameter("rut");
         %>
        <h1>Ingresar Datos!</h1>
        <form action="Controlador" method="POST" >
            <%
                for (int i = 1;i <= numeroCargas;i++) 
                {%>
        <table>
                <thead>
                <tr>
                        <th>Rut Apoderado
                        <th>Nombre
                        <th>Apellido 1
                        <th>Apellido 2
                </tr>
                </thead>
                <tbody><%
                            out.println("<tr>");
                            out.println("<td>" + rut + "</td>");
                            out.println("<td><input type='text' name='nombre"+i+"' required=''></td>");
                            out.println("<td><input type='text' name='apellidoPaterno"+i+"' required=''></td>");
                            out.println("<td><input type='text' name='apellidoMaterno"+i+"' required=''></td>");
                            out.println("</tr>");
                        
                    
                            %>
                </tbody><br>
                    
        </table><br><%}%><br>
            <button type="submit" name="opcion" value="Cargar">Agregar</button>
        </form>     
    </body>
</html>
