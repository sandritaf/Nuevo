
package Logica;

import Conexion.Conexion;
import Modelo.M_Defensa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ControladorDefensa {

    public ControladorDefensa() {
    }
    
    /*HAY QUE IDEAR UN METODO PARA CAMBIAR EL STATUS DE UNA TESIS DE POR DEFENDER>DEFENDIDA */
    
    public void getFechaFinal(JComboBox tesis, JTextField fecha){
        int codigo = getComboSelected(tesis);
        String sql = "SELECT fecha_fin FROM tesis WHERE idtesis="+codigo;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                fecha.setText(String.valueOf(rs.getDate("fecha_fin")));
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
    
    //Dada una fecha y un semestre, forma el periodo en el que se debe dar la defensa y lo devuelve
    public String getPeriodo(Date Fecha, JRadioButton SemestreI){
        String formato="yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        String anio = (dateFormat.format(Fecha));
        if (SemestreI.isSelected())
            anio = anio + "-I";
        else
            anio = anio+"-II";
        return anio;
    }
    
    //Selecciona en el comboBox una opcion en particular, correspondiente a un codigo dado
    public void setComboSelected(int codigoPK, JComboBox combito){
        //Obtengo la longitud de mi combo
        int largoCombo = combito.getItemCount();
        String textoCombo = "";
        //Recorro el arraycollection
        for (int i = 0; i < largoCombo; i++) {
            textoCombo = combito.getItemAt(i).toString();
            int limite = textoCombo.indexOf("-");
           //Comparo los objetos de mi combo con el codigo del item que buscaba
           if (Integer.parseInt(textoCombo.substring(0, limite)) == codigoPK)  {
              //Si encuentra el item le asigno su index a mi combo
              combito.setSelectedIndex(i);
              break;
           }
        }
    }
    
    //Devuelve el codigo de la opcio seleccionada en el combo box
    public int getComboSelected(JComboBox combito){
        String codigo = combito.getSelectedItem().toString(); 
        String codigoFinal = "";
        
        int guion = codigo.indexOf("-");
        codigoFinal = codigo.substring(0, guion);
        return Integer.parseInt(codigoFinal);
    }
    
    //Devuelve I o II dependiendo del semestre al que corresponda el periodo recibido
    public int getSemestrePeriodo(String periodo){
        String cadena = periodo; 
        String cadenaFinal = "";
        int largo = periodo.length();
        int guion = cadena.indexOf("-");
        cadenaFinal = cadena.substring(guion+1, largo);
        return cadenaFinal.length();
    }
    
    //Carga las tesis en una tabla, dependiendo si tienen defensa asociada o no
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

    //Carga los profesores en los combo box
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
    
    //Cambia el status de una tesis a "Por defender"
    private void porDefenderTesis(int pk, JRadioButton defendida){
        try {
        Conexion c = new Conexion();
        Connection con = c.getConection();
        PreparedStatement ps;            
        ps = con.prepareStatement("UPDATE tesis SET status=? WHERE idtesis=?");

        if (defendida.isSelected())
           ps.setString(1, "Defendida");
        else
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
    
    //Cambia el status de la tesis a "en desarrollo"
    private void enDesarrolloTesis(String PK){
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
            borrarNotas(PK);
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
    public void ingresar(M_Defensa defensa, JRadioButton defendida){
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
                porDefenderTesis(PK_Tesis, defendida);
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
    public void modificar(M_Defensa defensa, String pk_defensa, JRadioButton defendida){
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
                porDefenderTesis(defensa.getId_tesis(), defendida);
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
       
    //Dada una clave primaria, se elimina una defensa
    private void borrarNotas(String pk_tesis){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();     
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM notas WHERE id_tesis="+pk_tesis);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Borradas sus notas asociadas con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudieron borrar sus notas");
              }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
        
    }
}
