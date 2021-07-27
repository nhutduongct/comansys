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
import vn.csdl.infoapp.domain.QuarantinePlace;
import vn.csdl.infoapp.repository.QuarantinePlaceRepository;
import vn.csdl.infoapp.service.QuarantinePlaceService;
import vn.csdl.infoapp.service.dto.QuarantinePlaceDTO;
import vn.csdl.infoapp.service.mapper.QuarantinePlaceMapper;

@Api(value = "Quản lý nơi cách ly")
@RestController
@RequestMapping("/api")
public class QuarantinePlaceResource {
    QuarantinePlaceRepository repository;
    QuarantinePlaceService service;

    QuarantinePlaceMapper mapper = QuarantinePlaceMapper.INSTANCE;

    public QuarantinePlaceResource(QuarantinePlaceRepository repository, QuarantinePlaceService service) {
        this.repository = repository;
        this.service = service;
    }

    @ApiOperation(value = "Lấy danh sách nơi cách ly")
    @GetMapping("/quarantineplace")
    public ResponseEntity<Page<QuarantinePlaceDTO>> getAllQuarantinePlace(Pageable pageable) {
        Page<QuarantinePlace> page = repository.findAllBy(pageable);
        return new ResponseEntity<>(page.map(mapper::entityToDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Lấy thông tin của một đối tượng")
    @GetMapping("/quarantineplace/{id}")
    public ResponseEntity<QuarantinePlaceDTO> getQuarantinePlace(
        @ApiParam(value = "Mã ", required = true)
        @PathVariable Long id
    ) {
        return ResponseUtil.wrapOrNotFound(repository.findById(id).map(mapper::entityToDTO));
    }

    @ApiOperation(value = "Thêm một đối tượng mới")
    @PostMapping("/quarantineplace")
    public ResponseEntity<QuarantinePlaceDTO> createQuarantinePlace(
        @ApiParam(value = "QuarantinePlaceDTO chứa thông tin của đối tượng", required = true)
        @RequestBody QuarantinePlaceDTO dto
    ) {
        QuarantinePlace entity = service.save(dto);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Cập nhật thông tin cho một đối tượng")
    @PutMapping("/quarantineplace/{id}")
    public ResponseEntity<QuarantinePlaceDTO> updateQuarantinePlace(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id,
        @ApiParam(value = "QuarantinePlaceDTO chứa thông tin của đối tượng", required = true)
        @RequestBody QuarantinePlaceDTO dto
    ) {
        dto.setId(id);

        QuarantinePlace entity = mapper.dtoToEntity(dto);
        entity = repository.save(entity);

        return ResponseEntity.ok(mapper.entityToDTO(entity));
    }

    @ApiOperation(value = "Xóa đối tượng")
    @DeleteMapping("/quarantineplace/{id}")
    public void deleteQuarantinePlace(
        @ApiParam(value = "Mã đối tượng", required = true)
        @PathVariable Long id
    ) {
        repository.deleteById(id);
    }
}
