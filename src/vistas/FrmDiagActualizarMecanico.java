package vistas;

import modelo.AdminMecanicoDB;
import modelo.Mecanico;

public class FrmDiagActualizarMecanico extends javax.swing.JDialog {

    AdminMecanicoDB objAdmMecanicoDB = new AdminMecanicoDB();
    private int idm;

    public FrmDiagActualizarMecanico(java.awt.Frame parent, boolean modal, int idm) {
        super(parent, modal);
        initComponents();
        this.idm = idm;
        this.cargarMecanico(idm);
    }

    private void cargarMecanico(int id) {
        Mecanico objMecanico = new Mecanico();
        objMecanico.setIdm(id);

        objMecanico = (Mecanico) objAdmMecanicoDB.listarUno(objMecanico);

        this.txtDocumento.setText(objMecanico.getDocumento());
        this.txtNombre.setText(objMecanico.getNombre());
        this.txtApellido.setText(objMecanico.getApellido());
        this.txtDireccion.setText(objMecanico.getDireccion());
        this.txtTelefono.setText(objMecanico.getTelefono());
        this.txtEspecialidad.setText(objMecanico.getEspecialidad());
        this.txtNivel_educativo.setText(objMecanico.getNivel_educativo());
        this.txtExperiencia.setText(objMecanico.getExperiencia());
        this.txtContrasena.setText(objMecanico.getContrasena());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEspecialidad = new javax.swing.JTextField();
        txtNivel_educativo = new javax.swing.JTextField();
        txtExperiencia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Mecánico");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Documento:");

        txtDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentoActionPerformed(evt);
            }
        });

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
        jLabel3.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Apellido:");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Dirección:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Teléfono:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Especialidad:");

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEspecialidadActionPerformed(evt);
            }
        });

        txtNivel_educativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNivel_educativoActionPerformed(evt);
            }
        });

        txtExperiencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExperienciaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Nivel educativo:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Experiencia:");

        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Contraseña:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btnAceptar)
                        .addGap(75, 75, 75)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtExperiencia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTelefono)
                                .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEspecialidad, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNivel_educativo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDocumento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5))
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNivel_educativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtExperiencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentoActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String documento = this.txtDocumento.getText();
        String nombre = this.txtNombre.getText();
        String apellido = this.txtApellido.getText();
        String direccion = this.txtDireccion.getText();
        String telefono = this.txtTelefono.getText();
        String especialidad = this.txtEspecialidad.getText();
        String nivel_educativo = this.txtNivel_educativo.getText();
        String experiencia = this.txtExperiencia.getText();
        String contrasena = this.txtContrasena.getText();

        AdminMecanicoDB objAdmMecanicoDB = new AdminMecanicoDB();
        Mecanico objMecanico = new Mecanico();

        objMecanico.setIdm(this.idm);
        objAdmMecanicoDB.listarUno(objMecanico);

        objMecanico.setDocumento(documento);
        objMecanico.setNombre(nombre);
        objMecanico.setApellido(apellido);
        objMecanico.setDireccion(direccion);
        objMecanico.setTelefono(telefono);
        objMecanico.setEspecialidad(especialidad);
        objMecanico.setNivel_educativo(nivel_educativo);
        objMecanico.setExperiencia(experiencia);
        objMecanico.setContrasena(contrasena);

        objAdmMecanicoDB.actualizar(objMecanico);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEspecialidadActionPerformed

    private void txtNivel_educativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNivel_educativoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNivel_educativoActionPerformed

    private void txtExperienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExperienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExperienciaActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtExperiencia;
    private javax.swing.JTextField txtNivel_educativo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
