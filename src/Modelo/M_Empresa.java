package Modelo;

public class M_Empresa {
    private String nombre;
    private String rif;
    private String direccion;
    private String gerente;
    private String telefono;

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
    
    
    
}
