package whenDoc.whenDOc.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4136372247830513030L;

	@ManyToMany(fetch = FetchType.LAZY,

			cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	
	@JoinTable(name = "paciente_medico", joinColumns = { @JoinColumn(name = "paciente_id") }, inverseJoinColumns = {
			@JoinColumn(name = "medico_id") })
	@JsonBackReference
	private Set<Medico> medicos;

	@NotEmpty()
	@Column(name = "nome")
	private String nome;

	@Id
	private Long cpf;

	@NotEmpty()
	@Column(name = "email")
	private String email;

	@Column(name = "email_Secundario")
	private String emailSec;
	
	@NotEmpty()
	@Column(name = "Senha")
	private String senha;

	@NotEmpty()
	@Column(name = "telefone")
	private String telefone;

	@Column(name = "telefone_Secundario")
	private String telefoneSec;

	@NotEmpty()
	@Column(name = "tipo_Sanguineo")
	private String tipoSanguineo;

	@OneToMany(mappedBy = "paciente", orphanRemoval = true)
	@JsonBackReference(value = "id_alergia")
	private Set<Alergia> alergias;
	
	@OneToMany(mappedBy = "paciente", orphanRemoval = true)
	@JsonBackReference(value = "crm")
	private Set<Medication> medicamentos;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
	@JsonBackReference(value = "id_consulta")
	private Set<Consulta> consulta;

	@Column()
	private boolean app;

	public Paciente() {
		super();
	}

	public Paciente(@NotEmpty String nome, @NotEmpty Long cpf, @NotEmpty String email,  String emailSec,
			@NotEmpty String senha, @NotEmpty String telefone,  String telefoneSec,
			@NotEmpty String tipoSanguineo, boolean app) {
		super();
		this.alergias = new HashSet<>();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.emailSec = emailSec;
		this.senha = senha;
		this.telefone = telefone;
		this.telefoneSec = telefoneSec;
		this.tipoSanguineo = tipoSanguineo;
		this.app = app;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}
	
	public Set<Medication> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(Set<Medication> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailSec() {
		return emailSec;
	}
	

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void setEmailSec(String emailSec) {
		this.emailSec = emailSec;
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

	public String getTelefoneSec() {
		return telefoneSec;
	}

	public void setTelefoneSec(String telefoneSec) {
		this.telefoneSec = telefoneSec;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public boolean isApp() {
		return app;
	}

	public void setApp(boolean app) {
		this.app = app;
	}

	public Set<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(Set<Alergia> alergias) {
		this.alergias = alergias;
	}

	public Set<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(Set<Medico> medicos) {
		this.medicos = medicos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Consulta> getConsulta() {
		return consulta;
	}

	public void setConsulta(Set<Consulta> consulta) {
		this.consulta = consulta;
	}
	
	
}