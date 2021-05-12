package com.karmanchik.exam.javafxapp.config;

import com.karmanchik.exam.clientapi.config.ClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {ClientConfig.class})
public class AppConfig {
}
