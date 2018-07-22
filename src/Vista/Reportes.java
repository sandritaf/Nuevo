
package Vista;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;

public class Reportes extends javax.swing.JPanel {

    public Reportes() {
        initComponents();
        cargarCarreras();
        cargarCedulas();
        cargarPeriodos();
        GenerarPDF1.setEnabled(false);
        GenerarPDF2.setEnabled(false);
        GenerarPDF3.setEnabled(false);
    }
    
    private void cargarCarreras(){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT nombre FROM carrera";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            cmbCarreraAprobada.setModel(aModel);
            cmbCarreraConPeriodo.setModel(aModel);
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next() ){
               aux = rs.getString("nombre");
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
    
    private void cargarPeriodos(){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT DISTINCT periodo FROM defensa";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            cmbPeriodoConCarrera.setModel(aModel);
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next() ){
               aux = rs.getString("periodo");// + "- " + rs.getString("nombre");
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

    private void cargarCedulas(){
        DefaultComboBoxModel aModel = new DefaultComboBoxModel();
        String sql = "SELECT cedula FROM estudiante WHERE tesista = 1";
        String aux;
        
        try{
            PreparedStatement ps;
            ResultSet rs;
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            cmbCedulasEstudiantes.setModel(aModel);
            
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next() ){
               aux = rs.getString("cedula");
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ListaTesisCarreraPeriodo = new javax.swing.JRadioButton();
        CarreraConPeriodo = new javax.swing.JLabel();
        cmbCarreraConPeriodo = new javax.swing.JComboBox<>();
        cmbPeriodoConCarrera = new javax.swing.JComboBox<>();
        PeriodoCarrera = new javax.swing.JLabel();
        GenerarPDF2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        DatosTesisCedula = new javax.swing.JRadioButton();
        CedulaEstudiante = new javax.swing.JLabel();
        GenerarPDF1 = new javax.swing.JLabel();
        cmbCedulasEstudiantes = new javax.swing.JComboBox<>();
        iconoDatosTesis = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        ListadoTesisAprobadasCarrera = new javax.swing.JRadioButton();
        CarreraAprobada = new javax.swing.JLabel();
        cmbCarreraAprobada = new javax.swing.JComboBox<>();
        GenerarPDF3 = new javax.swing.JLabel();
        iconoTesisAprobada = new javax.swing.JLabel();
        iconoCarreraAprobada = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(953, 496));
        jPanel1.setRequestFocusEnabled(false);

        jPanel3.setBackground(new java.awt.Color(255, 0, 204));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/reporte64.png"))); // NOI18N
        jLabel2.setText("Reportes");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(320, 388));

        ListaTesisCarreraPeriodo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ListaTesisCarreraPeriodo.setText("Listado de Tesis de una Carrera en un Periodo");
        ListaTesisCarreraPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaTesisCarreraPeriodoActionPerformed(evt);
            }
        });

        CarreraConPeriodo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CarreraConPeriodo.setText("Carrera");

        cmbCarreraConPeriodo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        cmbPeriodoConCarrera.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        PeriodoCarrera.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        PeriodoCarrera.setText("Periodo");

        GenerarPDF2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        GenerarPDF2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pdf50.png"))); // NOI18N
        GenerarPDF2.setText("Generar PDF");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cursos_50color.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/periodo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CarreraConPeriodo)
                    .addComponent(PeriodoCarrera))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbPeriodoConCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCarreraConPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(GenerarPDF2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(ListaTesisCarreraPeriodo)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListaTesisCarreraPeriodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarreraConPeriodo)
                    .addComponent(cmbCarreraConPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PeriodoCarrera)
                    .addComponent(cmbPeriodoConCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(GenerarPDF2)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(320, 388));

        DatosTesisCedula.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        DatosTesisCedula.setText("Datos de una Tesis");
        DatosTesisCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatosTesisCedulaActionPerformed(evt);
            }
        });

        CedulaEstudiante.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CedulaEstudiante.setText("Cédula del Estudiante");

        GenerarPDF1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        GenerarPDF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pdf50.png"))); // NOI18N
        GenerarPDF1.setText("Generar PDF");
        GenerarPDF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenerarPDF1MouseClicked(evt);
            }
        });

        cmbCedulasEstudiantes.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        iconoDatosTesis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tesis.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CedulaEstudiante)
                        .addGap(19, 19, 19)
                        .addComponent(cmbCedulasEstudiantes, 0, 123, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(DatosTesisCedula)
                            .addComponent(iconoDatosTesis))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(GenerarPDF1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DatosTesisCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconoDatosTesis)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CedulaEstudiante)
                    .addComponent(cmbCedulasEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GenerarPDF1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setPreferredSize(new java.awt.Dimension(320, 388));

        ListadoTesisAprobadasCarrera.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        ListadoTesisAprobadasCarrera.setText("Listado de Tesis Aprobadas de una Carrera");
        ListadoTesisAprobadasCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadoTesisAprobadasCarreraActionPerformed(evt);
            }
        });

        CarreraAprobada.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        CarreraAprobada.setText("Carrera");

        cmbCarreraAprobada.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        GenerarPDF3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        GenerarPDF3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pdf50.png"))); // NOI18N
        GenerarPDF3.setText("Generar PDF");

        iconoTesisAprobada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/tesis.png"))); // NOI18N

        iconoCarreraAprobada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cursos_50color.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ListadoTesisAprobadasCarrera)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(CarreraAprobada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(iconoTesisAprobada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iconoCarreraAprobada))
                                    .addComponent(cmbCarreraAprobada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(GenerarPDF3)
                        .addGap(94, 94, 94))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListadoTesisAprobadasCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iconoTesisAprobada)
                    .addComponent(iconoCarreraAprobada))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarreraAprobada)
                    .addComponent(cmbCarreraAprobada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(GenerarPDF3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ListaTesisCarreraPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListaTesisCarreraPeriodoActionPerformed
        GenerarPDF2.setEnabled(true);
        GenerarPDF1.setEnabled(false);
        GenerarPDF3.setEnabled(false);
    }//GEN-LAST:event_ListaTesisCarreraPeriodoActionPerformed

    private void GenerarPDF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerarPDF1MouseClicked
//        try {
//        
//            Conexion conn = new Conexion();
//            Connection con = conn.getConection();
//            JasperReport reporte = null;
//            String report = "ReporteTesis.jasper";
//            String path = "src\\Reportes\\ReporteTesis.jasper";
//            
//            reporte = (JasperReport) JRLoader.loadObjectFromLocation(path);// loadObjectFromFile(path);
//            
//            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, con);
//            JasperViewer view = new JasperViewer(jprint,false);
//            
//            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            
//            view.setVisible(true);
//            
//        } catch (Exception e) {
//        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_GenerarPDF1MouseClicked

    private String valorCombito(JComboBox cmb){
        String s = cmb.getSelectedItem().toString();
        return s;
    }
    
    private void DatosTesisCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatosTesisCedulaActionPerformed
        GenerarPDF1.setEnabled(true);
        GenerarPDF2.setEnabled(false);
        GenerarPDF3.setEnabled(false);
    }//GEN-LAST:event_DatosTesisCedulaActionPerformed

    private void ListadoTesisAprobadasCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadoTesisAprobadasCarreraActionPerformed
        GenerarPDF1.setEnabled(false);
        GenerarPDF2.setEnabled(false);
        GenerarPDF3.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoTesisAprobadasCarreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CarreraAprobada;
    private javax.swing.JLabel CarreraConPeriodo;
    private javax.swing.JLabel CedulaEstudiante;
    private javax.swing.JRadioButton DatosTesisCedula;
    private javax.swing.JLabel GenerarPDF1;
    private javax.swing.JLabel GenerarPDF2;
    private javax.swing.JLabel GenerarPDF3;
    private javax.swing.JRadioButton ListaTesisCarreraPeriodo;
    private javax.swing.JRadioButton ListadoTesisAprobadasCarrera;
    private javax.swing.JLabel PeriodoCarrera;
    private javax.swing.JComboBox<String> cmbCarreraAprobada;
    private javax.swing.JComboBox<String> cmbCarreraConPeriodo;
    private javax.swing.JComboBox<String> cmbCedulasEstudiantes;
    private javax.swing.JComboBox<String> cmbPeriodoConCarrera;
    private javax.swing.JLabel iconoCarreraAprobada;
    private javax.swing.JLabel iconoDatosTesis;
    private javax.swing.JLabel iconoTesisAprobada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
