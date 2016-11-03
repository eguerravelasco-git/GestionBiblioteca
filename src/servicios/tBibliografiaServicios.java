/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import clases.tBibliografia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class tBibliografiaServicios {
    public static boolean insertar(tBibliografia tBibliografia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = " INSERT INTO public.tipo_bibliografia(nombre_bibliografia,descripcion_tipo_bibliografia) VALUES(?,?)";
            lstP.add(new Parametro(1, tBibliografia.getNombreBibliografia()));
            lstP.add(new Parametro(2, tBibliografia.getDescripcionTBibliografia()));
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
    
    public static boolean actualizar(tBibliografia tBibliografia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "UPDATE public.tipo_bibliografia SET  nombre_bibliografia =?, SET descripcion_tipo_bibliografia = ? WHERE id_tipo_bibliografia = ?";
             lstP.add(new Parametro(1, tBibliografia.getNombreBibliografia()));
            lstP.add(new Parametro(2, tBibliografia.getDescripcionTBibliografia()));
             lstP.add(new Parametro(3, tBibliografia.getIdTBibliografia()));
            
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
    
    public static boolean eliminar(tBibliografia tBibliografia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "DELETE FROM public.tipo_bibliografia WHERE id_tipo_bibliografia = ?";
            lstP.add(new Parametro(1, tBibliografia.getIdTBibliografia()));
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
    
    public static ArrayList<tBibliografia> llenarTipoBibliografia(ConjuntoResultado rs) throws Exception {
        ArrayList<tBibliografia> lst = new ArrayList<tBibliografia>();
        tBibliografia TBibliografia = null;
        try {
            while (rs.next()) {
                TBibliografia = new tBibliografia(rs.getInt("id_tipo_bibliografia"),
                        rs.getString("nombre_bibliografia"),rs.getString("descripcion_tipo_bibliografia"));
                lst.add(TBibliografia);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<tBibliografia> obtenerTodos() throws Exception {
        ArrayList<tBibliografia> lst = new ArrayList<tBibliografia>();
        try {
            String sql = "SELECT id_tipo_bibliografia,nombre_bibliografia, descripcion_tipo_bibliografia FROM public.tipo_bibliografia ORDER BY nombre_bibliografia";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarTipoBibliografia(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }
    
     public static tBibliografia obtenerDadoCodigo(int codigo) throws Exception {
        tBibliografia objTBibliografia = new tBibliografia();
        try {
            String sql = "SELECT id_tipo_bibliografia,nombre_bibliografia, descripcion_tipo_bibliografia FROM public.tipo_bibliografia WHERE id_tipo_bibliografia = ?";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>(); 
            lstP .add(new Parametro(1,codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql,lstP);
            objTBibliografia = llenarTipoBibliografia(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objTBibliografia;
    }
   
}
