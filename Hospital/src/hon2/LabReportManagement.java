/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hon2;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
/**
 *
 * @author ShredHead
 */
public class LabReportManagement extends javax.swing.JFrame {
    
    // Database Connection
    Connection con = null;
    PreparedStatement pst = null;
    public MainWindow.Mainwindow home;
    
    /**
     * Creates new form LabReportManagement
     */
    public void userInfo (String userName, int level)
    {
        lblUserName.setText("Hello " +userName+ "!");
        if (level == 100)
        {
            lblUserLevel.setText("Level : Admin");
        }
        else if (level == 75)
        {
            lblUserLevel.setText("Level : Doctor");
        }
    }
    
    
    
    public void close()
    {
        WindowEvent winClosingEvent = new WindowEvent (this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
     
    
    public void viewReport(int id, String type)
    {
        HashMap param = new HashMap();
        param.put("ID", id);
        try
        {
            if (type.equals("Blood"))
            {
                JasperReport report = JasperCompileManager.compileReport("BloodReport.jrxml");
                JasperPrint print = JasperFillManager.fillReport(report, param, con);
            
                JFrame frame = new JFrame();

                frame.setBounds(100, 100, 800,600);

                frame.getContentPane().add(new JRViewer(print));
        
                frame.setVisible(true);
            }
            else if (type.equals("Urine"))
            {
                JasperReport report = JasperCompileManager.compileReport("UrineReport.jrxml");
                JasperPrint print = JasperFillManager.fillReport(report, param, con);
            
                JFrame frame = new JFrame();

                frame.setBounds(100, 100, 800,600);

                frame.getContentPane().add(new JRViewer(print));
        
                frame.setVisible(true);
            }
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void update_table(String orderField)
    {
        try
        {
           if (orderField.equals("type"))
           {
                String sql1 = "SELECT id AS ID,pname AS Patient,dname AS Doctor, type AS Type,datetime AS Date FROM report ORDER BY type ASC";
                pst = con.prepareStatement(sql1);
                //pst.setString(1, orderField);
                ResultSet reports = pst.executeQuery();
                tblReportList.setModel(DbUtils.resultSetToTableModel(reports));
           }
           else if (orderField.equals("datetime"))
           {
               String sql1 = "SELECT id AS ID,pname AS Patient,dname AS Doctor, type AS Type,datetime AS Date FROM report ORDER BY datetime ASC";
                pst = con.prepareStatement(sql1);
                //pst.setString(1, orderField);
                ResultSet reports = pst.executeQuery();
                tblReportList.setModel(DbUtils.resultSetToTableModel(reports));
           }
           else if (orderField.equals("dname"))
           {
               String sql1 = "SELECT id AS ID,pname AS Patient,dname AS Doctor, type AS Type,datetime AS Date FROM report ORDER BY dname ASC";
                pst = con.prepareStatement(sql1);
                //pst.setString(1, orderField);
                ResultSet reports = pst.executeQuery();
                tblReportList.setModel(DbUtils.resultSetToTableModel(reports));
           }
           else if (orderField.equals("pname"))
           {
               String sql1 = "SELECT id AS ID,pname AS Patient,dname AS Doctor, type AS Type,datetime AS Date FROM report ORDER BY pname ASC";
                pst = con.prepareStatement(sql1);
                //pst.setString(1, orderField);
                ResultSet reports = pst.executeQuery();
                tblReportList.setModel(DbUtils.resultSetToTableModel(reports));
           }
        }
        catch(Exception eae)
        {
            JOptionPane.showMessageDialog(null,eae);
        }
    }
    
    private void update_table_search(String searchColumn, String searchWord)
    {
        try
        {
            if (searchColumn.equals("ID"))
            {
                String sql1 = "SELECT id AS ID,pname AS Patient,dname AS Doctor, datetime AS Date,type AS Type FROM report WHERE id = ?";
                pst = con.prepareStatement(sql1);
                pst.setString(1, searchWord);
                ResultSet reports = pst.executeQuery();
                if (reports.next())
                {
                    reports.beforeFirst();
                    tblReportList.setModel(DbUtils.resultSetToTableModel(reports));
                }
                else
                {
                JOptionPane.showMessageDialog(null, "No Matching Search Results."); 
                }
            }
            else if (searchColumn.equals("Patient Name"))
            {
                String sql1 = "SELECT id AS ID,pname AS Patient,dname AS Doctor, datetime AS Date,type AS Type FROM report WHERE pname = ?";
                pst = con.prepareStatement(sql1);
                pst.setString(1, searchWord);
                ResultSet reports = pst.executeQuery();
                if (reports.next())
                {
                    reports.beforeFirst();
                    tblReportList.setModel(DbUtils.resultSetToTableModel(reports));
                }
                else
                {
                JOptionPane.showMessageDialog(null, "No Matching Search Results."); 
                }
            }
            else if (searchColumn.equals("Doctor Name"))
            {
                String sql1 = "SELECT id AS ID,pname AS Patient,dname AS Doctor, datetime AS Date,type AS Type FROM report WHERE dname = ?";
                pst = con.prepareStatement(sql1);
                pst.setString(1, searchWord);
                ResultSet reports = pst.executeQuery();
                if (reports.next())
                {
                    reports.beforeFirst();
                    tblReportList.setModel(DbUtils.resultSetToTableModel(reports));
                }
                else
                {
                JOptionPane.showMessageDialog(null, "No Matching Search Results."); 
                }
            }
        }
        catch(Exception eae)
        {
            JOptionPane.showMessageDialog(null,eae);
        }
    }
    
    private int get_table_row_id()
    {
        int row = tblReportList.getSelectedRow();
        int id = (int) (tblReportList.getModel().getValueAt(row, 0));
        return id;
    }
    
    public LabReportManagement() {
        initComponents();
        con = DBConnect.ConnectDB();
        btnViewReport.setEnabled(false);
        btnDeleteReport.setEnabled(false);
        this.setLocationRelativeTo(null);
        
        // Retrieving Doctor Names from database and setting Autocomplete
        String query = "SELECT doctorName FROM doctor";
        try 
        {
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            String value;
            while(rs.next())
            {
                value = rs.getString("doctorName");
                cmbDoctorName.addItem(value);
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LabReportManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        AutoCompleteDecorator.decorate(cmbDoctorName);
        
        // Retrieving Patient Names from database and setting Autocomplete
        query = "SELECT patient_name FROM patient";
        try 
        {
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            String value;
            while(rs.next())
            {
                value = rs.getString("patient_name");
                cmbPatientName.addItem(value);
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(LabReportManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        AutoCompleteDecorator.decorate(cmbPatientName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pnlReport1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtR1F1 = new javax.swing.JTextField();
        txtR1F2 = new javax.swing.JTextField();
        txtR1F3 = new javax.swing.JTextField();
        txtR1F4 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtR1F5 = new javax.swing.JTextField();
        txtR1F6 = new javax.swing.JTextField();
        txtR1F7 = new javax.swing.JTextField();
        txtR1F8 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtR1F9 = new javax.swing.JTextField();
        txtR1F10 = new javax.swing.JTextField();
        txtR1F11 = new javax.swing.JTextField();
        pnlReport2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtR2F1 = new javax.swing.JTextField();
        txtR2F2 = new javax.swing.JTextField();
        txtR2F3 = new javax.swing.JTextField();
        txtR2F4 = new javax.swing.JTextField();
        txtR2F5 = new javax.swing.JTextField();
        txtR2F6 = new javax.swing.JTextField();
        txtR2F7 = new javax.swing.JTextField();
        txtR2F8 = new javax.swing.JTextField();
        btnCreateReport = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        cmbReportType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbPatientName = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbDoctorName = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbFilter = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        cmbSearchType = new javax.swing.JComboBox();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReportList = new javax.swing.JTable();
        btnViewReport = new javax.swing.JButton();
        btnDeleteReport = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblUserName = new javax.swing.JLabel();
        lblUserLevel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setTitle("Hospital Mangement System");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1005, 720));
        getContentPane().setLayout(null);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.CardLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Blood Picture");

        jLabel10.setText("Hb");

        jLabel16.setText("Hct");

        jLabel17.setText("Er");

        jLabel18.setText("WBC");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Lipid Profile");

        jLabel20.setText("Total Cholesterol");

        jLabel21.setText("Triglycerides");

        jLabel22.setText("HDL");

        jLabel23.setText("LDL");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Electrolytes");

        jLabel27.setText("K+");

        jLabel28.setText("Na+");

        jLabel29.setText("Cl-");

        javax.swing.GroupLayout pnlReport1Layout = new javax.swing.GroupLayout(pnlReport1);
        pnlReport1.setLayout(pnlReport1Layout);
        pnlReport1Layout.setHorizontalGroup(
            pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReport1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReport1Layout.createSequentialGroup()
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReport1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 591, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlReport1Layout.createSequentialGroup()
                                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlReport1Layout.createSequentialGroup()
                                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel10))
                                        .addGap(114, 114, 114)
                                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtR1F3)
                                            .addComponent(txtR1F2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtR1F1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtR1F4)
                                            .addComponent(txtR1F5)
                                            .addComponent(txtR1F6)
                                            .addComponent(txtR1F7)
                                            .addComponent(txtR1F8, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addGroup(pnlReport1Layout.createSequentialGroup()
                                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel29))
                                        .addGap(166, 166, 166)
                                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtR1F11)
                                            .addComponent(txtR1F10)
                                            .addComponent(txtR1F9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(100, 100, 100))
                    .addGroup(pnlReport1Layout.createSequentialGroup()
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlReport1Layout.setVerticalGroup(
            pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReport1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReport1Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtR1F9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtR1F10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txtR1F11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlReport1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtR1F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtR1F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtR1F3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtR1F4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19)))
                .addGap(8, 8, 8)
                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtR1F5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtR1F6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtR1F7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReport1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtR1F8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.add(pnlReport1, "card2");

        jLabel7.setText("Specific Weight");

        jLabel8.setText("pH");

        jLabel24.setText("Glucose");

        jLabel25.setText("Ketones");

        jLabel30.setText("Blood Cells");

        jLabel31.setText("Bilirubin");

        jLabel32.setText("Urobilinogen");

        jLabel33.setText("Nitrites");

        txtR2F3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtR2F3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReport2Layout = new javax.swing.GroupLayout(pnlReport2);
        pnlReport2.setLayout(pnlReport2Layout);
        pnlReport2Layout.setHorizontalGroup(
            pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReport2Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel30)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel8))
                .addGap(178, 178, 178)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtR2F1)
                                        .addComponent(txtR2F2)
                                        .addComponent(txtR2F8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtR2F3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtR2F4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtR2F5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtR2F6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtR2F7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(435, Short.MAX_VALUE))
        );
        pnlReport2Layout.setVerticalGroup(
            pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReport2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtR2F1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtR2F2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtR2F3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtR2F4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtR2F5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtR2F6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtR2F7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlReport2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtR2F8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel3.add(pnlReport2, "card3");

        btnCreateReport.setText("Create");
        btnCreateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateReportActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cmbReportType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blood", "Urine" }));
        cmbReportType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbReportTypeActionPerformed(evt);
            }
        });

        jLabel2.setText("Report Type :");

        jLabel5.setText("Patient Name :");

        cmbPatientName.setEditable(true);

        jLabel6.setText("Doctor's Name :");

        cmbDoctorName.setEditable(true);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbReportType, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbReportType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cmbDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCreateReport)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateReport)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Create Report", jPanel1);

        jLabel3.setText("Sort By :");

        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Date", "Type", "Patient Name", "Doctor Name" }));
        cmbFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbFilterMouseClicked(evt);
            }
        });
        cmbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilterActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbSearchType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Patient Name", "Doctor Name" }));

        tblReportList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblReportList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReportListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tblReportListMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tblReportList);

        btnViewReport.setText("View");
        btnViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReportActionPerformed(evt);
            }
        });

        btnDeleteReport.setText("Delete");
        btnDeleteReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 884, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearch)))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnViewReport, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteReport, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(cmbSearchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewReport)
                    .addComponent(btnDeleteReport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lab Report Archive", jPanel2);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(33, 134, 928, 510);
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 113, 996, 10);

        lblUserName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUserName.setText("jLabel34");
        getContentPane().add(lblUserName);
        lblUserName.setBounds(780, 39, 110, 15);

        lblUserLevel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUserLevel.setText("jLabel14");
        getContentPane().add(lblUserLevel);
        lblUserLevel.setBounds(780, 60, 110, 15);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Profile");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel15);
        jLabel15.setBounds(810, 11, 50, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 51));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Logout");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jLabel13);
        jLabel13.setBounds(810, 82, 50, 20);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hon2/admin1.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(910, 11, 60, 80);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hon2/backbtn.jpg"))); // NOI18N
        btnBack.setMaximumSize(new java.awt.Dimension(33, 9));
        btnBack.setMinimumSize(new java.awt.Dimension(33, 9));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(20, 20, 71, 71);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Lab Report Management");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(289, 30, 368, 44);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hon2/bg.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-10, -20, 1070, 890);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtR2F3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtR2F3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtR2F3ActionPerformed

    private void cmbReportTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbReportTypeActionPerformed
        
        // Get Value from the Report Type JComboBox and and make the relevant JPanel visible
        
        String strReport = (String) cmbReportType.getSelectedItem();
        
        if (strReport.equals("Blood"))
        {
            pnlReport1.setVisible(true);
            pnlReport2.setVisible(false);    
        }
        else if (strReport.equals("Urine"))
        {
            pnlReport2.setVisible(true); 
            pnlReport1.setVisible(false);
        }
    }//GEN-LAST:event_cmbReportTypeActionPerformed

    private void btnCreateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateReportActionPerformed
        
        // Get Patient Name, Doctor Name and Report Type
        String sqlQuery;
        String sqlQuery2;
        String sqlQuery3;
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = sdf.format(dt);
        
        int success;
        int id;
        String strPatient = (String) cmbPatientName.getSelectedItem();
        String strDoctor = (String) cmbDoctorName.getSelectedItem();
        String strReport = (String) cmbReportType.getSelectedItem();
        ResultSet rs = null;
        
        // Check which type of report is being created
        if (strReport.equals("Blood"))
        {
            // Get inputs from JTextFields and store in String variables
            String strR1F1 = txtR1F1.getText().trim();
            String strR1F2 = txtR1F2.getText().trim();
            String strR1F3 = txtR1F3.getText().trim();
            String strR1F4 = txtR1F4.getText().trim();
            String strR1F5 = txtR1F5.getText().trim();
            String strR1F6 = txtR1F6.getText().trim();
            String strR1F7 = txtR1F7.getText().trim();
            String strR1F8 = txtR1F8.getText().trim();
            String strR1F9 = txtR1F9.getText().trim();
            String strR1F10 = txtR1F10.getText().trim();
            String strR1F11 = txtR1F11.getText().trim();
            
            // Check if Strings are empty or null
            if ((strR1F1 != null && !strR1F1.isEmpty())&&(strR1F2 != null && !strR1F2.isEmpty())&&(strR1F3 != null && !strR1F3.isEmpty())&&(strR1F4 != null && !strR1F4.isEmpty())&&(strR1F5 != null && !strR1F5.isEmpty())&&(strR1F6 != null && !strR1F6.isEmpty())&&(strR1F7 != null && !strR1F7.isEmpty())&&(strR1F8 != null && !strR1F8.isEmpty())&&(strR1F9 != null && !strR1F9.isEmpty())&&(strR1F10 != null && !strR1F10.isEmpty())&&(strR1F11 != null && !strR1F11.isEmpty()))                                
            {
              
               
                try 
                {
                    // Enter into Report Table
                    sqlQuery = "INSERT INTO report (pname,dname,type,datetime) values (?,?,?,?)";
                    pst = con.prepareStatement(sqlQuery);
                    pst.setString(1,strPatient);
                    pst.setString(2,strDoctor);
                    pst.setString(3,strReport);
                    pst.setString(4,datetime);
                    pst.execute();
                    
                    // Insert report data into relevant table
                    sqlQuery3 = "INSERT INTO report_blood (id,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11) values ((SELECT MAX(id) FROM report),?,?,?,?,?,?,?,?,?,?,?)";
                    pst = con.prepareStatement(sqlQuery3);
                    //pst.setInt(1,id);
                    pst.setString(1,strR1F1);
                    pst.setString(2,strR1F2);
                    pst.setString(3,strR1F3);
                    pst.setString(4,strR1F4);
                    pst.setString(5,strR1F5);
                    pst.setString(6,strR1F6);
                    pst.setString(7,strR1F7);
                    pst.setString(8,strR1F8);
                    pst.setString(9,strR1F9);
                    pst.setString(10,strR1F10);
                    pst.setString(11,strR1F11);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Report Created Sucessfully!");
                    
                    // Resetting Text Fields
                    txtR1F1.setText("");
                    txtR1F2.setText("");
                    txtR1F3.setText("");
                    txtR1F4.setText("");
                    txtR1F5.setText("");
                    txtR1F6.setText("");
                    txtR1F7.setText("");
                    txtR1F8.setText("");
                    txtR1F9.setText("");
                    txtR1F10.setText("");
                    txtR1F11.setText("");
                
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(LabReportManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "One or more fields are empty.");
            }
        }
        
        // If Createing Urine Report
        else if (strReport.equals("Urine"))
        {
            
            // Get inputs from JTextFields and store in String variables
            String strR2F1 = txtR2F1.getText().trim();
            String strR2F2 = txtR2F2.getText().trim();
            String strR2F3 = txtR2F3.getText().trim();
            String strR2F4 = txtR2F4.getText().trim();
            String strR2F5 = txtR2F5.getText().trim();
            String strR2F6 = txtR2F6.getText().trim();
            String strR2F7 = txtR2F7.getText().trim();
            String strR2F8 = txtR2F8.getText().trim();
            
            // Check if Strings are empty or null
            if ((strR2F1 != null && !strR2F1.isEmpty())&&(strR2F2 != null && !strR2F2.isEmpty())&&(strR2F3 != null && !strR2F3.isEmpty())&&(strR2F4 != null && !strR2F4.isEmpty())&&(strR2F5 != null && !strR2F5.isEmpty())&&(strR2F6 != null && !strR2F6.isEmpty())&&(strR2F7 != null && !strR2F7.isEmpty())&&(strR2F8 != null && !strR2F8.isEmpty()))
            {
                success = 1;
                try
                {
                    // Enter into Report Table
                    sqlQuery = "INSERT INTO report (pname,dname,type,datetime) values (?,?,?,?)";
                    pst = con.prepareStatement(sqlQuery);
                    pst.setString(1,strPatient);
                    pst.setString(2,strDoctor);
                    pst.setString(3,strReport);
                    pst.setString(4,datetime);
                    pst.execute();
                    
                    // Insert report data into relevant table
                    sqlQuery3 = "INSERT INTO report_urine (id,f1,f2,f3,f4,f5,f6,f7,f8) values ((SELECT MAX(id) FROM report),?,?,?,?,?,?,?,?)";
                    pst = con.prepareStatement(sqlQuery3);
                    pst.setString(1,strR2F1);
                    pst.setString(2,strR2F2);
                    pst.setString(3,strR2F3);
                    pst.setString(4,strR2F4);
                    pst.setString(5,strR2F5);
                    pst.setString(6,strR2F6);
                    pst.setString(7,strR2F7);
                    pst.setString(8,strR2F8);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Report Sucessfully Created!");
                    
                    // Resetting Text Fields
                    txtR2F1.setText("");
                    txtR2F2.setText("");
                    txtR2F3.setText("");
                    txtR2F4.setText("");
                    txtR2F5.setText("");
                    txtR2F6.setText("");
                    txtR2F7.setText("");
                    txtR2F8.setText("");
                }
                catch (SQLException ex) 
                {
                    Logger.getLogger(LabReportManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
            {
                success = 0;
                JOptionPane.showMessageDialog(null, "One or more fields are empty.");
            }
        }
        
        
    }//GEN-LAST:event_btnCreateReportActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        JTabbedPane stp = (JTabbedPane) evt.getSource();
        int index = stp.getSelectedIndex();
        if (index == 1)
        {
            update_table("datetime");
        }
        btnViewReport.setEnabled(false);
        btnDeleteReport.setEnabled(false);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void cmbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilterActionPerformed
        // TODO add your handling code here:
        String strFilter = (String) cmbFilter.getSelectedItem();
        
        if (strFilter.equals("Date"))
        {
            update_table("datetime");
        }
        else if(strFilter.equals("Type"))
        {
            update_table("type");
        }
        else if(strFilter.equals("Patient Name"))
        {
            update_table("pname");
        }
        else if(strFilter.equals("Doctor Name"))
        {
            update_table("dname");
        }
    }//GEN-LAST:event_cmbFilterActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String strSearch = txtSearch.getText().trim();
        String strColumn = (String)cmbSearchType.getSelectedItem();
        update_table_search(strColumn,strSearch);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblReportListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReportListMouseClicked
        // TODO add your handling code here:
        btnViewReport.setEnabled(true);
        btnDeleteReport.setEnabled(true);
    }//GEN-LAST:event_tblReportListMouseClicked

    private void btnViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportActionPerformed
        // TODO add your handling code here:
        int rID = get_table_row_id();
        int row = tblReportList.getSelectedRow();
        String type = (String)(tblReportList.getModel().getValueAt(row, 3));
        viewReport(rID, type);
    }//GEN-LAST:event_btnViewReportActionPerformed

    private void btnDeleteReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteReportActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "Are sure you want to delete this report?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response == JOptionPane.YES_OPTION)
        {
            int rID = get_table_row_id();
            int row = tblReportList.getSelectedRow();
            String type = (String)(tblReportList.getModel().getValueAt(row, 3));
            String sqlQuery = "DELETE FROM report WHERE id = ?";
            try 
            {
                pst = con.prepareStatement(sqlQuery);
                pst.setInt(1, rID);
                pst.execute();
                if (type.equals("Blood"))
                {
                    sqlQuery = "DELETE FROM report_blood WHERE id = ?";
                    pst = con.prepareStatement(sqlQuery);
                    pst.setInt(1, rID);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Report Successfully Deleted.");
                    update_table("date");
                }
                else if (type.equals("Urine"))
                {
                    sqlQuery = "DELETE FROM report_urine WHERE id = ?";
                    pst = con.prepareStatement(sqlQuery);
                    pst.setInt(1, rID);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Report Successfully Deleted.");
                    update_table("date");
                }
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(LabReportManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            btnViewReport.setEnabled(false);
            btnDeleteReport.setEnabled(false);
        }
        
    }//GEN-LAST:event_btnDeleteReportActionPerformed

    private void cmbFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbFilterMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmbFilterMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        home.setVisible(true);
        close();
    }//GEN-LAST:event_btnBackActionPerformed

    private void tblReportListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReportListMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tblReportListMouseEntered

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
            java.util.logging.Logger.getLogger(LabReportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LabReportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LabReportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LabReportManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LabReportManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateReport;
    private javax.swing.JButton btnDeleteReport;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewReport;
    private javax.swing.JComboBox cmbDoctorName;
    private javax.swing.JComboBox cmbFilter;
    private javax.swing.JComboBox cmbPatientName;
    private javax.swing.JComboBox cmbReportType;
    private javax.swing.JComboBox cmbSearchType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblUserLevel;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JPanel pnlReport1;
    private javax.swing.JPanel pnlReport2;
    private javax.swing.JTable tblReportList;
    private javax.swing.JTextField txtR1F1;
    private javax.swing.JTextField txtR1F10;
    private javax.swing.JTextField txtR1F11;
    private javax.swing.JTextField txtR1F2;
    private javax.swing.JTextField txtR1F3;
    private javax.swing.JTextField txtR1F4;
    private javax.swing.JTextField txtR1F5;
    private javax.swing.JTextField txtR1F6;
    private javax.swing.JTextField txtR1F7;
    private javax.swing.JTextField txtR1F8;
    private javax.swing.JTextField txtR1F9;
    private javax.swing.JTextField txtR2F1;
    private javax.swing.JTextField txtR2F2;
    private javax.swing.JTextField txtR2F3;
    private javax.swing.JTextField txtR2F4;
    private javax.swing.JTextField txtR2F5;
    private javax.swing.JTextField txtR2F6;
    private javax.swing.JTextField txtR2F7;
    private javax.swing.JTextField txtR2F8;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
