package starter.stepdefinitions;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"DriverManager"})
@EnableAutoConfiguration
public class TestContextConfiguration {
}