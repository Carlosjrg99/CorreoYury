<%@page import="dao.EmpleoDAO"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="dao.PersonaDAO"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Usuarios</title>
    </head>
    <body>
        <%
            ArrayList<Persona> aLPersona = new ArrayList();
            if(request.getSession().getAttribute("filtrado") != null)
            {
                aLPersona = (ArrayList<Persona>) request.getSession().getAttribute("filtrado");
            }
            else
            {
                aLPersona = PersonaDAO.getArreglo();
            }
            Usuario user=null;
            String estadoSesion="off";

            HttpSession sesion = request.getSession(true);

            user=(Usuario)sesion.getAttribute("usuario");
            estadoSesion=(String) sesion.getAttribute("estadoSesion");   

            //Persona persona = PersonaDAO.buscar(user.getRutEmpleado());

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
        <h1>Usuarios Registrados:</h1>
        <table>
              <thead>
                <tr>
                        <th>Rut
                        <th>Nombre
                        <th>Apellido 1
                        <th>Apellido 2
                        <th>Genero
                        <th>Usuario
                        <th>Tipo
                        <th>Cargo
                        <th>Editar
                        <th>Eliminar
                </tr>
              </thead>
              <tbody>
                    <%
                        //String username = ;;
                        String tipo;
                        //Usuario usuario = UsuarioDAO.buscar(user.getUsername());
                        for(Persona persona: aLPersona)
                        {
                            if(persona.getEstado() != 3)
                            {
                                out.println("<tr>");
                                out.println("<td>" + persona.getRut() + "</td>");
                                out.println("<td>" + persona.getNombre() + "</td>");
                                out.println("<td>" + persona.getApellidoPaterno() + "</td>");
                                out.println("<td>" + persona.getApellidoMaterno() + "</td>");
                                out.println("<td>" + persona.getGenero()+ "</td>");
                                out.println("<td>" + UsuarioDAO.buscarRut(persona.getRut()).getUsername() + "</td>");
                                switch(UsuarioDAO.buscarRut(persona.getRut()).getTipoUsuario())
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
                                out.println("<td>" + EmpleoDAO.buscarCargo(persona.getRut())+ "</td>");
                                out.println("<td><a href='Modificar.jsp?rut=" + persona.getRut() + "'>modificar</a></td>");
                                out.println("<td><a href='Eliminar.jsp?rut=" + persona.getRut() + "'>eliminar</a></td>");
                                out.println("</tr>");
                            }
                        }
                        
                    %>
                    </tbody>
        </table><br><br><br>
        
        <h2>Filtrar</h2><br>
        <form action="ControladorFiltrarUsuarios" method="POST" >
            <label for="genero">Genero</label>
            <select name="genero">
                <option disabled selected hidden>-seleccionar-</option>
                <option value="Masculino">Masculino</option>
                <option value="Femenino">Femenino</option>
            </select><br>

            <label for="cargo">Cargo</label>
            <select name="cargo">
                <option disabled selected hidden>-seleccionar-</option>
                <option value="Miembro">Miembro</option>
                <option value="Cargo tipo 1">Cargo tipo 1</option>
                <option value="Cargo tipo 2">Cargo tipo 2</option>
                <option value="Cargo tipo 3">Cargo tipo 3</option>
                <option value="Cargo tipo 4">Cargo tipo 4</option>
                <option value="Cargo tipo 5">Cargo tipo 5</option>
            </select><br>

            <label for="departamento">Departamento</label>
            <select name="departamento">
                <option disabled selected hidden>-seleccionar-</option>
                <option value="Recursos Humanos">Recursos Humanos</option>
                <option value="Departamento 1">Departamento 1</option>
                <option value="Departamento 2">Departamento 2</option>
                <option value="Departamento 3">Departamento 3</option>
                <option value="Departamento 4">Departamento 4</option>
                <option value="Departamento 5">Departamento 5</option>
            </select><br>

            <label for="area">Area</label>
            <select name="area">
                <option disabled selected hidden>-seleccionar-</option>
                <option value="Administracion">Administración</option>
                <option value="Area 1">Area 1</option>
                <option value="Area 2">Area 2</option>
                <option value="Area 3">Area 3</option>
                <option value="Area 4">Area 4</option>
                <option value="Area 5">Area 5</option>
            </select><br><br>
            <button type="submit" name="opcion" value="Filtrar">Filtrar</button>
        </form>
        
        <button onclick="goBack()">Regresar</button>
        <script>
            function goBack() 
            {
                window.history.back();
            }
        </script>
    </body>
</html>
