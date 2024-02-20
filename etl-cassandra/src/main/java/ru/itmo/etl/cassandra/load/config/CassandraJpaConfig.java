package ru.itmo.etl.cassandra.load.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "ru.itmo.etl.cassandra.load.repository")
public class CassandraJpaConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "diploma";
    }
}
