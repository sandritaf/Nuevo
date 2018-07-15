package Conexion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private static final String BDD = "proyectotesis";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/"+BDD+"?useSSL=false"; 
    private Connection con = null;
    
    //public Conexion(){}
        
    public Connection getConection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection)DriverManager.getConnection(URL,USERNAME,PASSWORD);
           // JOptionPane.showMessageDialog(null, "Conexion exitosa");
        }catch(SQLException e){
            System.err.println(e);
        } catch(ClassNotFoundException e){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return con;
    }
    
    public void CerrarConexion() throws ClassNotFoundException, SQLException{
        con = null;
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
