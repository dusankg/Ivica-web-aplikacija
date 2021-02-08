package com.example.SOTIS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.SOTIS.model.User;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	@Async
	public void sendProbMail() throws MailException, InterruptedException {

		
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("dusan1998kg@gmail.com");
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Validacija registracije");
		mail.setText("Pozdrav, \n\n Vas zahtev za registaciju je prihacen. Ovde ces aktivirati nalog "+ "http://localhost:8082/api/patients/validate/");
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
	
	@Async
	public void sendVerificationCode(User user) throws MailException, InterruptedException {

		
		System.out.println("Slanje emaila...");

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject("Verifikacija registracije. Vas verifikacioni broj je: " + user.getVerificationCode());
		mail.setText(
					"Postovani/a " + user.getFirstName() + " " + user.getLastName() 
					+ ", \n\nVas zahtev za registaciju je prihvacen.\n\n"
					+ "Vas verifikacioni kod je: " + user.getVerificationCode()
					+ " \n\nOvde cete aktivirati nalog "+ "http://localhost:4200/validateAccount/" + user.getVerificationCode()
					);
		javaMailSender.send(mail);

		System.out.println("Email poslat!");
	}
}
