package Controladores;

import Clases.ClsVotante;
import Clases.ClsMensaje;
import Modelos.MdlVotante;
import java.util.LinkedList;


public class CtlVotante {

    MdlVotante modelo;

    public CtlVotante() {
        this.modelo = new MdlVotante();
    }

    public ClsMensaje actualizarVotante(ClsVotante votante) {

        return this.modelo.actualizarVotante(votante);
    }

    public ClsMensaje eliminarVotante(String idVotante) {

        return this.modelo.eliminarVotante(idVotante);
    }

    public ClsMensaje agregarVotante(ClsVotante votante) {

        return this.modelo.agregarVotante(votante);
    }

    public LinkedList<ClsVotante> Obtenervotante() {

        return this.modelo.obtenerVotante();
    }

}
