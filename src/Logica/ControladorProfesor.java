package Logica;

import Conexion.Conexion;
import Modelo.M_Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControladorProfesor {

    public ControladorProfesor() {
    }
    
    //Comprueba si una cedula ya existe en la tabla profesor
    public boolean idExiste(String cedula_profesor){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT cedula FROM profesor WHERE cedula = ?");
             
            ps.setString(1, cedula_profesor);
            
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

    public void ingresar(M_Profesor profesor){
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps = null;                

            ps = con.prepareCall("INSERT INTO profesor (nombre, apellido, cedula, telefono, "
                    + "profesion, direccion) VALUES (?,?,?,?,?,?)");

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido());
            ps.setString(3, profesor.getCedula());
            ps.setString(4, profesor.getTelefono());
            ps.setString(5,profesor.getProfesion());
            ps.setString(6,profesor.getDireccion());

            int res = ps.executeUpdate(); //Ejecutar la consulta

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Profesor(a) guardado/a con éxito");
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
    public void eliminar(String pk_profesor){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_profesor;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM profesor WHERE idprofesor="+pk);
                        
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
    public void modificar(String pk_, String cedula, String nombre, String apellido, String telefono, String profesion, String direccion){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            int pk = Integer.parseInt(pk_);
            PreparedStatement ps;
            
            ps = con.prepareStatement("UPDATE profesor SET cedula=?,nombre=?,apellido=?,telefono=?," +
                                        "profesion=?, direccion=? WHERE idprofesor=?");
            
            ps.setString(1, cedula); 
            ps.setString(2, nombre); 
            ps.setString(3, apellido); 
            ps.setString(4, telefono);  
            ps.setString(5, profesion);
            ps.setString(6, direccion); 
            ps.setInt(7,pk);
            
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Profesor modificado con éxito");
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
