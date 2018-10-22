package whenDoc.whenDOc.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.AlergiasRepository;
import whenDoc.whenDOc.repository.PacienteRepository;
import whenDoc.whenDOc.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private AlergiasRepository alergiaRepositorio;
	

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
		return pacienteRepository.getOne(cpf);

	}
	
	@Override
	public List<Paciente> findAll() {
		return pacienteRepository.findAll();
	}

	@Override
	public HttpStatus save(Paciente newPaciente) {
		try {
			Paciente paciente = new Paciente(newPaciente.getNome(), newPaciente.getCpf(), newPaciente.getEmail(), newPaciente.getEmailSec(),
					newPaciente.getSenha(), newPaciente.getTelefone(), newPaciente.getTelefoneSec(), newPaciente.getTipoSanguineo(), 
					newPaciente.isApp());
		
			paciente.setEndereco(newPaciente.getEndereco());
			
					
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return HttpStatus.BAD_REQUEST;
		}
	}

	@Override
	public HttpStatus editNome(String nome, Long id) {
		
		Paciente paciente = findByCPF(id);
		
		if(paciente != null) {
			paciente.setNome(nome);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editCPF(String cpf, Long id) {
		
		Paciente paciente = findByCPF(id);
		
		if(paciente != null) {
			//paciente.setCpf(cpf);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editSenha(String senha, Long id) {
		
		Paciente paciente = findByCPF(id);
		
		if(paciente != null) {
			
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
		
		if(paciente != null) {
			
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
		
		if(paciente != null) {
			
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
		
		if(paciente != null) {
			
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
		
		if(paciente != null) {
			
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
		
		if(paciente != null) {
			paciente.setTipoSanguineo(tipoSanguineo);
			pacienteRepository.save(paciente);
			return HttpStatus.OK;
		}else {
			return HttpStatus.NOT_FOUND;
		}
	}

	

	@Override
	public HttpStatus delete(Long id) {
		if(pacienteRepository.existsById(id)) {
			pacienteRepository.deleteById(id);
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

}
