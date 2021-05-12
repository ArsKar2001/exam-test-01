package com.karmanchik.exam.clientapi.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com/karmanchik/exam/clientapi/entity")
@EnableJpaRepositories(basePackages = "com.karmanchik.exam.clientapi.daos")
public class ClientConfig {
}
