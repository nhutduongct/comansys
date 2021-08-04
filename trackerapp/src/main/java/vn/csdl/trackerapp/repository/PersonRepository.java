package vn.csdl.trackerapp.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.csdl.trackerapp.domain.Person;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query(value = "MATCH data=(f0:Person)-[r:MEET*1]-(fn:Person) WHERE f0.id = $id AND all(rn IN r WHERE rn.startTime >= $fromTime) RETURN fn")
    List<Person> findF1PeopleByRootNode(@Param(value = "id") Long id, @Param(value = "fromTime") LocalDateTime fromTime);

    @Query(value = "match data=(f0:Person)-[r:MEET*2]-(fn:Person) WHERE f0.id = $id AND all(rn IN r WHERE rn.startTime >= $fromTime) RETURN fn")
    List<Person> findF2PeopleByRootNode(@Param(value = "id") Long id, @Param(value = "fromTime") LocalDateTime fromTime);

    @Query(value = "match data=(f0:Person)-[r:MEET*3]-(fn:Person) WHERE f0.id = $id AND all(rn IN r WHERE rn.startTime >= $fromTime) RETURN fn")
    List<Person> findF3PeopleByRootNode(@Param(value = "id") Long id, @Param(value = "fromTime") LocalDateTime fromTime);

    @Query(value = "match data=(f0:Person)-[r:MEET*4]-(fn:Person) WHERE f0.id = $id AND all(rn IN r WHERE rn.startTime >= $fromTime) RETURN fn")
    List<Person> findF4PeopleByRootNode(@Param(value = "id") Long id, @Param(value = "fromTime") LocalDateTime fromTime);
}
