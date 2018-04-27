<%-- 
    Document   : registroCliente
    Created on : 01-12-2016, 13:18:26
    Author     : ollidnanref
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Registro de Nuevos Clientes</title>
    </head>
    <body>
        
        <form name="formAgregarCliente" action="AgregarCliente">
            
            <h1>"Donde la Abuela" :: Registro</h1>
        
            <h3>Registro</h3>
            <table border="2">
                <tbody>
                    <tr>
                        <td>Rut</td>
                        <td><input type="text" name="rutCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Clave</td>
                        <td><input type="password" name="claveCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Confirmar Clave</td>
                        <td><input type="password" name="claveClienteAux" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombreCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Apellido Paterno</td>
                        <td><input type="text" name="apellidoPaternoCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Apellido Materno</td>
                        <td><input type="text" name="apellidoMaternoCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Dirección</td>
                        <td><input type="text" name="direccionCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Numeración</td>
                        <td><input type="text" name="numeracionCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td>Comuna</td>
                        <td>
                            <select name="comunaCliente">
                                <c:forEach var="comunas" items="${sessionScope.comunas}">                
                                    <option value="${comunas.codigo}">${comunas.nombre}</option> 
                                </c:forEach>
                            </select>

                        *</td>
                    </tr>
                    <tr>
                        <td>Telefono</td>
                        <td><input type="text" name="telefonoCliente" value="" size="25" />*</td>
                    </tr>
                    <tr>
                        <td><a href="inicio.jsp">Volver</a></td>
                        <td><input type="submit" value="Enviar" name="botonRegistrar" /></td>
                    </tr>
                </tbody>
            </table>
            
            <label name="mensaje" id="mensaje" for="mensaje">
                <c:out value="${sessionScope.mensajeError}" />
            </label>


        </body>
            
        </form>
        
        
</html>
