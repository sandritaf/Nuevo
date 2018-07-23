package Logica;

import Conexion.Conexion;
import Modelo.M_Calificaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorCalificaciones {

    //Devuelve el texto seleccionado de un comboBox
    public String getComboSelected(JComboBox cmb){
        String s = cmb.getSelectedItem().toString();
        return s;
    }
    
    //Calcula la nota final de la tesis
    public long calcularNotaFinal(int ni, int na, int j1, int j2){
        float defensa = ((j1+j2)/2);
        long nota_final = Math.round((ni*0.35)+(na*0.25)+(defensa*0.4));
        JOptionPane.showMessageDialog(null,"Nota final: "+nota_final);
        return nota_final;
    }
    
    //Ingresa una instancia de calificaciones en la tabla
    public void ingresar(M_Calificaciones nota, int pktesis){

        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps = null, ps2 = null;                

            ps = con.prepareCall("INSERT INTO notas (tutor_academico, tutor_industrial, "
                    + "jurado1, jurado2, promedio_defensa, final, id_tesis)"
                    + " VALUES (?,?,?,?,?,?,?)");
            ps2 = con.prepareStatement("UPDATE tesis SET status=? WHERE idtesis="+pktesis);

            nota.imprimir();
            
            ps.setInt(1, nota.getN_tacademico());
            ps.setInt(2, nota.getN_tindustrial());
            ps.setInt(3, nota.getN_j1());
            ps.setInt(4, nota.getN_j2());
            ps.setInt(5, nota.getN_promdefensa());
            ps.setInt(6, nota.getN_final());
            ps.setInt(7, pktesis);
            
            if (nota.getN_final() > 6)
                ps2.setString(1, "Aprobada");
            else
                ps2.setString(1, "Reprobada");

            int res = ps.executeUpdate(); //Ejecutar la consulta

            if (res > 0){
                if (ps2.executeUpdate()>0)
                    JOptionPane.showMessageDialog(null, "Calificaciones ingresadas con éxito");
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
    
    //Dada una clave primaria, se eliminan las calificaciones asociadas a una tesis
    //y se cambia el status de la tesis que estaba asociada
    public void eliminar(String pk, String pkTesis){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();  
            PreparedStatement ps, ps2;
            
            ps = con.prepareStatement("DELETE FROM notas WHERE idnotas="+pk);
            ps2 = con.prepareStatement("UPDATE tesis SET status='Defendida' WHERE idtesis="+pkTesis);       
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                int res2 = ps2.executeUpdate();
                if (res2 > 0)
                    JOptionPane.showMessageDialog(null, "Calificaciones eliminadas con éxito");
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
    
    //Se modifican datos de un estudiante dada su clave primaria, validar que no se ingresan 2 cedulas iguales
    public void modificar(M_Calificaciones nota, int pk, int pk_tesis){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            PreparedStatement ps, ps2;  
            boolean aprobado = false;

            nota.imprimir();
            
            ps = con.prepareStatement("UPDATE notas SET tutor_academico=?, "
                    + "tutor_industrial=?, jurado1=?, jurado2=?, "
                    + "promedio_defensa=?, final=? WHERE idnotas=?");
            ps2 = con.prepareStatement("UPDATE tesis SET status=? WHERE idtesis="+pk_tesis);

            ps.setInt(1, nota.getN_tacademico());
            ps.setInt(2, nota.getN_tindustrial());
            ps.setInt(3, nota.getN_j1());
            ps.setInt(4, nota.getN_j2());
            ps.setInt(5, nota.getN_promdefensa());
            ps.setInt(6, nota.getN_final());
            ps.setInt(7, pk);

            if (nota.getN_final() > 6)
                ps2.setString(1, "Aprobada");
            else
                ps2.setString(1, "Reprobada");
            
            int res = ps.executeUpdate();

            if (res > 0){
                if (ps2.executeUpdate()>0)
                    JOptionPane.showMessageDialog(null, "Calificaciones modificadas con éxito");
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
    
    //Carga la tabla con las tesis calificadas y no calificadas
    public void cargarTabla(JTable TablaTesis, JRadioButton Calificadas, JRadioButton NoCalificadas){
        String filtro = "";
        
        if(Calificadas.isSelected())
            filtro = "WHERE tesis.status = 'Reprobada' OR tesis.status = 'Aprobada'";
        else if (NoCalificadas.isSelected())
            filtro = "WHERE tesis.status = 'Defendida'";

        String sql = "SELECT idtesis, titulo, status, id_tutorAcademico, id_tutorIndustrial, "
                   + "id_jurado1, id_jurado2 FROM tesis "
                   + "INNER JOIN defensa ON tesis.idtesis = defensa.id_tesis "
                   + "INNER JOIN tutor_industrial ON tesis.id_tutorIndustrial = idtindustrial "
                   + "INNER JOIN profesor ON tesis.id_tutorAcademico = profesor.idprofesor "
                   + filtro;
        try{
            
            DefaultTableModel modelo = new DefaultTableModel();
            TablaTesis.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            
            // Columnas para los datos solicitados
            modelo.addColumn("Código");
            modelo.addColumn("Título");
            modelo.addColumn("Status");
            modelo.addColumn("Tutor A");
            modelo.addColumn("Tutor I");
            modelo.addColumn("Jurado 1");
            modelo.addColumn("Jurado 2");

            while(rs.next()){ //Carga en la tabla
                Object[] filas = new Object[cantidadColumnas];

                for(int i=0; i<cantidadColumnas; i++){
                    filas[i] = rs.getObject(i+1);
                }
                modelo.addRow(filas);
            }

            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();

        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
    }

    //Selecciona en un combo un valor correspondiente a una calificacion nada
    public void setComboSelected(int nota, JComboBox combito){
       combito.setSelectedIndex(nota-1);
    }
    
}
