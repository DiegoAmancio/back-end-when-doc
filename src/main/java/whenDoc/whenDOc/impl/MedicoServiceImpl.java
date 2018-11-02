package whenDoc.whenDOc.impl;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.ConsultaRepository;
import whenDoc.whenDOc.repository.DiagnosticoRepository;
import whenDoc.whenDOc.repository.MedicamentoRepository;
import whenDoc.whenDOc.repository.MedicoRepository;
import whenDoc.whenDOc.repository.PacienteRepository;
import whenDoc.whenDOc.service.MedicoService;
import whenDoc.whenDOc.service.PacienteService;

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
	@Autowired
	PacienteService pacientService;
	
	
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
	public Consulta addConsulta(String descricao, Long idMed,Long idPaciente) {
		Date d = new Date(System.currentTimeMillis());
		String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		Paciente paciente = pacienteRepository.findById(idPaciente).get();
		Diagnostico diagnostico = new Diagnostico("213123", descricao);
		
		Consulta consulta = new Consulta(data,diagnostico,paciente);
		Medico medico = medicoRepository.findById(idMed).get();

		consulta.setMedico(medico);
		
		Consulta consulta1 = consultaRepository.save(consulta);
		
		
		return consulta1;
	}

	@Override
	public Set<Diagnostico> getDiagnosticos(Long idMed, Long idPaciente) {
		Set<Diagnostico> diagnosticos = new HashSet<>();
		Medico medico = medicoRepository.findById(idMed).get();
		Paciente paciente = pacienteRepository.findById(idPaciente).get();
		if(medico.getPacientes().contains(paciente)) {
			diagnosticos = pacientService.getDiagnosticos(idPaciente);
		}
		return diagnosticos;
	}

	@Override
	public ResponseEntity<Set<Medicamento>> getMedicamentos(Long cpf, Long cpfPaciente) {
		
		Medico medico = medicoRepository.findById(cpf).get();
		Paciente paciente = pacienteRepository.findById(cpfPaciente).get();
		
		if(medico.getPacientes().contains(paciente)) {
			return new ResponseEntity<>(paciente.getMedicamentos(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new HashSet<>(),HttpStatus.NOT_FOUND);
	
	}

	@Override
	public ResponseEntity<Paciente> getPaciente(Long cpf, Long cpfPaciente) {
		Medico medico = medicoRepository.findById(cpf).get();
		Paciente paciente = pacienteRepository.findById(cpfPaciente).get();
		
		if(medico.getPacientes().contains(paciente)) {
			return new ResponseEntity<>(paciente,HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new Paciente(),HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Set<Medicamento>> addMedicamentos(Long cpf,Long idConsulta, Long cpfPaciente,
			ArrayList<Medicamento> medicamentos) {
		Medico medico = medicoRepository.findById(cpf).get();
		Paciente paciente = pacienteRepository.findById(cpfPaciente).get();
		Consulta consulta  = consultaRepository.findById(idConsulta).get();
		
		if(medico.getPacientes().contains(paciente)) {
			for (int i = 0; i < medicamentos.size(); i++) {
				Medicamento medicamento = medicamentos.get(i);
				medicamento.setConsulta(consulta);
				medicamento.setPaciente(paciente);
				medicamentoRepository.save(medicamento);
			}
			return new ResponseEntity<>(paciente.getMedicamentos(),HttpStatus.OK);
		}
		return new ResponseEntity<>(new HashSet<>(),HttpStatus.BAD_REQUEST);	}
	
}
