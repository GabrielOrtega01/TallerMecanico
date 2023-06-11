package tallerMecanico;

import dao.Conexion;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;
import modelo.AdminClienteDB;
import modelo.Cliente;
import modelo.AdminVehiculoDB;
import modelo.Vehiculo;
import modelo.AdminMecanicoDB;
import modelo.Mecanico;
import modelo.AdminRepuestoDB;
import modelo.Repuesto;
import modelo.AdminObservacionDB;
import modelo.Observacion;
import modelo.AdminReparacionDB;
import modelo.Reparacion;
import modelo.AdminFacturaDB;
import modelo.Factura;
import modelo.DatosDelMencanico;
import modelo.DatosMencanicoReparacion;
import modelo.DatosPersonaVehiculo;
import modelo.FacturaCliente;
import modelo.LibretaRepuesto;
import modelo.ListaRepuesto;
import modelo.RelacionesDB;
import vistas.FrmDiagLogin;
import vistas.FrmPrincipalAdministrador;

public class Principal {

    public static void main(String[] args) {
        FrmDiagLogin objFrmDiagLogin = new FrmDiagLogin(null,true);
        objFrmDiagLogin.setLocationRelativeTo(null);
        objFrmDiagLogin.setVisible(true);
        //*********** Clases Administradoras **********//
        /* AdminClienteDB objAdmClienteDB = new AdminClienteDB();
        AdminRepuestoDB objAdmRepuestoDB = new AdminRepuestoDB();
        AdminVehiculoDB objAdmVehiculoDB = new AdminVehiculoDB();
        AdminMecanicoDB objAdmMecanicoDB = new AdminMecanicoDB();
        AdminObservacionDB objAdmObservacionDB = new AdminObservacionDB();
        AdminReparacionDB objAdmReparacionDB = new AdminReparacionDB();
        AdminFacturaDB objAdmFacturaDB = new AdminFacturaDB();*/
        //--------------------------------------------//

        //********** Variables Lectoras de consola ********//
        /* Scanner leerOpcion = new Scanner(System.in);
        Scanner leerTexto = new Scanner(System.in);
        Scanner leerNumero = new Scanner(System.in);*/
        //-------------------------------------------------//
        //********** Otras Variales **********//        
        /* String opcion = "",
                    opcionCliente = "",
                    opcionVehiculo = "",
                    opcionMecanico = "",
                    opcionRepuesto = "",
                    opcionObservacion = "",
                    opcionReparacion = "",
                    opcionFactura = "",
                    opcionReporte = "";
        //------------------------------------------------//

        boolean salir = false,
                    salirCliente = false,
                    salirVehiculo = false,
                    salirMecanico = false,
                    salirRepuesto = false,
                    salirObservacion = false,
                    salirReparacion = false,
                    salirFactura = false,
                    salirReporte = false;
        //------------------------------------------------//
         *//*
        while (!salir) {
            opcion = "";
            System.out.println("\n---- MENÚ PRINCIPAL ----\n");
            System.out.println("1. Administrar Cliente");
            System.out.println("2. Administrar Vehículo");
            System.out.println("3. Administrar Mecanico");
            System.out.println("4. Administrar Repuesto");
            System.out.println("5. Administrar Observacion");
            System.out.println("6. Administrar Reparacion");
            System.out.println("7. Administrar Factura");
            System.out.println("8. Reportes");
            System.out.println("9. Salir");
            System.out.print("\nIngrese opción: ");
            opcion = leerOpcion.nextLine();

            switch (opcion) {
                case "1"://1. Administrar vehículos
                    while (!salirCliente) {
                        opcionCliente = "";
                        System.out.println("\n---- ADMINISTRAR CLIENTE ----\n");
                        System.out.println("1. Agregar cliente");
                        System.out.println("2. Mostrar todo los clientes");
                        System.out.println("3. Mostrar un solo cliente");
                        System.out.println("4. Actualizar cliente");
                        System.out.println("5. Eliminar cliente");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionCliente = leerOpcion.nextLine();

                        switch (opcionCliente) {
                            case "1":  //1. Agregar Cliente
                                System.out.println("\n|=========> Insertar Cliente <==========|\n");

                                Cliente objCliente = new Cliente();

                                System.out.print("\nIngrese el documento del cliente: ");
                                objCliente.setDoc(leerTexto.nextLine());

                                System.out.print("\nIngrese el nombre del cliente: ");
                                objCliente.setNom(leerTexto.nextLine());

                                System.out.print("\nIngrese el apellido del cliente: ");
                                objCliente.setNom(leerTexto.nextLine());

                                System.out.print("\nIngrese la direccion del cliente: ");
                                objCliente.setDirecc(leerTexto.nextLine());

                                System.out.print("\nIngrese el correo del cliente: ");
                                objCliente.setCorreo(leerTexto.nextLine());

                                objAdmClienteDB.insertar(objCliente);
                                break;
                            case "2": //2. Mostrar todos los clientes:
                                System.out.println("\n|=========> Listar Clientes <==========|\n");
                                
                                for (Object obj : objAdmClienteDB.listarTodo()) {
                                    Cliente objCliente1 = (Cliente) obj;
                                    System.out.println(objCliente1);
                                }
                                break;
                            case "3": //3. Mostrar un solo cliente:
                                System.out.println("\n|=========> Leer Cliente <==========|\n");

                                Cliente objCliente2 = new Cliente();

                                System.out.print("Ingrese el id del cliente: ");
                                objCliente2.setIdc(leerNumero.nextInt());

                                objAdmClienteDB.listarUno(objCliente2);

                                System.out.println(objCliente2);
                                break;
                            case "4": // Actualizar una cliente:
                                System.out.println("\n|=========> Actualizar Cliente <==========|\n");

                                Cliente objCliente3 = new Cliente();

                                System.out.print("Digite el id del cliente a actualizar: ");
                                objCliente3.setIdc(leerNumero.nextInt());

                                // Buscar el cliente en la base de datos
                                objCliente3 = (Cliente) objAdmClienteDB.listarUno(objCliente3);

                                if (objCliente3.getIdc() == 0) {
                                    System.out.println("El cliente no existe.");
                                } else {
                                    // Mostrar información del cliente antes de actualizar
                                    System.out.println("Cliente actual:");
                                    System.out.println("ID: " + objCliente3.getIdc());
                                    System.out.println("Documento: " + objCliente3.getDoc());
                                    System.out.println("Nombre: " + objCliente3.getNom());
                                    System.out.println("Apellido: " + objCliente3.getApelli());
                                    System.out.println("Dirección: " + objCliente3.getDirecc());
                                    System.out.println("Correo: " + objCliente3.getCorreo());

                                    // Pedir al usuario el nuevo documento del cliente
                                    System.out.print("Digite el nuevo documento del cliente: ");
                                    String nuevoCliente = leerNumero.next();

                                    // Pedir al usuario el nuevo nombre del cliente
                                    System.out.print("Digite el nuevo nombre del cliente: ");
                                    String nuevoCliente1 = leerNumero.next();

                                    // Pedir al usuario el nuevo apellido del cliente
                                    System.out.print("Digite el nuevo apellido del cliente: ");
                                    String nuevoCliente2 = leerNumero.next();

                                    // Pedir al usuario la nueva dirección del cliente
                                    System.out.print("Digite la nueva dirección del cliente: ");
                                    String nuevoCliente3 = leerNumero.next();

                                    // Pedir al usuario el nueva correo del cliente
                                    System.out.print("Digite el nuevo correo del cliente: ");
                                    String nuevoCliente4 = leerNumero.next();

                                    // Actualizar el cliente en la base de datos
                                    objCliente3.setDoc(nuevoCliente);
                                    objCliente3.setNom(nuevoCliente1);
                                    objCliente3.setApelli(nuevoCliente2);
                                    objCliente3.setDirecc(nuevoCliente3);
                                    objCliente3.setCorreo(nuevoCliente4);

                                    if (objAdmClienteDB.actualizar(objCliente3)) {
                                        System.out.println("Cliente actualizado exitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar al cliente.");
                                    }
                                }

                                break;
                            case "5":  //5. Eliminar un Cliente:
                                System.out.println("\n|=========> Eliminar Cliente <==========|\n");

                                Cliente objCliente4 = new Cliente();

                                System.out.print("\nIngrese el id del cliente: ");
                                objCliente4.setIdc(leerNumero.nextInt());

                                if (objAdmClienteDB.eliminar(objCliente4)) {
                                    System.out.println("El cliente se eliminó con exito.");
                                } else {
                                    System.out.println("Error al eliminar el cliente.");
                                }
                                break;
                            case "6": //6. Salir
                                salirCliente = true;
                                break;
                            default:
                                System.out.println("\nCliente - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirCliente = false;
                    break;
                case "2"://2. Administrar vehículo
                    
                    while (!salirVehiculo) {
                        opcionVehiculo = "";
                        System.out.println("\n---- ADMINISTRAR VEHICULO ----\n");
                        System.out.println("1. Agregar vehículo");
                        System.out.println("2. Mostrar todas los vehículos");
                        System.out.println("3. Mostrar un sola vehículo");
                        System.out.println("4. Actualizar vehículo");
                        System.out.println("5. Eliminar vehículo");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionVehiculo = leerOpcion.nextLine();

                        switch (opcionVehiculo) {
                            case "1":  //1. Agregar vehículo
                                System.out.println("\n|=========> Insertar Vehículo <==========|\n");

                                Vehiculo objVehiculo = new Vehiculo();

                                System.out.print("\nIngrese la placa del vehículo: ");
                                objVehiculo.setPlaca(leerTexto.nextLine());

                                System.out.print("\nIngrese la marca del vehículo: ");
                                objVehiculo.setMarca(leerTexto.nextLine());

                                System.out.print("\nIngrese la modelo del vehículo: ");
                                objVehiculo.setModelo(leerTexto.nextLine());

                                System.out.print("\nIngrese el color del vehículo: ");
                                objVehiculo.setColor(leerNumero.nextLine());

                                System.out.print("\nIngrese el tipo de vehículo: ");
                                objVehiculo.setTipo(leerNumero.nextLine());

                                System.out.print("\nIngrese el Cliente_idc del vehículo: ");
                                objVehiculo.setCliente_idc(leerNumero.nextInt());

                                objAdmVehiculoDB.insertar(objVehiculo);
                                break;
                            case "2": //2. Mostrar todos los vehículos:
                                System.out.println("\n|=========> Listar Vehículos <==========|\n");
                                
                                for (Object obj : objAdmVehiculoDB.listarTodo()) {
                                    Vehiculo objVehiculo1 = (Vehiculo) obj;
                                    System.out.println(objVehiculo1);
                                }
                                break;
                            case "3": //3. Mostrar un solo vehículo:
                                System.out.println("\n|=========> Leer Vehículo <==========|\n");

                                Vehiculo objVehiculo2 = new Vehiculo();

                                System.out.print("Ingrese el id del vehículo: ");
                                objVehiculo2.setIdv(leerNumero.nextInt());

                                objAdmVehiculoDB.listarUno(objVehiculo2);

                                System.out.println(objVehiculo2);
                                break;
                            case "4":  //4. Actualizar un vehículo:
                                System.out.println("\n|=========> Actualizar Vehículo <==========|\n");

                                Vehiculo objVehiculo3 = new Vehiculo();

                                System.out.print("Digite el id del vehículo a actualizar: ");
                                objVehiculo3.setIdv(leerNumero.nextInt());
                                
                                // Buscar el cliente en la base de datos
                                objVehiculo3 = (Vehiculo) objAdmVehiculoDB.listarUno(objVehiculo3);
                                if (objVehiculo3.getIdv() == 0) {
                                    System.out.println("La vehículo no existe.");
                                } else {
                                    // Mostrar información de la vehículo antes de actualizar
                                    System.out.println("vehículo actual:");
                                    System.out.println("ID: " + objVehiculo3.getIdv());
                                    System.out.println("Placa: " + objVehiculo3.getPlaca());
                                    System.out.println("Marca: " + objVehiculo3.getMarca());
                                    System.out.println("Modelo: " + objVehiculo3.getModelo());
                                    System.out.println("Color: " + objVehiculo3.getColor());
                                    System.out.println("Tipo: " + objVehiculo3.getTipo());
                                    System.out.println("Cliente_idc: " + objVehiculo3.getCliente_idc());

                                    // Pedir al usuario el nueva placa del vehículo
                                    System.out.print("Digite la nueva placa del vehículo: ");
                                    String nuevoVehiculo = leerNumero.next();

                                    // Pedir al usuario la nueva marca del vehículo
                                    System.out.print("Digite la nueva marca del vehículo: ");
                                    String nuevoVehiculo1 = leerNumero.next();

                                    // Pedir al usuario el nuevo modelo del vehículo
                                    System.out.print("Digite el nuevo modelo del vehículo: ");
                                    String nuevoVehiculo2 = leerNumero.next();

                                    // Pedir al usuario el nuevo modelo del vehículo
                                    System.out.print("Digite el nuevo color del vehículo: ");
                                    String nuevoVehiculo3 = leerNumero.next();

                                    // Pedir al usuario el nuevo modelo del vehículo
                                    System.out.print("Digite el nuevo tipo de vehículo: ");
                                    String nuevoVehiculo4 = leerNumero.next();

                                    // Pedir al usuario el nuevo cliente_idc del vehículo
                                    System.out.print("Digite el nuevo cliente_idc del vehículo: ");
                                    Integer nuevoVehiculo5 = leerNumero.nextInt();

                                    // Actualizar la vehículo en la base de datos
                                    objVehiculo3.setPlaca(nuevoVehiculo);
                                    objVehiculo3.setMarca(nuevoVehiculo1);
                                    objVehiculo3.setModelo(nuevoVehiculo2);
                                    objVehiculo3.setColor(nuevoVehiculo3);
                                    objVehiculo3.setTipo(nuevoVehiculo4);
                                    objVehiculo3.setCliente_idc(nuevoVehiculo5);

                                    if (objAdmVehiculoDB.actualizar(objVehiculo3)) {
                                        System.out.println("Vehículo actualizado éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar el vehículo.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar un vehículo:
                                System.out.println("\n|=========> Eliminar Vehículo <==========|\n");

                                Vehiculo objVehiculo4 = new Vehiculo();

                                System.out.print("\nIngrese el id del vehículo: ");
                                objVehiculo4.setIdv(leerNumero.nextInt());

                                if (objAdmVehiculoDB.eliminar(objVehiculo4)) {
                                    System.out.println("El vehículo se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar el vehículo.");
                                }
                                break;
                            case "6": //6. Salir
                                salirVehiculo = true;
                                break;
                            default:
                                System.out.println("\nVehículo - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirVehiculo = false;
                    break;
                case "3"://3. Administrar Mecanico

                    while (!salirMecanico) {
                        opcionMecanico = "";
                        System.out.println("\n---- ADMINISTRAR MECANICO ----\n");
                        System.out.println("1. Agregar mecánico");
                        System.out.println("2. Mostrar todas los mecánicos");
                        System.out.println("3. Mostrar un mecánico");
                        System.out.println("4. Actualizar mecánico");
                        System.out.println("5. Eliminar mecánico");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionMecanico = leerOpcion.nextLine();

                        switch (opcionMecanico) {
                            case "1":  //1. Agregar Mecánico
                                System.out.println("\n|=========> Insertar Mecánico <==========|\n");

                                Mecanico objMecanico = new Mecanico();
                                
                                System.out.print("\nIngrese el documeto del mecánico: ");
                                objMecanico.setDocumento(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese el nombre del mecánico: ");
                                objMecanico.setNombre(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese el apellido del mecánico: ");
                                objMecanico.setApellido(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese la direccion del mecánico: ");
                                objMecanico.setDireccion(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese la telefono del mecánico: ");
                                objMecanico.setTelefono(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese la especialidad del mecánico: ");
                                objMecanico.setEspecialidad(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese la nivel educativo del mecánico: ");
                                objMecanico.setNivel_educativo(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese la experiencia del mecánico: ");
                                objMecanico.setExperiencia(leerTexto.nextLine());
                                
                                objAdmMecanicoDB.insertar(objMecanico);
                                break;
                            case "2": //2. Mostrar todos los mecanicos:
                                System.out.println("\n|=========> Listar Mecánicos <==========|\n");
                                
                                for (Object obj : objAdmMecanicoDB.listarTodo()) {
                                    Mecanico objMecanico1 = (Mecanico) obj;
                                    System.out.println(objMecanico1);
                                }
                                break;
                            case "3": //3. Mostrar un solo mecanico:
                                System.out.println("\n|=========> Leer Mecánico <==========|\n");

                                Mecanico objMecanico2 = new Mecanico();

                                System.out.print("Ingrese el id del mecánico: ");
                                objMecanico2.setIdm(leerNumero.nextInt());

                                objAdmMecanicoDB.listarUno(objMecanico2);

                                System.out.println(objMecanico2);
                                break;
                            case "4":  //4. Actualizar un mecanico:
                                System.out.println("\n|=========> Actualizar Mecánico <==========|\n");
                                
                                Mecanico objMecanico3 = new Mecanico();
                                
                                System.out.print("Digite el id del mecánico a actualizar: ");
                                objMecanico3.setIdm(leerNumero.nextInt());
                                
                                // Buscar el cliente en la base de datos
                                objMecanico3 = (Mecanico) objAdmMecanicoDB.listarUno(objMecanico3);
                                if (objMecanico3.getIdm() == 0) {
                                    System.out.println("El mecanico no existe.");
                                } else {
                                    // Mostrar información del mecánico antes de actualizar
                                    System.out.println("Mecanico actual:");
                                    System.out.println("ID: " + objMecanico3.getIdm());
                                    System.out.println("Documeto: " + objMecanico3.getDocumento());
                                    System.out.println("Nombre: " + objMecanico3.getNombre());
                                    System.out.println("Apellido: " + objMecanico3.getApellido());
                                    System.out.println("Dirección: " + objMecanico3.getDireccion());
                                    System.out.println("Telefono: " + objMecanico3.getTelefono());
                                    System.out.println("Especialidad: " + objMecanico3.getEspecialidad());
                                    System.out.println("Nivel educativo: " + objMecanico3.getNivel_educativo());
                                    System.out.println("Experiencia: " + objMecanico3.getExperiencia());

                                    // Pedir al usuario el nuevo documeto del mecánico
                                    System.out.print("Digite el nuevo documeto del mecánico: ");
                                    String nuevoMecanico = leerNumero.next();

                                    // Pedir al usuario el nuevo nombre del mecánico
                                    System.out.print("Digite el nuevo nombre del mecánico: ");
                                    String nuevoMecanico1 = leerNumero.next();

                                    // Pedir al usuario el nuevo apellido del mecánico
                                    System.out.print("Digite el nuevo apellido del mecánico: ");
                                    String nuevoMecanico2 = leerNumero.next();

                                    // Pedir al usuario el nuevo precio unitario del mecánico
                                    System.out.print("Digite la nueva dirección del mecánico: ");
                                    String nuevoMecanico3 = leerNumero.next();

                                    // Pedir al usuario el nuevo telefono del mecánico
                                    System.out.print("Digite el nuevo teléfono del mecánico: ");
                                    String nuevoMecanico4 = leerNumero.next();

                                    // Pedir al usuario la nueva especialidad del mecánico
                                    System.out.print("Digite la nueva especialidad del mecánico: ");
                                    String nuevoMecanico5 = leerNumero.next();

                                    // Pedir al usuario el nuevo nivel educativo del mecánico
                                    System.out.print("Digite el nuevo nivel educativo del mecánico: ");
                                    String nuevoMecanico6 = leerNumero.next();

                                    // Pedir al usuario la nueva experiencia del mecánico
                                    System.out.print("Digite la nueva experiencia del mecánico: ");
                                    String nuevoMecanico7 = leerNumero.next();

                                    // Actualizar el mecanico en la base de datos
                                    objMecanico3.setDocumento(nuevoMecanico);
                                    objMecanico3.setNombre(nuevoMecanico1);
                                    objMecanico3.setApellido(nuevoMecanico2);
                                    objMecanico3.setDireccion(nuevoMecanico3);
                                    objMecanico3.setTelefono(nuevoMecanico4);
                                    objMecanico3.setEspecialidad(nuevoMecanico5);
                                    objMecanico3.setNivel_educativo(nuevoMecanico6);
                                    objMecanico3.setExperiencia(nuevoMecanico7);
                                    if (objAdmMecanicoDB.actualizar(objMecanico3)) {
                                        System.out.println("Mecanico actualizado éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar al mecanico.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar un mecanico:
                                System.out.println("\n|=========> Eliminar Mecánico <==========|\n");

                                Mecanico objMecanico4 = new Mecanico();
                                
                                System.out.print("\nIngrese el id del mecánico: ");
                                objMecanico4.setIdm(leerNumero.nextInt());

                                if (objAdmMecanicoDB.eliminar(objMecanico4)) {
                                    System.out.println("El mecanico se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar al mecanico.");
                                }
                                break;
                            case "6": //6. Salir
                                salirMecanico = true;
                                break;
                            default:
                                System.out.println("\nMecanico - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirMecanico = false;
                    break;
                case "4"://4. Administrar Repuesto
                    
                    while (!salirRepuesto) {
                        opcionRepuesto = "";
                        System.out.println("\n---- ADMINISTRAR REPUESTO ----\n");
                        System.out.println("1. Agregar repuesto");
                        System.out.println("2. Mostrar todas los repuestos");
                        System.out.println("3. Mostrar una solo repuesto");
                        System.out.println("4. Actualizar repuesto");
                        System.out.println("5. Eliminar repuesto");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionRepuesto = leerOpcion.nextLine();

                        switch (opcionRepuesto) {
                            case "1":  //1. Agregar Repuesto
                                System.out.println("\n|=========> Insertar Repuesto <==========|\n");

                                Repuesto objRepuesto = new Repuesto();
                                
                                System.out.print("\nIngrese el nombre del repuesto: ");
                                objRepuesto.setRepuesto(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese el tipo del repuesto: ");
                                objRepuesto.setTipo_repuesto(leerTexto.nextLine());
                                
                                System.out.print("\nIngrese el precio unitario del repuesto: ");
                                objRepuesto.setPreciounitario(leerNumero.nextInt());
                                
                                System.out.print("\nIngrese el iva del repuesto: ");
                                objRepuesto.setIva(leerNumero.nextFloat());
                                
                                objAdmRepuestoDB.insertar(objRepuesto);
                                break;
                            case "2": //2. Mostrar todos los repuestos:
                                System.out.println("\n|=========> Liatar Repuestos <==========|\n");
                                for (Object obj : objAdmRepuestoDB.listarTodo()) {
                                    Repuesto objRepuesto1 = (Repuesto) obj;
                                    System.out.println(objRepuesto1);
                                }
                                break;
                            case "3": //3. Mostrar un solo repuesto:
                                System.out.println("\n|=========> Leer Repuesto <==========|\n");

                                Repuesto objRepuesto2 = new Repuesto();

                                System.out.print("Ingrese el id de la repuesto: ");
                                objRepuesto2.setIdr(leerNumero.nextInt());

                                objAdmRepuestoDB.listarUno(objRepuesto2);

                                System.out.println(objRepuesto2);
                                break;
                            case "4"://4. Actualiar un repuesto
                                System.out.println("\n|=========> Actualizar Repuesto <==========|\n");
                                
                                Repuesto objRepuesto3 = new Repuesto();

                                System.out.print("Digite el id del repuesto a actualizar: ");
                                objRepuesto3.setIdr(leerNumero.nextInt());

                                // Buscar el repuesto en la base de datos
                                objRepuesto3 = (Repuesto) objAdmRepuestoDB.listarUno(objRepuesto3);

                                if (objRepuesto3.getIdr() == 0) {
                                    System.out.println("\nError: No existe esa repuesto en el sistema. \n");
                                } else {
                                    // Mostrar información del repuesto antes de actualizar
                                    System.out.println("Repuesto actual:");
                                    System.out.println("ID: " + objRepuesto3.getIdr());
                                    System.out.println("Nombre: " + objRepuesto3.getRepuesto());
                                    System.out.println("Tipo: " + objRepuesto3.getTipo_repuesto());
                                    System.out.println("Precio unitario: " + objRepuesto3.getPreciounitario());
                                    System.out.println("Iva: " + objRepuesto3.getIva());

                                    // Pedir al usuario el nuevo nombre del repuesto
                                    System.out.print("Ingrese nuevo nombre del repuesto: ");
                                    String nuevaRepuesto = leerNumero.next();

                                    // Pedir al usuario el nuevo tipo del repuesto
                                    System.out.print("Ingrese nuevo tipo del repuesto: ");
                                    String nuevaRepuesto1 = leerNumero.next();

                                    // Pedir al usuario el nuevo precio unitario del repuesto
                                    System.out.print("Ingrese el nuevo precio unitario del repuesto: ");
                                    Integer nuevaRepuesto2 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo ica del repuesto
                                    System.out.print("Ingrese el nuevo iva del repuesto: ");
                                    Float nuevaRepuesto3 = leerNumero.nextFloat();

                                    // Actualizar la repuesto en la base de datos
                                    objRepuesto3.setRepuesto(nuevaRepuesto);
                                    objRepuesto3.setTipo_repuesto(nuevaRepuesto1);
                                    objRepuesto3.setPreciounitario(nuevaRepuesto2);
                                    objRepuesto3.setIva(nuevaRepuesto3);
                                    if (objAdmRepuestoDB.actualizar(objRepuesto3)) {
                                        System.out.println("Repuesto actualizada exitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar la repuesto.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar un repuesto:
                                System.out.println("\n|=========> Eliminar Repuesto <==========|\n");

                                Repuesto objRepuesto4 = new Repuesto();
                                System.out.print("\nIngrese el id del repuesto: ");
                                objRepuesto4.setIdr(leerNumero.nextInt());

                                if (objAdmRepuestoDB.eliminar(objRepuesto4)) {
                                    System.out.println("El repuesto se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar el repuesto.");
                                }
                                break;

                            case "6": //6. Salir
                                salirRepuesto = true;
                                break;
                            default:
                                System.out.println("\nRepuesto - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirRepuesto = false;
                    break;
                case "5"://4. Administrar Observacion

                    while (!salirObservacion) {
                        opcionRepuesto = "";
                        System.out.println("\n---- ADMINISTRAR OBSERVACION ----\n");
                        System.out.println("1. Agregar observación");
                        System.out.println("2. Mostrar todas las observaciones");
                        System.out.println("3. Mostrar una observación");
                        System.out.println("4. Actualizar observación");
                        System.out.println("5. Eliminar observación");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionObservacion = leerOpcion.nextLine();

                        switch (opcionObservacion) {
                            case "1":  //1. Agregar Observación
                                System.out.println("\n|=========> Insertar Observación <==========|\n");
                                Observacion objObservacion = new Observacion();

                                System.out.print("Ingrese la observacion: ");
                                objObservacion.setObservacion(leerTexto.next());

                                System.out.print("Ingrese fecha [AAAA-MM-DDtHH:MM:SS]: ");
                                objObservacion.setFecha(LocalDateTime.parse(leerNumero.next()));

                                System.out.print("Ingrese el id del vehículo: ");
                                objObservacion.setVehiculo_idv(leerNumero.nextInt());

                                System.out.print("Ingrese el id del mecánico: ");
                                objObservacion.setMecanico_idm(leerNumero.nextInt());

                                objAdmObservacionDB.insertar(objObservacion);
                                break;
                            case "2": //2. Mostrar todas las observaciones:
                                System.out.println("\n|=========> Listar Observaciones <==========|\n");
                                
                                for (Object obj : objAdmObservacionDB.listarTodo()) {
                                    Observacion objObservacion1 = (Observacion) obj;
                                    System.out.println(objObservacion1);
                                }
                                break;
                            case "3": //3. Mostrar una sola observación:
                                System.out.println("\n|=========> Leer Observación <==========|\n");

                                Observacion objObservacion2 = new Observacion();

                                System.out.print("Ingrese el id del observación: ");
                                objObservacion2.setIdo(leerNumero.nextInt());

                                objAdmObservacionDB.listarUno(objObservacion2);

                                System.out.println(objObservacion2);

                                break;

                            case "4":  //4. Actualizar una observación:
                                System.out.println("\n|=========> Actualizar Observación <==========|\n");
                                
                                Observacion objObservacion3 = new Observacion();

                                System.out.print("Ingrese el id del observación a actualizar: ");
                                objObservacion3.setIdo(leerNumero.nextInt());

                                // Buscar el cliente en la base de datos
                                objObservacion3 = (Observacion) objAdmObservacionDB.listarUno(objObservacion3);

                                if (objObservacion3.getIdo() == 0) {
                                    System.out.println("El observación no existe.");
                                } else {
                                    System.out.println("Observacion actual:");
                                    System.out.println("ID: " + objObservacion3.getIdo());
                                    System.out.println("Observación: " + objObservacion3.getObservacion());
                                    System.out.println("Fecha: " + objObservacion3.getFecha());
                                    System.out.println("ID del vehículo: " + objObservacion3.getVehiculo_idv());
                                    System.out.println("ID del mecánico: " + objObservacion3.getMecanico_idm());

                                    // Pedir al usuario la nueva observación
                                    System.out.print("Ingrese la nueva observación: ");
                                    String nuevoObservacion = leerTexto.next();

                                    // Pedir al usuario la nueva fecha de la observación
                                    System.out.print("Ingrese la nueva fecha [AAAA-MM-DDtHH:MM:SS] de la observación: ");
                                    LocalDateTime nuevoObservacion1 = LocalDateTime.parse(leerNumero.next());
                                    objObservacion3.setFecha(nuevoObservacion1);

                                    // Pedir al usuario el nuevo id del vehículo encargada de la observación
                                    System.out.print("Ingrese el nuevo id de la vehículo encargada del observación: ");
                                    Integer nuevoObservacion2 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo id del mecánico encargado de la observación
                                    System.out.print("Ingrese el nuevo id del mecánico del observación: ");
                                    Integer nuevoObservacion3 = leerNumero.nextInt();

                                    // Actualizar la observación en la base de datos
                                    objObservacion3.setObservacion(nuevoObservacion);
                                    objObservacion3.setFecha(nuevoObservacion1);
                                    objObservacion3.setVehiculo_idv(nuevoObservacion2);
                                    objObservacion3.setMecanico_idm(nuevoObservacion3);
                                    if (objAdmObservacionDB.actualizar(objObservacion3)) {
                                        System.out.println("Observacion actualizado éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar la observación.");
                                    }
                                }
                                break;
                            case "5":  //4. Eliminar una Observacion:
                                System.out.println("\n|=========> Eliminar Observación <==========|\n");

                                Observacion objObservacion4 = new Observacion();
                                
                                System.out.print("\nIngrese el id del observación: ");
                                objObservacion4.setIdo(leerNumero.nextInt());

                                if (objAdmObservacionDB.eliminar(objObservacion4)) {
                                    System.out.println("La observación se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar la observación.");
                                }
                                break;
                            case "6": //6. Salir
                                salirObservacion = true;
                                break;
                            default:
                                System.out.println("\nObservacion - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirObservacion = false;
                    break;
                case "6"://2. Administrar Reparación

                    while (!salirReparacion) {
                        opcionReparacion = "";
                        System.out.println("\n---- ADMINISTRAR REPARACION ----\n");
                        System.out.println("1. Agregar reparación");
                        System.out.println("2. Mostrar todas las reparaciones");
                        System.out.println("3. Mostrar una sola reparación");
                        System.out.println("4. Actualizar reparación");
                        System.out.println("5. Eliminar reparación");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionReparacion = leerOpcion.nextLine();

                        switch (opcionReparacion) {
                            case "1":  //1. Agregar Reparación
                                System.out.println("\n|=========> Insertar Reparación <==========|\n");

                                Reparacion objReparacion = new Reparacion();
                                
                                System.out.print("\nIngrese la cantidad del repuesto usado en la reparación: ");
                                objReparacion.setCantidad(leerNumero.nextInt());
                                
                                System.out.print("\nIngrese el valor de la mano de obra de la reparación: ");
                                objReparacion.setMano_obra(leerNumero.nextInt());
                                
                                System.out.print("\nIngrese el id de la observación: ");
                                objReparacion.setObservacion_ido(leerNumero.nextInt());
                                
                                System.out.print("\nIngrese el id del repuesto: ");
                                objReparacion.setRepuesto_idr(leerNumero.nextInt());
                                
                                System.out.print("\nIngrese el id del mecánico: ");
                                objReparacion.setMecanico_idm2(leerNumero.nextInt());
                                
                                objAdmReparacionDB.insertar(objReparacion);
                                break;
                            case "2": //2. Mostrar todas las reparaciones:
                                System.out.println("\n|=========> Listar Reparaciones <==========|\n");
                                
                                for (Object obj : objAdmReparacionDB.listarTodo()) {
                                    Reparacion objReparacion1 = (Reparacion) obj;
                                    System.out.println(objReparacion1);
                                }
                                break;
                            case "3": //3. Mostrar una sola reparación:
                                System.out.println("\n|=========> Leer Reparación <==========|\n");

                                Reparacion objReparacion2 = new Reparacion();

                                System.out.print("Ingrese el id de la reparación: ");
                                objReparacion2.setIdrepa(leerNumero.nextInt());

                                objAdmReparacionDB.listarUno(objReparacion2);

                                System.out.println(objReparacion2);
                                break;
                            case "4":  //4. Actualizar una reparación:
                                System.out.println("\n|=========> Actualizar Reparación <==========|\n");
                                
                                Reparacion objReparacion3 = new Reparacion();
                                
                                System.out.print("Digite el id de la reparación a actualizar: ");
                                objReparacion3.setIdrepa(leerNumero.nextInt());
                                
                                // Buscar la reparación en la base de datos
                                objReparacion3 = (Reparacion) objAdmReparacionDB.listarUno(objReparacion3);
                                if (objReparacion3.getIdrepa() == 0) {
                                    System.out.println("La reparación no existe.");
                                } else {
                                    // Mostrar información de la reparacion antes de actualizar
                                    System.out.println("Reparación actual:");
                                    System.out.println("ID: " + objReparacion3.getIdrepa());
                                    System.out.println("Cantidad: " + objReparacion3.getCantidad());
                                    System.out.println("Precio de la mano de obra: " + objReparacion3.getMano_obra());
                                    System.out.println("ID Observación: " + objReparacion3.getObservacion_ido());
                                    System.out.println("ID Repuesto: " + objReparacion3.getRepuesto_idr());
                                    System.out.println("ID Mecanico: " + objReparacion3.getMecanico_idm2());

                                    // Pedir al usuario la nueva cantidad del repuesto usado en la reparación
                                    System.out.print("Digite la nueva cantidad del repuesto usado en la reparación: ");
                                    Integer nuevoReparacion = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo precio de la mano de obra de la reparación
                                    System.out.print("Digite el nuevo precio de la mano de obra de la reparación: ");
                                    Integer nuevoReparacion1 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo ID de la observacion de la reparación
                                    System.out.print("Digite el nuevo ID de la observacion de la reparación: ");
                                    Integer nuevoReparacion2 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo ID del repuesto de la reparación
                                    System.out.print("Digite el nuevo ID del repuesto de la reparación: ");
                                    Integer nuevoReparacion3 = leerNumero.nextInt();

                                    // Pedir al usuario el nuevo ID del mecánico de la reparación
                                    System.out.print("Digite el nuevo ID del mecánico de la reparación: ");
                                    Integer nuevoReparacion4 = leerNumero.nextInt();

                                    // Actualizar la reparación en la base de datos
                                    objReparacion3.setCantidad(nuevoReparacion);
                                    objReparacion3.setMano_obra(nuevoReparacion1);
                                    objReparacion3.setObservacion_ido(nuevoReparacion2);
                                    objReparacion3.setRepuesto_idr(nuevoReparacion3);
                                    objReparacion3.setMecanico_idm2(nuevoReparacion4);

                                    if (objAdmReparacionDB.actualizar(objReparacion3)) {
                                        System.out.println("Reparación actualizada éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar la reparación.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar una reparación:
                                System.out.println("\n|=========> Eliminar Reparación <==========|\n");

                                Reparacion objReparacion4 = new Reparacion();
                                
                                System.out.print("\nIngrese el id de la reparación: ");
                                objReparacion4.setIdrepa(leerNumero.nextInt());

                                if (objAdmReparacionDB.eliminar(objReparacion4)) {
                                    System.out.println("La reparación se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar la reparación.");
                                }
                                break;
                            case "6": //6. Salir
                                salirReparacion = true;
                                break;
                            default:
                                System.out.println("\nReparacion - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirReparacion = false;
                    break;
                case "7"://3. Administrar Factura

                    while (!salirFactura) {
                        opcionFactura = "";
                        System.out.println("\n---- ADMINISTRAR FACTURA ----\n");
                        System.out.println("1. Agregar factura");
                        System.out.println("2. Mostrar todas las facturas");
                        System.out.println("3. Mostrar una factura");
                        System.out.println("4. Actualizar factura");
                        System.out.println("5. Eliminar factura");
                        System.out.println("6. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionFactura = leerOpcion.nextLine();

                        switch (opcionFactura) {
                            case "1":  //1. Agregar Factura
                                System.out.println("\n|=========> Insertar Factura <==========|\n");

                                Factura objFactura = new Factura();
                                System.out.print("\nIngrese el nombre del administrador: ");
                                
                                objFactura.setAdministrador(leerTexto.nextLine());
                                System.out.print("\nIngrese el id de la reparación de la factura: ");
                                
                                objFactura.setReparacion_idrepa(leerNumero.nextInt());
                                objAdmFacturaDB.insertar(objFactura);
                                break;
                            case "2": //2. Mostrar todas las facturas:
                                System.out.println("\n|=========> Listar Facturas <==========|\n");
                                
                                for (Object obj : objAdmFacturaDB.listarTodo()) {
                                    Factura objFactura1 = (Factura) obj;
                                    System.out.println(objFactura1);
                                }
                                break;
                            case "3": //3. Mostrar una sola factura:
                                System.out.println("\n|=========> Leer Factura <==========|\n");

                                Factura objFactura2 = new Factura();

                                System.out.print("Ingrese el id de la factura: ");
                                objFactura2.setIdf(leerNumero.nextInt());

                                objAdmFacturaDB.listarUno(objFactura2);

                                System.out.println(objFactura2);
                                break;
                            case "4":  //4. Actualizar una factura:
                                System.out.println("\n|=========> Actualizar Factura <==========|\n");
                                
                                Factura objFactura3 = new Factura();
                                
                                System.out.print("Digite el id de la factura a actualizar: ");
                                objFactura3.setIdf(leerNumero.nextInt());
                                
                                // Buscar la factura en la base de datos
                                objFactura3 = (Factura) objAdmFacturaDB.listarUno(objFactura3);
                                if (objFactura3.getIdf() == 0) {
                                    System.out.println("La factura no existe.");
                                } else {
                                    // Mostrar información del factura antes de actualizar
                                    System.out.println("Factura actual:");
                                    System.out.println("ID: " + objFactura3.getIdf());
                                    System.out.println("Nombre del administrador: " + objFactura3.getAdministrador());
                                    System.out.println("ID de la reparación: " + objFactura3.getReparacion_idrepa());

                                    // Pedir al usuario el nuevo nombre del administrador de la factura
                                    System.out.print("Digite el nuevo nombre del administrador de la factura: ");
                                    String nuevoFactura = leerNumero.next();

                                    // Pedir al usuario el nuevo id de la reparación de la factura
                                    System.out.print("Digite el nuevo id de la reparación de la factura: ");
                                    Integer nuevoFactura1 = leerNumero.nextInt();

                                    // Actualizar la factura en la base de datos
                                    objFactura3.setAdministrador(nuevoFactura);
                                    objFactura3.setReparacion_idrepa(nuevoFactura1);
                                    if (objAdmFacturaDB.actualizar(objFactura3)) {
                                        System.out.println("Factura actualizada éxitosamente.");
                                    } else {
                                        System.out.println("Error al actualizar la factura.");
                                    }
                                }
                                break;
                            case "5":  //5. Eliminar un factura:
                                System.out.println("\n|=========> Eliminar Factura <==========|\n");

                                Factura objFactura4 = new Factura();
                                
                                System.out.print("\nIngrese el id de la factura: ");
                                objFactura4.setIdf(leerNumero.nextInt());

                                if (objAdmFacturaDB.eliminar(objFactura4)) {
                                    System.out.println("La factura se eliminó con éxito.");
                                } else {
                                    System.out.println("Error al eliminar la factura.");
                                }
                                break;
                            case "6": //6. Salir
                                salirFactura = true;
                                break;
                            default:
                                System.out.println("\nFactura - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirFactura = false;
                    break;
                case "8"://8. Administrar Consultas

                    while (!salirReporte) {
                        opcionReporte = "";
                        System.out.println("\n======> REPORTES <======\n");
                        System.out.println("1. Clientes con sus vehículos, indicando la fecha de reparación.");
                        System.out.println("2. Registro de los mecánicos, indicando el modelo, nivel educativo y la fecha de reparación.");
                        System.out.println("3. Registro de los repuestos usados un vehículo, indicando la placa y la fecha de reparación.");
                        System.out.println("4. Registro de los mecánicos.");
                        System.out.println("5. Registro de un solo mecánico.");
                        System.out.println("6. Repuestos utilizados en la reparación, indicando la placa del vehículo.");
                        System.out.println("7. Factura por cliente, indicando el nombre y apellido del cliente.");
                        System.out.println("8. Salir");
                        System.out.print("\nIngrese opción: ");
                        opcionReporte = leerOpcion.nextLine();

                        switch (opcionReporte) {
                            case "1"://1. Clientes con sus vehículos, indicando la fecha de reparación.
                                System.out.println("\n********** Reporte: Clientes con su vehículo reparado *********\n");

                                LocalDateTime fechaInicio = LocalDateTime.parse("1900-01-01t00:00:00");
                                LocalDateTime fechaFin = LocalDateTime.parse("1900-01-01t00:00:00");

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DDtHH:MM:SS]: ");
                                fechaInicio = LocalDateTime.parse(leerTexto.nextLine());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DDtHH:MM:SS]: ");
                                fechaFin = LocalDateTime.parse(leerTexto.nextLine());

                                System.out.println("\nLista de clientes con los datos de su vehículo:\n");

                                RelacionesDB objRelDB = new RelacionesDB();

                                int totalClientes = 0;
                                for (DatosPersonaVehiculo objResult : objRelDB.consultarDatos(fechaInicio, fechaFin)) {
                                    System.out.println(objResult);
                                    totalClientes++;
                                }

                                System.out.println("\nTotal clientes: " + totalClientes);
                                break;
                            case "2"://2. Registro de los mecánicos, indicando el modelo, nivel educativo y la fecha de reparación.
                                System.out.println("\n********** Reporte: Clientes con su vehículo reparado *********\n");

                                String modelo = "";
                                String nivel = "";
                                LocalDateTime fechaInicio2 = LocalDateTime.parse("1900-01-01t00:00:00");
                                LocalDateTime fechaFin2 = LocalDateTime.parse("1900-01-01t00:00:00");

                                System.out.print("Ingrese modelo del vehículo: ");
                                modelo = leerTexto.next();

                                System.out.print("Ingrese el nivel educativo del mecánico: ");
                                nivel = leerTexto.next();

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DDtHH:MM:SS]: ");
                                fechaInicio2 = LocalDateTime.parse(leerTexto.next());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DDtHH:MM:SS]: ");
                                fechaFin2 = LocalDateTime.parse(leerTexto.next());

                                System.out.println("\nLista de mecánico que han reparado al menos un vehículo:\n");

                                RelacionesDB objRelDB2 = new RelacionesDB();

                                int totalFechas = 0;
                                for (DatosMencanicoReparacion objResult : objRelDB2.ListaMecanicoReparacion(modelo, nivel, fechaInicio2, fechaFin2)) {
                                    System.out.println(objResult);
                                    totalFechas++;
                                }

                                System.out.println("\nTotal fechas: " + totalFechas);
                                break;
                            case "3"://3. Registro de los repuestos usados un vehículo, indicando la placa y la fecha de reparación.
                                System.out.println("\n********** Reporte: Repuestos usados un vehículo *********\n");

                                String placa3 = "";
                                LocalDateTime fechaInicio3 = LocalDateTime.parse("1900-01-01t00:00:00");
                                LocalDateTime fechaFin3 = LocalDateTime.parse("1900-01-01t00:00:00");

                                System.out.print("Ingrese la placa del vehículo: ");
                                placa3 = leerTexto.next();

                                System.out.print("Ingrese Fecha inicial[AAAA-MM-DDtHH:MM:SS]: ");
                                fechaInicio3 = LocalDateTime.parse(leerTexto.next());

                                System.out.print("Ingrese Fecha final[AAAA-MM-DDtHH:MM:SS]: ");
                                fechaFin3 = LocalDateTime.parse(leerTexto.next());

                                System.out.println("\nLista de mecánico que han reparado al menos un vehículo:\n");

                                RelacionesDB objRelDB3 = new RelacionesDB();

                                int totalReparaciones = 0;
                                for (ListaRepuesto objResult : objRelDB3.consultarDatos3(placa3, fechaInicio3, fechaFin3)) {
                                    System.out.println(objResult);
                                    totalReparaciones++;
                                }

                                System.out.println("\nTotal Reparaciones: " + totalReparaciones);
                                break;
                            case "4"://4. Registro de los mecánicos.
                                System.out.println("\n********** Reporte: registro de los mecánicos: **********\n");
                               
                                System.out.println("\nLista de datos de los mecánicos:\n");

                                RelacionesDB objRelDB4 = new RelacionesDB();

                                int totalMecanicos = 0;
                                for (DatosDelMencanico objResult : objRelDB4.ListaMecanico()) {
                                    System.out.println(objResult);

                                    totalMecanicos++;
                                }
                                System.out.println("\nTotal mecánicos: " + totalMecanicos);
                                break;
                            case "5"://5. Registro de un solo mecánico.
                                System.out.println("\n********** Reporte: registro de un mecánico: **********\n");
                                
                                String documento = "";

                                System.out.print("Ingrese documento del mecánico: ");
                                documento = leerTexto.next();

                                System.out.println("\nDatos del mecánico:\n");

                                RelacionesDB objRelDB5 = new RelacionesDB();

                                for (DatosDelMencanico objResult : objRelDB5.consultarDatos5(documento)) {
                                    System.out.println(objResult);
                                }
                                break;
                            case "6"://6. Repuestos utilizados en la reparación, indicando la placa del vehículo.
                                System.out.println("\n********** Reporte: Repuestos utilizados en la reparación *********\n");
                                
                                String placa6 = "";
                                System.out.print("Ingrese la placa del vehículo: ");
                                placa6 = leerTexto.next();
                                System.out.println("\nLista de los repuestos utilizados en la reparación:\n");

                                RelacionesDB objRelDB6 = new RelacionesDB();

                                int totalRepuestos = 0;
                                for (LibretaRepuesto objResult : objRelDB6.ListaRepuestoUtilizado(placa6)) {
                                    System.out.println(objResult);
                                    totalRepuestos++;
                                }
                                System.out.println("\nTotal repuestos utilizados: " + totalRepuestos);
                                break;
                            case "7"://7. Factura por cliente, indicando el nombre y apellido del cliente.
                                System.out.println("\n********** Reporte: Factura por cliente *********\n");
                                
                                String placa = "";
                                System.out.print("Ingrese Fecha [AAAA-MM-DDtHH:MM:SS]: ");
                                fecha = LocalDateTime.parse(leerTexto.next());

                                System.out.print("Ingrese el nombre del cliente: ");
                                nombreCliente = leerTexto.next();

                                System.out.print("Ingrese  del cliente: ");
                                apellidoCliente = leerTexto.next();

                                RelacionesDB objRelDB7 = new RelacionesDB();

                                BigDecimal total = BigDecimal.ZERO;
                                int libreta_repuestos_utilizados = 0;
                                for (FacturaCliente objResult : objRelDB7.consultarFacturaCliente(nombreCliente, apellidoCliente)) {
                                    System.out.println(objResult);

                                    libreta_repuestos_utilizados++;
                                    total = total.add(objResult.getTotal());
                                }
                                System.out.println("\nTotal libretas de repuestos utilizados: " + libreta_repuestos_utilizados);
                                System.out.println("El total de la factura del cliente " + nombreCliente + " " + apellidoCliente + " es: " + total);
                                break;
                            case "8": //8. Salir
                                salirReporte = true;
                                break;
                            default:
                                System.out.println("\nConsultas - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
                        }
                    }
                    salirReporte = false;
                    break;
                case "9": //9. Salir
                    salir = true;
                    System.out.println("\n!!! Adiós !!!\n");
                    System.out.println("Gracias por usar el sistema.");
                    break;
                default:
                    System.out.println("\n - Error: No existe opción. Por favor, inténtelo nuevamente. \n");
            }
        }
         */
    }
}
