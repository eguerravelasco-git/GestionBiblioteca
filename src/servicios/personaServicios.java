/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import clases.persona;
import java.sql.SQLException;
import java.util.ArrayList;


public class personaServicios {

    public static boolean insertar(persona persona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_insert_persona(?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, persona.getIdLector().getIdLector()));
            lstP.add(new Parametro(2, persona.getCedulaPersona()));
            lstP.add(new Parametro(3, persona.getNombresPersona()));
            lstP.add(new Parametro(4, persona.getApellidosPersona()));
            lstP.add(new Parametro(5, persona.getDireccionPersona()));
            lstP.add(new Parametro(6, persona.getTelefonoPersona()));
            lstP.add(new Parametro(7, persona.getCorreoElectronico()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean actualizar(persona persona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_update_persona(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, persona.getIdLector().getIdLector()));
            lstP.add(new Parametro(2, persona.getIdPersona()));
            lstP.add(new Parametro(3, persona.getCedulaPersona()));
            lstP.add(new Parametro(4, persona.getNombresPersona()));
            lstP.add(new Parametro(5, persona.getApellidosPersona()));
            lstP.add(new Parametro(6, persona.getDireccionPersona()));
            lstP.add(new Parametro(7, persona.getTelefonoPersona()));
            lstP.add(new Parametro(8, persona.getCorreoElectronico()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean eliminar(persona persona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_delete_persona(?)";
            lstP.add(new Parametro(1, persona.getIdPersona()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static ArrayList<persona> llenarPersona(ConjuntoResultado rs) throws Exception {
        ArrayList<persona> lst = new ArrayList<persona>();
        persona Persona = null;
        try {
            while (rs.next()) {
                Persona = new persona(rs.getInt("pid_tipo_persona"), lectorServicios.obtenerLectorDadoCodigo(rs.getInt("pid_tipo_lector")),
                        rs.getString("pcedula_persona"), rs.getString("pnombres_persona"),
                        rs.getString("papellidos_persona"), rs.getString("pdireccion_persona"),
                        rs.getString("ptelefono_persona"), rs.getString("pcorreo_electronico"));
                lst.add(Persona);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<persona> obtenerTodos() throws Exception {
        ArrayList<persona> lst = new ArrayList<persona>();
        try {
            String sql = "SELECT * from public.f_select_persona()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPersona(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static persona obtenerPersonaDadoCodigo(int codigo) throws Exception {
        persona objPersona = new persona();
        try {
            String sql = "SELECT * from public.f_select_persona_dado_id(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            objPersona = llenarPersona(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objPersona;
    }

}
