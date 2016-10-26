/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Computador01
 */
public class prestamos {

    private int idPrestamos;
    private persona idPersona;
    private bibliografia idBibliografia;
    private Date fecha_retiro;
    private boolean devolucion;
    private String observaciones;

    public prestamos() {
    }

    public int getIdPrestamos() {
        return idPrestamos;
    }

    public void setIdPrestamos(int idPrestamos) {
        this.idPrestamos = idPrestamos;
    }

    public persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(persona idPersona) {
        this.idPersona = idPersona;
    }

    public bibliografia getIdBibliografia() {
        return idBibliografia;
    }

    public void setIdBibliografia(bibliografia idBibliografia) {
        this.idBibliografia = idBibliografia;
    }

    public Date getFecha_retiro() {
        return fecha_retiro;
    }

    public void setFecha_retiro(Date fecha_retiro) {
        this.fecha_retiro = fecha_retiro;
    }

    public boolean isDevolucion() {
        return devolucion;
    }

    public void setDevolucion(boolean devolucion) {
        this.devolucion = devolucion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    

}
