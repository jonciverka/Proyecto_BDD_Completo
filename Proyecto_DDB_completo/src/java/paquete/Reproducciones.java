/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import db.dao.AdministradorDAO;
import db.dao.ArtistaDAO;
import db.dao.CancionDAO;
import db.dao.UsuarioDAO;
import db.entity.Administrador;
import db.entity.Artista;
import db.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Alfredo
 */
public class Reproducciones extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        CancionDAO cDAO = new CancionDAO();
        try {
            cDAO.incrementarReproducciones(id);
            int num = cDAO.recuperarNoReproducciones(id);
            if(num%10==0){
                out.print(1);
            }else{
                out.print(0);
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Reproducciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    

}
