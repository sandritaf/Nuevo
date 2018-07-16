/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.Conexion;
import Modelo.M_TutorIndustrial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author brenda
 */
public class ControladorTutorIndustrial {

    //Comprueba si una cedula ya existe en la tabla tutor_industrial
    public boolean idExiste(String cedula_tutor){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT cedula FROM tutor_industrial WHERE cedula = ?");
             
            ps.setString(1, cedula_tutor);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                bandera = true;
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
        return bandera;
    }
    
        
    //Ingresa un tutor en la tabla
    public void ingresar(M_TutorIndustrial tutor){
        try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                
                ps = con.prepareCall("INSERT INTO tutor_industrial (cedula, nombre, apellido, telefono, id_empresa)"
                        + " VALUES (?,?,?,?,?)");
                
                ps.setString(1, tutor.getCedula());
                ps.setString(2, tutor.getNombre());
                ps.setString(3, tutor.getApellido());
                ps.setString(4, tutor.getTelefono());
                ps.setInt(5, tutor.getId_empresa());

                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Tutor guardado con éxito");
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
    
    //Dada una clave primaria, se elimina un tutor
    public void eliminar(String pk_tutor){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_tutor;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM tutor_industrial WHERE idtindustrial="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Tutor eliminado con éxito");
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
    
    //Se modifican datos de un tutor dada su clave primaria, validar que no se ingresan 2 cedulas iguales
    public void modificar(String pk_tutor, String cedula, String nombre, String apellido, String telefono, int id_empresa){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            int pk = Integer.parseInt(pk_tutor);
            PreparedStatement ps;            
            ps = con.prepareStatement("UPDATE tutor_industrial SET cedula=?, nombre=?, apellido=?, telefono=?, id_empresa=?" +
                                        " WHERE idtindustrial=?");
            
            ps.setString(1, cedula); 
            ps.setString(2, nombre); 
            ps.setString(3, apellido); 
            ps.setString(4, telefono); 
            ps.setInt(5, id_empresa);
            ps.setInt(6, pk);
            
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Tutor modificada con éxito");
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

    
}
