package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class M_Validaciones {

    public M_Validaciones() {
    }

    //Busca en la BDD si ya hay alguna persona registrada con el numero de cedula ingresado
    public boolean idExiste(String cedula, String tabla){
        
        boolean bandera = false;
        
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT cedula FROM "+tabla+" WHERE cedula = ?");
             
            ps.setString(1, cedula);
            
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
    
    
    
    
    
}
