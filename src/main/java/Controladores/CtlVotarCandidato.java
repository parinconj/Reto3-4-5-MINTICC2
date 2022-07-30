/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ClsVotarCandidato;
import Clases.ClsMensaje;
import Modelos.MdlVotarCandidato;
import java.util.LinkedList;

public class CtlVotarCandidato {

    MdlVotarCandidato modeloVoto;

    public CtlVotarCandidato() {
        this.modeloVoto = new MdlVotarCandidato();
    }

    public ClsMensaje agregarVoto(ClsVotarCandidato voto) {

        return this.modeloVoto.agregarVoto(voto);
    }

    public LinkedList<ClsVotarCandidato> ObtenerVotos() {

        return this.modeloVoto.ObtenerVotos();
    }

    
     public LinkedList<ClsVotarCandidato> ContarVotos() {

        return this.modeloVoto.ContarVotos();
    }  
    
    
}
