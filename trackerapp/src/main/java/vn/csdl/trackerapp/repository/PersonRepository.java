package vn.csdl.trackerapp.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.csdl.trackerapp.domain.Person;

import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query(value = "MATCH data=(a:Person)-[r:MEET*1..3]-(b:Person) WHERE a.id=$id RETURN data")
    List<Person> findPeopleByRootNodeAndDepth(@Param(value = "id") Long id, @Param(value = "depth") Integer depth);
}
