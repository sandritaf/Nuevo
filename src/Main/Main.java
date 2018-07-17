package Main;

import Logica.ManejadorFecha;
import Vista.Menu;

public class Main {

    public static void main(String[] args) {        
       Menu ventana = new Menu();
       ventana.setVisible(true);
       ManejadorFecha fecha = new ManejadorFecha();
       System.out.println(fecha.fechaToString("2001-01-01"));
        
    }
    
}
