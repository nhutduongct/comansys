package vn.csdl.infoapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.infoapp.domain.Quarantine;

@Repository
public interface QuarantineRepository extends JpaRepository<Quarantine, Long> {

    Page<Quarantine> findAllBy(Pageable pageable);
}
