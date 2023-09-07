package kg.nsi.crm;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class CrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);
	}

//	@Bean
//	public OpenAPI customOpenApi(@Value("${application-description}")String appDescription,
//								 @Value("${application-version}")String appVersion) {
//		return new OpenAPI().info(new Info().title("MindMentor CRM system API")
//						.version(appVersion)
//						.description(appDescription)
//						.license(new License().name("Apache 2.0")
//								.url("http://springdoc.org"))
//						.contact(new Contact().name("akimovadna")
//								.email("akimovadna@gmail.com")
//
//						))
//				.servers(List.of(new Server().url("http://localhost:8080")
//								.description("Dev service")));
//
//	}

}
