package demo.core.config;

import javax.servlet.Filter;

import org.h2.server.web.WebServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import demo.web.MDCFilter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	private static final Logger LOG = LoggerFactory.getLogger(WebConfig.class);
	
	//adding some view controllers that just return a view no extra processing etc etc
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
	
	
	//registering a h2 servlet to process requests for h2 console
	@Bean
	ServletRegistrationBean h2ServletRegistration(){
		LOG.info("Registering h2Servlet for console ...");
		ServletRegistrationBean regBean = new ServletRegistrationBean(new WebServlet());
		regBean.addUrlMappings("/console/*");
		return regBean;
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12);
	}
	
	//HTTP filter for MDC
	@Bean
	FilterRegistrationBean mdcFilter(){
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new MDCFilter());
		registration.addUrlPatterns("/*");
				
		return registration;
	}
}
