/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import clases.prestamos;
import java.sql.SQLException;
import java.util.*;


public class prestamosServicio {
    public static boolean insertar(prestamos prestamos) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "INSERT INTO public.prestamos(id_persona,id_bibliografia,fecha_retiro,devolucion,observaciones) VALUES(?,?,?,?,?)";
            lstP.add(new Parametro(1, prestamos.getIdPersona().getIdPersona()));
            lstP.add(new Parametro(2, prestamos.getIdBibliografia().getIdBibliografia()));
            lstP.add(new Parametro(3, prestamos.getFecha_retiro()));
            lstP.add(new Parametro(4, prestamos.isDevolucion()));
            lstP.add(new Parametro(5, prestamos.getObservaciones()));
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

    public static boolean actualizar(prestamos prestamos) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "UPDATE public.prestamos SET id_persona=?, SET id_bibliografia=?, SET fecha_retiro=?, SET devolucion=?, SET observaciones=? WHERE id_prestamos=?";
            lstP.add(new Parametro(1, prestamos.getIdPersona().getIdPersona()));
            lstP.add(new Parametro(2, prestamos.getIdBibliografia().getIdBibliografia()));
            lstP.add(new Parametro(3, prestamos.getFecha_retiro()));
            lstP.add(new Parametro(4, prestamos.isDevolucion()));
            lstP.add(new Parametro(5, prestamos.getObservaciones()));
            lstP.add(new Parametro(6, prestamos.getIdPrestamos()));

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

    public static boolean eliminar(prestamos prestamos) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "DELETE FROM public.prestamos WHERE id_prestamos=?";
            lstP.add(new Parametro(1, prestamos.getIdPrestamos()));
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

    public static ArrayList<prestamos> llenarPrestamos(ConjuntoResultado rs) throws Exception {
        ArrayList<prestamos> lst = new ArrayList<prestamos>();
       prestamos Prestamos = null;
        try {
            while (rs.next()) {
                Prestamos = new prestamos(rs.getInt("id_prestamos"),personaServicios.obtenerPersonaDadoCodigo(rs.getInt("id_persona")),
                        bibliografiaServicios.obtenerBibliografiaDadoCodigo(rs.getInt("id_bibliografia")), rs.getDate("fecha_retiro"),
                        rs.getBoolean("devolucion"), rs.getString("observaciones"));
                lst.add(Prestamos);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<prestamos> obtenerTodos() throws Exception {
        ArrayList<prestamos> lst = new ArrayList<prestamos>();
        try {
            String sql = "SELECT id_prestamos,id_persona,id_bibliografia,fecha_retiro,devolucion,observaciones FROM public.prestamos ORDER BY id_prestamos";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarPrestamos(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static prestamos obtenerPrestamosDadoCodigo(int codigo) throws Exception {
        prestamos objPersona = new prestamos();
        try {
            String sql = "SELECT id_prestamos,id_persona,id_bibliografia,fecha_retiro,devolucion,observaciones FROM public.prestamos WHERE id_prestamos = ?";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            objPersona = llenarPrestamos(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objPersona;
    }

}
