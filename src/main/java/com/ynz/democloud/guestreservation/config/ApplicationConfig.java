package com.ynz.democloud.guestreservation.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig extends WebMvcConfigurationSupport {
    private final StringToDateConverter stringToDateConverter;

    @Override
    protected void addFormatters(FormatterRegistry registry) {
        registry.addConverter(stringToDateConverter);
    }

}
