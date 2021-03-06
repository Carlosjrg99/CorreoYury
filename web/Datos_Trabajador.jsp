<%@page import="dao.PersonaDAO"%>
<%@page import="modelo.Persona"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sus Datos</title>
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
                
                Persona persona = PersonaDAO.buscar(user.getRutEmpleado());
                
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
        <h1>Sus Datos</h1>
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
                        <th>Editar
                </tr>
              </thead>
              <tbody>
                    <%
                        //String username = ;;
                        String tipo;
                        //Usuario usuario = UsuarioDAO.buscar(user.getUsername());
                            out.println("<tr>");
                            out.println("<td>" + persona.getRut() + "</td>");
                            out.println("<td>" + persona.getNombre() + "</td>");
                            out.println("<td>" + persona.getApellidoPaterno() + "</td>");
                            out.println("<td>" + persona.getApellidoMaterno() + "</td>");
                            out.println("<td>" + user.getUsername() + "</td>");
                            switch(user.getTipoUsuario())
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
                            out.println("<td>" + persona.getCargo()+ "</td>");
                            out.println("<td><a href='Modificar.jsp?rut=" + persona.getRut() + "'>modificar</a></td>");
                            out.println("</tr>");
                        
                    %>
                    </tbody>
        </table><br><br><br>
        
        <button onclick="goBack()">Regresar</button>
        <script>
            function goBack() 
            {
                window.history.back();
            }
        </script>
    </body>
</html>
