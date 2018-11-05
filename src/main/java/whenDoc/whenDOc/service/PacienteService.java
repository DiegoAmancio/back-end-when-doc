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
	ResponseEntity<Paciente> findByCPF(String cpf);
	
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
	HttpStatus editName(String nome, String id);
	
	
	/*
	 * Edit Paciente senha.
	 * @param senha, id
	 */
	HttpStatus editPassword(String senha, String id);
	/**
	 * 
	 * @param email
	 * @param id
	 * @return
	 */
	HttpStatus editEmail(String email, String id);
	/**
	 * 
	 * @param emailSec
	 * @param id
	 * @return
	 */
	HttpStatus editEmailSec(String emailSec, String id);
	/**
	 * 
	 * @param telefone
	 * @param id
	 * @return
	 */
	HttpStatus editTelefone(String telefone, String id);
	/**
	 * 
	 * @param telefoneSec
	 * @param id
	 * @return
	 */
	HttpStatus editTelefoneSec(String telefoneSec, String id);
	
	/*
	 * Edit Paciente tipoSanguineo.
	 * @param tipoSanguineo, id
	 */
	HttpStatus editTipoSanguineo(String tipoSanguineo, String id);
	/**
	 * add patient's allergy in system
	 * @param allergysName
	 * @param patientCpf
	 * @return http status ACCEPTED or NOT_FOUND
	 */
	HttpStatus addAllergy(String allergysName,String patientCpf);
	/**
	 * add patient's medication in system
	 * @param medicamento
	 * @param id
	 * @return
	 */
	HttpStatus addMedication(Medication medicamento, String id);
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	ResponseEntity<Set<Medication>> getMedicamentos(String cpf);

	ResponseEntity<Set<Alergia>> getAlergias(String cpf);
	/**
	 * 
	 * @param id
	 * @param idMedicamento
	 * @return
	 */
	HttpStatus deleteMedicamento(String id, Long idMedicamento);

	Set<Diagnostico> getDiagnosticos(String cpf);
	
	ResponseEntity<Paciente> loginPaciente(String endereco,String senha);
	
}
