package Vista;

import Conexion.Conexion;
import Logica.ControladorConsultaTesis;
import Logica.ControladorTesis;
import Modelo.M_Tesis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaTesis extends javax.swing.JPanel {

    ControladorConsultaTesis controlador;
    M_Tesis tesis;
    
    public ConsultaTesis() {
        initComponents();
        controlador = new ControladorConsultaTesis();
        tesis = new M_Tesis();
        txtPK.setVisible(false);
        cargarCarreras();
    }
    
    public String filtroCarrera(){        
        String codcarrera = cmbCarrera.getSelectedItem().toString(); 
        String codigoFinal = "";
        
        int guion = codcarrera.indexOf("-");
        codigoFinal = codcarrera.substring(0, guion);
        
        int codigoCarrera = Integer.parseInt(codigoFinal);
        String cadena = "id_carrera = "+codigoCarrera;
        return cadena;
    }
    
    public String filtroCedula(){
        String cadena = "cedula LIKE '"+txtCedula.getText()+"%'";
        return cadena;
    }
       
    private void cargarCarreras(){
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
            JOptionPane.showMessageDialog(null, "Ocurrió un error cargando carreas: "+ex);
        }
    }

    private String getStatusSelected(){
        if (Reprobada.isSelected())
           return " status='Reprobada' ";
        else if (Aprobada.isSelected())
            return " status='Aprobada' ";
        else if (EnDesarrollo.isSelected())
            return " status='En desarrollo' ";
        else
            return " status='Por defender' ";
    }
     
/*    public String filtroFechaI(){
        String cadena = " fecha_inicio ="+txtAnio.getText();
        return cadena;
    }
    
    public String filtroFechaF(){
        String cadena = " fecha_fin ="+txtFechaF.getText();
        return cadena;
    }*/

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Reprobada = new javax.swing.JRadioButton();
        Aprobada = new javax.swing.JRadioButton();
        PorDefender = new javax.swing.JRadioButton();
        EnDesarrollo = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTesis = new javax.swing.JTable();
        Cargar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        cmbCarrera = new javax.swing.JComboBox<>();
        txtPK = new javax.swing.JTextField();
        txtTutorInd = new javax.swing.JTextField();
        txtTutorAcad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Limpiar = new javax.swing.JLabel();
        PorPeriodo = new javax.swing.JRadioButton();
        PorCarrera = new javax.swing.JRadioButton();
        PorStatus = new javax.swing.JRadioButton();
        PorCedula = new javax.swing.JRadioButton();
        SemestreI = new javax.swing.JRadioButton();
        SemestreII = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        txtFechaI = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtFechaF = new javax.swing.JTextField();
        Defendida = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
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

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Año");

        txtAnio.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        txtAnio.setText("yyyy-mm-dd");
        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Semestre");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Status");

        Reprobada.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Reprobada);
        Reprobada.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Reprobada.setText("Reprobada");

        Aprobada.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Aprobada);
        Aprobada.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Aprobada.setText("Aprobada");

        PorDefender.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(PorDefender);
        PorDefender.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PorDefender.setText("Por Defender");

        EnDesarrollo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(EnDesarrollo);
        EnDesarrollo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        EnDesarrollo.setText("En desarrollo");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Carrera");

        TablaTesis.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TablaTesis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tìtulo", "Status", "Nombre Autor", "Apellido Autor", "Observaciones", "Empresa", "Departamento", "Calificacion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaTesis.setSelectionBackground(new java.awt.Color(255, 153, 102));
        TablaTesis.setShowHorizontalLines(false);
        TablaTesis.setShowVerticalLines(false);
        TablaTesis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTesisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTesis);

        Cargar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Cargar.setForeground(new java.awt.Color(34, 49, 63));
        Cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8-libros-50.png"))); // NOI18N
        Cargar.setText("Listado de Tesis");
        Cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Cédula");

        txtCedula.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        cmbCarrera.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTutorInd.setEditable(false);
        txtTutorInd.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        txtTutorInd.setForeground(new java.awt.Color(102, 102, 102));
        txtTutorInd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTutorIndActionPerformed(evt);
            }
        });

        txtTutorAcad.setEditable(false);
        txtTutorAcad.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        txtTutorAcad.setForeground(new java.awt.Color(102, 102, 102));
        txtTutorAcad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTutorAcadActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Tutor Industrial");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Tutor Académico");

        Limpiar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escoba.png"))); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimpiarMouseClicked(evt);
            }
        });

        PorPeriodo.setBackground(new java.awt.Color(255, 255, 255));
        PorPeriodo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PorPeriodo.setText("Filtrar por Fechas");

        PorCarrera.setBackground(new java.awt.Color(255, 255, 255));
        PorCarrera.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PorCarrera.setText("Filtrar por Carrera");

        PorStatus.setBackground(new java.awt.Color(255, 255, 255));
        PorStatus.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PorStatus.setText("Filtrar por Status");

        PorCedula.setBackground(new java.awt.Color(255, 255, 255));
        PorCedula.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PorCedula.setText("Filtrar por Cédula");

        SemestreI.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(SemestreI);
        SemestreI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        SemestreI.setText("I");

        SemestreII.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup3.add(SemestreII);
        SemestreII.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        SemestreII.setText("II");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Fecha Inicio");

        txtFechaI.setEditable(false);
        txtFechaI.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFechaI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Fecha Fin");

        txtFechaF.setEditable(false);
        txtFechaF.setBackground(new java.awt.Color(255, 255, 255));
        txtFechaF.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFechaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFActionPerformed(evt);
            }
        });

        Defendida.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Defendida);
        Defendida.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Defendida.setSelected(true);
        Defendida.setText("Defendida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(305, 305, 305)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(txtTutorInd, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(txtTutorAcad, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel7))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(8, 8, 8)
                                                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel11))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(SemestreI, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(PorPeriodo)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PorCarrera)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel12)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(Reprobada))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(EnDesarrollo)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(PorDefender)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(Defendida))))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(282, 282, 282)
                                                        .addComponent(Aprobada)
                                                        .addGap(37, 37, 37))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(PorStatus)
                                                        .addGap(72, 72, 72)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(51, 51, 51)
                                                        .addComponent(PorCedula))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel8)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Limpiar)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Cargar)
                                            .addComponent(SemestreII, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 261, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PorPeriodo)
                            .addComponent(PorCarrera)
                            .addComponent(PorStatus)
                            .addComponent(PorCedula))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cmbCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(SemestreI)
                            .addComponent(SemestreII))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Cargar)
                                .addComponent(Limpiar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTutorInd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTutorAcad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Reprobada)
                        .addComponent(Aprobada)
                        .addComponent(jLabel8)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EnDesarrollo)
                            .addComponent(PorDefender)
                            .addComponent(Defendida))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 167, 0));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/libreta64.png"))); // NOI18N
        jLabel2.setText("Consultar Tesis");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(351, 351, 351)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(534, 534, 534)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
      
    }//GEN-LAST:event_txtAnioActionPerformed

    private void CargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarMouseClicked
        String sql = "SELECT idtesis, titulo, status, "
                + "estudiante.nombre, estudiante.apellido, observaciones, empresa.nombre, "
                + "departamento FROM tesis INNER JOIN "
                + "estudiante ON estudiante.idestudiante = tesis.estudiante_tesis "
                + "INNER JOIN empresa ON estudiante.id_empresa = empresa.idempresa";
        if (PorCarrera.isSelected())
            sql = sql + " WHERE estudiante."+filtroCarrera();
        if (PorStatus.isSelected())
            sql = sql + " WHERE "+getStatusSelected();
        if (PorCedula.isSelected())
            sql = sql + " WHERE estudiante."+filtroCedula();
        if (PorPeriodo.isSelected()){
            
        }
             
        
        /* + "/*INNER JOIN notas ON notas.id_tesis = tesis.idtesis";*/

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
            modelo.addColumn("Status");
            modelo.addColumn("Nombre autor");
            modelo.addColumn("Apellido autor");
            modelo.addColumn("Observaciones");
            modelo.addColumn("Empresa");
            modelo.addColumn("Departamento");
            //modelo.addColumn("Calificacion");

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
    }//GEN-LAST:event_CargarMouseClicked

    private void TablaTesisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTesisMouseClicked
        int fila = TablaTesis.getSelectedRow();
        int codigo = (int)TablaTesis.getValueAt(fila, 0);
        String status = TablaTesis.getValueAt(fila, 2).toString();
        //txtPK.setText(String.valueOf(codigo));
        controlador.cargarTutorAcad(txtTutorAcad, codigo);
        controlador.cargarTutorInd(txtTutorInd, codigo);
        controlador.cargarCedula(txtCedula,codigo);
        controlador.getComboSelected(cmbCarrera,codigo);
        controlador.cargarFecha_Final(txtFechaF, codigo);
        controlador.cargarFecha_Inicial(txtFechaI, codigo);
        
        
    }//GEN-LAST:event_TablaTesisMouseClicked

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtTutorIndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTutorIndActionPerformed
        
    }//GEN-LAST:event_txtTutorIndActionPerformed

    private void txtTutorAcadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTutorAcadActionPerformed
        
    }//GEN-LAST:event_txtTutorAcadActionPerformed

    private void LimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiarMouseClicked
        limpiarCajas();
    }//GEN-LAST:event_LimpiarMouseClicked

    private void txtFechaIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIActionPerformed

    private void txtFechaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFActionPerformed
    
    public void limpiarCajas(){
        txtAnio.setText("yyyy-mm-dd");
        txtAnio.setEnabled(true);
        txtCedula.setText(null);
        txtCedula.setEnabled(true);
        txtPK.setText(null);
        cmbCarrera.setSelectedItem(0);
        txtTutorAcad.setText(null);
        txtTutorInd.setText(null);
        txtFechaI.setText(null);
        txtFechaF.setText(null);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Aprobada;
    private javax.swing.JLabel Cargar;
    private javax.swing.JRadioButton Defendida;
    private javax.swing.JRadioButton EnDesarrollo;
    private javax.swing.JLabel Limpiar;
    private javax.swing.JRadioButton PorCarrera;
    private javax.swing.JRadioButton PorCedula;
    private javax.swing.JRadioButton PorDefender;
    private javax.swing.JRadioButton PorPeriodo;
    private javax.swing.JRadioButton PorStatus;
    private javax.swing.JRadioButton Reprobada;
    private javax.swing.JRadioButton SemestreI;
    private javax.swing.JRadioButton SemestreII;
    private javax.swing.JTable TablaTesis;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cmbCarrera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtFechaF;
    private javax.swing.JTextField txtFechaI;
    private javax.swing.JTextField txtPK;
    private javax.swing.JTextField txtTutorAcad;
    private javax.swing.JTextField txtTutorInd;
    // End of variables declaration//GEN-END:variables
}
