package vistas;

import dao.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmDiagLogin extends javax.swing.JDialog {

    public FrmDiagLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnAcceder = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Acceso al sistema");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Usuario:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Contraseña:");

        btnAcceder.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAcceder.setText("Acceder");
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        txtContrasena.setText("123");
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(btnAcceder)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalir))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsuario)
                                .addComponent(txtContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                            .addGap(59, 59, 59))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceder)
                    .addComponent(btnSalir))
                .addContainerGap(87, Short.MAX_VALUE))
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

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        String usuario = this.txtUsuario.getText();
        String contrasena = new String(this.txtContrasena.getPassword());

        String query = "SELECT m.especialidad, m.contrasena, m.documento FROM mecanico m "
                    + "WHERE m.documento = ?";

        try {
            Connection con = Conexion.abrirConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si existe el usuario
                String u = rs.getString("documento");
                String p = rs.getString("contrasena");
                String priv = rs.getString("especialidad");

                String inputPassword = new String(contrasena);
                if (p.equals(inputPassword)) {
                    if (priv.equals("frenos")) {
                        // Colaborador
                        FrmPrincipalMecanico objFrmPrincipalMecanico = new FrmPrincipalMecanico();
                        objFrmPrincipalMecanico.setLocationRelativeTo(null);
                        objFrmPrincipalMecanico.setVisible(true);
                    } else if (priv.equals("administrador")) {
                        // Administrador
                        FrmPrincipalAdministrador objFrmPrincipalAdministrador = new FrmPrincipalAdministrador();
                        objFrmPrincipalAdministrador.setLocationRelativeTo(null);
                        objFrmPrincipalAdministrador.setVisible(true);
                    } else if (priv.equals("general")) {
                        FrmPrincipalMecanico objFrmPrincipalMecanico = new FrmPrincipalMecanico();
                        objFrmPrincipalMecanico.setLocationRelativeTo(null);
                        objFrmPrincipalMecanico.setVisible(true);
                    } else if (priv.equals("electrico")) {
                        FrmPrincipalMecanico objFrmPrincipalMecanico = new FrmPrincipalMecanico();
                        objFrmPrincipalMecanico.setLocationRelativeTo(null);
                        objFrmPrincipalMecanico.setVisible(true);
                    } else if (priv.equals("motor")) {
                        FrmPrincipalMecanico objFrmPrincipalMecanico = new FrmPrincipalMecanico();
                        objFrmPrincipalMecanico.setLocationRelativeTo(null);
                        objFrmPrincipalMecanico.setVisible(true);
                    }
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                }
            } else {
                // El usuario no existe
                JOptionPane.showMessageDialog(null, "El usuario inexistente");
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrmPrincipalAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAccederActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContrasenaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
