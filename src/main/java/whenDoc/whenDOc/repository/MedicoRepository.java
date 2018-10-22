package whenDoc.whenDOc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
	
}
