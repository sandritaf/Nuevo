package Logica;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorConsultaTesis {

    public ControladorConsultaTesis() {
    }
    
    public void getComboSelected(JComboBox combito, int codigoPK){
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT carrera.id_carrera FROM tesis INNER JOIN"
                    + " estudiante ON estudiante.idestudiante=tesis.estudiante_tesis"
                    + " INNER JOIN carrera ON carrera.id_carrera = estudiante.id_carrera WHERE idtesis = ?");
             
            ps.setInt(1, codigoPK);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                int largoCombo = combito.getItemCount();
                String textoCombo = "";
                //Recorro el arraycollection
                for (int i = 0; i < largoCombo; i++) {
                    textoCombo = combito.getItemAt(i).toString();
                    int limite = textoCombo.indexOf("-");
                   //Comparo los objetos de mi combo con el codigo del item que buscaba
                   if (Integer.parseInt(textoCombo.substring(0, limite)) == rs.getInt("id_carrera"))  {
                      //Si encuentra el item le asigno su index a mi combo
                      combito.setSelectedIndex(i);
                      break;
                   }
                }
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error seleccionando carrera: "+e);
        }
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
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando tutor industrial: "+e);
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
            JOptionPane.showMessageDialog(null, "Ocurrió un error con tutor academico: "+e);
        }
    }
    
    public void cargarFecha_Inicial(JTextField fecha, int PK_tesis){
        fecha.setEnabled(false);
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT fecha_inicio FROM tesis WHERE idtesis = ?");
             
            ps.setInt(1, PK_tesis);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                fecha.setText(rs.getDate("fecha_inicio").toString());
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error con fecha inicio: "+e);
        }
    }  
    
    public void cargarFecha_Final(JTextField fecha, int PK_tesis){
        fecha.setEnabled(false);
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT fecha_fin FROM tesis WHERE idtesis = ?");
             
            ps.setInt(1, PK_tesis);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                fecha.setText(rs.getDate("fecha_fin").toString());
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error con fecha final: "+e);
        }
    }

    public void cargarCedula(JTextField cedula, int PK_tesis){
        cedula.setEnabled(false);
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT cedula FROM tesis INNER JOIN estudiante ON"
                    + " estudiante.idestudiante = tesis.estudiante_tesis WHERE idtesis = ?");
             
            ps.setInt(1, PK_tesis);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                cedula.setText(rs.getString("cedula"));
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando cedula: "+e);
        }
    }
}
