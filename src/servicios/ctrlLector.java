/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import clases.lector;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vistas.frmGuardarLector;


public class ctrlLector {

    private lector objLector;
    private ArrayList<lector> lstLectores;
    private lector lectorSel;

    public ctrlLector() {
        this.lstLectores = new ArrayList<lector>();
        this.lectorSel = new lector();
        this.objLector = new lector();
//        this.cargarLectores();

    }

    public void insertarLector() {
        try {

            if (lectorServicios.insertar(objLector)) {

                JOptionPane.showMessageDialog(null, "Datos Insertados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
//                this.cargarLectores();
                this.objLector = new lector();

            } else {
                JOptionPane.showMessageDialog(null, "Datos no Insertados ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("insertarLector dice;" + e);
        }
    }

    public void actualizarLector() {
        try {

            if (lectorServicios.actualizar(lectorSel)) {
                JOptionPane.showMessageDialog(null, "Datos Modificados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
                
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Modificados ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("actualizarLector dice;" + e);
        }
    }

    public void eliminarLector() {
        try {
            if (lectorServicios.eliminar(lectorSel)) {
                JOptionPane.showMessageDialog(null, "Datos Eliminados Correctamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no Eliminados ", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            System.out.println("eliminarLector dice;" + e);
        }
    }

    public void cargarLectores() {
        try {
            this.lstLectores = lectorServicios.obtenerTodos();
            this.lectorSel = lstLectores.get(0);
            System.out.println(lstLectores.get(0).getIdLector());
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "cargarLectores dice:", e.getMessage(), JOptionPane.ERROR_MESSAGE);
            System.out.println("private void cargarLectores dice: " + e.getMessage());
        }
    }

}
