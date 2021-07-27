package vn.csdl.infoapp.service;

import org.springframework.stereotype.Service;
import vn.csdl.infoapp.client.TrackerFeignClient;
import vn.csdl.infoapp.domain.Quarantine;
import vn.csdl.infoapp.repository.QuarantineRepository;
import vn.csdl.infoapp.service.dto.QuarantineDTO;
import vn.csdl.infoapp.service.mapper.QuarantineMapper;

@Service
public class QuarantineService {

    QuarantineRepository repository;
    TrackerFeignClient trackerFeignClient;

    QuarantineMapper mapper = QuarantineMapper.INSTANCE;

    public QuarantineService(QuarantineRepository repository, TrackerFeignClient trackerFeignClient) {
        this.repository = repository;
        this.trackerFeignClient = trackerFeignClient;
    }

    public Quarantine save(QuarantineDTO dto){
        Quarantine entity = mapper.dtoToEntity(dto);
        entity = repository.save(entity);

        QuarantineDTO resultDTO = mapper.entityToDTO(entity);

        entity = repository.save(entity);
        return entity;
    }
}
