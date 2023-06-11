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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualizar Observación");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");

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
        jLabel3.setText("Observación:");

        txtObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Vehículo:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Mecánico");

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Hora:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(93, 93, 93))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnAceptar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCancelar)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jDateFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(103, 103, 103)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jDateFechaObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbMecanico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(16, Short.MAX_VALUE))
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
