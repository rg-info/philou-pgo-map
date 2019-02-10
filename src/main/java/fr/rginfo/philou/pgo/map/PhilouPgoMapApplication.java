package fr.rginfo.philou.pgo.map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class PhilouPgoMapApplication {

  public static void main(String[] args) {
    SpringApplication.run(PhilouPgoMapApplication.class, args);
  }

  @Bean
  public CommonsRequestLoggingFilter logFilter() {
    CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
    filter.setIncludeQueryString(true);
    filter.setIncludePayload(true);
    filter.setMaxPayloadLength(Integer.MAX_VALUE);
    filter.setIncludeHeaders(false);
    filter.setAfterMessagePrefix("REQUEST DATA : ");
    return filter;
  }
}

