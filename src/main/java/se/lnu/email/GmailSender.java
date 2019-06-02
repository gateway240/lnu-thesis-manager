package se.lnu.email;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class GmailSender {
	private String host = "smtp.gmail.com";
	private int port = 587;
	private String username;
	private String password;
	
	public JavaMailSender getJavaMailSender() {
		return setupMailSenderProperties(setupMailSender(new JavaMailSenderImpl()));
	}

	public GmailSender(String username, String password) {
		this.username = username;
		this.password = password;
	}

	private JavaMailSenderImpl setupMailSender(JavaMailSenderImpl mailSender) {
		mailSender.setHost(host);
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		return mailSender;
	}

	private JavaMailSenderImpl setupMailSenderProperties(JavaMailSenderImpl mailSender) {
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		return mailSender;
	}
}
