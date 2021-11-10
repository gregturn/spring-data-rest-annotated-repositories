package com.greglturnquist.springdatarestannotatedrepositories;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

@SpringBootApplication
public class SpringDataRestAnnotatedRepositoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestAnnotatedRepositoriesApplication.class, args);
	}

	@Configuration(proxyBeanMethods = false)
	class CassandraConfig extends AbstractCassandraConfiguration {

		@Override
		protected String getKeyspaceName() {
			return "test";
		}

		@Override
		protected String getLocalDataCenter() {
			return "datacenter1";
		}

		@Override
		public SchemaAction getSchemaAction() {
			return SchemaAction.CREATE_IF_NOT_EXISTS;
		}

		@Override
		protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {

			return Collections.singletonList(CreateKeyspaceSpecification.createKeyspace(getKeyspaceName()) //
					.ifNotExists() //
					.withSimpleReplication(1));
		}
	}
}
