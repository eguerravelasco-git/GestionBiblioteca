/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import clases.lector;
import java.util.ArrayList;
import servicios.lectorServicios;

/**
 *
 * @author Usuario
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        ArrayList<lector> lstLectores;
        int tamaño = 0;
        try {
           lstLectores =lectorServicios.obtenerTodos(); 
           tamaño=lstLectores.size();
           
           for(int i = 0; i < tamaño; i++){
                System.out.println(lstLectores.get(i).getDescripcion());
                         
                }
        } catch (Exception e) {
            System.out.println("obtener dice:"+e);
        }
        
        
    }
    
}
