

package com.appliance.AFAPP.configue;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@ConditionalOnProperty(name = "keycloak.enabled", havingValue = "true", matchIfMissing = true)
public class KeycloakSpringSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(keycloakAuthenticationProvider());

    }
@Override
    protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
    http.authorizeRequests().antMatchers("/A/**").hasAuthority("for_ilyass");

      http.authorizeRequests().antMatchers("/Type/**").hasAuthority("for_ilyass");

    http.authorizeRequests().antMatchers("/C/**").hasAuthority("test");
    http.authorizeRequests().antMatchers("/Contact/**").hasAuthority("for_ilyass");
    http.authorizeRequests().antMatchers("/TypePrestation/**").hasAuthority("For_ilyass");
    http.authorizeRequests().antMatchers("/Pov/**").hasAuthority("For_ilyass");
    http.authorizeRequests().antMatchers("/Suivi/**").hasAuthority("For_ilyass");
    http.authorizeRequests().antMatchers("/Seance/**").hasAuthority("For_ilyass");


    http.csrf().disable().authorizeRequests();

    http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
            .anyRequest()

            .authenticated();


}

}
/*
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class KeycloakSpringSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new KeycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests().antMatchers("/Appliance/**").permitAll();
        http.headers().frameOptions().disable();
        http.csrf().disable();
        http.authorizeRequests().anyRequest().authenticated();

    }

 */




