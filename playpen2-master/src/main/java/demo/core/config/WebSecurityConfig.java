package demo.core.config;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Inject
	BCryptPasswordEncoder passwordEncoder;
	
	@Inject
	UserDetailsService userDetailsService;
	
	private static final Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		LOG.info("configuring Spring Security");
		http
			.authorizeRequests()
				.antMatchers(
							"/img/**", 
							"/css/**",
							"/js/**",
							"/console/**",
							"/encode/**"
							).permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login");
		
		
		//only so can see h2 console should never disable in a production only dev
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		LOG.info("Configuring daoAuthentication provider");
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		//daoAuthProvider.setPasswordEncoder(passwordEncoder);
		daoAuthProvider.setUserDetailsService(userDetailsService);
		
		auth.authenticationProvider(daoAuthProvider);
		
	}
	

}
