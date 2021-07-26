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
import vn.csdl.infoapp.domain.Person;
import vn.csdl.infoapp.domain.VaccineInjection;
import vn.csdl.infoapp.service.VaccineInjectionService;
import vn.csdl.infoapp.service.dto.PersonDTO;
import vn.csdl.infoapp.service.dto.VaccineInjectionDTO;
import vn.csdl.infoapp.service.mapper.VaccineInjectionMapper;

@Api(value = "Quản lý tiêm vaccine")
@RestController
@RequestMapping("/api")
public class VaccineInjectionResource {
    VaccineInjectionService vaccineInjectionService;

    VaccineInjectionMapper mapper = VaccineInjectionMapper.INSTANCE;

    @GetMapping("/vaccine-injection")
    public ResponseEntity<Page<VaccineInjectionDTO>> getAllVaccineInjection(Pageable pageable) {
        Page<VaccineInjection> page = vaccineInjectionService.findAllVaccineInjection(pageable);
        return new ResponseEntity<>(page.map(mapper::entityToDTO), HttpStatus.OK);
    }

    @GetMapping("/vaccine-injection/{id}")
    public ResponseEntity<VaccineInjectionDTO> getVaccineInjection(
        @ApiParam(value = "Mã ", required = true)
        @PathVariable Long id
    ) {
        return ResponseUtil.wrapOrNotFound(vaccineInjectionService.findVaccineInjectionById(id).map(mapper::entityToDTO));
    }

    @PostMapping("/vaccine-injection")
    public ResponseEntity<VaccineInjectionDTO> createVaccineInjection(
        @ApiParam(value = "VaccineInjectionDTO chứa thông tin của đối tượng", required = true)
        @RequestBody VaccineInjectionDTO dto
    ) {
        VaccineInjection entity = mapper.dtoToEntity(dto);

        entity = vaccineInjectionService.updateVaccineInjection(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @PutMapping("/vaccine-injection/{id}")
    public ResponseEntity<VaccineInjectionDTO> updateVaccineInjection(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id,
        @ApiParam(value = "VaccineInjectionDTO chứa thông tin của đối tượng", required = true)
        @RequestBody VaccineInjectionDTO dto
    ) {
        dto.setId(id);

        VaccineInjection entity = mapper.dtoToEntity(dto);
        entity = vaccineInjectionService.updateVaccineInjection(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Xóa đối tượng")
    @DeleteMapping("/vaccine-injection/{id}")
    public void deleteVaccineInjection(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id
    ) {
        vaccineInjectionService.deleteVaccineInjection(id);
    }
}
