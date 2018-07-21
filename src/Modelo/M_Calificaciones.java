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
    private int n_j1;
    private int n_j2;

    public M_Calificaciones() {
    }

    public M_Calificaciones(int id_tesis, int n_tindustrial, int n_tacademico, int n_j1, int n_j2, int n_promdefensa, int n_final) {
        this.id_tesis = id_tesis;
        this.n_tindustrial = n_tindustrial;
        this.n_tacademico = n_tacademico;
        this.n_promdefensa = n_promdefensa;
        this.n_final = n_final;
        this.n_j1 = n_j1;
        this.n_j2 = n_j2;
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

    public int getN_final() {
        int n_ti = (int) (n_tindustrial*0.35);
        int n_ta = (int) (n_tacademico*0.25);
        int n_defensa = (int) (n_promdefensa*0.40); 
        return n_ti + n_ta + n_defensa;
    }

    public void setN_final(int n_final) {
        this.n_final = n_final;
    }
    
    public int getNotaFinal(int nota_ti, int nota_ta, int nota_prom){
        int n_ti = (int) (nota_ti*0.35);
        int n_ta = (int) (nota_ta*0.25);
        int n_defensa = (int) (nota_prom*0.40); 
                
        return n_ti + n_ta + n_defensa;
    }
    
        public int getN_j1() {
        return n_j1;
    }

    public void setNota_j1(int n_j1) {
        this.n_j1 = n_j1;
    }

    public int getN_j2() {
        return n_j2;
    }

    public void setN_j2(int n_j2) {
        this.n_j2 = n_j2;
    }
    
    public int getPromedio(){
        return (n_j1+n_j2)/2;
    }
    
    public int getPromedio(int nj1, int nj2){
        return (nj1+nj2)/2;
    }
    
}
