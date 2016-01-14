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
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Change_REG_INFO extends javax.swing.JFrame {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/itp";
   private String ptno;
   private String old_nic;
   protected main home;
   //  Database credentials
   static final String USER = "itp";
   static final String PASS = "itp";
    /**
     * Creates new form Change_REG_INFO
     */
    public Change_REG_INFO() {
        initComponents();
    }
    
    private boolean validate_registration(){
        
        if(txt_reg_name.getText().isEmpty()){
            //change_footer("Please Fill the Name", 2);
            //System.out.println("asdaaa");
            JOptionPane.showMessageDialog(null, "Please Fill the Name","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try{
            
            if(!txt_reg_age.getText().isEmpty()){
                if(Integer.parseInt(txt_reg_age.getText())<0){
                    
                    JOptionPane.showMessageDialog(null, "Check the AGE","Warning",JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            
        }
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Check the AGE","Warning",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try{
            if(!txt_reg_nic.getText().isEmpty()){
                if(txt_reg_nic.getText().length() == 10 && (txt_reg_nic.getText().substring(txt_reg_nic.getText().length() - 1).equals("v") || txt_reg_nic.getText().substring(txt_reg_nic.getText().length() - 1).equals("V"))){
                    
                    String b_nic = txt_reg_nic.getText().substring(0, txt_reg_nic.getText().length()-1);
                    if(Integer.parseInt(b_nic)<0){
                        JOptionPane.showMessageDialog(null, "Recheck The NIC","Warning",JOptionPane.WARNING_MESSAGE);
                         
                         return false;
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Recheck The NIC","Warning",JOptionPane.WARNING_MESSAGE);
                
                return false;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Recheck The NIC","Warning",JOptionPane.WARNING_MESSAGE);
             
             return false;
        }
        try{
        if(!txt_reg_tpno.getText().isEmpty()){
            if(Integer.parseInt(txt_reg_tpno.getText()) < 1 || txt_reg_tpno.getText().length() < 10){
                
                JOptionPane.showMessageDialog(null, "Check the Telephone Number","Warning",JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
        }else{
            
        }
        }catch (Exception e) {
                        //Handle errors for Class.forName
            JOptionPane.showMessageDialog(null, "Check the Telephone Number","Warning",JOptionPane.WARNING_MESSAGE);
                        e.printStackTrace();
                        return false;
        }
        try{
        if(!txt_reg_age.getText().isEmpty()){
            if(Integer.parseInt(txt_reg_age.getText()) < 1){
                JOptionPane.showMessageDialog(null, "Check the AGE","Warning",JOptionPane.WARNING_MESSAGE);
                return false;
            }
            
        }
        }catch (Exception e) {
                        //Handle errors for Class.forName
            JOptionPane.showMessageDialog(null, "Check the AGE","Warning",JOptionPane.WARNING_MESSAGE);
                        e.printStackTrace();
                        return false;
        }
                
                if (check_for_db()) {
                     if(txt_reg_nic.getText().isEmpty()){
                       return true; 
                    }
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
                        sql = "SELECT * FROM `patient` WHERE `NIC` = '" + txt_reg_nic.getText() + "'";
                        ResultSet rs = stmt.executeQuery(sql);

                        //STEP 5: Extract data from result set
                        while (rs.next()) {
                            //Retrieve by column name
                            //change_footer("This NIC is Already Registered", 3);
                            if(old_nic.equals(txt_reg_nic.getText())){
                                
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "An Existing User found with the same NIC","Warning",JOptionPane.WARNING_MESSAGE);
                               return false; 
                            }
                            

                        }
                        //STEP 6: Clean-up environment
                        rs.close();
                        stmt.close();
                        

                        
                        

                        conn.close();
                    } catch (SQLException se) {
                        //Handle errors for JDBC
                        se.printStackTrace();
                        return false;
                    } catch (Exception e) {
                        //Handle errors for Class.forName
                        e.printStackTrace();
                        return false;
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

                } else {
                    return false;
                }
  
                
            
        
        
        
        return true;
    }
 public boolean check_for_db(){
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        txt_reg_nic = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_reg_name = new javax.swing.JTextField();
        jlable3 = new javax.swing.JLabel();
        txt_reg_age = new javax.swing.JTextField();
        jlable4 = new javax.swing.JLabel();
        jlable5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_reg_notes = new javax.swing.JTextArea();
        txt_reg_tpno = new javax.swing.JTextField();
        jlable6 = new javax.swing.JLabel();
        txt_reg_address = new javax.swing.JTextField();
        jlable7 = new javax.swing.JLabel();
        r_reg_male = new javax.swing.JRadioButton();
        r_reg_femail = new javax.swing.JRadioButton();
        reg_btn_register = new javax.swing.JButton();
        jlable17 = new javax.swing.JLabel();
        txt_reg_guardianName = new javax.swing.JTextField();
        txt_reg_guardianAddress = new javax.swing.JTextField();
        jlable18 = new javax.swing.JLabel();
        lbl_ptregno = new javax.swing.JLabel();

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));

        txt_reg_nic.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("NIC");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Full Name *");

        txt_reg_name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlable3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable3.setText("Telephone No");

        txt_reg_age.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlable4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable4.setText("AGE");

        jlable5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable5.setText("Notes");

        txt_reg_notes.setColumns(20);
        txt_reg_notes.setRows(5);
        jScrollPane1.setViewportView(txt_reg_notes);

        txt_reg_tpno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlable6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable6.setText("Gender");

        txt_reg_address.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlable7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable7.setText("Address");

        buttonGroup1.add(r_reg_male);
        r_reg_male.setSelected(true);
        r_reg_male.setText("Male");

        buttonGroup1.add(r_reg_femail);
        r_reg_femail.setText("Female");

        reg_btn_register.setText("Update Registration");
        reg_btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_btn_registerActionPerformed(evt);
            }
        });

        jlable17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable17.setText("Guardian Name");

        txt_reg_guardianName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txt_reg_guardianAddress.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jlable18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable18.setText("Guardian Address");

        lbl_ptregno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_ptregno.setText("Patient Reg No");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlable3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlable4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlable5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlable6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlable18, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addComponent(jlable17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlable7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_ptregno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                        .addComponent(txt_reg_guardianAddress, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_reg_guardianName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_reg_address, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_reg_age, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_reg_tpno, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_reg_name, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addGap(161, 161, 161)
                            .addComponent(r_reg_male)
                            .addGap(89, 89, 89)
                            .addComponent(r_reg_femail))
                        .addComponent(txt_reg_nic, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(reg_btn_register, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_reg_nic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_reg_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_reg_tpno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_reg_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jlable3)
                                .addGap(18, 18, 18)
                                .addComponent(jlable4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_reg_male)
                                    .addComponent(r_reg_femail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_reg_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_reg_guardianName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_reg_guardianAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(reg_btn_register)
                                .addGap(0, 37, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jlable6)
                                .addGap(18, 18, 18)
                                .addComponent(jlable7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlable17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlable18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlable5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_ptregno)
                                .addGap(14, 14, 14))))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void setPatientId(String pid) {
            ptno = pid;
            lbl_ptregno.setText("Patient Reg No : "+pid);
        
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
                    sql = "SELECT `ID`, `NIC`, `patient_name`, `telephone`, `remarks`, `guardian_name`, `guardianAdress`, `AGE`, `registerDate`, `gender`,`address` FROM `patient` WHERE `ID` = '"+ pid +"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                   
                    
                    while (rs.next()) {
                        //Retrieve by column name
                        old_nic = rs.getString("NIC");
                        txt_reg_nic.setText(rs.getString("NIC"));
                        txt_reg_address.setText(rs.getString("address"));
                        txt_reg_age.setText(rs.getString("AGE"));
                        txt_reg_guardianAddress.setText(rs.getString("guardianAdress"));
                        txt_reg_guardianName.setText(rs.getString("guardian_name"));
                        txt_reg_name.setText(rs.getString("patient_name"));
                        txt_reg_notes.setText(rs.getString("remarks"));
                        txt_reg_tpno.setText(rs.getString("telephone"));
                        
                        if(rs.getString("gender").equals("Male")){
                            r_reg_male.setSelected(true);
                        }else{
                            r_reg_femail.setSelected(true);
                        }
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
    private void reg_btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_btn_registerActionPerformed
        // TODO add your handling code here:
        if(!validate_registration()){
            return;
        }
        System.out.println("asd");
        String gender;
        if(r_reg_femail.isSelected()){
            gender = "Femail";
        }else{
            gender = "Male";
        }
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
                    
                    System.out.println("Updating...");
                    stmt = conn.createStatement();
                    String sql;
                    sql = "UPDATE `patient` SET `NIC`='"+ txt_reg_nic.getText() +"',`patient_name`='"+ txt_reg_name.getText() +"',`telephone`='"+ txt_reg_tpno.getText() +"',`remarks`='"+ txt_reg_notes.getText() +"',`guardian_name`='"+ txt_reg_guardianName.getText() +"',`guardianAdress`='"+ txt_reg_guardianAddress.getText() +"',`AGE`='"+ txt_reg_age.getText() +"',`gender`='"+ gender +"',`address`='"+ txt_reg_address.getText() +"' WHERE `ID` = '"+ ptno +"'";
                    stmt.executeUpdate(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    stmt.close();
                    conn.close();
                    this.hide();
                    home.update_recover_table();
                    home.change_footer("Update Successfull", 1);
                    //STEP 6: Clean-up environment
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Fill the form Properly","Warning",JOptionPane.WARNING_MESSAGE);
                    
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
    }//GEN-LAST:event_reg_btn_registerActionPerformed

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
            java.util.logging.Logger.getLogger(Change_REG_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Change_REG_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Change_REG_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Change_REG_INFO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_REG_INFO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jlable17;
    private javax.swing.JLabel jlable18;
    private javax.swing.JLabel jlable3;
    private javax.swing.JLabel jlable4;
    private javax.swing.JLabel jlable5;
    private javax.swing.JLabel jlable6;
    private javax.swing.JLabel jlable7;
    private javax.swing.JLabel lbl_ptregno;
    private javax.swing.JRadioButton r_reg_femail;
    private javax.swing.JRadioButton r_reg_male;
    private javax.swing.JButton reg_btn_register;
    private javax.swing.JTextField txt_reg_address;
    private javax.swing.JTextField txt_reg_age;
    private javax.swing.JTextField txt_reg_guardianAddress;
    private javax.swing.JTextField txt_reg_guardianName;
    private javax.swing.JTextField txt_reg_name;
    private javax.swing.JTextField txt_reg_nic;
    private javax.swing.JTextArea txt_reg_notes;
    private javax.swing.JTextField txt_reg_tpno;
    // End of variables declaration//GEN-END:variables
}
