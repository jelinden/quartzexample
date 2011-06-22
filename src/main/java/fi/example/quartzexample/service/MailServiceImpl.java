package fi.example.quartzexample.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("sendMailService")
public class MailServiceImpl implements MailService {

  @Autowired
  private JavaMailSender mailSender;

  private String to;
  
  private String from;
  
  protected final Log log = LogFactory.getLog(getClass());

  public void sendMail(String subject, String body) {
    MimeMessage message = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
      helper.setText(body, true);
      mailSender.send(message);
    }
    catch(MessagingException e) {
      log.error("sending mail failed: " + e);
    } 
    catch (UnsupportedEncodingException e) {
      log.error("encoding subject failed: " + e);
    }
  }

  public void setMailSender(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setFrom(String from) {
    this.from = from;
  }
}