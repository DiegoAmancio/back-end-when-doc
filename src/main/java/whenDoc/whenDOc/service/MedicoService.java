package whenDoc.whenDOc.service;

import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
	Medico findByCPF(String cpf);
	
	/*
	 * Find Medico by crm.
	 * @param crm
	 * @return
	 */
	Medico findByCRM(String crm);
	
	List<Medico> findAll();
	
	/*
	 * Save Medico into database.
	 * @param medico
	 * @return medico
	 */
	HttpStatus save(Medico newMedico);

	HttpStatus editNome(String nome, Long id);
	
	HttpStatus editCRM(String crm, Long id);
	
	HttpStatus editCPF(String cpf, Long id);
	
	HttpStatus editEspecialidade(String especialidade, Long id);
	
	HttpStatus editEmail(String email, Long id);
	
	HttpStatus editSenha(String senha, Long id);
	
	HttpStatus editTelefone(String telefone, Long id);
	
	
	/*
	 * Delete Medico by id.
	 * @param id
	 */
	HttpStatus delete(Long id);
	
	HttpStatus addPacientMed(Paciente pacient,Long idMed);

}
