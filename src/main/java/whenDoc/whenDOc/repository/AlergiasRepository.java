package whenDoc.whenDOc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Alergias;


@Repository
public interface AlergiasRepository extends JpaRepository<Alergias, String> {

}
