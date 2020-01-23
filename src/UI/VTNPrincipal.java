package UI;

import javax.swing.JOptionPane;

public class VTNPrincipal extends javax.swing.JFrame {

    public static void vermensaje(String mensaje, String titulo, int tipo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, tipo);
    }

    public VTNPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnuCuentas = new javax.swing.JMenu();
        mniRegistrarMatricula = new javax.swing.JMenuItem();
        mnRegistrarCalificacion = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnEstudiante = new javax.swing.JMenuItem();
        mnReporte = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.setFocusable(false);

        mnuCuentas.setMnemonic('f');
        mnuCuentas.setText("Matriculas");

        mniRegistrarMatricula.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniRegistrarMatricula.setMnemonic('o');
        mniRegistrarMatricula.setText("Registrar");
        mniRegistrarMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniRegistrarMatriculaActionPerformed(evt);
            }
        });
        mnuCuentas.add(mniRegistrarMatricula);

        mnRegistrarCalificacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnRegistrarCalificacion.setText("Calificar");
        mnRegistrarCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRegistrarCalificacionActionPerformed(evt);
            }
        });
        mnuCuentas.add(mnRegistrarCalificacion);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        mnuCuentas.add(exitMenuItem);

        menuBar.add(mnuCuentas);

        jMenu1.setText("Estudiantes");

        mnEstudiante.setText("Crear");
        mnEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnEstudianteActionPerformed(evt);
            }
        });
        jMenu1.add(mnEstudiante);

        mnReporte.setText("Reporte");
        mnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReporteActionPerformed(evt);
            }
        });
        jMenu1.add(mnReporte);

        menuBar.add(jMenu1);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Contents");
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void mnRegistrarCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRegistrarCalificacionActionPerformed
        frmRegistroCalificaciones m = new frmRegistroCalificaciones();
        this.desktopPane.add(m);
        m.show();
    }//GEN-LAST:event_mnRegistrarCalificacionActionPerformed

    private void mniRegistrarMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniRegistrarMatriculaActionPerformed
        frmRegistroMatricula m = new frmRegistroMatricula();
        this.desktopPane.add(m);
        m.show();
    }//GEN-LAST:event_mniRegistrarMatriculaActionPerformed

    private void mnEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnEstudianteActionPerformed
        frmRegistroEstudiante m = new frmRegistroEstudiante();
        this.desktopPane.add(m);
        m.show();
    }//GEN-LAST:event_mnEstudianteActionPerformed

    private void mnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReporteActionPerformed
        frmReporteCalificacion m = new frmReporteCalificacion();
        this.desktopPane.add(m);
        m.show();
    }//GEN-LAST:event_mnReporteActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new VTNPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnEstudiante;
    private javax.swing.JMenuItem mnRegistrarCalificacion;
    private javax.swing.JMenuItem mnReporte;
    private javax.swing.JMenuItem mniRegistrarMatricula;
    private javax.swing.JMenu mnuCuentas;
    private javax.swing.JMenuItem pasteMenuItem;
    // End of variables declaration//GEN-END:variables

}
