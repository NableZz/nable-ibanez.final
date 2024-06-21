
package library.management.system;

import config.dbConnector;
import java.security.MessageDigest;
import javax.swing.JOptionPane;


public class Signup extends javax.swing.JFrame {

    
    public Signup() {
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlib_name = new javax.swing.JTextField();
        jlib_contact = new javax.swing.JTextField();
        jlib_address = new javax.swing.JTextField();
        jlib_password = new javax.swing.JPasswordField();
        jlib_confirmpassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlib_gender = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Signup");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Librarian Registration Form");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 40, 480, 90);

        jlib_name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlib_name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jlib_name);
        jlib_name.setBounds(160, 170, 280, 32);

        jlib_contact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlib_contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jlib_contact);
        jlib_contact.setBounds(460, 170, 200, 32);

        jlib_address.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlib_address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jlib_address);
        jlib_address.setBounds(160, 250, 650, 32);

        jlib_password.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jlib_password);
        jlib_password.setBounds(160, 330, 310, 32);

        jlib_confirmpassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jlib_confirmpassword);
        jlib_confirmpassword.setBounds(490, 330, 320, 32);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 51));
        jButton1.setText("Login");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(270, 450, 200, 32);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Register");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(490, 450, 200, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 16)); // NOI18N
        jLabel5.setText("Full Name");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(160, 200, 100, 22);

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setText("Contact Number");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(470, 200, 150, 22);

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setText("Address");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(160, 280, 120, 22);

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setText("Gender");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(680, 200, 120, 22);

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel11.setText("Password");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(160, 360, 120, 22);

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText("Confirm Password");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(490, 360, 140, 22);

        jlib_gender.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jlib_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jlib_gender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jlib_gender);
        jlib_gender.setBounds(680, 170, 130, 32);

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
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String fullname = jlib_name.getText();
        String contactnumber = jlib_contact.getText();
        String gender = (String)jlib_gender.getSelectedItem();
        String address = jlib_address.getText();
        String password = jlib_password.getText();
        String repassword = jlib_confirmpassword.getText();
        String hashPassword = passwordHash(password); //hashpassword
        //check all textfield is empty
        if(fullname.isEmpty() || contactnumber.isEmpty() || address.isEmpty() || password.isEmpty() || repassword.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill in all fields");
            return;
        }
        
        //check if contact number contain number
        if(!contactnumber.matches("\\d+")){
            JOptionPane.showMessageDialog(null,"Contact number should only contain digits.");
            return;
        }
        //Check if contact number length is not 11 digits
        if(contactnumber.length() != 11) {
            JOptionPane.showMessageDialog(null,"Contact number must be 11 digits.");
            return;
        }
        //check if password length is less than 8 characters
        if(password.length() < 8 || repassword.length() < 8){
            JOptionPane.showMessageDialog(null, "Password must at least 8 characters");
            return;
        }
        //check if password and confirm password does not match
        if(!password.equals(repassword)){
            JOptionPane.showMessageDialog(null, "Password does not match");
            return;
        }
 
        //inserting data to database
        dbConnector dbc = new dbConnector();
        String query = "INSERT INTO librarian ( lib_name, lib_contactnumber, lib_gender, lib_address, lib_password, lib_status) VALUES ("
                + "'" + fullname + "',"
                + "'"+ contactnumber +"',"
                + "'"+ gender +"',"
                + "'"+ address +"',"
                + "'"+ hashPassword +"',"
                + "'INACTIVE')";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Register Successfully");
            Login LoginFrame = new Login();
            LoginFrame.setVisible(true);
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
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
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jlib_address;
    private javax.swing.JPasswordField jlib_confirmpassword;
    private javax.swing.JTextField jlib_contact;
    private javax.swing.JComboBox<String> jlib_gender;
    private javax.swing.JTextField jlib_name;
    private javax.swing.JPasswordField jlib_password;
    // End of variables declaration//GEN-END:variables
}
