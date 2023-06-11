package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    static Connection con = null;

    public static Connection abrirConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String urldb = "jdbc:mysql://localhost:3306/bdmecanico?serverTimezone=UTC";
            String usr = "root";
            String psw = "123";
            con = (Connection) DriverManager.getConnection(urldb, usr, psw);
            //System.out.println("¡¡¡La conexión fue exitosa !!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error >> Driver no Instalado!!");
        } catch (SQLException e) {
            System.out.println("Error >> de conexión con la BD");
        }
        return con;
    }

    public static void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
                //System.out.println("¡¡¡ La conexión cerró con éxito !!!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
