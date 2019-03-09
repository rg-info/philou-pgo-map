package fr.rginfo.philou.pgo.map.alert.mail;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MailRecipient {

  @Id
  private String email;

  public String getEmail() {
    return email;
  }

  public MailRecipient setEmail(String email) {
    this.email = email;
    return this;
  }
}
