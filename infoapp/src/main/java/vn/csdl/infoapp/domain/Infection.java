package vn.csdl.infoapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "infection")
public class Infection {
    @Id
    @GeneratedValue
    Long id;

    @JsonIgnoreProperties(value = "infections")
    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;

    @NotNull
    @Min(value = 0)
    Short fLevel;

    @NotNull
    LocalDateTime startTime;

    LocalDateTime endTime;

    String treatmentResult;

    @JsonIgnoreProperties(value = "infections")
    @ManyToOne
    @JoinColumn(name = "infected_from_person")
    Person infectedFromPerson;



}
