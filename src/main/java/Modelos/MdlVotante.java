/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsVotante;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;


public class MdlVotante {

    ClsJdbc jdbc = new ClsJdbc();

    public MdlVotante() {
        jdbc.CrearConexion();
    }

    public ClsMensaje actualizarVotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {

            String sql = "UPDATE tbl_votantes SET nombre = ?, telefono = ?, "
                    + "correo = ?, puesto_votacion = ? WHERE id_votantes = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getTelefono());
            sentencia.setString(3, votante.getCorreo());
            sentencia.setString(4, votante.getPuestoVotacion());
            sentencia.setString(5, votante.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El votante ha sido actualizado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El votante NO ha sido actualizado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje eliminarVotante(String idVotante) {

        ClsMensaje mensaje;

        try {

            String sql = "DELETE FROM tbl_votantes WHERE id_votantes = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idVotante);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El votante ha sido eliminado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El votante NO ha sido eliminado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, " error: " + e.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {

            String sql = "INSERT INTO tbl_votantes VALUES (?, ?, ?, ?,?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNumeroDocumento());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            sentencia.setString(5, votante.getPuestoVotacion());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El votante ha sido creado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El votante NO ha sido creado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsVotante> obtenerVotante() {

        try {

            LinkedList<ClsVotante> votantes = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_votantes";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String numeroDocumento = resultados.getString("id_votantes");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String puestoVotacion = resultados.getString("puesto_votacion");

                ClsVotante votante = new ClsVotante(puestoVotacion, numeroDocumento, nombre, telefono, correo);
                       

                votantes.add(votante);

            }

            return votantes;

        } catch (Exception e) {
            return null;
        }

    }

}
