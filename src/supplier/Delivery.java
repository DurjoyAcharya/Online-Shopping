/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package supplier;

import dao.PurchaseDao;
import dao.SupplierDao;
import java.awt.Color;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static supplier.SupplierDashboard.jLabel11;
import static supplier.SupplierDashboard.jLabel9;
import static supplier.SupplierDashboard.jPanel11;


public class Delivery extends javax.swing.JFrame {
public SimpleDateFormat df;
    public DefaultTableModel model;
    public Date date;
    public PurchaseDao purchase=new PurchaseDao();
    SupplierDao supplier;
    private String SupplierName;
    int rowIndex=0;
    public Delivery() throws SQLException {
          date=new Date();
          df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
          supplier=new SupplierDao();
          initComponents();
          init();
    }
    
    public void init() throws SQLException{
     
      SupplierName=supplier.getSupplierName("admin@lotto.org.bd");//SupplierDashboard.supplierEmail.getText()
      purchaseTable();
    }
    
    
    
     private void purchaseTable() throws SQLException{
       
        purchase.getOnTheWayProduct(jTable1, "", SupplierName);
        model=(DefaultTableModel) jTable1.getModel();
        jTable1.setRowHeight(30);
        jTable1.setShowGrid(true);
        jTable1.setGridColor(Color.black);
        jTable1.setBackground(Color.WHITE);
        jTable1.setSelectionBackground(Color.LIGHT_GRAY);
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 213, 128));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setFont(new java.awt.Font("Fira Code iScript", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Si.No", "UID", "UName", "Phone", "PID", "PName", "Qty", "Price", "Total", "Date", "Address", "Received", "Supplier Name", "Status"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1060, 420));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setText("Product Search");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 150, 20));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 260, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("x");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        setVisible(false);
        SupplierDashboard.jLabel9.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        jTable1.setModel(new DefaultTableModel(
        null,
           new Object[]{
               "Purchase Id",
               "User Id",
               "User Name",
               "User Phone",
               "Product Id",
               "Product Name",
               "Quantity",
               "Price",
               "Total",
               "Purchase Date",
               "Address",
               "Received Date",
               "Supplier Name",
               "Status"
           }
        ));
    try {
        purchase.getOnTheWayProduct(jTable1, "", SupplierName);
        
    } catch (SQLException ex) {
        Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        model=(DefaultTableModel) jTable1.getModel();
        rowIndex=jTable1.getSelectedRow();
        int id=Integer.parseInt((String) model.getValueAt(rowIndex, 0));
        String receivedDate=df.format(date);
        
        String status="Received";
    try {
        purchase.setDateStatus(id, receivedDate, status);
    } catch (SQLException ex) {
        Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTable1.setModel(new DefaultTableModel(
        null,
           new Object[]{
               "Purchase Id",
               "User Id",
               "User Name",
               "User Phone",
               "Product Id",
               "Product Name",
               "Quantity",
               "Price",
               "Total",
               "Purchase Date",
               "Address",
               "Received Date",
               "Supplier Name",
               "Status"
           }
        ));
    try {
        purchase.getOnTheWayProduct(jTable1, "", "");
        
    } catch (SQLException ex) {
        Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_jTable1KeyReleased

 
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(()-> {
        
            try {
                new Delivery().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Delivery.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
