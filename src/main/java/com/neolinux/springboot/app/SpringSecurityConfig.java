package com.neolinux.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.neolinux.springboot.app.model.service.JpaUserDetailsService;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/", "/css/**", "/js/**", "/listar").permitAll()
		.antMatchers("/ver/**").hasAnyRole("USER")
		.antMatchers("/form/**").hasAnyRole("ADMIN")
		.antMatchers("/alumnos/**").hasAnyRole("ADMIN")
		.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
			.formLogin().loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	public void ConfigurerGlobal(AuthenticationManagerBuilder build) throws Exception{
		
		build.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		build.inMemoryAuthentication().withUser(users.username("admin").password("admin").roles("ADMIN", "USER"))
//				.withUser(users.username("624992").password("mateo").roles("USER"));
	}
	
}
