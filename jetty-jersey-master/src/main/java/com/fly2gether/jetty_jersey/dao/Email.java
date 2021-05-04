package com.fly2gether.jetty_jersey.dao;

import java.net.Authenticator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	private  String username="ufly_eidd@outlook.com";
	private  String pwd="choco0234xx";
	private  String sender=username;
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
		//sendMail();
	}
	public static void mailSender(String message, String subject,String adressee) {
        Properties props = new Properties();
        props.put("mail.smtp.user", "FlightShare@outlook.com");
        props.put("mail.smtp.host", "smtp-mail.outlook.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth", "true");
        //props.put("mail.smtp.socketFactory.port", "587");
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //props.put("mail.smtp.socketFactory.fallback", "true");

        try
        {
        javax.mail.Authenticator auth = new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("FlightShare@outlook.com", "ShareFlight123");
            }
          };

        Session session = Session.getInstance(props, auth);

        MimeMessage msg = new MimeMessage(session);
        msg.setText(message);
        msg.setSubject(subject);
        msg.setFrom(new InternetAddress("FlightShare@outlook.com"));
        msg.addRecipient(Message.RecipientType.TO, new InternetAddress(adressee));
        Transport.send(msg);

        }catch (MessagingException mex) {
           mex.printStackTrace();
        }
    }


	
	public static void main(String [] args) throws MessagingException { 
		String test="Eidd gang";
		mailSender(test,"tesst","hiba.souber.hs@gmail.com");
	}


}
