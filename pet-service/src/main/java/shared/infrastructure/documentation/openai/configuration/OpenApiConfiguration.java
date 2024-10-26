package shared.infrastructure.documentation.openai.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI profileServicePlatformOpenApi(){
        return new OpenAPI()
                .info(new Info().title("Pet Service API")
                        .description(
                                "Pet Service REST API Documentation")
                        .version("v1.0.0"));
    }
}