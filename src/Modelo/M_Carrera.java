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
public class M_Carrera {
    
    private String semestres;
    private String uc_totales;
    private String nombre;
    
    public M_Carrera(){
    }

    public M_Carrera(String semestres, String uc_totales, String nombre) {
        this.semestres = semestres;
        this.uc_totales = uc_totales;
        this.nombre = nombre;
    }
    
    public void actualizar(String semestres, String uc_totales, String nombre) {
        this.semestres = semestres;
        this.uc_totales = uc_totales;
        this.nombre = nombre;
    }

    public String getSemestres() {
        return semestres;
    }

    public String getUc_totales() {
        return uc_totales;
    }

    public String getNombre() {
        return nombre;
    }


  
    
}
