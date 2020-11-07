<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    <center>
            <h1>FICHA de Trabajadores</h1>
                <form action="Controlador" method="POST" onsubmit="return validacion();">
                    <label for="rut">Rut</label>
                    <input type="text" name="rut" id="rut" class="validate" required=""><br><br>
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" class="validate" required=""><br><br>
                    <label for="apellidoPaterno">Apellido Paterno</label>
                    <input type="text" name="apellidoPaterno" class="validate" required=""><br><br>
                    <label for="apellidoMaterno">Apellido Materno</label>
                    <input type="text" name="apellidoMaterno" class="validate" required=""><br><br>
                    <label for="password">Password</label>
                    <input type="password" name="password" class="validate" required=""><br><br>
                    <label for="tipoUsuario">Tipo de Usuario</label>
                    <select name="tipoUsuario">
                        <option disabled selected hidden>-seleccionar-</option>
                        <option value="rrhh">Recursos Humanos</option>
                        <option value="trabajador">Trabajador</option>
                    </select><br><br>
                    <label for="cargo">Cargo</label>
                    <select name="cargo">
                        <option disabled selected hidden>-seleccionar-</option>
                        <option value="cargo1">Cargo tipo 1</option>
                        <option value="cargo2">Cargo tipo 2</option>
                        <option value="cargo3">Cargo tipo 3</option>
                        <option value="cargo4">Cargo tipo 4</option>
                        <option value="cargo5">Cargo tipo 5</option>
                    </select><br><br>
                    <label for="numeroCargas">Número de Cargas</label>
                    <input type="number" name="numeroCargas" required="" min="0" value="0"><br><br>
                    <label for="contactoEmergencia">Contacto de Emergencia</label>
                    <input type="text" name="contactoEmergencia" required=""><br><br>
                    <label for="ultimoTrabajo">Trabajo Anterior</label>
                    <input type="text" name="ultimoTrabajo" class="validate" required=""><br><br><br>
                    <button type="submit" name="opcion" value="Grabar">Crear</button>
                    <button type="reset">Cancelar</button>
                    <input type="submit" value="Regresar" onclick="window.location='menuRRHH.jsp';"/>
                </form>
        <script>
            function validacion()
            {
                var rut = document.getElementById('rut');
                var expRut = /^\d{7,8}[-]\d$/;
                if(!rut.value.match(expRut))
                {
                    alert('El rut tiene formato nnnnnnnn-n');
                    rut.focus();
                    return false;
                }
            }
        </script>
    </center>
    </body>
</html>