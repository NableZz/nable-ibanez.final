
package library.management.system;

import admin.AdminPage;
import config.Session;
import config.dbConnector;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import librarian.Dashboard;


public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
    }

    //function to get user position
    private static boolean loginAccount(int id, String password){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM librarian  WHERE lib_id = '" + id + "' AND lib_password = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                //get user data and set data to session
                Session session = Session.getInstance();
                session.setId(resultSet.getInt("lib_id"));
                session.setFullname("" + resultSet.getString("lib_name"));
                session.setContactNumber("" + resultSet.getString("lib_contactnumber"));
                session.setGender("" + resultSet.getString("lib_gender"));
                session.setAddress("" + resultSet.getString("lib_address"));
                session.setPassword("" + resultSet.getString("lib_password"));
                session.setStatus("" + resultSet.getString("lib_status"));
                
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex) {
            System.out.println("Invalid loginAccount Connection" + ex.getMessage());
            return false;
        }
    }
    
    //function to hash password
    public String passwordHash(String password){
        try{
            MessageDigest messagedigest = MessageDigest.getInstance("SHA");
            byte[] hashbyte = messagedigest.digest(password.getBytes());
            StringBuilder stringbuilder = new StringBuilder();
            
            for(byte bytes : hashbyte){
                stringbuilder.append(String.format("%02x",bytes));
            }
            
            return stringbuilder.toString();
        }catch(Exception ex){
            System.out.println("Password Hash Error: " + ex.getMessage() );
            return null;
        }
    }
    
    //function to get user status
    private static String loginStatus(int id, String password){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT lib_status FROM librarian  WHERE lib_id = '" + id + "' AND lib_password = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()){
                return resultSet.getString("lib_status");
            }else{
                return null;
            }
        }catch (SQLException ex) {
            System.out.println("Invalid loginStatus Connection" + ex.getMessage());
            return null;
        }
    }
    
    //check if admin id and pass is correct
    public static boolean loginAccountAdmin(int id, String password){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM admin  WHERE admin_id = '" + id + "' AND admin_password = '" + password + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()) {
                return true;
            }else{
                return false;
            }
        }catch (SQLException ex) {
            System.out.println("Invalid Connection" + ex.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLib_ID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLib_Password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText("Username");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(320, 200, 80, 22);

        jLib_ID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLib_ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jLib_ID);
        jLib_ID.setBounds(400, 190, 220, 32);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(320, 260, 80, 22);

        jLib_Password.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLib_Password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jLib_Password);
        jLib_Password.setBounds(400, 250, 220, 32);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Login");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 310, 220, 30);

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCheckBox1.setText("Show Password");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(530, 280, 93, 23);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("I don't have an account");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(320, 380, 150, 20);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Register");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(470, 370, 150, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText(" LIBRARY SYSTEM");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(320, 70, 310, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel6.setText("MINI");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(430, 20, 110, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ITECH.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int userID;
        try {
            userID = Integer.valueOf(jLib_ID.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Invalid user ID");
            return;
        }
 
        String password = passwordHash(jLib_Password.getText());
        
        String status = loginStatus(userID,password);
        if(loginAccountAdmin(userID, password)){
            JOptionPane.showMessageDialog(null, "Login Success");         
            AdminPage adminFrame = new AdminPage();
            adminFrame.setVisible(true);
            adminFrame.pack();
            adminFrame.setLocationRelativeTo(null);
            this.dispose(); 
        }else{
            if(status != null){
                if(status.equalsIgnoreCase("ACTIVE")){
                    if(loginAccount(userID, password)){
                        JOptionPane.showMessageDialog(null, "Login Success");
                        Dashboard DashboardFrame = new Dashboard();
                        DashboardFrame.setVisible(true);
                        DashboardFrame.pack();
                        DashboardFrame.setLocationRelativeTo(null);
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid UserID and password");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Account is InActive");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid UserID and password");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if(jCheckBox1.isSelected()) {
            jLib_Password.setEchoChar((char)0);
        }else {
            jLib_Password.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Signup SignupFrame = new Signup();
        SignupFrame.setVisible(true);
        SignupFrame.pack();
        SignupFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jLib_ID;
    private javax.swing.JPasswordField jLib_Password;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
