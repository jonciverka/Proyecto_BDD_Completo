
package db.dao;

import db.connection.Conexion;
import db.entity.DatosPago;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatosPagoDAO {
    
    public DatosPagoDAO(){}
    
    public void agregarDatosPago(DatosPago dp) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "insert into datospago values(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, dp.getIdDatosPago());
        pS.setString(2, dp.getNombre());
        pS.setString(3, dp.getApellidoP());
        pS.setString(4, dp.getApellidoM());
        pS.setString(5, dp.getNoTarjeta());
        pS.setString(6, dp.getFechaVenc());
        pS.setInt(7, dp.getIdUsuario());
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public DatosPago buscardatosPago(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "select * from DatosPago where idDatos = ?";
        PreparedStatement pS;
        ResultSet rS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1, id);
        rS = pS.executeQuery();
        conector.getConect().commit();
        return rS.next()
                ? new DatosPago(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5), rS.getString(6), rS.getInt(7))
                : null;
    }
    
    public void eliminarDatosPago(int id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector  = new Conexion();
        String query = "delete from datospago where iddatos=?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(1,id);
        pS.execute();
        conector.getConect().commit();
        conector.cerrarConexion();
    }
    
    public void actualizarDatosPago(DatosPago dp) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Conexion conector = new Conexion();
        String query = "UPDATE usuario SET Nomrbre=?, apellido_p=?, apellido_m=?, noTarjeta=?, fechavenc=?, idUsuario=?   WHERE idDatos = ?";
        PreparedStatement pS;
        conector.setBd("proyecto_DDB");
        conector.abrirConexion();
        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);
        pS.setInt(7, dp.getIdDatosPago());
        pS.setString(1, dp.getNombre());
        pS.setString(2, dp.getApellidoP());
        pS.setString(3, dp.getApellidoM());
        pS.setString(4, dp.getNoTarjeta());
        pS.setString(5, dp.getFechaVenc());
        pS.setInt(6, dp.getIdUsuario());
        pS.execute();
        conector.getConect().commit();
    }
    
    public List<DatosPago> getDatosPagos() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Conexion conector = new Conexion();
        String query = "SELECT * FROM DatosPago ORDER BY idDatos";
        PreparedStatement pS;
        ResultSet rS;

        conector.setBd("proyecto_DDB");
        conector.abrirConexion();

        pS = conector.getConect().prepareStatement(query);
        conector.getConect().setAutoCommit(false);

        rS = pS.executeQuery();
        conector.getConect().commit();

        List<DatosPago> lista = new ArrayList<>();
        while (rS.next()) {
            lista.add(new DatosPago(rS.getInt(1), rS.getString(2), rS.getString(3), rS.getString(4), rS.getString(5), rS.getString(6), rS.getInt(7)));
        }
        return lista;
    }
}
