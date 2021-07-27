package vn.csdl.infoapp.service;

import org.springframework.stereotype.Service;
import vn.csdl.infoapp.client.TrackerFeignClient;
import vn.csdl.infoapp.domain.QuarantinePlace;
import vn.csdl.infoapp.repository.QuarantinePlaceRepository;
import vn.csdl.infoapp.service.dto.QuarantinePlaceDTO;
import vn.csdl.infoapp.service.mapper.QuarantinePlaceMapper;

@Service
public class QuarantinePlaceService {

    QuarantinePlaceRepository repository;
    TrackerFeignClient trackerFeignClient;

    QuarantinePlaceMapper mapper = QuarantinePlaceMapper.INSTANCE;

    public QuarantinePlaceService(QuarantinePlaceRepository repository, TrackerFeignClient trackerFeignClient) {
        this.repository = repository;
        this.trackerFeignClient = trackerFeignClient;
    }

    public QuarantinePlace save(QuarantinePlaceDTO dto){
        QuarantinePlace entity = mapper.dtoToEntity(dto);
        entity = repository.save(entity);

        QuarantinePlaceDTO resultDTO = mapper.entityToDTO(entity);

        entity = repository.save(entity);
        return entity;
    }
}
