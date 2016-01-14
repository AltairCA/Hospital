/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Attendace;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Change_CLINIC_INFO extends javax.swing.JFrame {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/itp";
   private String ptno;
   private String old_clinic_name;
   private String old_date;
   private String old_clinic_no="";
   protected main home;
   //  Database credentials
   static final String USER = "itp";
   static final String PASS = "itp";
    /**
     * Creates new form Change_CLINIC_INFO
     */
   
   private boolean check_for_db(){
        Connection conn = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
            return false;
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
            return false;
        } //end finally try
        
        return true;
    }
    public Change_CLINIC_INFO() {
        initComponents();
        
        
        if(check_for_db()){
                Connection conn = null;
                Statement stmt = null;
                try {
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    //System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    //System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sql;
                    
                    sql = "SELECT `name` FROM `clinic`";
                    ResultSet rs = stmt.executeQuery(sql);
                    rs = stmt.executeQuery(sql);
                    cmb_clinic_name.removeAllItems();
                    
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_name.addItem(rs.getString(1));
                        
                        
                      
                       
                    }
                    
                    rs.close();
                    stmt.close();
                    conn.close();
                    
                    //STEP 6: Clean-up environment
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                    
                } finally {
                    //finally block used to close resources
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (SQLException se2) {
                    }// nothing we can do
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();

                    }//end finally try
                }
                
                
                
                
                
            }
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jlable9 = new javax.swing.JLabel();
        jlable10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_clinic_notes = new javax.swing.JTextArea();
        btn_clinic_reg = new javax.swing.JButton();
        cmb_clinic_name = new javax.swing.JComboBox();
        jlable20 = new javax.swing.JLabel();
        date_clinic_attend = new com.toedter.calendar.JDateChooser();

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setMaximumSize(new java.awt.Dimension(941, 416));
        jPanel6.setMinimumSize(new java.awt.Dimension(941, 416));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Patient Reg No");

        jlable9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable9.setText("Clinic Name");

        jlable10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable10.setText("Notes");

        txt_clinic_notes.setColumns(20);
        txt_clinic_notes.setRows(5);
        jScrollPane2.setViewportView(txt_clinic_notes);

        btn_clinic_reg.setText("Update Record");
        btn_clinic_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clinic_regActionPerformed(evt);
            }
        });

        cmb_clinic_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Skin Clinic", "Orthopedic Clinic" }));
        cmb_clinic_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_clinic_nameActionPerformed(evt);
            }
        });

        jlable20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable20.setText("Date");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlable9, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                            .addComponent(jlable10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlable20, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_clinic_reg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(cmb_clinic_name, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(date_clinic_attend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jlable20)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(date_clinic_attend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(cmb_clinic_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jlable9)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_clinic_reg)
                        .addContainerGap(60, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jlable10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(21, 21, 21))))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    
    public void setPatientId(String pid,String clinic_name,String date) {
        ptno = pid;
        old_clinic_name = clinic_name;
        old_date = date;
            if(check_for_db()){
                Connection conn = null;
                Statement stmt = null;
                try {
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                   // System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    
                   // System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sql;
                    sql = "SELECT `pId`, `clinic`.`name`, `notes`, `rdate` FROM `patient_clinic`, `clinic` WHERE `clinic`.`clinic_ID` = `patient_clinic`.`clinicId` and `clinic`.`name` = '"+ clinic_name +"' and `patient_clinic`.`pId` = '"+ pid +"' and `patient_clinic`.`rdate` = '"+ date +"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                   
                    
                    while (rs.next()) {
                        //Retrieve by column name
                        jLabel3.setText("Patient Reg No : "+rs.getString(1));
                        cmb_clinic_name.setSelectedItem(rs.getString(2));
                        txt_clinic_notes.setText(rs.getString(3));
                        
                        System.out.println(rs.getString(4));
                         
                        date_clinic_attend.setDate(rs.getDate(4));
                        
                        
                        
                        
                       // cmb_clinic_pno.addItem(rs.getString("ID"));
                       // cmb_ward_pno.addItem(rs.getString("ID"));
                      
                       
                    }
                    
                    
                    
                    rs.close();
                    stmt.close();
                    conn.close();
                    
                    //STEP 6: Clean-up environment
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                    
                } finally {
                    //finally block used to close resources
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (SQLException se2) {
                    }// nothing we can do
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();

                    }//end finally try
                }
                
                
                
                
                
            }
    }
    
    private void btn_clinic_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clinic_regActionPerformed
        // TODO add your handling code here:
        String date,clinic_no;
        
        
        
        
        if(check_for_db()){
                Connection conn = null;
                Statement stmt = null;
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date from_datetime = date_clinic_attend.getDate();
        date = dateFormat.format(from_datetime);
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                   // System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    String sql;
                   // System.out.println("Creating statement...");
                           
                    stmt = conn.createStatement();
                    sql = "SELECT `clinic_ID` FROM `clinic` WHERE `name` = '"+ cmb_clinic_name.getSelectedItem().toString() +"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                   
                    clinic_no = "";
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        clinic_no = rs.getString(1);
                        
                        
                        
                       // cmb_clinic_pno.addItem(rs.getString("ID"));
                       // cmb_ward_pno.addItem(rs.getString("ID"));
                      
                       
                    }
                    
                    
                    
                    
                    
                    rs.close();
                    stmt.close();
                    
                    
                    stmt=null;
                    stmt = conn.createStatement();
                    sql = "SELECT `clinic_ID` FROM `clinic` WHERE `name` = '"+ old_clinic_name +"'";
                    rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                  
                    
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        old_clinic_no = rs.getString(1);
                        
                        
                        
                       // cmb_clinic_pno.addItem(rs.getString("ID"));
                       // cmb_ward_pno.addItem(rs.getString("ID"));
                      
                       
                    }
                    
                    
                    
                    
                    
                    rs.close();
                    stmt.close();
                    
                    
                    stmt=null;
                    stmt = conn.createStatement();
                    
                    
                    
                    sql = "UPDATE `patient_clinic` SET `clinicId`='"+ clinic_no +"',`notes`='"+ txt_clinic_notes.getText() +"',`rdate`='"+ date +"' WHERE `clinicId` = '"+ old_clinic_no +"' and `patient_clinic`.`pId` = '"+ ptno +"' and `patient_clinic`.`rdate` = '"+ old_date +"'";
                    stmt.executeUpdate(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    
                    
                   
                    
                    
                    
                    
                    stmt.close();
                    conn.close();
                    
                    //STEP 6: Clean-up environment
                    this.hide();
                    home.update_recover_table();
                    home.change_footer("Update Successfull", 1);
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    JOptionPane.showMessageDialog(null, "Fill the form Properly","Warning",JOptionPane.WARNING_MESSAGE);
                    e.printStackTrace();
                    
                } finally {
                    //finally block used to close resources
                    try {
                        if (stmt != null) {
                            stmt.close();
                        }
                    } catch (SQLException se2) {
                    }// nothing we can do
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException se) {
                        se.printStackTrace();

                    }//end finally try
                }
                
                
                
                
                
            }
        
    }//GEN-LAST:event_btn_clinic_regActionPerformed

    private void cmb_clinic_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_clinic_nameActionPerformed
        // TODO add your handling code here:
        
        /*
             
        
        
       */
    }//GEN-LAST:event_cmb_clinic_nameActionPerformed

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
            java.util.logging.Logger.getLogger(Change_CLINIC_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_CLINIC_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_CLINIC_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_CLINIC_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_CLINIC_INFO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clinic_reg;
    private javax.swing.JComboBox cmb_clinic_name;
    private com.toedter.calendar.JDateChooser date_clinic_attend;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jlable10;
    private javax.swing.JLabel jlable20;
    private javax.swing.JLabel jlable9;
    private javax.swing.JTextArea txt_clinic_notes;
    // End of variables declaration//GEN-END:variables
}
