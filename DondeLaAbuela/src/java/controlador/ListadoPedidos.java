package controlador;

import dao.ListadoDAO;
import dao.PedidoDAO;
import dto.ClienteDTO;
import dto.ListadoDTO;
import dto.PedidoDTO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListadoPedidos", urlPatterns = {"/ListadoPedidos"})
public class ListadoPedidos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            ArrayList<ListadoDTO> listadoDTO = new ArrayList<>();
            
            ClienteDTO clienteDTO = (ClienteDTO)request.getSession().getAttribute("usuarioSesion");
            String rut = clienteDTO.getRut();
            
            ListadoDAO listadoDAO = new ListadoDAO();
            
            listadoDTO = listadoDAO.readAll(rut);
            
            request.getSession().setAttribute("listado", listadoDTO);
            request.getRequestDispatcher("listadoPedidos.jsp").forward(request, response);
            
        }catch (Exception ex) {
                Logger.getLogger(ListadoPedidos.class.getName()).log(Level.SEVERE, null, ex);
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
