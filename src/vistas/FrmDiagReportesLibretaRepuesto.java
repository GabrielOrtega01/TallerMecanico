package vistas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.RelacionesDB;
import modelo.LibretaRepuesto;

public class FrmDiagReportesLibretaRepuesto extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    RelacionesDB objRelDB6 = new RelacionesDB();

    public FrmDiagReportesLibretaRepuesto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
    }

    private void configurarTabla() {
        String cabecera[] = {"Mecánico", "Placa", "Libreta repuesto utilizados", "Costo mano de obra",
            "Precio unitario", "Cantidad", "Iva", "Total", "Fecha", "Hora"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblReporteFactura.setModel(this.modeloTabla);
    }

    private void refrescarTabla(String placa6) {

        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[10];

        for (Object obj : objRelDB6.ListaRepuestoUtilizado(placa6)) {
            LibretaRepuesto objLibretaRepuesto = (LibretaRepuesto) obj;
            filaDeTabla[0] = objLibretaRepuesto.getMecanico();
            filaDeTabla[1] = objLibretaRepuesto.getPlaca();
            filaDeTabla[2] = objLibretaRepuesto.getLibreta_repuestos_utilizados();
            filaDeTabla[3] = Integer.toString(objLibretaRepuesto.getCosto_mano_de_obra());
            filaDeTabla[4] = Integer.toString(objLibretaRepuesto.getPreciounitario());
            filaDeTabla[5] = Integer.toString(objLibretaRepuesto.getCantidad());
            filaDeTabla[6] = Float.toString(objLibretaRepuesto.getIva());
            filaDeTabla[7] = objLibretaRepuesto.getTotal().toString();
            filaDeTabla[8] = objLibretaRepuesto.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            filaDeTabla[9] = objLibretaRepuesto.getHora().toString();

            this.modeloTabla.addRow(filaDeTabla);
        }
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
        txtPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Reporte: Libreta repuestos utilizados ");

        tblReporteFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mecánico", "Placa", "Libreta repuesto utilizados", "Costo mano de obra", "Precio unitario", "Cantidad", "Iva", "Total", "Fecha", "Hora"
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
        jLabel2.setText("Placa del vehículo");

        txtPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlacaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(480, 480, 480))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(722, 722, 722))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnConsultarDineroTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSalir)
                        .addGap(480, 480, 480))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultarDineroTotal)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarDineroTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDineroTotalActionPerformed
        String placa = this.txtPlaca.getText();

         if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡La placa no debe estar vacía!");
        } else {
            this.refrescarTabla(placa);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReporteFactura;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables
}
