package Modelo;

public class M_TutorIndustrial {
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private int id_empresa;

    /*Esta clase permite manipular valores que se desean ingresar como un registro nuevo
    en la tabla "tutor industrial" de la base de datos, de manera que los valores ingresados por
    los usuarios se guardan en una instancia de M_TutorIndustrial y se reciben en el controlador
    que es la clase desde donde se haran las consultas que insertaran los registros nuevos"
    */
    
    public M_TutorIndustrial() {
    }
    
    public M_TutorIndustrial(String nombre, String apellido, String cedula, String telefono, int id_empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.id_empresa = id_empresa;
    }
    
    public void actualizar(String nombre, String apellido, String cedula, String telefono, int id_empresa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.telefono = telefono;
        this.id_empresa = id_empresa;
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

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }
    
    
    
}
