package whenDoc.whenDOc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Medico;

@Repository
public interface MedicRepository extends JpaRepository<Medico, Long> {
	Optional<Medico> findOptionalByEmailAndSenha(String email, String senha);
	Optional<Medico> findByCrm(Long crm);
}
