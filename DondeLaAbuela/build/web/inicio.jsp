<%-- 
    Document   : inicio
    Created on : 01-12-2016, 11:59:55
    Author     : ollidnanref
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Inicio</title>
    </head>
    <body>
        
        <form name="formIngreso" action="ValidarIngreso">
            
            <h1>"Donde la Abuela"</h1>
            <h3>Acceso</h3>
            <table border="2">
                <tbody>
                    <tr>
                        <td>Rut: </td>
                        <td><input type="text" name="rutCliente" value="" size="20" />*</td>
                    </tr>
                    <tr>
                        <td>Clave: </td>
                        <td><input type="password" name="claveCliente" value="" size="20" />*</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Enviar" name="botonEnviar" />
                            <label name="mensaje" id="mensaje" for="mensaje">
                                <c:out value="${sessionScope.mensajeError}" />
                            </label></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><a href="RegistroCliente">Regístrate</a></td>
                    </tr>
                </tbody>
            </table>
            
        </form>
        
    </body>
</html>
