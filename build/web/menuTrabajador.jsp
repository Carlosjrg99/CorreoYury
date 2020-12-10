<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú</title>
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
        <h1>MENÚ TRABAJADOR!</h1>
        <ul>
            <%if(user.getTipoUsuario()==1)
            {
                out.println("<li><a href='menuRRHH.jsp'>Acceder como RRHH</a></li>");
            }%>
            <li><a href="Modificar.jsp">Editar Información</a></li>
            <li><a href="Datos_Trabajador.jsp">Ver Información</a></li>
            <li><a href="CerrarSesion.jsp">Salir</a></li>
        </ul>
    </body>
</html>