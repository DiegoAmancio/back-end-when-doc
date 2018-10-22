package whenDoc.whenDOc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.service.PacienteService;

@CrossOrigin({"*"})
@RestController
@RequestMapping("/paciente")
public class PacientController {
	@Autowired
	PacienteService pacientService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public 	HttpStatus registerPacient(@RequestBody Paciente pacient) {
		return pacientService.save(pacient);
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public 	Paciente getPacient(@PathVariable("id") Long id ) {
		return pacientService.findByCPF(id);
		
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public 	List<Paciente> getPacientes() {
		return pacientService.findAll();
		
	}
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public HttpStatus editInfosPaciente(String tipoDado, String dado, Long id) {
		HttpStatus operacao;
		switch (tipoDado) {
			case "Nome":
				operacao = pacientService.editNome(dado, id);
				break;
			case "Cpf":
				operacao = pacientService.editCPF(dado, id);
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
	@RequestMapping(value = "/{id}/addAlergia", method = RequestMethod.POST)
	public 	HttpStatus addAlergia(@RequestBody String alergia,@PathVariable Long id) {
		return pacientService.addAlergia(alergia, id);
		
	}
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public 	HttpStatus deletePacient(@RequestBody Long id) {
		return pacientService.delete(id);
		
	}
}