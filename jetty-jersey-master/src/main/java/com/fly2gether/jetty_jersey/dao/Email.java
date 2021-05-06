package com.fly2gether.jetty_jersey.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	private static  String username="fly2getherEIDD@outlook.com";
	private static  String pwd="Fly2gether1999";
	private static  String sender=username;
	private  String recipient;
	private  String subject;
	private  String content;
	public String getPwd() {
		return pwd;
	}
	public String getSender() {
		return sender;
	}
	public String getRecipient() {
		return recipient;
	}
	public String getSubject() {
		return subject;
	}
	public String getContent() {
		return content;
	}
	public Email(String recipient, String subject, String content) throws MessagingException {
		this.recipient=recipient;
		this.subject=subject;
		this.content=content;
		sendMail();
	}
	public  void sendMail() {
        Properties props = new Properties();
        props.put("mail.smtp.user", sender);
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");


        try
        {
        javax.mail.Authenticator auth = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, pwd);
            }
          };

        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        msg.setText(content);
        msg.setSubject(subject);
        msg.setFrom(new InternetAddress(sender));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        Transport.send(msg);
        System.out.println("Message sent successfully");

        }catch (MessagingException mex) {
           mex.printStackTrace();
        }
    }
	
	public static void main(String [] args) throws MessagingException { 
		String test="I was angry with my friend; \r\n"
				+ "I told my wrath, my wrath did end.\r\n"
				+ "I was angry with my foe: \r\n"
				+ "I told it not, my wrath did grow. \r\n"
				+ "\r\n"
				+ "And I waterd it in fears,\r\n"
				+ "Night & morning with my tears: \r\n"
				+ "And I sunned it with smiles,\r\n"
				+ "And with soft deceitful wiles. \r\n"
				+ "\r\n"
				+ "And it grew both day and night. \r\n"
				+ "Till it bore an apple bright. \r\n"
				+ "And my foe beheld it shine,\r\n"
				+ "And he knew that it was mine. \r\n"
				+ "\r\n"
				+ "And into my garden stole, \r\n"
				+ "When the night had veild the pole; \r\n"
				+ "In the morning glad I see; \r\n"
				+ "My foe outstretched beneath the tree.\r\n"
				+ "\r\n";
		new Email("hiba.souber.hs@gmail.com","A Poison Tree by William Blake",test);
	}


}
