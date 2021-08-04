package vn.csdl.infoapp.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class PersonDTO {
    Long id;

    String personId;

    Short idType;

    String name;

    String phone;

    String address;

    Short yearOfBirth;

    WardDTO ward;

    @JsonIgnoreProperties(value = "person")
    List<InfectionDTO> infections;

    @JsonIgnoreProperties(value = "person")
    List<QuarantineDTO> quarantines;
}
