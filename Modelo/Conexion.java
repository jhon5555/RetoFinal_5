package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //1. Atributo tipo connection
    Connection connection;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String cadenaConexion = "jdbc:mysql://localhost:3306/reto1_g53_bd";

    //2. Añadimos el constructor sin argumentos
    public Conexion() {
        //3. Inicializamos la variable connection
        //Intentamos hacer conexión mediante el bloque try catch
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(cadenaConexion, user, password);
            if (connection != null) {
                System.out.println("Conexión éxitosa con la base de datos");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en la conexión" + e);
        }
    }

    public void finalizarConexion() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                System.out.println(ex.getMessage()
                        + ". >>> Error de Desconexion!!");
            }
        }
    }

    //4. Crear función getConnection
    public Connection getConnection() {
        //Puede retornar el mensaje de que si se conecto o que no se pudo conectar
        return connection;
    }
}
