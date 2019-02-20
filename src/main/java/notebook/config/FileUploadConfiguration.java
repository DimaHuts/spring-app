package notebook.config;

import notebook.property.FileStorageProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class FileUploadConfiguration {
}
