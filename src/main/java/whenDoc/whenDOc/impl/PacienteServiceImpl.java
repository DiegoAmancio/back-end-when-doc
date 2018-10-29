package whenDoc.whenDOc.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.AlergiasRepository;
import whenDoc.whenDOc.repository.MedicamentoRepository;
import whenDoc.whenDOc.repository.PacienteRepository;
import whenDoc.whenDOc.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private AlergiasRepository alergiaRepositorio;
	@Autowired
	private MedicamentoRepository medicamentoRepositorio;
	

	@Override
	public Paciente findByName(String nome) {
		
		for (Paciente paciente : pacienteRepository.findAll()) {
			String nomePaciente = paciente.getNome();
			
			if (nomePaciente.equals(nome)) {
				return paciente;
			}
		}
		return null;
	}

	@Override
	public Paciente findByCPF(Long cpf) {
		Optional<Paciente> paciente = pacienteRepository.findById(cpf);
		if(paciente.isPresent()) {
			return paciente.get();
		}else {
			return new Paciente();
		}
		
	}
	
	@Override
	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente save(Paciente newPaciente) {
		try {
			Paciente paciente = new Paciente(newPaciente.getNome(), newPaciente.getCpf(), newPaciente.getEmail(), newPaciente.getEmailSec(),
					newPaciente.getSenha(), newPaciente.getTelefone(), newPaciente.getTelefoneSec(), newPaciente.getTipoSanguineo(), 
					newPaciente.isApp());
		
			paciente.setEndereco(newPaciente.getEndereco());
			
					
			pacienteRepository.save(paciente);
			return paciente;
		} catch (Exception e) {

			return new Paciente();
		
		}
	}

	@Override
	public HttpStatus editNome(String nome, Long id) {
		
		Paciente paciente = findByCPF(id);
		
		if(paciente.getCpf() != null) {
			paciente.setNome(nome);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}

	
	@Override
	public HttpStatus editSenha(String senha, Long id) {
		
		Paciente paciente = findByCPF(id);
		
		if(paciente.getCpf() != null) {
			
			paciente.setSenha(senha);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@Override
	public HttpStatus editEmail(String email, Long id) {
		Paciente paciente = findByCPF(id);
		
		if(paciente.getCpf() != null) {
			
			paciente.setEmail(email);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@Override
	public HttpStatus editEmailSec(String emailSec, Long id) {
		Paciente paciente = findByCPF(id);
		
		if(paciente.getCpf() != null) {
			
			paciente.setEmail(emailSec);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@Override
	public HttpStatus editTelefone(String telefone, Long id) {
		Paciente paciente = findByCPF(id);
		
		if(paciente.getCpf() != null) {
			
			paciente.setEmail(telefone);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@Override
	public HttpStatus editTelefoneSec(String telefoneSec, Long id) {
		Paciente paciente = findByCPF(id);
		
		if(paciente.getCpf() != null) {
			
			paciente.setEmail(telefoneSec);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}
	
	@Override
	public HttpStatus editTipoSanguineo(String tipoSanguineo, Long id) {
		
		Paciente paciente = findByCPF(id);
		
		if(paciente.getCpf() != null) {
			paciente.setTipoSanguineo(tipoSanguineo);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}

	

	

	@Override
	public HttpStatus addAlergia(String nomeAlergia, Long id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		
		if(paciente.isPresent()) {
			
			Alergia alergia = new Alergia();
			
			alergia.setNome_Alergia(nomeAlergia);
			alergia.setPaciente(paciente.get());
			
			alergiaRepositorio.save(alergia);
		
			return HttpStatus.OK;
		}
		
		
	
		return HttpStatus.NOT_FOUND;
		
		
		
	}

	@Override
	public HttpStatus addEndereco(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public HttpStatus addMedicamento(Medicamento medicamento, Long id) {
		
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		
		if(paciente.isPresent()) {
		
			medicamento.setPaciente(paciente.get());
			
			medicamentoRepositorio.save(medicamento);
		
			return HttpStatus.OK;
		}
		
		return HttpStatus.NOT_FOUND;
		
	}

	@Override
	public Set<Medicamento> getMedicamentos(Long cpf) {
		
		Optional<Paciente> paciente = pacienteRepository.findById(cpf);
		
		if(paciente.isPresent()) {
			
			return paciente.get().getMedicamentos();
		
		}
		
		return new HashSet<Medicamento>();
	}

	@Override
	public Set<Alergia> getAlergias(Long cpf) {
		Optional<Paciente> paciente = pacienteRepository.findById(cpf);
		
		if(paciente.isPresent()) {
			
			return paciente.get().getAlergias();
		
		}
		
		return new HashSet<Alergia>();
	}

	@Override
	public HttpStatus deleteMedicamento(Long id, Long idMedicamento) {
		
		Optional<Medicamento> medicamento = medicamentoRepositorio.findById(idMedicamento);
		Optional<Paciente> paciente = pacienteRepository.findById(id);
		
		if(medicamento.isPresent() && 
				medicamento.get().getPaciente().getCpf().equals(paciente.get().getCpf())) {
				medicamento.get().setPaciente(null);
				medicamentoRepositorio.delete(medicamento.get());
				return HttpStatus.OK;
		}
		return HttpStatus.NOT_FOUND;
	}

	@Override
	public Set<String> getDiagnosticos(Long cpf) {
		
		HashSet<String> diagnosticos = new HashSet<>();
		Optional<Paciente> paciente = pacienteRepository.findById(cpf);
		
		for (Consulta consulta : paciente.get().getConsulta()) {
			diagnosticos.add(consulta.getDiagnostico().getDescricao());
		}

		return diagnosticos;
	}

}
