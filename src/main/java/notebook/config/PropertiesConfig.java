package notebook.config;

import notebook.property.FileStorageProperties;
import notebook.property.JWTProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
  FileStorageProperties.class,
  JWTProperties.class
})
public class PropertiesConfig {
}
