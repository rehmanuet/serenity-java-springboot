package com.lab.tas.configuration;

import com.lab.tas.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

import static com.lab.tas.models.JsonUtils.jsonToMap;

@Configuration
public class SpringConfiguration {

    @Bean
    public Map<String, User> users() {
        try {
            String usersJson = Files.readString(Path.of(Paths.get(Objects.requireNonNull(getClass().getResource("/user.json")).toURI()).toString()));
            return jsonToMap(usersJson, User.class);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Failed to read users configuration", e);
        }
    }
}
