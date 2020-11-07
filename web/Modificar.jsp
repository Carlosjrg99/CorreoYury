<%@page import="dao.UsuarioDAO"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modificar</title>
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
                     response.sendRedirect("MensajeError.jsp?mensaje=Error, usuario no auatorizado&retorno=index.jsp");
                }       
               else{
                    //Docente válido
                    // tiene nivel de acceso?
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
        Usuario usuario = UsuarioDAO.buscar(user.getUsername());
        String contacto = usuario.getContactoEmergencia();
        int cargas = usuario.getNumeroCargas();
        String nombreCompleto = usuario.getNombre()+" "+usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno();
        
        //String rut = user.getRut();
        //String nombreCompleto = user.getNombre()+" "+user.getApellidoPaterno()+" "+user.getApellidoMaterno();
    %><center>
            <h1>MODIFICAR</h1>
            <form action="Controlador" method="POST" onsubmit="return validacion();">
                        <h2><%out.println(nombreCompleto);%></h2>
                        <label for="contacto">Cambiar Contacto de Emergencia</label>
                        <input placeholder="<%=contacto%>" type="text" name="contacto"><br><br>
                        <label for="contacto">Añadir Cargas</label>
                        <input placeholder="Cargas actuales: <%=cargas%>" type="number" name="cargas" min="0" value="0"><br><br>
                        <h3>Cambiar Contraseña</h3>
                        <label for="password">Nueva Contraseña</label>
                        <input id="pass" type="password" name="pass" class="validate"><br><br>
                        <label for="rep">Repetir Contraseña</label>
                        <input id="rep" type="password" name="rep" class="validate"><br><br><br>
                <button type="submit" name="opcion" value="Modificar">Modificar
                </button>
                <button type="reset">Cancelar</button>
                <button onclick="goBack()">Regresar</button>
            </form>

    <script>
        function goBack() 
        {
            window.history.back();
        }
        
        function validacion()
        {
            var pass = document.getElementById('pass');
            var rep = document.getElementById('rep');
            if(pass.value !== rep.value)
            {
                alert('Los passwords no coinciden');
                document.getElementById('pass').focus();
                document.getElementById('rep').focus();
                return false;
            }
            else
            {
                
            }
        }
    </script>
    </center>
    </body>
</html>