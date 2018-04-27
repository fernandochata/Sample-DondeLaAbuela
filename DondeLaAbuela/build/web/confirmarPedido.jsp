<%-- 
    Document   : confirmarPedido
    Created on : 01-12-2016, 15:09:49
    Author     : ollidnanref
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página para confirmar Pedido de Cliente</title>
    </head>
    <body>
        <div style="text-align:right">Bienvenido(a) <c:out value="${sessionScope.usuarioSesion.nombre}" /> <c:out value="${sessionScope.usuarioSesion.apPaterno}" /> <c:out value="${sessionScope.usuarioSesion.apMaterno}" />  - <a href="inicio.jsp">Cerrar Sesión</a></div>
        <hr>
        
        <form name="formGenerarPedido" action="GenerarPedido">
            
            <h1>"Donde la Abuela" :: Agregar Pedido :: Paso 2</h1>

            <h3>Confirmar Pedido</h3>

            <table border="2">
                <tbody>
                    <tr>
                        <td>${sessionScope.plato.nombre}</td>
                        <td>$ ${sessionScope.plato.precio}</td>
                    </tr>
                    <tr>
                        <td>${sessionScope.bebida.nombre}</td>
                        <td>$ ${sessionScope.bebida.precio}</td>
                    </tr>
                    <tr>
                        <td>A domicilio</td>
                        
                        <td>
                            <c:choose> 
                            <c:when test="${sessionScope.pedido.despacho == 1}">
                                Si
                            </c:when>
                            <c:otherwise>
                                No
                            </c:otherwise>
                            </c:choose>
                        </td>
                        
                        
                    </tr>
                    <tr>
                        <td>Total</td>
                        <td>$ ${sessionScope.pedido.total}</td>
                    </tr>
                    <tr>
                        <td><a href="agregarPedido.jsp">Volver</a></td>
                        <td><input type="submit" value="Generar Pedido" name="botonAgregarPedido" /></td>
                    </tr>
                </tbody>
            </table>    
            
        </form>
        
        <h3><a href="menuCliente.jsp">Ir al Menú</a></h3>
    </body>
</html>
