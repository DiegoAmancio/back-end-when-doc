package whenDoc.whenDOc.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import whenDoc.whenDOc.entity.Alergia;


public interface AlergiasService {
	
	Alergia findById(Long id);
	
	Alergia findByCodPaciente(Long cod_paciente);
	
	List<Alergia> findAll();
	
	HttpStatus save(Alergia newAlergia);
	
	HttpStatus editNomeAlergia(String nomeAlergia, Long id);
	
	HttpStatus delete(Long id);


}
