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

	HttpStatus editNome(String nome, String id);
	
	HttpStatus editCRM(String crm, String id);
	
	HttpStatus editCPF(String cpf, String id);
	
	HttpStatus editEspecialidade(String especialidade, String id);
	
	HttpStatus editEmail(String email, String id);
	
	HttpStatus editSenha(String senha, String id);
	
	HttpStatus editTelefone(String telefone, String id);
	
	
	/*
	 * Delete Medico by id.
	 * @param id
	 */
	HttpStatus delete(String id);
	
	HttpStatus addPacientMed(Paciente pacient,String idMed);

}
