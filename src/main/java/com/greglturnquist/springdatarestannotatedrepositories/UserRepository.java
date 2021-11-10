package com.greglturnquist.springdatarestannotatedrepositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends CassandraRepository<User, String> {

	@AllowFiltering
	Optional<User> findByName(String name);
}
