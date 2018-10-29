package whenDoc.whenDOc.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "medico")
public class Medico {

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "medicos")
	@JsonBackReference(value = "cpf")
	private Set<Paciente> pacientes;

	@NotEmpty()
	@Column(name = "nome")
	private String nome;
	
	@Id
	@Column(name = "crm")
	private Long crm;

	@NotEmpty()
	@Column(name = "especialidade")
	private String especialidade;

	
	@Column(name = "cpf")
	private Long cpf;

	@NotEmpty()
	@Column(name = "email")
	private String email;

	@NotEmpty()
	private String senha;
	
	@OneToMany(mappedBy = "medico", orphanRemoval = true)
	@JsonBackReference(value = "consulta")
	private Set<Consulta> consulta;
	@NotEmpty()
	@Column(name = "telefone")
	private String telefone;

	public Medico(@NotEmpty String nome, @NotEmpty Long crm, @NotEmpty String especialidade, @NotEmpty Long cpf,
			@NotEmpty String email, @NotEmpty String senha, @NotEmpty String telefone) {
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
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
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

	public Set<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(Set<Consulta> consulta) {
		this.consulta = consulta;
	}
	

}
