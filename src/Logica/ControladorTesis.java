package Logica;

import Conexion.Conexion;
import Modelo.M_Tesis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControladorTesis {

    public ControladorTesis(){
    }
    
    //Comprueba si el titulo de la tesis ya existe en la tabla tesis
    public boolean tituloExiste(String titulo){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT titulo FROM empresa WHERE titulo = ?");
             
            ps.setString(1, titulo);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                bandera = true;
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error identificando empresa: "+e);
        }
        return bandera;
    }
    
    //Agrega una tesis a la tabla tesis
    public void ingresar(M_Tesis tesis){
        try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                
                ps = con.prepareCall("INSERT INTO tesis (status,titulo,observaciones) VALUES (?,?,?)");
                  
                ps.setString(1, tesis.getStatus());
                ps.setString(2, tesis.getTitulo());
                ps.setString(3, tesis.getObservaciones());
                
                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Tesis guardada con éxito");
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
    
    //Dada una clave primaria, se elimina una tesis
    public void eliminar(String pk_tesis){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_tesis;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM tesis WHERE idtesis="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Tesis eliminada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la empresa");
              }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error eliminando: "+e);
        }
    }
    
    //Se modifican datos de una tesis dada su clave primaria, validar que no se ingresan 2 titulos iguales
    public void modificar(M_Tesis tesis, String pk_tesis){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            int pk = Integer.parseInt(pk_tesis);
            PreparedStatement ps;
            
            ps = con.prepareStatement("UPDATE tesis SET status=?, titulo=?, observaciones=? WHERE idtesis="+pk_tesis);
            
            ps.setString(1, tesis.getStatus()); 
            ps.setString(2, tesis.getTitulo());
            ps.setString(3,tesis.getObservaciones());
            
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Tesis modificada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar la tesis");
            }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
    }
    
}
