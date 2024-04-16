package Views;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        btnViviendas = new javax.swing.JButton();
        btnHabitantes = new javax.swing.JButton();
        btnOcupaciones = new javax.swing.JButton();
        btnMateriales = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnViviendas.setText("Viviendas");
        btnViviendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViviendasActionPerformed(evt);
            }
        });

        btnHabitantes.setText("Habitantes");
        btnHabitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHabitantesActionPerformed(evt);
            }
        });

        btnOcupaciones.setText("Ocupaciones");
        btnOcupaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcupacionesActionPerformed(evt);
            }
        });

        btnMateriales.setText("Materiales Vivienda");
        btnMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("MENU");

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOcupaciones)
                    .addComponent(btnMateriales)
                    .addComponent(btnViviendas)
                    .addComponent(btnHabitantes))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(btnViviendas)
                .addGap(18, 18, 18)
                .addComponent(btnHabitantes)
                .addGap(18, 18, 18)
                .addComponent(btnOcupaciones)
                .addGap(18, 18, 18)
                .addComponent(btnMateriales)
                .addGap(32, 32, 32)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHabitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHabitantesActionPerformed
        // Crear una instancia de la ventana Habitantes
    Habitantes habitante = new Habitantes(); 
    habitante.setVisible(true); // Mostrar la ventana de Habitantes
    dispose();
    }//GEN-LAST:event_btnHabitantesActionPerformed

    private void btnMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialesActionPerformed
        // Crear una instancia de la ventana Materiales Vivienda
    MaterialVivienda material = new MaterialVivienda(); 
    material.setVisible(true); // Mostrar la ventana de Viviendas
    dispose();
    }//GEN-LAST:event_btnMaterialesActionPerformed

    private void btnViviendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViviendasActionPerformed
        // Crear una instancia de la ventana Viviendas
    Viviendas viviendas = new Viviendas(); 
    viviendas.setVisible(true); // Mostrar la ventana de Viviendas
    dispose(); // Cerrar la ventana del menú principal
    }//GEN-LAST:event_btnViviendasActionPerformed

    private void btnOcupacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcupacionesActionPerformed
        // Crear una instancia de la ventana Ocupaciones
    Ocupaciones ocupacion = new Ocupaciones(); 
    ocupacion.setVisible(true); // Mostrar la ventana de Ocupaciones
    dispose();
    }//GEN-LAST:event_btnOcupacionesActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // Cerrar la aplicación
        System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnHabitantes;
    private javax.swing.JButton btnMateriales;
    private javax.swing.JButton btnOcupaciones;
    private javax.swing.JButton btnViviendas;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
