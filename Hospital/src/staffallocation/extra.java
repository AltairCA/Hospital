/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package staffallocation;

import dbConnect.DBconnect;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author Dhananjaya
 */
public class extra extends javax.swing.JFrame {
    public MainWindow.Mainwindow home;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    ResultSet rs2 = null;
   
    
    public extra() {
        initComponents();
        
        //connect to db        
        con = DBconnect.connect();
        
        //load table
        extraActivityTableLoad();
        wardTableLoad();
        clinicTableLoad();
        
        txtClinicNameSearch.setVisible(false);
        lblClinicNameSearch.setVisible(false);
        btnClearSearch.setVisible(false);
        lblRoomNoSearch.setVisible(false);
        txtRoomNoSearch.setVisible(false);
        
        btnUpdateClinic.setEnabled(false);
        btnDeleteClinic.setEnabled(false);
        
        btnUpdateExtra.setEnabled(false);
        btnDeleteExtra.setEnabled(false);
        
        btnUpdateWard.setEnabled(false);
        btnDeleteWard.setEnabled(false);
        
        NoClinic.setVisible(false);
        NoExtra.setVisible(false);
        NoWard.setVisible(false);
        
        labelWarning.setVisible(false);
        
        AutoCompleteDecorator.decorate(cmbStaffnameSearch);
        AutoCompleteDecorator.decorate(cmbStaffNameClinic);
                
        try
        {
            String sql = "Select name FROM employee";
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                String r = rs.getString("name");
                cmbStaffnameSearch.addItem(r);
                cmbStaffNameClinic.addItem(r);
            }
            
            String sql2 = "Select clinic FROM clinicschedule";
            ps = (PreparedStatement) con.prepareStatement(sql2);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                String r = rs.getString("clinic");
                cmbClinicNameClinic.addItem(r);                
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    public void setUserDetails(String Username, int level){
        if(level==100){
            lbl_userinfo.setText("<html>Hello "+Username+"<br> Level : Admin </html>");
            
            
        }else if(level==75){
            lbl_userinfo.setText("<html>Hello "+Username+"<br> Level : Doctor </html>");
             
        }else if(level==65){
           
           
            lbl_userinfo.setText("<html>Hello "+Username+"<br> Level : Nurse/Receptionist </html>");
        }
    
    }
    public void extraActivityTableLoad()
    {
        try
        {
            String sql = "SELECT No,Staff_ID,Staff_Name,Location,Date,Time,Additional_Notes FROM extraactivity";

            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            tableExtraActivity.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void wardTableLoad()
    {
        try
        {
            String sql = "SELECT No,Staff_ID,Staff_Name,Date,Time,Section,Ward_No,Floor FROM ward";
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            tableWard.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
   /* public void searchTableLoad()
    {
        try
        {
            String sql = "SELECT ID,Doctor_ID,Day,Doctor_Name,Room_No FROM clinicschedule";
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            tableSearch.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
        }        
    }*/
    
    public void clinicTableLoad()
    {
        try
        {
            String sql = "SELECT No,Doctor_Name,Clinic FROM clinic_allocation";
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            tableClinic.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e)
        {
            System.out.println(e);
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

        jLabel15 = new javax.swing.JLabel();
        lbl_userinfo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        ward = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        cmbStaffnameSearch = new javax.swing.JComboBox();
        lblClinicNameSearch = new javax.swing.JLabel();
        txtClinicNameSearch = new javax.swing.JTextField();
        btnClearSearch = new javax.swing.JButton();
        lblRoomNoSearch = new javax.swing.JLabel();
        txtRoomNoSearch = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnInsertClinic = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClinic = new javax.swing.JTable();
        btnUpdateClinic = new javax.swing.JButton();
        btnDeleteClinic = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        cmbClinicNameClinic = new javax.swing.JComboBox();
        cmbStaffNameClinic = new javax.swing.JComboBox();
        NoClinic = new javax.swing.JLabel();
        btnClearClinic = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStaffNameWard = new javax.swing.JTextField();
        cmbSectionWard = new javax.swing.JComboBox();
        btnInsertWard = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableWard = new javax.swing.JTable();
        btnUpdateWard = new javax.swing.JButton();
        btnDeleteWard = new javax.swing.JButton();
        datePickerWard = new org.jdesktop.swingx.JXDatePicker();
        jLabel26 = new javax.swing.JLabel();
        txtFloorWard = new javax.swing.JTextField();
        txtWardNoWard = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        spinnerTime1Ward = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        spinnerTime2Ward = new javax.swing.JSpinner();
        cmbTime3Ward = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtStaffidWard = new javax.swing.JTextField();
        btnClearWard = new javax.swing.JButton();
        NoWard = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableExtraActivity = new javax.swing.JTable();
        btnInsertExtra = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnDeleteExtra = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btnUpdateExtra = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtStaffidExtra = new javax.swing.JTextField();
        cmbLocationExtra = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtAreaAdditionalExtra = new javax.swing.JTextArea();
        datePickerExtra = new org.jdesktop.swingx.JXDatePicker();
        spinnerTime1Extra = new javax.swing.JSpinner();
        spinnerTime2Extra = new javax.swing.JSpinner();
        cmbTime3Extra = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnClearExtra = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtStaffNameExtra = new javax.swing.JTextField();
        NoExtra = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnDisplayReport = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableReports = new javax.swing.JTable();
        btnGenerateReport = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtStaffidReports = new javax.swing.JTextField();
        labelWarning = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOSPITAL MANAGEMENT SYSTEM");
        setMinimumSize(new java.awt.Dimension(830, 630));
        setPreferredSize(new java.awt.Dimension(830, 630));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Profile");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel15);
        jLabel15.setBounds(631, 11, 50, 20);

        lbl_userinfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_userinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_userinfo.setText("<html>Hello Sleepy!<br> level : Admin </html>");
        getContentPane().add(lbl_userinfo);
        lbl_userinfo.setBounds(560, 40, 190, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Logout");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel13);
        jLabel13.setBounds(623, 73, 50, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staffallocation/admin1.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(742, 11, 60, 80);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staffallocation/home.png"))); // NOI18N
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 20, 70, 70);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 100, 780, 10);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Staff Name");

        btnSearch.setText("Search");
        btnSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbStaffnameSearch.setEditable(true);
        cmbStaffnameSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enter name here" }));
        cmbStaffnameSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cmbStaffnameSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cmbStaffnameSearchKeyTyped(evt);
            }
        });

        lblClinicNameSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblClinicNameSearch.setText("Clinic Name");

        btnClearSearch.setText("Clear");
        btnClearSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSearchActionPerformed(evt);
            }
        });

        lblRoomNoSearch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRoomNoSearch.setText("Room No");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblClinicNameSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRoomNoSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbStaffnameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClinicNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClearSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtRoomNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStaffnameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClinicNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClinicNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRoomNoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );

        ward.addTab("Search", jPanel5);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Staff Name");

        btnInsertClinic.setText("Insert");
        btnInsertClinic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertClinicActionPerformed(evt);
            }
        });

        tableClinic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableClinic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClinicMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClinic);

        btnUpdateClinic.setText("Update");
        btnUpdateClinic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateClinicActionPerformed(evt);
            }
        });

        btnDeleteClinic.setText("Delete");
        btnDeleteClinic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteClinicActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Clinic Name");

        cmbClinicNameClinic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Clinic" }));

        cmbStaffNameClinic.setEditable(true);
        cmbStaffNameClinic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enter name here" }));

        NoClinic.setText("jLabel31");

        btnClearClinic.setText("Clear");
        btnClearClinic.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClearClinic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearClinicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnInsertClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(cmbClinicNameClinic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbStaffNameClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(NoClinic)
                .addGap(85, 85, 85))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbStaffNameClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClinicNameClinic, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertClinic)
                    .addComponent(btnUpdateClinic)
                    .addComponent(btnDeleteClinic)
                    .addComponent(btnClearClinic)
                    .addComponent(NoClinic))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        ward.addTab("Clinic Allocation", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Staff name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Date ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Section");

        txtStaffNameWard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStaffNameWardKeyPressed(evt);
            }
        });

        cmbSectionWard.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Section", "Paediatric Ward", "Dermatology Ward", "Cardiology Ward", "Diabetes Ward", "Gyn care Ward", "Orthopaedic Ward", "Sergical Ward", "ENT Ward" }));
        cmbSectionWard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                cmbSectionWardMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                cmbSectionWardMouseMoved(evt);
            }
        });
        cmbSectionWard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbSectionWardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cmbSectionWardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cmbSectionWardMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbSectionWardMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbSectionWardMouseReleased(evt);
            }
        });

        btnInsertWard.setText("Insert");
        btnInsertWard.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertWardActionPerformed(evt);
            }
        });

        tableWard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableWard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableWardMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableWard);

        btnUpdateWard.setText("Update");
        btnUpdateWard.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateWardActionPerformed(evt);
            }
        });

        btnDeleteWard.setText("Delete");
        btnDeleteWard.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteWardActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Floor");

        txtWardNoWard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtWardNoWardMouseClicked(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Ward No");

        spinnerTime1Ward.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTime1WardStateChanged(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText(":");

        spinnerTime2Ward.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTime2WardStateChanged(evt);
            }
        });

        cmbTime3Ward.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Time");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Staff ID");

        txtStaffidWard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtStaffidWardMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtStaffidWardMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtStaffidWardMouseReleased(evt);
            }
        });
        txtStaffidWard.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStaffidWardKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStaffidWardKeyReleased(evt);
            }
        });

        btnClearWard.setText("Clear");
        btnClearWard.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClearWard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearWardActionPerformed(evt);
            }
        });

        NoWard.setText("No");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NoWard, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(74, 74, 74))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(42, 42, 42)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFloorWard, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtWardNoWard, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(spinnerTime1Ward, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(spinnerTime2Ward, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cmbTime3Ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtStaffNameWard, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                        .addComponent(datePickerWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbSectionWard, 0, 208, Short.MAX_VALUE))
                                    .addComponent(txtStaffidWard, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(42, 42, 42)
                        .addComponent(btnInsertWard, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateWard, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteWard, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearWard, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStaffidWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStaffNameWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(datePickerWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTime1Ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(spinnerTime2Ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTime3Ward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cmbSectionWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWardNoWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInsertWard)
                        .addComponent(btnUpdateWard)
                        .addComponent(btnDeleteWard)
                        .addComponent(btnClearWard))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtFloorWard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NoWard)
                .addContainerGap())
        );

        ward.addTab("Ward Allocation", jPanel2);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Extra Activities");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Staff ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Date & Time");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Location");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Additional notes");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Location", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jButton10.setText("Insert");
        jButton10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton11.setText("Delete");
        jButton11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton12.setText("Update");
        jButton12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(60, 60, 60)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(9, 9, 9)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton10)
                        .addComponent(jButton11)
                        .addComponent(jButton12)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableExtraActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableExtraActivity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableExtraActivityMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableExtraActivity);

        btnInsertExtra.setText("Insert");
        btnInsertExtra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnInsertExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertExtraActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Staff ID");

        btnDeleteExtra.setText("Delete");
        btnDeleteExtra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDeleteExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteExtraActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Date");

        btnUpdateExtra.setText("Update");
        btnUpdateExtra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnUpdateExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateExtraActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Location");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Additional notes");

        txtStaffidExtra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStaffidExtraKeyReleased(evt);
            }
        });

        cmbLocationExtra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Location", "Colombo", "Kandy", "Galle", "Kurunegala", "Jaffna", "Anuradhapura", "Puttalam", "Matara", "Batticaloa", "Trincomalee", "Nuwara-eliya" }));
        cmbLocationExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLocationExtraActionPerformed(evt);
            }
        });

        txtAreaAdditionalExtra.setColumns(20);
        txtAreaAdditionalExtra.setRows(5);
        jScrollPane6.setViewportView(txtAreaAdditionalExtra);

        datePickerExtra.setName("datepick"); // NOI18N
        datePickerExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datePickerExtraActionPerformed(evt);
            }
        });

        spinnerTime1Extra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTime1ExtraStateChanged(evt);
            }
        });

        spinnerTime2Extra.setName(""); // NOI18N
        spinnerTime2Extra.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerTime2ExtraStateChanged(evt);
            }
        });

        cmbTime3Extra.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AM", "PM" }));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Time");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText(":");

        btnClearExtra.setText("Clear");
        btnClearExtra.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClearExtra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearExtraActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Staff name");

        txtStaffNameExtra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStaffNameExtraKeyPressed(evt);
            }
        });

        NoExtra.setText("No");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnInsertExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClearExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NoExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbLocationExtra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(datePickerExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStaffNameExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtStaffidExtra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(spinnerTime1Extra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinnerTime2Extra, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbTime3Extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 386, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 385, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtStaffidExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtStaffNameExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmbLocationExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(datePickerExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerTime1Extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerTime2Extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTime3Extra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnInsertExtra)
                        .addComponent(btnUpdateExtra)
                        .addComponent(btnDeleteExtra)
                        .addComponent(btnClearExtra)
                        .addComponent(NoExtra)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 209, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 209, Short.MAX_VALUE)))
        );

        ward.addTab("Extra Activities", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnDisplayReport.setText("Display Report");
        btnDisplayReport.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tableReports);

        btnGenerateReport.setText("Generate Report");
        btnGenerateReport.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Staff ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(67, 67, 67)
                        .addComponent(txtStaffidReports, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btnDisplayReport, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(btnGenerateReport, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(116, 116, 116))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStaffidReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDisplayReport))
                        .addComponent(jLabel19))
                    .addComponent(btnGenerateReport))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        ward.addTab("Reports", jPanel4);

        getContentPane().add(ward);
        ward.setBounds(20, 115, 780, 450);

        labelWarning.setBackground(new java.awt.Color(255, 51, 0));
        labelWarning.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelWarning.setText("Warnings and Notifications will be here");
        labelWarning.setOpaque(true);
        getContentPane().add(labelWarning);
        labelWarning.setBounds(20, 570, 779, 18);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(-10, 760, 820, 0);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText("Staff Allocation System");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(300, 30, 210, 40);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/staffallocation/11806788_1135526379794041_692436290_o.jpg"))); // NOI18N
        jLabel21.setText("jLabel21");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(0, 0, 830, 630);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbLocationExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLocationExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLocationExtraActionPerformed

    private void btnInsertExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertExtraActionPerformed
         
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Insert?");
        
        if(x==0)
        {
            String id = txtStaffidExtra.getText();
            String name = txtStaffNameExtra.getText();
            String loc = cmbLocationExtra.getSelectedItem().toString();

            Date date = datePickerExtra.getDate();

            //check spinnerTime1 value is lessthan 10
            int t1 = Integer.parseInt(spinnerTime1Extra.getValue().toString());
            String time1;

            if (t1 < 10)
            {
                time1 = "0"+String.valueOf(t1);

            }
            else
            {
                time1 = spinnerTime1Extra.getValue().toString();
            }

            //check spinnerTime2 value is lessthan 10
            int t2 = Integer.parseInt(spinnerTime2Extra.getValue().toString());
            String time2;

            if (t2 < 10)
            {
                time2 = "0"+String.valueOf(t2);

            }
            else
            {
                time2 = spinnerTime2Extra.getValue().toString();
            }


            String ap = cmbTime3Extra.getSelectedItem().toString();
            String time = time1+" : " + time2+" "+ ap;

            String addi = txtAreaAdditionalExtra.getText();

            try
            {
                if((id.length() !=0) && id.matches("[a-z0-9]\\w*"))
                {
                    if(((name.length() !=0) && name.matches("\\D+")))
                    {
                        if(!loc.equals("Select Location"))
                        { 
                            if(date != null)
                            { 
                                if(t1 !=0)
                                {                            
                                    if((addi.length() !=0))
                                    {        
                                        Instant instant = date.toInstant();
                                        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

                                        String q = "INSERT INTO extraactivity (Staff_ID,Staff_Name,Location,Date,Time,Additional_Notes) values ('"+id+"','"+name+"','"+loc+"','"+localDate+"','"+time+"','"+addi+"')";
                                        ps = (PreparedStatement) con.prepareStatement(q);
                                        ps.executeUpdate();

                                        extraActivityTableLoad();

                                        labelWarning.setVisible(true);
                                        
                                        labelWarning.setText("Extra Activity is successfully Inserted for "+txtStaffNameExtra.getText()+".");
                                        labelWarning.setBackground(Color.cyan);
                                    }
                                    else
                                       JOptionPane.showMessageDialog(null,"Please Type Additional Notes.","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                  JOptionPane.showMessageDialog(null,"Please Select Time.","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                               JOptionPane.showMessageDialog(null,"Please Select Date.","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Please Select Location.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(name.length()==0)
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Staff Name.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);

            }
            catch (SQLException | HeadlessException e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnInsertExtraActionPerformed

    private void datePickerExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datePickerExtraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datePickerExtraActionPerformed

    private void btnUpdateExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateExtraActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Update?");
        if(x==0)
        {
            String id = txtStaffidExtra.getText();
            String name = txtStaffNameExtra.getText();
            String loc = cmbLocationExtra.getSelectedItem().toString();

            Date date = datePickerExtra.getDate();
                    
            //check spinnerTime1 value is lessthan 10
            int t1 = Integer.parseInt(spinnerTime1Extra.getValue().toString());
            String time1;

            if (t1 < 10)
            {
                time1 = "0"+String.valueOf(t1);
            }
            else
            {
                time1 = spinnerTime1Extra.getValue().toString();
            }

            //check spinnerTime2 value is lessthan 10
            int t2 = Integer.parseInt(spinnerTime2Extra.getValue().toString());
            String time2;

            if (t2 < 10)
            {
                time2 = "0"+String.valueOf(t2);
            }
            else
            {
                time2 = spinnerTime2Extra.getValue().toString();
            }
            
            String ap = cmbTime3Extra.getSelectedItem().toString();
            String time = time1+" : " + time2+" "+ ap;

            String addi = txtAreaAdditionalExtra.getText();

            
            try
            {
                if((id.length() !=0) && id.matches("[a-z0-9]\\w*"))
                {
                    if(((name.length() !=0) && name.matches("\\D+")))
                    {
                        if(!loc.equals("Select Location"))
                        { 
                            if(date != null)
                            { 
                                if(t1 !=0)
                                {                            
                                    if((addi.length() !=0))
                                    { 
                                        String no = NoExtra.getText();
                                        
                                        Instant instant = date.toInstant();
                                        LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
            
                                        String q = "UPDATE extraactivity SET Staff_ID='"+id+"',Staff_Name='"+name+"',Location='"+loc+"',Date='"+localDate+"',Time='"+time+"',Additional_Notes='"+addi+"' WHERE No='"+no+"'";
                                        ps = (PreparedStatement) con.prepareStatement(q);
                                        ps.execute();

                                        //load table
                                        extraActivityTableLoad();
                                        
                                        labelWarning.setVisible(true);
                                        
                                        labelWarning.setText("Extra Activity is Successfully Updated for "+txtStaffNameExtra.getText()+".");
                                        labelWarning.setBackground(Color.green);
                                    }
                                    else
                                       JOptionPane.showMessageDialog(null,"Please Type Additional Notes.","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                  JOptionPane.showMessageDialog(null,"Please Select Time.","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                               JOptionPane.showMessageDialog(null,"Please Select Date.","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Please Select Location.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(name.length()==0)
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Staff Name.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            catch (SQLException | HeadlessException e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btnUpdateExtraActionPerformed

    private void spinnerTime2ExtraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTime2ExtraStateChanged
        
        
        if(Integer.parseInt(spinnerTime2Extra.getValue().toString()) > 60)
        {
            spinnerTime2Extra.setValue(0);
        }
        else if(Integer.parseInt(spinnerTime2Extra.getValue().toString()) < 0){
            spinnerTime2Extra.setValue(0);
        }
    }//GEN-LAST:event_spinnerTime2ExtraStateChanged

    private void spinnerTime1ExtraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTime1ExtraStateChanged
        
        if(Integer.parseInt(spinnerTime1Extra.getValue().toString()) > 12)
        {
            spinnerTime1Extra.setValue(0);
        }
        else if(Integer.parseInt(spinnerTime1Extra.getValue().toString()) < 0){
            spinnerTime1Extra.setValue(0);
        }
    }//GEN-LAST:event_spinnerTime1ExtraStateChanged

    private void btnDeleteExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteExtraActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Delete?");
        
        if(x==0)
        {
            String no = NoExtra.getText();
            try
            {
                String q="DELETE FROM extraactivity WHERE No='"+no+"'";
                ps=(PreparedStatement) con.prepareStatement(q); 
                ps.execute();
            
                //load table
                extraActivityTableLoad();
                
                labelWarning.setVisible(true);
                
                labelWarning.setText("Extra Activity is Successfully Deleted for "+txtStaffNameExtra.getText()+".");
                labelWarning.setBackground(Color.yellow);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        
        }
    }//GEN-LAST:event_btnDeleteExtraActionPerformed

    private void btnInsertWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertWardActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Insert?");
        
        if(x==0)
        {
            String id = txtStaffidWard.getText();              
            String name = txtStaffNameWard.getText();

            Date date = datePickerWard.getDate();

            //check spinnerTime1 value is lessthan 10         
            int t1 = Integer.parseInt(spinnerTime1Ward.getValue().toString());
            String time1;

            if (t1 < 10)
            {
                time1 = "0"+String.valueOf(t1);                    
            }
            else
            {
                time1 = spinnerTime1Ward.getValue().toString();
            }

            //check spinnerTime2 value is lessthan 10
            int t2 = Integer.parseInt(spinnerTime2Ward.getValue().toString());
            String time2;

            if (t2 < 10)
            {
                time2 = "0"+String.valueOf(t2);                    
            }
            else
            {
                time2 = spinnerTime2Ward.getValue().toString();
            }


            String ap = cmbTime3Ward.getSelectedItem().toString();
            String time = time1+" : " + time2+" "+ ap;

            String sec = cmbSectionWard.getSelectedItem().toString();        
            String wrd = txtWardNoWard.getText();        
            String flr = txtFloorWard.getText();

            try
            {
                if((id.length() !=0) && id.matches("[a-z0-9]\\w*"))
                {
                    if((name.length() !=0) && name.matches("\\D+"))
                    {
                        if (date != null)
                        {
                            if(t1 !=0)
                            {
                                if(!sec.equals("Select Section"))
                                { 
                                    if((sec.equals("Paediatric Ward") && wrd.equals("PD-001")) || (sec.equals("Dermatology Ward") && wrd.equals("DT-002")) || (sec.equals("Cardiology Ward") && wrd.equals("CD-003")) ||(sec.equals("Diabetes Ward") && wrd.equals("DB-004")) ||(sec.equals("Gyn care Ward") && wrd.equals("GC-005")) ||(sec.equals("Orthopaedic Ward") && wrd.equals("OP-006")) ||(sec.equals("Sergical Ward") && wrd.equals("SG-007")) ||(sec.equals("ENT Ward") && wrd.equals("ENT-008")))
                                    {
                                        if((wrd.length() !=0) && wrd.contains("-"))
                                        {                             
                                            if((flr.length() !=0) && flr.matches("[0-9]"))
                                            {
                                                Instant instant = date.toInstant();
                                                LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();

                                                String q = "INSERT INTO ward (Staff_ID,Staff_Name,Date,Time,Section,Ward_No,Floor) values ('"+id+"','"+name+"','"+localDate+"','"+time+"','"+sec+"','"+wrd+"','"+flr+"')";
                                                ps = (PreparedStatement) con.prepareStatement(q);
                                                ps.execute();

                                                //load table
                                                wardTableLoad();

                                                labelWarning.setVisible(true);
                                                
                                                labelWarning.setText("Ward Allocation is successfully done for "+txtStaffNameWard.getText()+".");
                                                labelWarning.setBackground(Color.cyan);
                                            }
                                            else if(flr.length()==0)
                                            {
                                                JOptionPane.showMessageDialog(null,"Please Enter Floor Number.","ERROR",JOptionPane.ERROR_MESSAGE);
                                            }
                                            else
                                              JOptionPane.showMessageDialog(null,"Please Enter Correct Floor Number.","ERROR",JOptionPane.ERROR_MESSAGE);
                                        }
                                        else
                                           JOptionPane.showMessageDialog(null,"Please Enter Ward.","ERROR",JOptionPane.ERROR_MESSAGE);
                                    }
                                    else
                                        JOptionPane.showMessageDialog(null,"Please Click 'Ward No' Text Field for Get Correct Ward Number.","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                  JOptionPane.showMessageDialog(null,"Please Select Section.","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                               JOptionPane.showMessageDialog(null,"Please Select Correct Time.","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Please Select Date.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else if(name.length()==0)
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Staff Name.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            catch (SQLException | HeadlessException e)
            {
                System.out.println(e);
            }
        }
        
    }//GEN-LAST:event_btnInsertWardActionPerformed

    private void spinnerTime1WardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTime1WardStateChanged
        
        if(Integer.parseInt(spinnerTime1Ward.getValue().toString()) > 12)
        {
            spinnerTime1Ward.setValue(0);
        }
        else if(Integer.parseInt(spinnerTime1Ward.getValue().toString()) < 0){
            spinnerTime1Ward.setValue(0);
        }
    }//GEN-LAST:event_spinnerTime1WardStateChanged

    private void spinnerTime2WardStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerTime2WardStateChanged
        
        if(Integer.parseInt(spinnerTime2Ward.getValue().toString()) > 60)
        {
            spinnerTime2Ward.setValue(0);
        }
        else if(Integer.parseInt(spinnerTime2Ward.getValue().toString()) < 0){
            spinnerTime2Ward.setValue(0);
        }
    }//GEN-LAST:event_spinnerTime2WardStateChanged

    private void btnUpdateWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateWardActionPerformed
       
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Update?");
        if(x==0)
        {
          String name = txtStaffNameWard.getText();
          String id = txtStaffidWard.getText();

          Date date = datePickerWard.getDate();
     
          //check spinnerTime1 value is lessthan 10
          int t1 = Integer.parseInt(spinnerTime1Ward.getValue().toString());
          String time1;

          if (t1 < 10)
          {
              time1 = "0"+String.valueOf(t1);

          }
          else
          {
              time1 = spinnerTime1Ward.getValue().toString();
          }

          //check spinnerTime2 value is lessthan 10
          int t2 = Integer.parseInt(spinnerTime2Ward.getValue().toString());
          String time2;

          if (t2 < 10)
          {
              time2 = "0"+String.valueOf(t2);

          }
          else
          {
              time2 = spinnerTime2Ward.getValue().toString();
          }


          String ap = cmbTime3Ward.getSelectedItem().toString();
          String time = time1+" : " + time2+" "+ ap;

          String sec = cmbSectionWard.getSelectedItem().toString();
          String wrd = txtWardNoWard.getText();
          String flr = txtFloorWard.getText();

          try
          {
            if((id.length() !=0) && id.matches("[a-z0-9]\\w*"))
            {
                if((name.length() !=0) && name.matches("\\D+"))
                {
                    if(date != null)
                    { 
                        if(t1 !=0)
                        {
                            if(!sec.equals("Select Section"))
                            { 
                                if((sec.equals("Paediatric Ward") && wrd.equals("PD-001")) || (sec.equals("Dermatology Ward") && wrd.equals("DT-002")) || (sec.equals("Cardiology Ward") && wrd.equals("CD-003")) ||(sec.equals("Diabetes Ward") && wrd.equals("DB-004")) ||(sec.equals("Gyn care Ward") && wrd.equals("GC-005")) ||(sec.equals("Orthopaedic Ward") && wrd.equals("OP-006")) ||(sec.equals("Sergical Ward") && wrd.equals("SG-007")) ||(sec.equals("ENT Ward") && wrd.equals("ENT-008")))
                                {    
                                    if((wrd.length() !=0) && wrd.contains("-"))
                                    {                             
                                        if((flr.length() !=0) && flr.matches("[0-9]"))
                                        {
                                            Instant instant = date.toInstant();
                                            LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
          
                                            String no = NoWard.getText();
                                            
                                            String q = "UPDATE ward SET Staff_Name='"+name+"',Staff_ID='"+id+"',Date='"+localDate+"',Time='"+time+"',Section='"+sec+"',Ward_No='"+wrd+"',Floor='"+flr+"' WHERE No='"+no+"'";
                                            ps = (PreparedStatement) con.prepareStatement(q);
                                            ps.execute();

                                            //load table
                                            wardTableLoad();

                                            labelWarning.setVisible(true);
                                            
                                            labelWarning.setText("Ward Allocation is Successfully Updated for "+txtStaffNameWard.getText()+".");
                                            labelWarning.setBackground(Color.green);
                                        }
                                        else if(flr.length()==0)
                                            {
                                                JOptionPane.showMessageDialog(null,"Please Enter Floor Number.","ERROR",JOptionPane.ERROR_MESSAGE);
                                            }
                                        else
                                          JOptionPane.showMessageDialog(null,"Please Enter Correct Floor Number.","ERROR",JOptionPane.ERROR_MESSAGE);
                                    }
                                    else
                                       JOptionPane.showMessageDialog(null,"Please Enter Ward.","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                                else
                                    JOptionPane.showMessageDialog(null,"Please Click 'Ward No' Text Field for Get Correct Ward Number.","ERROR",JOptionPane.ERROR_MESSAGE);
                            }
                            else
                              JOptionPane.showMessageDialog(null,"Please Select Section.","ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                           JOptionPane.showMessageDialog(null,"Please Select Correct Time.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Please Select Date.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else if(name.length()==0)
                    {
                        JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                else
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Staff Name.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null,"Please Enter Correct Staff ID.","ERROR",JOptionPane.ERROR_MESSAGE);
              
          }
          catch (SQLException | HeadlessException e)
          {
              System.out.println(e);
          }

        }
    }//GEN-LAST:event_btnUpdateWardActionPerformed

    private void btnDeleteWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteWardActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Delete?");
        
        if(x==0)
        {
            String no = NoWard.getText();
            try
            {
                String q="DELETE FROM ward WHERE No='"+no+"'";
                ps=(PreparedStatement) con.prepareStatement(q); 
                ps.execute();
            
                //load table
                wardTableLoad();
                
                labelWarning.setVisible(true);
                
                labelWarning.setText("Ward Allocation is Successfully Deleted for "+txtStaffNameWard.getText()+".");
                labelWarning.setBackground(Color.yellow);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        
        }
    }//GEN-LAST:event_btnDeleteWardActionPerformed

    private void tableWardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableWardMouseClicked
        
        try
        {
            btnInsertWard.setEnabled(false);
            btnUpdateWard.setEnabled(true);
            btnDeleteWard.setEnabled(true);
                        
            int raw = tableWard.getSelectedRow();

            String no = tableWard.getValueAt(raw, 0).toString();
            String id = tableWard.getValueAt(raw, 1).toString();
            String name = tableWard.getValueAt(raw, 2).toString();
            
            String sdate = tableWard.getValueAt(raw, 3).toString();  
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = format.parse(sdate);

            String time = tableWard.getValueAt(raw, 4).toString();
            String sec = tableWard.getValueAt(raw, 5).toString();
            String wrd = tableWard.getValueAt(raw, 6).toString();
            String flr = tableWard.getValueAt(raw, 7).toString();

            String[] parts = time.split(" ");
            String time1 = parts[0];
            String time2 = parts[2];
            String ap = parts[3];

            txtStaffNameWard.setText(name);
            txtStaffidWard.setText(id);                     
            datePickerWard.setDate(date);

            spinnerTime1Ward.setValue(new Integer(time1));
            spinnerTime2Ward.setValue(new Integer(time2));
            cmbTime3Ward.setSelectedItem(ap);
            cmbSectionWard.setSelectedItem(sec);
            txtWardNoWard.setText(wrd);
            txtFloorWard.setText(flr);
            NoWard.setText(no);
        }
        catch(ParseException | NumberFormatException e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_tableWardMouseClicked

    private void btnClearExtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearExtraActionPerformed
               
            txtStaffidExtra.setText(null);
            txtStaffNameExtra.setText(null);
            cmbLocationExtra.setSelectedItem("Select Location");
            datePickerExtra.setDate(null);

            spinnerTime1Extra.setValue(0);
            spinnerTime2Extra.setValue(0);
            cmbTime3Extra.setSelectedItem("AM");
            txtAreaAdditionalExtra.setText(null);
            
            btnInsertExtra.setEnabled(true);
            btnUpdateExtra.setEnabled(false);
            btnDeleteExtra.setEnabled(false);
            
            labelWarning.setVisible(false);
    }//GEN-LAST:event_btnClearExtraActionPerformed

    private void btnClearWardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearWardActionPerformed
        
            txtStaffNameWard.setText(null);
            txtStaffidWard.setText(null);                     
            datePickerWard.setDate(null);

            spinnerTime1Ward.setValue(0);
            spinnerTime2Ward.setValue(0);
            cmbTime3Ward.setSelectedItem("AM");
            cmbSectionWard.setSelectedItem("Select Section");
            txtWardNoWard.setText(null);
            txtFloorWard.setText(null);
            
            btnInsertWard.setEnabled(true);
            btnUpdateWard.setEnabled(false);
            btnDeleteWard.setEnabled(false);
            
            labelWarning.setVisible(false);
    }//GEN-LAST:event_btnClearWardActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        
        String name = cmbStaffnameSearch.getSelectedItem().toString();
        
        try
        {
            
                String q="SELECT Clinic FROM clinic_allocation WHERE Doctor_Name='"+name+"'";
                ps=(PreparedStatement) con.prepareStatement(q); 
                rs=ps.executeQuery();
                
                if(rs.next())
                {
                    String cln = rs.getString("Clinic");

                    String q1 = "SELECT roomNo FROM clinicschedule WHERE clinic='"+cln+"'";
                    ps=(PreparedStatement) con.prepareStatement(q1); 
                    rs1=ps.executeQuery();
                    
                    rs1.next();
                    String roomNo = rs1.getString("roomNo");
                
                    Calendar calendar = Calendar.getInstance();
                    Date date = calendar.getTime();
                    String dayName = new SimpleDateFormat("EE",Locale.ENGLISH).format(date.getTime());

                    String q2="";

                    switch (dayName) {
                        case "Mon":
                            {
                                q2 = "SELECT clinic FROM clinic_monday WHERE clinic = '"+cln+"'";
                                break;
                            }
                        case "Tue":
                            {
                                q2 = "SELECT clinic FROM clinic_tuesday WHERE clinic = '"+cln+"'";
                                break;
                            }
                        case "Wed":
                            {
                                q2 = "SELECT clinic FROM clinic_wednesday WHERE clinic = '"+cln+"'";
                                break;
                            }
                        case "Thu":
                            {
                                q2 = "SELECT clinic FROM clinic_thursday WHERE clinic = '"+cln+"'";
                                break;
                            }
                        case "Fri":
                            {
                                q2 = "SELECT clinic FROM clinic_friday WHERE clinic = '"+cln+"'";
                                break;
                            }
                        case "Sat":
                            {
                                q2 = "SELECT clinic FROM clinic_saturday WHERE clinic = '"+cln+"'";
                                break;
                            }
                    }

                    ps=(PreparedStatement) con.prepareStatement(q2); 
                    rs2=ps.executeQuery();

                    if(rs2.next())
                    {
                        String cl = rs2.getString("clinic");

                        txtClinicNameSearch.setVisible(true);
                        lblClinicNameSearch.setVisible(true);
                        btnClearSearch.setVisible(true);
                        lblRoomNoSearch.setVisible(true);
                        txtRoomNoSearch.setVisible(true);

                        txtClinicNameSearch.setText(cl);
                        txtRoomNoSearch.setText(roomNo);
                        
                        labelWarning.setVisible(false);
                    }
                    else
                    {
                        labelWarning.setVisible(true);
                        
                        labelWarning.setText("The Clinic is not available today for "+ cmbStaffnameSearch.getSelectedItem().toString()+".");
                        labelWarning.setBackground(Color.red);
                    }
                }
                else
                {
                    labelWarning.setVisible(true);
                    
                    labelWarning.setText(cmbStaffnameSearch.getSelectedItem().toString()+" is not Allocated for the Clinic.");
                    labelWarning.setBackground(Color.red);
                }
       
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnInsertClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertClinicActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Insert?");
        
        if(x==0)
        {
            String name = cmbStaffNameClinic.getSelectedItem().toString();
            String clinic = cmbClinicNameClinic.getSelectedItem().toString();
            try
            {
                if((name.length() !=0) && (name.matches("\\D+")) && (!name.equals("Enter name here")))
                {
                    if((clinic.length() !=0) && (clinic.matches("\\D+")) && (!clinic.equals("Select Clinic")))
                    {
                            String q="INSERT INTO clinic_allocation(Doctor_Name,Clinic) values('"+name+"','"+clinic+"')";
                            ps=(PreparedStatement) con.prepareStatement(q); 
                            ps.execute();

                            //load table
                            clinicTableLoad();

                            labelWarning.setVisible(true);
                            
                            labelWarning.setText("Clinic Allocation is Successfully done  for "+ cmbStaffNameClinic.getSelectedItem().toString()+".");
                            labelWarning.setBackground(Color.cyan);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Please Select Clinic Name.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Staff Name.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            catch (SQLException | HeadlessException e)
            {
                System.out.println(e);
            }      
        }
    }//GEN-LAST:event_btnInsertClinicActionPerformed

    private void txtStaffidWardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffidWardMouseReleased
        

    }//GEN-LAST:event_txtStaffidWardMouseReleased

    private void txtStaffidWardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffidWardMouseExited
        
        
    }//GEN-LAST:event_txtStaffidWardMouseExited

    private void txtStaffidWardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtStaffidWardMouseClicked
        
    }//GEN-LAST:event_txtStaffidWardMouseClicked

    private void txtStaffNameWardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffNameWardKeyPressed
        
    }//GEN-LAST:event_txtStaffNameWardKeyPressed

    private void txtStaffidWardKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffidWardKeyPressed
        
    }//GEN-LAST:event_txtStaffidWardKeyPressed

    private void txtStaffidWardKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffidWardKeyReleased
        
        String id = txtStaffidWard.getText();
        
        try
        {
            String n = "SELECT name FROM employee WHERE employeeNo='"+id+"'";
            ps = (PreparedStatement) con.prepareStatement(n);
            rs = ps.executeQuery();
          
            while(rs.next())
            {
                String r = rs.getString("name");
                
                txtStaffNameWard.setText(r);
            }
            
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_txtStaffidWardKeyReleased

    private void cmbSectionWardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionWardMouseClicked
      
    }//GEN-LAST:event_cmbSectionWardMouseClicked

    private void cmbSectionWardMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionWardMouseReleased
     
    }//GEN-LAST:event_cmbSectionWardMouseReleased

    private void cmbSectionWardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionWardMousePressed
    
    }//GEN-LAST:event_cmbSectionWardMousePressed

    private void cmbSectionWardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionWardMouseEntered
       
        
    }//GEN-LAST:event_cmbSectionWardMouseEntered

    private void cmbSectionWardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionWardMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSectionWardMouseExited

    private void cmbSectionWardMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionWardMouseDragged
          
    
    }//GEN-LAST:event_cmbSectionWardMouseDragged

    private void cmbSectionWardMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbSectionWardMouseMoved
    
    }//GEN-LAST:event_cmbSectionWardMouseMoved

    private void txtWardNoWardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtWardNoWardMouseClicked
       
        String sec = cmbSectionWard.getSelectedItem().toString();
        
        switch (sec) {
            case "Paediatric Ward":
                txtWardNoWard.setText("PD-001");
                break;
            case "Dermatology Ward":
                txtWardNoWard.setText("DT-002");
                break;
            case "Cardiology Ward":
                txtWardNoWard.setText("CD-003");
                break;
            case "Diabetes Ward":
                txtWardNoWard.setText("DB-004");
                break;
            case "Gyn care Ward":
                txtWardNoWard.setText("GC-005");
                break;
            case "Orthopaedic Ward":
                txtWardNoWard.setText("OP-006");
                break;
            case "Sergical Ward":
                txtWardNoWard.setText("SG-007");
                break;
            case "ENT Ward":
                txtWardNoWard.setText("ENT-008");
                break;
        }       
    }//GEN-LAST:event_txtWardNoWardMouseClicked

    private void txtStaffNameExtraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffNameExtraKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStaffNameExtraKeyPressed

    private void txtStaffidExtraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStaffidExtraKeyReleased
        
        String id = txtStaffidExtra.getText();
        
        try
        {
            String n = "SELECT name FROM employee WHERE employeeNo='"+id+"'";
            ps = (PreparedStatement) con.prepareStatement(n);
            rs = ps.executeQuery();
          
            while(rs.next())
            {
                String r = rs.getString("name");
                
                txtStaffNameExtra.setText(r);
            }
            
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_txtStaffidExtraKeyReleased

    private void tableExtraActivityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableExtraActivityMouseClicked

        try
        {
            btnInsertExtra.setEnabled(false);
            btnUpdateExtra.setEnabled(true);
            btnDeleteExtra.setEnabled(true);

            int raw = tableExtraActivity.getSelectedRow();

            String id = tableExtraActivity.getValueAt(raw, 1).toString();
            String name = tableExtraActivity.getValueAt(raw, 2).toString();
            String loc = tableExtraActivity.getValueAt(raw, 3).toString();

            String sdate = tableExtraActivity.getValueAt(raw, 4).toString();
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date = format.parse(sdate);

            String time = tableExtraActivity.getValueAt(raw, 5).toString();
            String addi = tableExtraActivity.getValueAt(raw, 6).toString();

            String[] parts = time.split(" ");
            String time1 = parts[0];
            String time2 = parts[2];
            String ap = parts[3];

            String no = tableExtraActivity.getValueAt(raw, 0).toString();

            txtStaffidExtra.setText(id);
            txtStaffNameExtra.setText(name);
            cmbLocationExtra.setSelectedItem(loc);
            datePickerExtra.setDate(date);

            spinnerTime1Extra.setValue(new Integer(time1));
            spinnerTime2Extra.setValue(new Integer(time2));
            cmbTime3Extra.setSelectedItem(ap);
            txtAreaAdditionalExtra.setText(addi);

            NoExtra.setText(no);
        }
        catch(ParseException | NumberFormatException e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_tableExtraActivityMouseClicked

    private void cmbStaffnameSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbStaffnameSearchKeyTyped
        
        
    }//GEN-LAST:event_cmbStaffnameSearchKeyTyped

    private void cmbStaffnameSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbStaffnameSearchKeyReleased
        
    }//GEN-LAST:event_cmbStaffnameSearchKeyReleased

    private void tableClinicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClinicMouseClicked
        
        try
        {
            btnInsertClinic.setEnabled(false);
            btnUpdateClinic.setEnabled(true);
            btnDeleteClinic.setEnabled(true);

            int raw = tableClinic.getSelectedRow();

            String no = tableClinic.getValueAt(raw, 0).toString();
            String stname = tableClinic.getValueAt(raw, 1).toString();
            String clname = tableClinic.getValueAt(raw, 2).toString();
            
            NoClinic.setText(no);
            cmbStaffNameClinic.setSelectedItem(stname);
            cmbClinicNameClinic.setSelectedItem(clname);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_tableClinicMouseClicked

    private void btnUpdateClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateClinicActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Update?");
        
        if(x==0)
        {
            String name = cmbStaffNameClinic.getSelectedItem().toString();
            String clinic = cmbClinicNameClinic.getSelectedItem().toString();
            String no = NoClinic.getText();
            try
            {
                if(name.length() !=0 && (name.matches("\\D+"))&& (!name.equals("Enter name here")))
                {
                    if((clinic.length() !=0) && (clinic.matches("\\D+"))&& (!clinic.equals("Select Clinic")))
                    {

                            String q="UPDATE clinic_allocation SET Doctor_Name='"+name+"',Clinic='"+clinic+"' WHERE No='"+no+"'";
                            ps=(PreparedStatement) con.prepareStatement(q); 
                            ps.execute();

                            //load table
                            clinicTableLoad();

                            labelWarning.setVisible(true);
                            
                            labelWarning.setText("Clinic Allocation is Successfully Updated  for "+ cmbStaffNameClinic.getSelectedItem().toString()+".");
                            labelWarning.setBackground(Color.green);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Please Select Clinic Name.","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null,"Please Enter Correct Staff Name.","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            catch (SQLException | HeadlessException e)
            {
                System.out.println(e);
            }  
        }
    }//GEN-LAST:event_btnUpdateClinicActionPerformed

    private void btnDeleteClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteClinicActionPerformed
        
        int x=JOptionPane.showConfirmDialog(null, "Do You Want To Delete?");
        
        if(x==0)
        {
            String no = NoClinic.getText();
            try
            {
                String q="DELETE FROM clinic_allocation WHERE No='"+no+"'";
                ps=(PreparedStatement) con.prepareStatement(q); 
                ps.execute();
            
                //load table
                clinicTableLoad();
                
                labelWarning.setVisible(true);
                
                labelWarning.setText("Clinic Allocation is Successfully Deleted for "+cmbStaffNameClinic.getSelectedItem().toString()+".");
                labelWarning.setBackground(Color.yellow);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        
        }
    }//GEN-LAST:event_btnDeleteClinicActionPerformed

    private void btnClearClinicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearClinicActionPerformed
        
        cmbStaffNameClinic.setSelectedItem("Enter name here");
        cmbClinicNameClinic.setSelectedItem("Select Clinic");
        
        btnInsertClinic.setEnabled(true);
        btnUpdateClinic.setEnabled(false);
        btnDeleteClinic.setEnabled(false);
        labelWarning.setVisible(false);
    }//GEN-LAST:event_btnClearClinicActionPerformed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        
        btnClearSearch.setVisible(false);
        txtClinicNameSearch.setVisible(false);
        lblClinicNameSearch.setVisible(false);
        labelWarning.setVisible(false);
        lblRoomNoSearch.setVisible(false);
        txtRoomNoSearch.setVisible(false);
    }//GEN-LAST:event_btnClearSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        home.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(extra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(extra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(extra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(extra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new extra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoClinic;
    private javax.swing.JLabel NoExtra;
    private javax.swing.JLabel NoWard;
    private javax.swing.JButton btnClearClinic;
    private javax.swing.JButton btnClearExtra;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnClearWard;
    private javax.swing.JButton btnDeleteClinic;
    private javax.swing.JButton btnDeleteExtra;
    private javax.swing.JButton btnDeleteWard;
    private javax.swing.JButton btnDisplayReport;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnInsertClinic;
    private javax.swing.JButton btnInsertExtra;
    private javax.swing.JButton btnInsertWard;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateClinic;
    private javax.swing.JButton btnUpdateExtra;
    private javax.swing.JButton btnUpdateWard;
    private javax.swing.JComboBox cmbClinicNameClinic;
    private javax.swing.JComboBox cmbLocationExtra;
    private javax.swing.JComboBox cmbSectionWard;
    private javax.swing.JComboBox cmbStaffNameClinic;
    private javax.swing.JComboBox cmbStaffnameSearch;
    private javax.swing.JComboBox cmbTime3Extra;
    private javax.swing.JComboBox cmbTime3Ward;
    private org.jdesktop.swingx.JXDatePicker datePickerExtra;
    private org.jdesktop.swingx.JXDatePicker datePickerWard;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel labelWarning;
    private javax.swing.JLabel lblClinicNameSearch;
    private javax.swing.JLabel lblRoomNoSearch;
    private javax.swing.JLabel lbl_userinfo;
    private javax.swing.JSpinner spinnerTime1Extra;
    private javax.swing.JSpinner spinnerTime1Ward;
    private javax.swing.JSpinner spinnerTime2Extra;
    private javax.swing.JSpinner spinnerTime2Ward;
    private javax.swing.JTable tableClinic;
    private javax.swing.JTable tableExtraActivity;
    private javax.swing.JTable tableReports;
    private javax.swing.JTable tableWard;
    private javax.swing.JTextArea txtAreaAdditionalExtra;
    private javax.swing.JTextField txtClinicNameSearch;
    private javax.swing.JTextField txtFloorWard;
    private javax.swing.JTextField txtRoomNoSearch;
    private javax.swing.JTextField txtStaffNameExtra;
    private javax.swing.JTextField txtStaffNameWard;
    private javax.swing.JTextField txtStaffidExtra;
    private javax.swing.JTextField txtStaffidReports;
    private javax.swing.JTextField txtStaffidWard;
    private javax.swing.JTextField txtWardNoWard;
    private javax.swing.JTabbedPane ward;
    // End of variables declaration//GEN-END:variables
}
