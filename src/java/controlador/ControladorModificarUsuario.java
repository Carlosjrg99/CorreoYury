/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.CargaDAO;
import dao.UsuarioDAO;
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

/**
 *
 * @author Carlo
 */
@WebServlet(name = "ControladorModificarUsuario", urlPatterns = {"/ControladorModificarUsuario"})
public class ControladorModificarUsuario extends HttpServlet {

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
        
        String password="";
        int numeroCargas=0;
        int contactoEmergencia=0;
        String opcion=request.getParameter("opcion");
        if(opcion.equals("Modificar"))
        {
            //Permite modificar algunos de sus datos en la BD a los trabajadores
            HttpSession sesion = request.getSession(true);
            Usuario user = (Usuario) sesion.getAttribute("usuario");
            contactoEmergencia = Integer.valueOf(request.getParameter("contactos"));
            password = request.getParameter("pass");
            numeroCargas = Integer.valueOf(request.getParameter("cargas"));
            UsuarioDAO.modificar(user, password);
            sesion.setAttribute("usuarioMod", UsuarioDAO.buscar(user.getUsername()));
            sesion.setAttribute("numeroCargasMod", numeroCargas);
            sesion.setAttribute("numeroContactosMod", contactoEmergencia);
            sesion.setAttribute("numeroTrabajosMod", 0);
            if(numeroCargas != 0 && contactoEmergencia == 0)
            {
                response.sendRedirect("AgregarCarga.jsp?rut="+user.getRutEmpleado());
            }
            else if(numeroCargas == 0 && contactoEmergencia != 0)
            {
                response.sendRedirect("AgregarContacto.jsp?rut="+user.getRutEmpleado());
            }
            else if(numeroCargas != 0 && contactoEmergencia != 0)
            {
                sesion.setAttribute("contactar", "contactar");
                response.sendRedirect("AgregarCarga.jsp?rut="+user.getRutEmpleado());
            }
            else
            {
                response.sendRedirect("MensajeOk.jsp?mensaje=Datos modificados, &username="+user.getUsername());
            }
        }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorModificarUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorModificarUsuario at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ControladorModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
