package Logica;

import Conexion.Conexion;
import Modelo.M_Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ControladorCarrera {

    public ControladorCarrera() {
    }
    
    /*Verifica que los valores que vienen ingresados por el usuario de las cajas
    no vengan vacios*/
    public boolean estaVacio(M_Carrera carrera){
       if (carrera.getNombre().isEmpty() || carrera.getSemestres().isEmpty())
            return true;
        else if (carrera.getUc_totales().toString().isEmpty())
            return true;
        return false;        
    }
    
    //Comprueba si una carrera ya existe en la tabla carrera
    public boolean carreraExiste(String nombre){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            nombre = nombre.toLowerCase();
            
            ps = con.prepareStatement("SELECT nombre FROM carrera WHERE nombre = ?");
             
            ps.setString(1, nombre);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                bandera = true;
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error verificando si la carrera existe");
        }
        return bandera;
    }
            
    //Ingresa una carrera en la tabla carrera
    public void ingresar(M_Carrera carrera){
        if (estaVacio(carrera))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else {
            try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                
                //Consulta
                ps = con.prepareCall("INSERT INTO carrera (nombre, semestres, uc_totales)"
                        + " VALUES (?,?,?)");
                
                ps.setString(1, carrera.getNombre());
                ps.setInt(2, Integer.parseInt(carrera.getSemestres()));
                ps.setInt(3, Integer.parseInt(carrera.getUc_totales()));
                
                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Carrera guardada con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo guardar la carrera");
                }
                //Cerrar las conexiones
                ps.close();
                conn.CerrarConexion();
                con.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error ingresando carrera: "+e);
            }
        }
    }
    
    //Dada una clave primaria, se elimina una carrera
    public void eliminar(String pk_carrera){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_carrera;      
            PreparedStatement ps;
            //Consulta
            ps = con.prepareStatement("DELETE FROM carrera WHERE idcarrera="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Carrera eliminada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la carrera");
              }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando carrera: "+e);
        }
    }
    
    //Se modifican los valores de un registro de la tabla Carrera
    public void modificar(M_Carrera carrera, String pk_carrera){
        if (estaVacio(carrera))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else{
            try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            int pk = Integer.parseInt(pk_carrera);
            PreparedStatement ps;         
            //Consulta
            ps = con.prepareStatement("UPDATE carrera SET nombre=?, uc_totales=?, semestres=?" +
                                        " WHERE id_carrera=?");
            
            ps.setString(1, carrera.getNombre()); 
            ps.setInt(2, Integer.parseInt(carrera.getUc_totales())); 
            ps.setInt(3, Integer.parseInt(carrera.getSemestres())); 
            ps.setInt(4, pk); 
            
            int res = ps.executeUpdate(); //Ejecutar consulta
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Carrera modificada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo modificar la carrera");
            }
            //Cerrar consulta        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Ocurrió un error en la modificacion: "+e);
            }
        }
    }
    
    //Se cargan las carreras existentes en la BDD en una tabla
    public void cargarCarreras(JTable TablaCarreras){
        try{
            DefaultTableModel modelo = new DefaultTableModel();
            TablaCarreras.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            //la consulta a realizar
            ps = (PreparedStatement) con.prepareStatement("SELECT id_carrera, nombre, "
                                                 + "semestres, uc_totales FROM carrera");
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            
            //Las columnas que tendra la tabla
            modelo.addColumn("Código");
            modelo.addColumn("Nombre");
            modelo.addColumn("Num. Semestres");
            modelo.addColumn("UC totales");

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

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la carga: "+e);
        }
    }
}
