package Reportes;

import Logica.ControladorEstudiante;
import Modelo.M_Estudiante;
import Modelo.R_Estudiante;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ecastillo
 */
public class Reportes {

    String ruta;
    
    public Reportes() {
        ruta = "C:\\Users\\Ecastillo\\Documents\\NetBeansProjects\\Nuevo"+
                "\\src\\Reportes\\reportesalumnos.jrxml";
    }
    
    public R_Estudiante getEstudiante(int codigo){
        ControladorEstudiante controlador = new ControladorEstudiante();
        return controlador.obtenerEstudiante(codigo);
    }
    
    public void generarReporte(JTable Tabla){
        int fila;
        int codigo;
        List lista = new ArrayList();
        for (int i=0; i<Tabla.getRowCount(); i++){
            codigo = (int) Tabla.getValueAt(i, 0);
            R_Estudiante estudiantes = getEstudiante(codigo);
            lista.add(estudiantes);
        }

        try {
            JasperReport reporte = JasperCompileManager.compileReport(ruta);

            Map parametro = new HashMap();
           /* parametro.put("desde", Desde);
            parametro.put("hasta", Hasta);*/
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

            JasperViewer.viewReport(jprint, false);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error en reporte de alumnos: "+e);
        }
    }
}
