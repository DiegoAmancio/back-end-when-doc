package whenDoc.whenDOc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "diagnostico")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Diagnostico implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_diagnostico")
	private Long id;
	
	@NotEmpty()
	@Column()
	private String nomeDiagnostico;
	
	@NotEmpty()
	@Column()
	private String descricao;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Consulta consulta;

	

	public Diagnostico(@NotEmpty String nomeDiagnostico, @NotEmpty String descricao) {
		super();
		this.nomeDiagnostico = nomeDiagnostico;
		this.descricao = descricao;
	}
	public Diagnostico() {
		
	}

	public String getNomeDiagnostico() {
		return nomeDiagnostico;
	}

	public void setNomeDiagnostico(String nomeDiagnostico) {
		this.nomeDiagnostico = nomeDiagnostico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
