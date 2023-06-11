package vistas;

import modelo.AdminReparacionDB;
import modelo.AdminMecanicoDB;
import modelo.AdminRepuestoDB;
import modelo.AdminObservacionDB;
import modelo.Repuesto;
import modelo.ItemCmbRepuesto;
import modelo.ItemCmbObservacion;
import modelo.ItemCmbMecanico;
import modelo.Reparacion;
import modelo.Observacion;
import modelo.Mecanico;

public class FrmDiagAgregarReparacion extends javax.swing.JDialog {

    public FrmDiagAgregarReparacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.cargarReparacions();
    }

    private void cargarReparacions() {
        AdminObservacionDB objAdmObservacion = new AdminObservacionDB();
        AdminRepuestoDB objAdmRepuesto = new AdminRepuestoDB();
        AdminMecanicoDB objAdmOpr = new AdminMecanicoDB();

        for (Object obj : objAdmObservacion.listarTodo()) {
            Observacion objObservacion = new Observacion();
            objObservacion = (Observacion) obj;

            ItemCmbObservacion objItem = new ItemCmbObservacion();
            objItem.setIdo(objObservacion.getIdo());
            objItem.setObservacion(objObservacion.getObservacion());

            this.cmbObservacion.addItem(objItem);

        }

        for (Object obj : objAdmRepuesto.listarTodo()) {
            Repuesto objRepuesto = new Repuesto();
            objRepuesto = (Repuesto) obj;

            ItemCmbRepuesto objItem = new ItemCmbRepuesto();
            objItem.setIdr(objRepuesto.getIdr());
            objItem.setRepuesto(objRepuesto.getRepuesto());

            this.cmbRepuesto.addItem(objItem);
        }

        for (Object obj : objAdmOpr.listarTodo()) {
            Mecanico objMecanico = new Mecanico();
            objMecanico = (Mecanico) obj;

            ItemCmbMecanico objItem = new ItemCmbMecanico();
            objItem.setIdm(objMecanico.getIdm());
            objItem.setDocumento(objMecanico.getDocumento());

            this.cmbMecanico.addItem(objItem);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtMano_obra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbRepuesto = new javax.swing.JComboBox<>();
        cmbMecanico = new javax.swing.JComboBox<>();
        cmbObservacion = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(250, 191, 252));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Agregar Reparación");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad:");

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mano de obra:");

        txtMano_obra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMano_obraActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Observación:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mecánico");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Repuesto:");

        cmbRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRepuestoActionPerformed(evt);
            }
        });

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(btnAceptar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addGap(125, 125, 125))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbRepuesto, 0, 193, Short.MAX_VALUE)
                            .addComponent(txtMano_obra)
                            .addComponent(cmbObservacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbMecanico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCantidad)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMano_obra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int cantidad = Integer.parseInt(this.txtCantidad.getText());
        int mano_obra = Integer.parseInt(this.txtMano_obra.getText());

        ItemCmbObservacion objItem = (ItemCmbObservacion) this.cmbObservacion.getSelectedItem();
        int idObservacion = objItem.getIdo();

        ItemCmbRepuesto objItem2 = (ItemCmbRepuesto) this.cmbRepuesto.getSelectedItem();
        int idRepuesto = objItem2.getIdr();

        ItemCmbMecanico objItem3 = (ItemCmbMecanico) this.cmbMecanico.getSelectedItem();
        int idMecanico = objItem3.getIdm();

        AdminReparacionDB objAdmRepaDB = new AdminReparacionDB();
        Reparacion objReparacion = new Reparacion();

        objReparacion.setMano_obra(mano_obra);
        objReparacion.setCantidad(cantidad);
        objReparacion.setObservacion_ido(idObservacion);
        objReparacion.setRepuesto_idr(idRepuesto);
        objReparacion.setMecanico_idm2(idMecanico);

        objAdmRepaDB.insertar(objReparacion);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMano_obraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMano_obraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMano_obraActionPerformed

    private void cmbRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRepuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRepuestoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDiagAgregarReparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmDiagAgregarReparacion dialog = new FrmDiagAgregarReparacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<modelo.ItemCmbMecanico> cmbMecanico;
    private javax.swing.JComboBox<modelo.ItemCmbObservacion> cmbObservacion;
    private javax.swing.JComboBox<modelo.ItemCmbRepuesto> cmbRepuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtMano_obra;
    // End of variables declaration//GEN-END:variables
}
