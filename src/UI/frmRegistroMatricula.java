package UI;

import BEU.Curso;
import BEU.Estudiante;
import BLL.GestionCursos;
import BLL.GestionEstudiantes;
import BLL.GestionMatricula;
import Illapa.Util;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public class frmRegistroMatricula extends javax.swing.JInternalFrame {

    private final String titulo = "Registro de matrícula";
    // Servicio / Bussisness Logic Layer
    private final GestionCursos cursosBLL = new GestionCursos();
    private final GestionEstudiantes estudiantesBLL = new GestionEstudiantes();
    private final GestionMatricula matriculaBLL = new GestionMatricula();
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;

    private void leerEstudiantes() {
        try {
            Estudiante ficticio = new Estudiante();
            ficticio.setNombre("-Seleccione-");
            ficticio.setApellido("");
            this.cmbEstudiantes.addItem(ficticio);
            estudiantes = estudiantesBLL.leerEstudiantes();
            estudiantes.forEach((est) -> {
                cmbEstudiantes.addItem(est);
            });
        } catch (IOException e) {
            Util.Print("Error: " + e.toString());
            VTNPrincipal.vermensaje("Error al leer los estudiantes", titulo, JOptionPane.ERROR_MESSAGE);
        }
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

    private boolean validar() {
        Curso cr = (Curso) cmbCursos.getSelectedItem();
        Estudiante est = (Estudiante) cmbEstudiantes.getSelectedItem();
        if (cr.getTitulo().equals("-Seleccione-")) {
            VTNPrincipal.vermensaje("Curso invalido, seleccione", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (est.getNombre().equals("-Seleccione-")) {
            VTNPrincipal.vermensaje("Estudiante invalido, seleccione", titulo, JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private void crearMatricula() {
        Curso cr = (Curso) cmbCursos.getSelectedItem();
        Estudiante est = (Estudiante) cmbEstudiantes.getSelectedItem();
        matriculaBLL.crear();
        matriculaBLL.configurar(cr, est);
        matriculaBLL.archivar();

    }

    public frmRegistroMatricula() {
        initComponents();
        leerCursos();
        leerEstudiantes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbEstudiantes = new javax.swing.JComboBox<>();
        cmbCursos = new javax.swing.JComboBox<>();
        btnGuardarRegistro = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registrar Matrícula");
        setRequestFocusEnabled(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Registro de Matrícula");

        jLabel2.setText("Estudiante:");

        jLabel3.setText("Curso:");

        btnGuardarRegistro.setText("Guardar");
        btnGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardarRegistro, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbEstudiantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarRegistro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegistroActionPerformed
        try {
            if (validar()) {
                crearMatricula();
                VTNPrincipal.vermensaje("Matrícula creada correctamente", titulo, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            Util.Print("Error: " + e.toString());
            VTNPrincipal.vermensaje("Error al crear la matrícula", titulo, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarRegistro;
    private javax.swing.JComboBox<Curso> cmbCursos;
    private javax.swing.JComboBox<Estudiante> cmbEstudiantes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
