package Main;


import Logica.ManejadorFecha;
import Vista.Menu;
import Vista.Tesis;

public class Main {

    public static void main(String[] args) {   
        
        // los primeros strings son consultas por separadas
        
        String sql_ta = "SELECT profesor.nombre, profesor.apellido, titulo, idtesis FROM tesis INNER JOIN "
                        + "profesor ON profesor.idprofesor = tesis.id_tutorAcademico"; 
        
        String sql_ti = "SELECT tutor_industrial.nombre, tutor_industrial.apellido, titulo, idtesis FROM tesis INNER JOIN "
                        + "tutor_industrial ON tutor_industrial.idtindustrial = tesis.id_tutorIndustrial"; 
        
        String sql_j1 = "SELECT profesor.nombre, profesor.apellido, titulo, idtesis FROM tesis INNER JOIN "
                        + "defensa ON tesis.idtesis = defensa.id_tesis INNER JOIN "
                        + "profesor ON profesor.idprofesor = defensa.id_jurado1";
        
        String sql_j2 = "SELECT profesor.nombre, profesor.apellido, titulo, idtesis FROM tesis INNER JOIN "
                        + "defensa ON tesis.idtesis = defensa.id_tesis INNER JOIN "
                        + "profesor ON profesor.idprofesor = defensa.id_jurado2"; 
        
        String sql_es = "SELECT estudiante.nombre, estudiante.apellido, titulo, idtesis FROM tesis INNER JOIN "
                        + "estudiante ON estudiante.idestudiante = tesis.estudiante_tesis"; 
        
        String where = "WHERE tesis.status='Por defender'";
        
        //consulta con INNER JOIN
        String s = "SELECT profesor.nombre AS nombreP, profesor.apellido AS apellidoP, tutor_industrial.nombre AS nombreTI, tutor_industrial.apellido AS apellidoTI, estudiante.nombre as nombreEs, estudiante.apellido AS apellidoEs, titulo, idtesis FROM tesis INNER JOIN defensa ON defensa.id_tesis = tesis.idtesis INNER JOIN profesor ON (defensa.id_jurado1 = profesor.idprofesor AND defensa.id_jurado2 = profesor.idprofesor AND profesor.idprofesor = tesis.id_tutorAcademico) INNER JOIN tutor_industrial ON tutor_industrial.idtindustrial = tesis.id_tutorIndustrial INNER JOIN estudiante ON tesis.estudiante_tesis = estudiante.idestudiante WHERE tesis.status='Por defender'";
        //consulta con WHERE 
        String s2 = "SELECT idtesis, titulo, profesor.nombre, profesor.apellido, tutor_industrial.nombre, tutor_industrial.apellido, estudiante.nombre, estudiante.apellido FROM tesis, profesor, tutor_industrial, estudiante, defensa WHERE defensa.id_tesis = tesis.idtesis AND defensa.id_jurado1 = profesor.idprofesor AND defensa.id_jurado2 = profesor.idprofesor AND profesor.idprofesor = tesis.id_tutorAcademico AND tutor_industrial.idtindustrial = tesis.id_tutorIndustrial AND tesis.estudiante_tesis = estudiante.idestudiante AND tesis.status='Por defender' ";
        
        
        System.out.println(sql_ta);
        System.out.println(sql_ti);
        System.out.println(sql_j1);
        System.out.println(sql_j2);
        System.out.println(sql_es);
        
 //       System.out.println("aqui: "+ta+ti+defensa+j1+j2+es);
        
//       Menu ventana = new Menu();
//       ventana.setVisible(true);    
//        String sql = "SELECT idtesis, titulo, nombre, apellido FROM tesis INNER JOIN "
//                    + "estudiante ON tesis.estudiante_tesis = estudiante.tesista INNER JOIN "
//                    + "notas ON tesis.idtesis = notas.id_tesis "
//                    + "WHERE tesis.status=defendida";
//
//        System.out.println(sql);
    }
    
}
