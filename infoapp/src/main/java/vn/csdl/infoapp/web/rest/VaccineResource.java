package vn.csdl.infoapp.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.ResponseUtil;
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.domain.Vaccine;
import vn.csdl.infoapp.domain.VaccineInjection;
import vn.csdl.infoapp.service.VaccineService;
import vn.csdl.infoapp.service.dto.PersonDTO;
import vn.csdl.infoapp.service.dto.VaccineDTO;
import vn.csdl.infoapp.service.dto.VaccineInjectionDTO;
import vn.csdl.infoapp.service.mapper.VaccineMapper;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "Quản lý Vaccine")
@RestController
@RequestMapping("/api")
public class VaccineResource {

    private final VaccineService vaccineService;

    @Autowired
    public VaccineResource(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    VaccineMapper mapper = VaccineMapper.INSTANCE;

    @GetMapping("/vaccine")
    public ResponseEntity<List<VaccineDTO>> getAllVaccine() {
        List<Vaccine> vaccines  = vaccineService.findVaccine();
        // Convert list vaccine sang list vaccine dto
        return new ResponseEntity<>(vaccines.stream().map(mapper::entityToDTO).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/vaccine/{id}")
    public ResponseEntity<VaccineDTO> getVaccine(
        @ApiParam(value = "Mã ", required = true)
        @PathVariable Long id
    ) {
        return ResponseUtil.wrapOrNotFound(vaccineService.findVaccineById(id).map(mapper::entityToDTO));
    }

    @PostMapping("/vaccine")
    public ResponseEntity<VaccineDTO> createVaccine(
        @ApiParam(value = "VaccineDTO chứa thông tin của đối tượng", required = true)
        @RequestBody VaccineDTO dto
    ) {
        Vaccine entity = mapper.dtoToEntity(dto);

        entity = vaccineService.updateVaccine(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @PutMapping("/vaccine/{id}")
    public ResponseEntity<VaccineDTO> updateVaccine(
        @ApiParam(value = "Mã vaccine", required = true)
        @PathVariable Long id,
        @ApiParam(value = "VaccineDTO chứa thông tin của vaccine", required = true)
        @RequestBody VaccineDTO dto
    ) {
        dto.setId(id);

        Vaccine entity = mapper.dtoToEntity(dto);
        entity = vaccineService.updateVaccine(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @DeleteMapping("/vaccine/{id}")
    public void deleteVaccine(
        @ApiParam(value = "Mã vaccine", required = true)
        @PathVariable Long id
    ) {
        vaccineService.deleVaccine(id);
    }

}
