/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


public class lector {

    private int idLector;
    private String descripcion;

    public lector() {
    }

    public lector(int idLector, String descripcion) {
        this.idLector = idLector;
        this.descripcion = descripcion;
    }

    public int getIdLector() {
        return idLector;
    }

    public void setIdLector(int idLector) {
        this.idLector = idLector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

      
    

}
