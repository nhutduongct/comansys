package vn.csdl.infoapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.csdl.infoapp.domain.QuarantinePlace;
import vn.csdl.infoapp.service.dto.QuarantinePlaceDTO;

@Mapper
public interface QuarantinePlaceMapper {
    QuarantinePlaceMapper INSTANCE = Mappers.getMapper(QuarantinePlaceMapper.class);

    QuarantinePlace dtoToEntity(QuarantinePlaceDTO dto);
    QuarantinePlaceDTO entityToDTO(QuarantinePlace entity);
}
