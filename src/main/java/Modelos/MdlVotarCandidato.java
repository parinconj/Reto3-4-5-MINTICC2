/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import Clases.ClsVotarCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class MdlVotarCandidato {

    ClsJdbc jdbc = new ClsJdbc();

    public MdlVotarCandidato() {
        jdbc.CrearConexion();
    }

    public ClsMensaje agregarVoto(ClsVotarCandidato voto) {

        ClsMensaje mensaje;

        try {

            String sql = "INSERT INTO tbl_votos VALUES (?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, voto.getIdCandidato());
            sentencia.setString(2, voto.getIdVotante());
            //sentencia.setString(3, "");

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje = new ClsMensaje(ClsMensaje.OK, "El Voto ha sido registrado");
            } else {
                mensaje = new ClsMensaje(ClsMensaje.ERROR, "El Voto NO ha sido ");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy un error: " + e.getMessage());
            return mensaje;
        }

    }

    public LinkedList<ClsVotarCandidato> ObtenerVotos() {

        try {

            LinkedList<ClsVotarCandidato> votos = new LinkedList<>();

            String consulta = "SELECT * FROM tbl_votos";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String idCandidato = resultados.getString("id_candidato");
                String idVotante = resultados.getString("id_votantes");

                ClsVotarCandidato voto = new ClsVotarCandidato(idCandidato, idVotante);

                votos.add(voto);

            }

            return votos;

        } catch (Exception e) {
            return null;
        }

    }

        public LinkedList<ClsVotarCandidato> ContarVotos() {

        try {

            LinkedList<ClsVotarCandidato> conteos = new LinkedList<>();

            String consulta = "SELECT id_candidato, COUNT( id_candidato ) AS total FROM  tbl_votos GROUP BY id_candidato ORDER BY total DESC;";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);

            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String idCandidato = resultados.getString("id_candidato");
                int total = resultados.getInt("total");

                ClsVotarCandidato conteo = new ClsVotarCandidato(idCandidato, total);

                conteos.add(conteo);

            }

            return conteos;

        } catch (Exception e) {
            return null;
        }

    }
    
    
}
