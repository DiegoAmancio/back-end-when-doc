package whenDoc.whenDOc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
public class Consulta implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_consulta")
	private Long id;
	
	@NotEmpty()
	@Column(name = "data",length = 1024)
	private String data;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Diagnostico diagnostico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn	
	private Medico medico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn	
	private Paciente paciente;
	
	@OneToMany(mappedBy = "consulta", orphanRemoval = true)
	@JsonBackReference(value = "id_medicamento")
	private Set<Medication> medicamentosReceitados;

	public Consulta(String data,Diagnostico diagnostico,Paciente paciente) {
		super();
		this.data = data;
		this.diagnostico = diagnostico;
		this.paciente = paciente;
	}
	public Consulta() {
		
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setMedico(Medico medico2) {
		this.medico = medico2;
		
	}
	public String pacienteId() {
		return this.paciente.getCpf();
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Set<Medication> getMedicamentosReceitados() {
		return medicamentosReceitados;
	}
	public void setMedicamentosReceitados(Set<Medication> medicamentosReceitados) {
		this.medicamentosReceitados = medicamentosReceitados;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Medico getMedico() {
		return medico;
	}

}
