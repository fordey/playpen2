package demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;



@SpringBootApplication //combines @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {
       ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
       System.out.println("------------------------------------------------");
       System.out.println("Spring Beans created by Spring Boot : ");
       System.out.println("------------------------------------------------");
       
       String[] beanNames = ctx.getBeanDefinitionNames();
       Arrays.sort(beanNames);
       
       for(String beanName : beanNames){
    	   System.out.println(beanName);
       }
        
    }
	
}
