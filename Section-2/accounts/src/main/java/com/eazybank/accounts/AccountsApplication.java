package com.eazybank.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import static java.awt.SystemColor.info;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Account Microservice REST API Documentation",
				description = "EazyBank Account microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Jon Doe",
						email = "doeJon@gamil.com",
						url = "http://www.eazybank.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.eazybank.com"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Accounts microservices REST API Documentation",
				url = "https://www.eazybank.com/swagger-ui/index.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
