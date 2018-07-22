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

    public int getId_tesis() {
        return id_tesis;
    }

    public int getN_tindustrial() {
        return n_tindustrial;
    }

    public int getN_tacademico() {
        return n_tacademico;
    }

    public int getN_promdefensa() {
        return n_promdefensa;
    }

    public int getN_final() {
        return n_final;
    }

    public int getN_j1() {
        return n_j1;
    }

    public int getN_j2() {
        return n_j2;
    }
    
    public void imprimir(){
        System.out.println("Defensa: "+n_promdefensa+
        " Jurado 1: "+n_j1+
         " Jurado2 "+n_j2+
         " Industrial: "+n_tindustrial+
         " Academico: "+n_tacademico+
         " Final: "+n_final);
    }
    
    
    public void actualizar(int pk, int n_tindustrial, int n_tacademico, 
            int n_j1, int n_j2, int n_promdefensa, int n_final){
        this.idnotas = pk;
        this.n_tindustrial = n_tindustrial;
        this.n_tacademico = n_tacademico;
        this.n_promdefensa = n_promdefensa;
        this.n_final = n_final;
        this.n_j1 = n_j1;
        this.n_j2 = n_j2;
    }
    
}
