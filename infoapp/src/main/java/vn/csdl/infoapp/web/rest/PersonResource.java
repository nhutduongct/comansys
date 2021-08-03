package vn.csdl.infoapp.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import tech.jhipster.web.util.ResponseUtil;
import vn.csdl.infoapp.client.TrackerFeignClient;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.repository.PersonRepository;
import vn.csdl.infoapp.security.AuthoritiesConstants;
import vn.csdl.infoapp.service.PersonService;
import vn.csdl.infoapp.service.dto.PersonDTO;
import vn.csdl.infoapp.service.mapper.PersonMapper;

import java.util.List;
import java.util.stream.Collectors;


@Api(value = "Quản lý đối tượng nhiễm/nghi nhiễm")
@RestController
@RequestMapping("/api")
public class PersonResource {

    PersonRepository repository;
    PersonService service;

    PersonMapper mapper = PersonMapper.INSTANCE;

    public PersonResource(PersonRepository repository, PersonService service) {
        this.repository = repository;
        this.service = service;
    }

    @ApiOperation(value = "Lấy danh sách đối tượng (phân trang)")
    @GetMapping("/person")
    public ResponseEntity<Page<PersonDTO>> getAllPerson(Pageable pageable) {
        Page<Person> page = repository.findAllBy(pageable);
        return new ResponseEntity<>(page.map(mapper::entityToDTO), HttpStatus.OK);
    }

    @ApiIgnore
    @ApiOperation(value = "Lấy danh sách đối tượng")
    @GetMapping("/person-by-id-list")
    public List<PersonDTO> getAllPersonByIdList(
        @RequestParam(value = "ids") List<Long> ids
    ) {
        List<Person> list = repository.findAllById(ids);
        return list.stream().map(mapper::entityToDTO).collect(Collectors.toList());
    }

    @ApiOperation(value = "Lấy thông tin của một đối tượng")
    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDTO> getPerson(
        @ApiParam(value = "Mã ", required = true)
        @PathVariable Long id
    ) {
        return ResponseUtil.wrapOrNotFound(repository.findById(id).map(mapper::entityToDTO));
    }

    @ApiOperation(value = "Thêm một đối tượng mới")
    @PostMapping("/person")
    public ResponseEntity<PersonDTO> createPerson(
        @ApiParam(value = "PersonDTO chứa thông tin của đối tượng", required = true)
        @RequestBody PersonDTO dto
    ) {
        Person entity = service.save(dto);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Cập nhật thông tin cho một đối tượng")
    @PutMapping("/person/{id}")
    public ResponseEntity<PersonDTO> updatePerson(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id,
        @ApiParam(value = "PersonDTO chứa thông tin của đối tượng", required = true)
        @RequestBody PersonDTO dto
    ) {
        dto.setId(id);

        Person entity = mapper.dtoToEntity(dto);
        entity = repository.save(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Xóa đối tượng")
    @DeleteMapping("/person/{id}")
    public void deletePerson(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id
    ) {
        repository.deleteById(id);
    }}
