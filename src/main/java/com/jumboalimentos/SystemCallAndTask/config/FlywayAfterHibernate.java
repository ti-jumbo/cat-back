package com.jumboalimentos.SystemCallAndTask.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlywayAfterHibernate {
    // Criar manualmente o bean do Flyway
    @Bean
    public Flyway flyway() {
        return Flyway.configure()
                .dataSource(
                        "jdbc:mysql://localhost:3306/call_dev_v1_1?useSSL=false&serverTimezone=UTC",
                        "root",
                        "masterkey"
                )
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();
    }
    @Bean
    public ApplicationRunner runFlywayAfterHibernate(Flyway flyway) {
        return args -> {
            flyway.migrate();
            System.out.println("✅ Migrações Flyway executadas após o Hibernate.");
        };
    }
}