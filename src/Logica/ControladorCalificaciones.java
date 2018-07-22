
package Logica;

import Conexion.Conexion;
import Modelo.M_Calificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControladorCalificaciones {

    //Ingresa un estudiante en la tabla
    public void ingresar(M_Calificaciones nota, int pktesis){

        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps = null;                

            ps = con.prepareCall("INSERT INTO notas (tutor_academico, tutor_industrial, jurado1, jurado2, promedio_defensa, final, id_tesis)"
                    + " VALUES (?,?,?,?,?,?,?)");

            ps.setInt(1, nota.getN_tacademico());
            ps.setInt(2, nota.getN_tindustrial());
            ps.setInt(3, nota.getN_j1());
            ps.setInt(4, nota.getN_j2());
            ps.setInt(5, nota.getN_promdefensa());
            ps.setInt(6, nota.getN_final());
            ps.setInt(7, pktesis);

            int res = ps.executeUpdate(); //Ejecutar la consulta

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Calificaciones guardadas con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo guardar");
            }
            //Cerrar las conexiones
            ps.close();
            conn.CerrarConexion();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
    }
    
    //Dada una clave primaria, se eliminan las calificaciones asociadas a una tesis
    public void eliminar(String pk){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            //String pk = pk_calificacion;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM notas WHERE idnotas="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Calificaciones eliminadas con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudieron realizar los cambios");
              }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }
    
    //Se modifican datos de un estudiante dada su clave primaria, validar que no se ingresan 2 cedulas iguales
    public void modificar(M_Calificaciones nota, int pk){
            try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
//            int pk = Integer.parseInt(pk_calificacion);
            PreparedStatement ps;            
            ps = con.prepareStatement("UPDATE notas SET tutor_academico=?, tutor_industrial=?, jurado1=?, jurado2=?, promedio_defensa=?, final=?"
                    + " WHERE idnotas=?");
            
            ps.setInt(1, nota.getN_tacademico());
            ps.setInt(2, nota.getN_tindustrial());
            ps.setInt(3, nota.getN_j1());
            ps.setInt(4, nota.getN_j2());
            ps.setInt(5, nota.getN_promdefensa());
            ps.setInt(6, nota.getN_final());
            ps.setInt(7, pk);
            
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Calificaciones modificadas con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar");
            }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Ocurrió un error en la modificacion: "+e);
            }
    }

    public boolean encuentraTesis(int pk_tesis){
        boolean b = false;
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            PreparedStatement ps;  
            ResultSet rs;
            ps = con.prepareStatement("SELECT id_tesis FROM notas WHERE id_tesis=?");
            
            ps.setInt(1, pk_tesis);
            
            rs = ps.executeQuery();
            
            if (rs.next()){
                return true;
            }else{
                b = false;
            }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Ocurrió un error en la modificacion: "+e);
            }
        return b;
    }
    
}
