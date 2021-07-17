package vn.csdl.infoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.infoapp.domain.Aria;

@Repository
public interface AriaRepository extends JpaRepository<Aria, Integer> {
}
