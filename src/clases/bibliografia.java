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
public class bibliografia {
  private int idBibliografia;
  private tBibliografia idTBibliografia; 
  private String tituloBibliografia;
  private String autorBibliografia;
  private String materiaBibliografia;
  private String editorialBibliografia;
  private String edicionBibliografia;
  private Date fechaPublicacion;
  private double valoracionBibliografia;

    public bibliografia() {
    }

    public bibliografia(int idBibliografia, tBibliografia idTBibliografia, String tituloBibliografia, String autorBibliografia, String materiaBibliografia, String editorialBibliografia, String edicionBibliografia, Date fechaPublicacion, double valoracionBibliografia) {
        this.idBibliografia = idBibliografia;
        this.idTBibliografia = idTBibliografia;
        this.tituloBibliografia = tituloBibliografia;
        this.autorBibliografia = autorBibliografia;
        this.materiaBibliografia = materiaBibliografia;
        this.editorialBibliografia = editorialBibliografia;
        this.edicionBibliografia = edicionBibliografia;
        this.fechaPublicacion = fechaPublicacion;
        this.valoracionBibliografia = valoracionBibliografia;
    }

    public int getIdBibliografia() {
        return idBibliografia;
    }

    public void setIdBibliografia(int idBibliografia) {
        this.idBibliografia = idBibliografia;
    }

    public tBibliografia getIdTBibliografia() {
        return idTBibliografia;
    }

    public void setIdTBibliografia(tBibliografia idTBibliografia) {
        this.idTBibliografia = idTBibliografia;
    }

    public String getTituloBibliografia() {
        return tituloBibliografia;
    }

    public void setTituloBibliografia(String tituloBibliografia) {
        this.tituloBibliografia = tituloBibliografia;
    }

    public String getAutorBibliografia() {
        return autorBibliografia;
    }

    public void setAutorBibliografia(String autorBibliografia) {
        this.autorBibliografia = autorBibliografia;
    }

    public String getMateriaBibliografia() {
        return materiaBibliografia;
    }

    public void setMateriaBibliografia(String materiaBibliografia) {
        this.materiaBibliografia = materiaBibliografia;
    }

    public String getEditorialBibliografia() {
        return editorialBibliografia;
    }

    public void setEditorialBibliografia(String editorialBibliografia) {
        this.editorialBibliografia = editorialBibliografia;
    }

    public String getEdicionBibliografia() {
        return edicionBibliografia;
    }

    public void setEdicionBibliografia(String edicionBibliografia) {
        this.edicionBibliografia = edicionBibliografia;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public double getValoracionBibliografia() {
        return valoracionBibliografia;
    }

    public void setValoracionBibliografia(double valoracionBibliografia) {
        this.valoracionBibliografia = valoracionBibliografia;
    }

  

    }
