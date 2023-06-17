package vistas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import modelo.AdminObservacionDB;
import modelo.AdminMecanicoDB;
import modelo.AdminVehiculoDB;
import modelo.Mecanico;
import modelo.ItemCmbMecanico;
import modelo.ItemCmbVehiculo;
import modelo.Observacion;
import modelo.Vehiculo;

public class FrmDiagActualizarObservacion extends javax.swing.JDialog {

    AdminObservacionDB objAdmMovDB = new AdminObservacionDB();
    private int ido;

    public FrmDiagActualizarObservacion(java.awt.Frame parent, boolean modal, int ido) {
        super(parent, modal);
        initComponents();
        this.ido = ido;
        this.cargarObservaciones(ido);
    }

    private void cargarObservaciones(int idobs) {
        Observacion objObservacion = new Observacion();
        objObservacion.setIdo(idobs);

        objObservacion = (Observacion) objAdmMovDB.listarUno(objObservacion);

        LocalDate fechaObservacion = objObservacion.getFecha();
        
        this.jDateFechaObservacion.setDate(java.sql.Date.valueOf(fechaObservacion));
        this.txtHora.setText(String.valueOf(objObservacion.getHora()));
        this.txtObservacion.setText(String.valueOf(objObservacion.getObservacion()));

        AdminVehiculoDB objAdmVeh = new AdminVehiculoDB();

        ItemCmbVehiculo itemSeleccionado = new ItemCmbVehiculo();
        for (Object obj : objAdmVeh.listarTodo()) {
            Vehiculo objVehiculo = new Vehiculo();
            objVehiculo = (Vehiculo) obj;

            ItemCmbVehiculo objItem = new ItemCmbVehiculo();
            objItem.setIdv(objVehiculo.getIdv());
            objItem.setPlaca(objVehiculo.getPlaca());

            this.cmbVehiculo.addItem(objItem);

            if (objObservacion.getVehiculo_idv() == objVehiculo.getIdv()) {
                itemSeleccionado = objItem;
            }
        }

        this.cmbVehiculo.setSelectedItem(itemSeleccionado);

        AdminMecanicoDB objAdmMec = new AdminMecanicoDB();

        ItemCmbMecanico itemSeleccionado2 = new ItemCmbMecanico();
        for (Object obj : objAdmMec.listarTodo()) {
            Mecanico objMecanico = new Mecanico();
            objMecanico = (Mecanico) obj;

            ItemCmbMecanico objItem = new ItemCmbMecanico();
            objItem.setIdm(objMecanico.getIdm());
            objItem.setDocumento(objMecanico.getDocumento());

            this.cmbMecanico.addItem(objItem);

            if (objObservacion.getMecanico_idm() == objMecanico.getIdm()) {
                itemSeleccionado2 = objItem;
            }
        }

        this.cmbMecanico.setSelectedItem(itemSeleccionado2);

   

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
        txtObservacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbMecanico = new javax.swing.JComboBox<>();
        cmbVehiculo = new javax.swing.JComboBox<>();
        jDateFechaObservacion = new com.toedter.calendar.JDateChooser();
        txtHora = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 191, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Observación");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Observación:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        txtObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionActionPerformed(evt);
            }
        });
        jPanel1.add(txtObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Vehículo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Mecánico");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jPanel1.add(cmbMecanico, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 170, -1));

        jPanel1.add(cmbVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 170, -1));
        jPanel1.add(jDateFechaObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, -1));

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hora:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
        String observacion = this.txtObservacion.getText();
        LocalDate fecha = this.jDateFechaObservacion.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                // Obtener la hora ingresada en el campo de texto
        String horaTexto = txtHora.getText();
        LocalTime hora = LocalTime.parse(horaTexto, DateTimeFormatter.ofPattern("HH:mm"));

        
        ItemCmbVehiculo objItem = (ItemCmbVehiculo) this.cmbVehiculo.getSelectedItem();
        int idVeh = objItem.getIdv();

        ItemCmbMecanico objItem2 = (ItemCmbMecanico) this.cmbMecanico.getSelectedItem();
        int idMec = objItem2.getIdm();


        AdminObservacionDB objAdmObsDB = new AdminObservacionDB();
        Observacion objObservacion = new Observacion();

        objObservacion.setIdo(this.ido);
        objAdmObsDB.listarUno(objObservacion);

        objObservacion.setObservacion(observacion);
        objObservacion.setFecha(fecha);
        objObservacion.setHora(hora);
        objObservacion.setVehiculo_idv(idVeh);
        objObservacion.setMecanico_idm(idMec);

        objAdmObsDB.actualizar(objObservacion);

        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservacionActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<ItemCmbMecanico> cmbMecanico;
    private javax.swing.JComboBox<ItemCmbVehiculo> cmbVehiculo;
    private com.toedter.calendar.JDateChooser jDateFechaObservacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables
}
