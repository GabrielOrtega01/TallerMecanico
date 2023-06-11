package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminReparacionDB extends Conexion implements CRUD {

    public AdminReparacionDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Reparacion objReparacion = (Reparacion) obj;
        try {
            String sql = "INSERT INTO reparacion(cantidad, mano_obra, observacion_ido, repuesto_idr, mecanico_idm2) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, objReparacion.getCantidad());
            preparedStatement.setInt(2, objReparacion.getMano_obra());
            preparedStatement.setInt(3, objReparacion.getObservacion_ido());
            preparedStatement.setInt(4, objReparacion.getRepuesto_idr());
            preparedStatement.setInt(5, objReparacion.getMecanico_idm2());

            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objReparacion.setIdrepa(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción de la reparacion fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar la reparacion: " + e.getMessage());
        }
        cerrarConexion();
        return objReparacion;

    }

    @Override
    public boolean actualizar(Object obj) {
        Reparacion objReparacion = (Reparacion) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE reparacion SET cantidad=?, mano_obra=?, observacion_ido=?, repuesto_idr=?, mecanico_idm2=? WHERE idrepa=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objReparacion.getCantidad());
            preparedStatement.setInt(2, objReparacion.getMano_obra());
            preparedStatement.setInt(3, objReparacion.getObservacion_ido());
            preparedStatement.setInt(4, objReparacion.getRepuesto_idr());
            preparedStatement.setInt(5, objReparacion.getMecanico_idm2());
            preparedStatement.setInt(6, objReparacion.getIdrepa());

            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
            System.out.println("La inserción de la cantidad fue exitosa. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar la cantidad: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Reparacion objReparacion = (Reparacion) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM reparacion WHERE idrepa=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objReparacion.getIdrepa());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar la reparacion: "+e.getMessage());
            System.out.println("Error al eliminar la reparacion: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override
    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Reparacion objReparacion;
        try {
            String sql = "SELECT * FROM reparacion ORDER BY idrepa ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objReparacion = new Reparacion();
                objReparacion.setIdrepa(resultSet.getInt("idrepa"));
                objReparacion.setCantidad(resultSet.getInt("cantidad"));
                objReparacion.setMano_obra(resultSet.getInt("mano_obra"));
                objReparacion.setObservacion_ido(resultSet.getInt("observacion_ido"));
                objReparacion.setRepuesto_idr(resultSet.getInt("repuesto_idr"));
                objReparacion.setMecanico_idm2(resultSet.getInt("mecanico_idm2"));

                rowsQuery.add(objReparacion);
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
        Reparacion objReparacion = (Reparacion) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM reparacion WHERE idrepa = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objReparacion.getIdrepa());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objReparacion.setIdrepa(resultSet.getInt("idrepa"));
                objReparacion.setCantidad(resultSet.getInt("cantidad"));
                objReparacion.setMano_obra(resultSet.getInt("mano_obra"));
                objReparacion.setObservacion_ido(resultSet.getInt("observacion_ido"));
                objReparacion.setRepuesto_idr(resultSet.getInt("repuesto_idr"));
                objReparacion.setMecanico_idm2(resultSet.getInt("mecanico_idm2"));
                flag = true;
            }
            if (!flag) {
                objReparacion.setIdrepa(0);
            }
            preparedStatement.close();
            System.out.println("La inserción de la reparacion fue exitosa. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar la reparacion: " + e.getMessage());
        }
        cerrarConexion();
        return objReparacion;
    }

    public List<Object> listarTodo2() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        ReparacionVista objReparacionVista;
        try {
            String sql = "Select idrepa, cantidad, mano_obra, observacion, repuesto, concat(nombre,\" \",apellido) as mecanico \n"
                        + "        from mecanico as m inner join\n"
                        + "  (Select * from observacion as o inner join \n"
                        + "  (Select * from reparacion as re inner join repuesto as r\n"
                        + "   on r.idr = re.repuesto_idr) as tabla1\n"
                        + "   on o.ido = tabla1.observacion_ido) as tabla2\n"
                        + " on m.idm = tabla2.mecanico_idm2\n"
                        + " ORDER BY idrepa ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objReparacionVista = new ReparacionVista();
                objReparacionVista.setIdrepa(resultSet.getInt("idrepa"));
                objReparacionVista.setCantidad(resultSet.getInt("cantidad"));
                objReparacionVista.setMano_obra(resultSet.getInt("mano_obra"));
                objReparacionVista.setObservacion(resultSet.getString("observacion"));
                objReparacionVista.setRepuesto(resultSet.getString("repuesto"));
                objReparacionVista.setMecanico(resultSet.getString("mecanico"));

                rowsQuery.add(objReparacionVista);
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
