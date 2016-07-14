package org.spartan;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder authenticationManagerBuilder, DataSource dataSource) throws Exception{
//		authenticationManagerBuilder.inMemoryAuthentication()
//		.withUser("admin").password("123").roles("ADMIN","PROF");
//		
//		authenticationManagerBuilder.inMemoryAuthentication()
//		.withUser("prof1").password("123").roles("PROF");
//		
//		authenticationManagerBuilder.inMemoryAuthentication()
//		.withUser("et1").password("123").roles("ETUDIANT");
//		
//		authenticationManagerBuilder.inMemoryAuthentication()
//		.withUser("sco1").password("123").roles("SCOLARITE");
		
		authenticationManagerBuilder
			.jdbcAuthentication()
				.dataSource(dataSource)
					.usersByUsernameQuery("SELECT username as principal, password as credentials, true FROM users WHERE username = ?")
					.authoritiesByUsernameQuery("SELECT users as principal, roles as role FROM users_roles WHERE users = ?")
					.rolePrefix("ROLE_");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/css/**","/js/**","/images/**").permitAll()
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
			.defaultSuccessUrl("/index.html")
			;
	}
}
