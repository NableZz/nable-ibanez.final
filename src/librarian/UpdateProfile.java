
package librarian;

import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UpdateProfile extends javax.swing.JFrame {

    
    public UpdateProfile() {
        initComponents();
    }

    //get data from database and set to session
    public void updateDetails(int id){
        dbConnector connector = new dbConnector();
        try{
            String query = "SELECT * FROM librarian  WHERE lib_id = '" + id + "'";
            ResultSet resultSet = connector.getData(query);
            if(resultSet.next()) {
                Session session = Session.getInstance();
                session.setId(resultSet.getInt("lib_id"));
                session.setFullname("" + resultSet.getString("lib_name"));
                session.setContactNumber("" + resultSet.getString("lib_contactnumber"));
                session.setGender("" + resultSet.getString("lib_gender"));
                session.setAddress("" + resultSet.getString("lib_address"));
                session.setPassword("" + resultSet.getString("lib_password"));
                session.setStatus("" + resultSet.getString("lib_status"));
            }
        }catch (SQLException ex) {
            System.out.println("Invalid Connection" + ex.getMessage());            
        }
    }
    
    //set userdata to UserUpdateProfile
    public void setDetails(){
        Session session = Session.getInstance();
        jFullName.setText("" + session.getFullname());
        jContactNumber.setText("" + session.getContactNumber());
        jGender.setSelectedItem(session.getGender());
        jAddress.setText("" + session.getAddress());
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jFullName = new javax.swing.JTextField();
        jGender = new javax.swing.JComboBox<>();
        jContactNumber = new javax.swing.JTextField();
        jAddress = new javax.swing.JTextField();
        jRegisterButton = new javax.swing.JButton();
        jLoginButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jContactNumberLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("UPDATE PROFILE INFORMATION");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(290, 70, 380, 32);

        jFullName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jFullName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jFullName);
        jFullName.setBounds(120, 180, 240, 35);

        jGender.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        jGender.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jGender);
        jGender.setBounds(660, 180, 180, 35);

        jContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jContactNumber.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jContactNumber);
        jContactNumber.setBounds(390, 180, 240, 35);

        jAddress.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jAddress.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jAddress);
        jAddress.setBounds(120, 270, 720, 35);

        jRegisterButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRegisterButton.setText("SAVE CHANGES");
        jRegisterButton.setFocusPainted(false);
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jRegisterButton);
        jRegisterButton.setBounds(250, 400, 220, 30);

        jLoginButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLoginButton.setForeground(new java.awt.Color(255, 0, 0));
        jLoginButton.setText("CANCEL");
        jLoginButton.setFocusPainted(false);
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });
        jPanel1.add(jLoginButton);
        jLoginButton.setBounds(500, 400, 220, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Full Name");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(120, 210, 90, 30);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Gender");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(660, 210, 90, 30);

        jContactNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jContactNumberLabel.setText("Contact Number");
        jPanel1.add(jContactNumberLabel);
        jContactNumberLabel.setBounds(400, 210, 140, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setText("Address");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(120, 300, 90, 30);

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void jRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButtonActionPerformed
        String fullname = jFullName.getText();
        String contactnumber = jContactNumber.getText();
        String gender = (String)jGender.getSelectedItem();
        String address = jAddress.getText();
        Session session = Session.getInstance();
        int id = session.getId();
        //check if all textfields is empty
        if(fullname.isEmpty() || contactnumber.isEmpty() || address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields");
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


        //update data to database
        dbConnector dbc = new dbConnector();
        String query = "UPDATE employee SET "
        + "u_fullname = '" + fullname + "', "
        + "u_contactnumber = '"+ contactnumber +"', "
        + "u_gender = '"+ gender +"', "
        + "u_address = '"+ address +"' "
        + "WHERE u_id = '"+ id +"'";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Register Successfully");
            updateDetails(id);//update data to session
            Profile profile = new Profile();
            profile.setVisible(true);
            profile.pack();
            profile.setLocationRelativeTo(null);
            this.dispose();

        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jRegisterButtonActionPerformed

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        Profile profile = new Profile();
        profile.setVisible(true);
        profile.pack();
        profile.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private javax.swing.JTextField jContactNumber;
    private javax.swing.JLabel jContactNumberLabel;
    private javax.swing.JTextField jFullName;
    private javax.swing.JComboBox<String> jGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jRegisterButton;
    // End of variables declaration//GEN-END:variables
}
