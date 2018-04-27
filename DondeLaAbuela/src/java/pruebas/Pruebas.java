/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import dao.ListadoDAO;
import dto.ListadoDTO;
import java.util.ArrayList;

public class Pruebas {

    public static void main(String[] args) {
        
        ListadoDAO listadoDAO = new ListadoDAO();
        ArrayList<ListadoDTO> listadoDTO = new ArrayList<>();
        
        listadoDTO = listadoDAO.readAll("22042308-5");
        
        System.out.println(listadoDTO.get(1).getIngreso());
    }
    
}
