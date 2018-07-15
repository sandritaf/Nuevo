package Logica;

import Conexion.Conexion;
import Modelo.M_Estudiante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ControladorEstudiante {

    public ControladorEstudiante() {
    }
    
    //Comprueba si una cedula ya existe en la tabla estudiante
    public boolean idExiste(String cedula_alumno){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT cedula FROM estudiante WHERE cedula = ?");
             
            ps.setString(1, cedula_alumno);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                bandera = true;
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
        return bandera;
    }
    
    //Ingresa un estudiante en la tabla
    public void ingresar(M_Estudiante alumno){
        try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                
                ps = con.prepareCall("INSERT INTO estudiante (cedula, nombre, apellido, semestre, carrera)"
                        + " VALUES (?,?,?,?,?)");
                
                ps.setString(1, alumno.getCedula());
                ps.setString(2, alumno.getNombre());
                ps.setString(3, alumno.getApellido());
                ps.setString(4, alumno.getSemestre());
                ps.setString(5, alumno.getCarrera());

                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Persona guardada con éxito");
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
    
    //Dada una clave primaria, se elimina un estudiante
    public void eliminar(String pk_alumno){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_alumno;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM estudiante WHERE idestudiante="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Persona eliminada con éxito");
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
    public void modificar(String pk_alumno, String cedula, String nombre, String apellido, String carrera, String semestre){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            int pk = Integer.parseInt(pk_alumno);
            PreparedStatement ps;
            
            ps = con.prepareStatement("UPDATE estudiante SET cedula=?,nombre=?,apellido=?,semestre=?,carrera=?" +
                                        "WHERE idestudiante=?");
            
            ps.setString(1, cedula); 
            ps.setString(2, nombre); 
            ps.setString(3, apellido); 
            ps.setInt(4, Integer.parseInt(semestre)); 
            ps.setString(5,carrera);
            ps.setInt(6,pk);
            
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Alumno modificada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar");
            }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
    }
    
    
}
