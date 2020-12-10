<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hasta Luego</title>
    </head>
    <body bgcolor="yellow">
        
        <%
            
               HttpSession sesion = request.getSession(true);
        
                sesion.setAttribute("usuario", null);
                sesion.setAttribute("estadoSesion", "off");
                sesion.invalidate();   
            
            %>
        
        
        <br><br><br>
        <center><h1>Fin de la sesión</h1></center>
        <br><br><br>
        <center><a href='index.jsp'>Inicio</a></center>
    </body>
</html>