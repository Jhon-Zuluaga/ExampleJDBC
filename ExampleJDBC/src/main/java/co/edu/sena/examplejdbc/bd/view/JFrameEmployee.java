/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.view;

import co.edu.sena.examplejdbc.bd.Utils.MessageUtils;
import co.edu.sena.examplejdbc.controllers.EmployeeController;
import co.edu.sena.examplejdbc.controllers.EmployeeTypeController;
import co.edu.sena.examplejdbc.controllers.IEmployeeController;
import co.edu.sena.examplejdbc.controllers.IEmployeeTypeController;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.EmployeeType;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aprendiz
 */
public class JFrameEmployee extends javax.swing.JFrame {

    private IEmployeeTypeController employeeTypeController = new EmployeeTypeController();
    private IEmployeeController employeeController = new EmployeeController();

    /**
     * Creates new form JFrameEmployee
     */
    public JFrameEmployee() {
        initComponents();
        fillComboTypes();
        FillTable();
    }

    public void fillComboTypes() {
        try {
            List<EmployeeType> types = employeeTypeController.findAll();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            jComboBoxType.setModel(model);
            model.addAll(types);
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }

    public void FillTable() {
        try {
            DefaultTableModel model = new DefaultTableModel();
            jTableEmployee.setModel(model);
            model.addColumn("documento");
            model.addColumn("Nombre Completo");
            model.addColumn("Tipo de empleado");

            String[] rows = new String[3];
            List<Employee> types = employeeController.findAll();
            for (Employee type : types) {
                rows[0] = String.valueOf(type.getDocument());
                rows[1] = type.getFullname();
                rows[2] = type.getEmployeeType().getDescript();
                model.addRow(rows);
            }
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabelDocument = new javax.swing.JLabel();
        jLabelFullName = new javax.swing.JLabel();
        jTextFieldDocument = new javax.swing.JTextField();
        jTextFieldFullName = new javax.swing.JTextField();
        jLabelAddress = new javax.swing.JLabel();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jLabelType = new javax.swing.JLabel();
        jComboBoxType = new javax.swing.JComboBox<>();
        jButtonInsert = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();
        jLabelIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Empleado");

        jLabelDocument.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelDocument.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDocument.setText("Documento:");

        jLabelFullName.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelFullName.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFullName.setText("Nombre Completo:");

        jLabelAddress.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelAddress.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAddress.setText("Dirección:");

        jLabelPhone.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelPhone.setForeground(new java.awt.Color(0, 0, 0));
        jLabelPhone.setText("Teléfono:");

        jLabelType.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabelType.setForeground(new java.awt.Color(0, 0, 0));
        jLabelType.setText("Tipo:");

        jButtonInsert.setBackground(new java.awt.Color(153, 255, 51));
        jButtonInsert.setForeground(new java.awt.Color(0, 0, 0));
        jButtonInsert.setText("Insert");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 255, 204));
        jButtonUpdate.setForeground(new java.awt.Color(0, 0, 0));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(255, 102, 102));
        jButtonDelete.setForeground(new java.awt.Color(0, 0, 0));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonClear.setBackground(new java.awt.Color(153, 153, 153));
        jButtonClear.setForeground(new java.awt.Color(0, 0, 0));
        jButtonClear.setText("Clear");
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });

        jTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmployeeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmployee);

        jLabelIcon.setIcon(new javax.swing.ImageIcon("D:\\Repos\\ExampleJDBC\\ExampleJDBC\\src\\main\\resources\\co\\edu\\sena\\examplejdbc\\view\\logo.png")); // NOI18N
        jLabelIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelType)
                                    .addComponent(jButtonInsert))
                                .addGap(84, 84, 84)
                                .addComponent(jButtonUpdate)
                                .addGap(105, 105, 105)
                                .addComponent(jButtonDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelDocument)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelAddress)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldDocument, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPhone)
                                    .addComponent(jLabelFullName)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabelIcon)
                                .addGap(182, 182, 182)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonClear))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelIcon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDocument)
                    .addComponent(jLabelFullName)
                    .addComponent(jTextFieldDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddress)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPhone)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelType)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsert)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clean();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jTableEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmployeeMouseClicked
        int rowSelected = jTableEmployee.getSelectedRow();
        if (rowSelected != -1) {

            long documentSelected = Long.parseLong(jTableEmployee.getValueAt(rowSelected, 0).toString());
            try {
                Employee employee = employeeController.findById(documentSelected);
                jTextFieldDocument.setText(String.valueOf(documentSelected));
                jTextFieldFullName.setText(employee.getFullname());
                jTextFieldAddress.setText(employee.getAddress());
                jTextFieldPhone.setText(employee.getPhone());
                jComboBoxType.getModel().setSelectedItem(employee.getEmployeeType());

                jButtonInsert.setEnabled(false);
                jButtonDelete.setEnabled(true);
                jButtonUpdate.setEnabled(true);
            } catch (Exception e) {
                MessageUtils.ShowErrorMessage(e.getMessage());
            }

        }
    }//GEN-LAST:event_jTableEmployeeMouseClicked

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        try {
            Employee employee = new Employee();
            employee.setDocument(Long.parseLong(jTextFieldDocument.getText()));
            employee.setFullname(jTextFieldFullName.getText());
            employee.setAddress(jTextFieldAddress.getText());
            employee.setPhone(jTextFieldPhone.getText());
            // FK

            EmployeeType type = (EmployeeType) jComboBoxType.getSelectedItem();
            employee.setEmployeeType(type);

            employeeController.insert(employee);
            MessageUtils.ShowInfoMessage("Empleado creado exitosamente");
            FillTable();
            clean();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try {
            Employee employee = new Employee();
            employee.setDocument(Long.parseLong(jTextFieldDocument.getText()));
            employee.setFullname(jTextFieldFullName.getText());
            employee.setAddress(jTextFieldAddress.getText());
            employee.setPhone(jTextFieldPhone.getText());
            // FK

            EmployeeType type = (EmployeeType) jComboBoxType.getSelectedItem();
            employee.setEmployeeType(type);

            employeeController.update(employee);
            MessageUtils.ShowInfoMessage("Empleado modificado exitosamente");
            FillTable();
            clean();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
         try {
            int option = JOptionPane.showConfirmDialog(rootPane, "Está seguro de eliminar el registro?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                employeeController.delete(Long.parseLong(jTextFieldDocument.getText()));
                MessageUtils.ShowInfoMessage("Empleado eliminado exitosamente");
                FillTable();
            }
            clean();
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jLabelIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconMouseClicked
       JFrameHome view =new JFrameHome();
       view.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jLabelIconMouseClicked

    public void clean() {
        jTextFieldAddress.setText("");
        jTextFieldDocument.setText("");
        jTextFieldFullName.setText("");
        jTextFieldPhone.setText("");
        jTableEmployee.clearSelection();
        jComboBoxType.setSelectedIndex(0);
        jButtonInsert.setEnabled(true);
        jButtonDelete.setEnabled(false);
        jButtonUpdate.setEnabled(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelDocument;
    private javax.swing.JLabel jLabelFullName;
    private javax.swing.JLabel jLabelIcon;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldDocument;
    private javax.swing.JTextField jTextFieldFullName;
    private javax.swing.JTextField jTextFieldPhone;
    // End of variables declaration//GEN-END:variables
}
