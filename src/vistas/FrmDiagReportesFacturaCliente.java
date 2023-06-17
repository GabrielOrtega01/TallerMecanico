package vistas;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.FacturaCliente;

public class FrmDiagReportesFacturaCliente extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB7 = new RelacionesDB();

    public FrmDiagReportesFacturaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"Repuestos utilizados", "Costo mano de obra", "Precio unitario", "Cantidad", "Iva", "Total"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblReporteFactura.setModel(this.modeloTabla);
    }

    private void refrescarTabla(LocalDate fecha, String placa) {

        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[6];
        BigDecimal TotalFactura = BigDecimal.ZERO;

        for (Object obj : objRelDB7.consultarFacturaCliente(fecha, placa)) {
            FacturaCliente objFacturaCliente = (FacturaCliente) obj;

            filaDeTabla[0] = objFacturaCliente.getLibreta_repuestos_utilizados();
            filaDeTabla[1] = Integer.toString(objFacturaCliente.getCosto_mano_de_obra());
            filaDeTabla[2] = Integer.toString(objFacturaCliente.getPreciounitario());
            filaDeTabla[3] = Integer.toString(objFacturaCliente.getCantidad());
            filaDeTabla[4] = Float.toString(objFacturaCliente.getIva());
            filaDeTabla[5] = objFacturaCliente.getTotal().toString();

            this.modeloTabla.addRow(filaDeTabla);
            TotalFactura = TotalFactura.add(objFacturaCliente.getTotal());

            String administrador = objFacturaCliente.getAdministrador();
            this.labAdministrador.setText(administrador);

            String nombreCliente = objFacturaCliente.getCliente();
            this.labCliente.setText(nombreCliente);

            String Documento = objFacturaCliente.getDocumento();
            this.labDocumento.setText(Documento);

            String Direccion = objFacturaCliente.getDireccion();
            this.labDireccion.setText(Direccion);

            String Correo = objFacturaCliente.getCorreo();
            this.labCorreo.setText(Correo);

            String Placa = objFacturaCliente.getPlaca();
            this.labPlaca.setText(Placa);

            String Mecanico = objFacturaCliente.getMecanico();
            this.labMecanico.setText(Mecanico);

            String Fecha = objFacturaCliente.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.labFecha.setText(Fecha);

            String numeroFactura = Integer.toString(objFacturaCliente.getIdf());
            this.labFactura.setText(numeroFactura);

            String hora = objFacturaCliente.getHora().toString();
            this.labHora.setText(hora);

        }
        // Formatear el total invertido con separadores de miles
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String totalInvertidoFormateado = decimalFormat.format(TotalFactura);
        this.labTotalFactura.setText(totalInvertidoFormateado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteFactura = new javax.swing.JTable();
        btnConsultarDineroTotal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jDateFecha = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        labTotalFactura = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labDocumento = new javax.swing.JLabel();
        labCliente = new javax.swing.JLabel();
        labFecha = new javax.swing.JLabel();
        labMecanico = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labDireccion = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        labPlaca = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labCorreo = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labFactura = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        labAdministrador = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        labHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Taller mecánico S.A.S");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 0, -1, -1));

        tblReporteFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Repuestos utilizados", "Costo mano de obra", "Precio unitario", "Cantidad", "Iva", "Total"
            }
        ));
        jScrollPane1.setViewportView(tblReporteFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 371, 728, 140));

        btnConsultarDineroTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarDineroTotal.setText("Consultar");
        btnConsultarDineroTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDineroTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnConsultarDineroTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 576, -1, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 576, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 548, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Placa del vehículo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 548, -1, -1));

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 578, 126, -1));
        jPanel1.add(jDateFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 576, 103, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Total de la factura");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 548, -1, -1));

        labTotalFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labTotalFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTotalFactura.setText("0");
        jPanel1.add(labTotalFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 548, 106, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cliente:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 164, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Fecha:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 281, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Direccion:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 197, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Documento:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 164, -1, -1));

        labDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDocumento.setText("0");
        jPanel1.add(labDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 164, 183, -1));

        labCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCliente.setText("0");
        jPanel1.add(labCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 164, 214, -1));

        labFecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFecha.setText("0");
        jPanel1.add(labFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 281, 122, -1));

        labMecanico.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labMecanico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labMecanico.setText("0");
        jPanel1.add(labMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(482, 248, 174, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Mecanico:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 248, 104, -1));

        labDireccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDireccion.setText("0");
        jPanel1.add(labDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 197, 174, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Placa:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 248, -1, -1));

        labPlaca.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPlaca.setText("0");
        jPanel1.add(labPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 248, 125, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Correo:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 197, -1, -1));

        labCorreo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCorreo.setText("0");
        jPanel1.add(labCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 197, 280, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Factura#:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 281, -1, -1));

        labFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFactura.setText("0");
        jPanel1.add(labFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 281, 130, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Nit 123456789-8");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 35, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Admin:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 75, -1, -1));

        labAdministrador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labAdministrador.setText("0");
        jPanel1.add(labAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 75, 323, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Dirección: Bucaramanga");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 108, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Teléfono: +576071234567 ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(383, 108, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("-------------------------------------------------------------------------------------------");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 136, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("-------------------------------------------------------------------------------------------");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 220, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Hora:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 314, -1, -1));

        labHora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labHora.setText("0");
        jPanel1.add(labHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 314, 122, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarDineroTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDineroTotalActionPerformed

        String placa = this.txtPlaca.getText();
        LocalDate fecha = null;

        if (this.jDateFecha.getDate() != null) {
            fecha = this.jDateFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        if (fecha == null && placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡Los campos no pueden estar vacíos!");
        } else if (fecha == null) {
            JOptionPane.showMessageDialog(this, "¡La fecha no debe estar vacía!");
        } else if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡La placa no debe estar vacía!");
        } else {
            this.refrescarTabla(fecha, placa);
        }

    }//GEN-LAST:event_btnConsultarDineroTotalActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlacaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarDineroTotal;
    private javax.swing.JButton btnSalir;
    private com.toedter.calendar.JDateChooser jDateFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labAdministrador;
    private javax.swing.JLabel labCliente;
    private javax.swing.JLabel labCorreo;
    private javax.swing.JLabel labDireccion;
    private javax.swing.JLabel labDocumento;
    private javax.swing.JLabel labFactura;
    private javax.swing.JLabel labFecha;
    private javax.swing.JLabel labHora;
    private javax.swing.JLabel labMecanico;
    private javax.swing.JLabel labPlaca;
    private javax.swing.JLabel labTotalFactura;
    private javax.swing.JTable tblReporteFactura;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
