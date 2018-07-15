package Modelo;

import java.sql.Date;

public class M_Tesis {
    
    private int idtesis;
    private String status;
    private String titulo;
    private Date f_inicio;
    private Date f_fin;
    private int nota_tacademico;
    private int nota_tindustrial;
    private int nota_defensa;
    private String observaciones;
    private String departamento;
    private int nota_final;
    private int id_tutorAcademico;
    private int id_tutorIndustrial;
    private int estudiante_tesis;
    

    public M_Tesis(){
    }

    public M_Tesis(String status, String titulo, String observaciones) {
        this.status = status;
        this.titulo = titulo;
        this.observaciones = observaciones;
    }
    
    public M_Tesis(String status, String titulo, Date f_inicio, Date f_fin, String observaciones, String departamento) {
        this.status = status;
        this.titulo = titulo;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.observaciones = observaciones;
        this.departamento = departamento;
    }
    
    public M_Tesis(String status, String titulo, int nota_tacademico, int nota_tindustrial, int nota_defensa, 
            String observaciones, String departamento, float nota_final, Date f_inicio, Date f_fin){
        this.status="";
        this.titulo="";
        this.nota_tacademico=0;
        this.nota_tindustrial=0;
        this.nota_defensa=0;
        this.observaciones="";
        this.departamento="";
        this.nota_final=0;
        this.f_inicio = null;
        this.f_fin = null;
        
    }
    
    public int getIdtesis() {
        return idtesis;
    }

    public void setIdtesis(int idtesis) {
        this.idtesis = idtesis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getF_inicio() {
        return f_inicio;
    }

    public void setF_inicio(Date f_inicio) {
        this.f_inicio = f_inicio;
    }

    public Date getF_fin() {
        return f_fin;
    }

    public void setF_fin(Date f_fin) {
        this.f_fin = f_fin;
    }

    public int getNota_tacademico() {
        return nota_tacademico;
    }

    public void setNota_tacademico(int nota_tacademico) {
        this.nota_tacademico = nota_tacademico;
    }

    public int getNota_tindustrial() {
        return nota_tindustrial;
    }

    public void setNota_tindustrial(int nota_tindustrial) {
        this.nota_tindustrial = nota_tindustrial;
    }

    public int getNota_defensa() {
        return nota_defensa;
    }

    public void setNota_defensa(int nota_defensa) {
        this.nota_defensa = nota_defensa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getNota_final() {
        return nota_final;
    }

    public void setNota_final(int nota_final) {
        this.nota_final = nota_final;
    }

    public int getId_tutorAcademico() {
        return id_tutorAcademico;
    }

    public void setId_tutorAcademico(int id_tutorAcademico) {
        this.id_tutorAcademico = id_tutorAcademico;
    }

    public int getId_tutorIndustrial() {
        return id_tutorIndustrial;
    }

    public void setId_tutorIndustrial(int id_tutorIndustrial) {
        this.id_tutorIndustrial = id_tutorIndustrial;
    }

    public int getEstudiante_tesis() {
        return estudiante_tesis;
    }

    public void setEstudiante_tesis(int estudiante_tesis) {
        this.estudiante_tesis = estudiante_tesis;
    }
    
}
