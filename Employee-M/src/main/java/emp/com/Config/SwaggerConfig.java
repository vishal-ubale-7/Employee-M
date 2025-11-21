package emp.com.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig
{

    @Bean
    public OpenAPI employeeManagementOpenAPI()
    {

        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management System API")
                        .description("This API provides professional CRUD operations for employee management." + "\nBuilt with Spring Boot, MySQL, Swagger, and Postman.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Vishal Ubale")
                                .email("support@gangmen.com")
                                .url("https://www.gangmentechnologies.com")
                        )
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")
                        )
                )
                .servers(List.of(
                        new Server().url("http://localhost:8787").description("Local Server"),
                        new Server().url("https://api.gangmen.com").description("Production Server")
                ))
                .components(new Components());
    }
}
