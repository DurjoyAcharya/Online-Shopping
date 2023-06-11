/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package admin;

import static admin.AdminDashboard.jLabel37;
import static admin.AdminDashboard.jLabel38;
import static admin.AdminDashboard.jPanel4;
import dao.UserDao;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import user.UserDashboard;

/**
 *
 * @author rupkotha
 */
public class ManageUsers extends javax.swing.JFrame {
    public UserDao user;
    private String[] values;
    private int uid;
    public Color text=new Color(102,120,238);
    public Color primary=new Color(42,58,73);
    
    public ManageUsers() throws SQLException {
        user=new UserDao();
        values=new String[9];
        initComponents();
        init();
        
    }

    
    private void init() throws SQLException {
        uid = user.getUserId("monir@buet.ac.bd");//UserDashboard.userEmail.getText()
        values=user.getUserData(uid);//
        setValue();
    }
     private void setValue() {
        jTextField1.setText(values[0]);
        jTextField2.setText(values[1]);
        jTextField3.setText(values[2]);
        jPasswordField1.setText(values[3]);
        jTextField4.setText(values[4]);
        jTextField5.setText(values[6]);
        jTextField6.setText(values[7]);
        jTextField7.setText(values[8]);
        

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 213, 128));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 213, 128));
        jPanel1.setForeground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 300, 30));

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 300, 30));

        jTextField3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 300, 30));

        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 300, 30));

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favourite color?", "What is your family name?", "What is your first school name?", "What is your pet name?", "What is your first car?" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 300, 30));

        jTextField4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 300, 30));

        jTextField5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 300, 30));

        jTextField6.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 300, 30));

        jTextField7.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 300, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("User ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Username");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Email");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 40, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Password");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 80, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Phone no");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 70, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Security Question");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, 20));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Answer");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, -1, 20));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Address Line1(State & Area)");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 210, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Address Line2 (Country)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, -1));

        btnClear.setBackground(new java.awt.Color(7, 222, 152));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 300, 30));

        jLabel13.setBackground(new java.awt.Color(0, 0, 0));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hide.png"))); // NOI18N
        jLabel13.setText("jLabel10");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 30, 30));

        btnUpdate.setBackground(new java.awt.Color(7, 222, 152));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 140, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("x");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 20, 30));

        btnDelete1.setBackground(new java.awt.Color(7, 222, 152));
        btnDelete1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        setVisible(false);
     
        AdminDashboard.jLabel37.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
      clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        user.deleteUserdata(Integer.parseInt(jTextField1.getText()));
        this.dispose();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        int id=Integer.parseInt(jTextField1.getText());
        String name=jTextField2.getText();
        String email=jTextField2.getText();
        String pass=String.valueOf(jPasswordField1.getPassword());
        String phone=jTextField4.getText();
        String seq=jComboBox1.getSelectedItem().toString();
        var ans=jTextField5.getText();
        var address1=jTextField6.getText();
        var address2=jTextField7.getText();
        try {
            user.updateUser(id,name,email,pass,phone,seq,ans,address1,address2);
        } catch (SQLException ex) {
            Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

     private void clear(){
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jPasswordField1.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");                                      
    }
     
    
     
     
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(()-> {
            try {
                new ManageUsers().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ManageUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
