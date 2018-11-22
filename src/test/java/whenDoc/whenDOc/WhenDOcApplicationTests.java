package whenDoc.whenDOc;

import javax.validation.constraints.NotEmpty;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.WhemDocBackEndApplicationTests;

import net.minidev.json.JSONObject;
import whenDoc.whenDOc.controller.MedicoController;


public class WhenDOcApplicationTests extends WhemDocBackEndApplicationTests{
	private MockMvc mockMvc;
	
	@Autowired
	MedicoController medicoController;
		
	
	@org.junit.Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(medicoController).build();
	}
	
	@Test
	public void testPUTSalarioMinimoController() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.post("/medico/cadastrar").contentType(org.springframework.http.MediaType.APPLICATION_JSON).
				content(createUserInJson("ferreira99", "7653", "Taxista",  "3", "delicia", "123d", "213"))
				
				).andExpect(MockMvcResultMatchers.status().isCreated());
		
		
	}
	@Test
	public void testPUTSalarioMinimoController2() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.post("/medico/cadastrar").contentType(org.springframework.http.MediaType.APPLICATION_JSON).
				content(createUserInJson("ferreira99", "7653", "Taxista",  "3", "delicia", "123d", "213"))
				
				).andExpect(MockMvcResultMatchers.status().isNotAcceptable());
	}
	@Test
	public void contextLoads() {
	}	
	private static String createUserInJson (String nome, String crm, String especialidade,  String cpf,
			String email,String senha, String telefone) {
        return "{ \"nome\": \"" + nome + "\", " +
                    "\"crm\":\"" + crm + "\"," +
                    "\"especialidade\":\"" + especialidade + "\"," +
                    "\"cpf\":\"" + cpf + "\"," +
                    "\"email\":\"" + email + "\"," +
                    "\"senha\":\"" + senha + "\"," +
                    "\"telefone\":\"" + telefone + "\"}";
    }
}
