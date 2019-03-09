package fr.rginfo.philou.pgo.map.alert.facebook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import javax.sql.DataSource;

@Configuration
@ConditionalOnProperty(prefix = "rg-info.alert", name = "facebook.enabled", havingValue = "true")
public class FacebookConfiguration {

  @Value("${rg-info.alert.facebook.key}")
  private String facebookClientId;

  @Value("${rg-info.alert.facebook.secret}")
  private String facebookSecret;

  @Bean
  public ConnectionFactoryLocator connectionFactoryLocator() {
    ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
    registry.addConnectionFactory(new FacebookConnectionFactory(facebookClientId, facebookSecret));
    return registry;
  }

  @Bean
  public UsersConnectionRepository usersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator, DataSource dataSource) {
    JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
//    repository.setConnectionSignUp(new SimpleConnectionSignUp());
    return repository;
  }

  @Bean
  @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
  public ConnectionRepository connectionRepository(UsersConnectionRepository usersConnectionRepository) {
//    User user = SecurityContext.getCurrentUser();
    return usersConnectionRepository.createConnectionRepository("foo"); //user.getId());
  }

  @Bean
  @Scope(value="request", proxyMode= ScopedProxyMode.INTERFACES)
  public Facebook facebook(ConnectionRepository connectionRepository) {
    return connectionRepository.getPrimaryConnection(Facebook.class).getApi();
  }
}
