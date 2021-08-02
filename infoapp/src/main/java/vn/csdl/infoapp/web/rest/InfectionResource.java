package vn.csdl.infoapp.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.ResponseUtil;
import vn.csdl.infoapp.domain.Infection;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.repository.InfectionRepository;
import vn.csdl.infoapp.repository.PersonRepository;
import vn.csdl.infoapp.service.InfectionService;
import vn.csdl.infoapp.service.PersonService;
import vn.csdl.infoapp.service.dto.InfectionDTO;
import vn.csdl.infoapp.service.dto.PersonDTO;
import vn.csdl.infoapp.service.mapper.InfectionMapper;
import vn.csdl.infoapp.service.mapper.PersonMapper;


@Api(value = "Quản lý lần nhiễm/nghi nhiễm")
@RestController
@RequestMapping("/api")
public class InfectionResource {

    InfectionRepository repository;
    InfectionService service;

    InfectionMapper mapper = InfectionMapper.INSTANCE;

    public InfectionResource(InfectionRepository repository, InfectionService service) {
        this.repository = repository;
        this.service = service;
    }

    @ApiOperation(value = "Lấy danh sách lần nhiễm (phân trang)")
    @GetMapping("/infection")
    public ResponseEntity<Page<InfectionDTO>> getAllInfection(Pageable pageable) {
        Page<Infection> page = repository.findAllBy(pageable);
        return new ResponseEntity<>(page.map(mapper::entityToDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Lấy thông tin của một lần nhiễm")
    @GetMapping("/infection/{id}")
    public ResponseEntity<InfectionDTO> getInfection(
        @ApiParam(value = "Mã ", required = true)
        @PathVariable Long id
    ) {
        return ResponseUtil.wrapOrNotFound(repository.findById(id).map(mapper::entityToDTO));
    }

    @ApiOperation(value = "Thêm một lần nhiễm mới")
    @PostMapping("/infection")
    public ResponseEntity<InfectionDTO> createInfection(
        @ApiParam(value = "InfectionDTO chứa thông tin của lần nhiễm", required = true)
        @RequestBody InfectionDTO dto
    ) {
        Infection entity = service.save(dto);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Cập nhật thông tin cho một lần nhiễm")
    @PutMapping("/infection/{id}")
    public ResponseEntity<InfectionDTO> updateInfection(
        @ApiParam(value = "Mã lần nhiễm", required = true)
        @PathVariable Long id,
        @ApiParam(value = "InfectionDTO chứa thông tin của lần nhiễm", required = true)
        @RequestBody InfectionDTO dto
    ) {
        dto.setId(id);

        Infection entity = mapper.dtoToEntity(dto);
        entity = repository.save(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Xóa lần nhiễm")
    @DeleteMapping("/infection/{id}")
    public void deleteInfection(
        @ApiParam(value = "Mã lần nhiễm", required = true)
        @PathVariable Long id
    ) {
        repository.deleteById(id);
    }}
