package dk.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Service;

import java.lang.Exception;import java.lang.Override;

/**
 * Created by 52947 on 06-04-2016.
 */
@Configuration
@Service
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginService loginService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                /*.userDetailsService(loginService);*/
                //.passwordEncoder(passwordEncoder());
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }

    @Override
     protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/profile").hasRole("USER")
                .antMatchers("/**").permitAll()
                //.authorizeRequests()
                        .anyRequest().authenticated()
                .and()
                .formLogin()
                        .usernameParameter("username")
                        .passwordParameter("password")

                //.and()
                //.anonymous()
                .and()
                .httpBasic().disable()
                .csrf().disable();
    }
}

