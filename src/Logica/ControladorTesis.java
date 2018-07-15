package Logica;

import Conexion.Conexion;
import Modelo.M_Tesis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ControladorTesis {

    public ControladorTesis(){
    }
    
    public void ingresar(M_Tesis tesis){
        try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                
                ps = con.prepareCall("INSERT INTO tesis (status, titulo, observaciones,departamento,"
                        + "nota_tacademico, nota_tindustrial, nota_defensa)"
                        + " VALUES (?,?,?,?,?)");
                
                ps.setString(1, tesis.getStatus());
                ps.setString(2, tesis.getTitulo());
                ps.setString(3, tesis.getObservaciones());
                ps.setString(4, tesis.getDepartamento());
                ps.setInt(5,tesis.getNota_tacademico());
                ps.setInt(5,tesis.getNota_tindustrial());
                ps.setInt(5,tesis.getNota_defensa());

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
    
}
