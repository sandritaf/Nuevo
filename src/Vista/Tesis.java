package Vista;

import Conexion.Conexion;
import Logica.ControladorTesis;
import Logica.ManejadorFecha;
import Modelo.M_Tesis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Tesis extends javax.swing.JPanel {

    ControladorTesis controlador;
    M_Tesis tesis;
    ManejadorFecha manejador;
    
    public Tesis() {
        initComponents();
        controlador = new ControladorTesis();
        tesis = new M_Tesis();
        txtPK.setVisible(false);
        Modificar.setEnabled(false);
        Eliminar.setEnabled(false);
        txtPKIndustrial.setVisible(false);
        txtPKEmpresa.setVisible(false);
        controlador.cargarAlumnosSinTesis(cmbAlumno);
        controlador.cargarProfesores(cmbTutorA);
        //controlador.cargarTutores(cmbTutorI);
        controlador.cargarEmpresas(cmbEmpresa);
        manejador = new ManejadorFecha();
    }
    
    //Devuelve el codigo de la opcion seleccionada en un combo
    public int getComboSelected(JComboBox combito){
        String codigo = combito.getSelectedItem().toString(); 
        String codigoFinal = "";
        
        int guion = codigo.indexOf("-");
        codigoFinal = codigo.substring(0, guion);
        
        return Integer.parseInt(codigoFinal);
    }
    
    private boolean verificarTutorEmpresa(){
        
//        int pk_industrial = Integer.parseInt(pk_ti);
        int pk_empresa = getComboSelected(cmbEmpresa);
        int pk_industrial = getComboSelected(cmbTutorI);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            int fila = TablaTesis.getSelectedRow();
//            int codigo = getComboSelected(cmbTutorI);
            int codigo = (int)TablaTesis.getValueAt(fila, 0);
            
            ps = (PreparedStatement) con.prepareStatement("SELECT id_empresa, idtindustrial FROM tutor_industrial"
                                                        + " INNER JOIN tesis ON tesis.id_tutorIndustrial = tutor_industrial.idtindustrial "
                                                        + " WHERE idtesis=?");
            ps.setInt(1, codigo);          
            rs = ps.executeQuery();                            
            
            while(rs.next()){
                txtPKIndustrial.setText(rs.getString("idtindustrial"));
                txtPKEmpresa.setText(rs.getString("id_empresa"));
            }
            
            ps.close();
            rs.close();
            con.close();
            conn.CerrarConexion();
            
            int a = Integer.parseInt(txtPKEmpresa.getText());
            
            if(a == pk_empresa){
//                JOptionPane.showMessageDialog(null, "El tutor seleccionado ESTÁ ASOCIADO");
                return true;
            }
            else
                return false;
                //JOptionPane.showMessageDialog(null, "NO ESTÁ ASOCIADO");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
        return false;
    }
    
    private void cargarTutorConEmpresa(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            int fila = TablaTesis.getSelectedRow();
            int codigo = getComboSelected(cmbTutorI);
            
            ps = (PreparedStatement) con.prepareStatement("SELECT id_empresa FROM tutor_industrial WHERE"
                                                        + " id_empresa=?");
            
            ps.setInt(1, codigo);          
            rs = ps.executeQuery();                            
            
            while(rs.next()){
                txtPKIndustrial.setText(rs.getString("idtindustrial"));
                txtPKEmpresa.setText(rs.getString("id_empresa"));
            }
            
            ps.close();
            rs.close();
            con.close();
            conn.CerrarConexion();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
    }
        
    private boolean verificarFechaMayor(){
        if(txtVacio(txtFechaI) || txtVacio(txtFechaF))
            JOptionPane.showMessageDialog(null, "NO pueden haber campos vacíos (fechas vacias)");
        else{
            return manejador.rangoCorrectoTesis(txtFechaI.getText(), txtFechaF.getText());
        }
        return false;
    }
    
    private boolean FechaFinMayorFechaInicio(){
        if(txtVacio(txtFechaI) || txtVacio(txtFechaF))
            JOptionPane.showMessageDialog(null, "NO pueden haber campos vacíos (fechas vacias) ");
        else{
            return manejador.fechasCorrectas(txtFechaI.getText(), txtFechaF.getText());
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        cmbAlumno = new javax.swing.JComboBox<>();
        cmbTutorA = new javax.swing.JComboBox<>();
        cmbTutorI = new javax.swing.JComboBox<>();
        cmbEmpresa = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        cmbDepartamento = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtFechaI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtFechaF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        Guardar = new javax.swing.JLabel();
        Modificar = new javax.swing.JLabel();
        Limpiar = new javax.swing.JLabel();
        txtPKEmpresa = new javax.swing.JTextField();
        txtPKIndustrial = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Cargar = new javax.swing.JLabel();
        Eliminar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTesis = new javax.swing.JTable();
        Exportar = new javax.swing.JLabel();
        txtPK = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(31, 58, 147));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8-documento-64.png"))); // NOI18N
        jLabel1.setText("Gestionar Acta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(884, 477));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Título");

        txtTitulo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        cmbAlumno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        cmbTutorA.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbTutorA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTutorAActionPerformed(evt);
            }
        });

        cmbTutorI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        cmbEmpresa.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbEmpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEmpresaItemStateChanged(evt);
            }
        });
        cmbEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbEmpresaMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Estudiante");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("T. Académico");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("T. Industrial");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Empresa");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Departamento");

        cmbDepartamento.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dirección General", "Auxiliar administrativo", "Administración", "Recursos Humanos", "Finanzas/Contabilidad", "Producción", "Publicidad/Mercadeo", "Informática" }));

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Fecha Inicio");

        txtFechaI.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        txtFechaI.setForeground(new java.awt.Color(102, 102, 102));
        txtFechaI.setText("yyyy-mm-dd");
        txtFechaI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Fecha Fin");

        txtFechaF.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        txtFechaF.setForeground(new java.awt.Color(102, 102, 102));
        txtFechaF.setText("yyyy-mm-dd");
        txtFechaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Observaciones");

        txtObservaciones.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtObservaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionesActionPerformed(evt);
            }
        });

        Guardar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar.png"))); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarMouseClicked(evt);
            }
        });

        Modificar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar.png"))); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ModificarMouseEntered(evt);
            }
        });

        Limpiar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escoba.png"))); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTitulo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbAlumno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbTutorA, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbTutorI, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbDepartamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFechaI, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                                    .addComponent(txtFechaF))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(Limpiar)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(txtPKEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPKIndustrial, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Modificar)
                    .addComponent(Guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTutorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTutorI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPKEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKIndustrial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        Cargar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Cargar.setForeground(new java.awt.Color(34, 49, 63));
        Cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8-libros-50.png"))); // NOI18N
        Cargar.setText("Listado de Tesis");
        Cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarMouseClicked(evt);
            }
        });

        Eliminar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eliminar_libro.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarMouseClicked(evt);
            }
        });

        TablaTesis.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TablaTesis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tìtulo", "Status", "Estudiante", "Calificación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaTesis.setSelectionBackground(new java.awt.Color(244, 179, 80));
        TablaTesis.setShowHorizontalLines(false);
        TablaTesis.setShowVerticalLines(false);
        TablaTesis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTesisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTesis);

        Exportar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pdf50.png"))); // NOI18N
        Exportar.setText("Exportar a PDF");
        Exportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExportarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(txtPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Cargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Eliminar)
                    .addComponent(Cargar)
                    .addComponent(Exportar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(txtPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))))
        );

        jPanel3.setBackground(new java.awt.Color(255, 167, 0));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/libreta64.png"))); // NOI18N
        jLabel2.setText("Gestionar Tesis");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtFechaIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIActionPerformed
      
    }//GEN-LAST:event_txtFechaIActionPerformed

    private void txtFechaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFActionPerformed
     
    }//GEN-LAST:event_txtFechaFActionPerformed

    private void txtObservacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionesActionPerformed
       
    }//GEN-LAST:event_txtObservacionesActionPerformed

    private void cmbTutorAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTutorAActionPerformed
      
    }//GEN-LAST:event_cmbTutorAActionPerformed

    /*Falta asegurarse de que no se ingresan campos vacíos*/
    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        if(!verificarFechaMayor()){
            JOptionPane.showMessageDialog(null, "La tesis debe realizarse entre mínimo 4 y máximo 6 meses. Ingrese fechas que cumplan esta condición");
        }
        else if(!FechaFinMayorFechaInicio()){
            JOptionPane.showMessageDialog(null, "La fecha inicial debe ser menor a la fecha final");
        }
//        else if(!verificarTutorEmpresa()){
//            JOptionPane.showMessageDialog(null, "El tutor seleccionado no está asociado a la empresa");
//        }
        else{
        tesis.actualizar("En desarrollo", txtTitulo.getText(), txtFechaI.getText(),
                txtFechaF.getText(), txtObservaciones.getText(), cmbDepartamento.getSelectedItem().toString(), 
                controlador.getComboSelected(cmbTutorA),  controlador.getComboSelected(cmbTutorI), 
                controlador.getComboSelected(cmbAlumno), controlador.getComboSelected(cmbEmpresa));
        controlador.ingresar(tesis);
        limpiarCajas();
        }
    }//GEN-LAST:event_GuardarMouseClicked

    private void ExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExportarMouseClicked
        
    }//GEN-LAST:event_ExportarMouseClicked

    //Llama al controlador para cargar todas las tesis en la tabka
    private void CargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarMouseClicked
        controlador.cargarTesis(TablaTesis);
    }//GEN-LAST:event_CargarMouseClicked

    private void LimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiarMouseClicked
        limpiarCajas();
    }//GEN-LAST:event_LimpiarMouseClicked

    //Llama al controlador para eliminar un registro seleccionado
    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        if(txtPK.getText().isEmpty()){ //Asegurarse de que hay una tesis seleccionada
            JOptionPane.showMessageDialog(null, "Seleccione una tesis a eliminar");
        } else {
            controlador.eliminar(txtPK.getText());
        }
        limpiarCajas();    
    }//GEN-LAST:event_EliminarMouseClicked

    //Carga en los ComboBox y las cajas de texto los valores de un registro de tesis seleccionado
    private void TablaTesisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTesisMouseClicked
        Guardar.setEnabled(false);
        Modificar.setEnabled(true);
        Eliminar.setEnabled(true);
        controlador.cargarAlumnosConTesis(cmbAlumno);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            int fila = TablaTesis.getSelectedRow();
            int codigo = (int)TablaTesis.getValueAt(fila, 0);
            
            ps = (PreparedStatement) con.prepareStatement("SELECT idtesis, titulo, estudiante.idestudiante, "
                    + "estudiante_tesis, id_tutorIndustrial, id_tutorAcademico, estudiante.id_empresa, "
                    + "departamento, fecha_inicio, fecha_fin, observaciones FROM tesis INNER JOIN estudiante "
                    + "ON estudiante.idestudiante = tesis.estudiante_tesis WHERE idtesis=?");
            
            ps.setInt(1, codigo);          
            rs = ps.executeQuery();                            
            
            while(rs.next()){
                txtPK.setText(rs.getString("idtesis"));
                txtTitulo.setText(rs.getString("titulo"));
                controlador.setComboSelected(rs.getInt("estudiante_tesis"),cmbAlumno);
                controlador.setComboSelected(rs.getInt("id_tutorAcademico"),cmbTutorA);
                controlador.cargarTutores(cmbTutorI, rs.getInt("estudiante.id_empresa"));
                controlador.setComboSelected(rs.getInt("id_tutorIndustrial"),cmbTutorI);
                controlador.setComboSelected(rs.getInt("estudiante.id_empresa"),cmbEmpresa);
                controlador.setComboSelected(rs.getString("departamento"),cmbDepartamento);
                txtFechaI.setText((rs.getDate("fecha_inicio")).toString());
                txtFechaF.setText((rs.getDate("fecha_fin")).toString());
                txtObservaciones.setText(rs.getString("observaciones"));
            }
            ps.close();
            rs.close();
            con.close();
            conn.CerrarConexion();
            
//            verificarTutorEmpresa();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+e);
        }
    }//GEN-LAST:event_TablaTesisMouseClicked

    //Invoca al controlador y le envia valores nuevos que modificar , asociados a la tesis
    private void ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseClicked
        //Verifica que haya un registro seleccionado
        if(txtPK.getText().isEmpty())
            JOptionPane.showMessageDialog(null, "Seleccione una tesis");
        if(!verificarFechaMayor()){
            JOptionPane.showMessageDialog(null, "La tesis debe realizarse entre mínimo 4 y máximo 6 meses. Ingrese fechas que cumplan esta condición");
        }
        else if(!FechaFinMayorFechaInicio()){
            JOptionPane.showMessageDialog(null, "La fecha inicial debe ser menor a la fecha final");
        }
//        else if(!verificarTutorEmpresa()){
//            JOptionPane.showMessageDialog(null, "El tutor seleccionado no está asociado a la empresa");
//        }
        else{
            
        tesis.actualizar("En desarrollo", txtTitulo.getText(), txtFechaI.getText(),
                txtFechaF.getText(), txtObservaciones.getText(), cmbDepartamento.getSelectedItem().toString(), 
                controlador.getComboSelected(cmbTutorA),  controlador.getComboSelected(cmbTutorI), 
                controlador.getComboSelected(cmbAlumno), controlador.getComboSelected(cmbEmpresa));
        controlador.modificar(tesis, txtPK.getText());
        limpiarCajas();
        //controlador.cargarAlumnosSinTesis(cmbAlumno);
            
        }
//        //Verifica que haya un registro seleccionado
//        if(txtPK.getText().isEmpty()){
//            JOptionPane.showMessageDialog(null, "Seleccione una tesis");
//        } else {        
//            tesis.actualizar("En desarrollo", txtTitulo.getText(), txtFechaI.getText(),
//                txtFechaF.getText(), txtObservaciones.getText(), cmbDepartamento.getSelectedItem().toString(), 
//                controlador.getComboSelected(cmbTutorA),  controlador.getComboSelected(cmbTutorI), 
//                controlador.getComboSelected(cmbAlumno), controlador.getComboSelected(cmbEmpresa));
//            controlador.modificar(tesis, txtPK.getText()); 
//        }
//        limpiarCajas();
    }//GEN-LAST:event_ModificarMouseClicked

    private void ModificarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ModificarMouseEntered

    private void cmbEmpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEmpresaItemStateChanged
        
        controlador.cargarTutores(cmbTutorI, controlador.getComboSelected(cmbEmpresa));
    }//GEN-LAST:event_cmbEmpresaItemStateChanged

    private void cmbEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbEmpresaMouseClicked
        //controlador.cargarTutores(cmbTutorI, controlador.getComboSelected(cmbEmpresa));
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEmpresaMouseClicked
    
    public void limpiarCajas(){
        txtFechaF.setText(null);
        txtFechaI.setText(null);
        txtObservaciones.setText(null);
        txtTitulo.setText(null);
        txtPK.setText(null);
        Exportar.setEnabled(false);
        cmbTutorA.setSelectedItem(0);
        cmbTutorI.setSelectedItem(0);
        cmbDepartamento.setSelectedItem(0);
        cmbEmpresa.setSelectedItem(0);
        Guardar.setEnabled(true);
        Modificar.setEnabled(false);
        Eliminar.setEnabled(false);
        controlador.cargarAlumnosSinTesis(cmbAlumno);
        cmbAlumno.setSelectedItem(0);
        txtPKEmpresa.setText(null);
        txtPKIndustrial.setText(null);
    }
    
    public boolean txtVacio(JTextField txt){
        if(txt.getText().isEmpty())
            return true;
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cargar;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel Exportar;
    private javax.swing.JLabel Guardar;
    private javax.swing.JLabel Limpiar;
    private javax.swing.JLabel Modificar;
    private javax.swing.JTable TablaTesis;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbAlumno;
    private javax.swing.JComboBox<String> cmbDepartamento;
    private javax.swing.JComboBox<String> cmbEmpresa;
    private javax.swing.JComboBox<String> cmbTutorA;
    private javax.swing.JComboBox<String> cmbTutorI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFechaF;
    private javax.swing.JTextField txtFechaI;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtPK;
    private javax.swing.JTextField txtPKEmpresa;
    private javax.swing.JTextField txtPKIndustrial;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
