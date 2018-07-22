package Logica;

import Conexion.Conexion;
import Modelo.M_Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorProfesor {

    public ControladorProfesor() {
    }
    
    //Verifica que los valores ingresados no vengan vacios
    public boolean estaVacio(M_Profesor profesor){
        if (profesor.getNombre().isEmpty() || profesor.getApellido().isEmpty())
            return true;
        else if (profesor.getCedula().isEmpty() || profesor.getProfesion().isEmpty())
            return true;
        return false;
    }
    
    //Devuelve el codigo de la opcion seleccionada en un combo
    public int getComboSelected(JComboBox combito){
        String codigo = combito.getSelectedItem().toString(); 
        String codigoFinal = "";
        
        int guion = codigo.indexOf("-");
        codigoFinal = codigo.substring(0, guion);
        
        return Integer.parseInt(codigoFinal);
    }
    
    //Carga las carreras disponibles a las que asignar a un profesor
    public void cargarCarreras(JComboBox cmbCarrera){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT id_carrera, nombre FROM carrera";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            cmbCarrera.setModel(aModel);
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next() ){
               aux = rs.getString("id_carrera") + "- " + rs.getString("nombre");
               aModel.addElement(aux);
            }
            //Cerrar conexiones
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();            
        
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando Carreras: "+ex);
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
    
    //Se agrega en tabla un profesor
    public void ingresar(M_Profesor profesor){
        if (estaVacio(profesor))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else {
            try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps = null;                

            ps = con.prepareCall("INSERT INTO profesor (nombre, apellido, cedula, telefono, "
                    + "profesion, direccion, id_carrera_fk) VALUES (?,?,?,?,?,?,?)");

            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellido());
            ps.setString(3, profesor.getCedula());
            ps.setString(4, profesor.getTelefono());
            ps.setString(5,profesor.getProfesion());
            ps.setString(6,profesor.getDireccion());
            ps.setInt(7,profesor.getCarrera());

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
                JOptionPane.showMessageDialog(null, "Ocurrió un error guardando prof: "+e);
            }
        }
    }
    
    //Dada una clave primaria, se elimina un profesor
    public void eliminar(String pk_profesor){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_profesor;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM profesor WHERE idprofesor="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Persona eliminada con éxito");
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
    public void modificar(M_Profesor profesor, String pk_){
        if (estaVacio(profesor))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else{
            try {
                Conexion c = new Conexion();
                Connection con = c.getConection();
                int pk = Integer.parseInt(pk_);
                PreparedStatement ps;

                ps = con.prepareStatement("UPDATE profesor SET cedula=?,nombre=?,apellido=?,telefono=?," +
                                            "profesion=?, direccion=?, id_carrera_fk=? WHERE idprofesor=?");

                ps.setString(1, profesor.getCedula()); 
                ps.setString(2, profesor.getNombre()); 
                ps.setString(3, profesor.getApellido()); 
                ps.setString(4, profesor.getTelefono());  
                ps.setString(5, profesor.getProfesion());
                ps.setString(6, profesor.getDireccion()); 
                ps.setInt(7, profesor.getCarrera()); 
                ps.setInt(8,pk);

                int res = ps.executeUpdate();

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Profesor modificado con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar");
                }

                c.CerrarConexion();
                con.close();
                ps.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
            }
        }
    }
    
    //Carga en la tabla los valores de los registros de la tabla profesor
    public void cargarTabla(JTable TablaProfesor){
        String sql = "SELECT idprofesor, nombre, apellido, profesion, id_carrera_fk FROM profesor order by apellido";

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            TablaProfesor.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Profesión");
            modelo.addColumn("Carrera");

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
