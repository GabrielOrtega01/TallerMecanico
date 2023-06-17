package vistas;

import modelo.FacturaCliente;


public class FrmPrincipalMecanico extends javax.swing.JFrame {


    public FrmPrincipalMecanico() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        submenuSalir = new javax.swing.JMenuItem();
        submenuAcceso = new javax.swing.JMenuItem();
        menuConfiguracion = new javax.swing.JMenu();
        submenuAdminClientes = new javax.swing.JMenuItem();
        submenuAdmVehiculos = new javax.swing.JMenuItem();
        submenuAdminObservacion = new javax.swing.JMenuItem();
        submenuAdminRepuestos = new javax.swing.JMenuItem();
        submenuAdmReparaciones = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        submenuReportesFacturaCliente = new javax.swing.JMenuItem();
        submenuReportesLibretaRepuestos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        submenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1250, 700));

        jPanelFondo.setPreferredSize(new java.awt.Dimension(1250, 700));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Taller Mecánico");
        jPanelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 255, 69));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Perfil mecánico");
        jPanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 170, -1, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/TallerMecanico.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1250, 700));
        jPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 700));

        menuArchivo.setText("Archivo");

        submenuSalir.setText("Salir");
        submenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(submenuSalir);

        submenuAcceso.setText("Acceso");
        submenuAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAccesoActionPerformed(evt);
            }
        });
        menuArchivo.add(submenuAcceso);

        barraDeMenu.add(menuArchivo);

        menuConfiguracion.setText("Configuración");

        submenuAdminClientes.setText("Admin clientes");
        submenuAdminClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminClientesActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdminClientes);

        submenuAdmVehiculos.setText("Admin vehículos");
        submenuAdmVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmVehiculosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmVehiculos);

        submenuAdminObservacion.setText("Admin Observacion");
        submenuAdminObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminObservacionActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdminObservacion);

        submenuAdminRepuestos.setText("Admin repuestos");
        submenuAdminRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdminRepuestosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdminRepuestos);

        submenuAdmReparaciones.setText("Admin reparaciones");
        submenuAdmReparaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAdmReparacionesActionPerformed(evt);
            }
        });
        menuConfiguracion.add(submenuAdmReparaciones);

        barraDeMenu.add(menuConfiguracion);

        menuReportes.setText("Reportes");

        submenuReportesFacturaCliente.setText("Factura por cliente");
        submenuReportesFacturaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesFacturaClienteActionPerformed(evt);
            }
        });
        menuReportes.add(submenuReportesFacturaCliente);

        submenuReportesLibretaRepuestos.setText("Libreta repuestos utilizados");
        submenuReportesLibretaRepuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuReportesLibretaRepuestosActionPerformed(evt);
            }
        });
        menuReportes.add(submenuReportesLibretaRepuestos);

        barraDeMenu.add(menuReportes);

        jMenu3.setText("Ayuda");

        submenuAcercaDe.setText("Acerca de ...");
        submenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuAcercaDeActionPerformed(evt);
            }
        });
        jMenu3.add(submenuAcercaDe);

        barraDeMenu.add(jMenu3);

        setJMenuBar(barraDeMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_submenuSalirActionPerformed

    private void submenuAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAccesoActionPerformed
        FrmDiagLogin objFrmDiagLogin = new FrmDiagLogin(this, true);
        objFrmDiagLogin.setLocationRelativeTo(null);
        objFrmDiagLogin.setVisible(true);
    }//GEN-LAST:event_submenuAccesoActionPerformed

    private void submenuReportesFacturaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesFacturaClienteActionPerformed
        FrmDiagReportesFacturaCliente objFrmDiagRepFC = new FrmDiagReportesFacturaCliente(this, true);
        objFrmDiagRepFC.setLocationRelativeTo(null);
        objFrmDiagRepFC.setVisible(true);
    }//GEN-LAST:event_submenuReportesFacturaClienteActionPerformed

    private void submenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAcercaDeActionPerformed
        FrmDiagAcercaDe objFrmDiagAcerca = new FrmDiagAcercaDe(this, true);
        objFrmDiagAcerca.setLocationRelativeTo(null);
        objFrmDiagAcerca.setVisible(true);
    }//GEN-LAST:event_submenuAcercaDeActionPerformed

    private void submenuReportesLibretaRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuReportesLibretaRepuestosActionPerformed
        FrmDiagReportesLibretaRepuesto objFrmDiagLR = new FrmDiagReportesLibretaRepuesto(this, true);
        objFrmDiagLR.setLocationRelativeTo(null);
        objFrmDiagLR.setVisible(true);
    }//GEN-LAST:event_submenuReportesLibretaRepuestosActionPerformed

    private void submenuAdminClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdminClientesActionPerformed
        FrmDiagAdminClientes objFrmDiagAdmCliente = new FrmDiagAdminClientes(this, true);
        objFrmDiagAdmCliente.setLocationRelativeTo(null);
        objFrmDiagAdmCliente.setVisible(true);
    }//GEN-LAST:event_submenuAdminClientesActionPerformed

    private void submenuAdmVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmVehiculosActionPerformed
        FrmDiagAdminVehiculos objFrmDiagAdmVeh = new FrmDiagAdminVehiculos(this, true);
        objFrmDiagAdmVeh.setLocationRelativeTo(null);
        objFrmDiagAdmVeh.setVisible(true);
    }//GEN-LAST:event_submenuAdmVehiculosActionPerformed

    private void submenuAdminObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdminObservacionActionPerformed
        FrmDiagAdminObservaciones objFrmDiagObs = new FrmDiagAdminObservaciones(this, true);
        objFrmDiagObs.setLocationRelativeTo(null);
        objFrmDiagObs.setVisible(true);
    }//GEN-LAST:event_submenuAdminObservacionActionPerformed

    private void submenuAdminRepuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdminRepuestosActionPerformed
        FrmDiagAdminRepuestos objFrmDiagAdmRepuesto = new FrmDiagAdminRepuestos(this, true);
        objFrmDiagAdmRepuesto.setLocationRelativeTo(null);
        objFrmDiagAdmRepuesto.setVisible(true);
    }//GEN-LAST:event_submenuAdminRepuestosActionPerformed

    private void submenuAdmReparacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuAdmReparacionesActionPerformed
        FrmDiagAdminReparaciones objFrmDiagAdmReparacion = new FrmDiagAdminReparaciones(this, true);
        objFrmDiagAdmReparacion.setLocationRelativeTo(null);
        objFrmDiagAdmReparacion.setVisible(true);
    }//GEN-LAST:event_submenuAdmReparacionesActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalMecanico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipalMecanico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenuItem submenuAcceso;
    private javax.swing.JMenuItem submenuAcercaDe;
    private javax.swing.JMenuItem submenuAdmReparaciones;
    private javax.swing.JMenuItem submenuAdmVehiculos;
    private javax.swing.JMenuItem submenuAdminClientes;
    private javax.swing.JMenuItem submenuAdminObservacion;
    private javax.swing.JMenuItem submenuAdminRepuestos;
    private javax.swing.JMenuItem submenuReportesFacturaCliente;
    private javax.swing.JMenuItem submenuReportesLibretaRepuestos;
    private javax.swing.JMenuItem submenuSalir;
    // End of variables declaration//GEN-END:variables
}
