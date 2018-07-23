package Logica;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Reportes {

    private String ruta;
    private JTable tabla;
    
    public Reportes() {
    }
    
    public Reportes(String ruta, JTable tabla) {
        this.ruta = ruta;
        this.tabla = tabla;
    }
    
    public void cargarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Nombre");
        modelo.addColumn("Extensión");
        modelo.addColumn("Leíble");
        modelo.addColumn("Fecha de Modificación");
        modelo.addColumn("Traspasar");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Nombre Completo");
    }
    
    public void ExportarPDF(){
        
    }
    
}
