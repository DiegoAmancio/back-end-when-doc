package whenDoc.whenDOc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medication;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;

public interface MedicoService {
	
	/*
	 * Find Medico by id which is the primary key.
	 * @param id
	 * @return
	 */
	ResponseEntity<Medico> findById(Long id);
	
	/*
	 * Find Medico by name.
	 * @param nome
	 * @return
	 */
	Medico findByName(String nome);
	
	/*
	 * Find Medico by cpf.
	 * @param cpf
	 * @return
	 */
	Medico findByCPF(Long cpf);
	

	List<Medico> findAll();
	
	/*
	 * Save Medico into database.
	 * @param medico
	 * @return medico
	 */
	HttpStatus save(Medico newMedico);

	
	HttpStatus addPacientMed(Long cpfPaciente,Long idMed);
	
	ResponseEntity<Consulta> addConsulta(Diagnostico diagnostico,Long idMed,Long idPaciente);
	
	ResponseEntity<Set<Diagnostico>> getDiagnosticos(Long idMed,Long idPaciente);

	ResponseEntity<Set<Medication>> getMedicamentos(Long cpf, Long cpfPaciente);

	ResponseEntity<Paciente> getPaciente(Long cpf, Long cpfPaciente);

	ResponseEntity<Set<Medication>> addMedicamentos(Long cpf, Long cpfPaciente, Long cpfPaciente2, ArrayList<Medication> medicamentos);

	ResponseEntity<Medico> login(String email, String senha);

	ResponseEntity<Set<Paciente>> getPacientes(Long crm);
	ResponseEntity<Medico> editsMedico(Medico medico);

}