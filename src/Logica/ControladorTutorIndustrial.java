package Logica;

import Conexion.Conexion;
import Modelo.M_TutorIndustrial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorTutorIndustrial {

    //Verifica si los valores vienen vacios
    public boolean estaVacio(M_TutorIndustrial tutor){
        if (tutor.getNombre().isEmpty() || tutor.getApellido().isEmpty())
            return true;
        else if (tutor.getCedula().isEmpty() || tutor.getTelefono().isEmpty())
            return true;
        return false;
    }
    
    //Comprueba si una cedula ya existe en la tabla tutor_industrial
    public boolean idExiste(String cedula_tutor){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT cedula FROM tutor_industrial WHERE cedula = ?");
             
            ps.setString(1, cedula_tutor);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                bandera = true;
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
        return bandera;
    }
            
    //Carga el comboBox con las empresas existentes en la BDD
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
    
    //Ingresa un tutor en la tabla
    public void ingresar(M_TutorIndustrial tutor){
        if (estaVacio(tutor))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else {
            try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                
                ps = con.prepareCall("INSERT INTO tutor_industrial (cedula, nombre, apellido, telefono, id_empresa)"
                        + " VALUES (?,?,?,?,?)");
                
                ps.setString(1, tutor.getCedula());
                ps.setString(2, tutor.getNombre());
                ps.setString(3, tutor.getApellido());
                ps.setString(4, tutor.getTelefono());
                ps.setInt(5, tutor.getId_empresa());

                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Tutor guardado con éxito");
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
    
    //Dada una clave primaria, se elimina un tutor
    public void eliminar(String pk_tutor){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_tutor;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM tutor_industrial WHERE idtindustrial="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Tutor eliminado con éxito");
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
    
    //Se modifican datos de un tutor dada su clave primaria, validar que no se ingresan 2 cedulas iguales
    public void modificar(String pk_tutor, M_TutorIndustrial tutor){
        if (estaVacio(tutor))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else{
            try {
                Conexion c = new Conexion();
                Connection con = c.getConection();
                int pk = Integer.parseInt(pk_tutor);
                PreparedStatement ps;            
                ps = con.prepareStatement("UPDATE tutor_industrial SET cedula=?, nombre=?, apellido=?, telefono=?, id_empresa=?" +
                                            " WHERE idtindustrial=?");

                ps.setString(1, tutor.getCedula()); 
                ps.setString(2, tutor.getNombre()); 
                ps.setString(3, tutor.getApellido()); 
                ps.setString(4, tutor.getTelefono()); 
                ps.setInt(5, tutor.getId_empresa());
                ps.setInt(6, pk);

                int res = ps.executeUpdate();

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Tutor modificada con éxito");
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

    //Recibe un codigo y busca (y selecciona) en el ComboBox la opcion que le corresponda
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
    
    //Devuelve en codigo de la opcion seleccionada en el comboBox
    public int getComboSelected(JComboBox combito){
        String codigo = combito.getSelectedItem().toString(); 
        String codigoFinal = "";
        
        int guion = codigo.indexOf("-");
        codigoFinal = codigo.substring(0, guion);
        
        return Integer.parseInt(codigoFinal);
    }
    
    //Carga los tutores en la tabla, desde la bdd
    public void cargarTutores(JTable TablaTutores){
        String sql = "SELECT idtindustrial, nombre, apellido, cedula, telefono, id_empresa FROM tutor_industrial order by apellido";

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            TablaTutores.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            
            modelo.addColumn("Código");
            modelo.addColumn("Cedula");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Teléfono");
            modelo.addColumn("Empresa");

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
            System.err.println(ex);
        }
    }
}
