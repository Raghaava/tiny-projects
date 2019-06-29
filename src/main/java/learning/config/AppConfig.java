package learning.config;

import learning.service.DataService;
import learning.service.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {
  @Bean
  //Create bean always in context
  public DataService dataService() {
    return new DataService();
  }

  @Bean
  @Profile("test")
  public TestService testService() {
    return new TestService();
  }
}

