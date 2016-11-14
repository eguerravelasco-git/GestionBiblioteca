/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.prestamos;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import servicios.StringToDate;
import servicios.prestamosServicio;

/**
 *
 * @author Usuario
 */
public class frmListarPrestamos extends javax.swing.JFrame {

    private prestamos prestamoSel;
    private ArrayList<prestamos> lstPrestamos;
    String cambio = "";

    public frmListarPrestamos() {
        initComponents();
        prestamoSel = new prestamos();
        lstPrestamos = new ArrayList<>();
        this.llenarTabla();
    }

    private void cargarPrestamos() {
        try {
            this.lstPrestamos = prestamosServicio.obtenerTodos();
            this.prestamoSel = lstPrestamos.get(0);
            System.out.println(lstPrestamos.get(0).getObservaciones());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "cargarPrestamos dice:", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.out.println("private void cargarPrestamos dice: " + e.getMessage());
        }
    }

    private void llenarTabla() {
        this.cargarPrestamos();

        try {
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.LEFT);
            tblPrestamos.getColumnModel().getColumn(0).setCellRenderer(Alinear);
            tblPrestamos.getColumnModel().getColumn(1).setCellRenderer(Alinear);
            tblPrestamos.getColumnModel().getColumn(2).setCellRenderer(Alinear);
            tblPrestamos.getColumnModel().getColumn(3).setCellRenderer(Alinear);
            tblPrestamos.getColumnModel().getColumn(4).setCellRenderer(Alinear);
            tblPrestamos.getColumnModel().getColumn(5).setCellRenderer(Alinear);
            DefaultTableModel dtm = (DefaultTableModel) tblPrestamos.getModel();
            dtm.setRowCount(0);

            for (int i = 0; i < this.lstPrestamos.size(); i++) {

                if (true == this.lstPrestamos.get(i).isDevolucion()) {
                    cambio = "Devuelto";
                } else {
                    cambio = "Prestado";
                }

                dtm.addRow(new Object[]{
                    this.lstPrestamos.get(i).getIdPrestamos(),
                    this.lstPrestamos.get(i).getIdPersona().getNombresPersona() + " " + this.lstPrestamos.get(i).getIdPersona().getApellidosPersona(),
                    this.lstPrestamos.get(i).getIdBibliografia().getTituloBibliografia(),
                    this.lstPrestamos.get(i).getIdBibliografia().getIdTBibliografia().getNombreBibliografia(),
                    this.lstPrestamos.get(i).getFecha_retiro(),
                    this.cambio,
                    this.lstPrestamos.get(i).getObservaciones(),});
            }
        } catch (Exception e) {
        }
    }

    public void eliminarPersona() {
        try {
            if (prestamosServicio.eliminar(prestamoSel)) {
                JOptionPane.showMessageDialog(null, "Datos Eliminados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Eliminados ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("eliminarPrestamo dice;" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PRESTAMOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Game of Thrones", 1, 12))); // NOI18N

        tblPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "LECTOR", "BIBLIOGRAFIA", "TIPO", "FECHA", "ESTADO", "OBSERVACIONES"
            }
        ));
        jScrollPane1.setViewportView(tblPrestamos);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar)
                    .addComponent(btnSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 167, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmGuardarPrestamo vista = new frmGuardarPrestamo();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila_seleccionada = tblPrestamos.getSelectedRow();
        this.dispose();
        if (fila_seleccionada >= 0) {
            //lstLectores.this.dispose();
            frmDevolucion vista = new frmDevolucion();
            this.prestamoSel = lstPrestamos.get(fila_seleccionada);
            vista.txtCodigo.setText(String.valueOf(lstPrestamos.get(fila_seleccionada).getIdPrestamos()));
            vista.txtLector.setText(lstPrestamos.get(fila_seleccionada).getIdPersona().getNombresPersona());
            vista.txtLibro.setText(lstPrestamos.get(fila_seleccionada).getIdBibliografia().getTituloBibliografia());
            vista.txtFecha.setText(StringToDate.devolverFechaString(lstPrestamos.get(fila_seleccionada).getFecha_retiro()));
            vista.txtObservaciones.setText(lstPrestamos.get(fila_seleccionada).getObservaciones());

            vista.setVisible(true);
            vista.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
            this.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila_seleccionada = tblPrestamos.getSelectedRow();
        this.dispose();

        if (fila_seleccionada >= 0) {
            this.prestamoSel = lstPrestamos.get(fila_seleccionada);
            if (true == this.lstPrestamos.get(fila_seleccionada).isDevolucion()) {
                cambio = "Devuelto";
            } else {
                cambio = "Prestado";
            }

            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar este Registro?\n"
                    + "Código: " + prestamoSel.getIdPrestamos() + "\n"
                    + "Lector: " + prestamoSel.getIdPersona().getNombresPersona() + prestamoSel.getIdPersona().getApellidosPersona() + "\n"
                    + "Bibliografia: " + prestamoSel.getIdBibliografia().getTituloBibliografia() + "\n"
                    + "Estado: " + prestamoSel.isDevolucion() + "\n"
                    + "Fecha: " + prestamoSel.getFecha_retiro() + "\n"
                    + "Observaciones: " + prestamoSel.getObservaciones() + "\n", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (decision == 0) {
                eliminarPersona();
                this.setVisible(true);
                this.setLocationRelativeTo(null);
            } else {
                this.setVisible(true);
                this.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fila.");
            this.setVisible(true);
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmPrincipal principal = new frmPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmPrincipal principal = new frmPrincipal();
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(frmListarPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListarPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListarPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListarPrestamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmListarPrestamos v = new frmListarPrestamos();
                v.setVisible(true);
                v.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPrestamos;
    // End of variables declaration//GEN-END:variables
}
