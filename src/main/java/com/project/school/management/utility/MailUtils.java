package com.project.school.management.utility;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailUtils {

	@Value("${email.username}")
	private String username;

	@Value("${email.password}")
	private String password;

	public Boolean sendEmail(String to, String from, String subject, String body) {
		Boolean flag = Boolean.FALSE;

		try {
			Properties properties = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("email.properties");
			properties.load(stream);

			Session session = Session.getInstance(properties, new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message message = new MimeMessage(session);
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setFrom(new InternetAddress(from));
			message.setSubject(subject);
			message.setText(body);
			Transport.send(message);
			flag = Boolean.TRUE;
		} catch (Exception e) {
			System.out.println(e);
			// TODO: handle exception
		}
		return flag;

	}
}
