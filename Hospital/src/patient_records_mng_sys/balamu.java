/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient_records_mng_sys;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.KeyStroke;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
//import ca.odell.glazedlists.swing;
import javax.swing.JComboBox;
import org.apache.pdfbox.exceptions.COSVisitorException;
import static patient_records_mng_sys.History.rows;
import static patient_records_mng_sys.Patient_Records_Mng_Sys.patient_id;


/**
 *
 * @author S.Jayasinghe
 */
public class balamu extends Patient_Records_Mng_Sys {
//private static final String COMMIT_ACTION = "commit";
    
//this.temp = new JComboBox(new Object[] { "Ester", "Jordi",
 //       "Jordina", "Jorge", "Sergi" });
//AutoCompleteDecorator.decorate(this.comboBox);
//System.out.println("Is editable - " + 
     //   this.comboBox.isEditable() + ". Surprise!");

        
    
    
    public balamu() {
        initComponents();
        
       
        
        
        
        AutoCompleteDecorator.decorate(this.temp);
        
        //SpellChecker.setUserDictionaryProvider(new FileUserDictionary());      
        //SpellChecker.registerDictionaries(this.getClass().getResource("//ortho"), "en");
        //SpellChecker.register(messageWriter);
        //mainTextField.setText(null);
   /*
    mainTextField.setFocusTraversalKeysEnabled(false);      
    ArrayList<String> keywords = new ArrayList<>(5);
        keywords.add("example");
        keywords.add("autocomplete");
        keywords.add("stackabuse");
        keywords.add("java");
        
     Autocomplete autoComplete = new Autocomplete(mainTextField, keywords);
     mainTextField.getDocument().addDocumentListener(autoComplete);
        
 mainTextField.getInputMap().put(KeyStroke.getKeyStroke("TAB"), COMMIT_ACTION);
// mainTextField.getActionMap().put(COMMIT_ACTION, autoComplete.new CommitAction()); 
 */       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        temp = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messageWriter = new javax.swing.JEditorPane();
        jButton2 = new javax.swing.JButton();
        books = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        temp.setEditable(true);
        temp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mo\t", "Moto", "Motoro", "Motorolla" }));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jScrollPane1.setViewportView(messageWriter);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton2))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(books, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(temp, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(books, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           
        
        
        String latta="Lotta";
        System.out.println("Dagakara"+latta+" Balla");
// String var="Testing";
       // jLabel1.setText("HelloMto! "+var+"");
        String bloody="1227";
        try{
        
        System.out.println("Create Simple PDF file with Text");
        String fileName = "patientReport.pdf"; // name of our file
        
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
 
        doc.addPage(page);
 
        PDPageContentStream content = new PDPageContentStream(doc, page);
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 20);
        content.moveTextPositionByAmount(220, 750);
        content.drawString("Patient Report Form");
        content.endText();
        
        int x=80;
        int y=700;
        String spac="        ";
        String documen="PatientID"+spac+"PatientName"+spac+"Clinic"+spac+"Diagnose";
        
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 16);
        content.moveTextPositionByAmount(x,710);
        content.drawString(documen);
        content.endText();
        
        //To add from database//
         Connection conn=null;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/itp?"+"user=root&password=sparksndl");
            Statement sqlState=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            String selectStuff="Select `ID`,`patient_id`,`clinicName`,`diagnosis`,`dateOfEntry`,`allergiesIdentified`,`Remarks`,`nextClinicDate`,`ward` FROM `medical_records` WHERE `patient_id` LIKE "+bloody+" ";
            rows=sqlState.executeQuery(selectStuff);
            Object[] tempRow;
            String [] records;
          while(rows.next()){
        //tempRow=new Object[]{rows.getString(1),rows.getString(2),rows.getString(3),rows.getString(4),rows.getDate(5),rows.getString(6),rows.getString(7),rows.getString(8)};
                //dTableModel.addRow(tempRow);
              String id=rows.getString(1);
              String name="Classified";
              String clinic=rows.getString(3);
              String diagnose=rows.getString(4);
              String aller=rows.getString(6);
              String remark=rows.getString(7);
              String space="                 ";
              String document=id+space+space+space+name+space+space+clinic+space+diagnose;
        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 8);
        content.moveTextPositionByAmount(x,y);
        content.drawString(document);
        
        content.endText();      
        y=y-12;        
                
          }
           
       }catch(ClassNotFoundException | SQLException e)
       {
           e.printStackTrace();
       }
        
        
        
        //Over//
        
        
        
        content.close();
        doc.save(fileName);
        doc.close();
        
        System.out.println("your file created in : "+ System.getProperty("user.dir"));
 
        }
        catch(IOException | COSVisitorException e){
        
        System.out.println(e.getMessage());
        
        }
 
    
        
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    File folder = new File("C:\\Users\\S.Jayasinghe\\Desktop\\Maths");
    File[] listOfFiles = folder.listFiles();

    for (File file : listOfFiles) {
    if (file.isFile()) {
        books.addItem(file.getName());
        books.setEditable(true);
        books.setEnabled(false);
        AutoCompleteDecorator.decorate(this.books);
        System.out.println(file.getName());
    }
}        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(balamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(balamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(balamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(balamu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new balamu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox books;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JEditorPane messageWriter;
    private javax.swing.JComboBox temp;
    // End of variables declaration//GEN-END:variables
}
