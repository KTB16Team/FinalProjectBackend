package aiin.backend.common.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import aiin.backend.common.properties.properties.CorsProperties;
import aiin.backend.common.properties.properties.JwtProperties;
import aiin.backend.common.properties.properties.SecurityProperties;

@Configuration
@EnableConfigurationProperties(value = {
	JwtProperties.class,
	SecurityProperties.class,
	CorsProperties.class
})
public class PropertiesConfig {
}
