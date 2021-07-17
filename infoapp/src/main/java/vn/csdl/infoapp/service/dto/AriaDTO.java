package vn.csdl.infoapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AriaDTO {
    Integer ariaCode;

    String ariaName;

    DistrictDTO district;
}
