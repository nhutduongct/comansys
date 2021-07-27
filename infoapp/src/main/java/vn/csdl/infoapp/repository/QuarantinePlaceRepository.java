package vn.csdl.infoapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.infoapp.domain.QuarantinePlace;

@Repository
public interface QuarantinePlaceRepository extends JpaRepository<QuarantinePlace, Long> {

    Page<QuarantinePlace> findAllBy(Pageable pageable);
}
