package vn.csdl.infoapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
}
