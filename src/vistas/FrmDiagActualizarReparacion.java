package vistas;

import modelo.AdminReparacionDB;
import modelo.AdminMecanicoDB;
import modelo.AdminRepuestoDB;
import modelo.AdminObservacionDB;
import modelo.Repuesto;
import modelo.ItemCmbRepuesto;
import modelo.ItemCmbMecanico;
import modelo.ItemCmbObservacion;
import modelo.Reparacion;
import modelo.Observacion;
import modelo.Mecanico;

public class FrmDiagActualizarReparacion extends javax.swing.JDialog {

    AdminReparacionDB objAdmRepaDB = new AdminReparacionDB();
    private int idrepa;

    public FrmDiagActualizarReparacion(java.awt.Frame parent, boolean modal, int idrepa) {
        super(parent, modal);
        initComponents();
        this.idrepa = idrepa;
        this.cargarReparacions(idrepa);
    }

    private void cargarReparacions(int idrep) {
        Reparacion objReparacion = new Reparacion();
        objReparacion.setIdrepa(idrep);

        objReparacion = (Reparacion) objAdmRepaDB.listarUno(objReparacion);

        this.txtCantidad.setText(String.valueOf(objReparacion.getCantidad()));
        this.txtMano_obra.setText(String.valueOf(objReparacion.getMano_obra()));

        AdminObservacionDB objAdmOpr = new AdminObservacionDB();

        ItemCmbObservacion itemSeleccionado = new ItemCmbObservacion();
        for (Object obj : objAdmOpr.listarTodo()) {
            Observacion objObservacion = new Observacion();
            objObservacion = (Observacion) obj;

            ItemCmbObservacion objItem = new ItemCmbObservacion();
            objItem.setIdo(objObservacion.getIdo());
            objItem.setObservacion(objObservacion.getObservacion());

            this.cmbObservacion.addItem(objItem);

            if (objReparacion.getObservacion_ido() == objObservacion.getIdo()) {
                itemSeleccionado = objItem;
            }
        }

        this.cmbObservacion.setSelectedItem(itemSeleccionado);
        

        AdminRepuestoDB objAdmR = new AdminRepuestoDB();

        ItemCmbRepuesto itemSeleccionado2 = new ItemCmbRepuesto();
        for (Object obj : objAdmR.listarTodo()) {
            Repuesto objRepuesto = new Repuesto();
            objRepuesto = (Repuesto) obj;

            ItemCmbRepuesto objItem = new ItemCmbRepuesto();
            objItem.setIdr(objRepuesto.getIdr());
            objItem.setRepuesto(objRepuesto.getRepuesto());

            this.cmbRepuesto.addItem(objItem);

            if (objReparacion.getRepuesto_idr() == objRepuesto.getIdr()) {
                itemSeleccionado2 = objItem;
            }
        }

        this.cmbRepuesto.setSelectedItem(itemSeleccionado2);

        AdminMecanicoDB objAdmMec = new AdminMecanicoDB();

        ItemCmbMecanico itemSeleccionado3 = new ItemCmbMecanico();
        for (Object obj : objAdmMec.listarTodo()) {
            Mecanico objMecanico = new Mecanico();
            objMecanico = (Mecanico) obj;

            ItemCmbMecanico objItem = new ItemCmbMecanico();
            objItem.setIdm(objMecanico.getIdm());
            objItem.setDocumento(objMecanico.getDocumento());

            this.cmbMecanico.addItem(objItem);

            if (objReparacion.getMecanico_idm2() == objMecanico.getIdm()) {
                itemSeleccionado3 = objItem;
            }
        }

        this.cmbObservacion.setSelectedItem(itemSeleccionado3);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Reparación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Cantidad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mano de obra:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        txtMano_obra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMano_obraActionPerformed(evt);
            }
        });
        jPanel1.add(txtMano_obra, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 193, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Observación:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mecánico:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Repuesto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        cmbRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRepuestoActionPerformed(evt);
            }
        });
        jPanel1.add(cmbRepuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 193, -1));

        jPanel1.add(cmbMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 193, -1));

        jPanel1.add(cmbObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 193, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 193, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        objReparacion.setIdrepa(this.idrepa);
        objAdmRepaDB.listarUno(objReparacion);
        
        objReparacion.setMano_obra(mano_obra);
        objReparacion.setCantidad(cantidad);
        objReparacion.setObservacion_ido(idObservacion);
        objReparacion.setRepuesto_idr(idRepuesto);
        objReparacion.setMecanico_idm2(idMecanico);

        objAdmRepaDB.actualizar(objReparacion);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtMano_obraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMano_obraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMano_obraActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cmbRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRepuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRepuestoActionPerformed

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
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtMano_obra;
    // End of variables declaration//GEN-END:variables
}
