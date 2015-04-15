package demo.core.config;

import java.net.MalformedURLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.support.MBeanServerConnectionFactoryBean;


@Configuration

public class JMSConfig {

	//jmx connection factory bean for apache active mq
    @Bean
    public MBeanServerConnectionFactoryBean mbeanServerConnection() throws MalformedURLException{
    	MBeanServerConnectionFactoryBean mbeanfactory = new MBeanServerConnectionFactoryBean();
    	mbeanfactory.setServiceUrl("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
    	mbeanfactory.setConnectOnStartup(false);
    	return mbeanfactory;
    	
    }
	
	
}
