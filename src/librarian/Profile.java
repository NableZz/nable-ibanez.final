
package librarian;

import config.Session;
import library.management.system.*;


public class Profile extends javax.swing.JFrame {

    
    public Profile() {
        initComponents();
        displayUser_Role();
    }

    //display user profile data
    public void displayUser_Role(){
        Session session = Session.getInstance();
        jFullName.setText("" + session.getFullname());
        jID.setText("" + session.getId());
        jContactNumber.setText("" + session.getContactNumber());
        jGender.setText("" + session.getGender());
        jAddress.setText("" + session.getAddress());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jAdminName = new javax.swing.JLabel();
        jAdminRole9 = new javax.swing.JLabel();
        jFullName = new javax.swing.JLabel();
        jAdminRole3 = new javax.swing.JLabel();
        jID = new javax.swing.JLabel();
        jAdminRole4 = new javax.swing.JLabel();
        jContactNumber = new javax.swing.JLabel();
        jAdminRole6 = new javax.swing.JLabel();
        jGender = new javax.swing.JLabel();
        jAdminRole7 = new javax.swing.JLabel();
        jAddress = new javax.swing.JLabel();
        jUpdateProfile = new javax.swing.JButton();
        jChnagePassword = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(55, 50, 90, 90);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Librarian");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(67, 140, 80, 20);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Logout");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(30, 300, 140, 30);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Dashboard");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(30, 180, 140, 30);

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setText("Manage Books");
        jButton9.setFocusPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9);
        jButton9.setBounds(30, 210, 140, 30);

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(51, 51, 51));
        jButton10.setText("Profile");
        jButton10.setFocusPainted(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10);
        jButton10.setBounds(30, 270, 140, 30);

        jAdminName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jAdminName.setText("PROFILE INFORMATION");
        jPanel1.add(jAdminName);
        jAdminName.setBounds(320, 90, 280, 30);

        jAdminRole9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jAdminRole9.setText("NAME:");
        jPanel1.add(jAdminRole9);
        jAdminRole9.setBounds(320, 150, 60, 16);

        jFullName.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jFullName.setText("FULLNAME");
        jFullName.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jFullName);
        jFullName.setBounds(520, 150, 230, 20);

        jAdminRole3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jAdminRole3.setText("LIBRARIAN ID:");
        jPanel1.add(jAdminRole3);
        jAdminRole3.setBounds(320, 180, 120, 16);

        jID.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jID.setText("ID NUMBER");
        jID.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jID);
        jID.setBounds(520, 180, 250, 20);

        jAdminRole4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jAdminRole4.setText("CONTACT NUMBER:");
        jPanel1.add(jAdminRole4);
        jAdminRole4.setBounds(320, 210, 170, 16);

        jContactNumber.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jContactNumber.setText("CONTACT NUMBER");
        jContactNumber.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jContactNumber);
        jContactNumber.setBounds(520, 210, 250, 20);

        jAdminRole6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jAdminRole6.setText("GENDER:");
        jPanel1.add(jAdminRole6);
        jAdminRole6.setBounds(320, 240, 80, 16);

        jGender.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jGender.setText("GENDER");
        jGender.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jGender);
        jGender.setBounds(520, 240, 210, 20);

        jAdminRole7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jAdminRole7.setText("ADDRESS:");
        jPanel1.add(jAdminRole7);
        jAdminRole7.setBounds(320, 270, 90, 16);

        jAddress.setFont(new java.awt.Font("Segoe UI Semibold", 0, 17)); // NOI18N
        jAddress.setText("ADDRESS");
        jAddress.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jAddress);
        jAddress.setBounds(520, 270, 240, 20);

        jUpdateProfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jUpdateProfile.setText("UPDATE PROFILE");
        jUpdateProfile.setFocusPainted(false);
        jUpdateProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateProfileActionPerformed(evt);
            }
        });
        jPanel1.add(jUpdateProfile);
        jUpdateProfile.setBounds(310, 390, 190, 30);

        jChnagePassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jChnagePassword.setText("CHANGE PASSWORD");
        jChnagePassword.setFocusPainted(false);
        jChnagePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChnagePasswordActionPerformed(evt);
            }
        });
        jPanel1.add(jChnagePassword);
        jChnagePassword.setBounds(520, 390, 190, 30);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Transactions");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(30, 240, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/DashboardBackground.png"))); // NOI18N
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
        Dashboard DashboardFrame = new Dashboard();
        DashboardFrame.setVisible(true);
        DashboardFrame.pack();
        DashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ManageBooks MB = new ManageBooks();
        MB.setVisible(true);
        MB.pack();
        MB.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        Profile profile = new Profile();
        profile.setVisible(true);
        profile.pack();
        profile.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        displayUser_Role();
    }//GEN-LAST:event_formWindowActivated

    private void jUpdateProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateProfileActionPerformed
        UpdateProfile up = new UpdateProfile();
        up.setVisible(true);
        up.pack();
        up.setLocationRelativeTo(null);
        up.setDetails();
        this.dispose();
    }//GEN-LAST:event_jUpdateProfileActionPerformed

    private void jChnagePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChnagePasswordActionPerformed
        ChangePassword cp = new ChangePassword();
        cp.setVisible(true);
        cp.pack();
        cp.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jChnagePasswordActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Transactions TS = new Transactions();
        TS.setVisible(true);
        TS.pack();
        TS.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jAddress;
    private javax.swing.JLabel jAdminName;
    private javax.swing.JLabel jAdminRole3;
    private javax.swing.JLabel jAdminRole4;
    private javax.swing.JLabel jAdminRole6;
    private javax.swing.JLabel jAdminRole7;
    private javax.swing.JLabel jAdminRole9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jChnagePassword;
    private javax.swing.JLabel jContactNumber;
    private javax.swing.JLabel jFullName;
    private javax.swing.JLabel jGender;
    private javax.swing.JLabel jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jUpdateProfile;
    // End of variables declaration//GEN-END:variables
}
