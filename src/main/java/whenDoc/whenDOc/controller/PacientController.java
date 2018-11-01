package whenDoc.whenDOc.controller;

import java.util.List;
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

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.service.PacienteService;

@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacientController {
	
	@Autowired
	PacienteService pacientService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public 	ResponseEntity<Paciente> getPacient(@PathVariable("id") Long id ) {
		
		Paciente paciente = pacientService.findByCPF(id);
		
		HttpStatus status;
		
		if(paciente.getCpf() != null) {
			
			status = HttpStatus.OK;
		
		}else {
			
			status = HttpStatus.NOT_FOUND;
		
		}
		
		return new ResponseEntity<>(paciente, status);
				
		
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public 	List<Paciente> getPacientes() {
		
		return pacientService.findAll();
		
	}
	
	@RequestMapping(value = "{cpf}/medicamento", method = RequestMethod.GET)
	public 	ResponseEntity<Set<Medicamento>> getMedicamentos(@PathVariable("cpf") Long cpf) {
		
		Paciente paciente = pacientService.findByCPF(cpf);
		
		Set<Medicamento> medicamentos = pacientService.getMedicamentos(cpf);
		
		HttpStatus status;
		
		if(paciente.getCpf() == null ) {
			
			status = HttpStatus.NOT_FOUND;
		
		}else{
			
			status = HttpStatus.OK;
		
		}
		
		return new ResponseEntity<>(medicamentos,status);
	}
	
	@RequestMapping(value = "{cpf}/alergia", method = RequestMethod.GET)
	public 	ResponseEntity<Set<Alergia>> getAlergias(@PathVariable("cpf") Long cpf) {
		
		Paciente paciente = pacientService.findByCPF(cpf);
		
		Set<Alergia> alergias =  pacientService.getAlergias(cpf);
		
		HttpStatus status;
		
		if(paciente.getCpf() == null ) {
			
			status = HttpStatus.NOT_FOUND;
		
		}else{
			
			status = HttpStatus.OK;
		
		}
		
		return new ResponseEntity<>(alergias,status);
		
	}
	
	
	@RequestMapping(value = "/{id}/alergia", method = RequestMethod.POST)
	public 	HttpStatus addAlergia(@RequestBody String alergia,@PathVariable Long id) {
		
		return pacientService.addAlergia(alergia, id);
		
	}
	
	@RequestMapping(value = "/{id}/medicamento", method = RequestMethod.POST)
	public 	HttpStatus addMedicamento(@RequestBody Medicamento medicamento,@PathVariable Long id) {
		
		return pacientService.addMedicamento(medicamento, id);
		
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public 	ResponseEntity<Paciente> registerPacient(@RequestBody Paciente pacient) {
		Paciente paciente =  pacientService.save(pacient);

		HttpStatus status;
		
		if(paciente.getCpf() != null) {
			
			status = HttpStatus.CREATED;
		
		}else {
			
			status = HttpStatus.NOT_ACCEPTABLE;
		
		}
		
		return new ResponseEntity<>(paciente, status);
		
	}
	
	@RequestMapping(value = "/{cpf}/medicamento", method = RequestMethod.DELETE)
	public 	HttpStatus deleteMedicamento(@PathVariable("cpf") Long cpf,@RequestBody Long idMedicamento ) {
		
		return pacientService.deleteMedicamento(cpf,idMedicamento);
		
	}
	@RequestMapping(value = "/{cpf}/diagnosticos", method = RequestMethod.GET)
	public 	Set<String> getHistoricoDiagnosticos(@PathVariable("cpf") Long cpf) {
		
		return pacientService.getDiagnosticos(cpf);
		
	}
	@RequestMapping(value = "/{id}/medicamento/edit{tipoDado}", method = RequestMethod.PUT)
	public HttpStatus editInfosPaciente(@RequestBody String dado,@PathVariable("tipoDado") String tipoDado,@PathVariable("id") Long id) {
		
		HttpStatus operacao;
		
		switch (tipoDado) {
			case "Nome":
				operacao = pacientService.editNome(dado, id);
				break;
			case "Senha":
				operacao = pacientService.editSenha(dado, id);
				break;
			case "Email":
				operacao = pacientService.editEmail(dado, id);
				break;
			case "Email secundario":
				operacao = pacientService.editSenha(dado, id);
				break;
			case "Telefone":
				operacao = pacientService.editTelefone(dado, id);
				break;
			case "Telefone secundario":
				operacao = pacientService.editTelefoneSec(dado, id);
				break;
			case "Tipo sanguineo":
				operacao = pacientService.editTipoSanguineo(dado, id);
				break;
			
			default:
				operacao = HttpStatus.BAD_REQUEST;
				break;
		}
		return operacao;
	}
	
	
}