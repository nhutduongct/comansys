package vn.csdl.infoapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.csdl.infoapp.domain.Infection;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.service.dto.InfectionDTO;
import vn.csdl.infoapp.service.dto.PersonDTO;

@Mapper
public interface InfectionMapper {
    InfectionMapper INSTANCE = Mappers.getMapper(InfectionMapper.class);

    Infection dtoToEntity(InfectionDTO dto);
    InfectionDTO entityToDTO(Infection entity);
}
