package com.holaland.holalandadmin.config;

import com.holaland.holalandadmin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserServiceImpl userDetailsService;

    @Autowired
    public WebSecurityConfig(UserServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        //  User in Database
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/css/**", "/images/**", "/js/**", "/webfonts/**").permitAll();
        http.authorizeRequests().antMatchers("/login", "/logout", "/register").permitAll();
        //http.authorizeRequests().anyRequest().authenticated();

        http.authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN");
//        http.authorizeRequests().antMatchers("/fpt-university/department/**", "/fpt-university/lecturers/**", "/works/create-request-find-job", "/works/request-find-job-manage/**", "/works/jobs-save", "/works/jobs-apply").hasAnyRole("MEMBER");
//        http.authorizeRequests().antMatchers("/profile/**").hasAnyRole("MEMBER", "RECRUITER", "SELLER");
//        http.authorizeRequests().antMatchers("/store/**").hasAnyRole("SELLER");
//        http.authorizeRequests().antMatchers("/show-info").hasAnyRole("MEMBER", "RECRUITER", "SELLER");

        // Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL login
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                // Logout Page
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout");

        // Permission
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Remember Me
        http.rememberMe()
                .key("uniqueAndSecret")
                .tokenRepository(this.persistentTokenRepository())
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        // Save remember me in memory (RAM)
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
