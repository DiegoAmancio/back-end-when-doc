package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import whenDoc.whenDOc.WhenDOcApplication;
import whenDoc.whenDOc.controller.MedicoController;
import whenDoc.whenDOc.controller.PacientController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WhenDOcApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class WhemDocBackEndApplicationTests {

	private MockMvc mockMvcMedico;
	private MockMvc mockMvcPaciente;

	@Autowired
	MedicoController medicoController;
	@Autowired
	PacientController pacienteController;

	@org.junit.Before
	public void setUp() throws Exception {
		
		this.mockMvcMedico = MockMvcBuilders.standaloneSetup(medicoController).build();
		this.mockMvcPaciente = MockMvcBuilders.standaloneSetup(pacienteController).build();
		
		this.mockMvcMedico.perform(MockMvcRequestBuilders.post("/medico/cadastrar")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createUserInJson("ferreira99", "7653", "Taxista", "3", "email1", "123d", "213")));
		
		this.mockMvcPaciente.perform(MockMvcRequestBuilders.post("/paciente/cadastrar")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createPacienteInJson("nome", "f", "dsaa", "1", "123", "321321", "esdewq", "2213",

						false, "oq te importa", "2134", "se fode", "cmapi", "seewf", "3213", "213", "2")));

	}

	@Test
	public void testPostMedico() throws Exception {

		this.mockMvcMedico.perform(MockMvcRequestBuilders.post("/medico/cadastrar")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createUserInJson("ferreira99", "765332", "Taxista", "123", "email1232", "1223d", "213"))

		).andExpect(MockMvcResultMatchers.status().isCreated());

	}

	@Test
	public void testEditInfosFalha() throws Exception {

		this.mockMvcMedico.perform(MockMvcRequestBuilders.put("/medico/7653")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createUserInJson("ferreira99", "7653", "Taxista", "3", "email12", "123d", "213"))

		).andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void testEditInfos() throws Exception {

		this.mockMvcMedico.perform(MockMvcRequestBuilders.put("/medico/7653")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createUserInJson("ferreira99", "12", "Taxista", "3", "email12", "123d", "213"))

		).andExpect(MockMvcResultMatchers.status().isNotFound());

	}
	@Test
	public void testGetPacienteNotFound() throws Exception {

		this.mockMvcPaciente.perform(MockMvcRequestBuilders.get("/paciente/13232"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());

	}
	@Test
	public void testGetPacientes() throws Exception {

		this.mockMvcPaciente.perform(MockMvcRequestBuilders.get("/paciente"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	
	@Test
	public void testGetPaciente() throws Exception {

		this.mockMvcPaciente.perform(MockMvcRequestBuilders.get("/paciente/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	@Test
	public void testGetPacienteAlergias() throws Exception {

		this.mockMvcPaciente.perform(MockMvcRequestBuilders.get("/paciente/1/alergia"))
				.andExpect(MockMvcResultMatchers.status().is5xxServerError());

	}
	@Test
	public void testGetPacienteMedicamento() throws Exception {

		this.mockMvcPaciente.perform(MockMvcRequestBuilders.get("/paciente/1/medicamento"))
				.andExpect(MockMvcResultMatchers.status().is5xxServerError());

	}
	@Test
	public void testGetPacientesFalha() throws Exception {

		this.mockMvcMedico.perform(MockMvcRequestBuilders.get("/medico/23/pacientes"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());

	}

	@Test
	public void testLoginFalha() throws Exception {
		this.mockMvcMedico.perform(MockMvcRequestBuilders.post("/medico/login/")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createUserInJson("ferreira99", "7653", "Taxista", "3", "email1", "1232d", "213"))

		).andExpect(MockMvcResultMatchers.status().isBadGateway());
	}
	@Test
	public void testLoginPaciente() throws Exception {
		this.mockMvcPaciente.perform(MockMvcRequestBuilders.post("/paciente/login/")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createPacienteInJson("nome", "f", "dsaa", "1", "123", "321321", "esdewq", "2213",

						false, "oq te importa", "2134", "se fode", "cmapi", "seewf", "3213", "213", "2"))

		).andExpect(MockMvcResultMatchers.status().isAccepted());
	}
	@Test
	public void testLoginFalhaPaciente() throws Exception {
		this.mockMvcPaciente.perform(MockMvcRequestBuilders.post("/paciente/login/")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createPacienteInJson("nome", "333ws", "dsaa", "1", "1233", "3213221", "esdewq", "2213",

						false, "oq te importa", "2134", "se fode", "cmapi", "seewf", "3213", "213", "2"))

		).andExpect(MockMvcResultMatchers.status().isBadGateway());
	}
	@Test
	public void testPostMedicoIncompleto() throws Exception {
		this.mockMvcMedico.perform(MockMvcRequestBuilders.post("/medico/cadastrar")
				.contentType(org.springframework.http.MediaType.APPLICATION_JSON)
				.content(createUserInJson("ferreira99", "", "Taxista", "3", "email1", "123d", "213"))

		).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void testGetMedico() throws Exception {
		this.mockMvcMedico.perform(MockMvcRequestBuilders.get("/medico/7653"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGetMedicoNotFound() throws Exception {
		this.mockMvcMedico.perform(MockMvcRequestBuilders.get("/medico/9999"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

	@Test
	public void contextLoads() {
		
	}

	private static String createUserInJson(String nome, String crm, String especialidade, String cpf, String email,
			String senha, String telefone) {
		return "{ \"nome\": \"" + nome + "\", " + "\"crm\":\"" + crm + "\"," + "\"especialidade\":\"" + especialidade
				+ "\"," + "\"cpf\":\"" + cpf + "\"," + "\"email\":\"" + email + "\"," + "\"senha\":\"" + senha + "\","
				+ "\"telefone\":\"" + telefone + "\"}";
	}

	private static String createPacienteInJson(String nome, String emailSec, String telefoneSec, String cpf,
			String email, String senha, String telefone, String tipoSanguineo, boolean app, String rua, String bairro,
			String numero, String complemento, String cidade, String estado, String pais, String cep) {
		
		String json =  "{ \"nome\": \"" + nome + "\", " + "\"telefoneSec\":\"" + telefoneSec + "\"," + "\"cpf\":\"" + cpf
				+ "\"," + "\"email\":\"" + email + "\"," + "\"emailSec\":\"" + emailSec + "\"," + "\"senha\":\"" + senha
				+ "\"," + "\"tipoSanguineo\":\"" + tipoSanguineo + "\"," + "\"app\":\"" + app + "\","
				+ "\"Endereco\": { \"nome\": \"" + nome + "\", " + "\"rua\":\"" + rua + "\"," + "\"bairro\":\"" + bairro
				+ "\"," + "\"numero\":\"" + numero + "\"," + "\"complemento\":\"" + complemento + "\","
				+ "\"cidade\":\"" + cidade + "\"," + "\"estado\":\"" + estado + "\"," + "\"pais\":\"" + pais + "\"," +

				"\"cep\":\"" + cep + "\"}," + "\"telefone\":\"" + telefone + "\"}";
		return json;
	}

}
