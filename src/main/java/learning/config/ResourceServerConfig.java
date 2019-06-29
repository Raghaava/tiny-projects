package learning.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

//@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
  @Autowired private DefaultTokenServices defaultTokenServices;

  @Autowired private TokenStore tokenStore;

  @Autowired ApplicationProperties applicationProperties;

  @Override
  public void configure(ResourceServerSecurityConfigurer configurer) throws Exception {
    configurer
        .resourceId(applicationProperties.getAuth().getResourceId())
        .tokenServices(defaultTokenServices)
        .tokenStore(tokenStore);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.cors()
        .and()
        .csrf()
        .disable()
        .authorizeRequests()
        .antMatchers(applicationProperties.getEndpoint().getTestEndpoint())
        .hasAuthority("test")
        .antMatchers(applicationProperties.getEndpoint().getIndex())
        .permitAll()
        .antMatchers("/**")
        .denyAll();
  }
}
