
package librarian;

import config.PanelPrinter;
import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import library.management.system.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import net.proteanit.sql.DbUtils;


public class BorrowBook extends javax.swing.JFrame {
    
   
    public BorrowBook() {
        initComponents();
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
                    jQuantity.setText("" + rs.getString("book_quantity"));
                }else{
                    jTitle.setText("");
                    jAuthor.setText("");
                    jQuantity.setText("");
                }
                rs.close();
            }catch (SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }
        } else {
            // If search field is empty
            jTitle.setText("");
            jAuthor.setText("");
            jQuantity.setText("");
        }
    }
    
    // Update book quantity after borrowing
    public void updateBookQuantity(String ISBN, int borrowQuantity) {
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT book_quantity FROM books WHERE book_isbn = '" + ISBN + "'";
            ResultSet rs = dbc.getData(query);
            if (rs.next()) {
                int currentQuantity = rs.getInt("book_quantity");
                int newQuantity = currentQuantity - borrowQuantity;
                String updateQuery = "UPDATE books SET book_quantity = " + newQuantity + " WHERE book_isbn = '" + ISBN + "'";
                dbc.insertData(updateQuery);
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
        jQuantity = new javax.swing.JTextField();
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setText("Borrowing a Books");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(320, 30, 340, 50);

        jStudentID.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jStudentID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jStudentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jStudentIDKeyReleased(evt);
            }
        });
        jPanel1.add(jStudentID);
        jStudentID.setBounds(280, 270, 230, 32);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Enter Student ID");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(150, 280, 130, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Enter Book ISBN");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(150, 130, 130, 22);

        jQuantity.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jQuantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jQuantity);
        jQuantity.setBounds(540, 120, 250, 32);

        jISBN.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jISBN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jISBN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jISBNKeyReleased(evt);
            }
        });
        jPanel1.add(jISBN);
        jISBN.setBounds(280, 120, 230, 32);

        jDepartment.setEditable(false);
        jDepartment.setBackground(new java.awt.Color(255, 255, 255));
        jDepartment.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jDepartment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jDepartment);
        jDepartment.setBounds(540, 330, 250, 32);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Author");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(540, 210, 110, 22);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Book Title");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(150, 210, 90, 22);

        jTitle.setEditable(false);
        jTitle.setBackground(new java.awt.Color(255, 255, 255));
        jTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jTitle);
        jTitle.setBounds(150, 180, 360, 32);

        jAuthor.setEditable(false);
        jAuthor.setBackground(new java.awt.Color(255, 255, 255));
        jAuthor.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jAuthor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jAuthor);
        jAuthor.setBounds(540, 180, 250, 32);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Number of Copies");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(540, 150, 140, 22);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Department");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(540, 360, 110, 22);

        jStudentName.setEditable(false);
        jStudentName.setBackground(new java.awt.Color(255, 255, 255));
        jStudentName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jStudentName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel1.add(jStudentName);
        jStudentName.setBounds(150, 330, 360, 32);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Student Name");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(150, 360, 120, 22);

        jBorrowBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jBorrowBook.setText("BORROW BOOK");
        jBorrowBook.setFocusPainted(false);
        jBorrowBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBorrowBookActionPerformed(evt);
            }
        });
        jPanel1.add(jBorrowBook);
        jBorrowBook.setBounds(540, 410, 250, 32);

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
        jLoginButton.setBounds(280, 410, 230, 32);

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
        String student_name = jStudentName.getText();
        String Student_ID = jStudentID.getText();
        Session session = Session.getInstance();
        int Librarian_ID = session.getId();
        int borrowQuantity = 0;
        
        if(ISBN.isEmpty()){
            JOptionPane.showMessageDialog(this, "Invalid ISBN");
            return;
        }
        
        //if student exist
        if(!bookExist(ISBN)){
            JOptionPane.showMessageDialog(this, "Book ISBN not found");
            return;
        }
        
        //if quantity is invalid
        try{
            borrowQuantity = Integer.valueOf(jQuantity.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Invalid Number of copies");
            return;
        }

        if(Student_ID.isEmpty()){
            JOptionPane.showMessageDialog(this, "Invalid Student ID");
            return;
        }
        
        //if student exist
        if(!studentExist(Student_ID)){
            JOptionPane.showMessageDialog(this, "Student ID not found");
            return;
        }
        
        // Retrieve the current quantity from the database
        int currentQuantity = 0;
        try {
            dbConnector dbc = new dbConnector();
            String query = "SELECT book_quantity FROM books WHERE book_isbn = '" + ISBN + "'";
            ResultSet rs = dbc.getData(query);
            if (rs.next()) {
                currentQuantity = rs.getInt("book_quantity");
            } else {
                JOptionPane.showMessageDialog(this, "Book not found");
                return;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error retrieving book quantity: " + ex.getMessage());
            return;
        }
        
        // Check if borrowQuantity is greater than currentQuantity
        if (borrowQuantity > currentQuantity) {
            JOptionPane.showMessageDialog(this, "Invalid quantity. Not enough books in stock.");
            return;
        }
        
        // Set borrow_date to today's date and due_date to 7 days later
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String borrow_date = today.format(formatter);
        String due_date = dueDate.format(formatter);
    
        //inserting data to database
        dbConnector dbc = new dbConnector();
        String query = "INSERT INTO transactions ( book_isbn, lib_id, student_id, borrow_date, due_date, number_book_borrow, trans_status) VALUES ("
                + "'" + ISBN + "',"
                + "'"+ Librarian_ID +"',"
                + "'"+ Student_ID +"',"
                + "'"+ borrow_date +"',"
                + "'"+ due_date +"',"
                + "'"+ borrowQuantity +"',"
                + "'BORROW')";
        if(dbc.insertData(query)){
            // Retrieve the last inserted transaction ID
            String lastIdQuery = "SELECT LAST_INSERT_ID() AS last_id";
            ResultSet resultSet;
            int transactionID = 0;
            try {
                resultSet = dbc.getData(lastIdQuery);
                if (resultSet.next()) {
                    transactionID = resultSet.getInt("last_id");
                }
            } catch (SQLException ex) {
                System.out.println("Error" + ex.getMessage());;
            }
            
            
            // Update book quantity
            updateBookQuantity(ISBN, borrowQuantity);

            JOptionPane.showMessageDialog(null, "Borrow Successfully");
            JOptionPane.showMessageDialog(null, "printing borrower's slip");
            BorrowSlip BS = new BorrowSlip();
            BS.transID.setText("" + transactionID);
            BS.studentID.setText("" + Student_ID);
            BS.studentName.setText("" + student_name);
            BS.ISBN.setText("" + ISBN);
            BS.booktitle.setText("" + jTitle.getText());
            BS.quantity.setText("" + jQuantity.getText());
            BS.dateIssue.setHorizontalAlignment(SwingConstants.CENTER);
            BS.dateIssue.setText("" + borrow_date);
            BS.returnDate.setHorizontalAlignment(SwingConstants.CENTER);
            BS.returnDate.setText("" + due_date);
            BS.librarianName.setHorizontalAlignment(SwingConstants.CENTER);
            BS.librarianName.setText("" + session.getFullname());
            JPanel myPanel = new JPanel();
            PanelPrinter pPrint = new PanelPrinter(BS.page);
            pPrint.printPanel();
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
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowBook().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jQuantity;
    private javax.swing.JTextField jStudentID;
    public javax.swing.JTextField jStudentName;
    public javax.swing.JTextField jTitle;
    // End of variables declaration//GEN-END:variables
}
