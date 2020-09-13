package pe.com.util;

import java.io.File;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class ApplicationMailer {

	/**
	 * This method will send compose and send the message
	 * 
	 * @throws MessagingException
	 */
	public void sendMail(String to, String subject, String body, String pathToAttachment, String nombreDocumento,
			boolean adjunto) throws MessagingException {
		try {
			JavaMailSender mailSender = getJavaMailSender();

			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("cinfo.unmsm.certificado@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText("", body);

			if (adjunto == true) {
				FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
				helper.addAttachment(nombreDocumento, file);
			}

			mailSender.send(message);

		} catch (MailException e) {
			//System.out.println(e.getMessage());
		}

	}

	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("cinfo.unmsm.certificado@gmail.com");
		mailSender.setPassword("iekmifzojnvsdhbo");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

}
