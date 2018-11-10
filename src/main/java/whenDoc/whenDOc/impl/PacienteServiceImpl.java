package whenDoc.whenDOc.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medication;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.AllergysRepository;
import whenDoc.whenDOc.repository.MedicationRepository;
import whenDoc.whenDOc.repository.PatientRepository;
import whenDoc.whenDOc.repository.QueryRepository;
import whenDoc.whenDOc.service.PacienteService;

/**
 * 
 * @author diegoap
 *
 */
@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private AllergysRepository allergyRepository;
	@Autowired
	private MedicationRepository medicationRepository;
	@Autowired
	private QueryRepository queryRepository;

	@Override
	public ResponseEntity<Paciente> findByCPF(Long cpf) {

		Optional<Paciente> paciente = patientRepository.findById(cpf);

		if (paciente.isPresent()) {
			return new ResponseEntity<>(paciente.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Paciente(), HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public List<Paciente> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public ResponseEntity<Paciente> save(Paciente newPaciente) {
		try {
			Paciente paciente = new Paciente(newPaciente.getNome(), newPaciente.getCpf(), newPaciente.getEmail(),
					newPaciente.getEmailSec(), newPaciente.getSenha(), newPaciente.getTelefone(),
					newPaciente.getTelefoneSec(), newPaciente.getTipoSanguineo(), newPaciente.isApp());

			paciente.setEndereco(newPaciente.getEndereco());
			if(!existeEmail(newPaciente.getEmail())) {
				patientRepository.save(paciente);
				return new ResponseEntity<>(paciente, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(new Paciente(), HttpStatus.NOT_ACCEPTABLE);

			}
			
		} catch (Exception e) {

			return new ResponseEntity<>(new Paciente(), HttpStatus.NOT_ACCEPTABLE);

		}
	}
	private boolean existeEmail(String email) {
		List<Paciente> pacientes = patientRepository.findAll();
		for (int i = 0; i < pacientes.size(); i++) {
			if(pacientes.get(i).getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}


	@Override
	public HttpStatus addAllergy(String nomeAlergia, Long id) {

		Optional<Paciente> paciente = patientRepository.findById(id);

		if (paciente.isPresent()) {

			Alergia alergia = new Alergia();

			alergia.setNome_Alergia(nomeAlergia);
			alergia.setPaciente(paciente.get());

			allergyRepository.save(alergia);

			return HttpStatus.ACCEPTED;
		}

		return HttpStatus.NOT_FOUND;

	}


	@Override
	public HttpStatus addMedication(Medication medicamento, Long id) {

		Optional<Paciente> paciente = patientRepository.findById(id);

		if (paciente.isPresent()) {

			medicamento.setPaciente(paciente.get());

			medicationRepository.save(medicamento);

			return HttpStatus.ACCEPTED;
		}

		return HttpStatus.NOT_FOUND;

	}

	@Override
	public ResponseEntity<Set<Medication>> getMedicamentos(Long cpf) {

		Optional<Paciente> paciente = patientRepository.findById(cpf);

		if (paciente.isPresent()) {

			return new ResponseEntity<>(paciente.get().getMedicamentos(), HttpStatus.OK);

		}

		return new ResponseEntity<>(new HashSet<Medication>(), HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Set<Alergia>> getAlergias(Long cpf) {
		Optional<Paciente> paciente = patientRepository.findById(cpf);

		if (paciente.isPresent()) {

			return new ResponseEntity<>(paciente.get().getAlergias(), HttpStatus.OK);
		}

		return new ResponseEntity<>(new HashSet<Alergia>(), HttpStatus.NOT_FOUND);
	}

	@Override
	public HttpStatus deleteMedicamento(Long id, Long idMedicamento) {

		Optional<Medication> medicamento = medicationRepository.findById(idMedicamento);
		Optional<Paciente> paciente = patientRepository.findById(id);

		if (medicamento.isPresent() && medicamento.get().getPaciente().getCpf().equals(paciente.get().getCpf())) {
			medicamento.get().setPaciente(null);
			medicationRepository.delete(medicamento.get());
			return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}

	@Override
	public ResponseEntity<Set<Diagnostico>> getDiagnosticos(Long cpf) {
	
		Set<Diagnostico> diagnosticos = new HashSet<>();
		Optional<Paciente> paciente = patientRepository.findById(cpf);
		
		if(!paciente.isPresent()) {
			return new ResponseEntity<>(diagnosticos,HttpStatus.NOT_FOUND);
		}
		
		List<Consulta> consultas = queryRepository.findAll();
		for (int i = 0; i < consultas.size(); i++) {
			Consulta consulta = consultas.get(i);
			if (consulta.getPaciente().equals(paciente.get())) {
				diagnosticos.add(consulta.getDiagnostico());
			}
		}
		return new ResponseEntity<>(diagnosticos,HttpStatus.OK);
	}
	@Override	
	public ResponseEntity<Paciente> login(String email,String senha) {
		Optional<Paciente> paciente = patientRepository.findOptionalByEmailAndSenha(email, senha);
		
		if(paciente.isPresent()) {
			return new ResponseEntity<Paciente>(paciente.get(),HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<Paciente>(new Paciente(),HttpStatus.BAD_GATEWAY);
		}
	}

	@Override
	public ResponseEntity<Paciente> editsPaciente(Paciente paciente) {
		Optional<Paciente> pacienteBd = patientRepository.findById(paciente.getCpf());
		
		if(pacienteBd.isPresent()) {
			
			pacienteBd.get().setApp(paciente.isApp());
			pacienteBd.get().setEmail(paciente.getEmail());
			pacienteBd.get().setEmailSec(paciente.getEmailSec());
			pacienteBd.get().setTipoSanguineo(paciente.getTipoSanguineo());
			pacienteBd.get().setNome(paciente.getNome());
			pacienteBd.get().setTelefone(paciente.getTelefone());
			pacienteBd.get().setTelefoneSec(paciente.getTelefoneSec());
			pacienteBd.get().setSenha(paciente.getSenha());
			pacienteBd.get().setEndereco(paciente.getEndereco());

			patientRepository.save(pacienteBd.get());
			
			
			return new ResponseEntity<Paciente>(pacienteBd.get(),HttpStatus.OK);

		}
		return new ResponseEntity<Paciente>(new Paciente(),HttpStatus.NOT_FOUND);
	}
}
