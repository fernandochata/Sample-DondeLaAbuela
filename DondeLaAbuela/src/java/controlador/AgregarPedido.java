package controlador;

import dao.BebidaDAO;
import dao.PlatoDAO;
import dto.BebidaDTO;
import dto.ClienteDTO;
import dto.PedidoDTO;
import dto.PlatoDTO;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AgregarPedido", urlPatterns = {"/AgregarPedido"})
public class AgregarPedido extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ClienteDTO clienteDTO = (ClienteDTO)request.getSession().getAttribute("usuarioSesion");
            String rut = clienteDTO.getRut();
             
            int plato = Integer.parseInt(request.getParameter("plato"));
            int bebida = Integer.parseInt(request.getParameter("bebida"));
            String despachoAux = request.getParameter("despacho");
            int despacho = 0;
            if (despachoAux != null) {
                despacho = 1;
            }
            
            PedidoDTO pedidoDTO = new PedidoDTO();

            PlatoDTO platoDTO = new PlatoDTO();
            PlatoDAO platoDAO = new PlatoDAO();
            platoDTO = platoDAO.read(plato);

            BebidaDTO bebidaDTO = new BebidaDTO();
            BebidaDAO bebidaDAO = new BebidaDAO();
            bebidaDTO = bebidaDAO.read(bebida);

            int total = platoDTO.getPrecio() + bebidaDTO.getPrecio();

            Date fecha = new Date();
            
            int ano = fecha.getYear() + 1900;
            int mes = fecha.getMonth() + 1;
            int dia = fecha.getDate();
            int hora = fecha.getHours();
            int minuto = fecha.getMinutes();
            int segundo = fecha.getSeconds();
            
            String fechaHora = dia + "-" + mes + "-" + ano + " " + hora + ":" + minuto + ":" + segundo;

            
            pedidoDTO.setRutCliente(rut);
            pedidoDTO.setPlato(plato);
            pedidoDTO.setBebida(bebida);
            pedidoDTO.setDespacho(despacho);
            pedidoDTO.setTotal(total);
            pedidoDTO.setFechaHora(fechaHora);

            request.getSession().setAttribute("plato", platoDTO);
            request.getSession().setAttribute("bebida", bebidaDTO);
            request.getSession().setAttribute("pedido", pedidoDTO);

            request.getRequestDispatcher("confirmarPedido.jsp").forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(AgregarPedido.class.getName()).log(Level.SEVERE, null, ex);
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
