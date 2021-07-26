package vn.csdl.infoapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.csdl.infoapp.domain.Vaccine;
import vn.csdl.infoapp.domain.VaccineInjection;
import vn.csdl.infoapp.service.dto.VaccineInjectionDTO;

@Mapper
public interface VaccineInjectionMapper {
    VaccineInjectionMapper INSTANCE = Mappers.getMapper(VaccineInjectionMapper.class);

    VaccineInjection dtoToEntity(VaccineInjectionDTO dto);

    VaccineInjectionDTO entityToDTO(VaccineInjection entity);
}
