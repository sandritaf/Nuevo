/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author brenda
 */
public class M_Defensa {

    private int iddefensa;
    private Date fecha;
    private Time hora;
    private int aula;
    private String periodo;
    private int id_tesis;
    private int nota_j1;
    private int nota_j2;

    public M_Defensa() {
    }

    public M_Defensa(int iddefensa, Date fecha, Time hora, int aula, String periodo, int id_tesis, int nota_j1, int nota_j2) {
        this.iddefensa = iddefensa;
        this.fecha = fecha;
        this.hora = hora;
        this.aula = aula;
        this.periodo = periodo;
        this.id_tesis = id_tesis;
        this.nota_j1 = nota_j1;
        this.nota_j2 = nota_j2;
    }
    
    

    public int getIddefensa() {
        return iddefensa;
    }

    public void setIddefensa(int iddefensa) {
        this.iddefensa = iddefensa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getId_tesis() {
        return id_tesis;
    }

    public void setId_tesis(int id_tesis) {
        this.id_tesis = id_tesis;
    }

    public int getNota_j1() {
        return nota_j1;
    }

    public void setNota_j1(int nota_j1) {
        this.nota_j1 = nota_j1;
    }

    public int getNota_j2() {
        return nota_j2;
    }

    public void setNota_j2(int nota_j2) {
        this.nota_j2 = nota_j2;
    }
    
    
    
}
