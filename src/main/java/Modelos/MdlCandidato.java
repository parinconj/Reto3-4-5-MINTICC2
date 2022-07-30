/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;


public class MdlCandidato {

    ClsJdbc jdbc = new ClsJdbc();

    public MdlCandidato() {
        jdbc.CrearConexion();
    }

    public ClsMensaje actualizarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje;

        try {

            String sql = "UPDATE tbl_candidatos SET nombre = ?, telefono = ?, "
                    + "correo = ?, partido_politico = ?, descripcion = ? WHERE id_candidato = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNombre());
            sentencia.setString(2, candidato.getTelefono());
            sentencia.setString(3, candidato.getCorreo());
            sentencia.setString(4, candidato.getPartidoPolitico());
            sentencia.setString(5, candidato.getDescripcion());
            sentencia.setString(6, candidato.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El candidato ha sido actualizado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El candidato NO ha sido actualizado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje eliminarCandidato(String idCandidato) {

        ClsMensaje mensaje;

        try {

            String sql = "DELETE FROM tbl_candidatos WHERE id_candidato = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idCandidato);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El candidato ha sido eliminado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El candidato NO ha sido eliminado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            return mensaje;
        }

    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje;

        try {

            String sql = "INSERT INTO tbl_candidatos VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNumeroDocumento());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getCorreo());
            sentencia.setString(5, candidato.getPartidoPolitico());
            sentencia.setString(6, candidato.getDescripcion());
            sentencia.setString(7, candidato.getMensajeCampania());
            sentencia.setString(8, "");

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El candidato ha sido creado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El candidato NO ha sido creado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsCandidato> Obtenercandidatos() {

        try {

            LinkedList<ClsCandidato> candidatos = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_candidatos";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String partido = resultados.getString("partido_politico");
                String numeroDocumento = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String descripcion = resultados.getString("descripcion");

                ClsCandidato candidato = new ClsCandidato(partido, "", numeroDocumento,
                        nombre, telefono, correo);

                candidato.setDescripcion(descripcion);

                candidatos.add(candidato);

            }

            return candidatos;

        } catch (Exception e) {
            return null;
        }

    }

}
