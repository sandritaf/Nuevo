
package Logica;

import Conexion.Conexion;
import Modelo.M_Defensa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControladorDefensa {

    public ControladorDefensa() {
    }

    //Ingresa una defensa en la tabla
    public void ingresar(M_Defensa defensa){
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps = null;                

            ps = con.prepareCall("INSERT INTO defensa (fecha, hora, aula, periodo)"
                    + " VALUES (?,?,?,?)");

            ps.setDate(1, defensa.getFecha());
            ps.setTime(2, defensa.getHora());
            ps.setInt(3, defensa.getAula());
            ps.setString(4, defensa.getPeriodo());

            int res = ps.executeUpdate(); //Ejecutar la consulta

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Defensa guardada con éxito");
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
    
    //Dada una clave primaria, se elimina una defensa
    public void eliminar(String pk_defensa){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_defensa;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM defensa WHERE iddefensa="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Defensa eliminada con éxito");
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
    
    //Se modifican datos de una defensa dada su clave primaria
    public void modificar(M_Defensa defensa, String pk_defensa){
        try {
        Conexion c = new Conexion();
        Connection con = c.getConection();
        int pk = Integer.parseInt(pk_defensa);
        PreparedStatement ps;            
        ps = con.prepareStatement("UPDATE defensa SET fecha=?, hora=?, aula=?, periodo=?" +
                                    " WHERE iddefensa=?");

        ps.setDate(1, defensa.getFecha());
        ps.setTime(2, defensa.getHora());
        ps.setInt(3, defensa.getAula());
        ps.setString(4, defensa.getPeriodo());
        ps.setInt(5, pk);

        int res = ps.executeUpdate();

        if (res > 0){
            JOptionPane.showMessageDialog(null, "Defensa modificada con éxito");
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
