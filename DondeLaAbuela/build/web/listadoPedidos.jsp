<%-- 
    Document   : listadoPedidos
    Created on : 01-12-2016, 15:17:09
    Author     : ollidnanref
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de listado de Pedidos de Cliente</title>
    </head>
    <body>
        
        <div style="text-align:right">Bienvenido(a) <c:out value="${sessionScope.usuarioSesion.nombre}" /> <c:out value="${sessionScope.usuarioSesion.apPaterno}" /> <c:out value="${sessionScope.usuarioSesion.apMaterno}" />  - <a href="inicio.jsp">Cerrar Sesión</a></div>
        <hr>
        <h1>"Donde la Abuela" :: Mis Pedidos</h1>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Plato</th>
                    <th>Bebida</th>
                    <th>Entrega</th>
                    <th>Teléfono</th>
                    <th>Comuna</th>
                    <th>Ingreso</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                
                <c:forEach var="listado" items="${sessionScope.listado}">
                    <tr>
                        <td>${listado.codigo}</td>
                        <td>${listado.plato}</td>
                        <td>${listado.bebida}</td>
                        <td>${listado.entrega}</td>
                        <td>${listado.telefono}</td>
                        <td>${listado.comuna}</td>
                        <td>${listado.ingreso}</td>
                        <td>$ ${listado.total}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="menuCliente.jsp">Volver</a>
    </body>
</html>
