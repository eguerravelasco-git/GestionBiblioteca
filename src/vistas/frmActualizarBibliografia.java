/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.bibliografia;
import clases.tBibliografia;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import servicios.StringToDate;
import servicios.bibliografiaServicios;
import servicios.tBibliografiaServicios;

/**
 *
 * @author Usuario
 */
public class frmActualizarBibliografia extends javax.swing.JFrame {

    private bibliografia objBibliografia;
    private tBibliografia tBibliografiaSel;
    private ArrayList<tBibliografia> lstTBibliografia;
    public frmActualizarBibliografia() {
        initComponents();
        this.lstTBibliografia = new ArrayList<>();
        objBibliografia = new bibliografia();
        tBibliografiaSel = new tBibliografia();
        this.llenarComboBox();
    }
    
    private void cargarTBibliografia() {
        try {
            this.lstTBibliografia = tBibliografiaServicios.obtenerTodos();
            this.tBibliografiaSel = lstTBibliografia.get(0);
            System.out.println(lstTBibliografia.get(0).getNombreBibliografia());

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "cargarTBibliografia dice:", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.out.println("private void cargarTBibliografia dice: " + e.getMessage());
        }
    }

    private void llenarComboBox() {
        this.cargarTBibliografia();

        try {
            cbTBibliografia.setModel(new DefaultComboBoxModel(new Object[]{}));
            cbTBibliografia.removeAllItems();
            for (int i = 0; i < this.lstTBibliografia.size(); i++) {
                cbTBibliografia.addItem(lstTBibliografia.get(i).getNombreBibliografia());
            }

        } catch (Exception e) {
        }

    }

    public void actualizarBibliografia() {
        int item_seleccionado = cbTBibliografia.getSelectedIndex();
        try {
            this.tBibliografiaSel = lstTBibliografia.get(item_seleccionado);
            objBibliografia.setIdBibliografia(Integer.valueOf(txtCodigo.getText()));
            objBibliografia.setIdTBibliografia(tBibliografiaServicios.obtenerDadoCodigo(tBibliografiaSel.getIdTBibliografia()));
            objBibliografia.setTituloBibliografia(txtTitulo.getText());
            objBibliografia.setAutorBibliografia(txtAutor.getText());
            objBibliografia.setMateriaBibliografia(txtMateria.getText());
            objBibliografia.setEditorialBibliografia(txtEditorial.getText());
            objBibliografia.setEdicionBibliografia(txtEdicion.getText());
            objBibliografia.setFechaPublicacion(StringToDate.devolverFecha(fechaPublicacion.getDate()));
            objBibliografia.setValoracionBibliografia(Double.valueOf(txtValoracion.getText()));

            if (bibliografiaServicios.actualizar(objBibliografia)) {
                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Datos no Insertados ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("insertarBibliografia dice;" + e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlLectores = new javax.swing.JPanel();
        pnlIngresos = new javax.swing.JPanel();
        lbAutor = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        lbTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        lbMateria = new javax.swing.JLabel();
        txtMateria = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        lbEditorial = new javax.swing.JLabel();
        txtEdicion = new javax.swing.JTextField();
        lbFechapublicacion = new javax.swing.JLabel();
        lbEdicion = new javax.swing.JLabel();
        cbTBibliografia = new javax.swing.JComboBox();
        lbBibliografia = new javax.swing.JLabel();
        lbValoracion = new javax.swing.JLabel();
        txtValoracion = new javax.swing.JTextField();
        fechaPublicacion = new org.freixas.jcalendar.JCalendarCombo();
        txtCodigo = new javax.swing.JTextField();
        lbCodigo = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlLectores.setBackground(new java.awt.Color(102, 204, 255));
        pnlLectores.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BIBLIOGRAFIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Game of Thrones", 1, 12))); // NOI18N
        pnlLectores.setPreferredSize(new java.awt.Dimension(700, 400));

        pnlIngresos.setBackground(new java.awt.Color(204, 255, 255));
        pnlIngresos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        pnlIngresos.setPreferredSize(new java.awt.Dimension(520, 340));

        lbAutor.setText("Autor");

        lbTitulo.setText("Título");

        lbMateria.setText("Asignatura");

        lbEditorial.setText("Editorial");

        lbFechapublicacion.setText("Fecha Publicación");

        lbEdicion.setText("Año Edición");

        lbBibliografia.setText("Tipo");

        lbValoracion.setText("Valoración");

        fechaPublicacion.setDate(new java.util.Date(1478288304000L));

        txtCodigo.setEditable(false);

        lbCodigo.setText("Código");

        javax.swing.GroupLayout pnlIngresosLayout = new javax.swing.GroupLayout(pnlIngresos);
        pnlIngresos.setLayout(pnlIngresosLayout);
        pnlIngresosLayout.setHorizontalGroup(
            pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresosLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbFechapublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbEditorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBibliografia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEditorial)
                    .addComponent(txtMateria)
                    .addComponent(txtEdicion)
                    .addComponent(txtValoracion)
                    .addComponent(fechaPublicacion, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                    .addComponent(cbTBibliografia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAutor)
                    .addComponent(txtTitulo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        pnlIngresosLayout.setVerticalGroup(
            pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIngresosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTBibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBibliografia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitulo)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbAutor)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMateria)
                    .addComponent(txtMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEditorial)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEdicion)
                    .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechapublicacion)
                    .addComponent(fechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbValoracion)
                    .addComponent(txtValoracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pnlBotones.setBackground(new java.awt.Color(204, 255, 255));
        pnlBotones.setPreferredSize(new java.awt.Dimension(110, 340));

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlLectoresLayout = new javax.swing.GroupLayout(pnlLectores);
        pnlLectores.setLayout(pnlLectoresLayout);
        pnlLectoresLayout.setHorizontalGroup(
            pnlLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLectoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLectoresLayout.setVerticalGroup(
            pnlLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLectoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlLectoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLectores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlLectores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        actualizarBibliografia();
        txtTitulo.setText("");
        txtAutor.setText("");
        txtMateria.setText("");
        txtEdicion.setText("");
        txtEditorial.setText("");
        txtMateria.setText("");
        txtValoracion.setText("");

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmListarBibliografia vista = new frmListarBibliografia();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed

        this.dispose();
        frmListarBibliografia vista = new frmListarBibliografia();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmActualizarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmActualizarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmActualizarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmActualizarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmActualizarBibliografia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    public javax.swing.JComboBox cbTBibliografia;
    public org.freixas.jcalendar.JCalendarCombo fechaPublicacion;
    private javax.swing.JLabel lbAutor;
    private javax.swing.JLabel lbBibliografia;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbEdicion;
    private javax.swing.JLabel lbEditorial;
    private javax.swing.JLabel lbFechapublicacion;
    private javax.swing.JLabel lbMateria;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbValoracion;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlIngresos;
    private javax.swing.JPanel pnlLectores;
    public javax.swing.JTextField txtAutor;
    public javax.swing.JTextField txtCodigo;
    public javax.swing.JTextField txtEdicion;
    public javax.swing.JTextField txtEditorial;
    public javax.swing.JTextField txtMateria;
    public javax.swing.JTextField txtTitulo;
    public javax.swing.JTextField txtValoracion;
    // End of variables declaration//GEN-END:variables
}
