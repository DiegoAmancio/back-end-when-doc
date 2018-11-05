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
	Medico findById(String id);
	
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
	Medico findByCPF(String cpf);
	

	List<Medico> findAll();
	
	/*
	 * Save Medico into database.
	 * @param medico
	 * @return medico
	 */
	HttpStatus save(Medico newMedico);

	HttpStatus editNome(String nome, String id);
	
	
	HttpStatus editEspecialidade(String especialidade, String id);
	
	HttpStatus editEmail(String email, String id);
	
	HttpStatus editSenha(String senha, String id);
	
	HttpStatus editTelefone(String telefone, String id);
	
	HttpStatus addPacientMed(String cpfPaciente,String idMed);
	
	Consulta addConsulta(String descricao,String idMed,String idPaciente);
	
	Set<Diagnostico> getDiagnosticos(String idMed,String idPaciente);

	ResponseEntity<Set<Medication>> getMedicamentos(String cpf, String cpfPaciente);

	ResponseEntity<Paciente> getPaciente(String cpf, String cpfPaciente);

	ResponseEntity<Set<Medication>> addMedicamentos(String cpf, Long idConsulta, String cpfPaciente, ArrayList<Medication> medicamentos);
}
