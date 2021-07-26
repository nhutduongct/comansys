package vn.csdl.infoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.csdl.infoapp.domain.Vaccine;
import vn.csdl.infoapp.repository.VaccineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineServiceImpl implements VaccineService {

    private final VaccineRepository vaccineRepository;

    @Autowired
    public VaccineServiceImpl(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public List<Vaccine> findVaccine() {
        return  vaccineRepository.findAll();
    }

    @Override
    public Vaccine updateVaccine(Vaccine vaccine) {
        return vaccineRepository.save(vaccine);
    }

    @Override
    public Optional<Vaccine> findVaccineById(Long id) {
        return vaccineRepository.findById(id);
    }

    @Override
    public void deleVaccine(Long id) {
        vaccineRepository.deleteById(id);
    }

    @Override
    public Long checkExits(Long id) {
        return null;
    }
}
