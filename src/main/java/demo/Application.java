package demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication //combines @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

	public static void main(String[] args) {
       ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
       System.out.println("------------------------------------------------");
       System.out.println("Spring Beans created by Spring Boot : ");
       System.out.println("------------------------------------------------");
       
       /*String[] beanNames = ctx.getBeanDefinitionNames();
       Arrays.sort(beanNames);
       
       for(String beanName : beanNames){
    	   System.out.println(beanName);
       }
        */
    }
	
}
