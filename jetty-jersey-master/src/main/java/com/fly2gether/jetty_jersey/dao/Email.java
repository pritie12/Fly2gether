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
	private  String username="fly2gether@gmail.com";
	private  String pwd="marsupilami";
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
	public Email(String recipient, String subject, String content) {
		this.recipient=recipient;
		this.subject=subject;
		this.content=content;
		sendMail();
	}
	public void sendMail() {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.host", "smtp.gmail.com");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, pwd);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);

			System.out.println("Email sent successfully!");

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		}

	}


}
