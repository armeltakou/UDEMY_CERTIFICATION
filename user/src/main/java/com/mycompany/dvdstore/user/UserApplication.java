package com.mycompany.dvdstore.user;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EntityScan("com.mycompany.dvdstore.core.entity.user")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public Hibernate5Module dataHibernate5Module() {
		Hibernate5Module module = new Hibernate5Module();
		module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
		module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
		return module;
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
