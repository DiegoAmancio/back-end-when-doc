package whenDoc.whenDOc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Alergia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3426504371498240433L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_alergia")
	private Long id;
	
	@Column
	private String nomeAlergia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn	
	private Paciente paciente;
	
	
	public Alergia() {
		
	}


	public String getNome_Alergia() {
		return nomeAlergia;
	}

	public void setNome_Alergia(String nomeAlergia) {
		this.nomeAlergia = nomeAlergia;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
		
	}

	
}
