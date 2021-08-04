package vn.csdl.trackerapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.time.LocalDateTime;

@Getter
@Setter
@RelationshipProperties
public class Meet {
    @Id
    @GeneratedValue
    Long id;

    LocalDateTime startTime;

    LocalDateTime endTime;

    @TargetNode
    private final Person person;

    public Meet(LocalDateTime startTime, LocalDateTime endTime, Person person) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.person = person;
    }
}
