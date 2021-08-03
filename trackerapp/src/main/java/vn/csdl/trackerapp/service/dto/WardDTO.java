package vn.csdl.trackerapp.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WardDTO {
    Integer wardCode;

    String wardName;

    DistrictDTO district;
}
