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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> getPacient(@PathVariable("id") Long id) {

		ResponseEntity<Paciente> paciente = pacientService.findByCPF(id);

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

	@RequestMapping(value = "/{id}/alergia", method = RequestMethod.POST)
	public HttpStatus addAllergy(@RequestBody String alergia, @PathVariable Long id) {

		return pacientService.addAllergy(alergia, id);

	}

	@RequestMapping(value = "/{id}/medicamento", method = RequestMethod.POST)
	public HttpStatus addMedication(@RequestBody Medication medicamento, @PathVariable Long id) {

		return pacientService.addMedication(medicamento, id);

	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<Paciente> registerPacient(@RequestBody Paciente pacient) {
		
		ResponseEntity<Paciente> paciente = pacientService.save(pacient);

		return paciente;

	}

	@RequestMapping(value = "/{cpf}/medicamento", method = RequestMethod.DELETE)
	public HttpStatus deleteMedicamento(@PathVariable("cpf") Long cpf, @RequestBody Medication medicamento) {

		return pacientService.deleteMedicamento(cpf, medicamento.getId());

	}

	@RequestMapping(value = "/{cpf}/diagnosticos", method = RequestMethod.GET)
	public ResponseEntity<Set<Diagnostico>> getHistoricoDiagnosticos(@PathVariable("cpf") Long cpf) {

		return pacientService.getDiagnosticos(cpf);

	}
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<Paciente> login(@RequestBody Paciente paciente) {

		return pacientService.login(paciente.getEmail(), paciente.getSenha());

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Paciente> editInfosPaciente(@RequestBody Paciente paciente) {

		return pacientService.editsPaciente(paciente);
	}

}