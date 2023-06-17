package vistas;

import modelo.AdminRepuestoDB;
import modelo.Repuesto;
import modelo.ItemCmbRepuesto;

public class FrmDiagActualizarRepuesto extends javax.swing.JDialog {

    AdminRepuestoDB objAdmRepuestoDB = new AdminRepuestoDB();
    private int idr;

    public FrmDiagActualizarRepuesto(java.awt.Frame parent, boolean modal, int idr) {
        super(parent, modal);
        initComponents();
        this.idr = idr;
        this.cargarRepuesto(idr);
    }

    private void cargarRepuesto(int idart) {
        Repuesto objRepuesto = new Repuesto();
        objRepuesto.setIdr(idart);

        objRepuesto = (Repuesto) objAdmRepuestoDB.listarUno(objRepuesto);

        this.txtRepuesto.setText(objRepuesto.getRepuesto());
        this.txtTipo_Repuesto.setText(objRepuesto.getTipo_repuesto());
        this.txtPreciounitario.setText(String.valueOf(objRepuesto.getPreciounitario()));
        this.txtIva.setText(String.valueOf(objRepuesto.getIva()));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRepuesto = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTipo_Repuesto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPreciounitario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Repuesto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Repuesto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRepuestoActionPerformed(evt);
            }
        });
        jPanel1.add(txtRepuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 193, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Tipo de repuesto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtTipo_Repuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipo_RepuestoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTipo_Repuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 193, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Precio unitario:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtPreciounitario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreciounitarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPreciounitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 193, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Iva:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 193, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRepuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRepuestoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String repuesto = this.txtRepuesto.getText();
        String tipo_repuesto = this.txtTipo_Repuesto.getText();
        int preciounitario = Integer.parseInt(this.txtPreciounitario.getText());
        float iva = Float.parseFloat(this.txtIva.getText());

        AdminRepuestoDB objAdmRepuestoDB = new AdminRepuestoDB();
        Repuesto objRepuesto = new Repuesto();

        objRepuesto.setIdr(this.idr);
        objAdmRepuestoDB.listarUno(objRepuesto);

        objRepuesto.setRepuesto(repuesto);
        objRepuesto.setTipo_repuesto(tipo_repuesto);
        objRepuesto.setPreciounitario(preciounitario);
        objRepuesto.setIva(iva);

        objAdmRepuestoDB.actualizar(objRepuesto);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtTipo_RepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipo_RepuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipo_RepuestoActionPerformed

    private void txtPreciounitarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreciounitarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreciounitarioActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtPreciounitario;
    private javax.swing.JTextField txtRepuesto;
    private javax.swing.JTextField txtTipo_Repuesto;
    // End of variables declaration//GEN-END:variables
}
