
package librarian;

import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;


public class Transactions extends javax.swing.JFrame {

    
    public Transactions() {
        initComponents();
        displayData();
    }

    //search data in table
    public void searchData(){
        String searchText = jID.getText();
        if (!searchText.isEmpty()) {
            try {
                dbConnector dbc = new dbConnector();
                String query = "SELECT trans_id,book_isbn,student_id,lib_id,borrow_date,due_date,return_date,trans_status FROM transactions WHERE trans_id = '"+searchText+"'";
                ResultSet rs = dbc.getData(query);
                jBookTable.setModel(DbUtils.resultSetToTableModel(rs));
                tableFormat();
                rs.close();
            } catch (SQLException ex) {
                System.out.println("Errors: " + ex.getMessage());
            }
        } else {
            // If search field is empty, display all data
            displayData();
        }
    }
    
    //table format
    public void tableFormat(){
        // Disable cell editing by default
        jBookTable.setDefaultEditor(Object.class, null);

        TableColumnModel columnModel = jBookTable.getColumnModel();
        columnModel.getColumn(0).setHeaderValue("TRANSACTION ID");
        columnModel.getColumn(1).setHeaderValue("BOOK ISBN");
        columnModel.getColumn(2).setHeaderValue("STUDENT ID");
        columnModel.getColumn(3).setHeaderValue("LIBRARIAN ID");
        columnModel.getColumn(4).setHeaderValue("BORROW DATE");
        columnModel.getColumn(5).setHeaderValue("DUE DATE");
        columnModel.getColumn(6).setHeaderValue("RETRUN DATE");
        columnModel.getColumn(7).setHeaderValue("STATUS");;

        jBookTable.getTableHeader().setBackground(Color.decode("#9AD0D3"));

        //size of the row height
        jBookTable.setRowHeight(20);

        //size of column by percent
        int totalWidth = jBookTable.getWidth();
        double[] columnWidthPercentages = {12, 12, 12, 12, 12, 12, 12, 16};
        int[] columnWidths = new int[columnWidthPercentages.length];

        for (int i = 0; i < columnWidthPercentages.length; i++) {
            columnWidths[i] = (int) (totalWidth * (columnWidthPercentages[i] / 100.0));
        }
        columnModel.getColumn(0).setPreferredWidth(columnWidths[0]);
        columnModel.getColumn(1).setPreferredWidth(columnWidths[1]);
        columnModel.getColumn(2).setPreferredWidth(columnWidths[2]);
        columnModel.getColumn(3).setPreferredWidth(columnWidths[3]);
        columnModel.getColumn(4).setPreferredWidth(columnWidths[4]);
        columnModel.getColumn(5).setPreferredWidth(columnWidths[5]);
        columnModel.getColumn(6).setPreferredWidth(columnWidths[6]);
        columnModel.getColumn(7).setPreferredWidth(columnWidths[7]);

        TableCellRenderer rendererFromHeader = jBookTable.getTableHeader().getDefaultRenderer();
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        //Set cell renderer to center-align data in all columns 
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jBookTable.setDefaultRenderer(Object.class, centerRenderer);
    }
    
    //display table data
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT trans_id,book_isbn,student_id,lib_id,borrow_date,due_date,return_date,trans_status FROM transactions");
            jBookTable.setModel(DbUtils.resultSetToTableModel(rs));
            tableFormat();

            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBookTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
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

        jBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TRANSACTION ID", "BOOK ISBN", "STUDENT ID", "LIBRARIAN ID", "BORROW DATE", "DUE DATE", "RETURN DATE", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(jBookTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 120, 890, 380);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("REFRESH");
        jButton3.setFocusPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(160, 80, 120, 25);

        jID.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jIDKeyReleased(evt);
            }
        });
        jPanel1.add(jID);
        jID.setBounds(790, 80, 130, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("TRANSACTIONS");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(380, 20, 190, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("TRANSACTION ID");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(664, 84, 130, 20);

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("DASHBOARD");
        jButton4.setFocusPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(30, 80, 120, 25);

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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        displayData();
    }//GEN-LAST:event_formWindowActivated

    private void jIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jIDKeyReleased
        searchData();
    }//GEN-LAST:event_jIDKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jID.setText("");
        displayData();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Dashboard DashboardFrame = new Dashboard();
        DashboardFrame.setVisible(true);
        DashboardFrame.pack();
        DashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transactions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Transactions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable jBookTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JTextField jID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
