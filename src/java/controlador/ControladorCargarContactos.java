package controlador;

import dao.ContactoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

@WebServlet(name = "ControladorCargarContactos", urlPatterns = {"/ControladorCargarContactos"})
public class ControladorCargarContactos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String opcion=request.getParameter("opcion");
        if(opcion.equals("Cargar"))
        {
            //Para agregar cargas en la BD un usuario existente
            //Posterior a Grabar en el caso de indicar cargas
            String numeroTelefonico;
            String nombreContacto;
            String apellidoP;
            String apellidoM;
            HttpSession sesion = request.getSession(true);
            Usuario contacto = (Usuario) sesion.getAttribute("usuarioMod");
            int numContactos = (int) sesion.getAttribute("numeroContactosMod");
            for(int i = 1;i <= numContactos;i++) 
            {
                numeroTelefonico=request.getParameter("numeroTelefonico"+i);
                nombreContacto=request.getParameter("nombre"+i);
                apellidoP=request.getParameter("apellidoPaterno"+i);
                apellidoM=request.getParameter("apellidoMaterno"+i);
                ContactoDAO.agregarContacto(contacto.getRutEmpleado(), numeroTelefonico, nombreContacto, apellidoP, apellidoM);
            }
                response.sendRedirect("MensajeOk.jsp?mensaje=Datos agregados<br>Para: &username="+contacto.getUsername());
        }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCargarContactos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCargarContactos at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ControladorCargarContactos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorCargarContactos.class.getName()).log(Level.SEVERE, null, ex);
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
