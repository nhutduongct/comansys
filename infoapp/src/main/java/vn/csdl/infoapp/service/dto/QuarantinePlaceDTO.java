package vn.csdl.infoapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.csdl.infoapp.domain.Aria;

@Getter
@Setter
@NoArgsConstructor
public class QuarantinePlaceDTO {
    Long id;
    String name;
    String phone;
    String address;
    Aria aria;
}
