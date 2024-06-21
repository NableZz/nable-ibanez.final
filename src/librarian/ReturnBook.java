
package librarian;

import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class ReturnBook extends javax.swing.JFrame {
    
   
    public ReturnBook() {
        initComponents();
    }

    //search transaction info
    public void searchTransaction(){
        String trans_ID = jTransactionID.getText();
        if (!trans_ID.isEmpty()) {
            try {
                dbConnector dbc = new dbConnector();
                String query = "SELECT book_isbn, student_id, number_book_borrow FROM transactions WHERE trans_id =  '"+trans_ID+"'";
                ResultSet rs = dbc.getData(query);
                if(rs.next()){                    
                    jISBN.setText("" + rs.getString("book_isbn"));
                    jStudentID.setText("" + rs.getString("student_id"));
                    jQuantityReturn.setText("" + rs.getString("number_book_borrow"));
                    searchBookData();
                    searchStudentData();
                }else{
                    jISBN.setText("");
                    jStudentID.setText("");
                    jQuantityReturn.setText("");
                }
                rs.close();
            }catch (SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }
        } else {
            // If search field is empty
            jISBN.setText("");
            jStudentID.setText("");
            jQuantityReturn.setText("");
        }
    }
    
    //search student info
    public void searchStudentData(){
        String studentID = jStudentID.getText();
        if (!studentID.isEmpty()) {
            try {               
                dbConnector dbc = new dbConnector();
                String query = "SELECT student_name, student_department FROM students WHERE student_id =  '"+studentID+"'";
                ResultSet rs = dbc.getData(query);
                if(rs.next()){                    
                    jStudentName.setText("" + rs.getString("student_name"));
                    jDepartment.setText("" + rs.getString("student_department"));
                }else{
                    jStudentName.setText("");
                    jDepartment.setText("");
                }
                rs.close();
            }catch (SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }
        } else {
            // If search field is empty
            jStudentName.setText("");
            jDepartment.setText("");
        }
    }
    
    //search book info
    public void searchBookData(){
        String ISBN = jISBN.getText();
        if (!ISBN.isEmpty()) {
            try {
                dbConnector dbc = new dbConnector();
                String query = "SELECT book_title, book_author, book_quantity FROM books WHERE book_isbn =  '"+ISBN+"'";
                ResultSet rs = dbc.getData(query);
                if(rs.next()){                    
                    jTitle.setText("" + rs.getString("book_title"));
                    jAuthor.setText("" + rs.getString("book_author"));
                }else{
                    jTitle.setText("");
                    jAuthor.setText("");
                }
                rs.close();
            }catch (SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }
        } else {
            // If search field is empty
            jTitle.setText("");
            jAuthor.setText("");
        }
    }
    
    //get book quantity
    public int getBookQuantity(String ISBN){
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT book_quantity FROM books WHERE book_isbn = '" + ISBN + "'";
            ResultSet rs = dbc.getData(query);
            if (rs.next()) {
                return rs.getInt("book_quantity");
            }
            rs.close();
            return 0;
        } catch (SQLException ex) {
            System.out.println("Error updating book quantity: " + ex.getMessage());
            return 0;
        }
    }
    
    // Update book quantity after borrowing
    public void updateBookQuantity(int trans_id, int returnQuantity, String ISBN) {
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT number_book_borrow FROM transactions WHERE trans_id = '" + trans_id + "'";
            ResultSet rs = dbc.getData(query);
            if (rs.next()) {
                int currentQuantity = rs.getInt("number_book_borrow");
                int newQuantity = currentQuantity - returnQuantity;
                int bookQuantity = getBookQuantity(ISBN) + returnQuantity;
                if(newQuantity == 0){
                    String updateQuery = "UPDATE transactions SET number_book_borrow = '" + newQuantity + "',trans_status = 'RETURN' WHERE trans_id = '" + trans_id + "'";
                    String Query = "UPDATE books SET book_quantity = '" + bookQuantity + "'WHERE book_isbn = '" + ISBN + "'";
                    dbc.insertData(updateQuery);
                    dbc.insertData(Query);
                }else{
                    String updateQuery = "UPDATE transactions SET number_book_borrow = " + newQuantity + " WHERE trans_id = '" + trans_id + "'";
                    String Query = "UPDATE books SET book_quantity = '" + bookQuantity + "'WHERE book_isbn = '" + ISBN + "'";
                    dbc.insertData(updateQuery);
                    dbc.insertData(Query);
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error updating book quantity: " + ex.getMessage());
        }
    }
    
    public boolean studentExist(String studentID){
        try {
            dbConnector dbc = new dbConnector();
            String studentQuery = "SELECT * FROM students WHERE student_id = '" + studentID + "'";
            ResultSet studentRs = dbc.getData(studentQuery);
            if (!studentRs.next()) {
                return false;
            }
            studentRs.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error retrieving student data: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean bookExist(String ISBN) {
        try {
            dbConnector dbc = new dbConnector();
            String bookQuery = "SELECT * FROM books WHERE book_isbn = '" + ISBN + "'";
            ResultSet bookRs = dbc.getData(bookQuery);
            if (!bookRs.next()) {
                return false;  // Book ISBN not found
            }
            bookRs.close();
            return true;  // Book ISBN found
        } catch (SQLException ex) {
            System.out.println("Error retrieving book data: " + ex.getMessage());
            return false;  // Error occurred while checking
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jStudentID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jQuantityReturn = new javax.swing.JTextField();
        jISBN = new javax.swing.JTextField();
        jDepartment = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTitle = new javax.swing.JTextField();
        jAuthor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jStudentName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jBorrowBook = new javax.swing.JButton();
        jLoginButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTransactionID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("RETURNING A BOOKS");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(310, 20, 380, 50);

        jStudentID.setEditable(false);
        jStudentID.setBackground(new java.awt.Color(255, 255, 255));
        jStudentID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jStudentID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jStudentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jStudentIDKeyReleased(evt);
            }
        });
        jPanel1.add(jStudentID);
        jStudentID.setBounds(240, 320, 270, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Student ID");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 330, 90, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Enter Transaction ID");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 110, 160, 22);

        jQuantityReturn.setBackground(new java.awt.Color(255, 255, 255));
        jQuantityReturn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jQuantityReturn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jQuantityReturn);
        jQuantityReturn.setBounds(540, 170, 250, 32);

        jISBN.setEditable(false);
        jISBN.setBackground(new java.awt.Color(255, 255, 255));
        jISBN.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jISBNKeyReleased(evt);
            }
        });
        jPanel1.add(jISBN);
        jISBN.setBounds(240, 170, 270, 32);

        jDepartment.setEditable(false);
        jDepartment.setBackground(new java.awt.Color(255, 255, 255));
        jDepartment.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDepartment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jDepartment);
        jDepartment.setBounds(540, 380, 250, 32);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Author");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(540, 260, 110, 22);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Book Title");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 260, 90, 22);

        jTitle.setEditable(false);
        jTitle.setBackground(new java.awt.Color(255, 255, 255));
        jTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jTitle);
        jTitle.setBounds(150, 230, 360, 32);

        jAuthor.setEditable(false);
        jAuthor.setBackground(new java.awt.Color(255, 255, 255));
        jAuthor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jAuthor);
        jAuthor.setBounds(540, 230, 250, 32);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Number of copies to return");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(540, 200, 220, 22);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Department");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(540, 410, 110, 22);

        jStudentName.setEditable(false);
        jStudentName.setBackground(new java.awt.Color(255, 255, 255));
        jStudentName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jStudentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jStudentName);
        jStudentName.setBounds(150, 380, 360, 32);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Student Name");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(150, 410, 120, 22);

        jBorrowBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBorrowBook.setText("RETURN BOOK");
        jBorrowBook.setFocusPainted(false);
        jBorrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrowBookActionPerformed(evt);
            }
        });
        jPanel1.add(jBorrowBook);
        jBorrowBook.setBounds(540, 460, 250, 32);

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
        jLoginButton.setBounds(280, 460, 230, 32);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setText("Book ISBN");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(150, 180, 80, 22);

        jTransactionID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTransactionID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTransactionID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTransactionIDKeyReleased(evt);
            }
        });
        jPanel1.add(jTransactionID);
        jTransactionID.setBounds(310, 100, 200, 32);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

    private void jBorrowBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBorrowBookActionPerformed
        String ISBN = jISBN.getText();
        int trans_id = 0;
        
        //if trans_id is invalid
        try{
            trans_id = Integer.valueOf(jTransactionID.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Invalid Tranaction ID");
            return;
        }
        
        //if quantity is invalid
        int returnQuantity = 0;
        try{
            returnQuantity = Integer.valueOf(jQuantityReturn.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Invalid Number of copies");
            return;
        }

        // Retrieve the current quantity from the database
        int borrowQuantity = 0;
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT number_book_borrow FROM transactions WHERE trans_id = '" + trans_id + "'";
            ResultSet rs = dbc.getData(query);
            if (rs.next()) {
                borrowQuantity = rs.getInt("number_book_borrow");
            } else {
                JOptionPane.showMessageDialog(this, "Book not found");
                return;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error retrieving book quantity: " + ex.getMessage());
            return;
        }
        
        // Check if borrowQuantity is greater than returnQuantity
        if (returnQuantity > borrowQuantity) {
            JOptionPane.showMessageDialog(this, "Invalid quantity!");
            return;
        }

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String return_date = today.format(formatter);
    
        //inserting data to database
        dbConnector dbc = new dbConnector();
        String query = "UPDATE transactions SET return_date = '"+return_date+"'";
                
        if(dbc.insertData(query)){
            // Update book quantity
            updateBookQuantity(trans_id, returnQuantity, ISBN);
            
            JOptionPane.showMessageDialog(null, "Return Successfully");
            ManageBooks MB = new ManageBooks();
            MB.setVisible(true);
            MB.pack();
            MB.setLocationRelativeTo(null);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Connection Error");
        }
    }//GEN-LAST:event_jBorrowBookActionPerformed

    private void jStudentIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jStudentIDKeyReleased
        searchStudentData();
    }//GEN-LAST:event_jStudentIDKeyReleased

    private void jISBNKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jISBNKeyReleased
        searchBookData();
    }//GEN-LAST:event_jISBNKeyReleased

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        ManageBooks mb = new ManageBooks();
        mb.setVisible(true);
        mb.pack();
        mb.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void jTransactionIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTransactionIDKeyReleased
        searchTransaction();
    }//GEN-LAST:event_jTransactionIDKeyReleased

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField jAuthor;
    private javax.swing.JButton jBorrowBook;
    public javax.swing.JTextField jDepartment;
    private javax.swing.JTextField jISBN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jQuantityReturn;
    private javax.swing.JTextField jStudentID;
    public javax.swing.JTextField jStudentName;
    public javax.swing.JTextField jTitle;
    public javax.swing.JTextField jTransactionID;
    // End of variables declaration//GEN-END:variables
}
