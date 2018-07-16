/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Conexion.Conexion;
import Modelo.M_Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author brenda
 */
public class ControladorCarrera {

    public ControladorCarrera() {
    }
    
//    public boolean estaVacio(M_Carrera carrera){
//        if (carrera.getNombre().isEmpty()) || carrera.getSemestres().isEmpty())
//            return true;
//        else if (carrera.getUc_totales().isEmpty())
//            return true;
//        return false;
//    }

    
    //Comprueba si una carrera ya existe en la tabla carrera
    public boolean carreraExiste(String nombre){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            nombre = nombre.toLowerCase();
            
            ps = con.prepareStatement("SELECT nombre FROM carrera WHERE nombre = ?");
             
            ps.setString(1, nombre);
            
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
            
    //Ingresa una carrera en la tabla carrera
    public void ingresar(M_Carrera carrera){
//        if (estaVacio(alumno))
//            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
//        else {
            try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                
                ps = con.prepareCall("INSERT INTO carrera (nombre, semestres, uc_totales)"
                        + " VALUES (?,?,?)");
                
                ps.setString(1, carrera.getNombre());
                ps.setInt(2, carrera.getSemestres());
                ps.setInt(3, carrera.getUc_totales());
                
                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Carrera guardada con éxito");
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
        //}
    }
    
    //Dada una clave primaria, se elimina una carrera
    public void eliminar(String pk_carrera){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_carrera;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM carrera WHERE idcarrera="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Carrera eliminada con éxito");
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
    public void modificar(M_Carrera carrera, String pk_carrera){
//        if (estaVacio(alumno))
//            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
//        else{
            try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            int pk = Integer.parseInt(pk_carrera);
            PreparedStatement ps;            
            ps = con.prepareStatement("UPDATE carrera SET nombre=?, uc_totales=?, semestres=?" +
                                        " WHERE idcarrera=?");
            
            ps.setString(1, carrera.getNombre()); 
            ps.setInt(2, carrera.getUc_totales()); 
            ps.setInt(3, carrera.getSemestres()); 
            
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Carrera modificada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar");
            }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Ocurrió un error en la modificacion: "+e);
            }
        //}
    }
    
}
