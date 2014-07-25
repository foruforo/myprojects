package com.netsol.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class Sender {

	private static final Logger logger = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private JavaMailSender javaMailSender;

	private MimeMessage message;

	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
		this.message = javaMailSender.createMimeMessage();
	}

	private HashMap<String, String> templateCache = new HashMap<String, String>();

	public void sendMail(EmailGenerator email) {
		try {
			this.message = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("admin@demo.com");
			helper.setTo(email.getToEmail());
			if (email.getBccEmail() != null) {
				helper.setBcc(email.getBccEmail());
			}
			if (email.getCcEmail() != null) {
				helper.setCc(email.getCcEmail());
			}
			helper.setSentDate(new Date());
			helper.setSubject(email.getSubject());
			helper.setText(
					getEmailBody(email.getTemplateName(), email.getParam()),
					true);

			javaMailSender.send(message);

		} catch (Exception e) {
			logger.debug("error ocuurred in email sending", e);
			e.printStackTrace();
		}

	}

	private String getEmailBody(String templateName, Map<?, ?> model)
			throws IOException {
		templateName = templateName.replaceAll("%20", " ");
		String emailBody = null;
		File file = null;
		emailBody = templateCache.get(templateName);
		if (emailBody == null) {
			try {
				file = new File(templateName);// + ".template"
				if (!file.exists()) {
					FileSystemResource  resource = new FileSystemResource (
							templateName + ".template");
					file = resource.getFile();
				}
				FileInputStream fin = new FileInputStream(file);
				byte[] bytes = new byte[(int) file.length()];
				fin.read(bytes);
				emailBody = new String(bytes);
				// System.out.println("TEST:" + emailBody);
				templateCache.put(templateName, emailBody);
				fin.close();
			} catch (Exception e) {
				e.printStackTrace();
				logger.debug("error ocuurred in email sending", e);
			}

		}

		if (emailBody != null) {
			Iterator<?> itr = model.keySet().iterator();
			while (itr.hasNext()) {
				String key = (String) itr.next();
				String value = (String) model.get(key);
				if (value == null) {
					value = "NA";
				}
				emailBody = emailBody.replaceAll(key, value);
			}
		}

		return emailBody;
	}

}


