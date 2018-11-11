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
	@RequestMapping(value = "/{crm}", method = RequestMethod.GET)
	public 	ResponseEntity<Medico> getMedico(@PathVariable("crm") Long crm ) {
		
		return medicoService.findById(crm);
		
	}
	@RequestMapping(value = "/{crm}/pacientes", method = RequestMethod.GET)
	public 	ResponseEntity<Set<Paciente>> getPacientes(@PathVariable("crm") Long crm ) {
		
		return medicoService.getPacientes(crm);
		
	}
	
	@RequestMapping(value = "/{crm}", method = RequestMethod.PUT)
	public ResponseEntity<Medico> editInfosMedico(@RequestBody Medico medico) {
		return medicoService.editsMedico(medico);
	}
	@RequestMapping(value = "/{crm}/addPaciente/{cpfPaciente}", method = RequestMethod.POST)
	public HttpStatus addPacient(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("crm") Long crm) {
		
		return medicoService.addPacientMed(cpfPaciente, crm);
		
 	}
	@RequestMapping(value = "/{crm}/addConsulta/{cpfPaciente}", method = RequestMethod.POST)
	public ResponseEntity<Consulta> addConsulta(@RequestBody Diagnostico diagnostico,@PathVariable("cpfPaciente") Long CpfPaciente,@PathVariable("crm") Long crm) {
		return medicoService.addConsulta(diagnostico, crm, CpfPaciente);
		
 	}
	@RequestMapping(value = "/{crm}/diagnosticos/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Set<Diagnostico>> getDisgnosticosPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("crm") Long crm) {
		
		return medicoService.getDiagnosticos(crm,cpfPaciente);
		
 	}
	@RequestMapping(value = "/{crm}/medicamento/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Set<Medication>> getMedicamentosPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("crm") Long crm) {
		
		return medicoService.getMedicamentos(crm,cpfPaciente);
		
 	}
	@RequestMapping(value = "/{crm}/{idConsulta}/medicamento/{cpfPaciente}", method = RequestMethod.POST)
	public ResponseEntity<Set<Medication>> addMedicamentosPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("idConsulta") Long idConsulta,
			@PathVariable("crm") Long crm,@RequestBody ArrayList<Medication> medicamentos) {
		
		return medicoService.addMedicamentos(crm,idConsulta,cpfPaciente,medicamentos);
		
 	}
	@RequestMapping(value = "/{crm}/paciente/{cpfPaciente}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> getPaciente(@PathVariable("cpfPaciente") Long cpfPaciente,@PathVariable("crm") Long crm) {
		
		return medicoService.getPaciente(crm,cpfPaciente);
		
 	}
	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<Medico> login(@RequestBody Medico medico) {

		return medicoService.login(medico.getEmail(), medico.getSenha());

	}
	
	
	
}