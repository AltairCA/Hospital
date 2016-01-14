/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_records_mng_sys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author S.Jayasinghe
 */
public class records extends Patient_Records_Mng_Sys {
    Connection conn=null;
    static String date_error="";
    /**
     * Creates new form records
     */
    public void label(){
        jLabel13.setText("Hello "+username+" ");
        jLabel11.setText(level);
    };
    
    public records() {
       // AutoCompleteDecorator.decorate(this.clinic_name);
        
        setTitle("Enter Patient Medical Records");
        conn = dbconnect.ConnectDB();
        initComponents();
        id.setText(String.valueOf(patient_id));
        name.setText(String.valueOf(patient_name));
       
        this.label();
        
       //Connection conn=null;
      
       try{
           Class.forName("com.mysql.jdbc.Driver");
           //conn = DriverManager.getConnection("jdbc:mysql://localhost/itp?"+"user=root&password=sparksndl");
           //conn = DriverManager.getConnection("jdbc:mysql://localhost/itp?"+"user="+user+"&password="+pass+"");
           Statement sqlState=conn.createStatement();
           String select="SELECT * FROM `clinic` WHERE 1";
           ResultSet rows=sqlState.executeQuery(select);
          
           while(rows.next()){
            clinic_name.addItem(rows.getString(2));
            
             }
           AutoCompleteDecorator.decorate(this.clinic_name);
       }catch(ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
        //For Doctors
        try{
           Class.forName("com.mysql.jdbc.Driver");
           //conn = DriverManager.getConnection("jdbc:mysql://localhost/itp?"+"user=root&password=sparksndl");
           //conn = DriverManager.getConnection("jdbc:mysql://localhost/itp?"+"user="+user+"&password="+pass+"");
           Statement sqlState=conn.createStatement();
           String select="SELECT * FROM `doctor` WHERE 1";
           ResultSet rows=sqlState.executeQuery(select);
          
           while(rows.next()){
            doctor.addItem(rows.getString(4));
            
             }
           AutoCompleteDecorator.decorate(this.doctor);
       }catch(ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
        
        
        
        //Logic ends//
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        allergie = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        remark = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        diagnose = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        doctor = new javax.swing.JComboBox();
        clinic_name = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        wardLabel = new javax.swing.JLabel();
        wardText = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });
        jPanel1.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setText("Level");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(830, 40, 60, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Name");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(810, 20, 100, 30);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(110, 140, 150, 30);

        jButton5.setText("View History");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(620, 460, 110, 23);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient_records_mng_sys/images/admin1.png"))); // NOI18N
        jPanel1.add(jLabel14);
        jLabel14.setBounds(920, 10, 70, 80);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Profile");
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jLabel15);
        jLabel15.setBounds(830, 10, 41, 17);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 51));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Logout");
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17);
        jLabel17.setBounds(830, 60, 43, 17);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 90, 1460, 20);

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel12.setText("Patient Medical Records ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(370, 30, 250, 20);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel10.setText("Allergies Diagnosed");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(510, 320, 140, 40);

        allergie.setColumns(20);
        allergie.setRows(5);
        jScrollPane4.setViewportView(allergie);

        jPanel1.add(jScrollPane4);
        jScrollPane4.setBounds(500, 350, 480, 100);

        jButton2.setText("Insert Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(500, 460, 110, 23);

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Special Remarks");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 320, 140, 40);

        remark.setColumns(20);
        remark.setRows(5);
        jScrollPane3.setViewportView(remark);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 350, 480, 100);

        diagnose.setColumns(20);
        diagnose.setRows(5);
        jScrollPane2.setViewportView(diagnose);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 210, 960, 120);

        jLabel8.setFont(new java.awt.Font("Calibri", 3, 16)); // NOI18N
        jLabel8.setText("Investigations & Treatments");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 190, 190, 20);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Next Clinic Date");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 140, 100, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Name of Doctor");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(660, 100, 90, 30);

        doctor.setEditable(true);
        jPanel1.add(doctor);
        doctor.setBounds(770, 100, 140, 30);

        clinic_name.setEditable(true);
        clinic_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clinic_nameActionPerformed(evt);
            }
        });
        jPanel1.add(clinic_name);
        clinic_name.setBounds(510, 100, 130, 30);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Clinic");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(460, 100, 40, 30);

        name.setEditable(false);
        jPanel1.add(name);
        name.setBounds(280, 100, 150, 30);

        id.setEditable(false);
        jPanel1.add(id);
        id.setBounds(70, 100, 100, 30);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Patient Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 100, 90, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient_records_mng_sys/images/Back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 80, 70);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("PatientID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 100, 60, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient_records_mng_sys/images/cool-hd-blurred.jpg"))); // NOI18N
        jLabel1.setText("Next Clinic Date");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, -20, 1560, 550);

        wardLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        wardLabel.setText("Ward ");
        jPanel1.add(wardLabel);
        wardLabel.setBounds(10, 140, 50, 20);

        wardText.setEditable(false);
        jPanel1.add(wardText);
        wardText.setBounds(70, 140, 100, 30);

        jMenu1.setText("File");

        jMenuItem1.setText("Exit System");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1012, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setReset();
        before_one one=new before_one();
        one.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            this.setVisible(false) ;       // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        session=patient_id;
        History frame=new History();
        frame.setVisible(true);
        frame.fireTable();
        //this.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void clinic_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clinic_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clinic_nameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save your data?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
          //  JOptionPane.showMessageDialog(null,"Yes");
            
        String diag="";
        String allerg="";
        String remarks="";
            
      diag=diagnose.getText();
      allerg=allergie.getText();
      remarks=remark.getText();
       // String next_date="";
        String clinic =  (String) clinic_name.getSelectedItem();
        String doc_name= (String) doctor.getSelectedItem();
        SimpleDateFormat javadate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String next_date="";
        try{
        next_date = javadate .format(jDateChooser1.getDate());
        }
        catch(Exception e1){
               next_date="";
               //JOptionPane.showMessageDialog(null,"Please re-check the next clinic date,Patient is supposed arrive on a future date than of today");
               //date_error="Please re-check the next clinic date,Patient is supposed arrive on a future date than of today";
                //Error Occred,Possible User didnt provide the date//
        };
        
        Date date = new Date();
        String today = javadate.format(date);
        //JOptionPane.showMessageDialog(null,next_date);
        boolean comp=today.compareTo(next_date)<0;
        
        //JOptionPane.showMessageDialog(null,comp);
        
        if((!"".equals(diag))&&(!"".equals(allerg))&&(!"".equals(remarks))&&(comp==true)&&(!"".equals(next_date))){
            //Insert into the DB
            //Connection conn=null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           //conn = DriverManager.getConnection("jdbc:mysql://localhost/itp?"+"user=root&password=sparksndl");
           //conn = DriverManager.getConnection("jdbc:mysql://localhost/itp?"+"user="+user+"&password="+pass+"");
           Statement sqlState=conn.createStatement();
           String insert="INSERT INTO `itp`.`medical_records` (`ID`, `patient_id`, `clinicName`, `diagnosis`, `dateOfEntry`, `allergiesIdentified`, `Remarks`, `nextClinicDate`, `ward`) VALUES (NULL, '"+patient_id+"', '"+clinic+"', '"+diag+"', '"+today+"', '"+allerg+"', '"+remarks+"', '"+next_date+"', 'none');\n" +
"		";
          sqlState.executeUpdate(insert);
           //Clear Content//
        diagnose.setText("");
        allergie.setText("");
        remark.setText("");
          
          //Clearing finished//
           
           
           
       }catch(ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
       
       
       //Un Comment at the integration 
        sms send_message=new sms();
        try {
            String message="Your+Next+Clinic+Date+Is+On::"+next_date+"";
            send_message.sms(telephone,message);
        } catch (Exception ex) {
            Logger.getLogger(records.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
      
            //DB finished//
            
        }else
        {   if(comp==false){
            date_error="Please re-check the next clinic date.Patient is supposed arrive on a future date than of today";
            }else
        {
            date_error="";
        }
            
            JOptionPane.showMessageDialog(null,"Please fill the required fields correctly. "+date_error);
            diagnose.setText(diag);
            allergie.setText(allerg);
            remark.setText(remarks);
            
            
        }
        
            
            
        }else
        {
            JOptionPane.showMessageDialog(null,"You have selected No");
        }
        
        
        
        
        
      //  Enter to the database



// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
      // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
this.setVisible(false);
        //redirect to homepage        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

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
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(records.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new records().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea allergie;
    private javax.swing.JComboBox clinic_name;
    private javax.swing.JTextArea diagnose;
    private javax.swing.JComboBox doctor;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField name;
    private javax.swing.JTextArea remark;
    private javax.swing.JLabel wardLabel;
    private javax.swing.JTextField wardText;
    // End of variables declaration//GEN-END:variables
}