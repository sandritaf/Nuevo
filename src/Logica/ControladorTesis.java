package Logica;

import Conexion.Conexion;
import Modelo.M_Tesis;
import java.sql.Connection;
import java.sql.Date;
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
            
            ps = con.prepareStatement("SELECT titulo FROM tesis WHERE titulo =?");
             
            ps.setString(1, titulo);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                bandera = true;
            }//else bandera = false;
            
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
                PreparedStatement ps2 = null;    
                
                ps = con.prepareCall("INSERT INTO tesis (status,titulo,fecha_inicio, fecha_fin,"
                        + "observaciones,departamento,id_tutorAcademico,id_tutorIndustrial,"
                        + "estudiante_tesis) VALUES (?,?,?,?,?,?,?,?,?)");
                
                ps2 = con.prepareCall("UPDATE estudiante SET id_empresa=?, tesista=? WHERE idestudiante=?");
                  
                ps.setString(1, tesis.getStatus());
                ps.setString(2, tesis.getTitulo());
                ps.setDate(3, Date.valueOf(tesis.getF_inicio()));
                ps.setDate(4, Date.valueOf(tesis.getF_inicio()));
                ps.setString(5, tesis.getObservaciones());
                ps.setString(6, tesis.getDepartamento());
                ps.setInt(7, tesis.getId_tutorAcademico());
                ps.setInt(8, tesis.getId_tutorIndustrial());
                ps.setInt(9, tesis.getEstudiante_tesis());
                
                ps2.setInt(1, tesis.getEmpresa());
                ps2.setInt(2, 1);
                ps2.setInt(3, tesis.getEstudiante_tesis());
                
                
                int res = ps.executeUpdate(); //Ejecutar la consulta
                int rs2 = ps2.executeUpdate();

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Tesis guardada con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo tesis");
                }
                
                if (rs2 > 0){
                    JOptionPane.showMessageDialog(null, "Alumno afiliado a tesis con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo guardar alumno");
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
            int pkEstudiante=0;    
            ResultSet res = null;
            PreparedStatement ps1=null;
            PreparedStatement ps2=null;
            PreparedStatement ps3=null;
            
            ps1 = (PreparedStatement)con.prepareStatement("SELECT estudiante_tesis FROM tesis WHERE idtesis="+pk);
            ps2 = con.prepareStatement("UPDATE estudiante SET tesista=0 where idestudiante=?");
            ps3 = con.prepareStatement("DELETE FROM tesis WHERE idtesis="+pk);
           
            res = ps1.executeQuery();
            while(res.next()){
                pkEstudiante = res.getInt("estudiante_tesis");
            }
            
            ps2.setInt(1, pkEstudiante);            
            int res2 = ps2.executeUpdate();
            int res3 = ps3.executeUpdate();        
                        
            if (res2 > 0 && res3>0){
                JOptionPane.showMessageDialog(null, "Tesis eliminada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la tesis");
              }
                        
            c.CerrarConexion();
            con.close();
            ps1.close();
            ps2.close();
            ps3.close();
                 
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
    
    public void modificarStatus(int pk_tesis, String status){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
//            int pk = Integer.parseInt(pk_tesis);
            PreparedStatement ps;
            
            ps = con.prepareStatement("UPDATE tesis SET status=? WHERE idtesis=?");
            JOptionPane.showMessageDialog(null, "HOLA ESTOY EN MODIFICARSTATUS");
            ps.setString(1, status); 
            ps.setInt(2, pk_tesis); 
            JOptionPane.showMessageDialog(null, "este es el status: "+status);
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Status de la tesis modificado con éxito");
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
