package vn.csdl.infoapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.infoapp.domain.Vaccine;
import vn.csdl.infoapp.domain.VaccineInjection;

import java.util.List;

@Repository
public interface VaccineInjectionRespository extends JpaRepository<VaccineInjection, Long> {
   List<VaccineInjection> findByVaccineId(Long id);

    List<VaccineInjection> findByPerson(Long id);


}
