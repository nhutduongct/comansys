package vn.csdl.infoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.infoapp.domain.Ward;

@Repository
public interface WardRepository extends JpaRepository<Ward, Integer> {
}
