package vn.csdl.trackerapp.web.rest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import vn.csdl.trackerapp.domain.Meet;
import vn.csdl.trackerapp.domain.Person;
import vn.csdl.trackerapp.repository.PersonRepository;
import vn.csdl.trackerapp.service.PersonService;
import vn.csdl.trackerapp.service.dto.PersonDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PersonResource {

    PersonRepository repository;
    PersonService service;

    public PersonResource(PersonRepository repository, PersonService service) {
        this.repository = repository;
        this.service = service;
    }


    @PostMapping("/person")
    public void createOrUpdatePerson(
        @RequestBody Person person
    ) {
        repository.save(person);
    }

    @PostMapping("/person/{id}/meet")
    public void createOrUpdatePerson(
        @PathVariable(value = "id") Long id,
        @RequestParam(value = "meetPersonId") Long meetPersonId,
        @RequestParam(value = "startTime")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime startTime,
        @RequestParam(value = "endTime")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime endTime
    ) throws Exception {
        Assert.isTrue(!id.equals(meetPersonId), "meetPersonId must be different with id");

        Person person = repository.findById(id).orElseThrow(() -> new Exception("person is not exists"));

        Person meetPerson = repository.findById(meetPersonId).orElseThrow(() -> new Exception("meet person is not exists"));

        Meet meet = new Meet(startTime, endTime, meetPerson);
        person.getMeets().add(meet);
        repository.save(person);
    }

    @GetMapping("/person/{id}/track")
    public Map<String, List<PersonDTO>> trackMeet(
        @PathVariable(value = "id") Long id,
        @RequestParam(value = "fromTime")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        LocalDateTime fromTime
    ) {
        return service.track(id, fromTime);
    }
}
