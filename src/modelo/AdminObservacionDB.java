package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class AdminObservacionDB extends Conexion implements CRUD {

    public AdminObservacionDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Observacion objObservacion = (Observacion) obj;
        try {
            String sql = "INSERT INTO observacion(observacion, fecha, hora, vehiculo_idv, mecanico_idm) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objObservacion.getObservacion());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objObservacion.getFecha()));
            preparedStatement.setTime(3, java.sql.Time.valueOf(objObservacion.getHora()));
            preparedStatement.setInt(4, objObservacion.getVehiculo_idv());
            preparedStatement.setInt(5, objObservacion.getMecanico_idm());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objObservacion.setIdo(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la observacion fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar la observacion: " + e.getMessage());
        }
        cerrarConexion();
        return objObservacion;

    }

    @Override
    public boolean actualizar(Object obj) {
        Observacion objObservacion = (Observacion) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE observacion SET observacion=?, fecha=?, hora=?, vehiculo_idv=?, mecanico_idm=? WHERE ido=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objObservacion.getObservacion());
            preparedStatement.setDate(2, java.sql.Date.valueOf(objObservacion.getFecha()));
            preparedStatement.setTime(3, java.sql.Time.valueOf(objObservacion.getHora()));
            preparedStatement.setInt(4, objObservacion.getVehiculo_idv());
            preparedStatement.setInt(5, objObservacion.getMecanico_idm());
            preparedStatement.setInt(6, objObservacion.getIdo());

            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
            System.out.println("La inserción de la observacion fue exitosa. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar la observacion: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Observacion objObservacion = (Observacion) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM observacion WHERE ido=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objObservacion.getIdo());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar la observacion: "+e.getMessage());
            System.out.println("Error al eliminar la observacion: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Observacion objObservacion;
        try {
            String sql = "SELECT * FROM observacion ORDER BY ido ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objObservacion = new Observacion();
                objObservacion.setIdo(resultSet.getInt("ido"));
                objObservacion.setObservacion(resultSet.getString("observacion"));
                objObservacion.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                objObservacion.setHora(resultSet.getTimestamp("hora").toLocalDateTime().toLocalTime());
                objObservacion.setVehiculo_idv(resultSet.getInt("vehiculo_idv"));
                objObservacion.setMecanico_idm(resultSet.getInt("mecanico_idm"));

                rowsQuery.add(objObservacion);
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
        Observacion objObservacion = (Observacion) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM observacion WHERE ido = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objObservacion.getIdo());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objObservacion.setIdo(resultSet.getInt("ido"));
                objObservacion.setObservacion(resultSet.getString("observacion"));
                objObservacion.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                objObservacion.setHora(resultSet.getTimestamp("hora").toLocalDateTime().toLocalTime());
                objObservacion.setVehiculo_idv(resultSet.getInt("vehiculo_idv"));
                objObservacion.setMecanico_idm(resultSet.getInt("mecanico_idm"));
                flag = true;
            }
            if (!flag) {
                objObservacion.setIdo(0);
            }
            preparedStatement.close();
            System.out.println("La inserción de la observacion fue exitosa. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar la observacion: " + e.getMessage());
        }
        cerrarConexion();
        return objObservacion;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        ObservacionVista objObservacionVista;
        try {
            String sql = "Select ido, observacion, fecha, hora, placa, concat(nombre,\" \",apellido) as mecanico from mecanico as m inner join\n"
                        + "  (Select * from vehiculo as v inner join observacion as o\n"
                        + "   on v.idv = o.vehiculo_idv) as tabla1\n"
                        + " on m.idm = tabla1.mecanico_idm	\n"
                        + " ORDER BY ido ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objObservacionVista = new ObservacionVista();
                objObservacionVista.setIdo(resultSet.getInt("ido"));
                objObservacionVista.setObservacion(resultSet.getString("observacion"));
                objObservacionVista.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                objObservacionVista.setHora(resultSet.getTimestamp("hora").toLocalDateTime().toLocalTime());
                objObservacionVista.setPlaca(resultSet.getString("placa"));
                objObservacionVista.setMecanico(resultSet.getString("mecanico"));

                rowsQuery.add(objObservacionVista);
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
