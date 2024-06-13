package io.getint.recruitment_task.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "atlassian")
@Data
public class PropertiesConfig {
    private String userName;
    private String apiKey;
    private String url;
}
