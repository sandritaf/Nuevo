package Modelo;

public class M_Empresa {
    private String nombre;
    private String rif;
    private String direccion;
    private String gerente;
    private String telefono;

    /*Esta clase permite manipular valores que se desean ingresar como un registro nuevo
    en la tabla "empresa" de la base de datos, de manera que los valores ingresados por
    los usuarios se guardan en una instancia de M_Empresa y se reciben en el controlador
    que es la clase desde donde se haran las consultas que insertaran los registros nuevos"
    */
    
    public M_Empresa() {
    }

       
    public M_Empresa(String nombre, String rif, String direccion, String gerente, String telefono) {
        this.nombre = nombre;
        this.rif = rif;
        this.direccion = direccion;
        this.gerente = gerente;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRif() {
        return rif;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getGerente() {
        return gerente;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public void actualizar(String nombre, String rif, String direccion, String gerente, String telefono) {
        this.nombre = nombre;
        this.rif = rif;
        this.direccion = direccion;
        this.gerente = gerente;
        this.telefono = telefono;
    }
    
}
