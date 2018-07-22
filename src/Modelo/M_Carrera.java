package Modelo;

public class M_Carrera {
    
    private String semestres;
    private String uc_totales;
    private String nombre;
    
    /*Esta clase permite manipular valores que se desean ingresar como un registro nuevo
    en la tabla "carreras" de la base de datos, de manera que los valores ingresados por
    los usuarios se guardan en una instancia de M_Carrera y se reciben en el controlador
    que es la clase desde donde se haran las consultas que insertaran los registros nuevos"
    */
    
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
