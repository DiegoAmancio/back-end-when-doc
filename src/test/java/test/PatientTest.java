package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import whenDoc.whenDOc.entity.Alergia;
import whenDoc.whenDOc.entity.Endereco;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;
import whenDoc.whenDOc.repository.PatientRepository;
import whenDoc.whenDOc.service.PacienteService;

public class PatientTest {
	
	Paciente patient1 = new Paciente();;
	@Autowired
	PacienteService patientService1;
	
	PatientRepository patientRepository1;
	
	Medico medic1;
	
	Alergia allergy1;
	
	Endereco address1 = new Endereco();
	
	@Before
	public void createPatient() {
		
		
		patient1.setNome("Pele");
		patient1.setCpf((long) 123456);
		patient1.setEmail("pelebranco@gmail.com");
		patient1.setEmailSec("maradonacorono@gmail.com");
		patient1.setSenha("pelemarreta");
		patient1.setTelefone("7777");
		patient1.setTelefoneSec("8888");
		patient1.setTipoSanguineo("a+");
		patient1.setApp(true);

		
		address1.setRua("Rua dos Bobos");
		address1.setBairro("Ramadinha");
		address1.setNumero("0");
		address1.setComplemento("");
		address1.setCidade("Campina Grande");
		address1.setEstado("PB");
		address1.setPais("Brasil");
		address1.setCep("58100200");
		
		patient1.setEndereco(address1);
		
	}
	
	
	@Test
	public void testGetCpf() {
		assertNotEquals("123456",patient1.getCpf());
	}
	@Test
	public void testGetNome() {
		assertEquals("Pele",patient1.getNome());
	}
	@Test
	public void testGetEmail() {
		assertEquals("pelebranco@gmail.com",patient1.getEmail());
	}
	@Test
	public void testGetEmailSec() {
		assertEquals("maradonacorono@gmail.com",patient1.getEmailSec());
	}
	@Test
	public void testGetSenha() {
		assertEquals("pelemarreta",patient1.getSenha());
	}
	@Test
	public void testGetTelefone() {
		assertEquals("7777",patient1.getTelefone());
	}
	@Test
	public void testGetTelefoneSec() {
		assertEquals("8888",patient1.getTelefoneSec());
	}
	@Test
	public void testGetTipoSanguineo() {
		assertEquals("a+",patient1.getTipoSanguineo());
	}
	@Test
	public void testGetIsApp() {
		assertEquals(true,patient1.isApp());
	}
	@Test
	public void testGetEndereco() {
		assertEquals("a+",patient1.getTipoSanguineo());
	}
	@Test
	public void testGet() {
		assertEquals("a+",patient1.getTipoSanguineo());
	}
	@Test
	public void testGetRua() {
		assertEquals("Rua dos Bobos",patient1.getEndereco().getRua());
	}
	@Test
	public void testGetBairro() {
		assertEquals("Ramadinha",patient1.getEndereco().getBairro());
	}
	@Test
	public void testGetNumero() {
		assertEquals("0",patient1.getEndereco().getNumero());
	}
	@Test
	public void testGetComplemento() {
		assertNotEquals("Ramadinha é uma desgraça",patient1.getEndereco().getComplemento());
	}
	@Test
	public void testGetCidade() {
		assertEquals("Campina Grande",patient1.getEndereco().getCidade());
	}
	

}
