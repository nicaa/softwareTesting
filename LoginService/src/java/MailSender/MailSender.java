/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailSender;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Imran
 */
public class MailSender {

    String senderMail = "FreshBagelTester@gmail.com"; //has to be a gmail!!!
    String password = "HelloWorld123";
   // String mail = "nica1408@gmail.com"; //any valid email
    
    public void sendMail(String mail){
        Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderMail, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderMail));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mail));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");
                        
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
    }
    
    public void welcomeMail(String mail){
        Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderMail, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderMail));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mail));
			message.setSubject("Welcome! LoginService");
			message.setText("Dear User,"
				+ "\n\n Welcome to our service! Hope you will enjoy your stay!");
                        
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	
    }
}
