package Main;


import Logica.ManejadorFecha;
import Vista.Menu;
import Vista.Tesis;

public class Main {

    public static void main(String[] args) {        
       Menu ventana = new Menu();
       ventana.setVisible(true);    
//        String sql = "SELECT idtesis, titulo, nombre, apellido FROM tesis INNER JOIN "
//                    + "estudiante ON tesis.estudiante_tesis = estudiante.tesista INNER JOIN "
//                    + "notas ON tesis.idtesis = notas.id_tesis "
//                    + "WHERE tesis.status=defendida";
//
//        System.out.println(sql);
    }
    
}
