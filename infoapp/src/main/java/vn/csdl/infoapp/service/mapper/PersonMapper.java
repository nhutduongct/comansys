package vn.csdl.infoapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.service.dto.PersonDTO;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person dtoToEntity(PersonDTO dto);
    PersonDTO entityToDTO(Person entity);
}
