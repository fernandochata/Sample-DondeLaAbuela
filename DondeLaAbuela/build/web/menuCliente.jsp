<%-- 
    Document   : menuCliente
    Created on : 01-12-2016, 13:48:05
    Author     : ollidnanref
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div style="text-align:right">Bienvenido(a) <c:out value="${sessionScope.usuarioSesion.nombre}" /> <c:out value="${sessionScope.usuarioSesion.apPaterno}" /> <c:out value="${sessionScope.usuarioSesion.apMaterno}" />  - <a href="inicio.jsp">Cerrar Sesión</a></div>
        <hr>
        <h1>"Donde la Abuela" :: Menú</h1>
        
        <h2><a href="NuevoPedido">Generar un Pedido</a></h2>
        
        <h2><a href="ListadoPedidos">Ver Mis Pedidos</a></h2>
        
    </body>
</html>
