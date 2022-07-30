/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author parin
 */
public class ClsVotarCandidato {
  
    private String idCandidato;
    private String idVotante;
    private int conteoVotos;
    

    public ClsVotarCandidato(String idCandidato, String idVotante) {
        this.idCandidato = idCandidato;
        this.idVotante = idVotante;
    }

        public ClsVotarCandidato(String idCandidato, int conteoVotos) {
        this.idCandidato = idCandidato;
        this.conteoVotos = conteoVotos;
    }

    public int getConteoVotos() {
        return conteoVotos;
    }

    public void setConteoVotos(int conteoVotos) {
        this.conteoVotos = conteoVotos;
    }
    
        
        
       
    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getIdVotante() {
        return idVotante;
    }

    public void setIdVotante(String idVotante) {
        this.idVotante = idVotante;
    }


    
    
    
}
