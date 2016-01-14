/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Attendace;

import MainWindow.DBConnect;
import MainWindow.Mainwindow;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Alex
 */
public class main extends javax.swing.JFrame {
    public Mainwindow home;
    public login.Login login;
   private static final DBConnect db_con = new DBConnect();
   static final String JDBC_DRIVER = db_con.JDBC_DRIVER;  
   static final String DB_URL = db_con.DB_URL;
   private boolean onchange_cmb_clinic_pno = false;
   private boolean onchange_cmb_clinic_nic = false;
   private boolean onchange_cmb_ward_pno = false;
   private boolean onchange_cmb_ward_nic = false;
   //  Database credentials
   static final String USER = db_con.USER;
   static final String PASS = db_con.PASS;
   private String recovery_search;
   
   Change_REG_INFO changeReg = new Change_REG_INFO();
   Change_CLINIC_INFO changeClinic = new Change_CLINIC_INFO();
   Change_WARD_INFO changeWard = new Change_WARD_INFO();

            
    /**
     * Creates new form main
     */
    public main() {
        initComponents();
        date_clinic_attend.setDate(new Date());
        date_ward_date.setDate(new Date());
        
        if(!check_for_db()){
            change_footer("DB Connection Failed", 2);
        }else{
            change_footer("DB Connection Established", 1);
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
                    //System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sql;
                    sql = "SELECT `ID` FROM `patient`";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_pno.addItem(rs.getString("ID"));
                        cmb_ward_pno.addItem(rs.getString("ID"));
                      
                       
                    }
                    
                    
                    rs.close();
                    stmt.close();
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT NIC FROM `patient` WHERE `NIC` <> \"\"";
                    rs = stmt.executeQuery(sql);
                    
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_nic.addItem(rs.getString("NIC"));
                        cmb_ward_nic.addItem(rs.getString("NIC"));
                      
                       
                    }
                    
                    
                     rs.close();
                    stmt.close();
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT `name` FROM `clinic`";
                    rs = stmt.executeQuery(sql);
                    cmb_clinic_name.removeAllItems();
                    cmb_report_clinicname.removeAllItems();
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_name.addItem(rs.getString("name"));
                        cmb_report_clinicname.addItem(rs.getString("name"));
                        
                      
                       
                    }
                    
                     rs.close();
                    stmt.close();
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT DISTINCT `Ward_No` FROM `ward`";
                    rs = stmt.executeQuery(sql);
                    cmb_ward_wardno.removeAllItems();
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_ward_wardno.addItem(rs.getString("Ward_No"));
                        
                      
                       
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
        
        
        
        AutoCompleteDecorator.decorate(cmb_clinic_pno);
        AutoCompleteDecorator.decorate(cmb_clinic_nic);
        AutoCompleteDecorator.decorate(cmb_ward_nic);
        AutoCompleteDecorator.decorate(cmb_ward_pno);
        
        recovery_table.removeAll();
        recovery_search = "ID";
        update_recover_table();
    }
    
    public void setUserDetails(String Username, int level){
        if(level==100){
            lbl_userinfo.setText("<html>Hello "+Username+"<br> Level : Admin </html>");
            Component[] components = jPanel7.getComponents();
            for (int i = 0; i < components.length; i++) {

        
                  components[i].setEnabled(true);
        
            }
        }else if(level==75){
            lbl_userinfo.setText("<html>Hello "+Username+"<br> Level : Doctor </html>");
             Component[] components = jPanel7.getComponents();
            for (int i = 0; i < components.length; i++) {

        
                  components[i].setEnabled(false);
        
            }
        }else if(level==65){
           
            Component[] components = jPanel7.getComponents();
            for (int i = 0; i < components.length; i++) {

        
                  components[i].setEnabled(false);
        
            }
            lbl_userinfo.setText("<html>Hello "+Username+"<br> Level : Nurse/Receptionist </html>");
        }
    
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txt_recovery_regno = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_recovery_nic = new javax.swing.JTextField();
        jlable11 = new javax.swing.JLabel();
        txt_recovery_name = new javax.swing.JTextField();
        txt_recovery_tpno = new javax.swing.JTextField();
        jlable16 = new javax.swing.JLabel();
        btn_patientcontrol_reprint = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        recovery_table = new javax.swing.JTable();
        jSeparator6 = new javax.swing.JSeparator();
        btn_patientcontrol_unregister = new javax.swing.JButton();
        btn_patientcontrol_removeattendace = new javax.swing.JButton();
        r_recovery_reg = new javax.swing.JRadioButton();
        r_recovery_clinicattendace = new javax.swing.JRadioButton();
        r_recovery_wardattendance = new javax.swing.JRadioButton();
        btn_patientcontrol_removeattendace1 = new javax.swing.JButton();
        date_recovery_end = new com.toedter.calendar.JDateChooser();
        date_recovery_start = new com.toedter.calendar.JDateChooser();
        checkbox_recovery_date = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlable9 = new javax.swing.JLabel();
        jlable10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_clinic_notes = new javax.swing.JTextArea();
        btn_clinic_reg = new javax.swing.JButton();
        cmb_clinic_name = new javax.swing.JComboBox();
        jlable20 = new javax.swing.JLabel();
        cmb_clinic_pno = new javax.swing.JComboBox();
        cmb_clinic_nic = new javax.swing.JComboBox();
        date_clinic_attend = new com.toedter.calendar.JDateChooser();
        btn_clinic_refresh = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlable14 = new javax.swing.JLabel();
        jlable15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txt_ward_notes = new javax.swing.JTextArea();
        btn_ward_attendace = new javax.swing.JButton();
        cmb_ward_wardno = new javax.swing.JComboBox();
        jlable19 = new javax.swing.JLabel();
        txt_ward_bedno = new javax.swing.JTextField();
        jlable21 = new javax.swing.JLabel();
        cmb_ward_pno = new javax.swing.JComboBox();
        cmb_ward_nic = new javax.swing.JComboBox();
        date_ward_date = new com.toedter.calendar.JDateChooser();
        btn_ward_refresh = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlable12 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        cmb_report_clinicname = new javax.swing.JComboBox();
        jButton10 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jSeparator2 = new javax.swing.JSeparator();
        lbl_status = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lbl_userinfo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patient Attendace And Registration");
        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(java.awt.SystemColor.activeCaptionText);
        setMinimumSize(new java.awt.Dimension(996, 660));
        setPreferredSize(new java.awt.Dimension(996, 660));
        setResizable(false);
        setSize(new java.awt.Dimension(996, 660));
        getContentPane().setLayout(null);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane1FocusGained(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(153, 153, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_reg_nic.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_reg_nic.setMinimumSize(new java.awt.Dimension(6, 25));
        jPanel5.add(txt_reg_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 13, 531, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(368, 2, 12, 441));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("NIC");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 352, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Full Name *");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 352, -1));

        txt_reg_name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_reg_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 54, 531, -1));

        jlable3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable3.setText("Telephone No");
        jPanel5.add(jlable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 97, 352, -1));

        txt_reg_age.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_reg_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 136, 531, -1));

        jlable4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable4.setText("AGE");
        jPanel5.add(jlable4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 132, 352, 28));

        jlable5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable5.setText("Notes");
        jPanel5.add(jlable5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 320, 352, -1));

        txt_reg_notes.setColumns(20);
        txt_reg_notes.setRows(5);
        jScrollPane1.setViewportView(txt_reg_notes);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 305, 531, 64));

        txt_reg_tpno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_reg_tpno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_reg_tpnoActionPerformed(evt);
            }
        });
        jPanel5.add(txt_reg_tpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 95, 531, -1));

        jlable6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable6.setText("Gender");
        jPanel5.add(jlable6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 166, 352, -1));

        txt_reg_address.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_reg_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 196, 531, -1));

        jlable7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable7.setText("Address");
        jPanel5.add(jlable7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 201, 352, 20));

        buttonGroup1.add(r_reg_male);
        r_reg_male.setSelected(true);
        r_reg_male.setText("Male");
        jPanel5.add(r_reg_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(528, 166, 70, -1));

        buttonGroup1.add(r_reg_femail);
        r_reg_femail.setText("Female");
        jPanel5.add(r_reg_femail, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 166, 90, -1));

        reg_btn_register.setText("Register");
        reg_btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_btn_registerActionPerformed(evt);
            }
        });
        jPanel5.add(reg_btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 387, 523, -1));

        jlable17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable17.setText("Guardian Name");
        jPanel5.add(jlable17, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 239, 352, 21));

        txt_reg_guardianName.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_reg_guardianName, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 531, -1));

        txt_reg_guardianAddress.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel5.add(txt_reg_guardianAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 271, 531, -1));

        jlable18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable18.setText("Guardian Address");
        jPanel5.add(jlable18, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 278, 352, 24));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Registration", jPanel4);

        jPanel1.setPreferredSize(new java.awt.Dimension(941, 446));

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_recovery_regno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_recovery_regno.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_recovery_regnoInputMethodTextChanged(evt);
            }
        });
        txt_recovery_regno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_recovery_regnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_recovery_regnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_recovery_regnoKeyTyped(evt);
            }
        });
        jPanel8.add(txt_recovery_regno, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 13, 450, -1));

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel8.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 2, 12, 212));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Patient Reg No");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 178, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("NIC");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 178, -1));

        txt_recovery_nic.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_recovery_nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_recovery_nicKeyReleased(evt);
            }
        });
        jPanel8.add(txt_recovery_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 54, 450, -1));

        jlable11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable11.setText("Full Name");
        jPanel8.add(jlable11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 97, 178, -1));

        txt_recovery_name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_recovery_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_recovery_nameKeyReleased(evt);
            }
        });
        jPanel8.add(txt_recovery_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 95, 450, -1));

        txt_recovery_tpno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txt_recovery_tpno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_recovery_tpnoKeyReleased(evt);
            }
        });
        jPanel8.add(txt_recovery_tpno, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 136, 450, -1));

        jlable16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable16.setText("Tp No");
        jPanel8.add(jlable16, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 136, 178, 25));

        btn_patientcontrol_reprint.setText("Re Print the Card");
        jPanel8.add(btn_patientcontrol_reprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 405, 227, -1));

        recovery_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(recovery_table);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 250, 927, 137));
        jPanel8.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 222, 937, 10));

        btn_patientcontrol_unregister.setText("UnRegister Patient");
        btn_patientcontrol_unregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_patientcontrol_unregisterActionPerformed(evt);
            }
        });
        jPanel8.add(btn_patientcontrol_unregister, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 405, 133, -1));

        btn_patientcontrol_removeattendace.setText("Remove Attendace");
        btn_patientcontrol_removeattendace.setEnabled(false);
        btn_patientcontrol_removeattendace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_patientcontrol_removeattendaceActionPerformed(evt);
            }
        });
        jPanel8.add(btn_patientcontrol_removeattendace, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 405, 160, -1));

        buttonGroup2.add(r_recovery_reg);
        r_recovery_reg.setSelected(true);
        r_recovery_reg.setText("Registration Details");
        r_recovery_reg.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                r_recovery_regItemStateChanged(evt);
            }
        });
        jPanel8.add(r_recovery_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 179, -1, -1));

        buttonGroup2.add(r_recovery_clinicattendace);
        r_recovery_clinicattendace.setText("Clinic Attandace");
        r_recovery_clinicattendace.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                r_recovery_clinicattendaceItemStateChanged(evt);
            }
        });
        jPanel8.add(r_recovery_clinicattendace, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 179, -1, -1));

        buttonGroup2.add(r_recovery_wardattendance);
        r_recovery_wardattendance.setText("Ward Attendace");
        r_recovery_wardattendance.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                r_recovery_wardattendanceItemStateChanged(evt);
            }
        });
        jPanel8.add(r_recovery_wardattendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(583, 179, -1, -1));

        btn_patientcontrol_removeattendace1.setText("Change Information");
        btn_patientcontrol_removeattendace1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_patientcontrol_removeattendace1ActionPerformed(evt);
            }
        });
        jPanel8.add(btn_patientcontrol_removeattendace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(477, 405, 160, -1));

        date_recovery_end.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "End Date"));
        jPanel8.add(date_recovery_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 210, -1));

        date_recovery_start.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Start Date"));
        jPanel8.add(date_recovery_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 210, -1));

        checkbox_recovery_date.setText("Filter Using Date");
        jPanel8.add(checkbox_recovery_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, -1, -1));

        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 170, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Recovery & Update", jPanel1);

        jPanel3.setPreferredSize(new java.awt.Dimension(941, 446));

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setMaximumSize(new java.awt.Dimension(941, 416));
        jPanel6.setMinimumSize(new java.awt.Dimension(941, 416));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 12, 441));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Patient Reg No");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 384, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("NIC");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 61, 396, 27));

        jlable9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable9.setText("Clinic Name");
        jPanel6.add(jlable9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 192, 396, -1));

        jlable10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable10.setText("Notes");
        jPanel6.add(jlable10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 256, 396, -1));

        txt_clinic_notes.setColumns(20);
        txt_clinic_notes.setRows(5);
        jScrollPane2.setViewportView(txt_clinic_notes);

        jPanel6.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 258, 402, 116));

        btn_clinic_reg.setText("Mark The Attendace");
        btn_clinic_reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clinic_regActionPerformed(evt);
            }
        });
        jPanel6.add(btn_clinic_reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 392, 402, -1));

        cmb_clinic_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Skin Clinic", "Orthopedic Clinic" }));
        jPanel6.add(cmb_clinic_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 185, 402, -1));

        jlable20.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable20.setText("Date");
        jPanel6.add(jlable20, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 129, 396, -1));

        cmb_clinic_pno.setEditable(true);
        cmb_clinic_pno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_clinic_pnoItemStateChanged(evt);
            }
        });
        cmb_clinic_pno.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmb_clinic_pnoInputMethodTextChanged(evt);
            }
        });
        cmb_clinic_pno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_clinic_pnoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmb_clinic_pnoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmb_clinic_pnoKeyTyped(evt);
            }
        });
        jPanel6.add(cmb_clinic_pno, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 23, 329, -1));

        cmb_clinic_nic.setEditable(true);
        cmb_clinic_nic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_clinic_nicItemStateChanged(evt);
            }
        });
        cmb_clinic_nic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmb_clinic_nicKeyPressed(evt);
            }
        });
        jPanel6.add(cmb_clinic_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 61, 329, -1));
        jPanel6.add(date_clinic_attend, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 129, 402, -1));

        btn_clinic_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Attendace/refresh-icon.png"))); // NOI18N
        btn_clinic_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clinic_refreshActionPerformed(evt);
            }
        });
        jPanel6.add(btn_clinic_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(853, 23, 64, 58));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Clinic Attendance", jPanel3);

        jPanel9.setPreferredSize(new java.awt.Dimension(941, 446));

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setMaximumSize(new java.awt.Dimension(941, 416));
        jPanel10.setMinimumSize(new java.awt.Dimension(941, 416));
        jPanel10.setPreferredSize(new java.awt.Dimension(941, 416));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel10.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 12, 452));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Patient Reg No");
        jPanel10.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 384, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("NIC");
        jPanel10.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 61, 396, 27));

        jlable14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable14.setText("Bed No");
        jPanel10.add(jlable14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 235, 425, 28));

        jlable15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable15.setText("Notes");
        jPanel10.add(jlable15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 313, 425, -1));

        txt_ward_notes.setColumns(20);
        txt_ward_notes.setRows(5);
        jScrollPane4.setViewportView(txt_ward_notes);

        jPanel10.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 400, -1));

        btn_ward_attendace.setText("Mark The Attendace");
        btn_ward_attendace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ward_attendaceActionPerformed(evt);
            }
        });
        jPanel10.add(btn_ward_attendace, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 410, 402, -1));

        cmb_ward_wardno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WD 01", "WD 02" }));
        jPanel10.add(cmb_ward_wardno, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 180, 402, -1));

        jlable19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable19.setText("Ward No");
        jPanel10.add(jlable19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 425, 28));

        txt_ward_bedno.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel10.add(txt_ward_bedno, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 238, 402, -1));

        jlable21.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable21.setText("Date");
        jPanel10.add(jlable21, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 129, 425, -1));

        cmb_ward_pno.setEditable(true);
        cmb_ward_pno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_ward_pnoItemStateChanged(evt);
            }
        });
        jPanel10.add(cmb_ward_pno, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 23, 329, -1));

        cmb_ward_nic.setEditable(true);
        cmb_ward_nic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_ward_nicItemStateChanged(evt);
            }
        });
        jPanel10.add(cmb_ward_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 61, 329, -1));
        jPanel10.add(date_ward_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 129, 402, -1));

        btn_ward_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Attendace/refresh-icon.png"))); // NOI18N
        btn_ward_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ward_refreshActionPerformed(evt);
            }
        });
        jPanel10.add(btn_ward_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(853, 23, 64, 58));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ward Attendance", jPanel9);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 2, 12, 441));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Start Date");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 458, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("End Date");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 458, 25));

        jlable12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlable12.setText("Clinic Name");
        jPanel7.add(jlable12, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, 458, 28));

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton4.setText("Get the Report");
        jPanel7.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 268, 402, -1));

        cmb_report_clinicname.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        cmb_report_clinicname.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Skin Clinic", "Orthopedic Clinic" }));
        jPanel7.add(cmb_report_clinicname, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 134, 402, -1));

        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton10.setText("Save the Report Using New Data");
        jPanel7.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 309, 402, -1));
        jPanel7.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 13, 402, -1));
        jPanel7.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 59, 402, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reports", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 110, 970, 500);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 100, 1000, 10);

        lbl_status.setBackground(new java.awt.Color(255, 204, 51));
        lbl_status.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_status.setText("Information Saved !");
        lbl_status.setOpaque(true);
        getContentPane().add(lbl_status);
        lbl_status.setBounds(0, 610, 1010, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Attendace/admin1.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(900, 10, 60, 80);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Attendace/home.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 10, 70, 70);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Logout");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel13);
        jLabel13.setBounds(780, 70, 50, 20);

        lbl_userinfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_userinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_userinfo.setText("<html>Hello Sleepy!<br> level : Admin </html>");
        getContentPane().add(lbl_userinfo);
        lbl_userinfo.setBounds(700, 30, 210, 30);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Profile");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel15);
        jLabel15.setBounds(780, 10, 50, 20);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel17.setText("Patient Attendance and Registration System");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(270, 30, 430, 40);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/11806788_1135526379794041_692436290_o.jpg"))); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(1920, 500));
        getContentPane().add(jLabel16);
        jLabel16.setBounds(-10, -20, 1020, 680);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /** user defined functions **/
    protected void change_footer(String msg,int type){
        //type = 1 for success
        //type = 2 for faild
        //type = 3 for warning
        lbl_status.setText(msg);
        if(type == 1){
            Color color=new Color(0,153,0);
            lbl_status.setBackground(color);
        }else if(type == 2){
            Color color=new Color(255,102,102);
            lbl_status.setBackground(color);
        }else{
            Color color=new Color(255,204,51);
            lbl_status.setBackground(color);
        }
    }
    
    private boolean validate_registration(){
        
        if(txt_reg_name.getText().isEmpty()){
            change_footer("Please Fill the Name", 2);
            return false;
        }
        
        try{
            
            if(!txt_reg_age.getText().isEmpty()){
                if(Integer.parseInt(txt_reg_age.getText())<0){
                    change_footer("Check the AGE", 3);
                    return false;
                }
            
        }
        }catch(Exception e){
            change_footer("Check the AGE", 3);
            return false;
        }
        try{
            if(!txt_reg_nic.getText().isEmpty()){
                if(txt_reg_nic.getText().length() == 10 && (txt_reg_nic.getText().substring(txt_reg_nic.getText().length() - 1).equals("v") || txt_reg_nic.getText().substring(txt_reg_nic.getText().length() - 1).equals("V"))){
                    
                    String b_nic = txt_reg_nic.getText().substring(0, txt_reg_nic.getText().length()-1);
                    if(Integer.parseInt(b_nic)<0){
                         change_footer("Recheck The NIC", 2);
                         return false;
                    }
                    
                    
                }else{
                change_footer("Recheck The NIC", 2);
                return false;
                }
            }
        }catch(Exception e){
             change_footer("Recheck The NIC", 2);
             return false;
        }
        try{
        if(!txt_reg_tpno.getText().isEmpty()){
            
            if(Integer.parseInt(txt_reg_tpno.getText()) < 1 || (txt_reg_tpno.getText().length()) < 10){
                change_footer("Check the Telephone Number", 2);
                return false;
            }
            
        }
        }catch (Exception e) {
                        //Handle errors for Class.forName
            change_footer("Check the Telephone Number", 3);
                        e.printStackTrace();
                        return false;
        }
        try{
        if(!txt_reg_age.getText().isEmpty()){
            if(Integer.parseInt(txt_reg_age.getText()) < 1){
                change_footer("Check the AGE", 2);
                return false;
            }
            
        }
        }catch (Exception e) {
                        //Handle errors for Class.forName
            change_footer("Check the AGE", 2);
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
                            change_footer("This NIC is Already Registered", 3);
                            return false;

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
    
    private boolean register_patient(){
        String patient_reg_no, nic, f_name, age, gender, address, g_name, g_address, notes,tpno;
       
        
        patient_reg_no = "";
        nic = txt_reg_nic.getText();
        f_name = txt_reg_name.getText();
        age = txt_reg_age.getText();
        tpno = txt_reg_tpno.getText();
        
        if (r_reg_femail.isSelected()) {
            gender = "Femail";
        } else {
            gender = "Male";
        }

        address = txt_reg_address.getText();
        g_name = txt_reg_guardianName.getText();
        g_address = txt_reg_guardianAddress.getText();
        notes = txt_reg_notes.getText();

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String date_out = dateFormat.format(date);
            
            //STEP 4: Execute a query
            //System.out.println("Creating statement...");
            String sql = "INSERT INTO `patient`(`NIC`, `patient_name`, `telephone`, `remarks`,`guardian_name`, `guardianAdress`, `AGE`, `registerDate`, `gender`,`address`) VALUES ('"+ nic +"','"+ f_name +"','"+ tpno +"','"+ notes +"','"+ g_name +"','"+ g_address +"','"+ age +"','"+ date_out +"','"+ gender +"','"+ address +"')";
            stmt = conn.createStatement();

            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                patient_reg_no = String.valueOf(rs.getInt(1));
            }
            System.out.println(patient_reg_no);
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
        }//end try

        return true;
    }
    
    
    /** end of user define functions **/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        home.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reg_btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_btn_registerActionPerformed
        // TODO add your handling code here:
        if(validate_registration()){
            if(register_patient()){
                change_footer("Patient Registered", 1);
            }else{
                change_footer("There Is an erro", 2);
            }
        }else{
            
        }
    }//GEN-LAST:event_reg_btn_registerActionPerformed
    
    private boolean validate_patient(String patient_reg_no){
        
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
                    sql = "SELECT * FROM `patient` WHERE `ID` = '"+patient_reg_no+"'";
                    ResultSet rs = stmt.executeQuery(sql);

                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        rs.close();
                        stmt.close();      
                        conn.close();
                        return true;

                      
                       
                    }
                    change_footer("There is no record about Patient", 2);
            
                    rs.close();
                    stmt.close();      
                    conn.close();
                    return false;
                    //STEP 6: Clean-up environment
                    
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
                
                
                
                
                
            }else{
                return false;
            }
        
        
    }
    
    private boolean mark_attendace_clinic(){
        String patient_reg_no,date,clinic_name,notes,clinic_id;
        Connection conn = null;
        Statement stmt = null;
        try {
        if(cmb_clinic_pno.getSelectedItem().toString().isEmpty()){
            change_footer("Fill the Form Properly", 3);
            return false;
        }else{
            patient_reg_no = cmb_clinic_pno.getSelectedItem().toString();
            if(!validate_patient(patient_reg_no)){
                
                return false;
            }
            clinic_id="";
            clinic_name = cmb_clinic_name.getSelectedItem().toString();
            notes = txt_clinic_notes.getText();
            
            
            
            
            if(check_for_db()){
               
                
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date from_datetime = date_clinic_attend.getDate();
                    date = dateFormat.format(from_datetime);
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    //System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    //System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sql;
                    sql = "SELECT `clinic_ID` FROM `clinic` WHERE `name` = '"+ clinic_name +"'";
                    ResultSet rs = stmt.executeQuery(sql);

                    //STEP 5: Extract data from result set
                    if (rs.next()) {
                        //Retrieve by column name
                        clinic_id = rs.getString("clinic_ID");

                      
                       
                    }else{
                        change_footer("Wrong Clinic is selected", 2);
                        return false;
                    }
                    //STEP 6: Clean-up environment
                    rs.close();
                    stmt.close();
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT * FROM `patient_clinic` WHERE `pId` = '"+ patient_reg_no +"' and `clinicId` = '"+ clinic_id +"' and `rdate` = '"+ date +"'";
                    rs = stmt.executeQuery(sql);

                    //STEP 5: Extract data from result set
                    if (rs.next()) {
                        //Retrieve by column name
                        
                            change_footer("This Patient Already Visited to the Clinic", 3);
                            return false;
                      
                       
                    }
                    
                    if (clinic_id.isEmpty()){
                        return false;
                    }
                    
                    //INSERTING TO DATABASE
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT * FROM `patient_clinic` WHERE `pId` = '"+ patient_reg_no +"' and `clinicId` = '"+ clinic_id +"'";
                    rs = stmt.executeQuery(sql);

                    //STEP 5: Extract data from result set
                    if (rs.next()) {
                        //Retrieve by column name
                        
                           sql = "INSERT INTO `patient_clinic`(`pId`, `clinicId`, `notes`, `rdate`,`first_visit`) VALUES ('"+ patient_reg_no +"','"+ clinic_id +"','"+ notes +"','"+date+"',0)";
                      
                       
                    }else{
                        sql = "INSERT INTO `patient_clinic`(`pId`, `clinicId`, `notes`, `rdate`,`first_visit`) VALUES ('"+ patient_reg_no +"','"+ clinic_id +"','"+ notes +"','"+date+"',1)";
                    }
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    
                    stmt.executeUpdate(sql);
                    
                    
                    conn.close();
                    }else{
                return false;
            }
            
            
        }
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    //change_footer("Fill the Form Properly", 3);
                    return false;
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                    change_footer("Fill the Form Properly", 3);
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
                
                
                
                
                
            
        change_footer("Patient Attendace Recorded", 1);
        return true;
    }
    
    
    
    //Mart Ward Attendace
    
    private boolean mark_attendace_ward(){
        String patient_reg_no,date,wd_no,notes,bed_no;
         Connection conn = null;
         Statement stmt = null;
         try {
        if(cmb_ward_pno.getSelectedItem().toString().isEmpty()){
            change_footer("Fill the Form Properly", 3);
            return false;
        }else{
            patient_reg_no = cmb_ward_pno.getSelectedItem().toString();
            if(!validate_patient(patient_reg_no)){
                return false;
            }
            bed_no = txt_ward_bedno.getText();
            wd_no = cmb_ward_wardno.getSelectedItem().toString();
            notes = txt_ward_notes.getText();
            
            
            
            
            if(check_for_db()){
               
               
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date from_datetime = date_ward_date.getDate();
            date = dateFormat.format(from_datetime);
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");

                    //STEP 3: Open a connection
                    //System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);

                    //STEP 4: Execute a query
                    //System.out.println("Creating statement...");
                    //stmt = conn.createStatement();
                    String sql;
                    
                    ResultSet rs;

                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT * FROM `ward` WHERE `Ward_No` = '"+ wd_no +"'";
                    rs = stmt.executeQuery(sql);

                    //STEP 5: Extract data from result set
                    if (rs.next()) {
                        //Retrieve by column name
                        
                           
                      
                       
                    }else{
                        change_footer("No Record found about Selected Ward", 2);
                        return false;
                    }
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT * FROM `patient_ward` WHERE `pId` = '"+ patient_reg_no +"' and `wardno` = '"+ wd_no +"' and `date` = '"+ date +"'";
                    rs = stmt.executeQuery(sql);
                    
                     if (rs.next()) {
                        //Retrieve by column name
                        change_footer("Patient Already Admited on this Ward", 3);
                        return false;
                           
                    }else{
                        
                    }
                    //INSERTING TO DATABASE
                    
                    
                    sql = "INSERT INTO `patient_ward`(`pId`, `wardno`, `notes`, `date`, `bedNo`) VALUES ('"+ patient_reg_no +"','" + wd_no + "','"+ notes +"','"+ date +"','"+ bed_no +"')";
                    
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    
                    stmt.executeUpdate(sql);
                    
                    
                    conn.close();
                    }else{
                        return false;
                    }
            
            
                }
                    
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    return false;
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                    change_footer("Fill the Form Properly", 3);
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
                
                
                
                
                
            
        change_footer("Patient Attendace Recorded", 1);
        return true;
    }
    
    private void btn_clinic_regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clinic_regActionPerformed
        // TODO add your handling code here:
        mark_attendace_clinic();
    }//GEN-LAST:event_btn_clinic_regActionPerformed

    private void btn_ward_attendaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ward_attendaceActionPerformed
        // TODO add your handling code here:
        mark_attendace_ward();
    }//GEN-LAST:event_btn_ward_attendaceActionPerformed

    private void cmb_clinic_pnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_clinic_pnoKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_clinic_pnoKeyPressed

    private void cmb_clinic_nicKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_clinic_nicKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_clinic_nicKeyPressed

    private void cmb_clinic_pnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_clinic_pnoKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_clinic_pnoKeyTyped

    private void cmb_clinic_pnoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmb_clinic_pnoInputMethodTextChanged
        // TODO add your handling code here:
        
        
        
        
        
    }//GEN-LAST:event_cmb_clinic_pnoInputMethodTextChanged

    private void cmb_clinic_pnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_clinic_pnoItemStateChanged
        // TODO add your handling code here:
        if(onchange_cmb_clinic_nic || onchange_cmb_clinic_pno){
            return;
        }
        onchange_cmb_clinic_pno = true;
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
                    sql = "SELECT `NIC` FROM `patient` where `ID` = '"+ cmb_clinic_pno.getSelectedItem().toString() +"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_nic.setSelectedItem(rs.getString("NIC"));

                      
                       
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
                    onchange_cmb_clinic_pno = false;
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
        onchange_cmb_clinic_pno = false;
    }//GEN-LAST:event_cmb_clinic_pnoItemStateChanged

    private void cmb_clinic_pnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_clinic_pnoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_clinic_pnoKeyReleased

    private void cmb_clinic_nicItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_clinic_nicItemStateChanged
        // TODO add your handling code here:
        
        if(onchange_cmb_clinic_pno || onchange_cmb_clinic_nic){
            return;
        }
        onchange_cmb_clinic_nic = true;
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
                    sql = "SELECT `ID` FROM `patient` where `NIC` = '"+ cmb_clinic_nic.getSelectedItem().toString() +"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_pno.setSelectedItem(rs.getString("ID"));

                      
                       
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
                    onchange_cmb_clinic_nic = false;
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
        onchange_cmb_clinic_nic = false;
    }//GEN-LAST:event_cmb_clinic_nicItemStateChanged

    private void cmb_ward_pnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_ward_pnoItemStateChanged
        // TODO add your handling code here:
        if(onchange_cmb_ward_nic || onchange_cmb_ward_pno){
            return;
        }
        onchange_cmb_ward_pno = false;
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
                    sql = "SELECT `NIC` FROM `patient` where `ID` = '"+ cmb_ward_pno.getSelectedItem().toString() +"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_ward_nic.setSelectedItem(rs.getString("NIC"));

                      
                       
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
                    onchange_cmb_ward_pno = false;
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
        onchange_cmb_ward_pno = false;
    }//GEN-LAST:event_cmb_ward_pnoItemStateChanged

    private void cmb_ward_nicItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_ward_nicItemStateChanged
        // TODO add your handling code here:
        if(onchange_cmb_ward_pno || onchange_cmb_ward_nic){
            return;
        }
        onchange_cmb_ward_nic = true;
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
                    sql = "SELECT `ID` FROM `patient` where `NIC` = '"+ cmb_ward_nic.getSelectedItem().toString() +"'";
                    ResultSet rs = stmt.executeQuery(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_ward_pno.setSelectedItem(rs.getString("ID"));

                      
                       
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
                    onchange_cmb_ward_nic = false;
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
        onchange_cmb_ward_nic = false;
    }//GEN-LAST:event_cmb_ward_nicItemStateChanged

    private void txt_recovery_regnoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_recovery_regnoInputMethodTextChanged
        // TODO add your handling code here:
        //System.out.print("asdas");
    }//GEN-LAST:event_txt_recovery_regnoInputMethodTextChanged

    private void txt_recovery_regnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_recovery_regnoKeyPressed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txt_recovery_regnoKeyPressed

    private void txt_recovery_regnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_recovery_regnoKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_recovery_regnoKeyTyped
    protected void update_recover_table(){
        String date_start="",date_end="";
        if(check_for_db()){
            if (checkbox_recovery_date.isSelected()) {
                try {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date1 = date_recovery_start.getDate();
                    date_start = dateFormat.format(date1);
                    
                    Date date2 = date_recovery_end.getDate();
                    date_end = dateFormat.format(date2);
                    
                    if(!date1.equals(date2) && !date1.before(date2)){
                        change_footer("Start Date should be Less than or Equal to the End Date", 3);
                        return;
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                    change_footer("Fill the Form Properly", 3);
                    return;
                }
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
                    sql = "";
                    
                    if (recovery_search.equals("ID")) {
                        
                            if (r_recovery_reg.isSelected()) {
                                sql = "SELECT `ID`, `NIC`, `patient_name` as 'Patient Name', `telephone` as 'Telephone', `gender` as 'Gender' FROM `patient` WHERE `ID` LIKE '%" + txt_recovery_regno.getText() + "%'";
                            } else if (r_recovery_clinicattendace.isSelected()) {
                                sql = "SELECT `pId` as 'PID', `clinic`.`name` as 'Clinic', `notes` as 'Notes', `rdate` as 'Attended Date' FROM `patient_clinic`, `patient`,`clinic`  WHERE `patient_clinic`.`pId` = `patient`.`ID` and `clinic`.`clinic_ID` = `patient_clinic`.`clinicId` and `patient_clinic`.`pId` LIKE '%" + txt_recovery_regno.getText() + "%'";
                            } else {
                                sql = "SELECT `pId` as 'PID', `wardno` as 'Ward', `bedNo` as 'Bed No',`date` as 'Admited Date' FROM `patient_ward`, `patient` WHERE `patient_ward`.`pId` = `patient`.`ID` and `patient_ward`.`pId` LIKE '%" + txt_recovery_regno.getText() + "%'";
                            }
                        
                    } else if (recovery_search.equals("NIC")) {
                        
                            if (r_recovery_reg.isSelected()) {
                                sql = "SELECT `ID`, `NIC`, `patient_name` as 'Patient Name', `telephone` as 'Telephone', `gender` as 'Gender' FROM `patient` WHERE `NIC` LIKE '%" + txt_recovery_nic.getText() + "%'";
                            } else if (r_recovery_clinicattendace.isSelected()) {
                                sql = "SELECT `pId` as 'PID', `clinic`.`name` as 'Clinic', `notes` as 'Notes', `rdate` as 'Attended Date' FROM `patient_clinic`, `patient`,`clinic`  WHERE `patient_clinic`.`pId` = `patient`.`ID` and `clinic`.`clinic_ID` = `patient_clinic`.`clinicId` and `patient`.`NIC` LIKE '%" + txt_recovery_nic.getText() + "%'";
                            } else {
                                sql = "SELECT `pId` as 'PID', `wardno` as 'Ward', `bedNo` as 'Bed No',`date` as 'Admited Date' FROM `patient_ward`, `patient` WHERE `patient_ward`.`pId` = `patient`.`ID` and `patient`.`NIC` LIKE '%" + txt_recovery_nic.getText() + "%'";
                            }
                        

                    } else if (recovery_search.equals("NAME")) {
                        
                            if (r_recovery_reg.isSelected()) {
                                sql = "SELECT `ID`, `NIC`, `patient_name` as 'Patient Name', `telephone` as 'Telephone', `gender` as 'Gender' FROM `patient` WHERE `patient_name` LIKE '%" + txt_recovery_name.getText() + "%'";
                            } else if (r_recovery_clinicattendace.isSelected()) {
                                sql = "SELECT `pId` as 'PID', `clinic`.`name` as 'Clinic', `notes` as 'Notes', `rdate` as 'Attended Date' FROM `patient_clinic`, `patient`,`clinic`  WHERE `patient_clinic`.`pId` = `patient`.`ID` and `clinic`.`clinic_ID` = `patient_clinic`.`clinicId` and `patient`.`patient_name` LIKE '%" + txt_recovery_name.getText() + "%'";
                            } else {
                                sql = "SELECT `pId` as 'PID', `wardno` as 'Ward', `bedNo` as 'Bed No',`date` as 'Admited Date' FROM `patient_ward`, `patient` WHERE `patient_ward`.`pId` = `patient`.`ID` and `patient`.`patient_name` LIKE '%" + txt_recovery_name.getText() + "%'";
                            }
                        

                    } else {
                        
                            if (r_recovery_reg.isSelected()) {
                                sql = "SELECT `ID`, `NIC`, `patient_name` as 'Patient Name', `telephone` as 'Telephone', `gender` as 'Gender' FROM `patient` WHERE `telephone` LIKE '%" + txt_recovery_tpno.getText() + "%'";
                            } else if (r_recovery_clinicattendace.isSelected()) {
                                sql = "SELECT `pId` as 'PID', `clinic`.`name` as 'Clinic', `notes` as 'Notes', `rdate` as 'Attended Date' FROM `patient_clinic`, `patient`,`clinic`  WHERE `patient_clinic`.`pId` = `patient`.`ID` and `clinic`.`clinic_ID` = `patient_clinic`.`clinicId` and `patient`.`telephone` LIKE '%" + txt_recovery_tpno.getText() + "%'";
                            } else {
                                sql = "SELECT `pId` as 'PID', `wardno` as 'Ward', `bedNo` as 'Bed No',`date` as 'Admited Date' FROM `patient_ward`, `patient` WHERE `patient_ward`.`pId` = `patient`.`ID` and `patient`.`telephone` LIKE '%" + txt_recovery_tpno.getText() + "%'";
                            }
                        

                    }
        
                    
                    if (checkbox_recovery_date.isSelected()) {
                            if (r_recovery_reg.isSelected()) {
                                sql = sql + " and `patient`.`registerDate` >= '"+ date_start +"' and `patient`.`registerDate` <= '"+ date_end +"'";
                            } else if (r_recovery_clinicattendace.isSelected()) {
                                sql = sql + " and `patient_clinic`.`rdate` >= '"+ date_start +"' and `patient_clinic`.`rdate` <= '"+ date_end +"'";
                            } else {
                                sql = sql + " and `patient_ward`.`date` >= '"+ date_start +"' and `patient_ward`.`date` <= '"+ date_end +"'";
                            }
                    }
                    
                    
                    
                    ResultSet rs = stmt.executeQuery(sql);
                    recovery_table.setModel(DbUtils.resultSetToTableModel(rs));
                    //STEP 5: Extract data from result set
                   
                    rs.close();
                    stmt.close();      
                    conn.close();
                    change_footer("Search Complete", 1);
                    //STEP 6: Clean-up environment
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    //se.printStackTrace();
                    
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    //e.printStackTrace();
                    
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
                        //se.printStackTrace();

                    }//end finally try
                }
                
                
                
                
                
            }
    }
    private void txt_recovery_regnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_recovery_regnoKeyReleased
        // TODO add your handling code here:
        recovery_search = "ID";
        update_recover_table();
        
        
        
    }//GEN-LAST:event_txt_recovery_regnoKeyReleased

    private void r_recovery_regItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_r_recovery_regItemStateChanged
        // TODO add your handling code here:
        update_recover_table();
        if(r_recovery_reg.isSelected()){
            btn_patientcontrol_removeattendace.setEnabled(false);
            
            btn_patientcontrol_unregister.setEnabled(true);
            
        }
    }//GEN-LAST:event_r_recovery_regItemStateChanged

    private void r_recovery_clinicattendaceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_r_recovery_clinicattendaceItemStateChanged
        // TODO add your handling code here:
        update_recover_table();
        if(r_recovery_clinicattendace.isSelected()){
            btn_patientcontrol_removeattendace.setEnabled(true);
            btn_patientcontrol_unregister.setEnabled(false);
            
        }
    }//GEN-LAST:event_r_recovery_clinicattendaceItemStateChanged

    private void r_recovery_wardattendanceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_r_recovery_wardattendanceItemStateChanged
        // TODO add your handling code here:
        update_recover_table();
          if(r_recovery_wardattendance.isSelected()){
            btn_patientcontrol_removeattendace.setEnabled(true);
            btn_patientcontrol_unregister.setEnabled(false);
            
        }
    }//GEN-LAST:event_r_recovery_wardattendanceItemStateChanged

    private void txt_recovery_nicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_recovery_nicKeyReleased
        // TODO add your handling code here:
        recovery_search = "NIC";
        update_recover_table();
    }//GEN-LAST:event_txt_recovery_nicKeyReleased

    private void txt_recovery_nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_recovery_nameKeyReleased
        // TODO add your handling code here:
        recovery_search = "NAME";
        update_recover_table();
    }//GEN-LAST:event_txt_recovery_nameKeyReleased

    private void txt_recovery_tpnoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_recovery_tpnoKeyReleased
        // TODO add your handling code here:
        recovery_search = "TPNO";
        update_recover_table();
    }//GEN-LAST:event_txt_recovery_tpnoKeyReleased

    private void btn_patientcontrol_unregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_patientcontrol_unregisterActionPerformed
        // TODO add your handling code here:
        try{
            if(recovery_table.getSelectedRow()<0){
                return;
            }
            int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to delete this record ?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.NO_OPTION){
                return;
            }
            int row = recovery_table.getSelectedRow();
            String selected_pid = recovery_table.getValueAt(row, 0).toString();
            //System.out.println(selected_pid);
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
                    sql = "DELETE FROM `patient_clinic` WHERE `pId` = '"+ selected_pid +"'";
                    stmt.executeUpdate(sql);
                    
                    sql = "DELETE FROM `patient_ward` WHERE `pId` = '"+ selected_pid +"'";
                     stmt.executeUpdate(sql);
                     
                     sql = "DELETE FROM `patient` WHERE `ID` = '"+ selected_pid +"'";
                     stmt.executeUpdate(sql);
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    update_recover_table();
                    stmt.close();
                    conn.close();
                    change_footer("Successfully Unregistered the patient",1);
                    //STEP 6: Clean-up environment
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                    
                } finally {
                    //finally block used to close resources
                    onchange_cmb_ward_nic = false;
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
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btn_patientcontrol_unregisterActionPerformed

    private void btn_patientcontrol_removeattendaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_patientcontrol_removeattendaceActionPerformed
        // TODO add your handling code here:
        try{
            if(recovery_table.getSelectedRow()<0 || (!r_recovery_clinicattendace.isSelected() && !r_recovery_wardattendance.isSelected())){
                return;
            }
            int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to delete this record ?","Warning",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.NO_OPTION){
                return;
            }
            int row = recovery_table.getSelectedRow();
            String selected_pid = recovery_table.getValueAt(row, 0).toString();
            String selected_date = recovery_table.getValueAt(row, 3).toString();
            String Selected_name = recovery_table.getValueAt(row, 1).toString();
            //System.out.println(selected_pid);
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
                    ////System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sql;
                    if(r_recovery_clinicattendace.isSelected()){
                        sql = "DELETE FROM `patient_clinic` WHERE `pId` = '"+ selected_pid +"' and `clinicId` = (SELECT `clinicId` from `clinic` WHERE `name` = '"+ Selected_name +"' ) and `rdate` = '"+ selected_date +"'";
                        stmt.executeUpdate(sql);
                        update_recover_table();
                    }else if(r_recovery_wardattendance.isSelected()){
                        sql = "DELETE FROM `patient_ward` WHERE `pId` = '"+ selected_pid +"' and `wardno` = '"+ Selected_name +"' and `date` = '"+ selected_date +"'";
                        stmt.executeUpdate(sql);
                        update_recover_table();
                    }
                    
                    
                   
                     
                     
                    //cmb_clinic_pno.removeAllItems();
                    //STEP 5: Extract data from result set
                    
                    stmt.close();
                    conn.close();
                    change_footer("Successfully removed the attendance",1);
                    //STEP 6: Clean-up environment
                    
                } catch (SQLException se) {
                    //Handle errors for JDBC
                    se.printStackTrace();
                    
                } catch (Exception e) {
                    //Handle errors for Class.forName
                    e.printStackTrace();
                    
                } finally {
                    //finally block used to close resources
                    onchange_cmb_ward_nic = false;
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
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_btn_patientcontrol_removeattendaceActionPerformed

    private void btn_patientcontrol_removeattendace1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_patientcontrol_removeattendace1ActionPerformed
        // TODO add your handling code here:
        int row = recovery_table.getSelectedRow();
        
        if(row>-1){
            
        }else{
            return;
        }
        if(r_recovery_reg.isSelected()){
            
            changeReg.setVisible(true);
            changeReg.home = this;
            changeReg.setPatientId(recovery_table.getValueAt(row, 0).toString());
        }
        if(r_recovery_clinicattendace.isSelected()){
            changeClinic.setVisible(true);
            changeClinic.home = this;
            changeClinic.setPatientId(recovery_table.getValueAt(row, 0).toString(), recovery_table.getValueAt(row, 1).toString(), recovery_table.getValueAt(row, 3).toString());
        }
        if(r_recovery_wardattendance.isSelected()){
            changeWard.setVisible(true);
            changeWard.home = this;
            changeWard.setPatientId(recovery_table.getValueAt(row, 0).toString(), recovery_table.getValueAt(row, 1).toString(), recovery_table.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_btn_patientcontrol_removeattendace1ActionPerformed

    private void refresh_cmbs(){
        onchange_cmb_clinic_nic = true;
        onchange_cmb_clinic_pno = true;
        onchange_cmb_ward_nic = true;
        onchange_cmb_ward_pno = true;
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
                    ////System.out.println("Creating statement...");
                    stmt = conn.createStatement();
                    String sql;
                    sql = "SELECT `ID` FROM `patient`";
                    ResultSet rs = stmt.executeQuery(sql);
                    cmb_clinic_pno.removeAllItems();
                    cmb_ward_pno.removeAllItems();
                    
                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_pno.addItem(rs.getString("ID"));
                        cmb_ward_pno.addItem(rs.getString("ID"));
                      
                       
                    }
                    
                    
                    rs.close();
                    stmt.close();
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT NIC FROM `patient` WHERE `NIC` <> \"\"";
                    rs = stmt.executeQuery(sql);
                    cmb_clinic_nic.removeAllItems();
                    cmb_ward_nic.removeAllItems();
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_nic.addItem(rs.getString("NIC"));
                        cmb_ward_nic.addItem(rs.getString("NIC"));
                      
                       
                    }
                    
                    
                     rs.close();
                    stmt.close();
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT `name` FROM `clinic`";
                    rs = stmt.executeQuery(sql);
                    cmb_clinic_name.removeAllItems();
                    cmb_report_clinicname.removeAllItems();
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_clinic_name.addItem(rs.getString("name"));
                        cmb_report_clinicname.addItem(rs.getString("name"));
                        
                      
                       
                    }
                    
                     rs.close();
                    stmt.close();
                    
                    stmt = null;
                    stmt = conn.createStatement();
                    sql = "SELECT `Ward_No` FROM `ward`";
                    rs = stmt.executeQuery(sql);
                    cmb_ward_wardno.removeAllItems();
                    while (rs.next()) {
                        //Retrieve by column name
                        
                        cmb_ward_wardno.addItem(rs.getString("Ward_No"));
                        
                      
                       
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
        
        onchange_cmb_clinic_nic = false;
        onchange_cmb_clinic_pno = false;
        onchange_cmb_ward_nic = false;
        onchange_cmb_ward_pno = false;
        
    }
    private void txt_reg_tpnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_reg_tpnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_reg_tpnoActionPerformed

    private void jTabbedPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane1FocusGained
        // TODO add your handling code here:
        //update_recover_table();
    }//GEN-LAST:event_jTabbedPane1FocusGained

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        try{
             update_recover_table();
        }catch(Exception e){
            
        }
       
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void btn_ward_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ward_refreshActionPerformed
        // TODO add your handling code here:
        refresh_cmbs();
    }//GEN-LAST:event_btn_ward_refreshActionPerformed

    private void btn_clinic_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clinic_refreshActionPerformed
        // TODO add your handling code here:
        refresh_cmbs();
    }//GEN-LAST:event_btn_clinic_refreshActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        update_recover_table();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clinic_refresh;
    private javax.swing.JButton btn_clinic_reg;
    private javax.swing.JButton btn_patientcontrol_removeattendace;
    private javax.swing.JButton btn_patientcontrol_removeattendace1;
    private javax.swing.JButton btn_patientcontrol_reprint;
    private javax.swing.JButton btn_patientcontrol_unregister;
    private javax.swing.JButton btn_ward_attendace;
    private javax.swing.JButton btn_ward_refresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JCheckBox checkbox_recovery_date;
    private javax.swing.JComboBox cmb_clinic_name;
    private javax.swing.JComboBox cmb_clinic_nic;
    private javax.swing.JComboBox cmb_clinic_pno;
    private javax.swing.JComboBox cmb_report_clinicname;
    private javax.swing.JComboBox cmb_ward_nic;
    private javax.swing.JComboBox cmb_ward_pno;
    private javax.swing.JComboBox cmb_ward_wardno;
    private com.toedter.calendar.JDateChooser date_clinic_attend;
    private com.toedter.calendar.JDateChooser date_recovery_end;
    private com.toedter.calendar.JDateChooser date_recovery_start;
    private com.toedter.calendar.JDateChooser date_ward_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlable10;
    private javax.swing.JLabel jlable11;
    private javax.swing.JLabel jlable12;
    private javax.swing.JLabel jlable14;
    private javax.swing.JLabel jlable15;
    private javax.swing.JLabel jlable16;
    private javax.swing.JLabel jlable17;
    private javax.swing.JLabel jlable18;
    private javax.swing.JLabel jlable19;
    private javax.swing.JLabel jlable20;
    private javax.swing.JLabel jlable21;
    private javax.swing.JLabel jlable3;
    private javax.swing.JLabel jlable4;
    private javax.swing.JLabel jlable5;
    private javax.swing.JLabel jlable6;
    private javax.swing.JLabel jlable7;
    private javax.swing.JLabel jlable9;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_userinfo;
    private javax.swing.JRadioButton r_recovery_clinicattendace;
    private javax.swing.JRadioButton r_recovery_reg;
    private javax.swing.JRadioButton r_recovery_wardattendance;
    private javax.swing.JRadioButton r_reg_femail;
    private javax.swing.JRadioButton r_reg_male;
    private javax.swing.JTable recovery_table;
    private javax.swing.JButton reg_btn_register;
    private javax.swing.JTextArea txt_clinic_notes;
    private javax.swing.JTextField txt_recovery_name;
    private javax.swing.JTextField txt_recovery_nic;
    private javax.swing.JTextField txt_recovery_regno;
    private javax.swing.JTextField txt_recovery_tpno;
    private javax.swing.JTextField txt_reg_address;
    private javax.swing.JTextField txt_reg_age;
    private javax.swing.JTextField txt_reg_guardianAddress;
    private javax.swing.JTextField txt_reg_guardianName;
    private javax.swing.JTextField txt_reg_name;
    private javax.swing.JTextField txt_reg_nic;
    private javax.swing.JTextArea txt_reg_notes;
    private javax.swing.JTextField txt_reg_tpno;
    private javax.swing.JTextField txt_ward_bedno;
    private javax.swing.JTextArea txt_ward_notes;
    // End of variables declaration//GEN-END:variables
}
