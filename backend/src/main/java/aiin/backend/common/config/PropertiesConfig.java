package aiin.backend.common.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import aiin.backend.auth.properties.CorsProperties;
import aiin.backend.auth.properties.JwtProperties;
import aiin.backend.auth.properties.SecurityProperties;

@Configuration
@EnableConfigurationProperties(value = {
	JwtProperties.class,
	SecurityProperties.class,
	CorsProperties.class
})
public class PropertiesConfig {
}
