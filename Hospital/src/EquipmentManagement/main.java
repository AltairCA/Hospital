/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EquipmentManagement;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import java.net.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
//import java

import java.io.*;
import java.text.ParseException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alex
 */
public class main extends javax.swing.JFrame {
   public MainWindow.Mainwindow home;
   public login.Login login;
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    
    
    
  
    public main() {
        initComponents();
       // con = DBConnect.connect();
        
        //connect to DB
        tableload();
        
      
       tableload1();
        
        label.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
          jLabel5.setVisible(false);
        jLabel24.setVisible(false);
     
      jComboBox1.setVisible(false);
      jXDatePicker1.setVisible(false);
      jTextField5.setVisible(false);
     
      jButton3.setVisible(false);
      jButton5.setVisible(false);
      jLabel11.setVisible(false);
     
      jLabel12.setVisible(false);
      jLabel13.setVisible(false);
      jLabel14.setVisible(false);
      jLabel28.setVisible(false);
      jLabel25.setVisible(false);
        jLabel26.setVisible(false);
          jLabel27.setVisible(false);
          jButton8.setVisible(false);
          
          //jLabel41.setVisible(false);
           // jTextField7.setVisible(false);
            
           jTextField7.setVisible(false);
           jTextField8.setVisible(false);
           jTextField9.setVisible(false);
           jTextField10.setVisible(false);
           jTextField11.setVisible(false);
           jTextField12.setVisible(false);
           jComboBox7.setVisible(false);       
           //jXDatePicker4.setVisible(false);
            jLabel46.setVisible(false);
            jLabel36.setVisible(false);
            //jLabel37.setVisible(false);
            jLabel45.setVisible(false);
            jLabel44.setVisible(false);
            jLabel43.setVisible(false);
            jLabel41.setVisible(false);
            jLabel47.setVisible(false);
            jLabel42.setVisible(false);
            jButton17.setVisible(false);
            jButton19.setVisible(false);       
            
              
        
    }
    public void setUserDetails(String Username, int level){
         
         if(level==100){
            lbl_userinfo.setText("<html>Hello "+Username+"<br> level : Admin </html>");
        }else if(level==75){
            lbl_userinfo.setText("<html>Hello "+Username+"<br> level : Doctor </html>");
        }else if(level==65){
            lbl_userinfo.setText("<html>Hello "+Username+"<br> level : Nurse/Receptionist </html>");
        }
    
    }
    public void tableload(){
    
    try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp");     
       @SuppressWarnings("LocalVariableHidesMemberVariable")
       PreparedStatement pst = conn.prepareStatement("Select * from schedules");
       //pst.setString(1, pidt); 
      
      
       ResultSet rs;   
       rs = pst.executeQuery();
       
      
      
      jTable1.setModel(DbUtils.resultSetToTableModel(rs));
       
      //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
       
       

       
             
     
          conn.close();               
   }
   catch(Exception e){
       
       
   }
    
    
    
}
    
  
    
    
    
        
  public void tableload1(){
    
    try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp");     
       @SuppressWarnings("LocalVariableHidesMemberVariable")
       PreparedStatement pst = conn.prepareStatement("Select * from maintenance");
       //pst.setString(1, pidt); 
      
      
       ResultSet rs;   
       rs = pst.executeQuery();
       
   
      
      
    jTable2.setModel(DbUtils.resultSetToTableModel(rs));
       
      //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
       
       

       
             
     
          conn.close();               
   }
   catch(Exception e){
       
       
   }
    
    
    
}
  
  
  
    
    private void validate_ID(String pidt) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp");     
       @SuppressWarnings("LocalVariableHidesMemberVariable")
       PreparedStatement pst = conn.prepareStatement("Select * from patient where ID=?");
       pst.setString(1, pidt); 
      
      
       ResultSet rs;   
       rs = pst.executeQuery();
       
      
      
      
       
       
        
       
       if(rs.next())  
       {
           
            String fname = rs.getString("patient_name");
            String lname = rs.getString("NIC");
       String tpnumber = rs.getString("telephone");
       String city = rs.getString("guardianAdress");
          jButton3.setEnabled(true);
            label.setVisible(true);
           label.setText("Patient Validated Successfully");
           label.setBackground(Color.green);
           
            label.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
          jLabel5.setVisible(true);
        jLabel24.setVisible(true);
      
      jComboBox1.setVisible(true);
      jXDatePicker1.setVisible(true);
      jTextField5.setVisible(true);
     
      jButton3.setVisible(true);
      jButton5.setVisible(true);
         jLabel11.setVisible(true);
     
      jLabel12.setVisible(true);
      jLabel13.setVisible(true);
      jLabel14.setVisible(true);
      jLabel28.setVisible(true);
        jLabel25.setVisible(true);
        jLabel26.setVisible(true);
          jLabel27.setVisible(true);
           
         
          jLabel12.setText(fname);
          jLabel28.setText(tpnumber);
          jLabel14.setText(city);
          jLabel13.setText(lname);
      
       }
       
             
       else
       {
           //JOptionPane.showMessageDialog(null,"Patient ID cannot be validated"); 
            label.setVisible(true);
           label.setText("Patient cannot be validated");
           label.setBackground(Color.red);
           jButton3.setEnabled(false);
       }
          conn.close();               
   }
   catch(Exception e){
       
       
   }
 
}
    
  
 private void validate_Date(String pidt, String dates) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp");     
       @SuppressWarnings("LocalVariableHidesMemberVariable")
       PreparedStatement pst = conn.prepareStatement("Select * from maintenance where Date=? AND Machine_Type=?");
       
       PreparedStatement pst1 = conn.prepareStatement("Select * from schedules where Date=? AND Mac_Type=?");
       
       pst.setString(2, pidt); 
       pst.setString(1, dates); 
       pst1.setString(2, pidt); 
       pst1.setString(1, dates); 
      
       ResultSet rs;   
       rs = pst.executeQuery();
       ResultSet rs1;   
       rs1 = pst1.executeQuery();
         
      
     
       if(rs.next() )  
       {
               
                   
               label.setVisible(true);
               label.setText("This date is reserved for maintenance works");
               label.setBackground(Color.red);
               jButton3.setEnabled(false);
                   
                   
           
       }
                   
       else if (rs1.next())
       {
           int val = getRows(rs1);
           
           if ( val == 4)
           {
              label.setVisible(true);
               label.setText("No more free slots available for this Date");
               label.setBackground(Color.red);
               jButton3.setEnabled(false); 
           }
       }
             
       else
       {
           
            label.setVisible(false);
           label.setVisible(true);
           label.setText("Date is available");
           label.setBackground(Color.green); 
           jButton3.setEnabled(true);
           
       
           }
       
           
       
          conn.close();               
   }
   catch(Exception e){
       System.out.println(e);
       
   }
 
}
 
  private void validate_ID1(String pidtt) {
   try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp")) {
           @SuppressWarnings("LocalVariableHidesMemberVariable")
                   PreparedStatement pst1 = conn.prepareStatement("Select * from schedules where PID=?");
           pst1.setString(1, pidtt);
           
           
           ResultSet rs1;         
           rs1 = pst1.executeQuery();
           
           
           
           
           
           
           
           
           if(rs1.next())
           {
               
               String fname = rs1.getString("Name");
               String lname = rs1.getString("LName");
               String tpnumber = rs1.getString("TP_umber");
               String city = rs1.getString("City");
               
               System.out.print(fname);
               
               
               jTextField8.setText(fname);
               jTextField9.setText(lname);
               jTextField10.setText(city);
               jTextField11.setText(tpnumber);
               //jLabel48.setText(city);
               
               
               label.setVisible(true);
               label.setText("Patient Validated Successfully");
               label.setBackground(Color.green);
               
               
               
               
              
               
           }
           
           
           else
           {
               //JOptionPane.showMessageDialog(null,"Patient ID cannot be validated");
               label.setVisible(false);
               label.setVisible(true);
               label.setText("Patient cannot be validated");
               label.setBackground(Color.red);
           }
       }
   }
   catch(Exception e){
       
       
   }
 
}
 
 
 
 
 public int getRows(ResultSet res){
    int totalRows = 0;
    try {
        res.last();
        totalRows = res.getRow();
        res.beforeFirst();
    } 
    catch(Exception ex)  {
        return 0;
    }
    return totalRows ;  
   
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
        jLabel51 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        check = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jComboBox8 = new javax.swing.JComboBox();
        jPanel10 = new javax.swing.JPanel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jXDatePicker3 = new org.jdesktop.swingx.JXDatePicker();
        jLabel38 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel9 = new javax.swing.JPanel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton5 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        dateChooserCombo4 = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();
        dateChooserCombo5 = new datechooser.beans.DateChooserCombo();
        jButton4 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jLabel6 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel21 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel49 = new javax.swing.JLabel();
        dateChooserCombo6 = new datechooser.beans.DateChooserCombo();
        jLabel50 = new javax.swing.JLabel();
        dateChooserCombo7 = new datechooser.beans.DateChooserCombo();
        jButton20 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel36 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jButton19 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        label = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        picture = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        lbl_userinfo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Equipment Management System");
        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(java.awt.SystemColor.activeCaptionText);
        setMinimumSize(new java.awt.Dimension(829, 690));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel51.setText("Equipment Management System");
        getContentPane().add(jLabel51);
        jLabel51.setBounds(220, 30, 320, 40);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Patient ID");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Patient Details");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));
        jPanel4.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 370, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Date");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a Machine Type", "CT", "MRI", "X-Ray" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
        });
        jPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 190, 30));

        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 430, 80, 30));

        jButton12.setText("Clear");
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(833, 405, 82, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText(" Machine ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 100, -1));

        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 80, 30));

        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jPanel4.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 190, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Doctor ");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));

        check.setText("Check");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        jPanel4.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("First Name : ");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("NIC : ");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("City : ");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("TP Number :");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));
        jLabel27.getAccessibleContext().setAccessibleDescription("");

        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 300, -1));
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 300, -1));
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 300, -1));
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 300, -1));

        jXDatePicker1.setName(""); // NOI18N
        jPanel4.add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 190, 30));

        jTabbedPane1.addTab("Add New Record", jPanel4);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Patient Name", "Age", "Machine Type", "Date", "Time"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Sort By");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Machine Type");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Patient ID");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Patient Name");

        jButton13.setText("Search");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel29.setText("Machine Type");

        jLabel30.setText("Date");

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel31.setText("Schedule ID: ");

        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select a Machine Type", "CT", "MRI", "X-Ray" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)))
                .addGap(158, 158, 158))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jButton2)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("View Record", jPanel1);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Machine Type", "CT", "MRI", "X-Ray" }));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setText("Machine Type");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setText("Date");

        jButton11.setText("Submit");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jXDatePicker3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel35)
                .addGap(18, 18, 18)
                .addComponent(jXDatePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton11)
                .addContainerGap(262, Short.MAX_VALUE))
            .addComponent(jSeparator6)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)
                        .addComponent(jXDatePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11)))
                .addGap(103, 103, 103)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add Maintenance Record ", jPanel10);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Machine Type", "CT", "MRI", "X-Ray" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Machine Type");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Date");

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setText("Machine Type");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Sort By");

        jButton15.setText("Search");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Machine Type", "Date", "Time"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Delete");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel18.setText("Repair ID:");

        jButton14.setText("Refresh");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton5)
                .addGap(85, 85, 85)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3)
                .addGap(18, 18, 18)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton14)
                .addGap(30, 30, 30))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton9)
                        .addComponent(jButton10)
                        .addComponent(jButton14)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(jRadioButton5)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("View Maintenance Records", jPanel9);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("Emergency Patients");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Machine Type");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CT", "MRI", "X-Ray" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("From");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("To");

        jButton4.setText("Get Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton16.setText("Get Report");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("To");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("From");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CT", "MRI", "X-Ray" }));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Machine Type");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Maintenance Reports");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setText("Patient Reports");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Machine Type");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CT", "MRI", "X-Ray" }));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setText("From");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("To");

        jButton20.setText("Get Report");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton20)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel22)
                        .addGap(6, 6, 6)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel21)
                        .addGap(14, 14, 14)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton16)))
                .addGap(116, 116, 116))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel37)
                    .addContainerGap(755, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jComboBox2)
                                    .addComponent(jLabel8))
                                .addGap(67, 67, 67))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel20)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserCombo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateChooserCombo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(116, 116, 116)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(jComboBox3)
                            .addComponent(jLabel49))
                        .addGap(10, 10, 10))
                    .addComponent(dateChooserCombo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserCombo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addComponent(jLabel10)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22)
                    .addComponent(jComboBox5)
                    .addComponent(jLabel21)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(70, 70, 70)
                    .addComponent(jLabel37)
                    .addContainerGap(392, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Reports", jPanel2);

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Machine Type", "CT", "MRI", "X-Ray" }));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("Machine Type:");

        jButton17.setText("Submit");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton19.setText("Clear");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Registered");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setText("Non Registered");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        jRadioButton6.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jRadioButton6PropertyChange(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Status");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Patient ID:");

        jTextField7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField7MouseExited(evt);
            }
        });
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField7PropertyChange(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("TP Number :");

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("City : ");

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Last Name : ");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("First Name : ");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setText("Patient Details:");

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Doctor:");

        jButton8.setText("Check");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel40)
                        .addGap(58, 58, 58)
                        .addComponent(jRadioButton4)
                        .addGap(48, 48, 48)
                        .addComponent(jRadioButton6))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addGap(42, 42, 42)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel45)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel11Layout.createSequentialGroup()
                                                .addComponent(jLabel44)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                                .addComponent(jLabel43)
                                                .addGap(57, 57, 57)))
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField9)
                                            .addComponent(jTextField10)))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel36)
                                    .addComponent(jLabel47))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox7, 0, 134, Short.MAX_VALUE)
                                    .addComponent(jTextField12)))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(420, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton6)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel39)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel46))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(37, 37, 37)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton19))
                .addGap(60, 60, 60))
        );

        jTabbedPane1.addTab("Emergency", new javax.swing.ImageIcon(getClass().getResource("/EquipmentManagement/Emergency off.png")), jPanel11); // NOI18N

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(7, 120, 810, 510);
        jTabbedPane1.getAccessibleContext().setAccessibleName("New Record");

        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(0, 100, 820, 10);

        label.setBackground(new java.awt.Color(255, 51, 0));
        label.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setText("Notification Bar");
        label.setOpaque(true);
        getContentPane().add(label);
        label.setBounds(0, 630, 830, 30);
        getContentPane().add(jSeparator8);
        jSeparator8.setBounds(0, 660, 820, 20);

        picture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EquipmentManagement/admin1.png"))); // NOI18N
        getContentPane().add(picture);
        picture.setBounds(750, 10, 60, 80);

        logout.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(204, 0, 51));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(650, 70, 50, 20);

        lbl_userinfo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_userinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_userinfo.setText("<html>Hello Sleepy!<br> level : Admin </html>");
        getContentPane().add(lbl_userinfo);
        lbl_userinfo.setBounds(580, 30, 190, 30);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Profile");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel15);
        jLabel15.setBounds(650, 10, 50, 20);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EquipmentManagement/home.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 20, 73, 60);

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EquipmentManagement/11806788_1135526379794041_692436290_o.jpg"))); // NOI18N
        jLabel23.setText("jLabel23");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(0, 0, 830, 690);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int x =JOptionPane.showConfirmDialog(null,"Do You really want to update");

        if (x == 0)
        {
            String macv = jComboBox4.getSelectedItem().toString();
            String dater = jTextField3.getText();
            String hab = jLabel33.getText();
if (macv == "Select Machine Type"  || dater.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill all fields properly", "Information" , JOptionPane.ERROR_MESSAGE);
            }

else
{
    

            try
            {
                // create a java mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/itp";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "itp", "itp");

                // create the java mysql update preparedstatement
                String query = "update maintenance set Machine_Type = ? , Date = ? where Re_ID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, macv);
                preparedStmt.setString(2, dater);
                preparedStmt.setString(3, hab);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();

                conn.close();
                
                tableload1();
        label.setVisible(false);
        label.setVisible(true);
        label.setText("Data updated successfully");
        label.setBackground(Color.green);
            }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

        }

        
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int roo = jTable2.getSelectedRow();

        String Mac_Type= jTable2.getValueAt(roo, 1).toString();
        String date=  jTable2.getValueAt(roo, 2).toString();
        String rid= jTable2.getValueAt(roo, 0).toString();
        jTextField3.setText(date);
        jComboBox4.setSelectedItem(Mac_Type);
        jLabel33.setText(rid);
        // jTextField1.setText(Mac_Name);
        //jTextField6.setText(Date);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
       String searchval=jTextField4.getText();

        if ( jRadioButton5.isSelected())
        {

            try{
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp");
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                PreparedStatement pst = conn.prepareStatement("Select * from maintenance where Machine_Type LIKE '%' ? '%' ");
                pst.setString(1, searchval);

                ResultSet rs;
                rs = pst.executeQuery();

                jTable2.setModel(DbUtils.resultSetToTableModel(rs));

                //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));

                conn.close();
            }
            catch(Exception e){

            }

        }

        

        else
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp");
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                PreparedStatement pst = conn.prepareStatement("Select * from maintenance where Machine_Type LIKE '%' ? '%' ");
                pst.setString(1, searchval);

                ResultSet rs;
                rs = pst.executeQuery();

                jTable2.setModel(DbUtils.resultSetToTableModel(rs));

                //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));

                conn.close();
            }
            catch(Exception e){

            }
        }

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        tableload();
        label.setVisible(false);
        label.setVisible(true);
        label.setText("Data Refreshed");
        label.setBackground(Color.green);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int x = JOptionPane.showConfirmDialog(null,"Do you want to delete");
        label.setVisible(false);

        if (x == 0)

        {

            String tiddd = jLabel32.getText();

            try
            {
                // create a java mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/itp";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "itp", "itp");

                // create the java mysql update preparedstatement
                String query = "delete from schedules where TID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);

                preparedStmt.setString(1, tiddd);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();

                conn.close();
            }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            tableload();
            label.setVisible(false);
            label.setVisible(true);
            label.setText("Data deleted successfully");
            label.setBackground(Color.green);

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x =JOptionPane.showConfirmDialog(null,"Do You really want to update");

        if (x == 0)
        {

            //String mac_tt= jTextField1.getText();
            String dat = jTextField6.getText();
            String tidd = jLabel32.getText();
            String mac_t = jComboBox8.getSelectedItem().toString();
            
            if (mac_t == "Select a Machine Type"  || dat.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Fill all fields properly", "Information" , JOptionPane.ERROR_MESSAGE);
            }
            
            
            else {
            try
            {
                // create a java mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/itp";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "itp", "itp");

                // create the java mysql update preparedstatement
                String query = "update schedules set Mac_Type = ? , Date = ? where TID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, mac_t);
                preparedStmt.setString(2, dat);
                preparedStmt.setString(3, tidd);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();

                conn.close();
                tableload();
        label.setVisible(false);
        label.setVisible(true);
        label.setText("Data updated successfully");
        label.setBackground(Color.green);
            }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }
            }
        }

        

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String searchval=jTextField2.getText();

        if ( jRadioButton1.isSelected())
        {

            try{
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp")) {
                    @SuppressWarnings("LocalVariableHidesMemberVariable")
                            PreparedStatement pst = conn.prepareStatement("Select * from schedules where Mac_Type LIKE '%' ? '%' ");
                    pst.setString(1, searchval);
                    
                    ResultSet rs;
                    rs = pst.executeQuery();
                    
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
                }
            }
            catch(Exception e){

            }

        }

        else if ( jRadioButton2.isSelected())
        {

            try{
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp")) {
                    @SuppressWarnings("LocalVariableHidesMemberVariable")
                            PreparedStatement pst = conn.prepareStatement("Select * from schedules where PID LIKE '%' ? '%' ");
                    pst.setString(1, searchval);
                    
                    ResultSet rs;
                    rs = pst.executeQuery();
                    
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
                }
            }
            catch(Exception e){

            }

        }

        else if ( jRadioButton3.isSelected())
        {

            try{
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp")) {
                    @SuppressWarnings("LocalVariableHidesMemberVariable")
                            PreparedStatement pst = conn.prepareStatement("Select * from schedules where Name LIKE '%' ? '%' OR LName LIKE '%' ? '%' ");
                    pst.setString(1, searchval);
                    pst.setString(2, searchval);
                    
                    ResultSet rs;
                    rs = pst.executeQuery();
                    
                    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                    
                    //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));
                }
            }
            catch(Exception e){

            }

        }

        else
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp");
                @SuppressWarnings("LocalVariableHidesMemberVariable")
                PreparedStatement pst = conn.prepareStatement("Select * from schedules where Mac_Type LIKE '%' ? '%' ");
                pst.setString(1, searchval);

                ResultSet rs;
                rs = pst.executeQuery();

                jTable1.setModel(DbUtils.resultSetToTableModel(rs));

                //jTable1.removeColumn(jTable1.getColumnModel().getColumn(0));

                conn.close();
            }
            catch(Exception e){

            }
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int ro = jTable1.getSelectedRow();

        String Mac_Name= jTable1.getValueAt(ro, 6).toString();
        String Date= jTable1.getValueAt(ro, 8).toString();
        String tid= jTable1.getValueAt(ro, 0).toString();
        jLabel32.setText(tid);
        //jTextField1.setText(Mac_Name);
        jTextField6.setText(Date);
        
        jComboBox8.setSelectedItem(Mac_Name);
    }//GEN-LAST:event_jTable1MouseClicked

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        String patid = pid.getText();

        if(patid.length() == 0){
            JOptionPane.showMessageDialog(null,"Patient ID Field is empty");
        }
        else

        {
            validate_ID(patid);
        }
    }//GEN-LAST:event_checkActionPerformed

    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked

        
        
        
        
        
        String select = jComboBox1.getSelectedItem().toString();
        String datee = jXDatePicker1.getDate().toString();
        java.util.Date fecha = new java.util.Date("Mon Dec 15 00:00:00 CST 2014");
    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
    Date date = null;
        try {
            date = (Date)formatter.parse(datee);
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println(date);        

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    String formatedDate = cal.get(Calendar.DATE) + "/" + 
            (cal.get(Calendar.MONTH) + 1) + 
            "/" +         cal.get(Calendar.YEAR);
    System.out.println("formatedDate : " + formatedDate);
        System.out.println(datee);
       validate_Date(select,formatedDate);
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        jXDatePicker1.setDate(null);
        jTextField5.setText(" ");
        //pid.setText(" ");

        jComboBox1.setSelectedIndex(0);

        jLabel12.setText(" ");
        jLabel28.setText(" ");
        jLabel14.setText(" ");
        jLabel13.setText(" ");

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String pidd = pid.getText();
        String fname = jLabel12.getText();
        String lname = jLabel13.getText();
        String city = jLabel14.getText();
        String tpnumber = jLabel28.getText();
        String dateee = jXDatePicker1.getDate().toString();
        String mac = jComboBox1.getSelectedItem().toString();
        String doc = jTextField5.getText();
        int fgh = jComboBox1.getItemCount();
        Date gh= jXDatePicker1.getDate();
 String patid = pid.getText();

java.util.Date fecha = new java.util.Date("Mon Dec 15 00:00:00 CST 2014");
    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
    Date date = null;
        try {
            date = (Date)formatter.parse(dateee);
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println(date);        

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    String formatedDate = cal.get(Calendar.DATE) + "/" + 
            (cal.get(Calendar.MONTH) + 1) + 
            "/" +         cal.get(Calendar.YEAR);
    System.out.println("formatedDate : " + formatedDate);
 System.out.println(formatedDate);
 
 
 
 

// 
//  String maty4;
//        maty4 = jComboBox1.getSelectedItem().toString();
//        String input = "";
//        if(maty4.equalsIgnoreCase("Select Machine Type")){
//            JOptionPane.showMessageDialog(null, "Select a Machine type", "Information" , JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        try{
//         input = jXDatePicker1.getDate().toString();
//        }catch(Exception ex){
//                    JOptionPane.showMessageDialog(null, "Select a Date", "Information" , JOptionPane.ERROR_MESSAGE);
//
//        }
 
 
 
       
        
       
                
//         if (doc.equals(""))
//            
//        {
//           JOptionPane.showMessageDialog(null, "Enter a Doctor ID", "Information" , JOptionPane.ERROR_MESSAGE);
//        }
            
//         if (jRadioButton6.isSelected())
         {
        
         DateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
            Date date1 = new Date();
            String dater1 = dateFormat.format(date1);
            
         if (doc.isEmpty() ||   "Select a Machine Type".equals(mac) || formatedDate.compareTo(dater1)<0 )
                
            {
                
                
                        JOptionPane.showMessageDialog(null, "Fill required fields properly and check the date", "Information" , JOptionPane.ERROR_MESSAGE);
                       
            }
         
         else if (formatedDate.compareTo(dater1)<0 )
                
            {
                
                
                        JOptionPane.showMessageDialog(null, "Check the date", "Information" , JOptionPane.ERROR_MESSAGE);
                       
            }
        
        
     
            
          
        
        
        
        
          else
        {
            
            
            
            
        try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/itp";
            Class.forName(myDriver);
            // create a sql date object so we can use it in our INSERT statement
            try (Connection conn = DriverManager.getConnection(myUrl, "itp", "itp")) {
                // create a sql date object so we can use it in our INSERT statement
                
                
                // the mysql insert statement
                String query = " insert into schedules (PID, Name, LName, TP_Number, City, Mac_Type, Doctor, Date, Added_Date )"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, pidd);
                preparedStmt.setString (2, fname);
                preparedStmt.setString (3, lname);
                preparedStmt.setString (4, tpnumber);
                preparedStmt.setString (5, city);
                preparedStmt.setString (6, mac);
                preparedStmt.setString (7, doc);
                preparedStmt.setString (8, formatedDate);
                preparedStmt.setString (9, dater1);
                
                // execute the preparedstatement
                preparedStmt.execute();
                
                         
                label.setVisible(false);
                label.setVisible(true);
                label.setText("Data inserted successfully");
                label.setBackground(Color.green);
                
            }      
        }
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }


    
        }
            
            
            
            
            
        
        
            
        
        
        
        
        
        //        String rec = jLabel28.getText();
        //      int c = Integer.parseInt(rec);
        //
        //        URL textit = null;
        //        try {
            //            textit = new URL("http://textit.biz/sendmsg/index.php?id=94767482482&pw=2878&to=" +c+ "&text=Test+SMS");
            //        } catch (MalformedURLException ex) {
            //            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        //BufferedReader in = null;
        //        try {
            //            in = new BufferedReader(
                //                    new InputStreamReader(textit.openStream()));
            //        } catch (IOException ex) {
            //            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            //        }

        //String inputLine;
        //        try {
            //            while ((inputLine = in.readLine()) != null)
            //                System.out.println(inputLine);
            //        } catch (IOException ex) {
            //            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        //        try {
            //            in.close();
            //        } catch (IOException ex) {
            //            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            //        }
        //
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String maty = jComboBox6.getSelectedItem().toString();
        String input1 = "";
        if(maty.equalsIgnoreCase("Select Machine Type")){
            JOptionPane.showMessageDialog(null, "Select a Machine type", "Information" , JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
         input1 = jXDatePicker3.getDate().toString();
        }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Select a Date", "Information" , JOptionPane.ERROR_MESSAGE);

        }
//        System.out.println(input);
//        Instant instant;
//      String input = "2012/01/20 12:05:10.321";
        
        DateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy");
            Date date2 = new Date();
            String dater2 = dateFormat.format(date2);
        
         java.util.Date fecha = new java.util.Date("Mon Dec 15 00:00:00 CST 2014");
    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
    Date date = null;
        try {
            date = (Date)formatter.parse(input1);
        } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println(date);        

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    String formatedDate = cal.get(Calendar.DATE) + "/" + 
            (cal.get(Calendar.MONTH) + 1) + 
            "/" +         cal.get(Calendar.YEAR);
    System.out.println("formatedDate : " + formatedDate);

    
    
   if(formatedDate.compareTo(dater2)<0)   
        
          {
                JOptionPane.showMessageDialog(null, "Enter a valid date", "Information" , JOptionPane.ERROR_MESSAGE);
                System.out.println("new date is after today");
           }

    else
    {
        
    
        
        maintenance m2 = new maintenance();

      m2.insertdata(maty, formatedDate);

        label.setVisible(false);
        label.setVisible(true);
        label.setText("Data inserted successfully");
        label.setBackground(Color.green);

    }   
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        tableload1();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         int x = JOptionPane.showConfirmDialog(null,"Do you want to delete");
        label.setVisible(false);

        if (x == 0)

        {

            String tidddd = jLabel33.getText();

            try
            {
                // create a java mysql database connection
                String myDriver = "com.mysql.jdbc.Driver";
                String myUrl = "jdbc:mysql://localhost:3306/itp";
                Class.forName(myDriver);
                Connection conn = DriverManager.getConnection(myUrl, "itp", "itp");

                // create the java mysql update preparedstatement
                String query = "delete from maintenance where Re_ID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);

                preparedStmt.setString(1, tidddd);

                // execute the java preparedstatement
                preparedStmt.executeUpdate();

                conn.close();
            }
            catch (Exception e)
            {
                System.err.println("Got an exception! ");
                System.err.println(e.getMessage());
            }

            tableload1();
            label.setVisible(false);
            label.setVisible(true);
            label.setText("Data deleted successfully");
            label.setBackground(Color.green);

        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
         String nmee = jTextField7.getText();
        String nme = jTextField8.getText();
            String dfg = jTextField9.getText();
            String asd = jTextField10.getText();
            String wer = jTextField11.getText();
            
            String qwe = jComboBox7.getSelectedItem().toString();
            
           
            String weg = jTextField12.getText();
            

 
          
            
         if (jRadioButton6.isSelected())
         {
             if (nme.isEmpty() ||  dfg.isEmpty() || asd.isEmpty()  || wer.isEmpty() || weg.isEmpty() || "Select Machine Type".equals(qwe)  )
                
            {
                
                
                        JOptionPane.showMessageDialog(null, "Fill required fields properly", "Information" , JOptionPane.ERROR_MESSAGE);
                       
            }
             
            
             
             else { 
         
            try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/itp";
            Class.forName(myDriver);
            // create a sql date object so we can use it in our INSERT statement
            try (Connection conn = DriverManager.getConnection(myUrl, "itp", "itp")) {
                // create a sql date object so we can use it in our INSERT statement
                Calendar calendar = Calendar.getInstance();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
                String dater = startDate.toString();
                
                // the mysql insert statement
                String query = " insert into emergency (PID, fname, lname, city, tpnumber, date, doctor, Machine )"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, "N/A");
                preparedStmt.setString (2, nme);
                preparedStmt.setString (3, dfg);
                preparedStmt.setString (4, asd);
                preparedStmt.setString (5, wer);
                preparedStmt.setString (6, dater);
                preparedStmt.setString (7, weg);
                preparedStmt.setString (8, qwe);

                
                // execute the preparedstatement
                preparedStmt.execute();
                conn.close();
            }
        
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        label.setVisible(false);
        label.setVisible(true);
        label.setText("Data inserted successfully");
        label.setBackground(Color.green);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
         }
         }
    
         
         else if (jRadioButton4.isSelected())
         {
             if(qwe == "Select Machine Type" || weg.isEmpty() )
             {
                 JOptionPane.showMessageDialog(null, "Fill required fields properly", "Information" , JOptionPane.ERROR_MESSAGE);
             }
             
             else
             {
                 
             
             
              try
        {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost:3306/itp";
            Class.forName(myDriver);
            // create a sql date object so we can use it in our INSERT statement
            try (Connection conn = DriverManager.getConnection(myUrl, "itp", "itp")) {
                // create a sql date object so we can use it in our INSERT statement
                Calendar calendar = Calendar.getInstance();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
                String dater = startDate.toString();
                
                // the mysql insert statement
                String query = " insert into emergency (PID, fname, lname, city, tpnumber, date, doctor, Machine )"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?)";
                
                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString (1, nmee);
                preparedStmt.setString (2, nme);
                preparedStmt.setString (3, dfg);
                preparedStmt.setString (4, asd);
                preparedStmt.setString (5, wer);
                preparedStmt.setString (6, dater);
                preparedStmt.setString (7, weg);
                preparedStmt.setString (8, qwe);

                
                // execute the preparedstatement
                preparedStmt.execute();
                conn.close();
            }
        
        catch (Exception e)
        {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }

        label.setVisible(false);
        label.setVisible(true);
        label.setText("Data inserted successfully");
        label.setBackground(Color.green);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } 
             
             
             
             
             
             
             
         }
      
         
            
         
         
         
         } 
         
         
         
         
         
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if (jRadioButton4.isSelected())
        {
            jLabel41.setVisible(false);
           jTextField7.setVisible(false);
             jButton8.setVisible(true);
           jTextField7.setVisible(true);
           jTextField8.setVisible(true);
           jTextField9.setVisible(true);
           jTextField10.setVisible(true);
           jTextField11.setVisible(true);
           jTextField12.setVisible(true);
           jComboBox7.setVisible(true);       
           //jXDatePicker4.setVisible(true);
            jLabel46.setVisible(true);
            jLabel36.setVisible(true);
           // jLabel37.setVisible(true);
            jLabel45.setVisible(true);
            jLabel44.setVisible(true);
            jLabel43.setVisible(true);
            jLabel42.setVisible(true);
            jLabel41.setVisible(true);
            jLabel47.setVisible(true);
            jButton17.setVisible(true);
            jButton19.setVisible(true);       
            jTextField8.setEnabled(false);
               jTextField9.setEnabled(false);
               jTextField10.setEnabled(false);
               jTextField11.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton6PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jRadioButton6PropertyChange
       
    }//GEN-LAST:event_jRadioButton6PropertyChange

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
       jTextField8.setText("");
               jTextField9.setText("");
               jTextField10.setText("");
               jTextField11.setText("");
               jTextField12.setText("");
               jComboBox7.setSelectedItem("Select Machine Type");
        
        
        
        if (jRadioButton6.isSelected())
        {
           jLabel41.setVisible(false);
           jTextField7.setVisible(false);
           jButton8.setVisible(false);
            
           jTextField7.setVisible(false);
           jTextField8.setVisible(true);
           jTextField9.setVisible(true);
           jTextField10.setVisible(true);
           jTextField11.setVisible(true);
           jTextField12.setVisible(true);
           jComboBox7.setVisible(true);    
           
            jTextField8.setEnabled(true);
               jTextField9.setEnabled(true);
               jTextField10.setEnabled(true);
               jTextField11.setEnabled(true);
          
            jLabel46.setVisible(true);
            jLabel36.setVisible(true);
            //jLabel37.setVisible(true);
            jLabel45.setVisible(true);
            jLabel47.setVisible(true);
            jLabel44.setVisible(true);
            jLabel43.setVisible(true);
            jLabel42.setVisible(true);
            jButton17.setVisible(true);
            jButton19.setVisible(true);       
            
            
            
        }
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
       
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField7PropertyChange
        
    }//GEN-LAST:event_jTextField7PropertyChange

    private void jTextField7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField7MouseExited
    
    }//GEN-LAST:event_jTextField7MouseExited

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       String ppid = jTextField7.getText();
       
        if(ppid.length() == 0){
            JOptionPane.showMessageDialog(null,"Patient ID Field is empty");
        }
        else

        {
            try{           
       Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
       try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp?" + "user=itp&password=itp")) {
           @SuppressWarnings("LocalVariableHidesMemberVariable")
                   PreparedStatement pst1 = conn.prepareStatement("Select * from patient where ID=?");
           pst1.setString(1, ppid);
           
           
           ResultSet rs1;         
           rs1 = pst1.executeQuery();
           
           
           
           
           
           
           
           
           if(rs1.next())
           {
               
               String fname = rs1.getString("patient_name");
               String lname = rs1.getString("NIC");
               String tpnumber = rs1.getString("telephone");
               String city = rs1.getString("guardianAdress");
               
               System.out.print(fname);
               
               
               jTextField8.setText(fname);
               jTextField9.setText(lname);
               jTextField10.setText(city);
               jTextField11.setText(tpnumber);
               
                 jTextField8.setEnabled(false);
               jTextField9.setEnabled(false);
               jTextField10.setEnabled(false);
               jTextField11.setEnabled(false);
              
               
               
               label.setVisible(true);
               label.setText("Patient Validated Successfully");
               label.setBackground(Color.green);
               
               jButton17.setEnabled(true);
               
               
              
               
           }
           
           
           else
           {
               //JOptionPane.showMessageDialog(null,"Patient ID cannot be validated");
               label.setVisible(false);
               jButton17.setEnabled(false);
               label.setVisible(true);
               label.setText("Patient cannot be validated");
               label.setBackground(Color.red);
           }
       }
   }
   catch(Exception e){
       
       
   }
        }
                                      

       
       
       
       
       
       
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
      // jTextField7.getText();
        jTextField8.setText("");
            jTextField9.setText("");
          jTextField10.setText("");
          jTextField11.setText("");
            
            jComboBox7.setSelectedItem(null);
            
            jTextField12.setText("");
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
         tableload1();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jXDatePicker3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker3ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
         
    }//GEN-LAST:event_jTable1MouseEntered

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
     
    }//GEN-LAST:event_jTable2MouseEntered

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
         
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.hide();
        home.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        this.hide();
        login.setVisible(true);
    }//GEN-LAST:event_logoutMouseClicked

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton check;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private datechooser.beans.DateChooserCombo dateChooserCombo4;
    private datechooser.beans.DateChooserCombo dateChooserCombo5;
    private datechooser.beans.DateChooserCombo dateChooserCombo6;
    private datechooser.beans.DateChooserCombo dateChooserCombo7;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
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
    public javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    public javax.swing.JLabel label;
    private javax.swing.JLabel lbl_userinfo;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel picture;
    private javax.swing.JTextField pid;
    // End of variables declaration//GEN-END:variables
}
