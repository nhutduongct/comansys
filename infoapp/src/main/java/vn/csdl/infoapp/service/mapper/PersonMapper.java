package vn.csdl.infoapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.service.dto.PersonDTO;
import vn.csdl.infoapp.web.rest.vm.PersonVM;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person dtoToEntity(PersonDTO dto);
    PersonDTO entityToDTO(Person entity);

    PersonVM entityToVM(Person entity);
}
