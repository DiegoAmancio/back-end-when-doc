package whenDoc.whenDOc.controller;

import java.util.ArrayList;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medication;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.service.MedicoService;

@CrossOrigin
@RestController
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	MedicoService medicoService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public 	ResponseEntity<Medico> registerMedico(@RequestBody Medico medico) {
				
		HttpStatus status = medicoService.save(medico);;
		
		
		return new ResponseEntity<>(medico, status);
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public 	ResponseEntity<Medico> getMedico(@PathVariable("id") String id ) {
		Medico medico = medicoService.findById(id);
		HttpStatus status;
		
		if(medico.getCpf() != null) {
		
			status = HttpStatus.FOUND;
		
		}else {
		
			status = HttpStatus.NOT_FOUND;
		
		}
		return new ResponseEntity<>(medico,status);
	}
	@RequestMapping(value = "/{id}/pacientes", method = RequestMethod.GET)
	public 	Set<Paciente> getPacientes(@PathVariable("id") String id ) {
		
		return medicoService.findByCPF(id).getPacientes();
		
	}
	
	@RequestMapping(value = "/{id}/edit{tipoDado}", method = RequestMethod.PUT)
	public HttpStatus editInfosMedico(@RequestBody String dado,@PathVariable("tipoDado") String tipoDado,@PathVariable("id") String id) {
		HttpStatus operacao;
		switch (tipoDado) {
			case "Nome":
				operacao = medicoService.editNome(dado, id);
				break;
			
			case "Especialidade":
				operacao = medicoService.editEspecialidade(dado, id);
				break;
			case "Email":
				operacao = medicoService.editEmail(dado, id);
				break;
			case "Senha":
				operacao = medicoService.editSenha(dado, id);
				break;
			case "Telefone":
				operacao = medicoService.editTelefone(dado, id);
				break;
			default:
				operacao = HttpStatus.BAD_REQUEST;
				break;
		}
		return operacao;
	}
	@RequestMapping(value = "/{cpf}/addPacient/", method = RequestMethod.POST)
	public HttpStatus addPacient(@RequestBody String cpfPaciente,@PathVariable("cpf") String cpf) {
		
		return medicoService.addPacientMed(cpfPaciente, cpf);
		
 	}
	@RequestMapping(value = "/{cpf}/addConsulta/{cpfPaciente}", method = RequestMethod.POST)
	public Consulta addConsulta(@RequestBody String descricao,@PathVariable("cpfPaciente") String idPaciente,@PathVariable("cpf") String cpf) {
		
		return medicoService.addConsulta(descricao, cpf, idPaciente);
		
 	}
	@RequestMapping(value = "/{cpf}/diagnosticos/{cpfPaciente}", method = RequestMethod.GET)
	public Set<Diagnostico> getDisgnosticosPaciente(@PathVariable("cpfPaciente") String cpfPaciente,@PathVariable("cpf") String cpf) {
		
		return medicoService.getDiagnosticos(cpf,cpfPaciente);
		
 	}
	@RequestMapping(value = "/{cpf}/medicamento/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Set<Medication>> getMedicamentosPaciente(@PathVariable("cpfPaciente") String cpfPaciente,@PathVariable("cpf") String cpf) {
		
		return medicoService.getMedicamentos(cpf,cpfPaciente);
		
 	}
	@RequestMapping(value = "/{cpf}/{idConsulta}/medicamento/{cpfPaciente}", method = RequestMethod.POST)
	public ResponseEntity<Set<Medication>> addMedicamentosPaciente(@PathVariable("cpfPaciente") String cpfPaciente,@PathVariable("idConsulta") Long idConsulta,@PathVariable("cpf") String cpf,@RequestBody ArrayList<Medication> medicamentos) {
		
		return medicoService.addMedicamentos(cpf,idConsulta,cpfPaciente,medicamentos);
		
 	}
	@RequestMapping(value = "/{cpf}/paciente/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> getPaciente(@PathVariable("cpfPaciente") String cpfPaciente,@PathVariable("cpf") String cpf) {
		
		return medicoService.getPaciente(cpf,cpfPaciente);
		
 	}
	
	
	
}