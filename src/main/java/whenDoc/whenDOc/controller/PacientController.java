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
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medication;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.service.PacienteService;

@CrossOrigin
@RestController
@RequestMapping("/paciente")
public class PacientController {

	@Autowired
	PacienteService pacientService;

	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> getPacient(@PathVariable("cpf") Long cpf) {

		ResponseEntity<Paciente> paciente = pacientService.findByCPF(cpf);

		return paciente;

	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Paciente> getPacientes() {

		return pacientService.findAll();

	}

	@RequestMapping(value = "{cpf}/medicamento", method = RequestMethod.GET)
	public ResponseEntity<Set<Medication>> getMedicamentos(@PathVariable("cpf") Long cpf) {

		ResponseEntity<Set<Medication>> medicamentos = pacientService.getMedicamentos(cpf);

		return medicamentos;
	}

	@RequestMapping(value = "{cpf}/alergia", method = RequestMethod.GET)
	public ResponseEntity<Set<Alergia>> getAlergias(@PathVariable("cpf") Long cpf) {

		ResponseEntity<Set<Alergia>> alergias = pacientService.getAlergias(cpf);

		return alergias;

	}

	@RequestMapping(value = "/{cpf}/alergia", method = RequestMethod.POST)
	public HttpStatus addAllergy(@RequestBody String alergia, @PathVariable("cpf") Long cpf) {

		return pacientService.addAllergy(alergia, cpf);

	}

	@RequestMapping(value = "/{cpf}/medicamento", method = RequestMethod.POST)
	public HttpStatus addMedication(@RequestBody Medication medicamento, @PathVariable("cpf") Long cpf) {

		return pacientService.addMedication(medicamento, cpf);

	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Paciente> registerPacient(@RequestBody Paciente pacient) {
		
		ResponseEntity<Paciente> paciente = pacientService.save(pacient);

		return paciente;

	}

	@RequestMapping(value = "/{cpf}/medicamento/{idMed}", method = RequestMethod.DELETE)
	public HttpStatus deleteMedicamento(@PathVariable("cpf") Long cpf, @PathVariable("idMed") Long idMedicamento) {

		return pacientService.deleteMedicamento(cpf, idMedicamento);
		

	}

	@RequestMapping(value = "/{cpf}/diagnosticos", method = RequestMethod.GET)
	public ResponseEntity<Set<Diagnostico>> getHistoricoDiagnosticos(@PathVariable("cpf") Long cpf) {

		return pacientService.getDiagnosticos(cpf);

	}
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<Paciente> login(@RequestBody Paciente paciente) {

		return pacientService.login(paciente.getEmail(), paciente.getSenha());

	}

	@RequestMapping(value = "/{cpf}", method = RequestMethod.PUT)
	public ResponseEntity<Paciente> editInfosPaciente(@RequestBody Paciente paciente) {

		return pacientService.editsPaciente(paciente);
	}

}