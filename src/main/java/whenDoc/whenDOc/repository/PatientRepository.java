package whenDoc.whenDOc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Paciente;

@Repository
public interface PatientRepository extends JpaRepository<Paciente, Long> {
	
}
