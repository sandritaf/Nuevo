package Modelo;


public class M_Tesis {
    
    private String status;
    private String titulo;
    private String f_inicio;
    private String f_fin;
    private String observaciones;
    private String departamento;
    private int id_tutorAcademico;
    private int id_tutorIndustrial;
    private int estudiante_tesis;
    private int empresa;
    
    /*Esta clase permite manipular valores que se desean ingresar como un registro nuevo
    en la tabla "tesis" de la base de datos, de manera que los valores ingresados por
    los usuarios se guardan en una instancia de M_Tesis y se reciben en el controlador
    que es la clase desde donde se haran las consultas que insertaran los registros nuevos"
    */

    public M_Tesis(){
    }

    public M_Tesis(String status, String titulo, String observaciones) {
        this.status = status;
        this.titulo = titulo;
        this.observaciones = observaciones;
    }
    
    /*public float nota_final(){
        float n_ti = (float) (nota_tindustrial*0.35);
        float n_ta = (float) (nota_tacademico*0.25);
        float n_defensa = (float) (nota_defensa*0.40); 
        
        return nota_final = n_ti + n_ta + n_defensa;
    }*/

    public M_Tesis(String status, String titulo, String f_inicio, String f_fin, String observaciones, 
            String departamento, int id_tutorAcademico, int id_tutorIndustrial, int estudiante_tesis) {
        this.status = status;
        this.titulo = titulo;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.observaciones = observaciones;
        this.departamento = departamento;
        this.id_tutorAcademico = id_tutorAcademico;
        this.id_tutorIndustrial = id_tutorIndustrial;
        this.estudiante_tesis = estudiante_tesis;
        this.empresa = empresa;
    }
    
    public void actualizar(String status, String titulo, String f_inicio, String f_fin, String observaciones, 
            String departamento, int id_tutorAcademico, int id_tutorIndustrial, int estudiante_tesis, int empresa) {
        this.status = status;
        this.titulo = titulo;
        this.f_inicio = f_inicio;
        this.f_fin = f_fin;
        this.observaciones = observaciones;
        this.departamento = departamento;
        this.id_tutorAcademico = id_tutorAcademico;
        this.id_tutorIndustrial = id_tutorIndustrial;
        this.estudiante_tesis = estudiante_tesis;
        this.empresa = empresa;
    }

    public String getStatus() {
        return status;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getF_inicio() {
        return f_inicio;
    }

    public String getF_fin() {
        return f_fin;
    }
    
    public int getEmpresa(){
        return empresa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getDepartamento() {
        return departamento;
    }

    public int getId_tutorAcademico() {
        return id_tutorAcademico;
    }

    public int getId_tutorIndustrial() {
        return id_tutorIndustrial;
    }

    public int getEstudiante_tesis() {
        return estudiante_tesis;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setF_inicio(String f_inicio) {
        this.f_inicio = f_inicio;
    }

    public void setF_fin(String f_fin) {
        this.f_fin = f_fin;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setId_tutorAcademico(int id_tutorAcademico) {
        this.id_tutorAcademico = id_tutorAcademico;
    }

    public void setId_tutorIndustrial(int id_tutorIndustrial) {
        this.id_tutorIndustrial = id_tutorIndustrial;
    }

    public void setEstudiante_tesis(int estudiante_tesis) {
        this.estudiante_tesis = estudiante_tesis;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }      
    
}
