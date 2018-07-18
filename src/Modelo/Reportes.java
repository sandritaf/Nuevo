/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Ecastillo
 */
public class Reportes {

    public Reportes() {
    }
    
    public void generarReporte(){
        /*String Desde = (String) cmbAnioDesde.getSelectedItem() + "-" +(String) cmbMesDesde.getSelectedItem() +
                             "-" + (String) cmbDiaDesde.getSelectedItem();
        String Hasta = (String) cmbAnioHasta.getSelectedItem() + "-" +(String) cmbMesHasta.getSelectedItem() +
                             "-" + (String) cmbDiaHasta.getSelectedItem();

        List lista = new ArrayList();
        for (int i=0; i<TablaVentas.getRowCount(); i++){
            listaventas ventas = new listaventas(TablaVentas.getValueAt(i, 0).toString(), TablaVentas.getValueAt(i, 1).toString());
            lista.add(ventas);
        }

        try {
            JasperReport reporte = JasperCompileManager.compileReport("C:\\Users\\Ecastillo\\Documents\\NetBeansProjects\\PROYECTO_DOMINGO\\"+
                "ProyectoDomingo10y30pm\\src\\Reportes\\reporteventas.jrxml");

            Map parametro = new HashMap();
            parametro.put("desde", Desde);
            parametro.put("hasta", Hasta);
            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, new JRBeanCollectionDataSource(lista));

            JasperViewer.viewReport(jprint, false);

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }*/
    }
}
