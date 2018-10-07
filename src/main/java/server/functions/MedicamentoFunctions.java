package server.functions;

import java.util.List;
import org.springframework.http.HttpStatus;

import server.entities.Medicamento;

public interface MedicamentoFunctions {
	
	Medicamento findById(Long id);
	
	Medicamento findByName(String nome);
	
	List<Medicamento> findAll();
	
	HttpStatus save(Medicamento newMedicamento);
	
	HttpStatus editNome(String nome, Long id);
	
	// apenas o medico pode alterar a quantidade.
	HttpStatus editQuantidade(Integer quantidade, Long id);
	
	HttpStatus editHorario(String horario, Long id);
	
	HttpStatus editIntervalo(String intervalo, Long id);
	
	HttpStatus editDataInicial(String dataInicial, Long id);
	
	HttpStatus editDataFinal(String dataFinal, Long id);
	
	// apenas o medico pode alterar a dosagem.
	HttpStatus editDosagem(float dosagem, Long id);
	
	HttpStatus delete(Long id);
}
