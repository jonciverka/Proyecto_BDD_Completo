/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import db.Conexion;
import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author OmarNori
 */
public class Disminuir extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Conexion c = new Conexion();
            int juguete = Integer.parseInt(request.getParameter("idJuguete"));
            Conexion conexion = new Conexion();
            Connection con = conexion.getConexion();
            Statement state = con.createStatement();
            String sql = "UPDATE juguete_has_sucursal set existencia = existencia - 1 where sucursal_idsucursal = 3 "
                    + "and juguete_idjuguete = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, juguete);
            ps.execute();
            response.sendRedirect("index.html");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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
