package Logica;

import Conexion.Conexion;
import Modelo.M_Tesis;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorTesis {

    public ControladorTesis(){
    }
    
    //Carga en un combo box todos los estudiantes que aun no tienen tesis asignadas
    public void cargarAlumnosSinTesis(JComboBox cmbAlumno){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT idestudiante, nombre, apellido FROM estudiante WHERE tesista=0";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            cmbAlumno.setModel(aModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("idestudiante") + "- " + rs.getString("nombre") 
                       + " " + rs.getString("apellido");
               aModel.addElement(aux);
            }
            //Cerrar conexiones
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando estudiantes: "+ex);
        }
    }
    
    //Carga en el combo box los estudiantes con tesis
    public void cargarAlumnosConTesis(JComboBox cmbAlumno){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT idestudiante, nombre, apellido FROM estudiante WHERE tesista=1";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            cmbAlumno.setModel(aModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("idestudiante") + "- " + rs.getString("nombre") 
                       + " " + rs.getString("apellido");
               aModel.addElement(aux);
            }
            //Cerrar conexiones
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando estudiantes: "+ex);
        }
    }
    
    //Carga todos los profesores existentes en la base de datos que puedan ser tutores academicos
    public void cargarProfesores(JComboBox cmbTutor){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT idprofesor, nombre, apellido FROM profesor";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            cmbTutor.setModel(aModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("idprofesor") + "- " + rs.getString("nombre") + " " + rs.getString("apellido");
               aModel.addElement(aux);
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
    
    //Selecciona en un combo box la opcion que corresponde a un codigo PK dado.
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
    
    //Carga en una tabla todos los posibles tutores industriales que pueden atender la tesis
    public void cargarTutores(JComboBox cmbTutor2){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT idtindustrial, nombre, apellido FROM tutor_industrial";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            cmbTutor2.setModel(aModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("idtindustrial") + "- " + rs.getString("nombre") + " " + rs.getString("apellido");
               aModel.addElement(aux);
            }
            //Cerrar conexiones
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando tutores industriales: "+ex);
        }
    }
    
    //Carga en el ComboBox todas las empresas existentes en la base de datos 
    public void cargarEmpresas(JComboBox cmbEmpresa){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT idempresa, nombre FROM empresa";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            cmbEmpresa.setModel(aModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("idempresa") + "- " + rs.getString("nombre");
               aModel.addElement(aux);
            }
            //Cerrar conexiones
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando Empresas: "+ex);
        }
    }
    
    //selecciona una opcion en un combo box que corresponda a un String dado
    public void setComboSelected(String nombre, JComboBox combito){
        //Obtengo la longitud de mi combo
        int largoCombo = combito.getItemCount();
        String textoCombo = "";
        //Recorro el arraycollection
        for (int i = 0; i < largoCombo; i++) {
            textoCombo = combito.getItemAt(i).toString();
             //Comparo los objetos de mi combo con el codigo del item que buscaba
           if (textoCombo == nombre)  {
              //Si encuentra el item le asigno su index a mi combo
              combito.setSelectedIndex(i);
              break;
           }
        }
    }

    //Devuelve el codigo de la opcion seleccionada del comboBpx
    public int getComboSelected(JComboBox combito){
        String codigo = combito.getSelectedItem().toString(); 
        String codigoFinal = "";
        
        int guion = codigo.indexOf("-");
        codigoFinal = codigo.substring(0, guion);
        
        return Integer.parseInt(codigoFinal);
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
    
    //Modifica el status de una tesis dada su clave primaria
    public void modificarStatus(int pk_tesis, String status){
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
//            int pk = Integer.parseInt(pk_tesis);
            PreparedStatement ps;
            
            ps = con.prepareStatement("UPDATE tesis SET status=? WHERE idtesis=?");
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
    
    //Carga todas las tesis en una JTable
    public void cargarTesis(JTable TablaTesis){
        String sql = "SELECT idtesis, titulo, estudiante_tesis, status FROM tesis";

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
            
            modelo.addColumn("Código");
            modelo.addColumn("Título");
            modelo.addColumn("Estudiante");
            modelo.addColumn("Status");

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
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+ex);
        }
    }
}
