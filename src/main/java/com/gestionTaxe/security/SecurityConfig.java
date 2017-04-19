package com.gestionTaxe.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
private DataSource dataSource  ;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//auth.inMemoryAuthentication().withUser("mohamed").password("12345").roles("ADMIN","USER");
	//auth.inMemoryAuthentication().withUser("kamel").password("12345").roles("USER");
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username as principal , password as credentials , active   from  users where  username =? ")
		.authoritiesByUsernameQuery("select  username as  principal  ,  roles  as  role from  users_role where username = ?")
		.rolePrefix("ROLE_")  
		.passwordEncoder(new  ShaPasswordEncoder() ) ;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		//http.authorizeRequests().anyRequest().hasRole("SURVEILLANT"); // permet de désactiver tous les  réquetes pour  un  type de users 
		//http.authorizeRequests().anyRequest().authenticated(); // tous les  rêquettes nécessite  une authentification
		
		http.authorizeRequests().antMatchers("/taxes","/entreprises").hasRole("USER");
		http.authorizeRequests().antMatchers("/addEntreprise","/formEntreprise").hasRole("ADMIN");
		http.exceptionHandling().accessDeniedPage("/403");
	}
	

}
