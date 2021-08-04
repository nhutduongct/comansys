package vn.csdl.infoapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.domain.QuarantinePlace;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class QuarantineDTO {
    Long id;
    PersonDTO person;
    QuarantineDTO quarantinePlace;
    LocalDateTime startDate;
    LocalDateTime endDate;
    Short quarantineResult;
    String note;
}
