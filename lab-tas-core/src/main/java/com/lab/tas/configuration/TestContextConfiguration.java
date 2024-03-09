package com.lab.tas.configuration;

import com.lab.tas.context.ScenarioContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackageClasses = ScenarioContext.class)
@EnableAutoConfiguration
@Import(value = {SpringConfiguration.class})
public class TestContextConfiguration {
}