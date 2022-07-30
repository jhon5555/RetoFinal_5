package Controlador;

import Modelo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CbSucursal { 
    Connection connection;
    Conexion conexion = new Conexion();
    Statement st;
    ResultSet rs;

    public CbSucursal() {
    }
    
    public ArrayList getListaSucursales(){
        System.out.println("Ingrese a la función getListaSucursales");
        ArrayList mListaSucursales = new ArrayList();
        Sucursal sucursal = null;
        String query = "SELECT idSucursal, nombreSucursal FROM `sucursal`;";
        try{
            connection = conexion.getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                sucursal = new Sucursal();
                //el idSucursal que devuelve la consulta select
                int idSucursal = rs.getInt("idSucursal");
                String nombreSucursal = rs.getString("nombreSucursal");
                sucursal.setIdSucursal(idSucursal);
                sucursal.setNombreSucursal(nombreSucursal);
                mListaSucursales.add(sucursal);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        System.out.println(mListaSucursales);
        return mListaSucursales;
    }
}
