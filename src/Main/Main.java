package Main;

import Logica.ManejadorFecha;
import Vista.Menu;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {   
        
        ManejadorFecha mf = new ManejadorFecha();
        
//        if(mf.rangoCorrectoTesis("2021-05-24", "2025-09-24"))
//            JOptionPane.showMessageDialog(null, "bien");
//        else
//            JOptionPane.showMessageDialog(null, "malisimo");
        
       Menu ventana = new Menu();
       ventana.setVisible(true);    
    }
    
}
