<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <h1>Datos!</h1>
        <table>
              <thead>
                <tr>
                        <th>Rut
                        <th>Nombre
                        <th>Apellido 1
                        <th>Apellido 2
                        <th>Usuario
                        <th>Tipo
                        <th>Cargo
                        <th style="text-align: center;" colspan="2">Editar
                </tr>
              </thead>
              <tbody>
                    <%
                        //String username = ;;
                        String tipo;
                        Usuario usuario = UsuarioDAO.buscar((String)sesion.getAttribute("username"));
                            out.println("<tr>");
                            out.println("<td>" + usuario.getRut() + "</td>");
                            out.println("<td>" + usuario.getNombre() + "</td>");
                            out.println("<td>" + usuario.getApellidoPaterno() + "</td>");
                            out.println("<td>" + usuario.getApellidoMaterno() + "</td>");
                            out.println("<td>" + usuario.getUsername() + "</td>");
                            switch(usuario.getTipoUsuario())
                            {
                                case 1:
                                    tipo="RR.HH.";
                                    break;
                                case 2:
                                    tipo="Trabajador";
                                    break;
                                default:
                                tipo="Error";
                                break;
                            }
                            out.println("<td>" + tipo + "</td>");
                            out.println("<td>" + usuario.getCargo()+ "</td>");
                            out.println("<td><a href='Eliminar.jsp?rut=" + usuario.getRut() + "'>eliminar</a></td>");
                            out.println("<td><a href='Modificar.jsp?rut=" + usuario.getRut() + "'>modificar</a></td>");
                            out.println("</tr>");
                        
                    %>
                    </tbody>
            </table>
    </body>
</html>
