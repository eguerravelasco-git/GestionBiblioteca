/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Computador01
 */
public class tBibliografia {

    private int idTBibliografia;
    private String nombreBibliografia;
    private String descripcionTBibliografia;

    public tBibliografia() {
    }

    public tBibliografia(int idTBibliografia, String nombreBibliografia, String descripcionTBibliografia) {
        this.idTBibliografia = idTBibliografia;
        this.nombreBibliografia = nombreBibliografia;
        this.descripcionTBibliografia = descripcionTBibliografia;
    }

    public int getIdTBibliografia() {
        return idTBibliografia;
    }

    public void setIdTBibliografia(int idTBibliografia) {
        this.idTBibliografia = idTBibliografia;
    }

    public String getNombreBibliografia() {
        return nombreBibliografia;
    }

    public void setNombreBibliografia(String nombreBibliografia) {
        this.nombreBibliografia = nombreBibliografia;
    }

    public String getDescripcionTBibliografia() {
        return descripcionTBibliografia;
    }

    public void setDescripcionTBibliografia(String descripcionTBibliografia) {
        this.descripcionTBibliografia = descripcionTBibliografia;
    }
    
    

}
