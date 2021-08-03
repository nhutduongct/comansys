package vn.csdl.trackerapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.INCOMING;

@Getter
@Setter
@NoArgsConstructor
@Node
public class Person {
    @Id
    Long id;

    String name;

    @Relationship(type = "MEET", direction = INCOMING)
    @JsonIgnoreProperties(value = "person")
    private List<Meet> meets = new ArrayList<>();
}
