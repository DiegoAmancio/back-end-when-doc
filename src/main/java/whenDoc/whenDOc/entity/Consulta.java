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

@Entity
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
	
	@NotEmpty()
	@OneToOne(cascade = CascadeType.ALL)
	private Diagnostico diagnostico;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn	
	private Medico medico;
	
	@OneToMany(mappedBy = "consulta", orphanRemoval = true)
	@JsonBackReference(value = "id_medicamento")
	private Set<Medicamento> medicamentosReceitados;

	public Consulta(String data) {
		super();
		this.data = data;
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

}
