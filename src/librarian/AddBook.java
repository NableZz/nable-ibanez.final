
package librarian;

import config.dbConnector;
import java.text.SimpleDateFormat;
import library.management.system.*;
import javax.swing.JOptionPane;


public class AddBook extends javax.swing.JFrame {


    public AddBook() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jAuthor = new javax.swing.JTextField();
        jTitle = new javax.swing.JTextField();
        jGenre = new javax.swing.JComboBox<>();
        jQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLoginButton = new javax.swing.JButton();
        jISBN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Addbook");
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Book Details");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 70, 260, 60);

        jAuthor.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jAuthor);
        jAuthor.setBounds(60, 300, 360, 32);

        jTitle.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jTitle);
        jTitle.setBounds(60, 230, 590, 32);

        jGenre.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biography", "History", "Programming" }));
        jGenre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jGenre.setFocusable(false);
        jPanel1.add(jGenre);
        jGenre.setBounds(440, 160, 210, 32);

        jQuantity.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jQuantity);
        jQuantity.setBounds(440, 300, 210, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Author");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 330, 80, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("ISBN");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 190, 80, 22);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Genre");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(440, 190, 130, 22);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Quantity");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(440, 330, 130, 22);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("ADD BOOK");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(150, 410, 200, 32);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Book Title");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(60, 260, 80, 22);

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
        jLoginButton.setBounds(380, 410, 200, 32);

        jISBN.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jISBN);
        jISBN.setBounds(60, 160, 360, 32);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/DashboardBackground.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String ISBN = jISBN.getText();
        String title = jTitle.getText();
        String genre = (String)jGenre.getSelectedItem();
        String author = jAuthor.getText();
        String quantity = jQuantity.getText();
        
        //check if all textfields is empty
        if(ISBN.isEmpty() || title.isEmpty() || genre.isEmpty() || author.isEmpty() || quantity.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please fill all fields");
            return;
        }
        
        //check if quantity is number
        if(!quantity.matches("\\d+")){
            JOptionPane.showMessageDialog(null,"Invalid quantity.");
            return;
        }    

        //insert data to database
        dbConnector dbc = new dbConnector();
        String query = "INSERT INTO books ( book_isbn, book_title, book_genre, book_author, book_quantity) VALUES ("
                + "'" + ISBN + "',"
                + "'"+ title +"',"
                + "'"+ genre +"',"
                + "'"+ author +"',"
                + "'"+ quantity +"')";
        if(dbc.insertData(query)){
            JOptionPane.showMessageDialog(null, "Book added Successfully");
            ManageBooks MB = new ManageBooks();
            MB.setVisible(true);
            MB.pack();
            MB.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        ManageBooks mb = new ManageBooks();
        mb.setVisible(true);
        mb.pack();
        mb.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAuthor;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jGenre;
    private javax.swing.JTextField jISBN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jQuantity;
    private javax.swing.JTextField jTitle;
    // End of variables declaration//GEN-END:variables
}
