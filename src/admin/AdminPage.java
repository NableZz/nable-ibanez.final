
package admin;

import librarian.*;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import library.management.system.*;
import net.proteanit.sql.DbUtils;


public class AdminPage extends javax.swing.JFrame {

    
    public AdminPage() {
        initComponents();
        displayData();
    }

    
    //table format
    public void tableFormat(){
        // Disable cell editing by default
        jBookTable.setDefaultEditor(Object.class, null);

        TableColumnModel columnModel = jBookTable.getColumnModel();
        columnModel.getColumn(0).setHeaderValue("LIBRARIAN ID");
        columnModel.getColumn(1).setHeaderValue("NAME");
        columnModel.getColumn(2).setHeaderValue("CONTACT NUMBER");
        columnModel.getColumn(3).setHeaderValue("STATUS");

        jBookTable.getTableHeader().setBackground(Color.decode("#9AD0D3"));

        //size of the row height
        jBookTable.setRowHeight(20);

        //size of column by percent
        int totalWidth = jBookTable.getWidth();
        double[] columnWidthPercentages = {20, 30, 30, 20};
        int[] columnWidths = new int[columnWidthPercentages.length];

        for (int i = 0; i < columnWidthPercentages.length; i++) {
            columnWidths[i] = (int) (totalWidth * (columnWidthPercentages[i] / 100.0));
        }
        columnModel.getColumn(0).setPreferredWidth(columnWidths[0]);
        columnModel.getColumn(1).setPreferredWidth(columnWidths[1]);
        columnModel.getColumn(2).setPreferredWidth(columnWidths[2]);
        columnModel.getColumn(3).setPreferredWidth(columnWidths[3]);

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
            ResultSet rs = dbc.getData("SELECT lib_id, lib_name, lib_contactnumber, lib_status FROM librarian");
            jBookTable.setModel(DbUtils.resultSetToTableModel(rs));
            tableFormat();

            rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        }
    }
    
    //approve the selected ID
    private void approveSelectedRow() {
        int selectedRow = jBookTable.getSelectedRow();
        if (selectedRow >= 0) {
            int librarianID = (int)jBookTable.getValueAt(selectedRow, 0);
            String currentStatus = jBookTable.getValueAt(selectedRow, 3).toString();

            if ("ACTIVE".equals(currentStatus)) {
                JOptionPane.showMessageDialog(null, "Librarian ID " + librarianID + " is already active.", "Already Active", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to approve this record?", "", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String query = "UPDATE librarian SET lib_status = 'ACTIVE' WHERE lib_id = '" + librarianID + "'";
                dbConnector dbc = new dbConnector();
                if(dbc.insertData(query)){
                    JOptionPane.showMessageDialog(null,"Librarian ID " + librarianID + " record approve successfully.");
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to approve record.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to approve.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //deactive the selected ID
    private void deactiveSelectedRow() {
        int selectedRow = jBookTable.getSelectedRow();
        if (selectedRow >= 0) {
            int librarianID = (int)jBookTable.getValueAt(selectedRow, 0);
            String currentStatus = jBookTable.getValueAt(selectedRow, 3).toString();

            if ("INACTIVE".equals(currentStatus)) {
                JOptionPane.showMessageDialog(null, "Librarian ID " + librarianID + " is already inactive.", "Already Active", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to deactive this record?", "", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String query = "UPDATE librarian SET lib_status = 'INACTIVE' WHERE lib_id = '" + librarianID + "'";
                dbConnector dbc = new dbConnector();
                if(dbc.insertData(query)){
                    JOptionPane.showMessageDialog(null,"Librarian ID " + librarianID + " record deactive successfully.");
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to deactive record.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to deactive.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jBookTable = new javax.swing.JTable();
        refresh = new javax.swing.JButton();
        approve = new javax.swing.JButton();
        deactive = new javax.swing.JButton();
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
        jLabel3.setText("  ADMIN");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(67, 140, 70, 20);

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
        jButton1.setBounds(20, 210, 160, 30);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Manage Librarian");
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(20, 180, 160, 30);

        jBookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "LIBRARIAN ID", "NAME", "CONTACT NUMBER", "STATUS"
            }
        ));
        jScrollPane1.setViewportView(jBookTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(210, 120, 710, 380);

        refresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        refresh.setForeground(new java.awt.Color(51, 51, 51));
        refresh.setText("REFRESH");
        refresh.setFocusPainted(false);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel1.add(refresh);
        refresh.setBounds(410, 80, 90, 25);

        approve.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        approve.setForeground(new java.awt.Color(51, 51, 51));
        approve.setText("APPROVE");
        approve.setFocusPainted(false);
        approve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveActionPerformed(evt);
            }
        });
        jPanel1.add(approve);
        approve.setBounds(210, 80, 90, 25);

        deactive.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deactive.setForeground(new java.awt.Color(51, 51, 51));
        deactive.setText("DEACTIVE");
        deactive.setFocusPainted(false);
        deactive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deactiveActionPerformed(evt);
            }
        });
        jPanel1.add(deactive);
        deactive.setBounds(310, 80, 90, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("List of Librarian");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 20, 190, 25);

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
        AdminPage DashboardFrame = new AdminPage();
        DashboardFrame.setVisible(true);
        DashboardFrame.pack();
        DashboardFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        displayData();
    }//GEN-LAST:event_formWindowActivated

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        displayData();
    }//GEN-LAST:event_refreshActionPerformed

    private void approveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveActionPerformed
        approveSelectedRow();
    }//GEN-LAST:event_approveActionPerformed

    private void deactiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deactiveActionPerformed
        deactiveSelectedRow();
    }//GEN-LAST:event_deactiveActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approve;
    private javax.swing.JButton deactive;
    private javax.swing.JTable jBookTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    // End of variables declaration//GEN-END:variables
}
