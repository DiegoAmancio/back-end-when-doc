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
import whenDoc.whenDOc.entity.Medication;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.MedicRepository;
import whenDoc.whenDOc.repository.MedicationRepository;
import whenDoc.whenDOc.repository.PatientRepository;
import whenDoc.whenDOc.repository.QueryRepository;
import whenDoc.whenDOc.service.MedicoService;
import whenDoc.whenDOc.service.PacienteService;

@Service
public class MedicoServiceImpl implements MedicoService {

	@Autowired
	private MedicRepository medicoRepository;
	@Autowired
	private PatientRepository pacienteRepository;
	
	@Autowired
	private MedicationRepository medicamentoRepository;
	@Autowired
	private QueryRepository consultaRepository;
	@Autowired
	PacienteService pacientService;
	
	
	@Override
	public ResponseEntity<Medico> findById(Long id) {
		
		Optional<Medico> medico = medicoRepository.findById(id);
		
		if (medico.isPresent()) {
			return new ResponseEntity<>(medico.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Medico(), HttpStatus.NOT_FOUND);
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
		Medico medico = findById(id).getBody();

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
		Medico medico = findById(id).getBody();

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
		Medico medico = findById(id).getBody();

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
		Medico medico = findById(id).getBody();

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
		Medico medico = findById(id).getBody();

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
	public ResponseEntity<Consulta> addConsulta(String descricao, Long idMed,Long idPaciente) {
		
		Date d = new Date(System.currentTimeMillis());
		String data = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		
		Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
		
		Diagnostico diagnostico = new Diagnostico("213123", descricao);
		
		
		Optional<Medico> medico = medicoRepository.findById(idMed);
		
		if(medico.isPresent() && paciente.isPresent()) {
			
			Consulta consulta = new Consulta(data,diagnostico,paciente.get());
			consulta.setMedico(medico.get());
			
			Consulta consulta1 = consultaRepository.save(consulta);
			return new ResponseEntity<>(consulta1,HttpStatus.ACCEPTED);
		}
		
		
		
		 return new ResponseEntity<>(new Consulta(),HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Set<Diagnostico>> getDiagnosticos(Long idMed, Long idPaciente) {
		Set<Diagnostico> diagnosticos = new HashSet<>();
		
		Optional<Medico> medico = medicoRepository.findById(idMed);
		
		Optional<Paciente> paciente = pacienteRepository.findById(idPaciente);
		if(!medico.isPresent() || !paciente.isPresent()) {
			
			return new ResponseEntity<>(diagnosticos,HttpStatus.NOT_FOUND);
		
		}
		
		if(medico.get().getPacientes().contains(paciente.get())) {
			diagnosticos = pacientService.getDiagnosticos(idPaciente).getBody();
		
		}
		
		return new ResponseEntity<>(diagnosticos,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Set<Medication>> getMedicamentos(Long cpf, Long cpfPaciente) {
		
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
	public ResponseEntity<Set<Paciente>> getPacientes(Long crm) {
		Optional<Medico> medico = medicoRepository.findById(crm);
		
		
		if(medico.isPresent()) {
			return new ResponseEntity<>(medico.get().getPacientes(),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new HashSet<Paciente>(),HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Set<Medication>> addMedicamentos(Long cpf,Long idConsulta, Long cpfPaciente,
			ArrayList<Medication> medicamentos) {
		Medico medico = medicoRepository.findById(cpf).get();
		Paciente paciente = pacienteRepository.findById(cpfPaciente).get();
		Consulta consulta  = consultaRepository.findById(idConsulta).get();
		
		if(medico.getPacientes().contains(paciente)) {
			for (int i = 0; i < medicamentos.size(); i++) {
				Medication medicamento = medicamentos.get(i);
				medicamento.setConsulta(consulta);
				medicamento.setPaciente(paciente);
				medicamentoRepository.save(medicamento);
			}
			return new ResponseEntity<>(paciente.getMedicamentos(),HttpStatus.OK);
		}
		return new ResponseEntity<>(new HashSet<>(),HttpStatus.BAD_REQUEST);	
		}
	@Override
	public ResponseEntity<Medico> login(String email,String senha) {
		Optional<Medico> medic = medicoRepository.findOptionalByEmailAndSenha(email, senha);
		
		if(medic.isPresent()) {
			return new ResponseEntity<Medico>(medic.get(),HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Medico>(new Medico(),HttpStatus.BAD_GATEWAY);
		}
	}
	
}