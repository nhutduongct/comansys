package vn.csdl.infoapp.service;

import org.springframework.stereotype.Service;
import vn.csdl.infoapp.client.TrackerFeignClient;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.repository.PersonRepository;
import vn.csdl.infoapp.service.dto.PersonDTO;
import vn.csdl.infoapp.service.mapper.PersonMapper;

@Service
public class PersonService {

    PersonRepository repository;
    TrackerFeignClient trackerFeignClient;

    PersonMapper mapper = PersonMapper.INSTANCE;

    public PersonService(PersonRepository repository, TrackerFeignClient trackerFeignClient) {
        this.repository = repository;
        this.trackerFeignClient = trackerFeignClient;
    }

    public Person save(PersonDTO dto){
        Person entity = mapper.dtoToEntity(dto);
        entity = repository.save(entity);

        PersonDTO resultDTO = mapper.entityToDTO(entity);
        trackerFeignClient.createOrUpdatePerson(resultDTO);

        entity.setSync((short)1);
        entity = repository.save(entity);
        return entity;
    }
}
