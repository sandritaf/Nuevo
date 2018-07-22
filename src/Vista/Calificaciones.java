package Vista;

import Conexion.Conexion;
import Logica.ControladorCalificaciones;
import Modelo.M_Calificaciones;
import Modelo.M_Defensa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Calificaciones extends javax.swing.JPanel {
    
    M_Calificaciones calificaciones;
    ControladorCalificaciones controlador;
    
    
    public Calificaciones() {
        initComponents();
        controlador = new ControladorCalificaciones();
        calificaciones = new M_Calificaciones();
        txtPKEstudiante.setVisible(false);
        txtPKCalificaciones.setVisible(false);
        Guardar.setEnabled(false);
        Modificar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Guardar = new javax.swing.JLabel();
        Modificar = new javax.swing.JLabel();
        Modificar1 = new javax.swing.JLabel();
        NotaTutorIndustrial = new javax.swing.JLabel();
        NotaTutorAcademico = new javax.swing.JLabel();
        NotaJurado1 = new javax.swing.JLabel();
        NotaJurado2 = new javax.swing.JLabel();
        CalificacionFinal = new javax.swing.JLabel();
        cmbNotaIndustrial = new javax.swing.JComboBox<>();
        cmbNotaAcademico = new javax.swing.JComboBox<>();
        cmbNotaJurado1 = new javax.swing.JComboBox<>();
        cmbNotaJurado2 = new javax.swing.JComboBox<>();
        txtNotaFinal = new javax.swing.JTextField();
        CalcularNotaFinal = new javax.swing.JLabel();
        txtPKEstudiante = new javax.swing.JTextField();
        txtPKCalificaciones = new javax.swing.JTextField();
        txtPKTutorI = new javax.swing.JTextField();
        txtPKTutorA = new javax.swing.JTextField();
        txtPKJurado1 = new javax.swing.JTextField();
        txtPKJurado2 = new javax.swing.JTextField();
        txtPKTesis = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTesis = new javax.swing.JTable();
        Lista = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/calificaciones64.png"))); // NOI18N
        jLabel3.setText("Calificaciones");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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

        Modificar1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Modificar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eliminar50.png"))); // NOI18N
        Modificar1.setText("Eliminar");

        NotaTutorIndustrial.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        NotaTutorIndustrial.setText("Calificación Tutor Industrial");

        NotaTutorAcademico.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        NotaTutorAcademico.setText("Calificación Tutor Académico");

        NotaJurado1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        NotaJurado1.setText("Calificación Jurado 1");

        NotaJurado2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        NotaJurado2.setText("Calificación Jurado 2");

        CalificacionFinal.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CalificacionFinal.setText("Calificación Final");

        cmbNotaIndustrial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmbNotaAcademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmbNotaJurado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmbNotaJurado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        txtNotaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaFinalActionPerformed(evt);
            }
        });

        CalcularNotaFinal.setBackground(new java.awt.Color(204, 204, 204));
        CalcularNotaFinal.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CalcularNotaFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/calculadora50.png"))); // NOI18N
        CalcularNotaFinal.setText("Calcular Nota Final");
        CalcularNotaFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CalcularNotaFinalMouseClicked(evt);
            }
        });

        txtPKJurado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPKJurado1ActionPerformed(evt);
            }
        });

        txtPKTesis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPKTesisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(CalcularNotaFinal)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Modificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NotaTutorIndustrial)
                            .addComponent(NotaTutorAcademico)
                            .addComponent(NotaJurado1)
                            .addComponent(NotaJurado2)
                            .addComponent(CalificacionFinal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPKCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNotaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPKEstudiante, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbNotaAcademico, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNotaJurado1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNotaJurado2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbNotaIndustrial, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPKJurado2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPKTutorA)
                            .addComponent(txtPKJurado1)
                            .addComponent(txtPKTutorI)
                            .addComponent(txtPKTesis, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Modificar)
                    .addComponent(Modificar1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NotaTutorIndustrial)
                    .addComponent(cmbNotaIndustrial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKTutorI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NotaTutorAcademico)
                    .addComponent(cmbNotaAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKTutorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NotaJurado1)
                    .addComponent(cmbNotaJurado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKJurado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NotaJurado2)
                    .addComponent(cmbNotaJurado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKJurado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPKEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKTesis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CalcularNotaFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CalificacionFinal)
                    .addComponent(txtNotaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        TablaTesis.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TablaTesis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaTesis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTesisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTesis);

        Lista.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Lista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/defensa.png"))); // NOI18N
        Lista.setText("Listado de Tesis Defendidas");
        Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(Lista)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        int n_industrial = Integer.parseInt(valorCombito(cmbNotaIndustrial));
        int n_academico = Integer.parseInt(valorCombito(cmbNotaAcademico));
        int n_jurado1 = Integer.parseInt(valorCombito(cmbNotaJurado1));
        int n_jurado2 = Integer.parseInt(valorCombito(cmbNotaJurado2));
        int n_final = Integer.parseInt(txtNotaFinal.getText());
        int pk = Integer.parseInt(txtPKTesis.getText());
        int n_defensa = (n_jurado1 + n_jurado2) / 2;
        calificaciones = new M_Calificaciones(pk, n_industrial, n_academico, n_jurado1, n_jurado2, n_defensa, n_final);
        controlador.ingresar(calificaciones, pk);
    }//GEN-LAST:event_GuardarMouseClicked

    private void txtNotaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaFinalActionPerformed
        
    }//GEN-LAST:event_txtNotaFinalActionPerformed

    private void CalcularNotaFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcularNotaFinalMouseClicked
        
        String opc = "Seleccione";
        
        if(valorCombito(cmbNotaIndustrial).equals(opc) || valorCombito(cmbNotaAcademico).equals(opc) 
                || valorCombito(cmbNotaJurado1).equals(opc) || valorCombito(cmbNotaJurado2).equals(opc)){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una nota válida: Por favor intente de nuevo");
        }
        else{
            
            int n_industrial = Integer.parseInt(valorCombito(cmbNotaIndustrial));
            int n_academico = Integer.parseInt(valorCombito(cmbNotaAcademico));
            int n_jurado1 = Integer.parseInt(valorCombito(cmbNotaJurado1));
            int n_jurado2 = Integer.parseInt(valorCombito(cmbNotaJurado2));

            int promediojurado = calificaciones.getPromedio(n_jurado1, n_jurado2);
            int nota_final = calificaciones.getNotaFinal(n_industrial, n_academico,promediojurado);

            String notaf = Integer.toString(nota_final);

            txtNotaFinal.setText(notaf);
        }
        //calificaciones.calculo_nfinal()
    }//GEN-LAST:event_CalcularNotaFinalMouseClicked

    private void TablaTesisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTesisMouseClicked
        //getValorPKTesis();
        Guardar.setEnabled(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            int fila = TablaTesis.getSelectedRow();
            int codigo = (int)TablaTesis.getValueAt(fila, 0);
            ps = (PreparedStatement) con.prepareStatement("SELECT id_tesis, id_tutorAcademico, id_tutorIndustrial, id_jurado1, id_jurado2 FROM "
                                                + "tesis INNER JOIN defensa ON defensa.id_tesis = tesis.idtesis "
                                                + "INNER JOIN tutor_industrial ON tesis.id_tutorIndustrial = tutor_industrial.idtindustrial "
                                                + "WHERE idtesis=?");
            
            ps.setInt(1, codigo);          
            rs = ps.executeQuery();                            
            
            while(rs.next()){
                txtPKTesis.setText(rs.getString("id_tesis"));
                txtPKTutorA.setText(rs.getString(("id_tutorAcademico")));
                txtPKTutorI.setText(rs.getString(("id_tutorIndustrial")));
                txtPKJurado1.setText(rs.getString(("id_jurado1")));
                txtPKJurado2.setText(rs.getString(("id_jurado2")));
//                txtPKDefensa.setText(rs.getString("iddefensa"));
//                txtFecha.setText(rs.getString("fecha"));
//                txtHora.setText(rs.getString("hora"));
//                txtAula.setText(rs.getString("aula"));
//                setComboSelected(rs.getInt("id_jurado1"), cmbJurado1);
//                setComboSelected(rs.getInt("id_jurado2"), cmbJurado2);
//                setComboSelected(rs.getInt("id_tesis"), cmbTesis);
//                txtPKTutorA.setText(rs.getString("id_tutorAcademico"));
//                if (getSemestrePeriodo(rs.getString("periodo"))==1)
//                    SemestreI.setSelected(true);
//                else 
//                    SemestreII.setSelected(true);
            }
            con.close();
            conn.CerrarConexion();
            ps.close();
            
        }catch(Exception e){
            System.out.println(e);
        }

        
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaTesisMouseClicked

    private void ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaMouseClicked
        
//        String sql_ta = "SELECT profesor.nombre, profesor.apellido, titulo, idtesis FROM tesis INNER JOIN "
//                        + "profesor ON profesor.idprofesor = tesis.id_tutorAcademico"; 
//        String sql_ti = "SELECT tutor_industrial.nombre, tutor_industrial.apellido, titulo, idtesis FROM tesis INNER JOIN "
//                        + "tutor_industrial ON tutor_industrial.idtindustrial = tesis.id_tutorIndustrial"; 
//        String sql_j1 = "SELECT profesor.nombre, profesor.apellido, titulo, idtesis FROM tesis INNER JOIN "
//                        + "defensa ON tesis.idtesis = defensa.id_tesis INNER JOIN "
//                        + "profesor ON profesor.idprofesor = defensa.id_jurado1";
//        String sql_j2 = "SELECT profesor.nombre, profesor.apellido, titulo, idtesis FROM tesis INNER JOIN "
//                        + "defensa ON tesis.idtesis = defensa.id_tesis INNER JOIN "
//                        + "profesor ON profesor.idprofesor = defensa.id_jurado2"; 
//        String sql_es = "SELECT estudiante.nombre, estudiante.apellido, titulo, idtesis FROM tesis INNER JOIN "
//                        + "estudiante ON estudiante.idestudiante = tesis.estudiante_tesis"; 
//        String where = "WHERE tesis.status='Por defender'";
//        System.out.println(sql1);

        String sql = "SELECT idtesis, titulo, status, id_tutorAcademico, id_tutorIndustrial,"
                   + " id_jurado1, id_jurado2 FROM tesis "
                   + "INNER JOIN defensa ON tesis.idtesis = defensa.id_tesis "
                   + "INNER JOIN tutor_industrial ON tesis.id_tutorIndustrial = idtindustrial "
                   + "INNER JOIN profesor ON tesis.id_tutorAcademico = profesor.idprofesor "
                   + "WHERE tesis.status = 'Defendida'";

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
            System.err.println(ex);
        }
    }//GEN-LAST:event_ListaMouseClicked

    private void txtPKJurado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPKJurado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPKJurado1ActionPerformed

    private void txtPKTesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPKTesisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPKTesisActionPerformed

    private String valorCombito(JComboBox cmb){
        String s = cmb.getSelectedItem().toString();
        return s;
    }
    
    private int getValorPKTesis(){
        int fila = TablaTesis.getSelectedRow();
        String nombre_tesis = TablaTesis.getValueAt(fila, 0).toString();
        
        System.out.println("este es el nombre de la tesis: "+nombre_tesis);
        return 0;
    }
    
    public boolean txtVacio(JTextField txt){
        if(txt.getText().isEmpty())
            return true;
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CalcularNotaFinal;
    private javax.swing.JLabel CalificacionFinal;
    private javax.swing.JLabel Guardar;
    private javax.swing.JLabel Lista;
    private javax.swing.JLabel Modificar;
    private javax.swing.JLabel Modificar1;
    private javax.swing.JLabel NotaJurado1;
    private javax.swing.JLabel NotaJurado2;
    private javax.swing.JLabel NotaTutorAcademico;
    private javax.swing.JLabel NotaTutorIndustrial;
    private javax.swing.JTable TablaTesis;
    private javax.swing.JComboBox<String> cmbNotaAcademico;
    private javax.swing.JComboBox<String> cmbNotaIndustrial;
    private javax.swing.JComboBox<String> cmbNotaJurado1;
    private javax.swing.JComboBox<String> cmbNotaJurado2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNotaFinal;
    private javax.swing.JTextField txtPKCalificaciones;
    private javax.swing.JTextField txtPKEstudiante;
    private javax.swing.JTextField txtPKJurado1;
    private javax.swing.JTextField txtPKJurado2;
    private javax.swing.JTextField txtPKTesis;
    private javax.swing.JTextField txtPKTutorA;
    private javax.swing.JTextField txtPKTutorI;
    // End of variables declaration//GEN-END:variables
}
