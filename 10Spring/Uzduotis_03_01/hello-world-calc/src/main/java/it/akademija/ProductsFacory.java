package it.akademija;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//08 pamoka 02_01 uzduotis. produktus kurkite @Bean konfiguracijos bean'se

@Configuration
public class ProductsFacory {
	@Bean 
	public Product samsung1FromBeanFactory() {
	return new Product();
	}
	
	@Bean
	public Product samsung2FromBeanFactory() {
	return new Product();
	}
	
	@Bean
	public Product samsung3FromBeanFactory() {
	return new Product("Mano1FromBeanFactory");
	}

	@Bean
	public Product samsung4FromBeanFactory() {
	return new Product("Mano2FromBeanFactory");
	}
	
}
