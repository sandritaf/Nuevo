package Modelo;

public class M_Estudiante {
    private String nombre;
    private String apellido;
    private String carrera;
    private String semestre;
    private String cedula;

    public M_Estudiante() {
    }

    public M_Estudiante(String nombre, String apellido, String carrera, String semestre, String cedula) {
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

    public String getCarrera() {
        return carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getCedula() {
        return cedula;
    }
    
    
}
