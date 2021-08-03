package vn.csdl.trackerapp.service;

import org.springframework.stereotype.Service;
import vn.csdl.trackerapp.client.InfoappFeignClient;
import vn.csdl.trackerapp.client.InfoappTokenRelayFeignClient;
import vn.csdl.trackerapp.domain.Person;
import vn.csdl.trackerapp.repository.PersonRepository;
import vn.csdl.trackerapp.service.dto.PersonDTO;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PersonService {
    PersonRepository repository;

    InfoappFeignClient infoappFeignClient;

    InfoappTokenRelayFeignClient infoappTokenRelayFeignClient;

    public PersonService(PersonRepository repository, InfoappFeignClient infoappFeignClient, InfoappTokenRelayFeignClient infoappTokenRelayFeignClient) {
        this.repository = repository;
        this.infoappFeignClient = infoappFeignClient;
        this.infoappTokenRelayFeignClient = infoappTokenRelayFeignClient;
    }

    public Map<String, List<PersonDTO>> track(Long idOfF0, LocalDateTime fromTime){
        Optional<Person> f0 = repository.findById(idOfF0);
        if (f0.isEmpty())
            return null;

        Map<String, List<PersonDTO>> map = new HashMap<>();

        List<PersonDTO> f0List = new ArrayList<>();
        f0List.add(infoappFeignClient.getPerson(f0.get().getId()).getBody());
        map.put("f0", f0List);

        List<PersonDTO> f1DTOList = infoappFeignClient
            .getAllPersonByIdList(
                repository.findF1PeopleByRootNode(idOfF0, fromTime, 1)
                .stream()
                .map(Person::getId)
                .collect(Collectors.toList())
            );
        map.put("f1", f1DTOList);

        List<PersonDTO> f2DTOList = infoappFeignClient
            .getAllPersonByIdList(
                repository.findF2PeopleByRootNode(idOfF0, fromTime)
                    .stream()
                    .map(Person::getId)
                    .collect(Collectors.toList())
            );
        map.put("f2", f2DTOList);

        List<PersonDTO> f3DTOList = infoappFeignClient
            .getAllPersonByIdList(
                repository.findF3PeopleByRootNode(idOfF0, fromTime)
                    .stream()
                    .map(Person::getId)
                    .collect(Collectors.toList())
            );
        map.put("f3", f3DTOList);

        List<PersonDTO> f4DTOList = infoappFeignClient
            .getAllPersonByIdList(
                repository.findF4PeopleByRootNode(idOfF0, fromTime)
                    .stream()
                    .map(Person::getId)
                    .collect(Collectors.toList())
            );
        map.put("f4", f4DTOList);

        return map;
    }
}
