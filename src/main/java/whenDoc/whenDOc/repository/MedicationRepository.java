package whenDoc.whenDOc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
