package Vista;

import Conexion.Conexion;
import Logica.ControladorCarrera;
import Modelo.M_Carrera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Carrera extends javax.swing.JPanel {

    M_Carrera carrera;
    ControladorCarrera controlador;
    
    public Carrera() {
        initComponents();
        txtPK.setVisible(false);
        controlador = new ControladorCarrera();
        carrera = new M_Carrera();
        Modificar.setEnabled(false);
        Eliminar.setEnabled(false);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        Carrera = new javax.swing.JLabel();
        panelderecho = new javax.swing.JPanel();
        Guardar = new javax.swing.JLabel();
        Modificar = new javax.swing.JLabel();
        Eliminar = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        UCTotales = new javax.swing.JLabel();
        Semestres = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUCTotales = new javax.swing.JTextField();
        txtSemestres = new javax.swing.JTextField();
        txtPK = new javax.swing.JTextField();
        Limpiar = new javax.swing.JLabel();
        panelizquierdo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaCarreras = new javax.swing.JTable();
        ListaCarreras = new javax.swing.JLabel();

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));

        panelTitulo.setBackground(new java.awt.Color(0, 204, 204));

        Carrera.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Carrera.setForeground(new java.awt.Color(255, 255, 255));
        Carrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Carrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/carrera64.png"))); // NOI18N
        Carrera.setText("Carrera");

        javax.swing.GroupLayout panelTituloLayout = new javax.swing.GroupLayout(panelTitulo);
        panelTitulo.setLayout(panelTituloLayout);
        panelTituloLayout.setHorizontalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTituloLayout.createSequentialGroup()
                .addContainerGap(343, Short.MAX_VALUE)
                .addComponent(Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        panelTituloLayout.setVerticalGroup(
            panelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Carrera, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        panelderecho.setBackground(new java.awt.Color(255, 255, 255));

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

        Nombre.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Nombre.setText("Nombre");

        UCTotales.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UCTotales.setText("UC Totales");

        Semestres.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Semestres.setText("Cantidad de Semestres");

        Limpiar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/escoba.png"))); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelderechoLayout = new javax.swing.GroupLayout(panelderecho);
        panelderecho.setLayout(panelderechoLayout);
        panelderechoLayout.setHorizontalGroup(
            panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelderechoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelderechoLayout.createSequentialGroup()
                        .addComponent(Guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelderechoLayout.createSequentialGroup()
                        .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre)
                            .addComponent(UCTotales)
                            .addComponent(Semestres))
                        .addGap(27, 27, 27)
                        .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUCTotales)
                            .addComponent(txtNombre)
                            .addGroup(panelderechoLayout.createSequentialGroup()
                                .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSemestres, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelderechoLayout.createSequentialGroup()
                        .addComponent(Limpiar)
                        .addGap(105, 105, 105)))
                .addGap(14, 14, 14))
        );
        panelderechoLayout.setVerticalGroup(
            panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelderechoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Guardar)
                    .addComponent(Modificar)
                    .addComponent(Eliminar))
                .addGap(18, 18, 18)
                .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UCTotales)
                    .addComponent(txtUCTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelderechoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Semestres)
                    .addComponent(txtSemestres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        panelizquierdo.setBackground(new java.awt.Color(255, 255, 255));

        TablaCarreras.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TablaCarreras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Cant. Semestres", "UC Totales"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaCarreras.setSelectionBackground(new java.awt.Color(3, 201, 169));
        TablaCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCarrerasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaCarreras);

        ListaCarreras.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ListaCarreras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cursos_50color.png"))); // NOI18N
        ListaCarreras.setText("Listado de Carreras Ofertadas");
        ListaCarreras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListaCarrerasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelizquierdoLayout = new javax.swing.GroupLayout(panelizquierdo);
        panelizquierdo.setLayout(panelizquierdoLayout);
        panelizquierdoLayout.setHorizontalGroup(
            panelizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelizquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(panelizquierdoLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(ListaCarreras)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelizquierdoLayout.setVerticalGroup(
            panelizquierdoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelizquierdoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListaCarreras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelderecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelizquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addComponent(panelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelderecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    //Limpia las cajas de texto
    public void limpiarCajas(){
        txtNombre.setText(null);
        txtSemestres.setText(null);
        txtUCTotales.setText(null);
        txtPK.setText(null);
        Guardar.setEnabled(true);
        Modificar.setEnabled(false);
        Eliminar.setEnabled(false);
    }
    
    //Verifica que no exista una carrera con el mismo nombre en la BDD
    public boolean idExiste(String nombre){
        return controlador.carreraExiste(nombre);
    }
    
    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
         //No permite añadir carreras cuyo nombre ya existe en la base de datos ni con campos vacios
        if(idExiste(txtNombre.getText())){
            JOptionPane.showMessageDialog(null, "Ya existe una carrera con ese nombre");
        } else {
            /*Actualiza los valores del objeto tipo carrera con los ingresados por el usuario
            y los los ingresa como un registro nuevo en la base de datos*/
            carrera.actualizar(txtSemestres.getText(), txtUCTotales.getText(), txtNombre.getText());
            controlador.ingresar(carrera);
        }
        limpiarCajas();
    }//GEN-LAST:event_GuardarMouseClicked

    private void LimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LimpiarMouseClicked
        limpiarCajas();
    }//GEN-LAST:event_LimpiarMouseClicked

    private void ModificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModificarMouseClicked
        //Verifica que no sea un nombre que ya existe en la base de datos
        if(idExiste(txtNombre.getText())){
            JOptionPane.showMessageDialog(null, "Ya existe una carrera con ese nombre");
        } else {
            carrera.actualizar(txtSemestres.getText(), txtUCTotales.getText(), txtNombre.getText());
            controlador.modificar(carrera, txtPK.getText());
        }
        limpiarCajas();
    }//GEN-LAST:event_ModificarMouseClicked

    private void ListaCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListaCarrerasMouseClicked
        /*Carga las carreras en la tabla */
        controlador.cargarCarreras(TablaCarreras);
    }//GEN-LAST:event_ListaCarrerasMouseClicked

    /*Carga valores en las cajas de texto de la carrera seleccionada de la tabla,
    permitiendo que este registro se pueda modificar
    */
    private void TablaCarrerasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCarrerasMouseClicked
        Guardar.setEnabled(false);
        Modificar.setEnabled(true);
        Eliminar.setEnabled(true);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Conexion conn = new Conexion();
            Connection con = conn.getConection();
            /*El valor de la primera columna de la tabla es el codigo PK de la carrera lo que permite
            ubicar la misma en la consulta*/
            int fila = TablaCarreras.getSelectedRow();
            int codigo = (int) TablaCarreras.getValueAt(fila, 0);
            //Consulta
            ps = (PreparedStatement) con.prepareStatement("SELECT id_carrera, nombre, semestres, uc_totales "
                                                        + "FROM carrera WHERE id_carrera=?");
            ps.setInt(1, codigo);          
            rs = ps.executeQuery();                            
            //Se cargan las cajas de texto
            while(rs.next()){
                txtPK.setText(rs.getString("id_carrera"));
                txtNombre.setText(rs.getString("nombre"));
                txtSemestres.setText(rs.getString("semestres"));
                txtUCTotales.setText(rs.getString("uc_totales"));
            }
            
            ps.close();
            rs.close();
            conn.CerrarConexion();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_TablaCarrerasMouseClicked

    private void EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarMouseClicked
        //Se asegura de que haya un registro seleccionado de la tabla
        if(txtPK.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Seleccione una carrera a eliminar");
        } else {
            controlador.eliminar(txtPK.getText());
        }
        limpiarCajas();
    }//GEN-LAST:event_EliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Carrera;
    private javax.swing.JLabel Eliminar;
    private javax.swing.JLabel Guardar;
    private javax.swing.JLabel Limpiar;
    private javax.swing.JLabel ListaCarreras;
    private javax.swing.JLabel Modificar;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Semestres;
    private javax.swing.JTable TablaCarreras;
    private javax.swing.JLabel UCTotales;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel panelderecho;
    private javax.swing.JPanel panelizquierdo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPK;
    private javax.swing.JTextField txtSemestres;
    private javax.swing.JTextField txtUCTotales;
    // End of variables declaration//GEN-END:variables
}
