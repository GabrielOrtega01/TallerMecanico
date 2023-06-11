package vistas;

import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdminMecanicoDB;
import modelo.AdminObservacionDB;
import modelo.AdminVehiculoDB;
import modelo.Observacion;
import modelo.ObservacionVista;

public class FrmDiagAdminObservaciones extends javax.swing.JDialog {

    DefaultTableModel modeloTabla;
    AdminObservacionDB objAdmObsDB = new AdminObservacionDB();
    AdminVehiculoDB objAdmVehDB = new AdminVehiculoDB();
    AdminMecanicoDB objAdmMecDB = new AdminMecanicoDB();
    

    public FrmDiagAdminObservaciones(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.configurarTabla();
        this.refrescarTabla();
    }
    
    private void configurarTabla() {
        String cabecera[] = {"ID", "Observación", "Fecha", "Hora", "Vehículo", "Mecánico"};
        String datos[][] = {};
        this.modeloTabla = new DefaultTableModel(datos, cabecera) {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };
        this.tblListaDeObservaciones.setModel(this.modeloTabla);
    }

    private void refrescarTabla() {
        //Elimina los registros del modelo y de la tabla
        this.modeloTabla.setNumRows(0);

        //Agregar información de la base de datos a la tabla
        String filaDeTabla[] = new String[6];

        for (Object obj : objAdmObsDB.listarTodo2()) {
            ObservacionVista objObservacionVista = (ObservacionVista) obj;
            filaDeTabla[0] = Integer.toString(objObservacionVista.getIdo());
            filaDeTabla[1] = objObservacionVista.getObservacion();
            filaDeTabla[2] = objObservacionVista.getFecha().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            filaDeTabla[3] = objObservacionVista.getHora().toString();
            filaDeTabla[4] = objObservacionVista.getPlaca();
            filaDeTabla[5] = objObservacionVista.getMecanico();

            this.modeloTabla.addRow(filaDeTabla);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaDeObservaciones = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administración de Observaciones");

        tblListaDeObservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Observación", "Fecha", "Hora", "Vehículo", "Mecánico"
            }
        ));
        jScrollPane1.setViewportView(tblListaDeObservaciones);

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnAgregar)
                        .addGap(53, 53, 53)
                        .addComponent(btnActualizar)
                        .addGap(55, 55, 55)
                        .addComponent(btnEliminar)
                        .addGap(67, 67, 67)
                        .addComponent(btnSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1035, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(368, 368, 368)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        FrmDiagAgregarObservacion objFrmDiagAddObs = new FrmDiagAgregarObservacion(null, true);
        objFrmDiagAddObs.setLocationRelativeTo(null);
        objFrmDiagAddObs.setVisible(true);

        this.refrescarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        int fila = this.tblListaDeObservaciones.getSelectedRow();

        if (fila > -1) {
            int id = Integer.parseInt(this.tblListaDeObservaciones.getValueAt(fila, 0).toString());

            FrmDiagActualizarObservacion objFrmDiagUpdMovs = new FrmDiagActualizarObservacion(null, true, id);
            objFrmDiagUpdMovs.setLocationRelativeTo(null);
            objFrmDiagUpdMovs.setVisible(true);

            this.refrescarTabla();

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione el movimiento que desea actualizar.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = this.tblListaDeObservaciones.getSelectedRow();

        if (fila > -1) {
            int idmovimiento = Integer.parseInt(this.tblListaDeObservaciones.getValueAt(fila, 0).toString());

            Observacion objObservacion = new Observacion();
            objObservacion.setIdo(idmovimiento);

            objAdmObsDB.eliminar(objObservacion);

            this.refrescarTabla();

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione el movimiento que quiere eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListaDeObservaciones;
    // End of variables declaration//GEN-END:variables
}
