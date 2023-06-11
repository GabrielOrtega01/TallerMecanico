package modelo;

import dao.Conexion;
import static dao.Conexion.abrirConexion;
import static dao.Conexion.cerrarConexion;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RelacionesDB extends Conexion {

    public RelacionesDB() {
    }

    public List<DatosPersonaVehiculo> consultarDatos(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        List<DatosPersonaVehiculo> rowsQuery = new ArrayList<DatosPersonaVehiculo>();
        Connection conex = abrirConexion();
        DatosPersonaVehiculo objDatPer;
        try {
            String sql = "Select concat(nom,\" \",apelli) as nombre, placa, marca, modelo, color, tipo, fecha from\n"
                        + "     (Select * from cliente as c inner join\n"
                        + "    (Select * from vehiculo as v inner join\n"
                        + "   (Select * from observacion as o inner join\n"
                        + "  (Select * from reparacion as r inner join factura as f\n"
                        + "  on r.idrepa=f.reparacion_idrepa) as tabla1\n"
                        + "   on o.ido = tabla1.observacion_ido) as tabla2\n"
                        + "	 on v.idv = tabla2.vehiculo_idv) as tabla3\n"
                        + "      on c.idc = tabla3.cliente_idc) as tabla4\n"
                        + "where fecha BETWEEN ? AND ?\n"
                        + "ORDER BY fecha ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setTimestamp(1, Timestamp.valueOf(fechaInicio));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(fechaFin));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDatPer = new DatosPersonaVehiculo();

                objDatPer.setNombre(resultSet.getString("nombre"));
                objDatPer.setPlaca(resultSet.getString("placa"));
                objDatPer.setMarca(resultSet.getString("marca"));
                objDatPer.setModelo(resultSet.getString("modelo"));
                objDatPer.setColor(resultSet.getString("color"));
                objDatPer.setTipo(resultSet.getString("tipo"));
                objDatPer.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime());

                rowsQuery.add(objDatPer);

            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<DatosMencanicoReparacion> ListaMecanicoReparacion(String modelo, String nivel, LocalDateTime fechaInicio2, LocalDateTime fechaFin2) {
        List<DatosMencanicoReparacion> rowsQuery = new ArrayList<DatosMencanicoReparacion>();
        Connection conex = abrirConexion();
        DatosMencanicoReparacion objDatosMencanicoReparacion;
        try {
            String sql = "Select concat(nombre,\" \",apellido) as mecanico, nivel_educativo, experiencia, fecha from\n"
                        + "     (Select * from cliente as c inner join\n"
                        + "    (Select * from vehiculo as v inner join\n"
                        + "   (Select * from mecanico as m inner join\n"
                        + "  (Select * from observacion as o inner join\n"
                        + " (Select * from reparacion as r inner join factura as f\n"
                        + "  on r.idrepa=f.reparacion_idrepa) as tabla1\n"
                        + "   on o.ido = tabla1.observacion_ido) as tabla2\n"
                        + "    on m.idm = tabla2.mecanico_idm2) as tabla3\n"
                        + "	 on v.idv = tabla3.vehiculo_idv) as tabla4\n"
                        + "      on c.idc = tabla4.cliente_idc) as tabla5\n"
                        + "where  modelo=? AND nivel_educativo = ? AND \n"
                        + "fecha BETWEEN ? AND ?\n"
                        + "ORDER BY fecha ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, modelo);
            preparedStatement.setString(2, nivel);
            preparedStatement.setTimestamp(3, Timestamp.valueOf(fechaInicio2));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(fechaFin2));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDatosMencanicoReparacion = new DatosMencanicoReparacion();

                objDatosMencanicoReparacion.setMecanico(resultSet.getString("mecanico"));
                objDatosMencanicoReparacion.setNivel_educativo(resultSet.getString("nivel_educativo"));
                objDatosMencanicoReparacion.setExperiencia(resultSet.getString("experiencia"));
                objDatosMencanicoReparacion.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime());

                rowsQuery.add(objDatosMencanicoReparacion);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<ListaRepuesto> consultarDatos3(String placa3, LocalDateTime fechaInicio3, LocalDateTime fechaFin3) {
        List<ListaRepuesto> rowsQuery = new ArrayList<ListaRepuesto>();
        Connection conex = abrirConexion();
        ListaRepuesto objListaRepuesto;
        try {
            String sql = "Select repuesto, cantidad, preciounitario, mano_obra, iva, sum(preciounitario*cantidad*iva+mano_obra) as total, fecha from\n"
                        + "    (Select * from vehiculo as v inner join\n"
                        + "   (Select * from mecanico as m inner join\n"
                        + "  (Select * from observacion as o inner join\n"
                        + " (Select * from reparacion as repa inner join repuesto as r\n"
                        + "  on r.idr = repa.repuesto_idr) as tabla1\n"
                        + "   on o.ido = tabla1.observacion_ido) as tabla2\n"
                        + "    on m.idm = tabla2.mecanico_idm2) as tabla3\n"
                        + "	 on v.idv = tabla3.vehiculo_idv) as tabla4\n"
                        + "where  placa=? AND fecha BETWEEN ? AND ?\n"
                        + "GROUP BY repuesto, cantidad, preciounitario, mano_obra, iva, fecha\n"
                        + "ORDER BY fecha ASC";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, placa3);
            preparedStatement.setTimestamp(2, Timestamp.valueOf(fechaInicio3));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(fechaFin3));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objListaRepuesto = new ListaRepuesto();

                objListaRepuesto.setRepuesto(resultSet.getString("repuesto"));
                objListaRepuesto.setCantidad(resultSet.getInt("cantidad"));
                objListaRepuesto.setPreciounitario(resultSet.getInt("preciounitario"));
                objListaRepuesto.setMano_obra(resultSet.getInt("mano_obra"));
                objListaRepuesto.setIva(resultSet.getFloat("iva"));
                objListaRepuesto.setTotal(resultSet.getBigDecimal("total").setScale(0, RoundingMode.HALF_UP));
                objListaRepuesto.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime());

                rowsQuery.add(objListaRepuesto);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos del repuesto: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<DatosDelMencanico> ListaMecanico() {
        List<DatosDelMencanico> rowsQuery = new ArrayList<DatosDelMencanico>();
        Connection conex = abrirConexion();
        DatosDelMencanico objDatosDelMencanico;
        try {
            String sql = "Select documento ,concat(nombre,\" \",apellido) as mecanico, direccion, telefono, especialidad,\n"
                        + " nivel_educativo, experiencia from mecanico ORDER BY mecanico ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDatosDelMencanico = new DatosDelMencanico();

                objDatosDelMencanico.setDocumento(resultSet.getString("documento"));
                objDatosDelMencanico.setMecanico(resultSet.getString("mecanico"));
                objDatosDelMencanico.setDireccion(resultSet.getString("direccion"));
                objDatosDelMencanico.setTelefono(resultSet.getString("telefono"));
                objDatosDelMencanico.setEspecialidad(resultSet.getString("especialidad"));
                objDatosDelMencanico.setNivel_educativo(resultSet.getString("nivel_educativo"));
                objDatosDelMencanico.setExperiencia(resultSet.getString("experiencia"));

                rowsQuery.add(objDatosDelMencanico);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<DatosDelMencanico> consultarDatos5(String documento) {
        List<DatosDelMencanico> rowsQuery = new ArrayList<DatosDelMencanico>();
        Connection conex = abrirConexion();
        DatosDelMencanico objDatosDelMencanico;
        try {
            String sql = " Select documento ,concat(nombre,\" \",apellido) as mecanico, direccion, telefono, especialidad,\n"
                        + " nivel_educativo, experiencia from mecanico where documento=?";

            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, documento);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                objDatosDelMencanico = new DatosDelMencanico();

                objDatosDelMencanico.setDocumento(resultSet.getString("documento"));
                objDatosDelMencanico.setMecanico(resultSet.getString("mecanico"));
                objDatosDelMencanico.setDireccion(resultSet.getString("direccion"));
                objDatosDelMencanico.setTelefono(resultSet.getString("telefono"));
                objDatosDelMencanico.setEspecialidad(resultSet.getString("especialidad"));
                objDatosDelMencanico.setNivel_educativo(resultSet.getString("nivel_educativo"));
                objDatosDelMencanico.setExperiencia(resultSet.getString("experiencia"));

                rowsQuery.add(objDatosDelMencanico);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos de la persona: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;
    }

    public List<LibretaRepuesto> ListaRepuestoUtilizado(String placa6) {
        List<LibretaRepuesto> rowsQuery = new ArrayList<LibretaRepuesto>();
        Connection conex = abrirConexion();
        LibretaRepuesto objLibretaRepuesto;
        try {
            String sql = "Select concat(nombre,\" \",apellido) as mecanico, placa, repuesto as libreta_repuestos_utilizados, mano_obra as costo_mano_de_obra, \n"
                        + " preciounitario, cantidad, iva, sum(preciounitario*cantidad*iva+mano_obra) as total, fecha, MAX(hora) as hora from (Select * from vehiculo as v inner join\n"
                        + "   (Select * from mecanico as m inner join\n"
                        + "  (Select * from observacion as o inner join\n"
                        + " (Select * from reparacion as repa inner join repuesto as r\n"
                        + "  on r.idr = repa.repuesto_idr) as tabla1\n"
                        + "   on o.ido = tabla1.observacion_ido) as tabla2\n"
                        + "    on m.idm = tabla2.mecanico_idm2) as tabla3\n"
                        + "	 on v.idv = tabla3.vehiculo_idv) as tabla4\n"
                        + "where  placa=?\n"
                        + "GROUP BY mecanico, placa, libreta_repuestos_utilizados, costo_mano_de_obra, preciounitario, cantidad, iva, fecha\n"
                        + "ORDER BY mecanico ASC";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setString(1, placa6);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                objLibretaRepuesto = new LibretaRepuesto();

                objLibretaRepuesto.setMecanico(resultSet.getString("mecanico"));
                objLibretaRepuesto.setPlaca(resultSet.getString("placa"));
                objLibretaRepuesto.setLibreta_repuestos_utilizados(resultSet.getString("libreta_repuestos_utilizados"));
                objLibretaRepuesto.setCosto_mano_de_obra(resultSet.getInt("costo_mano_de_obra"));
                objLibretaRepuesto.setPreciounitario(resultSet.getInt("preciounitario"));
                objLibretaRepuesto.setCantidad(resultSet.getInt("cantidad"));
                objLibretaRepuesto.setIva(resultSet.getFloat("iva"));
                objLibretaRepuesto.setTotal(resultSet.getBigDecimal("total").setScale(0, RoundingMode.HALF_UP));
                objLibretaRepuesto.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                objLibretaRepuesto.setHora(resultSet.getTimestamp("hora").toLocalDateTime().toLocalTime());

                rowsQuery.add(objLibretaRepuesto);
            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }

    public List<FacturaCliente> consultarFacturaCliente(LocalDate fecha, String placa) {
        List<FacturaCliente> rowsQuery = new ArrayList<FacturaCliente>();
        Connection conex = abrirConexion();
        FacturaCliente objFacturaCliente;
        try {
            String sql = "Select concat(nom,\" \",apelli) as cliente, doc as documento, direcc as direccion, correo,  \n"
                        + "placa, repuesto as libreta_repuestos_utilizados, sum(mano_obra) as costo_mano_de_obra, preciounitario,\n"
                        + "cantidad, iva, sum((preciounitario*cantidad+mano_obra)*iva) as total, fecha,  MAX(hora) as hora,\n"
                        + "concat(nombre,\" \",apellido) as mecanico, idf, administrador from\n"
                        + "   (Select * from cliente as c inner join (Select * from vehiculo as v inner join\n"
                        + "  (Select * from mecanico as m inner join (Select * from observacion as o inner join \n"
                        + " (Select * from factura as f inner join (Select * from reparacion as repa inner join \n"
                        + " repuesto as r on r.idr = repa.repuesto_idr) as tabla1\n"
                        + "  on f.reparacion_idrepa=tabla1.idrepa) as tabla2\n"
                        + "   on o.ido = tabla2.observacion_ido) as tabla3\n"
                        + "    on m.idm = tabla3.mecanico_idm2) as tabla4\n"
                        + "	 on v.idv = tabla4.vehiculo_idv) as tabla5\n"
                        + "      on c.idc = tabla5.cliente_idc) as tabla6 where fecha = ? and placa = ?\n"
                        + "      GROUP BY cliente, doc, direcc, correo, documento, placa, repuesto,mano_obra, preciounitario,\n"
                        + "      cantidad, iva,fecha, hora, mecanico, idf, administrador";
            PreparedStatement preparedStatement = (PreparedStatement) conex.prepareStatement(sql);
            preparedStatement.setDate(1, java.sql.Date.valueOf(fecha));
            preparedStatement.setString(2, placa);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                objFacturaCliente = new FacturaCliente();

                objFacturaCliente.setCliente(resultSet.getString("cliente"));
                objFacturaCliente.setDocumento(resultSet.getString("documento"));
                objFacturaCliente.setDireccion(resultSet.getString("direccion"));
                objFacturaCliente.setCorreo(resultSet.getString("correo"));
                objFacturaCliente.setPlaca(resultSet.getString("placa"));
                objFacturaCliente.setLibreta_repuestos_utilizados(resultSet.getString("libreta_repuestos_utilizados"));
                objFacturaCliente.setCosto_mano_de_obra(resultSet.getInt("costo_mano_de_obra"));
                objFacturaCliente.setPreciounitario(resultSet.getInt("preciounitario"));
                objFacturaCliente.setCantidad(resultSet.getInt("cantidad"));
                objFacturaCliente.setIva(resultSet.getFloat("iva"));
                objFacturaCliente.setTotal(resultSet.getBigDecimal("total").setScale(0, RoundingMode.HALF_UP));
                objFacturaCliente.setFecha(resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate());
                objFacturaCliente.setHora(resultSet.getTimestamp("hora").toLocalDateTime().toLocalTime());
                objFacturaCliente.setMecanico(resultSet.getString("mecanico"));
                objFacturaCliente.setIdf(resultSet.getInt("idf"));
                objFacturaCliente.setAdministrador(resultSet.getString("administrador"));

                rowsQuery.add(objFacturaCliente);

            }
            preparedStatement.close();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
            System.out.println("Error en la adquisición de datos: " + ex.getMessage());
        }
        cerrarConexion();
        return rowsQuery;

    }
}
