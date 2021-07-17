package vn.csdl.infoapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DistrictDTO {
    Integer districtCode;

    String districtName;

    CityDTO city;
}
