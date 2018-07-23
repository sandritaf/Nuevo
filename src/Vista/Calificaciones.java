package Vista;

import Conexion.Conexion;
import Logica.ControladorCalificaciones;
import Logica.ControladorTesis;
import Modelo.M_Calificaciones;
import Modelo.M_Tesis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Calificaciones extends javax.swing.JPanel {
    
    M_Calificaciones calificaciones;
    ControladorCalificaciones controlador;
    M_Tesis tesis;
    ControladorTesis controladortesis;
    int NotaFinal;
    String formato;
    
    public Calificaciones() {
        initComponents();
        controlador = new ControladorCalificaciones();
        controladortesis = new ControladorTesis();
        calificaciones = new M_Calificaciones();
        txtPKEstudiante.setVisible(false);
        //txtPKCalificaciones.setVisible(false);
        Guardar.setEnabled(false);
        Modificar.setEnabled(false);
        Eliminar.setEnabled(false);
        formato ="";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Guardar = new javax.swing.JLabel();
        Modificar = new javax.swing.JLabel();
        Eliminar = new javax.swing.JLabel();
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
        txtStatus = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTesis = new javax.swing.JTable();
        Lista = new javax.swing.JLabel();
        NoCalificadas = new javax.swing.JRadioButton();
        Calificadas = new javax.swing.JRadioButton();

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
        Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarMouseClicked(evt);
            }
        });

        Eliminar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eliminar50.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarMouseClicked(evt);
            }
        });

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

        cmbNotaIndustrial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmbNotaAcademico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmbNotaJurado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        cmbNotaJurado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

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
                .addGap(0, 3, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(CalcularNotaFinal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(CalificacionFinal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNotaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NotaTutorIndustrial)
                                    .addComponent(NotaTutorAcademico)
                                    .addComponent(NotaJurado1)
                                    .addComponent(NotaJurado2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbNotaJurado2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbNotaJurado1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbNotaAcademico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbNotaIndustrial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPKCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(txtPKEstudiante)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPKJurado2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(txtPKJurado1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPKTutorA, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPKTutorI, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPKTesis))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Modificar)
                    .addComponent(Eliminar))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(NotaTutorIndustrial)
                        .addGap(18, 18, 18)
                        .addComponent(NotaTutorAcademico)
                        .addGap(18, 18, 18)
                        .addComponent(NotaJurado1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NotaJurado2)
                            .addComponent(txtPKJurado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNotaIndustrial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPKTutorI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNotaAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPKTutorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbNotaJurado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPKJurado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cmbNotaJurado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPKEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKCalificaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPKTesis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CalcularNotaFinal)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        NoCalificadas.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(NoCalificadas);
        NoCalificadas.setText("No Calificadas");
        NoCalificadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoCalificadasActionPerformed(evt);
            }
        });

        Calificadas.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Calificadas);
        Calificadas.setText("Calificadas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Lista)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(NoCalificadas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Calificadas))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(Lista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoCalificadas)
                    .addComponent(Calificadas))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    //Devuelve true si alguno de los combos no tiene una calificacion seleccionada
    private boolean combosVacios(){
        String opc = "Seleccione";
        if(controlador.getComboSelected(cmbNotaIndustrial).equals(opc) || 
           controlador.getComboSelected(cmbNotaAcademico).equals(opc) ||
           controlador.getComboSelected(cmbNotaJurado1).equals(opc) || 
           controlador.getComboSelected(cmbNotaJurado2).equals(opc))
               return true;
        return false;
    }
    
    //Invoca al controlador para ingresar las calificaciones seleccionadas por el usuario
    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        //Verifica que haya una tesis seleccionada
        if(txtPKTesis.getText().isEmpty() || txtNotaFinal.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tesis y calcular su nota final.");
        }
        //Calcula todas las calificaciones y llama al controlador para ingresarlas
        else{
            int n_industrial = Integer.parseInt(controlador.getComboSelected(cmbNotaIndustrial));
            int n_academico = Integer.parseInt(controlador.getComboSelected(cmbNotaAcademico));
            int n_jurado1 = Integer.parseInt(controlador.getComboSelected(cmbNotaJurado1));
            int n_jurado2 = Integer.parseInt(controlador.getComboSelected(cmbNotaJurado2));
            int n_defensa = ((n_jurado1+n_jurado2)/2);
            int pk = Integer.parseInt(txtPKTesis.getText());
            int nota_final = Integer.parseInt(txtNotaFinal.getText());
            
            calificaciones = new M_Calificaciones(pk, n_industrial, n_academico, 
                         n_jurado1, n_jurado2, n_defensa, nota_final);
            controlador.ingresar(calificaciones, pk);

            limpiarCajas();
        }
    }//GEN-LAST:event_GuardarMouseClicked

    private void txtNotaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaFinalActionPerformed
        
    }//GEN-LAST:event_txtNotaFinalActionPerformed
    
    //Calcula la nota final y la guarda en una caja de texto
    private void CalcularNotaFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcularNotaFinalMouseClicked
        if(combosVacios()){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una nota válida. Por favor intente de nuevo");
        }
        else{
            int n_industrial = Integer.parseInt(controlador.getComboSelected(cmbNotaIndustrial)); 
            int n_academico = Integer.parseInt(controlador.getComboSelected(cmbNotaAcademico));
            int n_jurado1 = Integer.parseInt(controlador.getComboSelected(cmbNotaJurado1));
            int n_jurado2 = Integer.parseInt(controlador.getComboSelected(cmbNotaJurado2));
            int defensa = Math.round((n_jurado1+n_jurado2)/2);
            
            
            int nota_final = (int)controlador.calcularNotaFinal(n_industrial, n_academico,n_jurado1, n_jurado2);
            txtNotaFinal.setText(String.valueOf(nota_final));
        }
    }//GEN-LAST:event_CalcularNotaFinalMouseClicked
    
    private void cargarCalificaciones(String pkTesis){
        if(pkTesis.equals("")){
            JOptionPane.showMessageDialog(null, "No se recibio ninguna PK");
        } else{
            PreparedStatement ps = null;
            ResultSet rs = null;
            try{
                Conexion conn = new Conexion();
                Connection con = conn.getConection();
                String sql = "SELECT * FROM notas WHERE id_tesis=?";

                ps = (PreparedStatement) con.prepareStatement(sql);

                ps.setString(1, pkTesis);    //??      
                rs = ps.executeQuery();                            

                while(rs.next()){
                    txtPKCalificaciones.setText(rs.getString("idnotas"));
                    controlador.setComboSelected(rs.getInt("jurado1"), cmbNotaJurado1);
                    controlador.setComboSelected(rs.getInt("jurado2"), cmbNotaJurado2);
                    controlador.setComboSelected(rs.getInt("tutor_industrial"), cmbNotaIndustrial);
                    controlador.setComboSelected(rs.getInt("tutor_academico"), cmbNotaAcademico);
                    txtNotaFinal.setText(rs.getString(("final")));
                }

                con.close();
                conn.CerrarConexion();
                ps.close();

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "error en getPKCalificaciones: "+e);
            }
        }
    }
    
    private void TablaTesisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTesisMouseClicked
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            int fila = TablaTesis.getSelectedRow();
            int codigo = (int)TablaTesis.getValueAt(fila, 0);
            
            String sql = "SELECT idtesis, status, id_tutorAcademico, "
                    + "id_tutorIndustrial, id_jurado1, id_jurado2 FROM tesis "
                    + "INNER JOIN profesor ON tesis.id_tutorAcademico = profesor.idprofesor "
                    + "INNER JOIN defensa ON tesis.idtesis = defensa.id_tesis "
                    + "INNER JOIN tutor_industrial ON tesis.id_tutorIndustrial = tutor_industrial.idtindustrial "
                    + "WHERE idtesis=?";
            
            ps = (PreparedStatement) con.prepareStatement(sql);

            ps.setInt(1, codigo);          
            rs = ps.executeQuery(); // realizamos la consulta                            
            
            //Cargamos datos en el panel, para auxiliar 
            while(rs.next()){
                txtPKTesis.setText(rs.getString("idtesis"));
                txtStatus.setText(rs.getString("status"));
                txtPKTutorA.setText(rs.getString(("id_tutorAcademico")));
                txtPKTutorI.setText(rs.getString(("id_tutorIndustrial")));
                txtPKJurado1.setText(rs.getString(("id_jurado1")));
                txtPKJurado2.setText(rs.getString(("id_jurado2")));
            }
            
            if (!txtStatus.getText().equals("Defendida")){ // Si la tesis ya tiene notas asociadas
                Modificar.setEnabled(true); // se puede modificar
                Eliminar.setEnabled(true); // y se puede eliminar
                cargarCalificaciones(txtPKTesis.getText()); // entonces cargamos las notas en los combo box
            }
            else Guardar.setEnabled(true);
            
            con.close();
            conn.CerrarConexion();
            ps.close();
            rs.close();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrió un error al seleccionar la PK de la tesis: "+e);
        }
    }//GEN-LAST:event_TablaTesisMouseClicked
        
    //Llama al controlador para cargar la tabla con las tesis
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
        controlador.cargarTabla(TablaTesis, Calificadas, NoCalificadas);
        limpiarCajas();
    }//GEN-LAST:event_ListaMouseClicked

    private void txtPKJurado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPKJurado1ActionPerformed
      
    }//GEN-LAST:event_txtPKJurado1ActionPerformed

    private void txtPKTesisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPKTesisActionPerformed
        
    }//GEN-LAST:event_txtPKTesisActionPerformed

    private void NoCalificadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoCalificadasActionPerformed
        
    }//GEN-LAST:event_NoCalificadasActionPerformed

    //Llama al controlador para hacer modificaciones a las calificaciones asociadas a una tesis
    private void ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseClicked
        if(txtPKCalificaciones.getText().isEmpty()){ //Si no hay tesis seleccionada
            JOptionPane.showMessageDialog(null, "Seleccione una tesis");
        }
        else if(txtNotaFinal.getText().isEmpty()){ //si no se calculó la nota final
            JOptionPane.showMessageDialog(null, "Primero calcule la nota final");
        }
        else{ //Se calcula la calificación final y se llama al controlador para hacer la modificacion
            int n_industrial = Integer.parseInt(controlador.getComboSelected(cmbNotaIndustrial));
            int n_academico = Integer.parseInt(controlador.getComboSelected(cmbNotaAcademico));
            int n_jurado1 = Integer.parseInt(controlador.getComboSelected(cmbNotaJurado1));
            int n_jurado2 = Integer.parseInt(controlador.getComboSelected(cmbNotaJurado2));
            int n_defensa = ((n_jurado1 + n_jurado2)/2);
            
            int n_final = (int)controlador.calcularNotaFinal(n_industrial, n_academico,n_jurado1,n_jurado2);
            
            int pk_tesis = Integer.parseInt(txtPKTesis.getText());
            int pk_notas = Integer.parseInt(txtPKCalificaciones.getText());

            calificaciones.actualizar(pk_notas,n_industrial, n_academico, n_jurado1, n_jurado2, n_defensa, n_final);
            controlador.modificar(calificaciones, pk_notas, pk_tesis);
            limpiarCajas();
        }
    }//GEN-LAST:event_ModificarMouseClicked

    //Llama a controlador para que elimine la tesis seleccionada
    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        if(txtPKCalificaciones.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione una tesis");
        }
        else if(txtStatus.getText().equals("Defendida")){
            JOptionPane.showMessageDialog(null, "Error al eliminar. Tesis sin notas");
        }
        else{
            controlador.eliminar(txtPKCalificaciones.getText(),txtPKTesis.getText());
          //  controladortesis.modificarStatus(Integer.parseInt(txtPKTesis.getText()), "Defendida");
            limpiarCajas();
        }
    }//GEN-LAST:event_EliminarMouseClicked
    
    //Limpia las cajas de texto
    private void limpiarCajas(){
        txtNotaFinal.setText(null);
        txtPKCalificaciones.setText(null);
        txtPKEstudiante.setText(null);
        txtPKJurado1.setText(null);
        txtPKJurado2.setText(null);
        txtPKTesis.setText(null);
        txtPKTutorA.setText(null);
        txtPKTutorI.setText(null);
        txtStatus.setText(null);
        controlador.setComboSelected(1, cmbNotaJurado1);
        controlador.setComboSelected(1, cmbNotaJurado2);
        controlador.setComboSelected(1, cmbNotaIndustrial);
        controlador.setComboSelected(1, cmbNotaAcademico);
        Modificar.setEnabled(false);
        Eliminar.setEnabled(false);
        Guardar.setEnabled(false);
    }
    
    //Devuelve verdadero si una caja de texto esta vacia
    public boolean txtVacio(JTextField txt){
        if(txt.getText().isEmpty())
            return true;
        return false;
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CalcularNotaFinal;
    private javax.swing.JLabel CalificacionFinal;
    private javax.swing.JRadioButton Calificadas;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel Guardar;
    private javax.swing.JLabel Lista;
    private javax.swing.JLabel Modificar;
    private javax.swing.JRadioButton NoCalificadas;
    private javax.swing.JLabel NotaJurado1;
    private javax.swing.JLabel NotaJurado2;
    private javax.swing.JLabel NotaTutorAcademico;
    private javax.swing.JLabel NotaTutorIndustrial;
    private javax.swing.JTable TablaTesis;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
