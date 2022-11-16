package com.alticci;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Alticci calculation API",
				version = "1.0",
				description = "2022 Alticci calculation API",
				contact = @Contact(
						name = "Julio Queija",
						email = "juliocqueija@gmail.com"
				)
		)
)
@SpringBootApplication
public class AlticciApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlticciApplication.class, args);
	}

}
