package whenDoc.whenDOc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "alergias")
public class Alergias {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_alergia")
	private Long id;
	
	@Column
	private String nomeAlergia;
	
	@ManyToOne
	@JoinColumn(name="paciente_id", nullable = false)
	private Paciente paciente;
	
	public Alergias() {
		
	}


	public String getNome_Alergia() {
		return nomeAlergia;
	}

	public void setNome_Alergia(String nomeAlergia) {
		this.nomeAlergia = nomeAlergia;
	}

	
}
