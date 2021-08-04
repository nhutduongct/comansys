package vn.csdl.infoapp.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import vn.csdl.infoapp.domain.Quarantine;
import vn.csdl.infoapp.service.dto.QuarantineDTO;

@Mapper
public interface QuarantineMapper {
    QuarantineMapper INSTANCE = Mappers.getMapper(QuarantineMapper.class);

    Quarantine dtoToEntity(QuarantineDTO dto);

    QuarantineDTO entityToDTO(Quarantine entity);
}
