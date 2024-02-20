package ru.itmo.etl.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.itmo.etl.cassandra.extract.repository")
public class EtlCassandraApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtlCassandraApplication.class, args);
    }
}
