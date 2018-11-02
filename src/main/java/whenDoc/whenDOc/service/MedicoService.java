package whenDoc.whenDOc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;

public interface MedicoService {
	
	/*
	 * Find Medico by id which is the primary key.
	 * @param id
	 * @return
	 */
	Medico findById(Long id);
	
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

	HttpStatus editNome(String nome, Long id);
	
	
	HttpStatus editEspecialidade(String especialidade, Long id);
	
	HttpStatus editEmail(String email, Long id);
	
	HttpStatus editSenha(String senha, Long id);
	
	HttpStatus editTelefone(String telefone, Long id);
	
	HttpStatus addPacientMed(Long cpfPaciente,Long idMed);
	
	Consulta addConsulta(String descricao,Long idMed,Long idPaciente);
	
	Set<Diagnostico> getDiagnosticos(Long idMed,Long idPaciente);

	ResponseEntity<Set<Medicamento>> getMedicamentos(Long cpf, Long cpfPaciente);

	ResponseEntity<Paciente> getPaciente(Long cpf, Long cpfPaciente);

	ResponseEntity<Set<Medicamento>> addMedicamentos(Long cpf, Long cpfPaciente, Long cpfPaciente2, ArrayList<Medicamento> medicamentos);
}
