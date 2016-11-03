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

/**
 *
 * @author Usuario
 */
public class personaServicios {

    public static boolean insertar(persona persona) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "INSERT INTO public.persona(id_tipo_lector,cedula_persona,nombres_persona,apellidos_persona,direccion_persona,telefono_persona,correo_electronico) VALUES(?,?,?,?,?,?,?)";
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
            String sql = "UPDATE public.persona SET id_tipo_lector=?, SET cedula_persona=?, SET nombres_persona=?, SET apellidos_persona=?, SET direccion_persona=?, SET telefono_persona=?, SET correo_electronico =? WHERE id_tipo_persona = ?";
            lstP.add(new Parametro(1, persona.getIdLector().getIdLector()));
            lstP.add(new Parametro(2, persona.getCedulaPersona()));
            lstP.add(new Parametro(3, persona.getNombresPersona()));
            lstP.add(new Parametro(4, persona.getApellidosPersona()));
            lstP.add(new Parametro(5, persona.getDireccionPersona()));
            lstP.add(new Parametro(6, persona.getTelefonoPersona()));
            lstP.add(new Parametro(7, persona.getCorreoElectronico()));
            lstP.add(new Parametro(8, persona.getIdPersona()));

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
            String sql = "DELETE FROM public.persona WHERE id_tipo_persona = ?";
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
                Persona = new persona(rs.getInt("id_tipo_persona"),lectorServicios.obtenerLectorDadoCodigo(rs.getInt("id_tipo_lector")),
                        rs.getString("cedula_persona"), rs.getString("nombres_persona"),
                        rs.getString("apellidos_persona"), rs.getString("direccion_persona"),
                        rs.getString("telefono_persona"), rs.getString("correo_electronico"));
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
            String sql = "SELECT id_tipo_persona,id_tipo_lector,cedula_persona,nombres_persona,apellidos_persona,direccion_persona,telefono_persona,correo_electronico FROM public.persona ORDER BY nombres_persona";
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
            String sql = "SELECT id_tipo_persona,id_tipo_lector,cedula_persona,nombres_persona,apellidos_persona,direccion_persona,telefono_persona,correo_electronico FROM public.persona WHERE id_persona = ?";
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
