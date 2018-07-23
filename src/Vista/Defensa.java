package Vista;

import Conexion.Conexion;
import Logica.ControladorCalificaciones;
import Modelo.M_Defensa;
import Modelo.M_Tesis;
import Logica.ControladorDefensa;
import Logica.ControladorTesis;
import Logica.ManejadorFecha;
import Modelo.M_Calificaciones;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Time;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Defensa extends javax.swing.JPanel {

    M_Defensa defensa;
    ControladorDefensa controlador;
    M_Tesis tesis;
    ControladorTesis controladortesis;
    ControladorCalificaciones controladornotas;
    ManejadorFecha manejador;
    
    public Defensa() {
        initComponents();        
        controlador = new ControladorDefensa();
        defensa = new M_Defensa();
        Eliminar.setEnabled(false);
        txtPKTesis.setVisible(true);
        txtPKDefensa.setVisible(false);
        Modificar.setEnabled(false);
        controlador.cargarTesis(cmbTesis, false);
        controlador.cargarProfesores(cmbJurado1, cmbJurado2);
        txtPKTutorA.setVisible(false);
        controladortesis = new ControladorTesis();
        controladornotas = new ControladorCalificaciones();
        manejador = new ManejadorFecha();
    }
  
    public void limpiarCajas(){
        Guardar.setEnabled(true);
        Eliminar.setEnabled(false);
        Modificar.setEnabled(false);
        controlador.cargarTesis(cmbTesis, false);
        cmbTesis.setSelectedItem(0);
        txtPKTesis.setText(null);
        txtPKDefensa.setText(null);
        txtFechaDefensa.setText(null);
        txtFechaFin.setText(null);
        txtHora.setText(null);
        txtAula.setText(null);
        cmbTesis.setEnabled(true);
    }
    
    public String getPeriodo(Date Fecha){
        String formato="yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        String anio = (dateFormat.format(Fecha));
        if (SemestreI.isSelected())
            anio = anio + "-I";
        else
            anio = anio+"-II";
        return anio;
    }
    
    private void setComboSelected(int codigoPK, JComboBox combito){
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
    
    private int getComboSelected(JComboBox combito){
        String codigo = combito.getSelectedItem().toString(); 
        String codigoFinal = "";
        
        int guion = codigo.indexOf("-");
        codigoFinal = codigo.substring(0, guion);
        return Integer.parseInt(codigoFinal);
    }
    
    private int getSemestrePeriodo(String periodo){
        String cadena = periodo; 
        String cadenaFinal = "";
        int largo = periodo.length();
        int guion = cadena.indexOf("-");
        cadenaFinal = cadena.substring(guion+1, largo);
        return cadenaFinal.length();
        
    }
    
    private boolean camposVacios(){
        if(txtAula.getText().isEmpty() || txtHora.getText().isEmpty() || txtFechaDefensa.getText().isEmpty() &&
                (!SemestreI.isSelected() || !SemestreII.isSelected()))
            return true;
        return false;
    }
    
    private boolean juradosIguales(JComboBox c1, JComboBox c2){
       int a = getComboSelected(c1);
       int b = getComboSelected(c2);
       if(a == b)
           return true;
       return false;
    }

    private boolean juradosIgualesTutor(){
        
        String pk_ta = txtPKTutorA.getText();
        String ak = Integer.toString(getComboSelected(cmbJurado1));
        String bk = Integer.toString(getComboSelected(cmbJurado2));

        if(pk_ta.equals(ak) || pk_ta.equals(bk))
            return true;
        return false;
    }
    
    private void obtenerStatus(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            int fila = TablaDefensa.getSelectedRow();
            int codigo = (int)TablaDefensa.getValueAt(fila, 0);
            ps = (PreparedStatement) con.prepareStatement("SELECT status FROM tesis WHERE idtesis=?");
            
            ps.setInt(1, codigo);          
            rs = ps.executeQuery();                            
            
            while(rs.next()){
                txtStatus.setText(rs.getString("status"));
            }
            
            con.close();
            conn.CerrarConexion();
            ps.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ListadoTesis = new javax.swing.JLabel();
        Añadir = new javax.swing.JLabel();
        Eliminar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaDefensa = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        fechaDefensa = new javax.swing.JLabel();
        jurado2 = new javax.swing.JLabel();
        jurado1 = new javax.swing.JLabel();
        cmbJurado2 = new javax.swing.JComboBox<>();
        cmbJurado1 = new javax.swing.JComboBox<>();
        txtFechaDefensa = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        PorDefender = new javax.swing.JRadioButton();
        Defendida = new javax.swing.JRadioButton();
        txtPKTesis = new javax.swing.JTextField();
        txtPKDefensa = new javax.swing.JTextField();
        cmbTesis = new javax.swing.JComboBox<>();
        Todas = new javax.swing.JRadioButton();
        Guardar = new javax.swing.JLabel();
        fechaDefensa1 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        fechaDefensa2 = new javax.swing.JLabel();
        txtAula = new javax.swing.JTextField();
        SemestreI = new javax.swing.JRadioButton();
        SemestreII = new javax.swing.JRadioButton();
        Modificar = new javax.swing.JLabel();
        Limpiar = new javax.swing.JLabel();
        txtPKTutorA = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(884, 497));

        jPanel2.setBackground(new java.awt.Color(0, 87, 231));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/doc64.png"))); // NOI18N
        jLabel1.setText("Defensa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        ListadoTesis.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ListadoTesis.setForeground(new java.awt.Color(34, 49, 63));
        ListadoTesis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/icons8-libros-50.png"))); // NOI18N
        ListadoTesis.setText("Listado de Tesis");
        ListadoTesis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoTesisMouseClicked(evt);
            }
        });

        Añadir.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/añadir_libro.png"))); // NOI18N
        Añadir.setText("Añadir");

        Eliminar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/eliminar_libro.png"))); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarMouseClicked(evt);
            }
        });

        TablaDefensa.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TablaDefensa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TablaDefensa.setGridColor(new java.awt.Color(255, 0, 0));
        TablaDefensa.setSelectionBackground(new java.awt.Color(25, 181, 254));
        TablaDefensa.setShowHorizontalLines(false);
        TablaDefensa.setShowVerticalLines(false);
        TablaDefensa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaDefensaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaDefensa);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(ListadoTesis)
                        .addGap(18, 18, 18)
                        .addComponent(Añadir)
                        .addGap(33, 33, 33)
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(Añadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListadoTesis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        fechaDefensa.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        fechaDefensa.setText("Fecha de Defensa");

        jurado2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jurado2.setText("Jurado 2");

        jurado1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        jurado1.setText("Jurado 1");

        cmbJurado2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbJurado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Titulo.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/etiqueta.png"))); // NOI18N
        Titulo.setText("Tesis");

        PorDefender.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(PorDefender);
        PorDefender.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PorDefender.setText("Por defender");
        PorDefender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PorDefenderActionPerformed(evt);
            }
        });

        Defendida.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Defendida);
        Defendida.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Defendida.setText("Defendida");

        cmbTesis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Todas.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(Todas);
        Todas.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Todas.setText("Todas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Titulo)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTesis, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtPKTesis, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPKDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PorDefender)
                        .addGap(38, 38, 38)
                        .addComponent(Defendida)
                        .addGap(18, 18, 18)
                        .addComponent(Todas)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cmbTesis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Titulo)
                        .addComponent(txtPKTesis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPKDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PorDefender)
                    .addComponent(Defendida)
                    .addComponent(Todas)))
        );

        Guardar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/guardar.png"))); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                GuardarMousePressed(evt);
            }
        });

        fechaDefensa1.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        fechaDefensa1.setText("Hora");

        fechaDefensa2.setFont(new java.awt.Font("Century Gothic", 0, 13)); // NOI18N
        fechaDefensa2.setText("Aula");

        SemestreI.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(SemestreI);
        SemestreI.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        SemestreI.setSelected(true);
        SemestreI.setText("Semestre I");

        SemestreII.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(SemestreII);
        SemestreII.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        SemestreII.setText("Semestre II");

        Modificar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar.png"))); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModificarMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(fechaDefensa1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Guardar)
                                    .addComponent(fechaDefensa2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(Modificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Limpiar))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jurado1)
                                    .addComponent(jurado2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbJurado2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txtFechaDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(SemestreI)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(cmbJurado1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPKTutorA, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(SemestreII))
                                            .addComponent(txtAula, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtFechaFin)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jurado1)
                        .addComponent(cmbJurado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtPKTutorA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jurado2)
                    .addComponent(cmbJurado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechaDefensa)
                    .addComponent(txtFechaDefensa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SemestreI)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fechaDefensa1)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SemestreII))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fechaDefensa2)
                            .addComponent(txtAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMousePressed
        if(juradosIguales(cmbJurado1,cmbJurado2)){
            JOptionPane.showMessageDialog(null, "Jurado 1 debe ser distinto a Jurado 2");
        }
        else if(juradosIgualesTutor()){
            JOptionPane.showMessageDialog(null, "Codigo Tutor Académico: "+txtPKTutorA.getText()+". El Tutor Académico"
                    + " no puede ser Jurado");
        }
        else if(camposVacios()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos para guardar");
        }
        else if(!FechaDefensaMayorFechaFin()){
            JOptionPane.showMessageDialog(null, "La fecha de la defensa debe ser posterior a la fecha final de la tesis, es decir, luego de: "+txtFechaFin.getText());
        }
        else{
            String status = "Por Defender";
           /* if(PorDefender.isSelected()) status = "Por defender";
            else if(Aprobada.isSelected()) status = "Aprobada";
            else if(Reprobada.isSelected()) status = "Reprobada";
            else if(Defendida.isSelected()) status = "Defendida"; */
            
            int pk = controlador.getComboSelected(cmbTesis);
            defensa.actualizar(Date.valueOf(txtFechaDefensa.getText()), Time.valueOf(txtHora.getText()), 
                    Integer.parseInt(txtAula.getText()), 
                    controlador.getPeriodo(Date.valueOf(txtFechaDefensa.getText()), SemestreI), 
                    controlador.getComboSelected(cmbTesis), controlador.getComboSelected(cmbJurado1),
                    controlador.getComboSelected(cmbJurado2));
            controlador.ingresar(defensa);
            
           /* // Si el status seleccionado es Por defender o Defendida
            if(status.equals("Por defender") || status.equals("Defendida")){
                controladortesis.modificarStatus(pk, status); // cambia el status de la tesis
                limpiarCajas();
            }
            else
                JOptionPane.showMessageDialog(null, "No puede calificar de aprobada o "
                                    + "reprobada a una tesis sin asociar primero notas");*/
        }
    }//GEN-LAST:event_GuardarMousePressed
    
    private void PorDefenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PorDefenderActionPerformed
        
    }//GEN-LAST:event_PorDefenderActionPerformed

    private void ListadoTesisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoTesisMouseClicked
        String sql = "SELECT iddefensa, id_tesis, fecha, hora, aula, periodo, status "
                + "FROM defensa INNER JOIN tesis ON tesis.idtesis = defensa.id_tesis";
        if (PorDefender.isSelected())
            sql = sql + " WHERE status='Por defender'";
        else if (Defendida.isSelected())
            sql = sql + " WHERE status='Defendida'";

        try{
            DefaultTableModel modelo = new DefaultTableModel();
            TablaDefensa.setModel(modelo);

            PreparedStatement ps = null;
            ResultSet rs = null;

            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            
            modelo.addColumn("Código");
            modelo.addColumn("Tesis");
            modelo.addColumn("Fecha");
            modelo.addColumn("Hora");
            modelo.addColumn("Aula");
            modelo.addColumn("Periodo");
            modelo.addColumn("Status");

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
            JOptionPane.showMessageDialog(null, "Ocurrió un error: "+ex);
        }
    }//GEN-LAST:event_ListadoTesisMouseClicked

    private void TablaDefensaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaDefensaMouseClicked
        cmbTesis.setEnabled(false);
        Guardar.setEnabled(false);
        Modificar.setEnabled(true);        
        controlador.cargarTesis(cmbTesis, true);
        Eliminar.setEnabled(false);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            
            int fila = TablaDefensa.getSelectedRow();
            int codigo = (int)TablaDefensa.getValueAt(fila, 0);
            ps = (PreparedStatement) con.prepareStatement("SELECT id_tesis, iddefensa, fecha, hora, aula, "
                                                + "id_jurado1, id_jurado2, periodo, id_tutorAcademico, fecha_fin FROM "
                                                + "defensa INNER JOIN tesis ON defensa.id_tesis = tesis.idtesis "
                                                + "WHERE iddefensa=?");
            
            ps.setInt(1, codigo);          
            rs = ps.executeQuery();                            
            
            while(rs.next()){
                txtPKTesis.setText(rs.getString("id_tesis"));
                txtPKDefensa.setText(rs.getString("iddefensa"));
                txtFechaDefensa.setText(rs.getString("fecha"));
                txtHora.setText(rs.getString("hora"));
                txtAula.setText(rs.getString("aula"));
                setComboSelected(rs.getInt("id_jurado1"), cmbJurado1);
                setComboSelected(rs.getInt("id_jurado2"), cmbJurado2);
                setComboSelected(rs.getInt("id_tesis"), cmbTesis);
                txtPKTutorA.setText(rs.getString("id_tutorAcademico"));
                //txtStatus.setText(rs.getString("status"));
                txtFechaFin.setText(rs.getString("fecha_fin"));
                if (getSemestrePeriodo(rs.getString("periodo"))==1)
                    SemestreI.setSelected(true);
                else 
                    SemestreII.setSelected(true);
            }
            
            //obtenerStatus();
            
            con.close();
            conn.CerrarConexion();
            ps.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_TablaDefensaMouseClicked

    private void ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseClicked
        if(txtPKDefensa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Error en la modificación, no hay defensa seleccionada");
        }
        else if(juradosIguales(cmbJurado1,cmbJurado2)){
            JOptionPane.showMessageDialog(null, "Jurado 1 debe ser distinto a Jurado 2");
        }
        else if(juradosIgualesTutor()){
            JOptionPane.showMessageDialog(null, "Codigo Tutor Académico: "+txtPKTutorA.getText()+". El Tutor Académico"
                    + " no puede ser Jurado");
        }
        else if(!FechaDefensaMayorFechaFin()){
            JOptionPane.showMessageDialog(null, "La fecha de la defensa debe ser posterior a la fecha final de la tesis, es decir, luego de: "+txtFechaFin.getText());
        }
        else {
            String status="Por defender";
//            if(PorDefender.isSelected()) status = "Por defender";
//            if(Aprobada.isSelected()) status = "Aprobada";
//            if(Reprobada.isSelected()) status = "Reprobada";
//            if(Defendida.isSelected()) status = "Defendida";
//            if(Todas.isSelected()) status = s;
            
            int pk = Integer.parseInt(txtPKDefensa.getText());
            
            defensa.actualizar(Date.valueOf(txtFechaDefensa.getText()), Time.valueOf(txtHora.getText()), 
                Integer.parseInt(txtAula.getText()), controlador.getPeriodo(Date.valueOf(txtFechaDefensa.getText()), SemestreI), 
                controlador.getComboSelected(cmbTesis), controlador.getComboSelected(cmbJurado1),
                controlador.getComboSelected(cmbJurado2));
            
            controlador.modificar(defensa, txtPKDefensa.getText());
            
            //si NO selecciona el status de aprobada o reprobada Y el status que tiene es diferente a Aprobada o Reprobada
//            else if(!(s.equals("Aprobada") || s.equals("Reprobada")) && !(status.equals("Aprobada") || status.equals("Reprobada"))){
//                defensa.actualizar(Date.valueOf(txtFechaDefensa.getText()), Time.valueOf(txtHora.getText()), 
//                Integer.parseInt(txtAula.getText()), getPeriodo(Date.valueOf(txtFechaDefensa.getText())), 
//                getComboSelected(cmbTesis), getComboSelected(cmbJurado1),getComboSelected(cmbJurado2));
//                controlador.modificar(defensa, txtPKDefensa.getText());
//                controladortesis.modificarStatus(pk, status); // cambia el status de la tesis
                limpiarCajas();
            }
//        }           
    }//GEN-LAST:event_ModificarMouseClicked
    
    private boolean FechaDefensaMayorFechaFin(){
        if(txtVacio(txtFechaDefensa) || txtVacio(txtFechaFin))
            JOptionPane.showMessageDialog(null, "NO pueden haber campos vacíos");
        else{
            JOptionPane.showMessageDialog(null, "toy aqui");
            return manejador.fechasCorrectas(txtFechaFin.getText(), txtFechaDefensa.getText());
        }
        return false;
    }

    private void LimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiarMouseClicked
        limpiarCajas();
    }//GEN-LAST:event_LimpiarMouseClicked

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        if(txtPKDefensa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione una defensa a eliminar");
        } else {
            controlador.eliminar(txtPKDefensa.getText(),txtPKTesis.getText());
        }
        limpiarCajas();
    }//GEN-LAST:event_EliminarMouseClicked
   
    public boolean txtVacio(JTextField txt){
        if(txt.getText().isEmpty())
            return true;
        return false;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Añadir;
    private javax.swing.JRadioButton Defendida;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel Guardar;
    private javax.swing.JLabel Limpiar;
    private javax.swing.JLabel ListadoTesis;
    private javax.swing.JLabel Modificar;
    private javax.swing.JRadioButton PorDefender;
    private javax.swing.JRadioButton SemestreI;
    private javax.swing.JRadioButton SemestreII;
    private javax.swing.JTable TablaDefensa;
    private javax.swing.JLabel Titulo;
    private javax.swing.JRadioButton Todas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cmbJurado1;
    private javax.swing.JComboBox<String> cmbJurado2;
    private javax.swing.JComboBox<String> cmbTesis;
    private javax.swing.JLabel fechaDefensa;
    private javax.swing.JLabel fechaDefensa1;
    private javax.swing.JLabel fechaDefensa2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jurado1;
    private javax.swing.JLabel jurado2;
    private javax.swing.JTextField txtAula;
    private javax.swing.JTextField txtFechaDefensa;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtPKDefensa;
    private javax.swing.JTextField txtPKTesis;
    private javax.swing.JTextField txtPKTutorA;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
