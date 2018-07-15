package Modelo;

public class M_Profesor {

    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String profesion;
    private String direccion;
    private int carrera;
    
    public M_Profesor(){
    }
    
    public M_Profesor(String nombre, String apellido, String cedula, String telefono, String profesion, String direccion, int carrera){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.profesion = profesion;
        this.direccion = direccion;
        this.carrera = carrera;
    }

      public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCarrera() {
        return carrera;
    }

    public void actualizar(String nombre, String apellido, String cedula, String telefono, String profesion, String direccion, int carrera){
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.profesion = profesion;
        this.direccion = direccion;
        this.carrera = carrera;
    }
    
    
}
