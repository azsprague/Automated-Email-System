package email;
 
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    

/**
 * Does all of the back end work to access and send emails.
 * 
 * @author Aidan Sprague
 * @version 2020.12.20
 */
public class EmailScript { 

    private Session session;
    private Data data;
    
    
    /**
     * Constructor for the class.
     * @param data  A full data object
     */
    public EmailScript(Data data) {
        this.data = data;
    }
    
    /**
     * Signs into the email service.
     */
    public void signIn() { 
        //Get properties object    
        Properties props = new Properties();    
        props.put("mail.smtp.host", "smtp.gmail.com");    
        props.put("mail.smtp.socketFactory.port", "465");    
        props.put("mail.smtp.socketFactory.class",    
                  "javax.net.ssl.SSLSocketFactory");    
        props.put("mail.smtp.auth", "true");    
        props.put("mail.smtp.port", "465");   
        
        //Get Session   
        session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(data.getEmail(), data.getPassword());  
           }    
        });  
    }
    
    /**
     * Sends the message.
     */
    public void send() {
        try {
            MimeMessage message = new MimeMessage(session);
            for (String email : data.getRecipients()) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
            }
            message.setSubject(data.getHeader());    
            message.setText(data.getBody());
            
            Transport.send(message);
            
        } catch (MessagingException e) {throw new RuntimeException(e);}  
    }
             
}
