/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedList;

public class MdlEleccion {

    ClsJdbc jdbc = new ClsJdbc();

    public MdlEleccion() {
        jdbc.CrearConexion();
    }

    public ClsMensaje agregarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje;

        try {

            String sql = "INSERT INTO tbl_elecciones VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, eleccion.getIdEleccion());
            sentencia.setString(2, eleccion.getDescripcion());
            sentencia.setString(3, eleccion.getTipo());
            sentencia.setString(4, eleccion.getFechaInicio());
            sentencia.setString(5, eleccion.getFechaFin());
            sentencia.setString(6, eleccion.getEstado());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "La eleccion ha sido creada");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "La eleccion NO ha sido creada");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsEleccion> obtenerElecciones() {

        try {

            LinkedList<ClsEleccion> elecciones = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_elecciones";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String idEleccion = resultados.getString("id_eleccion");
                String descripcion = resultados.getString("descripcion");
                String tipo = resultados.getString("tipo_eleccion");
                String fechaInicio = resultados.getString("fecha_inicio");
                String fechaFin = resultados.getString("fecha_fin");
                String estado = resultados.getString("estado");

                ClsEleccion eleccion = new ClsEleccion(idEleccion, descripcion, tipo, fechaInicio, fechaFin, estado);

                elecciones.add(eleccion);

            }

            return elecciones;

        } catch (Exception e) {
            return null;
        }
    }

    public ClsMensaje eliminarEleccion(String idEleccion) {

        ClsMensaje mensaje;

        try {

            String sql = "DELETE FROM tbl_elecciones WHERE id_eleccion = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idEleccion);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "La eleccion ha sido eliminada");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "La eleccion NO ha sido eliminada");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Se detecto un error: " + e.getMessage());
            return mensaje;
        }
    }

    public ClsMensaje actualizarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje;

        try {
            String sql = "UPDATE tbl_elecciones SET id_eleccion = ?, descripcion = ?, tipo_eleccion = ?, "
                    + "fecha_inicio = ?, fecha_fin = ?, estado = ?  WHERE 1";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(2, eleccion.getDescripcion());
            sentencia.setString(3, eleccion.getTipo());
            sentencia.setString(4, eleccion.getFechaInicio());
            sentencia.setString(5, eleccion.getFechaFin());
            sentencia.setString(6, eleccion.getEstado());
            sentencia.setString(1, eleccion.getIdEleccion());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "La eleccion se ha actualizado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "La eleccion  NO se ha actualizado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "SE ENCONTRO UN ERROR: " + e.getMessage());
            return mensaje;
        }

    }
}

/*
    public ClsMensaje asociarCandidatoEleccion(String idCandidato, String idEleccion) {

        ClsMensaje mensaje;

        try {

            String sql = "INSERT INTO tbl_candidatos_x_eleccion VALUES (?, ?, NOW())";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idCandidato);
            sentencia.setString(2, idEleccion);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "Se ha asociado un candidato");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "No se ha podido asociar");
            }

            return mensaje;

        } catch (SQLException e) {
            int code = e.getErrorCode();

            if (code == 1062) {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "Este candidato ya está asociado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            }

            return mensaje;
        }

    }
        
        

    public LinkedList<ClsCandidato> obtenerCandidatosEleccion(String idEleccion) {

        try {

            LinkedList<ClsCandidato> candidatos = new LinkedList<>();

            String consulta = "SELECT tc.* FROM tbl_candidatos_x_eleccion te,"
                    + " tbl_candidatos tc WHERE te.id_eleccion = ? AND "
                    + " te.id_candidato = tc.id_candidato";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            sentencia.setString(1, idEleccion);

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
 */
