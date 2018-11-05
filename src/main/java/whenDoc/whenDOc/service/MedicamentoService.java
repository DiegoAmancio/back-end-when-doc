package whenDoc.whenDOc.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import whenDoc.whenDOc.entity.Medication;

public interface MedicamentoService {
	
	Medication findById(Long id);
	
	Medication findByName(String nome);
	
	List<Medication> findAll();
	
	HttpStatus save(Medication newMedicamento);
	
	HttpStatus editNome(String nome, Long id);
	
	// apenas o medico pode alterar a quantidade.
	HttpStatus editQuantidade(String quantidade, Long id);
	
	HttpStatus editHorario(String horario, Long id);
	
	HttpStatus editIntervalo(String intervalo, Long id);
	
	HttpStatus editDataInicial(String dataInicial, Long id);
	
	HttpStatus editDataFinal(String dataFinal, Long id);
	
	// apenas o medico pode alterar a dosagem.
	HttpStatus editDosagem(String dosagem, Long id);
	
	HttpStatus delete(Long id);
}
