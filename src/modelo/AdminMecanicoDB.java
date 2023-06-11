package modelo;

import dao.CRUD;
import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMecanicoDB extends Conexion implements CRUD {

    public AdminMecanicoDB() {
    }

    @Override
    public Object insertar(Object obj) {
        Connection conex = abrirConexion();
        Mecanico objMecanico = (Mecanico) obj;
        try {
            String sql = "INSERT INTO mecanico(documento, nombre, apellido, direccion, telefono, especialidad, nivel_educativo, experiencia, contrasena) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, objMecanico.getDocumento());
            preparedStatement.setString(2, objMecanico.getNombre());
            preparedStatement.setString(3, objMecanico.getApellido());
            preparedStatement.setString(4, objMecanico.getDireccion());
            preparedStatement.setString(5, objMecanico.getTelefono());
            preparedStatement.setString(6, objMecanico.getEspecialidad());
            preparedStatement.setString(7, objMecanico.getNivel_educativo());
            preparedStatement.setString(8, objMecanico.getExperiencia());
            preparedStatement.setString(9, objMecanico.getContrasena());
            
            preparedStatement.execute();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                objMecanico.setIdm(rs.getInt(1));
            }
            preparedStatement.close();

            System.out.println("La inserción del mecanico fue exitosa. ");
        } catch (SQLException e) {

            System.out.println("Error al insertar al mecanico: " + e.getMessage());
        }
        cerrarConexion();
        return objMecanico;

    }

    @Override
    public boolean actualizar(Object obj) {
        Mecanico objMecanico = (Mecanico) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "UPDATE mecanico SET documento=?,nombre=?,apellido=?,direccion=?,telefono=?,especialidad=?,nivel_educativo=?,experiencia=?,contrasena=? WHERE idm=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, objMecanico.getDocumento());
            preparedStatement.setString(2, objMecanico.getNombre());
            preparedStatement.setString(3, objMecanico.getApellido());
            preparedStatement.setString(4, objMecanico.getDireccion());
            preparedStatement.setString(5, objMecanico.getTelefono());
            preparedStatement.setString(6, objMecanico.getEspecialidad());
            preparedStatement.setString(7, objMecanico.getNivel_educativo());
            preparedStatement.setString(8, objMecanico.getExperiencia());
            preparedStatement.setString(9, objMecanico.getContrasena());
            preparedStatement.setInt(10, objMecanico.getIdm());

             int totalFilasAfectadas = preparedStatement.executeUpdate();
            if (totalFilasAfectadas > 0) {
                flag = true;
            }
            preparedStatement.close();
            System.out.println("La actualización del Mecanico fue exitoso. ");
        } catch (SQLException e) {
            System.out.println("Error al actualizar al Mecanico: " + e.getMessage());
        }
        return flag;
    }

    @Override
    public boolean eliminar(Object obj) {
        Mecanico objMecanico = (Mecanico) obj;
        boolean flag = false;
        Connection conex = abrirConexion();
        try {
            String sql = "DELETE FROM mecanico WHERE idm=?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMecanico.getIdm());
            int totalFilasafectadas = preparedStatement.executeUpdate();
            if (totalFilasafectadas > 0) {
                flag = true;
            }
            preparedStatement.close();

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error al eliminar al mecanico: "+e.getMessage());
            System.out.println("Error al eliminar al mecanico: " + e.getMessage());
        }
        cerrarConexion();
        return flag;

    }

    @Override

    public List<Object> listarTodo() {
        List<Object> rowsQuery = new ArrayList<Object>();
        Connection conex = abrirConexion();
        Mecanico objMecanico;
        try {
            String sql = "SELECT * FROM mecanico where especialidad != 'administrador' ORDER BY idm ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMecanico = new Mecanico();
                objMecanico.setIdm(resultSet.getInt("idm"));
                objMecanico.setDocumento(resultSet.getString("documento"));
                objMecanico.setNombre(resultSet.getString("nombre"));
                objMecanico.setApellido(resultSet.getString("apellido"));
                objMecanico.setDireccion(resultSet.getString("direccion"));
                objMecanico.setTelefono(resultSet.getString("telefono"));
                objMecanico.setEspecialidad(resultSet.getString("especialidad"));
                objMecanico.setNivel_educativo(resultSet.getString("nivel_educativo"));
                objMecanico.setExperiencia(resultSet.getString("experiencia"));
                objMecanico.setContrasena(resultSet.getString("contrasena"));

                rowsQuery.add(objMecanico);
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
        Mecanico objMecanico = (Mecanico) obj;
        boolean flag = false;
        try {
            String sql = "SELECT * FROM mecanico WHERE idm = ?";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setInt(1, objMecanico.getIdm());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objMecanico.setIdm(resultSet.getInt("idm"));
                objMecanico.setDocumento(resultSet.getString("documento"));
                objMecanico.setNombre(resultSet.getString("nombre"));
                objMecanico.setApellido(resultSet.getString("apellido"));
                objMecanico.setDireccion(resultSet.getString("direccion"));
                objMecanico.setTelefono(resultSet.getString("telefono"));
                objMecanico.setEspecialidad(resultSet.getString("especialidad"));
                objMecanico.setNivel_educativo(resultSet.getString("nivel_educativo"));
                objMecanico.setExperiencia(resultSet.getString("experiencia"));
                objMecanico.setContrasena(resultSet.getString("contrasena"));
                flag = true;
            }
            if (!flag ){
                objMecanico.setIdm(0);
            }
            preparedStatement.close();
            System.out.println("La inserción del mecanico fue exitoso. ");
        } catch (SQLException e) {
            System.out.println("Error al insertar al mecanico: " + e.getMessage());
        }
        cerrarConexion();
        return objMecanico;
    }

}
