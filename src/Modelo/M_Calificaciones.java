/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author brenda
 */
public class M_Calificaciones {
   
    private int idnotas;
    private int id_tesis;
    private int n_tindustrial;
    private int n_tacademico;
    private int n_promdefensa;
    private int n_final;

    public M_Calificaciones(int idnotas, int id_tesis, int n_tindustrial, int n_tacademico, int n_promdefensa, int n_final) {
        this.idnotas = idnotas;
        this.id_tesis = id_tesis;
        this.n_tindustrial = n_tindustrial;
        this.n_tacademico = n_tacademico;
        this.n_promdefensa = n_promdefensa;
        this.n_final = n_final;
    }

    public int getIdnotas() {
        return idnotas;
    }

    public void setIdnotas(int idnotas) {
        this.idnotas = idnotas;
    }

    public int getId_tesis() {
        return id_tesis;
    }

    public void setId_tesis(int id_tesis) {
        this.id_tesis = id_tesis;
    }

    public int getN_tindustrial() {
        return n_tindustrial;
    }

    public void setN_tindustrial(int n_tindustrial) {
        this.n_tindustrial = n_tindustrial;
    }

    public int getN_tacademico() {
        return n_tacademico;
    }

    public void setN_tacademico(int n_tacademico) {
        this.n_tacademico = n_tacademico;
    }

    public int getN_promdefensa() {
        return n_promdefensa;
    }

    public void setN_promdefensa(int n_promdefensa) {
        this.n_promdefensa = n_promdefensa;
    }
    
    public void calculoPromedio(){
        
    }
    
    public int calculo_nfinal(){
        int n_ti = (int) (n_tindustrial*0.35);
        int n_ta = (int) (n_tacademico*0.25);
        int n_defensa = (int) (n_promdefensa*0.40); 
        
        return n_ti + n_ta + n_defensa;
    }
    
}
