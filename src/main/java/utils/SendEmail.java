package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import entities.User;

public class SendEmail {

    final String BGmail = "bgelectronicsofficial@gmail.com";
    final String password = "udditpaevdykcqxy";
	
    public void sendMail(String userMail, String subject, String userMsg) {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(BGmail, password);
            }
          }
        );
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(BGmail));
            msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(BGmail));
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
    
    public void sendPassword(User u) {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(BGmail, password);
            }
          }
        );
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("bgelectronicsofficial@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(u.getMail()));
            msg.setSubject("Recuperaci�n de contrase�a");
            
            StringBuilder txt = new StringBuilder();
            txt.append("Hola, " + u.getName() + ":").append(System.lineSeparator());
            txt.append("").append(System.lineSeparator());
            txt.append("Hemos recibido una solicitud para recuperar tu cuenta de BG Electronics.").append(System.lineSeparator());
            txt.append("").append(System.lineSeparator());
            txt.append("Tu contrase�a es: " + u.getPassword()).append(System.lineSeparator());
            txt.append("").append(System.lineSeparator());
            txt.append("").append(System.lineSeparator());
            txt.append("�No fuiste t� quien realiz� la solicitud?").append(System.lineSeparator());
            txt.append("No te preocupes, solo ignora este email.").append(System.lineSeparator());
            msg.setText(txt.toString());
            
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void sendCodeToChangePassword(User u, String randomCode) {

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(BGmail, password);
            }
          }
        );
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(BGmail));
            msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(u.getMail()));
            msg.setSubject("C�digo para modificar contrase�a");
            
            StringBuilder txt = new StringBuilder();
            txt.append("Hola, " + u.getName() + ":").append(System.lineSeparator());
            txt.append("Hemos recibido una solicitud para modificar la contrase�a de tu cuenta de BGElectronics.").append(System.lineSeparator());
            txt.append("Para continuar, deber�s ingresar el siguiente c�digo:").append(System.lineSeparator());
            txt.append("").append(System.lineSeparator());
            txt.append(randomCode).append(System.lineSeparator());
            txt.append("").append(System.lineSeparator());
            txt.append("�No fuiste t� quien realiz� la solicitud?").append(System.lineSeparator());
            txt.append("Deber�as ponerte en contacto con nosotros, tu cuenta podr�a estar en peligro. Cont�ctanos en nuestra p�gina web as� podemos ayudarte.");
            msg.setText(txt.toString());
            
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
}