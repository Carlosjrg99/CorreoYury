<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>OK</title>
    </head>
    <body>
        <%
              String mensaje;
              String username;
              
              mensaje=request.getParameter("mensaje");
              username=request.getParameter("username");
              
              Usuario user=null;
              
              HttpSession sesion = request.getSession(true);
              user=(Usuario)sesion.getAttribute("usuario");
         %>
        
        
    <center>
        
        <h1>Bien!</h1>

        <h3> <%=mensaje+"<br><br>"+username%></h3>

        <br><br><br>
        <button onclick="goBack()">Volver</button>
        <script>
        function goBack() 
        {
            window.history.back();
        }
        </script>
        <br>
        <%
            switch(user.getTipoUsuario())
            {
                case 1:
                    out.println("<form action='menuRRHH.jsp'>");
                    out.println("<input type='submit' value='Menu'/>");
                    out.println("</form>");
                    break;
                case 2:
                    out.println("<form action='menuTrabajador.jsp'>");
                    out.println("<input type='submit' value='Menu'/>");
                    out.println("</form>");
                    break;
                default:
                    response.sendRedirect("CerrarSesion.jsp");
                    break;
            }
            if(user.getTipoUsuario()==1)
        {
        }%>
    </center>
</body>
</html>