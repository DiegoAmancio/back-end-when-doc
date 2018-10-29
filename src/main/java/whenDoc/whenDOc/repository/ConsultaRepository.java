package whenDoc.whenDOc.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import whenDoc.whenDOc.entity.Consulta;


@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
	
	@Query("select u from Consulta u where u.paciente = ?1")
	Set<Consulta> findDiagnosticoPaciente(Long cpf);
	
	@Query("select u from Consulta u where u.medico.crm = ?1")
	Set<Consulta> findDiagnosticoParaMedico(Long crm);
}
