package Logica;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorConsultaTesis {

    public ControladorConsultaTesis() {
    }
    
    public void cargarTutorInd(JTextField tutor, int PK_tesis){
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT nombre, apellido FROM tesis INNER JOIN tutor_industrial"
                    + " ON tesis.id_tutorIndustrial = tutor_industrial.idtindustrial WHERE idtesis = ?");
             
            ps.setInt(1, PK_tesis);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                tutor.setText(rs.getString("nombre")+" "+rs.getString("apellido"));
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }
    
    public void cargarTutorAcad(JTextField tutor, int PK_tesis){
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT nombre, apellido FROM tesis INNER JOIN profesor"
                    + " ON tesis.id_tutorAcademico = profesor.idprofesor WHERE idtesis = ?");
             
            ps.setInt(1, PK_tesis);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                tutor.setText(rs.getString("nombre")+" "+rs.getString("apellido"));
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error");
        }
    }
    
}
