package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Endereco;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.PatientRepository;
import whenDoc.whenDOc.service.PacienteService;

public class PatientTest {
	
	Paciente patient1;
	
	PacienteService patientService1;
	
	PatientRepository patientRepository1;
	
	Medico medic1;
	
	Alergia allergy1;
	
	Endereco address1;
	
	@Before
	public void createPatient() {
		
		patient1 = new Paciente();
		patient1.setNome("Pele");
		patient1.setCpf((long) 123456);
		patient1.setEmail("pelebranco@gmail.com");
		patient1.setEmailSec("maradonacorono@gmail.com");
		patient1.setSenha("pelemarreta");
		patient1.setTelefone("7777");
		patient1.setTelefoneSec("8888");
		patient1.setTipoSanguineo("a+");
		patient1.setApp(true);

		address1 = new Endereco();
		address1.setRua("Rua dos Bobos");
		address1.setBairro("Ramadinha");
		address1.setNumero("0");
		address1.setComplemento("");
		address1.setCidade("Campina Grande");
		address1.setEstado("PB");
		address1.setPais("Brasil");
		address1.setCep("58100200");
		
		patient1.setEndereco(address1);
		
		patientService1.save(patient1);
		
		patientService1.addAllergy(allergy1.getNome_Alergia(), patient1.getCpf());
	}
	
	@Before
	public void createAllergy() {
		allergy1.setNome_Alergia("comunismo");
		allergy1.setPaciente(patient1);
	}
	
	@Test
	public void testSavePatient() {
		assertEquals(patientRepository1.findOptionalByEmailAndSenha(patient1.getEmail(), patient1.getSenha()), patient1);
	}

}
