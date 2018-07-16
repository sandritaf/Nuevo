package Logica;

import Conexion.Conexion;
import Modelo.M_Empresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class ControladorEmpresa {

    public ControladorEmpresa() {
    }
    
    public boolean estaVacio(M_Empresa empresa){
        if (empresa.getNombre().isEmpty() || empresa.getRif().isEmpty() || empresa.getTelefono().isEmpty())
            return true;
        else if (empresa.getDireccion().isEmpty() || empresa.getGerente().isEmpty())
            return true;
        return false;
    }
    
    //Comprueba si un rif ya existe en la tabla empresa
    public boolean idExiste(String rif){
        boolean bandera = false;
        try {
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            PreparedStatement ps;
            ResultSet rs;
            
            ps = con.prepareStatement("SELECT rif FROM empresa WHERE rif = ?");
             
            ps.setString(1, rif);
            
            rs = ps.executeQuery();
                        
            if(rs.next()){
                bandera = true;
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error identificando empresa: "+e);
        }
        return bandera;
    }
    
    //Ingresa una empresa en la tabla
    public void ingresar(M_Empresa empresa){
        if (estaVacio(empresa))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else {
            try {
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                PreparedStatement ps = null;                

                ps = con.prepareCall("INSERT INTO empresa (rif, nombre, gerente, direccion, telefono)"
                        + " VALUES (?,?,?,?,?)");

                ps.setString(1, empresa.getRif());
                ps.setString(2, empresa.getNombre());
                ps.setString(3, empresa.getGerente());
                ps.setString(4, empresa.getDireccion());
                ps.setString(5, empresa.getTelefono());

                int res = ps.executeUpdate(); //Ejecutar la consulta

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Empresa guardada con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo guardar");
                }
                //Cerrar las conexiones
                ps.close();
                conn.CerrarConexion();
                con.close();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error guardando empresa: "+e);
            }
        }
    }
    
    //Dada una clave primaria, se elimina una empresa
    public void eliminar(String pk_empresa){
        
        try {
            Conexion c = new Conexion();
            Connection con = c.getConection();
            String pk = pk_empresa;      
            PreparedStatement ps;
            
            ps = con.prepareStatement("DELETE FROM empresa WHERE idempresa="+pk);
                        
            int res = ps.executeUpdate();
            
            if (res > 0){
                JOptionPane.showMessageDialog(null, "Empresa eliminada con éxito");
            }else{
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la empresa");
              }
                        
            c.CerrarConexion();
            con.close();
            ps.close();
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error eliminando: "+e);
        }
    }
    
    //Se modifican datos de un estudiante dada su clave primaria, validar que no se ingresan 2 rif iguales
    public void modificar(M_Empresa empresa, String pk_empresa){
        if (estaVacio(empresa))
            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos.");
        else {
            try {
                Conexion c = new Conexion();
                Connection con = c.getConection();
                int pk = Integer.parseInt(pk_empresa);
                PreparedStatement ps;

                ps = con.prepareStatement("UPDATE empresa SET rif=?,nombre=?,gerente=?,direccion=?,telefono=?" +
                                            "WHERE idempresa=?");

                ps.setString(1, empresa.getRif()); 
                ps.setString(2, empresa.getNombre()); 
                ps.setString(3, empresa.getGerente()); 
                ps.setString(4, empresa.getDireccion()); 
                ps.setString(5, empresa.getTelefono());
                ps.setInt(6,pk);

                int res = ps.executeUpdate();

                if (res > 0){
                    JOptionPane.showMessageDialog(null, "Empresa modificada con éxito");
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo modificar empresa");
                }

                c.CerrarConexion();
                con.close();
                ps.close();

            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
            }
        }
    }
    
    
}
