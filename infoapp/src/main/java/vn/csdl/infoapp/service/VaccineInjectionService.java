package vn.csdl.infoapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.csdl.infoapp.domain.VaccineInjection;

import java.util.List;
import java.util.Optional;

public interface VaccineInjectionService {

    Page<VaccineInjection> findAllVaccineInjection(Pageable pageable);

    Optional<VaccineInjection> findVaccineInjectionById(Long id);

    List<VaccineInjection> findVaccineInjectionByPersonId(Long id);

    List<VaccineInjection> findVaccineInjectionByVaccineId(Long id);

    VaccineInjection updateVaccineInjection(VaccineInjection vaccineInjection);

    void deleteVaccineInjection(Long id);

}
