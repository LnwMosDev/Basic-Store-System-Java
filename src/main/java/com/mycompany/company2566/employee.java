/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.company2566;

import java.awt.Event;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class employee extends javax.swing.JFrame {

    /**
     * Creates new form employee
     */
    Connection conn=null;
    Statement statement=null;

    
    public employee() {
        initComponents();
           ConnectDatabase();
           selectcombobox();

        showTableDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalSale = new javax.swing.JTextField();
        bNew = new javax.swing.JButton();
        bShow = new javax.swing.JButton();
        bClose = new javax.swing.JButton();
        employeeCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        employeeName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        Male = new javax.swing.JRadioButton();
        Unsex = new javax.swing.JRadioButton();
        Female = new javax.swing.JRadioButton();
        bInsert1 = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("department");

        jLabel5.setText("total sale");

        bNew.setText("New");
        bNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewActionPerformed(evt);
            }
        });

        bShow.setText("show");
        bShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowActionPerformed(evt);
            }
        });

        bClose.setText("close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });

        employeeCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                employeeCodeKeyPressed(evt);
            }
        });

        jLabel1.setText("code");

        employeeName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setText("name");

        jLabel3.setText("gender");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(Male);
        Male.setText("Male");

        buttonGroup1.add(Unsex);
        Unsex.setText("undifind");

        buttonGroup1.add(Female);
        Female.setText("Female");

        bInsert1.setText("insert");
        bInsert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsert1bInsertActionPerformed(evt);
            }
        });

        bUpdate.setText("update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        bDelete.setText("delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeCode, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(totalSale, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Male)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Female)
                                .addGap(35, 35, 35)
                                .addComponent(Unsex))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bNew)
                        .addGap(28, 28, 28)
                        .addComponent(bShow)
                        .addGap(33, 33, 33)
                        .addComponent(bClose))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(bInsert1)
                        .addGap(18, 18, 18)
                        .addComponent(bUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bDelete)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(employeeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(employeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Male)
                            .addComponent(Unsex)
                            .addComponent(Female))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(totalSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bInsert1)
                            .addComponent(bDelete)
                            .addComponent(bUpdate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bNew)
                            .addComponent(bShow)
                            .addComponent(bClose))))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void ConnectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cit3535", "root", "");
                statement=conn.createStatement();
                  System.out.println("success");
            } catch (SQLException ex) {
                System.out.println("un success1 ");
            }
        } catch (ClassNotFoundException Ex) {
             System.out.println("un success2");
        }
        
    }

    private void bNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewActionPerformed
        employeeCode.setText(null);
        employeeName.setText("");
       buttonGroup1.clearSelection();
       jComboBox1.setSelectedIndex(0);
         totalSale.setText("");
      employeeCode.requestFocus();
    }//GEN-LAST:event_bNewActionPerformed

    private void bShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowActionPerformed
        String gender="";
        if(Male.isSelected()){
            gender="Male";
        }else if(Female.isSelected()){
            gender="Female";
    }else if(Unsex.isSelected()){
        gender="undifind";
    }
        JOptionPane.showMessageDialog(this, employeeCode.getText()+","+employeeName.getText()+","+gender+","+jComboBox1.getSelectedItem()+","+totalSale.getText());
    }//GEN-LAST:event_bShowActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        int pressed=JOptionPane.showConfirmDialog(null, "Exit", "ออก ?", JOptionPane.YES_NO_OPTION);
        if(pressed==0){
            this.dispose();
        }
    }//GEN-LAST:event_bCloseActionPerformed

    private void bInsert1bInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsert1bInsertActionPerformed
        //        String insert = "INSERT INTO item VALUES ("+    sCode.getText()+",'"+   sName.getText()+"',"+  sPrice.getText()+""
        //        + ","+  sQty.getText()+",'"+jComboBox1.getSelectedItem()+"',"+sAmount.getText()+");";
        String gender="";
        if(Male.isSelected()){
            gender="M";
        }else if(Female.isSelected()){
            gender="F";
    }else if(Unsex.isSelected()){
        gender="undifind";
    }
        String insert = "INSERT INTO  employee VALUES ("+ employeeCode.getText()+",'"+   employeeName.getText()+"','"+ gender+"',"+jComboBox1.getSelectedItem().toString().substring(0, 2)  +","
                + ""+   totalSale.getText()+");";
        try{
            statement.executeUpdate(insert );
            showTableDB();
            System.out.println("success");
        }catch(Exception Ex){System.out.print("Error"+insert );}
    }//GEN-LAST:event_bInsert1bInsertActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        String gender = "";
        if (Male.isSelected()) {
            gender = "M";
        } else if (Female.isSelected()) {
            gender = "F";
        } else if (Unsex.isSelected()) {
            gender = "U";
        }
        String update = "UPDATE employee SET employeeName='" + employeeName.getText() + "', sex='"
                + gender + "', departmentCode=" + jComboBox1.getSelectedItem().toString().substring(0, 2)
                + " WHERE employeeCode=" + employeeCode.getText() + "";

        try {
            statement.executeUpdate(update);
            showTableDB();
            System.out.println("Update success");
        } catch (Exception ex) {
            System.out.print("Update Error" + ex.getMessage());
        }
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        String delete = "DELETE FROM employee WHERE employeeCode=("+employeeCode.getText()+")";
        try{
            statement.executeUpdate(delete );
            showTableDB();
            System.out.println("Delete success");
        }catch(Exception Ex){System.out.print("Delete Error"+delete);}
    }//GEN-LAST:event_bDeleteActionPerformed

    private void employeeCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employeeCodeKeyPressed
       if (evt.getKeyCode() == Event.ENTER) {
            String sql = "select * from employee WHERE employeeCode='" + employeeCode.getText() + "'";
            try {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    employeeName.setText(rs.getString("employeeName"));


                    String gender = rs.getString("sex");
                    if ("M".equals(gender)) {
                        Male.setSelected(true);
                    } else if ("F".equals(gender)) {
                        Female.setSelected(true);
                    } else if ("undifind".equals(gender)) {
                        Unsex.setSelected(true);
                    } else {
                        System.out.print("ไม่เจอ");
                    }
                                    
                    String departmentCode= rs.getString("departmentCode");
                    for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                        String item = jComboBox1.getItemAt(i).toString();
                        if (item.startsWith(departmentCode)) {
                            jComboBox1.setSelectedItem(item);
                            break; 
                        }
                    }

                    totalSale.setText(rs.getString("totalSale"));
                }
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_employeeCodeKeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

      private void selectcombobox(){
     try {
            ResultSet r = statement.executeQuery("select * from employee join department using(departmentCode) group by departmentCode");
            while (r.next()) {
                jComboBox1.addItem(r.getString("departmentCode") + " - " +r.getString("departmentName"));    
            }
            r.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
        
private void showTableDB() {
        try {
     DefaultTableModel tableModel = new DefaultTableModel();
                        Object[] header = {"employeeCode", "employeeName","sex","departmentCode","totalSale"};
        tableModel.setColumnIdentifiers(header);
        jTable1.setModel(tableModel);
        
            ResultSet r = statement.executeQuery("select * from employee");
//            DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
//            tableModel1.setRowCount(0);
            while (r.next()) {
                tableModel.addRow(new String[]{r.getString("employeeCode"), r.getString("employeeName"),
                    r.getString("sex"), r.getString("departmentCode"), r.getString("totalSale")});
            }
            r.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
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
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Female;
    private javax.swing.JRadioButton Male;
    private javax.swing.JRadioButton Unsex;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bInsert1;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bShow;
    private javax.swing.JButton bUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField employeeCode;
    private javax.swing.JTextField employeeName;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField totalSale;
    // End of variables declaration//GEN-END:variables
}
