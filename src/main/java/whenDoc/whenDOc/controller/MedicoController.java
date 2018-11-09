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
	public 	ResponseEntity<Medico> getMedico(@PathVariable("id") Long id ) {
		
		return medicoService.findById(id);
		
	}
	@RequestMapping(value = "/{id}/pacientes", method = RequestMethod.GET)
	public 	ResponseEntity<Set<Paciente>> getPacientes(@PathVariable("id") Long id ) {
		
		return medicoService.getPacientes(id);
		
	}
	
	@RequestMapping(value = "/{id}/edit{tipoDado}", method = RequestMethod.PUT)
	public HttpStatus editInfosMedico(@RequestBody String dado,@PathVariable("tipoDado") String tipoDado,@PathVariable("id") Long id) {
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
	public HttpStatus addPacient(@RequestBody Long cpfPaciente,@PathVariable("cpf") Long cpf) {
		
		return medicoService.addPacientMed(cpfPaciente, cpf);
		
 	}
	@RequestMapping(value = "/{cpf}/addConsulta/{cpfPaciente}", method = RequestMethod.POST)
	public ResponseEntity<Consulta> addConsulta(@RequestBody String descricao,@PathVariable("cpfPaciente") Long idPaciente,@PathVariable("cpf") Long cpf) {
		return medicoService.addConsulta(descricao, cpf, idPaciente);
		
 	}
	@RequestMapping(value = "/{cpf}/diagnosticos/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Set<Diagnostico>> getDisgnosticosPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("cpf") Long cpf) {
		
		return medicoService.getDiagnosticos(cpf,cpfPaciente);
		
 	}
	@RequestMapping(value = "/{cpf}/medicamento/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Set<Medication>> getMedicamentosPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("cpf") Long cpf) {
		
		return medicoService.getMedicamentos(cpf,cpfPaciente);
		
 	}
	@RequestMapping(value = "/{cpf}/{idConsulta}/medicamento/{cpfPaciente}", method = RequestMethod.POST)
	public ResponseEntity<Set<Medication>> addMedicamentosPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("idConsulta") Long idConsulta,@PathVariable("cpf") Long cpf,@RequestBody ArrayList<Medication> medicamentos) {
		
		return medicoService.addMedicamentos(cpf,idConsulta,cpfPaciente,medicamentos);
		
 	}
	@RequestMapping(value = "/{cpf}/paciente/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> getPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("cpf") Long cpf) {
		
		return medicoService.getPaciente(cpf,cpfPaciente);
		
 	}
	@RequestMapping(value = "/login/{email}", method = RequestMethod.POST)
	public ResponseEntity<Medico> login(@PathVariable("email") String email,@RequestBody String senha) {

		return medicoService.login(email, senha);

	}
	
	
	
}