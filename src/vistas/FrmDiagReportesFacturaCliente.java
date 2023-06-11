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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Taller mecánico S.A.S");

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

        btnConsultarDineroTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnConsultarDineroTotal.setText("Consultar");
        btnConsultarDineroTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDineroTotalActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Placa del vehículo:");

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Total de la factura");

        labTotalFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labTotalFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTotalFactura.setText("0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Cliente:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Fecha:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Direccion:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Documento:");

        labDocumento.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labDocumento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDocumento.setText("0");

        labCliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCliente.setText("0");

        labFecha.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFecha.setText("0");

        labMecanico.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labMecanico.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labMecanico.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Mecanico:");

        labDireccion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labDireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labDireccion.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Placa:");

        labPlaca.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labPlaca.setText("0");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Correo:");

        labCorreo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labCorreo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labCorreo.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Factura#:");

        labFactura.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labFactura.setText("0");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Nit 123456789-8");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Admin:");

        labAdministrador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labAdministrador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labAdministrador.setText("0");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Dirección: Bucaramanga");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Teléfono: +576071234567 ");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("-------------------------------------------------------------------------------------------");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("-------------------------------------------------------------------------------------------");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Hora:");

        labHora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labHora.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(labDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(labPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(labDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(labHora, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(52, 52, 52)
                                        .addComponent(labFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel16))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(btnConsultarDineroTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir)
                                .addGap(230, 230, 230))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(labTotalFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(labAdministrador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labCliente)
                    .addComponent(jLabel8)
                    .addComponent(labDocumento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labDireccion)
                    .addComponent(jLabel11)
                    .addComponent(labCorreo))
                .addGap(1, 1, 1)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labPlaca)
                    .addComponent(jLabel9)
                    .addComponent(labMecanico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labFecha)
                    .addComponent(jLabel12)
                    .addComponent(labFactura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(labHora))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(labTotalFactura))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConsultarDineroTotal)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalir))
                    .addComponent(jDateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
