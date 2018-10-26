package whenDoc.whenDOc.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import java.io.Serializable;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Entity
public class Medicamento implements Serializable{
	
	@Transient
	private static final long serialVersionUID= 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_medicamento")
	private Long id;
	
	@NotEmpty()
	@Column()
	private String nome;
	
	@NotEmpty()
	@Column()
	private String quantidade;
	
	@NotEmpty()
	@Column()
	private String horario;
	
	@NotEmpty()
	@Column()
	private String intervalo;
	
	@NotEmpty()
	@Column()
	private String dataInicial;
	
	@NotEmpty()
	@Column()
	private String dataFinal;
	
	@NotEmpty()
	@Column()
	private String dosagem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn	
	private Paciente paciente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn	
	private Consulta consulta;
	
	
	@Column()
	private boolean active;

	public Medicamento(String nome, String quantidade, String horario,
			 String intervalo, String dataInicial, String dataFinal,
			 String dosagem) {
		super();
		this.nome = nome;
		this.quantidade = quantidade;
		this.horario = horario;
		this.intervalo = intervalo;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.dosagem = dosagem;
		this.active = true;
	}

	public Medicamento() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDosagem() {
		return dosagem;
	}

	public void setDosagem(String dosagem) {
		this.dosagem = dosagem;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
