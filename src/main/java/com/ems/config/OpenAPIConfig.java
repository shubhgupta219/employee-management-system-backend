package com.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI employeeManagementOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
						.title("Employee Management System")
						.description("Rest API's for Employee Management System")
						.version("1.0")
						.contact(new Contact()
								.name("admin")
								.email("admin@test.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Project Documentation"));
	}
}
