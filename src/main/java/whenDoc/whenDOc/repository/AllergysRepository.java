package whenDoc.whenDOc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Alergia;


@Repository
public interface AllergysRepository extends JpaRepository<Alergia, String> {

}
