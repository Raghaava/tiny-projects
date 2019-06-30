package org.learning.jwtsecurity.config;

import com.google.common.collect.Lists;
import org.learning.jwtsecurity.security.JwtAuthSuccessHandler;
import org.learning.jwtsecurity.security.JwtAuthenticationEntryPoint;
import org.learning.jwtsecurity.security.JwtAuthenticationProvider;
import org.learning.jwtsecurity.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class JwtSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationProvider authenticationProvider;
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Lists.newArrayList(authenticationProvider));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .disable()
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/hello")
                .authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //call JWT token filter first
        http.addFilterBefore(authenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    //Overriding default LDAP filter from spring
    public JwtAuthenticationTokenFilter authenticationTokenFilter() {
        JwtAuthenticationTokenFilter jwtAuthTokenFilter = new JwtAuthenticationTokenFilter();
        jwtAuthTokenFilter.setAuthenticationManager(authenticationManager());
        jwtAuthTokenFilter.setAuthenticationSuccessHandler(new JwtAuthSuccessHandler());
        return jwtAuthTokenFilter;
    }
}
