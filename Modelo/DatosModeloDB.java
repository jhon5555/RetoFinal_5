package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatosModeloDB {

    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    ArrayList list = new ArrayList();
    DatosSucursalPuestoTrabajo datosDB;

    public ArrayList<DatosSucursalPuestoTrabajo> getPuestosTrabajo(int idSucursal) {
        System.out.println("Ingreso a getPuestosTrabajo");
        ArrayList listPuestosTrabajo = new ArrayList();
        String query = "SELECT `idPuestoTrabajo`, `nombrePuestoTrabajo`, `salario`, `FK_idSucursal` FROM puestotrabajo INNER JOIN sucursal ON (sucursal.idSucursal = puestotrabajo.FK_idSucursal) WHERE sucursal.idSucursal= ?;";
        try {
            connection = conexion.getConnection();
            pst = connection.prepareStatement(query);
            pst.setInt(1, idSucursal);
            rs = pst.executeQuery();
            while (rs.next()) {
                datosDB = new DatosSucursalPuestoTrabajo();
                int idPuestoTrabajo = rs.getInt("idPuestoTrabajo");
                String nombrePuestoTrabajo = rs.getString("nombrePuestoTrabajo");
                float salario = rs.getFloat("salario");
                datosDB.setIdPuestoTrabajo(idPuestoTrabajo);
                datosDB.setNombrePuestoTrabajo(nombrePuestoTrabajo);
                datosDB.setSalario(salario);
                listPuestosTrabajo.add(datosDB);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("Puestos de trabajo" + listPuestosTrabajo);
        return listPuestosTrabajo;
    }

    public ArrayList<DatosSucursalPuestoTrabajo> getSucursales() {
        ArrayList listaSucursales = new ArrayList();
        String query = "SELECT `idSucursal`, `nombreSucursal` FROM `sucursal`;";
        try {
            connection = conexion.getConnection();
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                datosDB = new DatosSucursalPuestoTrabajo();
                int idSucursalC = rs.getInt("idSucursal");
                String nombreSucursal = rs.getString("nombreSucursal");
                datosDB.setIdSucursal(idSucursalC);
                datosDB.setNombreSucursal(nombreSucursal);
                listaSucursales.add(datosDB);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        System.out.println("Sucursales: " + listaSucursales);
        return listaSucursales;
    }
}
