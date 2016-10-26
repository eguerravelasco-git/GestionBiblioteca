/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import clases.lector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Computador01
 */
public class lectorServicios {

    private final String tipo_lector = "public.lector";

    public void guardar(Connection conexion, lector lector) throws SQLException {
        try {
            PreparedStatement consulta;
            if (lector.getIdLector() != 0) {
                consulta = conexion.prepareStatement("INSERT INTO " + this.tipo_lector + "(descripcion_lector) VALUES(?)");
                consulta.setString(1, lector.getDescripcion());
                consulta.executeUpdate();

            }

        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public void actualizar(Connection conexion, lector lector) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("UPDATE " + this.tipo_lector + " SET  descripcion_lector = ? WHERE id_tipo_lector = ?");
            consulta.setString(1, lector.getDescripcion());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public lector recuperarPorId(Connection conexion, int Id_Lector) throws SQLException {
        lector lector = null;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_tipo_lector,descripcion_lector FROM " + this.tipo_lector + " WHERE id_lector = ?");
            consulta.setInt(1, Id_Lector);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                lector = new lector(resultado.getInt("id_tipo_lector"), resultado.getString("descripcion_lector"));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return lector;
    }

    public void eliminar(Connection conexion, lector lector) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM " + this.tipo_lector + " WHERE id_tipo_lector = ?");
            consulta.setInt(1, lector.getIdLector());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
    }

    public List<lector> recuperarTodas(Connection conexion) throws SQLException {
        List<lector> lstLector = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id_tipo_lector,descripcion_lector FROM " + this.tipo_lector + " ORDER BY descripcion_tipo_lector");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                lstLector.add(new lector(resultado.getInt("id_tipo_lector"), resultado.getString("descripcion_tipo_lector")));
            }
        } catch (SQLException ex) {
            throw new SQLException(ex);
        }
        return lstLector;
    }
}
