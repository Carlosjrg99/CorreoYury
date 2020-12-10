<%@page import="modelo.Usuario"%>
<%@page import="modelo.Persona"%>
<%@page import="dao.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Usuario</title>
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
        <%
            String rut = request.getParameter("rut");
            Persona persona = PersonaDAO.buscar(rut);
        %>
        <h1>Eliminar Usuario</h1>
         <div style="margin-top: 30px;">
                <form action="ControladorEliminar" method="post">
                            <label for="rut">Rut: </label>
                            <input type="text" name="rut" value="<%=persona.getRut()%>" readonly="readonly"><br>
                            <br><br>
                            <label for="nombre">Nombre: </label>
                        <input type="text" name="nombre" value="<%=persona.getNombre()%>" readonly="readonly"><br> 
                            <br><br>
                    <button type="submit" value="Aceptar" name="opcion" >Eliminar
                    </button>
                    <button type="reset">Cancelar</button>
                </form>
        </div>
        <br><button onclick="goBack()">Regresar</button>
        <script>
            function goBack() 
            {
                window.history.back();
            }
        </script>
    </body>
</html>
