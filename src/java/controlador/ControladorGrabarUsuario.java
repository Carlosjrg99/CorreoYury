package controlador;

import dao.PersonaDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Persona;
import modelo.Usuario;

public class ControladorGrabarUsuario extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            
        response.setContentType("text/html;charset=UTF-8");
        String rut = "";
        String nombre = "";
        String apellidoPaterno="";
        String apellidoMaterno="";
        int tipoUsuario=0;
        String cargo="";
        String username="";
        String password="";
        int estado=0;
        int numeroCargas=0;
        int contactoEmergencia=0;
        int anteriorTrabajo=0;
        String opcion=request.getParameter("opcion");
            //Recibe el valor de opcion de algún botón para realizar acciones
        if (opcion.equals("Grabar")) 
        {
            //Para grabar en la BD un nuevo usuario
            rut=request.getParameter("rut");
            nombre=request.getParameter("nombre");
            apellidoPaterno=request.getParameter("apellidoPaterno");
            apellidoMaterno=request.getParameter("apellidoMaterno");
            password=request.getParameter("password");
            switch (request.getParameter("tipoUsuario")) 
            {
                case "rrhh":
                    tipoUsuario=1;
                    cargo="Recursos Humanos";
                    break;
                case "trabajador":
                    tipoUsuario=2;
                    switch (request.getParameter("cargo")) 
                    {
                        case "cargo1":
                            cargo="Cargo tipo 1";
                            break;
                        case "cargo2":
                            cargo="Cargo tipo 2";
                            break;
                        case "cargo3":
                            cargo="Cargo tipo 3";
                            break;
                        case "cargo4":
                            cargo="Cargo tipo 4";
                            break;
                        case "cargo5":
                            cargo="Cargo tipo 5";
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
            numeroCargas=Integer.valueOf(request.getParameter("numeroCargas"));
            contactoEmergencia=Integer.valueOf(request.getParameter("contactoEmergencia"));
            anteriorTrabajo=Integer.valueOf(request.getParameter("anteriorTrabajo"));
            username = UsuarioDAO.revisionUsuario(nombre, apellidoPaterno);
            Persona persona = new Persona(rut, nombre, apellidoPaterno, apellidoMaterno, cargo, estado);
            PersonaDAO.agregar(persona);
            Usuario usuario=new Usuario(username, rut, tipoUsuario, password);
            UsuarioDAO.agregar(usuario);
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("usuarioMod", usuario);
            sesion.setAttribute("numeroCargasMod", numeroCargas);
            sesion.setAttribute("numeroContactosMod", contactoEmergencia);
            sesion.setAttribute("numeroTrabajosMod", anteriorTrabajo);
            sesion.setAttribute("", cargo);
            
            if(numeroCargas != 0)
            {
                response.sendRedirect("AgregarCarga.jsp?rut="+rut);
            }
            else if(contactoEmergencia != 0)
            {
                response.sendRedirect("AgregarContacto.jsp?rut="+rut);
            }
            else if(anteriorTrabajo != 0)
            {
                response.sendRedirect("AgregarTrabajo.jsp?rut="+rut);
            }
            else
            {
                response.sendRedirect("MensajeOk.jsp?mensaje=Usuario agregado<br>Su username es: &username="+username);
            }
        } 
        
        try (PrintWriter out = response.getWriter()) 
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorGrabarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorGrabarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}