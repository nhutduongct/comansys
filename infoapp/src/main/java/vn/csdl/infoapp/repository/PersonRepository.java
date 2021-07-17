package vn.csdl.infoapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.csdl.infoapp.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Page<Person> findAllBy(Pageable pageable);
}
