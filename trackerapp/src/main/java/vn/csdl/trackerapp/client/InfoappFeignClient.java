package vn.csdl.trackerapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.csdl.trackerapp.service.dto.PersonDTO;

import java.util.List;

@FeignClient(name = "infoapp", configuration = OAuth2InterceptedFeignConfiguration.class)
public interface InfoappFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/person/{id}", consumes = "application/json")
    ResponseEntity<PersonDTO> getPerson(@PathVariable(value = "id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/person-by-id-list", consumes = "application/json")
    List<PersonDTO> getAllPersonByIdList(@RequestParam(value = "ids") List<Long> ids);
}
