package fr.rginfo.philou.pgo.map.alert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlertBean {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String email;
  private Integer minIv;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getMinIv() {
    return minIv;
  }

  public void setMinIv(Integer minIv) {
    this.minIv = minIv;
  }
}
