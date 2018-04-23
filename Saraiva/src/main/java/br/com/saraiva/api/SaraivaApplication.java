package br.com.saraiva.api;
	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SaraivaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaraivaApplication.class, args);
	}
}
