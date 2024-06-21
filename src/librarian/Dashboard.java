
package librarian;

import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import library.management.system.*;


public class Dashboard extends javax.swing.JFrame {

    
    public Dashboard() {
        initComponents();
    }

    //get number of librabrian
    public int numberOfLibrarian() {
        int lib_count = 0;
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT COUNT(*) AS lib_count FROM librarian WHERE lib_status = 'ACTIVE'";
            ResultSet resultset = dbc.getData(query);
            if (resultset.next()) {
                lib_count = resultset.getInt("lib_count");
                resultset.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error fetching librarian count: " + ex.getMessage());
        }
        return lib_count;
    }
    
    // Get the total number of books based on the book_quantity field
    public int numberOfBooks() {
        int totalBooks = 0;
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT SUM(book_quantity) AS total_books FROM books";
            ResultSet resultSet = dbc.getData(query);
            if (resultSet.next()) {
                totalBooks = resultSet.getInt("total_books");
                resultSet.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error fetching total number of books: " + ex.getMessage());
        }
        return totalBooks;
    }
    
    //get number of borrow books
    public int numberOfBorrowBooks() {
        int book_borrow_count = 0;
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT SUM(number_book_borrow) AS total_books_borrow FROM transactions";
            ResultSet resultset = dbc.getData(query);
            if (resultset.next()) {
                book_borrow_count = resultset.getInt("total_books_borrow");
                resultset.close();
            }
        } catch (SQLException ex) {
            System.err.println("Error fetching book_borrow count: " + ex.getMessage());
        }
        return book_borrow_count;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jBorrow_Books = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLib_Count = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLib_Books = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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

        jPanel2.setBackground(new java.awt.Color(224, 251, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel2.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("BORROW BOOKS");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 70, 160, 20);

        jBorrow_Books.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jBorrow_Books.setForeground(new java.awt.Color(0, 102, 51));
        jPanel2.add(jBorrow_Books);
        jBorrow_Books.setBounds(0, 30, 190, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(450, 320, 190, 110);

        jPanel3.setBackground(new java.awt.Color(224, 251, 226));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel3.setLayout(null);

        jLib_Count.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLib_Count.setForeground(new java.awt.Color(0, 102, 51));
        jPanel3.add(jLib_Count);
        jLib_Count.setBounds(0, 30, 190, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("LIBRARIAN");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(50, 70, 110, 20);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(320, 170, 190, 110);

        jPanel4.setBackground(new java.awt.Color(224, 251, 226));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel4.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("ALL BOOKS");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(50, 70, 110, 20);

        jLib_Books.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLib_Books.setForeground(new java.awt.Color(0, 102, 51));
        jPanel4.add(jLib_Books);
        jLib_Books.setBounds(0, 30, 190, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(570, 170, 190, 110);

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel8.setText("MINI");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(500, 20, 110, 40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText(" LIBRARY SYSTEM");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 70, 310, 40);

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
        jLib_Count.setHorizontalAlignment(SwingConstants.CENTER);
        jLib_Count.setText("" + numberOfLibrarian());
        jLib_Books.setHorizontalAlignment(SwingConstants.CENTER);
        jLib_Books.setText("" + numberOfBooks());
        jBorrow_Books.setHorizontalAlignment(SwingConstants.CENTER);
        jBorrow_Books.setText("" + numberOfBorrowBooks());
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBorrow_Books;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLib_Books;
    private javax.swing.JLabel jLib_Count;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
