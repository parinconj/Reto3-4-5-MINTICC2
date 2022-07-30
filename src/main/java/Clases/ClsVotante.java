/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author parin
 */
public class ClsVotante extends ClsPersona{
    
    private String puestoVotacion;

    public ClsVotante(String puestoVotacion, String numeroDocumento, String nombre, String telefono, String correo) {
        super(numeroDocumento, nombre, telefono, correo);
        this.puestoVotacion = puestoVotacion;
    }

    public String getPuestoVotacion() {
        return puestoVotacion;
    }

    public void setPuestoVotacion(String puestoVotacion) {
        this.puestoVotacion = puestoVotacion;
    }
    
    
    
    
}
