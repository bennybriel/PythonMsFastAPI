package com.PostGraduateLog.PostGraduateLog.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info= @Info(title="LAUTECH Admission Portal Central Dashboard", version="1"))
@SecurityScheme(name="jwtBearerAuth",bearerFormat = "JWT", scheme = "bearer", type = SecuritySchemeType.HTTP)

public class SwaggerConfig {

}
