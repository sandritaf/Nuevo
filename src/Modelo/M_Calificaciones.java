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
    private int id_tindustrial;
    private int id_tacademico;
    private float promedio_defensa;

    public M_Calificaciones(int idnotas, int id_tesis, int id_tindustrial, int id_tacademico, float promedio_defensa) {
        this.idnotas = idnotas;
        this.id_tesis = id_tesis;
        this.id_tindustrial = id_tindustrial;
        this.id_tacademico = id_tacademico;
        this.promedio_defensa = promedio_defensa;
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

    public int getId_tindustrial() {
        return id_tindustrial;
    }

    public void setId_tindustrial(int id_tindustrial) {
        this.id_tindustrial = id_tindustrial;
    }

    public int getId_tacademico() {
        return id_tacademico;
    }

    public void setId_tacademico(int id_tacademico) {
        this.id_tacademico = id_tacademico;
    }

    public float getPromedio_defensa() {
        return promedio_defensa;
    }

    public void setPromedio_defensa(float promedio_defensa) {
        this.promedio_defensa = promedio_defensa;
    }
    
    
    
}
