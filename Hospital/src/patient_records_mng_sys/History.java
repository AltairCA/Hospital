/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_records_mng_sys;


import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author S.Jayasinghe
 */


public class History extends Patient_Records_Mng_Sys {
Connection conn=null;
        //static String session="";
        static ResultSet rows;
        static Object [][] databaseResults;
        static Object[] columns={"ID","Patient ID","Clinic","Diagnosis","Date of Entry","Allergies","Remarks","Next Clinic"};   
        static DefaultTableModel dTableModel=new DefaultTableModel(databaseResults,columns){
            public Class getColumnClass(int column){
                Class returnValue;
                
                if((column>=0)&&(column<getColumnCount())){
                    returnValue=getValueAt(0,column).getClass();
                }
                else{
                    returnValue=Object.class;
                }
                return returnValue;
            }
                 
            };
        
        
        
        public void mouseReleased(MouseEvent me){
            String value=JOptionPane.showInputDialog(null,"Enter Cell value");
            if(value!=null){
                jTable1.setValueAt(value,jTable1.getSelectedRow(),jTable1.getSelectedColumn());
                String updateCol;
                try{
                    rows.absolute(jTable1.getSelectedRow()+1);
                    updateCol=dTableModel.getColumnName(jTable1.getSelectedColumn());
                    
                
                switch(updateCol){
                    case "Date of Entry":
                       JOptionPane.showMessageDialog(null,"Date alternations are not allowed");
                        break;
                    case "Next Clinic":
                       JOptionPane.showMessageDialog(null,"Date alternations are not allowed");
                        break;
                    default:
                        rows.updateString(updateCol,value);
                        rows.updateRow();
                        break;
                }
                }catch(SQLException e1){
                    e1.printStackTrace();
                    
                }
            }
        };
     
    /**
     * Creates new form search_patient
     */
    public History() {
//        jLabel16.setText("Printing info");
//       jTable1.setFont(new Font("Serif",Font.PLAIN,26));
//       jTable1.setRowHeight(jTable1.getRowHeight()+16);
//       jTable1.setAutoCreateRowSorter(true);
       //JScrollPane scrollPane=new JScrollPane(jTable1);
  
    
       setTitle("Search Records");
     //  JOptionPane.showMessageDialog(null,patient_id);
       dTableModel.setRowCount(0); 
       conn = dbconnect.ConnectDB();
       
       initComponents();
       jLabel7.setText("Hello "+username+" ");
       jLabel10.setText(level);
       //jTable1.repaint(); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Level");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(830, 40, 60, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Name");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(810, 20, 100, 30);

        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(870, 440, 100, 23);

        jButton2.setText("Search Another Patient");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(680, 440, 180, 23);

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient_records_mng_sys/images/admin1.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(920, 10, 60, 80);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(dTableModel);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 90, 1000, 310);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient_records_mng_sys/images/Back.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(10, 10, 80, 70);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 90, 1000, 30);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jLabel4.setText("View Patient Records");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(380, 20, 240, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patient_records_mng_sys/images/cool-hd-blurred.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 520);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1012, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // before_one one=new before_one();
       // one.setVisible(true);
       // this.setVisible(false);
        
        // patient_id="";
       if(key==0){
         this.setVisible(false);
       }// 
        else
       {
            JOptionPane.showMessageDialog(null,"You are viewing the patient records,Please select below buttons to return ");
       };
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        session=""; 
        search_patient_only frame=new search_patient_only();
        frame.setVisible(true);
        frame.label();
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try{
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Confirm The Deletion","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
        
        dTableModel.removeRow(jTable1.getSelectedRow());
        try{
            rows.absolute(jTable1.getSelectedRow());
            rows.deleteRow();
            
        }catch(Exception e1){
            e1.printStackTrace();
        }
        }
        else
        {
            
        }
        }catch(Exception e1){
            System.out.println("Possible Error Has Occured,Click on the row to be deleted");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Do you want to edit cell content?Warning,Sensitive material will be altered","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
        
            
            String value=JOptionPane.showInputDialog(null,"Enter Cell value");
            if((value!=null)&&(!"".equals(value))){
                jTable1.setValueAt(value,jTable1.getSelectedRow(),jTable1.getSelectedColumn());
                String updateCol;
                
                try{
                    rows.absolute(jTable1.getSelectedRow()+1);
                    updateCol=dTableModel.getColumnName(jTable1.getSelectedColumn());
                    
                
                switch(updateCol){
                    case "ID":
                            case "Patient ID":
                              JOptionPane.showMessageDialog(null,"ID alternations are not allowed.The desired change will not be permenently stored");  
                    case "Date of Entry":
                       JOptionPane.showMessageDialog(null,"Date alternations are not allowed.The desired change will not be permenently stored");
                        break;
                    case "Next Clinic":
                       JOptionPane.showMessageDialog(null,"Date alternations are not allowed.The desired change will not be permenently stored");
                        break;
                    case "Clinic" :
                        String name="clinicName";
                        rows.updateString(name,value);
                        rows.updateRow();
                        break;
                    case "Allergies" :
                        String aller_name="allergiesIdentified";
                        rows.updateString(aller_name,value);
                        rows.updateRow();
                        break;
                    default:
                        rows.updateString(updateCol,value);
                        rows.updateRow();
                        break;
                }
                }catch(SQLException e1){
                    //e1.printStackTrace();
                    
                }
            }
            else{
                 JOptionPane.showMessageDialog(null,"Null Value Provided,Database Not Updated");   
                 }
        
        }else
        {
            //User Clicked Cancel
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
 this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked

        this.setVisible(false);
        //redirect to homepage
        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseClicked

    /**
     * @param args the command line arguments
     */
    public void setColSize(){
      jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
      jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
      jTable1.getColumnModel().getColumn(2).setPreferredWidth(75);
      jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
      jTable1.setRowHeight(30);
    };
    
    public void fireTable(){
         jTable1.repaint();
         jLabel7.setText("Hello "+username+" ");
         jLabel10.setText(level);
         this.setColSize();
         
        
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Statement sqlState=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String bloody=patient_id;
            String selectStuff="Select `ID`,`patient_id`,`clinicName`,`diagnosis`,`dateOfEntry`,`allergiesIdentified`,`Remarks`,`nextClinicDate`,`ward` FROM `medical_records` WHERE `patient_id` LIKE "+bloody+" ";
            rows=sqlState.executeQuery(selectStuff);
            Object[] tempRow;
          
          while(rows.next()){
                tempRow=new Object[]{rows.getString(1),rows.getString(2),rows.getString(3),rows.getString(4),rows.getDate(5),rows.getString(6),rows.getString(7),rows.getString(8)};
                dTableModel.addRow(tempRow);
          }
           
       }catch(ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
       
     //  try{
     //      rows.moveToInsertRow();
     //      rows.updateString(username, testv);
     //      
      // }catch(Exception e){
           
      // }
    }
    
    public static void main(String args[]) {
      //Get Values from DB//
        
        
       
      
       
      //DB over//  
    
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new History().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
