
package librarian;

import config.Session;
import config.dbConnector;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ChangePassword extends javax.swing.JFrame {

    
    public ChangePassword() {
        initComponents();
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
    //get data from databse and set data to session
    public void updateDetails(int id){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM librarian  WHERE lib_id = '" + id + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()) {
                Session session = Session.getInstance();
                session.setPassword("" + resultSet.getString("lib_password"));
            }
        }catch (SQLException ex) {
            System.out.println("Invalid Connection" + ex.getMessage());            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jUsername = new javax.swing.JTextField();
        jCancelButton = new javax.swing.JButton();
        jNewPasswordField = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPassword = new javax.swing.JLabel();
        jConfirmPassword = new javax.swing.JLabel();
        jOldPassword = new javax.swing.JPasswordField();
        jSaveButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jConfirmNewPassword = new javax.swing.JPasswordField();
        jConfirmPassword1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIGNUP");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel2.setLayout(null);

        jUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(jUsername);
        jUsername.setBounds(60, 180, 220, 30);

        jCancelButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jCancelButton.setForeground(new java.awt.Color(255, 0, 0));
        jCancelButton.setText("CANCEL");
        jCancelButton.setFocusPainted(false);
        jCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelButtonActionPerformed(evt);
            }
        });
        jPanel2.add(jCancelButton);
        jCancelButton.setBounds(300, 350, 220, 30);

        jNewPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jNewPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(jNewPasswordField);
        jNewPasswordField.setBounds(60, 260, 220, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Librarian ID");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(60, 210, 80, 20);

        jPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPassword.setText("Old Password");
        jPanel2.add(jPassword);
        jPassword.setBounds(300, 210, 100, 20);

        jConfirmPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmPassword.setText("New Password");
        jPanel2.add(jConfirmPassword);
        jConfirmPassword.setBounds(60, 290, 120, 20);

        jOldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jOldPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(jOldPassword);
        jOldPassword.setBounds(300, 180, 220, 30);

        jSaveButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jSaveButton.setText("SAVE CHANGES");
        jSaveButton.setFocusPainted(false);
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });
        jPanel2.add(jSaveButton);
        jSaveButton.setBounds(60, 350, 220, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("UPDATE PASSWORD");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(170, 80, 250, 32);

        jConfirmNewPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmNewPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.add(jConfirmNewPassword);
        jConfirmNewPassword.setBounds(300, 260, 220, 30);

        jConfirmPassword1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jConfirmPassword1.setText("Confirm New Password");
        jPanel2.add(jConfirmPassword1);
        jConfirmPassword1.setBounds(300, 290, 160, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Password Background.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 580, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelButtonActionPerformed
        Profile profile = new Profile();
        profile.setVisible(true);
        profile.pack();
        profile.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jCancelButtonActionPerformed

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        Session session = Session.getInstance();
        String password = session.getPassword();  
        String hashPassword = passwordHash(jOldPassword.getText()); //hashpassword
        String newPassword = jNewPasswordField.getText();
        String confirmNewPassword = jConfirmNewPassword.getText();
        String newPasswordHash = passwordHash(newPassword); //new hashpassword
        int ID = session.getId();
        
        //check if textfields is empty
        if(newPassword.isEmpty() || confirmNewPassword.isEmpty() || jOldPassword.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }
        //check if password length is less than 8 characters
        if(newPassword.length() < 8 || confirmNewPassword.length() < 8){
            JOptionPane.showMessageDialog(null, "Password must at least 8 characters");
            return;
        }
        //check if old password is correct
        if(!password.equals(hashPassword)){
            JOptionPane.showMessageDialog(null, "Incorrect Old Password");
            return;
        }
        //check if new password and confirm new password is match
        if(!newPassword.equals(confirmNewPassword)){
            JOptionPane.showMessageDialog(null, "New Password and Confirm Password does not match");
            return;
        }
        
        //update password to database
        dbConnector dbc = new dbConnector();
        String query = "UPDATE librarian SET "
                + "lib_password = '"+ newPasswordHash +"' "
                + "WHERE lib_id = '"+ ID +"'";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Update Successfully");
            updateDetails(ID);
            Profile profile = new Profile();
            profile.setVisible(true);
            profile.pack();
            profile.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session session = Session.getInstance();
        jUsername.setText("" + session.getId());
        jUsername.setEditable(false);
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jCancelButton;
    private javax.swing.JPasswordField jConfirmNewPassword;
    private javax.swing.JLabel jConfirmPassword;
    private javax.swing.JLabel jConfirmPassword1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jNewPasswordField;
    private javax.swing.JPasswordField jOldPassword;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jPassword;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}
