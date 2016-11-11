/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


public class persona {

    private int idPersona;
    private lector idLector;
    private String cedulaPersona;
    private String nombresPersona;
    private String apellidosPersona;
    private String direccionPersona;
    private String telefonoPersona;
    private String correoElectronico;

    public persona() {
    }

    public persona(int idPersona, lector idLector, String cedulaPersona, String nombresPersona, String apellidosPersona, String direccionPersona, String telefonoPersona, String correoElectronico) {
        this.idPersona = idPersona;
        this.idLector = idLector;
        this.cedulaPersona = cedulaPersona;
        this.nombresPersona = nombresPersona;
        this.apellidosPersona = apellidosPersona;
        this.direccionPersona = direccionPersona;
        this.telefonoPersona = telefonoPersona;
        this.correoElectronico = correoElectronico;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public lector getIdLector() {
        return idLector;
    }

    public void setIdLector(lector idLector) {
        this.idLector = idLector;
    }

    public String getCedulaPersona() {
        return cedulaPersona;
    }

    public void setCedulaPersona(String cedulaPersona) {
        this.cedulaPersona = cedulaPersona;
    }

    public String getNombresPersona() {
        return nombresPersona;
    }

    public void setNombresPersona(String nombresPersona) {
        this.nombresPersona = nombresPersona;
    }

    public String getApellidosPersona() {
        return apellidosPersona;
    }

    public void setApellidosPersona(String apellidosPersona) {
        this.apellidosPersona = apellidosPersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(String telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    
    
}
