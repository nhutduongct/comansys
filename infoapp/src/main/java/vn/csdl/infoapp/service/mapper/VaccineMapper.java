package vn.csdl.infoapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.csdl.infoapp.domain.Vaccine;
import vn.csdl.infoapp.service.dto.VaccineDTO;

@Mapper
public interface VaccineMapper {
    VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

    Vaccine dtoToEntity(VaccineDTO dto);

    VaccineDTO entityToDTO(Vaccine entity);
}
