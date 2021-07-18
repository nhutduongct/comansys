package vn.csdl.trackerapp.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.trackerapp.domain.Person;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {
}
