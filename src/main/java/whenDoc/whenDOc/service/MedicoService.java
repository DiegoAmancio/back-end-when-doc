package whenDoc.whenDOc.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;

import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.entity.Medico;

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
	
	HttpStatus editEspecialidade(String especialidade, Long id);
	
	HttpStatus editEmail(String email, Long id);
	
	HttpStatus editSenha(String senha, Long id);
	
	HttpStatus editTelefone(String telefone, Long id);
	
	HttpStatus addPacientMed(Long cpfPaciente,Long idMed);
	
	Consulta addConsulta(Set<Medicamento> idMedicamentos,Long idMed,Long idPaciente);
	
	Set<Diagnostico> getDiagnosticos(Long idMed,Long idPaciente);
}
