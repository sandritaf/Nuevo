package Main;


import Logica.ManejadorFecha;
import Vista.Menu;
import Vista.Tesis;

public class Main {

    public static void main(String[] args) {        
       Menu ventana = new Menu();
       ventana.setVisible(true);     
       ManejadorFecha fecha = new ManejadorFecha();
       if(fecha.fechasCorrectas("2016-06-11", "2017-09-11"))
           System.out.println("La de inicio es menor que la de fin");
       else 
           System.out.println("La de inicio no es menor que la de fin");
    }
    
}
