package whenDoc.whenDOc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import whenDoc.whenDOc.entity.Medication;
import whenDoc.whenDOc.service.MedicamentoService;

@CrossOrigin({"*"})
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {
	@Autowired
	MedicamentoService medicamentoService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public 	HttpStatus registerMedicine(@RequestBody Medication medicine) {
		return medicamentoService.save(medicine);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public 	Medication getMecine(@PathVariable("id") Long id ) {
		return medicamentoService.findById(id);
		
	}
	
	@RequestMapping(value = "{id}/edit{tipoDado}", method = RequestMethod.PUT)
	public HttpStatus editInfosMedicamento(@RequestBody String dado,@PathVariable("tipoDado")String tipoDado,@PathVariable("id") Long id) {
		HttpStatus operacao;
		switch(tipoDado) {
			case "Nome":
				operacao = medicamentoService.editNome(dado, id);
				break;
			case "Quantidade":
				operacao = medicamentoService.editQuantidade(dado, id);
				break;
			case "Horario":
				operacao = medicamentoService.editHorario(dado, id);
				break;
			case "Intervalo":
				operacao = medicamentoService.editIntervalo(dado, id);
				break;
			case "Data inicial":
				operacao = medicamentoService.editDataInicial(dado, id);
				break;
			case "Data final":
				operacao = medicamentoService.editDataFinal(dado, id);
				break;
			case "Dosagem":
				operacao = medicamentoService.editDosagem(dado, id);
				break;
			default:
				operacao = HttpStatus.BAD_REQUEST;
				break;
		}
		return operacao;
	}
	
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public 	HttpStatus deleteMedicine(@RequestBody Long id) {
		return medicamentoService.delete(id);
	}
}
