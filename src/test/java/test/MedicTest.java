package test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import whenDoc.whenDOc.entity.Consulta;
import whenDoc.whenDOc.entity.Diagnostico;
import whenDoc.whenDOc.entity.Medico;
import whenDoc.whenDOc.entity.Paciente;

public class MedicTest {
	
	Medico medic1 = new Medico();
	
	Paciente patient1;
	Paciente patient2;
	Paciente patient3;
	Paciente patient4;
	
	Consulta query1;
	Consulta query2;
	Consulta query3;
	Consulta query4;
	
	Diagnostico diagnostic1 = new Diagnostico();
	Diagnostico diagnostic2 = new Diagnostico();
	Diagnostico diagnostic3 = new Diagnostico();
	Diagnostico diagnostic4 = new Diagnostico();
	
	Set<Paciente> setPatients1 = new HashSet<Paciente>();
	Set<Consulta> setQueries1 = new HashSet<Consulta>();
	
	@Before
	public void createMedic() {
		medic1.setNome("Dr Damião");
		medic1.setCrm((long) 1234);
		medic1.setEspecialidade("hemorroidas e dst");
		medic1.setCpf((long) 4321);
		medic1.setEmail("aloalodoto@gmail.com");
		medic1.setSenha("numgostodesermedico");
		medic1.setTelefone("3333");	
	}
	
	@Before
	public void createSetPatient() {
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
		
		patient2 = new Paciente();
		patient2.setNome("Hitler");
		patient2.setCpf((long) 654321);
		patient2.setEmail("hitlers2stalin@gmail.com");
		patient2.setEmailSec("slutslavehitler@gmail.com");
		patient2.setSenha("stalinamorzinho");
		patient2.setTelefone("1111");
		patient2.setTelefoneSec("22222");
		patient2.setTipoSanguineo("o+");
		patient2.setApp(true);
		
		patient3 = new Paciente();
		patient3.setNome("Bonoro");
		patient3.setCpf((long) 1964);
		patient3.setEmail("bonoro2018@gmail.com");
		patient3.setEmailSec("ustravive@gmail.com");
		patient3.setSenha("talkei");
		patient3.setTelefone("2019");
		patient3.setTelefoneSec("2018");
		patient3.setTipoSanguineo("o-");
		patient3.setApp(false);
		
		patient4 = new Paciente();
		patient4.setNome("Boulos");
		patient4.setCpf((long) 666);
		patient4.setEmail("voinvadi@gmail.com");
		patient4.setEmailSec("ladraodeterra@gmail.com");
		patient4.setSenha("<3capitalismo<3");
		patient4.setTelefone("666");
		patient4.setTelefoneSec("6667");
		patient4.setTipoSanguineo("a-");
		patient4.setApp(false);
		
		setPatients1.add(patient1);
		setPatients1.add(patient2);
		setPatients1.add(patient3);
	}
	
	@Before
	public void createConsulta() {
		query1 = new Consulta();
		query1.setData("10/11/2018");
		query1.setDiagnostico(diagnostic1);
		query1.setPaciente(patient1);
		query1.setMedico(medic1);
	
		query2 = new Consulta();
		query2.setData("01/11/2018");
		query2.setDiagnostico(diagnostic2);
		query2.setPaciente(patient2);
		query2.setMedico(medic1);
		
		query3 = new Consulta();
		query3.setData("05/11/2018");
		query3.setDiagnostico(diagnostic3);
		query3.setPaciente(patient3);
		query3.setMedico(medic1);
		
		query4 = new Consulta();
		query4.setData("06/11/2018");
		query4.setDiagnostico(diagnostic4);
		query4.setPaciente(patient4);
		query4.setMedico(medic1);
		
		setQueries1.add(query1);
		setQueries1.add(query2);
		setQueries1.add(query3);
	}
	
	
	
	@Test
	public void getMedicName() {
		assertEquals("Dr Damião", medic1.getNome());
		assertNotEquals("Dr rey", medic1.getNome());
	}
	
	@Test
	public void getMedicCrm() {
		assertNotEquals("1234", medic1.getCrm());
	}
	
	@Test
	public void getMedicSpecialty() {
		assertEquals("hemorroidas e dst", medic1.getEspecialidade());
		assertNotEquals(null, medic1.getEspecialidade());
	}
	
	@Test
	public void getMedicEmail() {
		assertEquals("aloalodoto@gmail.com", medic1.getEmail());
		assertNotEquals("", medic1.getEmail());
	}
	
	@Test
	public void getMedicPassword() {
		assertEquals("numgostodesermedico", medic1.getSenha());
		assertNotEquals("amosermedico", medic1.getSenha());
	}
	
	@Test
	public void getTelefone() {
		assertEquals("3333", medic1.getTelefone());
		assertNotEquals("40028922", medic1.getTelefone());
	}
	
	@Test
	public void getSetPatients() {
		assertEquals(3, setPatients1.size());
		assertNotEquals(0, setPatients1.size());
		assertEquals(setPatients1.contains(patient1), true);
		assertEquals(setPatients1.contains(patient2), true);
		assertEquals(setPatients1.contains(patient3), true);
		assertEquals(setPatients1.contains(patient4), false);
	}
	
	
	@Test
	public void getMedicQueries() {
		assertEquals(3, setQueries1.size());
		assertEquals(setQueries1.contains(query1), true);
		assertEquals(setQueries1.contains(query2), true);
		assertEquals(setQueries1.contains(query3), true);
		assertEquals(setQueries1.contains(query4), false);
	}
	

}
