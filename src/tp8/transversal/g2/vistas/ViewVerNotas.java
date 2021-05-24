/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.transversal.g2.vistas;


import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tp8.transversal.g2.clases.*;
import tp8.transversal.g2.data.AlumnoData;
import tp8.transversal.g2.data.CursadaData;
import tp8.transversal.g2.data.MateriaData;

/**
 *
 * @author Guido Caballero
 */
public class ViewVerNotas extends javax.swing.JInternalFrame {
private CursadaData cd;
private AlumnoData ad;
private DefaultTableModel dtm;
    /**
     * Creates new form ViewVerInscriptos
     */
    public ViewVerNotas(AlumnoData ad,MateriaData md,CursadaData cd) {
        initComponents();
        this.cd=cd;
        this.ad = ad;
        dtm = (DefaultTableModel) jtInscriptos.getModel();
        Iterator <Alumno> it=ad.obtenerAlumnos().iterator();
        cbAlumnos.addItem(null);
        while(it.hasNext()){
            Alumno a = it.next();
            cbAlumnos.addItem(a);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        cbAlumnos = new javax.swing.JComboBox<>();
        jbBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtInscriptos = new javax.swing.JTable();
        jbConfirmar = new javax.swing.JButton();
        jtNota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbMaterias = new javax.swing.JComboBox<>();
        jbLimpiar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setClosable(true);

        cbAlumnos.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        cbAlumnos.setToolTipText("");

        jbBuscar.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel1.setText("Alumno");

        jtInscriptos.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 14)); // NOI18N
        jtInscriptos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Materia", "Materia", "Nota"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtInscriptos);

        jbConfirmar.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jbConfirmar.setText("Confirmar");
        jbConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConfirmarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel3.setText("Ingrese la nota");

        jLabel2.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jLabel2.setText("Materia ");

        cbMaterias.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N

        jbLimpiar.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jbLimpiar.setText("Limpiar");
        jbLimpiar.setPreferredSize(new java.awt.Dimension(101, 38));
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbSalir.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 16)); // NOI18N
        jbSalir.setText("Salir");
        jbSalir.setMaximumSize(new java.awt.Dimension(86, 38));
        jbSalir.setMinimumSize(new java.awt.Dimension(101, 38));
        jbSalir.setPreferredSize(new java.awt.Dimension(101, 38));
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBuscar))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(84, 84, 84)
                                .addComponent(jtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)))
                        .addGap(551, 551, 551))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbConfirmar)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        int x = jtInscriptos.getRowCount();
        dtm = (DefaultTableModel)jtInscriptos.getModel();
        for (int i = 0;x>i; i++)
                dtm.removeRow(0);
        jtInscriptos.setModel(dtm);
        if(cbAlumnos.getSelectedItem()!=null){
            cbAlumnos.setEnabled(true);
            cbMaterias.setEnabled(true);
            cbMaterias.removeAllItems();
            cbMaterias.addItem(null);
            Alumno a = (Alumno)cbAlumnos.getSelectedItem();
            Iterator <Cursada> itC = cd.obtenerCursadasxAlumno(a.getId_alumno()).iterator();
            if (itC.hasNext()){
                while(itC.hasNext()){
                    Cursada c1 = itC.next();
                    Materia m = c1.getMateria();
                    String []row = new String[3];
                    row[0] = m.getId_materia()+"";
                    row[1] = m.getNombre();
                    row[2] = c1.getNota()+"";
                    dtm.addRow(row);
                    jtInscriptos.setModel(dtm);
                    cbMaterias.addItem(c1.getMateria());
                    jbConfirmar.setEnabled(true);
                }
                cbAlumnos.setEnabled(false);
            }else
                JOptionPane.showMessageDialog(null, "El alumno que seleccionó, no se encuentra inscripto en ninguna materia");
        }        
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConfirmarActionPerformed
        float nota=0;
        Materia m;
        try{
            nota = Float.valueOf(jtNota.getText());
            if(nota<0||nota>10)
                nota=0;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Por favor ingrese un valor entre 1 y 10");
            this.jbLimpiarActionPerformed(evt);
        }
        if(nota !=0){
            Alumno a = (Alumno)cbAlumnos.getSelectedItem();
            if(cbMaterias.getSelectedItem()!= null){
                m = (Materia)cbMaterias.getSelectedItem();
                if(cd.buscarNotaCursada(a.getId_alumno(), m.getId_materia())==0){
                    cd.actualizarNotaCursada(a.getId_alumno(), m.getId_materia(), nota);
                    JOptionPane.showMessageDialog(null,"La nota fue guardada exitosamente");
                }else{
                    if(JOptionPane.showConfirmDialog(null, "El alumno ya posee una nota cargada, realmente desea actualizarla?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0){
                        cd.actualizarNotaCursada(a.getId_alumno(), m.getId_materia(), nota);
                        JOptionPane.showMessageDialog(null,"La nota ha sido modificada exitosamente");
                    }
                }
            }else
            JOptionPane.showMessageDialog(null,"Por favor seleccione una materia del conjunto");
        }else 
            JOptionPane.showMessageDialog(null,"Ingrese un número entre 1 y 10");
        this.jbLimpiarActionPerformed(evt);
    }//GEN-LAST:event_jbConfirmarActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        int x = jtInscriptos.getRowCount();
        dtm = (DefaultTableModel)jtInscriptos.getModel();
        for (int i = 0;x>i; i++)
                dtm.removeRow(0);
        jtInscriptos.setModel(dtm);
        cbMaterias.removeAllItems();
        cbAlumnos.removeAllItems();
        Iterator <Alumno> it=ad.obtenerAlumnos().iterator();
        cbAlumnos.addItem(null);
        jtNota.setText("");
        while(it.hasNext()){
            Alumno a1=it.next();
            if(a1.isActivo())
            cbAlumnos.addItem(a1);
        }
        jbConfirmar.setEnabled(false);
        cbMaterias.setEnabled(false);
        cbAlumnos.setEnabled(true);
    }//GEN-LAST:event_jbLimpiarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Alumno> cbAlumnos;
    private javax.swing.JComboBox<Materia> cbMaterias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbConfirmar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtInscriptos;
    private javax.swing.JTextField jtNota;
    // End of variables declaration//GEN-END:variables
}
