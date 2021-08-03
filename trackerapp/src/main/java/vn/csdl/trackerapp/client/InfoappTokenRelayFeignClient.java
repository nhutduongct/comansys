package vn.csdl.trackerapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vn.csdl.trackerapp.service.dto.PersonDTO;

import java.util.List;

@FeignClient(name = "infoapp", configuration = TokenRelayRequestInterceptor.class)
public interface InfoappTokenRelayFeignClient {
    @RequestMapping(method = RequestMethod.GET, value = "/api/person/{id}", consumes = "application/json")
    ResponseEntity<PersonDTO> getPerson(@PathVariable(value = "id") Long id);

    @RequestMapping(method = RequestMethod.GET, value = "/api/person-by-id-list", consumes = "application/json")
    List<PersonDTO> getAllPersonByIdList(@RequestParam(value = "ids") List<Long> ids);
}
