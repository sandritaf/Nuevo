
package Vista;

import java.io.File;
import java.io.PrintStream;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReporteVentanaFea extends javax.swing.JPanel {

    String path;
    String pathFilesImport;
    String fileExtension;
    DefaultTableModel tableModelFiles;
    JScrollPane jScrollPaneFicheros;
    JTable jTableFicheros;
    
    public ReporteVentanaFea() {
        initComponents();
    }
    
    public ReporteVentanaFea(String path){
        // Components loading (Carga de componentes)
        initComponents();
        pathFilesImport = "C:\\Users\\brenda\\Desktop\\plugin";
        initJTable();
        // Load the files in the table (Cargamos los ficheros en la tabla).
        loadTableModelFiles(tableModelFiles,
        pathFilesImport, null,
        null, // extesionFile,
        pathFilesImport,
        System.out);
//        setLocationCenter();
        setVisible(true);
    }
    
    private void initJTable(){
        txtPath.setText(pathFilesImport);
        Object[] newObjectItems = initJTableFiles(jTableFicheros, jScrollPaneFicheros, tableModelFiles);
        tableModelFiles = (DefaultTableModel) newObjectItems[2];
        jTableFicheros = (JTable) newObjectItems[0];
        jScrollPaneFicheros = (JScrollPane) newObjectItems[1];
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        GenerarPDF1 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        Ruta = new javax.swing.JLabel();

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
                .addContainerGap(347, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(279, 279, 279))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
        );

        jTable.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        GenerarPDF1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        GenerarPDF1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pdf50.png"))); // NOI18N
        GenerarPDF1.setText("Generar PDF");
        GenerarPDF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenerarPDF1MouseClicked(evt);
            }
        });

        txtPath.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N

        Ruta.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Ruta.setText("Ruta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Ruta)
                        .addGap(35, 35, 35)
                        .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(GenerarPDF1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenerarPDF1)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ruta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
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
    
    public void cargarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
//        jTable.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Extensión");
        modelo.addColumn("Leíble");
        modelo.addColumn("Fecha de Modificación");
        modelo.addColumn("Traspasar");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Nombre Completo");
    }
    
    private Object[] initJTableFiles(JTable jTable, JScrollPane jScrollPane, DefaultTableModel tableModel) {
        Object[] object = null;
        // We define te (Definimos el modelo de la tabla).
        tableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "NOMBRE", "EXTENSIÓN", "LEIBLE", "FECHA MODIFICACIÓN",
                    "TRASPASAR", "TAMAÑO", "NOMBRE COMPLETO"
                }
        ) {
            // Data types of the columns (Tipos de datos de las columnas).
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class,
                java.util.Date.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class,};
            // Editables columns (Columnas editables).
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, true, false, false
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        jTable = new JTable();
        jTable.setModel(tableModel);
        jScrollPane.setViewportView(jTable);
        // We define the width of the columns (Definimos el ancho de las columnas).
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setPreferredWidth(120);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(500);
        }
        // Columns auto sort (Ordenación automática de las columnas).
        jTable.setAutoCreateRowSorter(true);
        object = new Object[]{jTable, jScrollPane, tableModel};
        return object;
    }
    
    public boolean loadTableModelFiles(DefaultTableModel tableModel,
        String filesPath,  File filesDir,
        String extesionFile,
        String folder, PrintStream output) {
        boolean resultado;
        int row = 0;
        // Folder to read: folderFile (Fichero para leer).
        File folderFile = new File(folder);
        /*
            Then we read all the folder, the implementation 
            of filters extesionFile FilesDir and can be incorporated easily here.
            A continuación, leemos toda la carpeta, la implementación 
            de los filtros filesDir y extesionFile se puede incorporar aquí fácilmente.
         */
        if ((resultado = folderFile.exists())) {
            File[] files = folderFile.listFiles();
            for (File file : files) {
                boolean isFolder = file.isDirectory();
                if ((!isFolder)) {
                    output.println((isFolder ? "FOLDER: " : "  FILE: ") + file.getName());
                    double fileBytes = file.length();
                    double fileKiloBytes = (fileBytes / 1024);
                    double fileMegaBytes = (fileKiloBytes / 1024);
                    // Add rows to the TableModel (Añadimos filas al tableModel).
                    tableModel.insertRow(row++,
                            new Object[]{
                                file.getName(),                     // Name (Nombre)
                                getFileExtension(file.getName()),   // Extension (Extensión)                                
                                file.canRead(),                             // Readable (Leible)                 
                                new java.util.Date(file.lastModified()),    // Modify date (Fecha modificación)
                                false,                                      // Transfer (Traspasar)
                                fileKiloBytes + " KB",  // File Size (Tamaño del fichero)
                                file.getAbsolutePath()  // Absolute Path (Ruta del fichero completa)
                            });
                }
            }
        }
        return resultado;
    }
    /**
     * Returns the extension of a file that we pass as a parameter.
     * Devuelve la extensión de un archivo que se pasa como parámetro.
     * @param fileName <code>String</code> the file name (el nombre del fichero).
     * @return <code>String</code> the extension of the file name (la extensión del nombre del fichero).
     */
    public String getFileExtension(String fileName) {
        try {
            fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        } catch (Exception e) {
            fileExtension = "UNKNOW";
        }
        return fileExtension;
    }
    
    
    private void GenerarPDF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerarPDF1MouseClicked

    }//GEN-LAST:event_GenerarPDF1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GenerarPDF1;
    private javax.swing.JLabel Ruta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField txtPath;
    // End of variables declaration//GEN-END:variables
}
