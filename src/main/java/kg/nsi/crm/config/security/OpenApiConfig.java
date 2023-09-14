package kg.nsi.crm.config.security;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact =
                @Contact(
                        name = "Developer"
                ),
                description = "API documentation for Mindmentor CRM System",
                title = "CRM system API",
                version = "1.0"
                 ),
                servers =
                {
                    @Server(
                            description = "Local DEV",
                            url = "https://mindmentor-back-4e278328d2f5.herokuapp.com/swagger-ui/index.html#/Vacancy/createVacancy"
                    )
                })
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT Auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}
