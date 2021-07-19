package vn.csdl.trackerapp.web.rest;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import vn.csdl.trackerapp.domain.Meet;
import vn.csdl.trackerapp.domain.Person;
import vn.csdl.trackerapp.repository.PersonRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonResource {

    PersonRepository repository;

    public PersonResource(PersonRepository repository) {
        this.repository = repository;
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
        @RequestParam(value = "startTime") LocalDateTime startTime,
        @RequestParam(value = "endTime") LocalDateTime endTime
    ) throws Exception {
        Assert.isTrue(!id.equals(meetPersonId), "meetPersonId must be different with id");

        Person person = repository.findById(id).orElseThrow(() -> new Exception("person is not exists"));

        Person meetPerson = repository.findById(meetPersonId).orElseThrow(() -> new Exception("meet person is not exists"));

        Meet meet = new Meet(startTime, endTime, meetPerson);
        person.getMeets().add(meet);
        repository.save(person);
    }

    @GetMapping("/person/{id}/track")
    public List<Person> trackMeet(
        @PathVariable(value = "id") Long id,
        @RequestParam(value = "depth", required = false) Integer depth
    ) {
        if (depth == null)
            depth = 3;

        return repository.findPeopleByRootNodeAndDepth(id, depth);
    }
}
