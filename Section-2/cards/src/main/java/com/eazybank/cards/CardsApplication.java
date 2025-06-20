package com.eazybank.cards;

import com.eazybank.cards.audit.AuditAwareImpl;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@OpenAPIDefinition(
	info = @Info(
				title = "EazyBank Card Microservice",
				description = "EazyBank Card Microservice to handle card data",
				version = "v1",
			contact = @Contact(
					name = "Jon Doe",
					email = "doejon@gmail.com",
					url = "https://www.eazybank.com"
			),
			license = @License(
					name = "Apache 2.0",
					url = "https://www.eazybank.com"
			)
	),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Cards microservices REST API Documentation",
				url = "https://www.eazybank.com/swagger-ui/index.html"
		)
)
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@SpringBootApplication
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
