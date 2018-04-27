<%-- 
    Document   : agregarPedido
    Created on : 11-12-2016, 21:00:30
    Author     : ollidnanref
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página para agregar Pedido de Cliente</title>
    </head>
    <body>
        <div style="text-align:right">Bienvenido(a) <c:out value="${sessionScope.usuarioSesion.nombre}" /> <c:out value="${sessionScope.usuarioSesion.apPaterno}" /> <c:out value="${sessionScope.usuarioSesion.apMaterno}" />  - <a href="inicio.jsp">Cerrar Sesión</a></div>
        <hr>
        <form name="formAgregarPedido" action="AgregarPedido">
        
            <h1>"Donde la Abuela" :: Agregar Pedido :: Paso 1</h1>
            <h3>Agregar Pedido</h3>
            <table border="2">
                <tbody>
                    <tr>
                        <td>Plato</td>
                        <td>
                            <select name="plato">
                                <c:forEach var="platos" items="${sessionScope.platos}">                
                                    <option value="${platos.idPlato}">${platos.nombre} - $ ${platos.precio}</option> 
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Bebida</td>
                        <td>
                            <input type="radio" name="bebida" value="1" checked/>Mineral $ 700
                            <input type="radio" name="bebida" value="2" />Jugo $ 800
                            <input type="radio" name="bebida" value="3" />Malteada $ 1000
                        </td>
                    </tr>
                    <tr>
                        <td>A domicilio</td>
                        <td><input type="checkbox" name="despacho" value="1"/></td>
                    </tr>
                    <tr>
                        <td><a href="menuCliente.jsp">Volver</a></td>
                        <td><input type="submit" value="Paso 2" name="botonAgregarPedido" /></td>
                    </tr>
                </tbody>
            </table>
            
        </form>
    </body>
</html>
