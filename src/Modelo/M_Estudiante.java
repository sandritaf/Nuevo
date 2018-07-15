package Modelo;

public class M_Estudiante {
    private String nombre;
    private String apellido;
    private int carrera;
    private String semestre;
    private String cedula;

    public M_Estudiante() {
    }

    public M_Estudiante(String nombre, String apellido, int carrera, String semestre, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.semestre = semestre;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCarrera() {
        return carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getCedula() {
        return cedula;
    }
    
    public void actualizar(String nombre, String apellido, int carrera, String semestre, String cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.semestre = semestre;
        this.cedula = cedula;
    }
    
}
