package vn.csdl.infoapp.service;

import vn.csdl.infoapp.domain.Vaccine;

import java.util.List;
import java.util.Optional;

public interface VaccineService {

    List<Vaccine> findVaccine();

    Optional<Vaccine> findVaccineById(Long id);

    Vaccine updateVaccine(Vaccine vaccine);

    void deleVaccine(Long id);

    Long checkExits(Long id);

}
