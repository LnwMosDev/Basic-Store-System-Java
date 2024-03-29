/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.company2566;

import java.awt.Event;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class TableTest extends javax.swing.JFrame {

    /**
     * Creates new form TableTest
     */
    
     DefaultTableModel tableModel=new DefaultTableModel();
     
    public TableTest() {
        initComponents();
           Object[] header={"itemCode","itemName","price","qty","amount"};
        tableModel.setColumnIdentifiers(header);

        jTable1.setModel( tableModel);
//        tableModel.setColumnCount(5);
//        initialValue();

        Object[] [] data={
                                                         {"0001","a","100","10","null"},{"0002","b","150","10","null"},{"0003","c","250","10","null"}
                                                    };
        tableModel.setDataVector(data,header);
        bAmount.doClick();
        bTotal.doClick();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bShow = new javax.swing.JButton();
        bAmount = new javax.swing.JButton();
        bTotal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        showTotal = new javax.swing.JTextField();
        bAdd = new javax.swing.JButton();
        bCode = new javax.swing.JTextField();
        bPrice = new javax.swing.JTextField();
        bName = new javax.swing.JTextField();
        bQty = new javax.swing.JTextField();
        bbAmount = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"001", "computer", "20000", "10", ""},
                {"002", "pencil", "5", "5", ""},
                {"003", "notebook", "10", "10", ""},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "itemCode", "itemName", "price", "qty", "amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(120);
        }

        bShow.setText("show");
        bShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowActionPerformed(evt);
            }
        });

        bAmount.setText("Amount");
        bAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAmountActionPerformed(evt);
            }
        });

        bTotal.setText("total");
        bTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTotalActionPerformed(evt);
            }
        });

        jLabel1.setText("Total");

        showTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showTotalActionPerformed(evt);
            }
        });

        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bCodeKeyPressed(evt);
            }
        });

        bPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bPriceKeyPressed(evt);
            }
        });

        bName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNameActionPerformed(evt);
            }
        });
        bName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bNameKeyPressed(evt);
            }
        });

        bQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bQtyKeyPressed(evt);
            }
        });

        jLabel2.setText("itemCode");

        jLabel3.setText("price");

        jLabel4.setText("itemName");

        jLabel5.setText("qty");

        jLabel6.setText("Amount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bCode, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bQty, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(bName, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addComponent(bAdd))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(bShow)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(bAmount))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(showTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bTotal)))
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bbAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(bAdd))
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bShow)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAmount)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bTotal)
                            .addComponent(showTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

      private void initialValue(){                                      
        Object[] data1={"0001","a","100","10","null"};
        tableModel.addRow(data1);
        Object[] data2={"0002","b","150","10","null"};
        tableModel.addRow(data2);
        Object[] data3={"0003","c","250","10","null"};
        tableModel.addRow(data3);
    }
      
    private void bShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowActionPerformed
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            for (int j = 0; j < jTable1.getColumnCount(); j++) {
                System.out.print(jTable1.getValueAt(i, j) + "\t");
            }
            System.out.println();
    }//GEN-LAST:event_bShowActionPerformed
    }

    private void bAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAmountActionPerformed

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
//             int value1 = (int) jTable1.getValueAt(i, 3);
//             int value2 = (int) jTable1.getValueAt(i, 2);
                int value1 = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
                int value2 = Integer.parseInt(jTable1.getValueAt(i, 2).toString());
                // Calculate the subtotal and format it
                int subtotal = value1 * value2;

//                String formattedSubtotal = numberFormat.format(subtotal);
//                jTable1.setValueAt(formattedSubtotal, i, 4);
  NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
            jTable1.setValueAt(numberFormat.format(subtotal), i, 4);
//                  jTable1.setValueAt(value1*value2, i, 4);
            } catch (Exception ex) { ex.printStackTrace(); }
            
    }//GEN-LAST:event_bAmountActionPerformed
    }
    
    private void bTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTotalActionPerformed
 int totalSum = 0;

//    for (int i = 0; i < jTable1.getRowCount(); i++) {
//        try {
////             int totalValue = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
//             int totalValue = Integer.parseInt(jTable1.getValueAt(i, 4).toString());
//            totalSum += totalValue;
//        } catch (Exception ex) {}
//    }
//    showTotal.setText(String.valueOf(totalSum));
for (int i = 0; i < jTable1.getRowCount(); i++) {
        try {
            int totalValue = Integer.parseInt(jTable1.getValueAt(i, 4).toString().replaceAll(",", ""));
            totalSum += totalValue;
        } catch (NumberFormatException | NullPointerException ignored) {}
    }

    showTotal.setText(NumberFormat.getInstance(Locale.US).format(totalSum));

//    NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
//    showTotal.setText(numberFormat.format(totalSum));
    }//GEN-LAST:event_bTotalActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
//        Object[] data = {bCode.getText(), bName.getText(), bPrice.getText(), bQty.getText(), bbAmount.getText()};
//        tableModel.addRow(data);
//        
//        int sum=Integer.parseInt(showTotal.getText().toString());
//        sum+=Integer.parseInt(   bbAmount.getText().toString());
//        showTotal.setText(String.valueOf(sum));
        
          Object[] data = {bCode.getText(), bName.getText(), bPrice.getText(), bQty.getText(), bbAmount.getText()};
    tableModel.addRow(data);

    int sum = Integer.parseInt(showTotal.getText().replace(",", ""));
    sum += Integer.parseInt(bbAmount.getText().replace(",", ""));

    NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
    showTotal.setText(numberFormat.format(sum));
    
     for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
//             int value1 = (int) jTable1.getValueAt(i, 3);
//             int value2 = (int) jTable1.getValueAt(i, 2);
                int value1 = Integer.parseInt(jTable1.getValueAt(i, 3).toString());
                int value2 = Integer.parseInt(jTable1.getValueAt(i, 2).toString());
                // Calculate the subtotal and format it
                int subtotal = value1 * value2;

//                String formattedSubtotal = numberFormat.format(subtotal);
//                jTable1.setValueAt(formattedSubtotal, i, 4);
            jTable1.setValueAt(numberFormat.format(subtotal), i, 4);
//                  jTable1.setValueAt(value1*value2, i, 4);
            } catch (Exception ex) { ex.printStackTrace(); }
     }
     
    }//GEN-LAST:event_bAddActionPerformed

    private void bNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bNameActionPerformed

    private void bCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bCodeKeyPressed
        if(evt.getKeyCode()==Event.ENTER){
        bName.requestFocus();
        }
    }//GEN-LAST:event_bCodeKeyPressed

    private void bNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bNameKeyPressed
        if(evt.getKeyCode()==Event.ENTER){
        bPrice.requestFocus();
        }
    }//GEN-LAST:event_bNameKeyPressed

    private void bQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bQtyKeyPressed
      if (evt.getKeyCode() == Event.ENTER) {
            bbAmount.requestFocus();
            try {
                int priceValue = Integer.parseInt(bPrice.getText());
                int qtyValue = Integer.parseInt(bQty.getText());
                int amountValue = priceValue * qtyValue;
                bbAmount.setText(String.valueOf(amountValue));
                
            } catch (Exception ex) {
            }
    }          
    }//GEN-LAST:event_bQtyKeyPressed

    private void bPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bPriceKeyPressed
       if(evt.getKeyCode()==Event.ENTER){
        bQty.requestFocus();
        }
    }//GEN-LAST:event_bPriceKeyPressed

    private void showTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showTotalActionPerformed
    
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
            java.util.logging.Logger.getLogger(TableTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bAmount;
    private javax.swing.JTextField bCode;
    private javax.swing.JTextField bName;
    private javax.swing.JTextField bPrice;
    private javax.swing.JTextField bQty;
    private javax.swing.JButton bShow;
    private javax.swing.JButton bTotal;
    private javax.swing.JTextField bbAmount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField showTotal;
    // End of variables declaration//GEN-END:variables
}
