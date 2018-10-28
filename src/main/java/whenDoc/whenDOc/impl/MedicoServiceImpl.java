package whenDoc.whenDOc.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.ConsultaRepository;
import whenDoc.whenDOc.repository.MedicamentoRepository;
import whenDoc.whenDOc.repository.MedicoRepository;
import whenDoc.whenDOc.repository.PacienteRepository;
import whenDoc.whenDOc.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@Autowired
	private ConsultaRepository consultaRepository;

	@Override
	public Medico findById(Long id) {
		
		Optional<Medico> medico = medicoRepository.findById(id);
		
		if(medico.isPresent()) {
			
			return medico.get();
		
		}else {
			
			return new Medico();
		
		}

	}

	@Override
	public Medico findByName(String nome) {
		for (Medico medico : medicoRepository.findAll()) {
			String nomeMedico = medico.getNome();

			if (nomeMedico.equals(nome)) {
				return medico;
			}
		}
		return null;
	}

	@Override
	public Medico findByCPF(Long cpf) {
		Optional<Medico> medico = medicoRepository.findById(cpf);
		
		if(medico.isPresent()) {
		
			return medico.get();
		
		}else {
		
			return new Medico();
		
		}
	}

	@Override
	public Medico findByCRM(String crm) {
		for (Medico medico : medicoRepository.findAll()) {
			String crmMedico = medico.getCrm();

			if (crmMedico.equals(crm)) {
				return medico;
			}
		}
		return null;
	}

	@Override
	public List<Medico> findAll() {
		return medicoRepository.findAll();
	}

	@Override
	public HttpStatus save(Medico newMedico) {
		try {
			Medico medico = new Medico(newMedico.getNome(), newMedico.getCrm(), newMedico.getEspecialidade(),
					newMedico.getCpf(), newMedico.getEmail(), newMedico.getSenha(), newMedico.getTelefone());
			medicoRepository.save(medico);
			return HttpStatus.CREATED;
		} catch (Exception e) {
			return HttpStatus.NOT_ACCEPTABLE;
		}

	}

	@Override
	public HttpStatus editNome(String nome, Long id) {
		Medico medico = findById(id);

		if (medico.getCpf() != null) {
			medico.setNome(nome);
			medicoRepository.save(medico);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editCRM(String crm, Long id) {
		Medico medico = findById(id);

		if (medico.getCpf() != null) {
			medico.setCrm(crm);
			medicoRepository.save(medico);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	

	@Override
	public HttpStatus editEspecialidade(String especialidade, Long id) {
		Medico medico = findById(id);

		if (medico.getCpf() != null) {
			medico.setEspecialidade(especialidade);
			medicoRepository.save(medico);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}

	}

	@Override
	public HttpStatus editEmail(String email, Long id) {
		Medico medico = findById(id);

		if (medico.getCpf() != null) {
			medico.setEmail(email);
			medicoRepository.save(medico);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}

	}

	@Override
	public HttpStatus editSenha(String senha, Long id) {
		Medico medico = findById(id);

		if (medico.getCpf() != null) {
			medico.setSenha(senha);
			medicoRepository.save(medico);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}

	}

	@Override
	public HttpStatus editTelefone(String telefone, Long id) {
		Medico medico = findById(id);

		if (medico.getCpf() != null) {
			medico.setTelefone(telefone);
			medicoRepository.save(medico);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}

	}

	

	@Override
	public HttpStatus addPacientMed(Long cpfPaciente, Long idMed) {
		Optional<Medico> medico = medicoRepository.findById(idMed);
		Optional<Paciente> pacient = pacienteRepository.findById(cpfPaciente);
		if (medico.isPresent()) {

			medico.get().addPaciente(pacient.get());

			pacient.get().getMedicos().add(medico.get());
			medicoRepository.save(medico.get());
			pacienteRepository.save(pacient.get());

			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public Consulta addConsulta(String data,Set<Medicamento> idMedicamentos, Long idMed,Long idPaciente) {
		Consulta teste = new Consulta(data);
		teste.setDiagnostico(new Diagnostico("213123", "foda-se a descrição"));
		Consulta consulta1 = consultaRepository.save(teste);
		
		for (Medicamento medicamento : idMedicamentos) {
			medicamento.setPaciente(pacienteRepository.findById(idPaciente).get());
			medicamento.setConsulta(consulta1);
			medicamentoRepository.save(medicamento);
		}
		return consulta1;
	}

}
