/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesodatos;
/**
 *
 * @author Usuario
 */
public final  class Global {

     java.util.ResourceBundle Configuracion = java.util.ResourceBundle.getBundle("accesodatos.database");
    
    private String URL=Configuracion.getString("url");
    private String DRIVER = Configuracion.getString("driver");
    private String USER = Configuracion.getString("user");
    private String PASS = Configuracion.getString("password");
    
    //pool de conexiones
    private String JDNI = Configuracion.getString("jdni");

    
    //Mensajes de error
    public final static String MENSAJEERRORDATOS = "Error al procesar la solicitud, revise los datos";
    public final static String MENSAJEERRORSESION = "Su sesi&oacute;n ha caducado, reinicie sesi&oacute;n ";
    public final static String MENSAJEERRORCLAVES = "Las claves no coinciden";

    public String getJDNI() {
        return JDNI;
    }

    public void setJDNI(String JDNI) {
        this.JDNI = JDNI;
    }

    /**
     * @return the URL
     */
    public String getURL() {
        return URL;
    }

    /**
     * @param URL the URL to set
     */
    public void setURL(String URL) {
        this.URL = URL;
    }

    /**
     * @return the DRIVER
     */
    public String getDRIVER() {
        return DRIVER;
    }

    /**
     * @param DRIVER the DRIVER to set
     */
    public void setDRIVER(String DRIVER) {
        this.DRIVER = DRIVER;
    }

    /**
     * @return the USER
     */
    public String getUSER() {
        return USER;
    }

    /**
     * @param USER the USER to set
     */
    public void setUSER(String USER) {
        this.USER = USER;
    }

    /**
     * @return the PASS
     */
    public String getPASS() {
        return PASS;
    }

    /**
     * @param PASS the PASS to set
     */
    public void setPASS(String PASS) {
        this.PASS = PASS;
    }
}
