package vn.csdl.infoapp.service;

import org.springframework.stereotype.Service;
import vn.csdl.infoapp.client.TrackerFeignClient;
import vn.csdl.infoapp.domain.Infection;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.repository.InfectionRepository;
import vn.csdl.infoapp.repository.PersonRepository;
import vn.csdl.infoapp.service.dto.InfectionDTO;
import vn.csdl.infoapp.service.dto.PersonDTO;
import vn.csdl.infoapp.service.mapper.InfectionMapper;
import vn.csdl.infoapp.service.mapper.PersonMapper;

@Service
public class InfectionService {

    InfectionRepository repository;

    InfectionMapper mapper = InfectionMapper.INSTANCE;

    public InfectionService(InfectionRepository repository) {
        this.repository = repository;
    }

    public Infection save(InfectionDTO dto){
        Infection entity = mapper.dtoToEntity(dto);

        entity = repository.save(entity);
        return entity;
    }
}
