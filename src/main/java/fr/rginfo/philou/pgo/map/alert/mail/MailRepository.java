package fr.rginfo.philou.pgo.map.alert.mail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailRecipient, String> {
}
