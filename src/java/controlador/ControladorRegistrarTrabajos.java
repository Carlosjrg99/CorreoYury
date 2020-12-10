/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.TrabajoDAO;
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
import modelo.Trabajo;
import modelo.Usuario;

/**
 *
 * @author Carlo
 */
public class ControladorRegistrarTrabajos extends HttpServlet {

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
                String cargo;
                String empresa;
                String fechaInico;
                String fechaFin;
                HttpSession sesion = request.getSession(true);
                Usuario usuario = (Usuario) sesion.getAttribute("usuarioMod");
                int numTrabajos = (int) sesion.getAttribute("numeroTrabajosMod");
                for(int i = 1;i <= numTrabajos;i++) 
                {
                    cargo=request.getParameter("cargo"+i);
                    empresa=request.getParameter("empresa"+i);
                    fechaInico=request.getParameter("fechaInicio"+i);
                    fechaFin=request.getParameter("fechaFin"+i);
                    Trabajo trabajo = new Trabajo(0,usuario.getRutEmpleado(),cargo,empresa,fechaInico,fechaFin);
                    TrabajoDAO.agregar(trabajo);
                }
                response.sendRedirect("MensajeOk.jsp?mensaje=Datos agregados<br>Para: &username="+usuario.getUsername());
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorRegistrarTrabajos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorRegistrarTrabajos at " + request.getContextPath() + "</h1>");
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
            Logger.getLogger(ControladorRegistrarTrabajos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControladorRegistrarTrabajos.class.getName()).log(Level.SEVERE, null, ex);
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
