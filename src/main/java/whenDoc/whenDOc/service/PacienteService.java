package whenDoc.whenDOc.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.entity.Paciente;

public interface PacienteService {
	
	
	/*
	 * Find Paciente by name.
	 * @param nome
	 * @return
	 */
	Paciente findByName(String nome);
	
	/*
	 * Find Paciente by cpf.
	 * @param cpf
	 * @return
	 */
	Paciente findByCPF(Long cpf);
	
	/*
	 * Find all Paciente 
	 * @return All Paciente in database.
	 */
	List<Paciente> findAll();
	/*
	 * Save Paciente into database.
	 * @param paciente
	 */
	HttpStatus save(Paciente newPaciente);
	
	/*
	 * Edit Paciente name.
	 * @param nome, id
	 */
	HttpStatus editNome(String nome, Long id);
	
	
	/*
	 * Edit Paciente senha.
	 * @param senha, id
	 */
	HttpStatus editSenha(String senha, Long id);
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
	HttpStatus addAlergia(String nomeAlergia,Long id);
	/**
	 * 
	 * @param medicamento
	 * @param id
	 * @return
	 */
	HttpStatus addMedicamento(Medicamento medicamento, Long id);
	/**
	 * 
	 * @param cpf
	 * @return
	 */
	Set<Medicamento> getMedicamentos(Long cpf);

	Set<Alergia> getAlergias(Long cpf);
	/**
	 * 
	 * @param id
	 * @param idMedicamento
	 * @return
	 */
	HttpStatus deleteMedicamento(Long id, Long idMedicamento);
	
}
