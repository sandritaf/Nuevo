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
    
    private int idcarrera;
    private int semestres;
    private int uc_totales;
    private String nombre;
    
    public M_Carrera(){
    }

    public M_Carrera(int idcarrera, int semestres, int uc_totales, String nombre) {
        this.idcarrera = idcarrera;
        this.semestres = semestres;
        this.uc_totales = uc_totales;
        this.nombre = nombre;
    }

    public int getIdcarrera() {
        return idcarrera;
    }

    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    public int getSemestres() {
        return semestres;
    }

    public void setSemestres(int semestres) {
        this.semestres = semestres;
    }

    public int getUc_totales() {
        return uc_totales;
    }

    public void setUc_totales(int uc_totales) {
        this.uc_totales = uc_totales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
