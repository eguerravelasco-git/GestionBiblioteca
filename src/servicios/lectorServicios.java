/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import clases.lector;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class lectorServicios {
    
    public static boolean insertar(lector lector) throws Exception {
        boolean eje=false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_insert_tipo_lector(?)";

            lstP.add(new Parametro(1, lector.getDescripcion()));            
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).isEmpty());
                eje=true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
    
    public static boolean actualizar(lector lector) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_update_tipo_lector(?,?)";
             lstP.add(new Parametro(1, lector.getDescripcion()));
             lstP.add(new Parametro(2, lector.getIdLector()));
             
            
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
    
    public static boolean eliminar(lector lector) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_delete_tipo_lector(?)";
            lstP.add(new Parametro(1, lector.getIdLector()));
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
    
    public static ArrayList<lector> llenarLector(ConjuntoResultado rs) throws Exception {
        ArrayList<lector> lst = new ArrayList<lector>();
        lector Lector = null;
        try {
            while (rs.next()) {
                Lector = new lector(rs.getInt("pid_tipo_lector"),
                        rs.getString("pdescripcion_lector"));
                lst.add(Lector);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<lector> obtenerTodos() throws Exception {
        ArrayList<lector> lst = new ArrayList<lector>();
        try {
            String sql = "SELECT * FROM public.f_select_tipo_lector()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarLector(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static lector obtenerLectorDadoCodigo(int codigo) throws Exception {
        lector objLector = new lector();
        try {
            String sql = "SELECT * FROM public.f_select_tipo_lector_dado_id(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objLector = llenarLector(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objLector;
    }
   
}
