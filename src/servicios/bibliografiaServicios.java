/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import accesodatos.Parametro;
import clases.bibliografia;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class bibliografiaServicios {
    public static boolean insertar(bibliografia bibliografia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_insert_bibliografia(?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, bibliografia.getIdTBibliografia().getIdTBibliografia()));
            lstP.add(new Parametro(2, bibliografia.getTituloBibliografia()));
            lstP.add(new Parametro(3, bibliografia.getAutorBibliografia()));
            lstP.add(new Parametro(4, bibliografia.getMateriaBibliografia()));
            lstP.add(new Parametro(5, bibliografia.getEditorialBibliografia()));
            lstP.add(new Parametro(6, bibliografia.getEdicionBibliografia()));
            lstP.add(new Parametro(7, bibliografia.getFechaPublicacion()));
            lstP.add(new Parametro(8, bibliografia.getValoracionBibliografia()));
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

    public static boolean actualizar(bibliografia bibliografia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_update_bibliografia(?,?,?,?,?,?,?,?,?)";
            lstP.add(new Parametro(1, bibliografia.getIdBibliografia()));
            lstP.add(new Parametro(2, bibliografia.getIdTBibliografia().getIdTBibliografia()));
            lstP.add(new Parametro(3, bibliografia.getTituloBibliografia()));
            lstP.add(new Parametro(4, bibliografia.getAutorBibliografia()));
            lstP.add(new Parametro(5, bibliografia.getMateriaBibliografia()));
            lstP.add(new Parametro(6, bibliografia.getEditorialBibliografia()));
            lstP.add(new Parametro(7, bibliografia.getEdicionBibliografia()));
            lstP.add(new Parametro(8, bibliografia.getFechaPublicacion()));
            lstP.add(new Parametro(9, bibliografia.getValoracionBibliografia()));
            

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

    public static boolean eliminar(bibliografia bibliografia) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from public.f_delete_bibliografia(?)";
            lstP.add(new Parametro(1, bibliografia.getIdBibliografia()));
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

    public static ArrayList<bibliografia> llenarBibliografia(ConjuntoResultado rs) throws Exception {
        ArrayList<bibliografia> lst = new ArrayList<bibliografia>();
        bibliografia Bibliografia = null;
        try {
            while (rs.next()) {
                Bibliografia = new bibliografia(rs.getInt("pid_bibliografia"),tBibliografiaServicios.obtenerDadoCodigo(rs.getInt("pid_tipo_bibliografia")),
                        rs.getString("ptitulo_bibliografia"), rs.getString("pautor_bibliografia"),
                        rs.getString("pmateria_bibliografia"), rs.getString("peditorial_bibliografia"),
                        rs.getString("pedicion_bibliografia"), rs.getDate("pfecha_publicacion"),rs.getDouble("pvaloracion_bibliografia"));
                lst.add(Bibliografia);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<bibliografia> obtenerTodos() throws Exception {
        ArrayList<bibliografia> lst = new ArrayList<bibliografia>();
        try {
            String sql = "SELECT * from public.f_select_bibliografia()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarBibliografia(rs);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static bibliografia obtenerBibliografiaDadoCodigo(int codigo) throws Exception {
        bibliografia objBibliografia = new bibliografia();
        try {
            String sql = "SELECT * from public.f_select_bibliografia_dado_id(?)";
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            objBibliografia = llenarBibliografia(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return objBibliografia;
    }

}
