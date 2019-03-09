package fr.rginfo.philou.pgo.map.alert.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MailService {

  private final MailRepository repository;
  private final JavaMailSender javaMailSender;

  public MailService(MailRepository repository, JavaMailSender javaMailSender) {
    Assert.notNull(repository, "repository can't be null");
    Assert.notNull(javaMailSender, "javaMailSender can't be null");

    this.repository = repository;
    this.javaMailSender = javaMailSender;
  }

  public void sendMessageToAllRecipient(String message) {
    repository.findAll().forEach(mailRecipient -> {
      sendMessageToRecipient(mailRecipient, message);
    });
  }

  public void sendMessageToRecipient(MailRecipient mailRecipient, String message)  {
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setTo(mailRecipient.getEmail());
    simpleMailMessage.setFrom("no-reply@philou.pgo.map");
    simpleMailMessage.setSubject("Perfect detected !!!!");
    simpleMailMessage.setText(message);
    javaMailSender.send(simpleMailMessage);
  }
}
