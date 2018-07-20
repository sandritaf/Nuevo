
package Logica;

import Conexion.Conexion;
import Modelo.M_Defensa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ControladorDefensa {

    public ControladorDefensa() {
    }
    
    public void cargarTesis(JComboBox combito, boolean conDefensa){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT idtesis, titulo FROM tesis ";
        if (conDefensa){
            sql = sql + "INNER JOIN defensa ON defensa.id_tesis = tesis.idtesis";
        }
        else {
            sql = sql + "WHERE status='En desarrollo'";
        }
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            combito.setModel(aModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("idtesis") + "- " + rs.getString("titulo");
               aModel.addElement(aux);
            }
            //Cerrar conexiones
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando tesis: "+ex);
        }
    }

    public void cargarProfesores(JComboBox cmbJurado1, JComboBox cmbJurado2){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        DefaultComboBoxModel bModel = new DefaultComboBoxModel();
        String sql = "SELECT idprofesor, nombre, apellido FROM profesor";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            cmbJurado1.setModel(aModel);
            cmbJurado2.setModel(bModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("idprofesor") + "- " + rs.getString("nombre") + " " + rs.getString("apellido");
               aModel.addElement(aux);
               bModel.addElement(aux);
            }
            //Cerrar conexiones
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando Profesores: "+ex);
        }
    }
    
    public void porDefenderTesis(int pk){
        try {
        Conexion c = new Conexion();
        Connection con = c.getConection();
        PreparedStatement ps;            
        ps = con.prepareStatement("UPDATE tesis SET status=? WHERE idtesis=?");

        ps.setString(1, "Por defender");
        ps.setInt(2, pk);

        int res = ps.executeUpdate();

        if (res > 0){
            JOptionPane.showMessageDialog(null, "Tesis actualizada con éxito");
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
    
    public void enDesarrolloTesis(String PK){
        try {
        Conexion c = new Conexion();
        Connection con = c.getConection();
        int pk = Integer.parseInt(PK);
        PreparedStatement ps;            
        ps = con.prepareStatement("UPDATE tesis SET status=? WHERE idtesis=?");

        ps.setString(1, "En desarrollo");
        ps.setInt(2, pk);

        int res = ps.executeUpdate();

        if (res > 0){
            JOptionPane.showMessageDialog(null, "Tesis actualizada con éxito");
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
    
    //Ingresa una defensa en la tabla
    public void ingresar(M_Defensa defensa){
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps = null;  
            int PK_Tesis;

            ps = con.prepareCall("INSERT INTO defensa (fecha, hora, aula, periodo, id_tesis, id_jurado1, id_jurado2)"
                    + " VALUES (?,?,?,?,?,?,?)");

            ps.setDate(1, defensa.getFecha());
            ps.setTime(2, defensa.getHora());
            ps.setInt(3, defensa.getAula());
            ps.setString(4, defensa.getPeriodo());
            ps.setInt(5, defensa.getId_tesis());
            PK_Tesis = defensa.getId_tesis();
            ps.setInt(6, defensa.getId_jurado1());
            ps.setInt(7, defensa.getId_jurad2());

            int res = ps.executeUpdate(); //Ejecutar la consulta

            if (res > 0){
                JOptionPane.showMessageDialog(null, "Defensa guardada con éxito");
                porDefenderTesis(PK_Tesis);
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
    public void eliminar(String pk_defensa, String PK_Tesis){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_defensa;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM defensa WHERE iddefensa="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Defensa eliminada con éxito");
                enDesarrolloTesis(PK_Tesis);
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
        ps = con.prepareStatement("UPDATE defensa SET fecha=?, hora=?, aula=?, periodo=?, id_jurado1=?, "
                + "id_jurado2=?  WHERE iddefensa=?");

        ps.setDate(1, defensa.getFecha());
        ps.setTime(2, defensa.getHora());
        ps.setInt(3, defensa.getAula());
        ps.setString(4, defensa.getPeriodo());
        ps.setInt(5, defensa.getId_jurado1());
        ps.setInt(6, defensa.getId_jurad2());
        ps.setInt(7, pk);

        int res = ps.executeUpdate();

        if (res > 0){
            JOptionPane.showMessageDialog(null, "Defensa modificada con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo modificar la defensa");
        }

        c.CerrarConexion();
        con.close();
        ps.close();

        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Ocurrió un error en la modificacion: "+e);
        }
    }
       
}
