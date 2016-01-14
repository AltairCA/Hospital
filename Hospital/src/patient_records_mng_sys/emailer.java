package patient_records_mng_sys;
import java.io.File;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
//import static mondrian.rolap.RolapConnectionProperties.DataSource;

//import taxi.Interface;

public class emailer {

    
    private static String USER_NAME = "patientrecordssystem@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "071hospital"; // GMail password
    private static String RECIPIENT = "jsandunil@gmail.com";
    private static String filename="C:\\Users\\S.Jayasinghe\\Documents\\NetBeansProjects\\Patient_Records_Mng_Sys\\patientReport.pdf";
    public static void main(String[] args) {
        String file=filename;
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Patient Diagnosement Report";
        String body = "A report has been attached";
     //String send="";
     // sendFromGMail();
       
        
    }

    static void  sendFromGMail(String res) {
        
    try{    
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        
        //New//
        // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(USER_NAME,PASSWORD);
            }
         });

      try {
         // Create a default MimeMessage object.
         Message message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(USER_NAME));

         // Set To: header field of the header.
         message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(res));

         // Set Subject: header field
         message.setSubject("Patient Report Document");

         // Create the message part
         BodyPart messageBodyPart = new MimeBodyPart();

         // Now set the actual message
         messageBodyPart.setText("The requested patient document has been attached herewith");

         // Create a multipar message
         Multipart multipart = new MimeMultipart();

         // Set text message part
         multipart.addBodyPart(messageBodyPart);

         // Part two is attachment
         messageBodyPart = new MimeBodyPart();
        // String filename =filename;
         DataSource source = new FileDataSource(filename);
         messageBodyPart.setDataHandler(new DataHandler(source));
         messageBodyPart.setFileName(filename);
         multipart.addBodyPart(messageBodyPart);

         // Send the complete message parts
         message.setContent(multipart);

         // Send message
         Transport.send(message);

         System.out.println("Sent message successfully....");
         JOptionPane.showMessageDialog(null,"Email Successfully Sent!","Emailer",JOptionPane.INFORMATION_MESSAGE);
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
        //New//
    }catch(Exception network){     
        JOptionPane.showMessageDialog(null,"Internet Connection Is Required To Perform The Action.Your report was not send","Internet Connection",JOptionPane.ERROR_MESSAGE);
    }
    }
}