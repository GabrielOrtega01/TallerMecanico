package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminFacturaDB extends Conexion implements CRUD {

    public AdminFacturaDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Factura objFactura = (Factura) obj;
        try {
            String sql = "INSERT INTO factura(administrador, reparacion_idrepa) VALUES(?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objFactura.getAdministrador());
            preparedStatement.setInt(2, objFactura.getReparacion_idrepa());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objFactura.setIdf(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la factura fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar la factura: " + e.getMessage());
        }
        cerrarConexion();
        return objFactura;

    }

    @Override
    public boolean actualizar(Object obj) {
        Factura objFactura = (Factura) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE factura SET administrador=?, reparacion_idrepa=? WHERE idf=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objFactura.getAdministrador());
            preparedStatement.setInt(2, objFactura.getReparacion_idrepa());
            preparedStatement.setInt(3, objFactura.getIdf());
            
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
            System.out.println("La inserción de la factura fue exitosa. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar la factura: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Factura objFactura = (Factura) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM factura WHERE idf=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objFactura.getIdf());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar la factura: "+e.getMessage());
            System.out.println("Error al eliminar la factura: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Factura objFactura;
        try {
            String sql = "SELECT * FROM factura ORDER BY idf ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objFactura = new Factura();
                objFactura.setIdf(resultSet.getInt("idf"));
                objFactura.setAdministrador(resultSet.getString("administrador"));
                objFactura.setReparacion_idrepa(resultSet.getInt("reparacion_idrepa"));
           
                rowsQuery.add(objFactura);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos. " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Factura objFactura = (Factura) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM factura WHERE idf = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objFactura.getIdf());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objFactura.setIdf(resultSet.getInt("idf"));
                objFactura.setAdministrador(resultSet.getString("administrador"));
                objFactura.setReparacion_idrepa(resultSet.getInt("reparacion_idrepa"));
                flag = true;
            }
            if (!flag) {
                objFactura.setIdf(0);
            }
            preparedStatement.close();
            System.out.println("La inserción de la factura fue exitosa. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar la factura: " + e.getMessage());
        }
        cerrarConexion();
        return objFactura;
    }
}
