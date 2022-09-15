package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ContactEmail {

    public void sendMail(String userMail, String subject, String userMsg) {

        final String username = "";
        final String password = "";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          }
        );
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("bgelectronicsofficial@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("bgelectronicsofficial@gmail.com"));
            msg.setSubject(subject);
            
            StringBuilder txt = new StringBuilder();
            txt.append("Mail: " + userMail).append(System.lineSeparator());
            txt.append("").append(System.lineSeparator());
            txt.append(userMsg);
            msg.setText(txt.toString());
            
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
