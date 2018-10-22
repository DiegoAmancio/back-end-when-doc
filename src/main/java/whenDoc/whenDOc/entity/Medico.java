package whenDoc.whenDOc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "medico")
public class Medico {

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "medicos")
    @JsonBackReference 
 	private Set<Paciente> pacientes;	
	
    @NotEmpty()
	@Column(name = "nome")
	private String nome;
	
	@NotEmpty()
	@Column(name = "crm")
	private String crm;
	
	@NotEmpty()
	@Column(name = "especialidade")
	private String especialidade;
	
	@Id
	@Column(name = "cpf")
	private String cpf;
	
	@NotEmpty()
	@Column(name = "email")
	private String email;
	
	@NotEmpty()
	private String senha;
	
	@NotEmpty()
	@Column(name = "telefone")
	private String telefone;

	
	
	public Medico(@NotEmpty String nome, @NotEmpty String crm, @NotEmpty String especialidade,
			@NotEmpty String cpf, @NotEmpty String email, @NotEmpty String senha, @NotEmpty String telefone) {
		super();
		
		this.nome = nome;
		this.crm = crm;
		this.especialidade = especialidade;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
	}

	public Medico() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Paciente> getPacientes() {
		return pacientes;
	}
	public void addPaciente(Paciente paciente) {
		this.pacientes.add(paciente);
	}

}
