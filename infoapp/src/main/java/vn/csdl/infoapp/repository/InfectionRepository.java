package vn.csdl.infoapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.infoapp.domain.Infection;
import vn.csdl.infoapp.domain.Person;

@Repository
public interface InfectionRepository extends JpaRepository<Infection, Long> {

    Page<Infection> findAllBy(Pageable pageable);
}
