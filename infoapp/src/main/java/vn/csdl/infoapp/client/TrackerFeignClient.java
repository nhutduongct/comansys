package vn.csdl.infoapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vn.csdl.infoapp.service.dto.PersonDTO;

@FeignClient(name = "trackerapp", configuration = OAuth2InterceptedFeignConfiguration.class)
public interface TrackerFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/person", consumes = "application/json")
    void createOrUpdatePerson(@RequestBody PersonDTO person);

}
