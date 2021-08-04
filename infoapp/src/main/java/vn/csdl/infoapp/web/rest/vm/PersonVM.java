package vn.csdl.infoapp.web.rest.vm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.csdl.infoapp.service.dto.InfectionDTO;
import vn.csdl.infoapp.service.dto.QuarantineDTO;
import vn.csdl.infoapp.service.dto.WardDTO;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class PersonVM {
    Long id;

    String personId;

    Short idType;

    String name;

    String phone;

    String address;

    Short yearOfBirth;

    WardDTO ward;

    @JsonIgnoreProperties(value = "person")
    Set<InfectionDTO> infections;

    @JsonIgnoreProperties(value = "person")
    Set<QuarantineDTO> quarantines;

}
