package UI;

import BEU.Curso;
import BEU.Matricula;
import BLL.GestionCursos;
import BLL.GestionMatricula;
import Illapa.Util;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmReporteCalificacion extends javax.swing.JInternalFrame {

    private final DefaultTableModel dtmCalificaciones = new DefaultTableModel();
    private final String titulo = "Reporte de Calificaciones";
    private final GestionCursos cursosBLL = new GestionCursos();
    private List<Curso> cursos;
    private GestionMatricula matriculaBLL = new GestionMatricula();
    private List<Matricula> calificaciones;

    private void configurarModeloTabla() {
        String[] columnas = {"Nombre", "Promedio", "Estado"};
        dtmCalificaciones.setColumnIdentifiers(columnas);
        tblReporte.setModel(dtmCalificaciones);
    }

    private void mostrarCalificaciones() {
        int lim = dtmCalificaciones.getRowCount() - 1;
        for (int i = lim; i >= 0; i--) {
            dtmCalificaciones.removeRow(i);
        }
        for (Matricula m : calificaciones) {
            Vector fila = new Vector();
            fila.addElement(m.getEstudiante());
            fila.addElement(m.getPromedio());
            fila.addElement(m.getEstado());
            dtmCalificaciones.addRow(fila);

        }
    }

    private void buscarMatriculas() throws IOException {
        Curso seleccionado = (Curso) cmbCursos.getSelectedItem();
        calificaciones = matriculaBLL.reportar(seleccionado.getTitulo());
        mostrarCalificaciones();
    }

    private void leerCursos() {
        try {
            Curso ficticio = new Curso("-Seleccione-", 0, "");
            this.cmbCursos.addItem(ficticio);
            cursos = cursosBLL.getCursos();
            cursos.forEach((c) -> {
                cmbCursos.addItem(c);
            });
        } catch (IOException e) {
            Util.Print("Error: " + e.toString());
            VTNPrincipal.vermensaje("Error al leer los cursos", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }

    public frmReporteCalificacion() {
        initComponents();
        leerCursos();
        configurarModeloTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbCursos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        bntBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporte = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setText("Curso:");

        bntBuscar.setIcon(new javax.swing.ImageIcon("/home/labctr/Descargas/Ejercicio 3 U3/Library/iconos/search.png")); // NOI18N
        bntBuscar.setToolTipText("Buscar");
        bntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Reporte de Calificaciones");

        tblReporte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblReporte);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntBuscar)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bntBuscar))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarActionPerformed
        try {
            buscarMatriculas();
        } catch (IOException e) {
            Util.Print("Error: " + e.toString());
            VTNPrincipal.vermensaje("Error al encontrar la Matrícula", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bntBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscar;
    private javax.swing.JComboBox<Curso> cmbCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReporte;
    // End of variables declaration//GEN-END:variables
}
