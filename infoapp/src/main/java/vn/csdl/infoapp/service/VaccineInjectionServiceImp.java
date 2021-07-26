package vn.csdl.infoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.csdl.infoapp.domain.VaccineInjection;
import vn.csdl.infoapp.repository.VaccineInjectionRespository;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineInjectionServiceImp implements VaccineInjectionService{

    private final VaccineInjectionRespository vaccineInjectionRespository;

    @Autowired
    public VaccineInjectionServiceImp(VaccineInjectionRespository vaccineInjectionRespository) {
        this.vaccineInjectionRespository = vaccineInjectionRespository;
    }

    @Override
    public Page<VaccineInjection> findAllVaccineInjection(Pageable pageable) {
        return vaccineInjectionRespository.findAll(pageable);
    }

    @Override
    public Optional<VaccineInjection> findVaccineInjectionById(Long id) {
        return vaccineInjectionRespository.findById(id);
    }

    @Override
    public List<VaccineInjection> findVaccineInjectionByPersonId(Long id) {
        return vaccineInjectionRespository.findByPerson(id);
    }

    @Override
    public List<VaccineInjection> findVaccineInjectionByVaccineId(Long id) {
        return vaccineInjectionRespository.findByVaccineId(id);
    }

    @Override
    public VaccineInjection updateVaccineInjection(VaccineInjection vaccineInjection) {
        return vaccineInjectionRespository.save(vaccineInjection);
    }

    @Override
    public void deleteVaccineInjection(Long id) {
        vaccineInjectionRespository.deleteById(id);
    }
}
