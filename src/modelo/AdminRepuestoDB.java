package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepuestoDB extends Conexion implements CRUD {

    public AdminRepuestoDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Repuesto objRepuesto = (Repuesto) obj;
        try {
            String sql = "INSERT INTO repuesto(repuesto,tipo_repuesto,preciounitario,iva) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objRepuesto.getRepuesto());
            preparedStatement.setString(2, objRepuesto.getTipo_repuesto());
            preparedStatement.setInt(3, objRepuesto.getPreciounitario());
            preparedStatement.setFloat(4, objRepuesto.getIva());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objRepuesto.setIdr(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del repuesto fue exitoso. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar el repuesto: " + e.getMessage());
        }
        cerrarConexion();
        return objRepuesto;

    }

    @Override
    public boolean actualizar(Object obj) {
        Repuesto objRepuesto = (Repuesto) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE repuesto SET repuesto=?,tipo_repuesto=?,preciounitario=?,iva=? WHERE idr=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objRepuesto.getRepuesto());
            preparedStatement.setString(2, objRepuesto.getTipo_repuesto());
            preparedStatement.setInt(3, objRepuesto.getPreciounitario());
            preparedStatement.setFloat(4, objRepuesto.getIva());
            preparedStatement.setInt(5, objRepuesto.getIdr());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el repuesto: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Repuesto objRepuesto = (Repuesto) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM repuesto WHERE idr=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRepuesto.getIdr());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar el repuesto: "+e.getMessage());
            System.out.println("Error al eliminar el repuesto: " + e.getMessage());
        }
        cerrarConexion();
        return flag;
        
    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Repuesto objRepuesto;
        try {
            String sql = "SELECT * FROM repuesto ORDER BY idr ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRepuesto = new Repuesto();
                objRepuesto.setIdr(resultSet.getInt("idr"));
                objRepuesto.setRepuesto(resultSet.getString("repuesto"));
                objRepuesto.setTipo_repuesto(resultSet.getString("tipo_repuesto"));
                objRepuesto.setPreciounitario(resultSet.getInt("preciounitario"));                
                objRepuesto.setIva(resultSet.getFloat("iva"));
                
                rowsQuery.add(objRepuesto);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos. "+e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
    
    @Override
    public Object listarUno(Object obj) {
        Connection conex = abrirConexion();
        Repuesto objRepuesto = (Repuesto) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM repuesto WHERE idr = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objRepuesto.getIdr());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objRepuesto.setIdr(resultSet.getInt("idr"));
                objRepuesto.setRepuesto(resultSet.getString("repuesto"));
                objRepuesto.setTipo_repuesto(resultSet.getString("tipo_repuesto"));
                objRepuesto.setPreciounitario(resultSet.getInt("preciounitario"));                
                objRepuesto.setIva(resultSet.getFloat("iva"));
                flag = true;
                     
            }
            if (!flag ){
                objRepuesto.setIdr(0);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Error al insertar el repuesto: " + e.getMessage());
        }
        cerrarConexion();
        return objRepuesto;
    }
}

