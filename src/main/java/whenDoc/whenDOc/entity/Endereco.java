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


@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {
	
	@Transient
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_endereco")
	private Long id;
	
	@NotEmpty()
	@Column(name = "rua")
	private String rua;
	
	@NotEmpty()
	@Column(name = "bairro")
	private String bairro;
	
	@NotEmpty()
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "complemento")
	private String complemento;
	
	@NotEmpty()
	@Column(name = "cidade")
	private String cidade;
	
	@NotEmpty()
	@Column(name = "estado")
	private String estado;
	
	@NotEmpty()
	@Column(name = "pais")
	private String pais;
	
	@NotEmpty()
	@Column(name = "cep")
	private String cep;
	

	@OneToOne
	@PrimaryKeyJoinColumn
	private Paciente paciente;

	

	public Endereco() {
		
	}
	
	
	


	public Endereco(@NotEmpty String rua, @NotEmpty String bairro, @NotEmpty String numero, String complemento,
			@NotEmpty String cidade, @NotEmpty String estado, @NotEmpty String pais, @NotEmpty String cep) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}





	public String getRua() {
		return rua;
	}

	

	public String getBairro() {
		return bairro;
	}

	

	public String getNumero() {
		return numero;
	}

	

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	

	public String getEstado() {
		return estado;
	}

	

	public String getPais() {
		return pais;
	}

	

	public String getCep() {
		return cep;
	}

	

	
}
