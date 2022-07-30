package Controladores;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsMensaje;
import Modelos.MdlEleccion;
import java.util.LinkedList;

public class CtlEleccion {

    MdlEleccion modelo;

    public CtlEleccion() {
        this.modelo = new MdlEleccion();
    }

    public ClsMensaje agregarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje = this.modelo.agregarEleccion(eleccion);
        return mensaje;
    }

    public LinkedList<ClsEleccion> obtenerElecciones() {

        LinkedList<ClsEleccion> elecciones = this.modelo.obtenerElecciones();
        return elecciones;
    }

        public ClsMensaje eliminarEleccion(String idEleccion) {

        return this.modelo.eliminarEleccion(idEleccion);
    }
    
    
    public ClsMensaje actualizarEleccion(ClsEleccion eleccion) {

        return this.modelo.actualizarEleccion(eleccion);
    }
        
   /*
    public ClsMensaje asociarCandidatoEleccion(String idCandidato, String idEleccion) {

        return this.modelo.asociarCandidatoEleccion(idCandidato, idEleccion);

    }

    public LinkedList<ClsCandidato> obtenerCandidatosEleccion(String idEleccion) {

        LinkedList<ClsCandidato> candidatos = this.modelo.obtenerCandidatosEleccion(idEleccion);

        return candidatos;

    }
*/

}


