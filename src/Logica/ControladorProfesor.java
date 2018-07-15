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

            ps = con.prepareCall("INSERT INTO profesor (nombre, apellido, cedula, telefono"
                    + ",titulo, profesion) VALUES (?,?,?,?,?,?)");

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido());
            ps.setString(3, profesor.getCedula());
            ps.setString(4, profesor.getTelefono());
            ps.setString(5,profesor.getTitulo());
            ps.setString(6,profesor.getProfesion());
//            ps.setString(7,profesor.getCarrera());

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
    
}
