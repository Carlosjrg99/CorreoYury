<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                     response.sendRedirect("MensajeError.jsp?mensaje=Error, ingresar como usuario RRHH&retorno=index.jsp");
                }       
               else{
                    //Usuario válido
                    // ¿tiene nivel de acceso?
                    switch(user.getTipoUsuario())
                    {
                        case 1:
                            break;
                        case 2:
                            response.sendRedirect("MensajeError.jsp?mensaje=Error, no es miembro de RRHH&retorno=menuTrabajador.jsp");
                            break;
                        default:
                            response.sendRedirect("CerrarSesion.jsp");
                            break;
                    }
                }
         %>
         <h1>MENÚ RR.HH.!</h1>
        <ul>
            <li><a href="CRUD_RRHH.jsp">Crear trabajador</a></li>
            <li><a href="menuTrabajador.jsp">Acceder como trabajador</a></li>
            <li><a href="CerrarSesion.jsp">Salir</a></li>
        </ul>
    </body>
</html>