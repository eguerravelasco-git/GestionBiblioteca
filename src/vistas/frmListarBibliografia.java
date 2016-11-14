/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.bibliografia;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import servicios.StringToDate;
import servicios.bibliografiaServicios;
import servicios.personaServicios;

public class frmListarBibliografia extends javax.swing.JFrame {

    private bibliografia bibliografiaSel;
    private ArrayList<bibliografia> lstBibliografias;

    public frmListarBibliografia() {
        initComponents();
        bibliografiaSel = new bibliografia();
        lstBibliografias = new ArrayList<>();
        this.llenarTabla();
    }

    private void cargarBibliografias() {
        try {
            this.lstBibliografias = bibliografiaServicios.obtenerTodos();
            this.bibliografiaSel = lstBibliografias.get(0);
            System.out.println(lstBibliografias.get(0).getTituloBibliografia());

        } catch (Exception e) {
            if (lstBibliografias.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No existen Registros...", "Infromación", JOptionPane.INFORMATION_MESSAGE);
            }

            System.out.println("private void cargarPersonas dice: " + e.getMessage());
        }
    }

    private void llenarTabla() {
        this.cargarBibliografias();
        try {
            DefaultTableCellRenderer Alinear = new DefaultTableCellRenderer();
            Alinear.setHorizontalAlignment(SwingConstants.LEFT);

            tblBibliografias.getColumnModel().getColumn(0).setCellRenderer(Alinear);
            tblBibliografias.getColumnModel().getColumn(1).setCellRenderer(Alinear);
            tblBibliografias.getColumnModel().getColumn(2).setCellRenderer(Alinear);

            DefaultTableModel dtm = (DefaultTableModel) tblBibliografias.getModel();
            dtm.setRowCount(0);

            for (int i = 0; i < this.lstBibliografias.size(); i++) {
                dtm.addRow(new Object[]{
                    this.lstBibliografias.get(i).getIdBibliografia(),
                    this.lstBibliografias.get(i).getIdTBibliografia().getNombreBibliografia(),
                    this.lstBibliografias.get(i).getTituloBibliografia(),
                    this.lstBibliografias.get(i).getAutorBibliografia(),
                    this.lstBibliografias.get(i).getMateriaBibliografia(),
                    this.lstBibliografias.get(i).getEditorialBibliografia(),
                    this.lstBibliografias.get(i).getEdicionBibliografia(),
                    this.lstBibliografias.get(i).getFechaPublicacion(),
                    this.lstBibliografias.get(i).getValoracionBibliografia(),});
            }
        } catch (Exception e) {
        }
    }

    public void eliminarBibliografia() {
        try {
            if (bibliografiaServicios.eliminar(bibliografiaSel)) {
                JOptionPane.showMessageDialog(null, "Datos Eliminados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Eliminados ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("eliminarPersona dice;" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBibliografia = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBibliografias = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBibliografia.setBackground(new java.awt.Color(102, 204, 255));
        pnlBibliografia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BIBLIOGRAFIA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Game of Thrones", 1, 12))); // NOI18N
        pnlBibliografia.setPreferredSize(new java.awt.Dimension(1200, 500));

        tblBibliografias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "TIPO BIBLIOGRAFÍA", "TITULO", "AUTOR", "ASIGNATURA", "EDITORIAL", "AÑO EDICIÓN", "FECHA PUBLICACIÓN", "VALORACIÓN"
            }
        ));
        jScrollPane1.setViewportView(tblBibliografias);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnRegresar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBibliografiaLayout = new javax.swing.GroupLayout(pnlBibliografia);
        pnlBibliografia.setLayout(pnlBibliografiaLayout);
        pnlBibliografiaLayout.setHorizontalGroup(
            pnlBibliografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBibliografiaLayout.createSequentialGroup()
                .addContainerGap(409, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(370, 370, 370))
        );
        pnlBibliografiaLayout.setVerticalGroup(
            pnlBibliografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBibliografiaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frmGuardarBibliografia vista = new frmGuardarBibliografia();
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int fila_seleccionada = tblBibliografias.getSelectedRow();
        this.dispose();
        if (fila_seleccionada >= 0) {
            //lstLectores.this.dispose();
            frmActualizarBibliografia vista = new frmActualizarBibliografia();
            this.bibliografiaSel = lstBibliografias.get(fila_seleccionada);
            vista.txtCodigo.setText(String.valueOf(lstBibliografias.get(fila_seleccionada).getIdBibliografia()));
            vista.cbTBibliografia.setSelectedItem(lstBibliografias.get(fila_seleccionada).getIdTBibliografia().getNombreBibliografia());
            vista.txtTitulo.setText(lstBibliografias.get(fila_seleccionada).getTituloBibliografia());
            vista.txtAutor.setText(lstBibliografias.get(fila_seleccionada).getAutorBibliografia());
            vista.txtMateria.setText(lstBibliografias.get(fila_seleccionada).getMateriaBibliografia());
            vista.txtEditorial.setText(lstBibliografias.get(fila_seleccionada).getEditorialBibliografia());
            vista.txtEdicion.setText(lstBibliografias.get(fila_seleccionada).getEdicionBibliografia());
            vista.fechaPublicacion.setDate(lstBibliografias.get(fila_seleccionada).getFechaPublicacion());
            vista.txtValoracion.setText(String.valueOf(lstBibliografias.get(fila_seleccionada).getValoracionBibliografia()));
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
        int fila_seleccionada = tblBibliografias.getSelectedRow();
        this.dispose();
        if (fila_seleccionada >= 0) {
            this.bibliografiaSel = lstBibliografias.get(fila_seleccionada);

            int decision = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar este Registro?\n"
                    + "Código: " + bibliografiaSel.getIdBibliografia() + "\n"
                    + "Tipo Bibliografía: " + bibliografiaSel.getIdTBibliografia().getNombreBibliografia() + "\n"
                    + "Título: " + bibliografiaSel.getTituloBibliografia() + "\n"
                    + "Autor: " + bibliografiaSel.getAutorBibliografia() + "\n"
                    + "Asignatura: " + bibliografiaSel.getMateriaBibliografia() + "\n"
                    + "Editorial: " + bibliografiaSel.getEditorialBibliografia() + "\n"
                    + "Año Edición: " + bibliografiaSel.getEdicionBibliografia() + "\n"
                    + "Fecha Publicación:" + bibliografiaSel.getFechaPublicacion() + "\n"
                    + "Valoración:" + bibliografiaSel.getValoracionBibliografia() + "\n", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (decision == 0) {
                eliminarBibliografia();
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
            java.util.logging.Logger.getLogger(frmListarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmListarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmListarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmListarBibliografia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmListarBibliografia biblio = new frmListarBibliografia();
                biblio.setVisible(true);
                biblio.setLocationRelativeTo(null);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBibliografia;
    private javax.swing.JTable tblBibliografias;
    // End of variables declaration//GEN-END:variables
}
