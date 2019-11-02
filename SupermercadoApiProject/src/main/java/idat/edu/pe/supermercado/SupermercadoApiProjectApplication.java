package idat.edu.pe.supermercado;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SupermercadoApiProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermercadoApiProjectApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(Locale.US);
		return slr;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource rbm = new ResourceBundleMessageSource();
		rbm.setBasename("messages");
		rbm.setUseCodeAsDefaultMessage(true);
		return rbm;
	}
	
}
