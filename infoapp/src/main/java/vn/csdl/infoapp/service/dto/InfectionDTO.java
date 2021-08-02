package vn.csdl.infoapp.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.csdl.infoapp.domain.Person;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class InfectionDTO {
    Long id;

    PersonDTO person;

    Short fLevel;

    LocalDateTime startTime;

    LocalDateTime endTime;

    String treatmentResult;

    PersonDTO infectedFromPerson;
}
