package Controladores;

import Clases.ClsCandidato;
import Clases.ClsMensaje;
import Modelos.MdlCandidato;
import java.util.LinkedList;


public class CtlCandidato {

    MdlCandidato modelo;

    public CtlCandidato() {
        this.modelo = new MdlCandidato();
    }

    public ClsMensaje actualizarCandidato(ClsCandidato candidato) {

        return this.modelo.actualizarCandidato(candidato);
    }

    public ClsMensaje eliminarCandidato(String idCandidato) {

        return this.modelo.eliminarCandidato(idCandidato);
    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        return this.modelo.agregarCandidato(candidato);
    }

    public LinkedList<ClsCandidato> Obtenercandidatos() {

        return this.modelo.Obtenercandidatos();
    }

}
