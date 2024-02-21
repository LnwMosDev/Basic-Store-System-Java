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
public class Item extends javax.swing.JFrame {

    /**
     * Creates new form Item
     */
    Connection conn=null;
    Statement statement=null;

    
    
    public Item() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bNew = new javax.swing.JButton();
        bShow = new javax.swing.JButton();
        bClose = new javax.swing.JButton();
        sCode = new javax.swing.JTextField();
        sName = new javax.swing.JTextField();
        sPrice = new javax.swing.JTextField();
        sQty = new javax.swing.JTextField();
        sAmount = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        bInsert1 = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        jLabel2.setText("Name");

        jLabel3.setText("Price");

        jLabel4.setText("QTY");

        jLabel5.setText("Amount");

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

        sCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sCodeKeyPressed(evt);
            }
        });

        sName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sNameKeyPressed(evt);
            }
        });

        sPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sPriceKeyPressed(evt);
            }
        });

        sQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sQtyKeyPressed(evt);
            }
        });

        sAmount.setEnabled(false);

        jComboBox1.setFont(new java.awt.Font("PK Sukhothai", 0, 14)); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel6.setText("type");

        bInsert1.setText("insert");
        bInsert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertActionPerformed(evt);
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
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sCode, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sAmount, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sQty, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bNew)
                                .addGap(28, 28, 28)
                                .addComponent(bShow)
                                .addGap(33, 33, 33)
                                .addComponent(bClose))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(bInsert1)
                                .addGap(18, 18, 18)
                                .addComponent(bUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bDelete)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(sCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(sPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(sQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(sAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bInsert1)
                            .addComponent(bDelete)
                            .addComponent(bUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bNew)
                            .addComponent(bShow)
                            .addComponent(bClose))))
                .addContainerGap(65, Short.MAX_VALUE))
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
       sCode.setText(null);
     sName.setText("");
     sPrice.setText("");
     sQty.setText("");
     jComboBox1.setSelectedIndex(0);
     sAmount.setText("");
     sCode.requestFocus();
    }//GEN-LAST:event_bNewActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
 int pressed=JOptionPane.showConfirmDialog(null, "Exit", "ออก ?", JOptionPane.YES_NO_OPTION);
      if(pressed==0){
      this.dispose();
      }    
    }//GEN-LAST:event_bCloseActionPerformed

    private void bShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowActionPerformed
        JOptionPane.showMessageDialog(this,sCode.getText()+","+sName.getText()+","+jComboBox1.getSelectedItem()+","+sPrice.getText()+","+sQty.getText()+","+sAmount.getText());
    }//GEN-LAST:event_bShowActionPerformed

    private void sCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sCodeKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            String sql = "select * from item WHERE itemCode='" + sCode.getText() + "'";
            try {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    
                    sName.setText(rs.getString("itemName"));

                    String typeCode = rs.getString("typeCode");
                    for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                        String item = jComboBox1.getItemAt(i).toString();
                        if (item.startsWith(typeCode)) {
                            jComboBox1.setSelectedItem(item);
                            break; 
                        }
                    }

                    sPrice.setText(rs.getString("price"));
                    sQty.setText(rs.getString("qty"));
                }
                rs.close();
            } catch (SQLException ex) {
            }
        }
    }//GEN-LAST:event_sCodeKeyPressed

    private void sNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sNameKeyPressed
       if(evt.getKeyCode()==Event.ENTER){
        sPrice.requestFocus();
    }//GEN-LAST:event_sNameKeyPressed
}
    private void sPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sPriceKeyPressed
        if(evt.getKeyCode()==Event.ENTER){
        sQty.requestFocus();
    }//GEN-LAST:event_sPriceKeyPressed
}
    
    private void sQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sQtyKeyPressed
        if (evt.getKeyCode() == Event.ENTER) {
            sAmount.requestFocus();
            try {
                double priceValue = Double.parseDouble(sPrice.getText());
                int qtyValue = Integer.parseInt(sQty.getText());
                double amountValue = priceValue * qtyValue;
                sAmount.setText(String.valueOf(amountValue));
            } catch (Exception ex) {
            }
    }//GEN-LAST:event_sQtyKeyPressed
}
    private void bInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertActionPerformed

  String insert = "INSERT INTO item VALUES ("+    sCode.getText()+",'"+   sName.getText()+"',"+  sPrice.getText()+""
        + ","+  sQty.getText()+","+jComboBox1.getSelectedItem().toString().substring(0,2) +");";
        try{
            statement.executeUpdate(insert );
            showTableDB();
            System.out.println("success");
        }catch(Exception Ex){System.out.print("Error"+insert+"\n"+Ex.getMessage() );}
    }//GEN-LAST:event_bInsertActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        String update = "UPDATE item SET itemName='" + sName.getText() + "', price=" + sPrice.getText() + ", qty=" + sQty.getText() + ",typeCode=" + jComboBox1.getSelectedItem().toString().substring(0, 2) + " WHERE itemCode=" + sCode.getText() + "";

        try {
            statement.executeUpdate(update);
            showTableDB();
            System.out.println("Update success");
        } catch (Exception ex) {
            System.out.print("Update Error" + ex.getMessage());
        }
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        String delete = "DELETE FROM item WHERE itemCode=("+  sCode.getText()+")";
        try{
            statement.executeUpdate(delete );
            showTableDB();
            System.out.println("success");
        }catch(Exception Ex){System.out.print("Error"+delete);}
    }//GEN-LAST:event_bDeleteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
       
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    private void selectcombobox(){
     try {
            ResultSet r = statement.executeQuery("select * from item join itemtype using(typeCode) group by typeCode");
            while (r.next()) {
                jComboBox1.addItem(r.getString("typeCode") + " - " +r.getString("typeName"));    
            }
            r.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection",
                    JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
    }
    
private void showTableDB() {
        try {
 DefaultTableModel tableModel = new DefaultTableModel();
   Object[] header = {"itemCode", "itemName","price","qty","typeCode"};
        tableModel.setColumnIdentifiers(header);
        jTable1.setModel(tableModel);
 
            ResultSet r = statement.executeQuery("select * from item");
//            DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
//            tableModel1.setRowCount(0);
            while (r.next()) {
                tableModel.addRow(new String[]{r.getString("itemCode"), r.getString("itemName"),
                    r.getString("price"), r.getString("qty"), r.getString("typeCode")});
            }
            r.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to Connect to Database", "Error Connection",
                    JOptionPane.WARNING_MESSAGE);
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
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bClose;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bInsert1;
    private javax.swing.JButton bNew;
    private javax.swing.JButton bShow;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sAmount;
    private javax.swing.JTextField sCode;
    private javax.swing.JTextField sName;
    private javax.swing.JTextField sPrice;
    private javax.swing.JTextField sQty;
    // End of variables declaration//GEN-END:variables
}