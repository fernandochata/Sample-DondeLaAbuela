package controlador;

import dao.ClienteDAO;
import dto.ClienteDTO;
import dto.ComunaDTO;
import dao.ComunaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AgregarCliente", urlPatterns = {"/AgregarCliente"})
public class AgregarCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String mensajeError = null;        
        boolean validar = true;
        String rut, clave, claveAux, nombre, apPaterno, apMaterno, direccion, comuna;
        int numeracion=0, telefono=0;
        //SIN VALIDACIONES
        rut = request.getParameter("rutCliente");
        clave = request.getParameter("claveCliente");
        claveAux = request.getParameter("claveClienteAux");
        nombre = request.getParameter("nombreCliente");
        apPaterno = request.getParameter("apellidoPaternoCliente");
        apMaterno = request.getParameter("apellidoMaternoCliente");
        direccion = request.getParameter("direccionCliente");
        comuna = request.getParameter("comunaCliente");
        try{
        numeracion = Integer.parseInt(request.getParameter("numeracionCliente"));
        telefono = Integer.parseInt(request.getParameter("telefonoCliente"));
        }catch(Exception ex){
            //VALIDACION DE Numeracion Y Telefono
            mensajeError = "Numeracion y Telefono deben ser numericos.";
            request.getSession().setAttribute("mensajeError", mensajeError);
            request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
        }
        
        //FIN CAPTURAR PARAMETROS
        
        
        //VALIDAR QUE TODOS LOS CAMPOS DE TEXTO TENGAN VALORES        
        if (rut.isEmpty()||clave.isEmpty()||nombre.isEmpty()||apPaterno.isEmpty()||apMaterno.isEmpty()||direccion.isEmpty()||comuna.isEmpty()) {
            validar = false;
            mensajeError = "Debe ingresar valores en todos los campos.";
        }
        
        //VALIDAR CAMPO claveCliente Y claveClienteAux SEAN IGUALES
        if(clave.compareTo(claveAux) != 0){
            validar = false;
            mensajeError = "Campos Clave y Confirmar Clave deben ser iguales.";
        }
        
        //VALIDAR EL MODULO 11 DEL RUT
        if(!validarDv(rut)){
            validar = false;
            mensajeError = "Rut ingresado no cumple el formato o Dígito verificador es incorrecto.";
        }

        if(validar){
            //TODAS LAS VALIDACIONES CORRECTAS
            ClienteDAO clienteDAO = new ClienteDAO();
            ClienteDTO clienteDTO = new ClienteDTO(rut, clave, nombre, apPaterno, apMaterno, direccion, numeracion, comuna, telefono);

            clienteDAO.create(clienteDTO);
        
            //LIMPIA EL MENSAJE DE ERROR DE LA PAGINA DE INICIO
            request.getSession().setAttribute("mensajeError", null);
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        }else{
            //MUESTRA EL MENSAJE DE ERROR Y DEVUELVE A LA PAGINA
            request.getSession().setAttribute("mensajeError", mensajeError);
            request.getRequestDispatcher("registroCliente.jsp").forward(request, response);
        }
    }

    public boolean validarDv(String rutDv){
        
        boolean isNumeric = false;
        
	    try {
                Integer.parseInt(rutDv.substring(0, rutDv.length()-2));
		isNumeric = true;
	    }finally{    
            //VALIDAR LARGO = 10 Ó 9
            //VALIDAR EL GUION
            //VALIDAR QUE ANTES DEL GUION SEA NUMERICO
            if((rutDv.length() == 9 || rutDv.length() == 10) && isNumeric && (rutDv.substring(rutDv.length()-2, rutDv.length()-1).equalsIgnoreCase("-") )){
                //DIVIDIR RUT EN RUT Y DV
                String rut = rutDv.substring(0, rutDv.length()-2);
                String dv = rutDv.substring(rutDv.length()-1, rutDv.length());
                
                //VALIDACION MODULO 11
                String rutAux = "";
                for (int x = rut.length() - 1; x >= 0; x--) {
                    rutAux = rutAux + rut.charAt(x);
                }

                int pivote = 2;
                int longitudCadena = rutAux.length();
                int cantidadTotal = 0;
                int b = 1;
                for (int i = 0; i < longitudCadena; i++) {
                    if (pivote == 8) {
                        pivote = 2;
                    }
                    int temporal = Integer.parseInt("" + rutAux.substring(i, b));
                    b++;
                    temporal *= pivote;
                    pivote++;
                    cantidadTotal += temporal;
                }
                cantidadTotal = 11 - cantidadTotal % 11;

                String dvAux = "";

                switch(cantidadTotal){
                     case 1:
                        dvAux = "1";
                        break;
                    case 2:
                        dvAux = "2";
                        break;
                    case 3:
                        dvAux = "3";
                        break;
                    case 4:
                        dvAux = "4";
                        break;
                    case 5:
                        dvAux = "5";
                        break;
                    case 6:
                        dvAux = "6";
                        break;
                    case 7:
                        dvAux = "7";
                        break;
                    case 8:
                        dvAux = "8";
                        break;
                    case 9:
                        dvAux = "9";
                        break;
                    case 10:
                        dvAux = "k";
                        break;
                    case 11:
                        dvAux = "0";
                        break;
                }
                //RETORNA VERDADERO SI DIGITO ES CORRECTO
                return dv.equalsIgnoreCase(dvAux);
                
            }else{
                //no tiene el largo adecuado
                return false;
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
