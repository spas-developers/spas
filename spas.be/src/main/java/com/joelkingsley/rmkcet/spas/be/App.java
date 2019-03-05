package com.joelkingsley.rmkcet.spas.be;

import java.util.Arrays;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	
	private final Logger LOGGER = Logger.getLogger(App.class.getName());
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
    
    @Bean
   	public CommandLineRunner commandLineRunner(ApplicationContext context) {
   		return args -> {
   			
   			LOGGER.info("Let's inspect the beans provided by Spring Boot:");
   			
   			String[] beanNames = context.getBeanDefinitionNames();
   			Arrays.sort(beanNames);
   			for(String beanName : beanNames) {
   				LOGGER.info(beanName);
   			}
   			
   		};
   	}
}
