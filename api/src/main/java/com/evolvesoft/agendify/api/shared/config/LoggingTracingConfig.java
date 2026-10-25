package com.evolvesoft.agendify.api.shared.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.opentelemetry.exporter.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.trace.export.SpanExporter;

@Configuration
@Profile("local")
public class LoggingTracingConfig {

    @Bean
    SpanExporter loggingSpanExporter() {
        return LoggingSpanExporter.create();
    }
}