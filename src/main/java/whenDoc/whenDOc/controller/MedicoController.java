package whenDoc.whenDOc.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.service.MedicoService;

@CrossOrigin({"*"})
@RestController
@RequestMapping("/medico")
public class MedicoController {
	@Autowired
	MedicoService medicoService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public 	HttpStatus registerMedico(@RequestBody Medico medico) {
		return medicoService.save(medico);
		
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public 	Medico getMedico(@PathVariable("id") Long id ) {
		return medicoService.findByCPF(id);

		
	}
	@RequestMapping(value = "/{id}/pacientes", method = RequestMethod.GET)
	public 	Set<Paciente> getPacientes(@PathVariable("id") Long id ) {
		
		return medicoService.findByCPF(id).getPacientes();
		
	}
	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public HttpStatus editInfosMedico(@RequestBody String tipoDado,String dado,@PathVariable("id") Long id) {
		HttpStatus operacao;
		switch (tipoDado) {
			case "Nome":
				operacao = medicoService.editNome(dado, id);
				break;
			case "Crm":
				operacao = medicoService.editCRM(dado, id);
				break;
			case "Cpf":
				operacao = medicoService.editCPF(dado, id);
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
	
	
}