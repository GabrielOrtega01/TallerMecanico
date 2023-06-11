package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminVehiculoDB extends Conexion implements CRUD {

    public AdminVehiculoDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Vehiculo objVehiculo = (Vehiculo) obj;
        try {
            String sql = "INSERT INTO vehiculo (placa, marca, modelo, color, tipo, cliente_idc) VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objVehiculo.getPlaca());
            preparedStatement.setString(2, objVehiculo.getMarca());
            preparedStatement.setString(3, objVehiculo.getModelo());
            preparedStatement.setString(4, objVehiculo.getColor());
            preparedStatement.setString(5, objVehiculo.getTipo());
            preparedStatement.setInt(6, objVehiculo.getCliente_idc());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objVehiculo.setIdv(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del vehiculo fue exitoso. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar el vehiculo: " + e.getMessage());
        }
        cerrarConexion();
        return objVehiculo;

    }

    @Override
    public boolean actualizar(Object obj) {
        Vehiculo objVehiculo = (Vehiculo) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE vehiculo SET placa=?,marca=?,modelo=?,color=?,tipo=?,cliente_idc=? WHERE idv=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objVehiculo.getPlaca());
            preparedStatement.setString(2, objVehiculo.getMarca());
            preparedStatement.setString(3, objVehiculo.getModelo());
            preparedStatement.setString(4, objVehiculo.getColor());
            preparedStatement.setString(5, objVehiculo.getTipo());
            preparedStatement.setInt(6, objVehiculo.getCliente_idc());
            preparedStatement.setInt(7, objVehiculo.getIdv());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
            System.out.println("La inserción del vehiculo fue exitoso. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar el vehiculo: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Vehiculo objVehiculo = (Vehiculo) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM vehiculo WHERE idv=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objVehiculo.getIdv());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: "+e.getMessage());
            System.out.println("Error al eliminar el vehiculo: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Vehiculo objVehiculo;
        try {
            String sql = "SELECT * FROM vehiculo ORDER BY idv ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVehiculo = new Vehiculo();
                objVehiculo.setIdv(resultSet.getInt("idv"));
                objVehiculo.setPlaca(resultSet.getString("placa"));
                objVehiculo.setMarca(resultSet.getString("marca"));
                objVehiculo.setModelo(resultSet.getString("modelo"));
                objVehiculo.setColor(resultSet.getString("color"));
                objVehiculo.setTipo(resultSet.getString("tipo"));
                objVehiculo.setCliente_idc(resultSet.getInt("cliente_idc"));

                rowsQuery.add(objVehiculo);
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
        Vehiculo objVehiculo = (Vehiculo) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM vehiculo WHERE Idv = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objVehiculo.getIdv());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVehiculo.setIdv(resultSet.getInt("idv"));
                objVehiculo.setPlaca(resultSet.getString("placa"));
                objVehiculo.setMarca(resultSet.getString("marca"));
                objVehiculo.setModelo(resultSet.getString("modelo"));
                objVehiculo.setColor(resultSet.getString("color"));
                objVehiculo.setTipo(resultSet.getString("tipo"));
                objVehiculo.setCliente_idc(resultSet.getInt("cliente_idc"));
                flag = true;
            }
            if (!flag) {
                objVehiculo.setIdv(0);
            }
            preparedStatement.close();
            System.out.println("La inserción del vehiculo fue exitoso. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar el vehiculo: " + e.getMessage());
        }
        cerrarConexion();
        return objVehiculo;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        VehiculoVista objVehiculoVista;
        try {
            String sql = "Select idv, placa, marca, modelo, color, tipo, concat(nom,\" \",apelli) as cliente from \n"
                        + "vehiculo as v  inner join cliente as c\n"
                        + "   on c.idc = v.cliente_idc\n"
                        + " ORDER BY idv ASC;";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objVehiculoVista = new VehiculoVista();
                objVehiculoVista.setIdv(resultSet.getInt("idv"));
                objVehiculoVista.setPlaca(resultSet.getString("placa"));
                objVehiculoVista.setMarca(resultSet.getString("marca"));
                objVehiculoVista.setModelo(resultSet.getString("modelo"));
                objVehiculoVista.setColor(resultSet.getString("color"));
                objVehiculoVista.setTipo(resultSet.getString("tipo"));
                objVehiculoVista.setCliente(resultSet.getString("cliente"));

                rowsQuery.add(objVehiculoVista);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos. " + e.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }
}
