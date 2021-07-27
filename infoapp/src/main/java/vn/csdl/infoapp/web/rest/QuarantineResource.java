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
import vn.csdl.infoapp.domain.Quarantine;
import vn.csdl.infoapp.repository.QuarantineRepository;
import vn.csdl.infoapp.service.QuarantineService;
import vn.csdl.infoapp.service.dto.QuarantineDTO;
import vn.csdl.infoapp.service.mapper.QuarantineMapper;

@Api(value = "Quản lý cách ly")
@RestController
@RequestMapping("/api")
public class QuarantineResource {
    QuarantineRepository repository;
    QuarantineService service;

    QuarantineMapper mapper = QuarantineMapper.INSTANCE;

    public QuarantineResource(QuarantineRepository repository, QuarantineService service) {
        this.repository = repository;
        this.service = service;
    }

    @ApiOperation(value = "Lấy danh sách bệnh nhân cách ly (theo địa điểm, ngày bắt đầu, ngày kết thúc")
    @GetMapping("/quarantine")
    public ResponseEntity<Page<QuarantineDTO>> getAllQuarantine(Pageable pageable) {
        Page<Quarantine> page = repository.findAllBy(pageable);
        return new ResponseEntity<>(page.map(mapper::entityToDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Lấy thông tin của một đối tượng")
    @GetMapping("/quarantine/{id}")
    public ResponseEntity<QuarantineDTO> getQuarantine(
        @ApiParam(value = "Mã ", required = true)
        @PathVariable Long id
    ) {
        return ResponseUtil.wrapOrNotFound(repository.findById(id).map(mapper::entityToDTO));
    }

    @ApiOperation(value = "Thêm một đối tượng mới")
    @PostMapping("/quarantine")
    public ResponseEntity<QuarantineDTO> createQuarantine(
        @ApiParam(value = "QuarantineDTO chứa thông tin của đối tượng", required = true)
        @RequestBody QuarantineDTO dto
    ) {
        Quarantine entity = service.save(dto);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Cập nhật thông tin cho một đối tượng")
    @PutMapping("/quarantine/{id}")
    public ResponseEntity<QuarantineDTO> updateQuarantine(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id,
        @ApiParam(value = "QuarantineDTO chứa thông tin của đối tượng", required = true)
        @RequestBody QuarantineDTO dto
    ) {
        dto.setId(id);

        Quarantine entity = mapper.dtoToEntity(dto);
        entity = repository.save(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Xóa đối tượng")
    @DeleteMapping("/quarantine/{id}")
    public void deleteQuarantine(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id
    ) {
        repository.deleteById(id);
    }
}
