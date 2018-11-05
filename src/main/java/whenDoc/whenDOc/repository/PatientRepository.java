package whenDoc.whenDOc.repository;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Paciente;

@Repository
public interface PatientRepository extends JpaRepository<Paciente, String> {
			
}
