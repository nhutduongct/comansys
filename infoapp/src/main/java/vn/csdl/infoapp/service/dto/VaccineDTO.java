package vn.csdl.infoapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class VaccineDTO {

    Long id;

    String name;
    //    nha san xuat
    String manufactures;
    // so lieu
    Short numberOfInjections;
    // hieu luc
    Short efficiency;

    String note;

}
