package whenDoc.whenDOc.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medication;
import whenDoc.whenDOc.entity.Paciente;

public interface PacienteService {

	/*
	 * Find Paciente by cpf.
	 * @param cpf
	 * @return
	 */
	ResponseEntity<Paciente> findByCPF(Long cpf);
	
	/*
	 * Find all Paciente 
	 * @return All Paciente in database.
	 */
	List<Paciente> findAll();
	/*
	 * Save Paciente into database.
	 * @param paciente
	 */
	ResponseEntity<Paciente> save(Paciente newPaciente);
	
	/*
	 * Edit Paciente name.
	 * @param nome, id
	 */
	HttpStatus editName(String nome, Long id);
	
	
	/*
	 * Edit Paciente senha.
	 * @param senha, id
	 */
	HttpStatus editPassword(String senha, Long id);
	/**
	 * 
	 * @param email
	 * @param id
	 * @return
	 */
	HttpStatus editEmail(String email, Long id);
	/**
	 * 
	 * @param emailSec
	 * @param id
	 * @return
	 */
	HttpStatus editEmailSec(String emailSec, Long id);
	/**
	 * 
	 * @param telefone
	 * @param id
	 * @return
	 */
	HttpStatus editTelefone(String telefone, Long id);
	/**
	 * 
	 * @param telefoneSec
	 * @param id
	 * @return
	 */
	HttpStatus editTelefoneSec(String telefoneSec, Long id);
	
	/*
	 * Edit Paciente tipoSanguineo.
	 * @param tipoSanguineo, id
	 */
	HttpStatus editTipoSanguineo(String tipoSanguineo, Long id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	HttpStatus addEndereco(Long id);
	/**
	 * add patient's allergy in system
	 * @param allergysName
	 * @param patientCpf
	 * @return http status ACCEPTED or NOT_FOUND
	 */
	HttpStatus addAllergy(String allergysName,Long patientCpf);
	/**
	 * add patient's medication in system
	 * @param medicamento
	 * @param id
	 * @return
	 */
	HttpStatus addMedication(Medication medicamento, Long id);
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	ResponseEntity<Set<Medication>> getMedicamentos(Long cpf);

	ResponseEntity<Set<Alergia>> getAlergias(Long cpf);
	/**
	 * 
	 * @param id
	 * @param idMedicamento
	 * @return
	 */
	HttpStatus deleteMedicamento(Long id, Long idMedicamento);

	ResponseEntity<Set<Diagnostico>> getDiagnosticos(Long cpf);

	ResponseEntity<Paciente> login(String email, String senha);
	
}
