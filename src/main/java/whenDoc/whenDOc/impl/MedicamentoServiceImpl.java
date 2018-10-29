package whenDoc.whenDOc.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import whenDoc.whenDOc.entity.Medicamento;
import whenDoc.whenDOc.repository.MedicamentoRepository;
import whenDoc.whenDOc.service.MedicamentoService;

@Service
public class MedicamentoServiceImpl implements MedicamentoService {
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@Override
	public Medicamento findById(Long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		if(medicamento.isPresent()) {
			return medicamento.get();
		}
		return new Medicamento();
	}

	@Override
	public Medicamento findByName(String nome) {
		for (Medicamento medicamento : medicamentoRepository.findAll()) {
			String nomeMedicamento = medicamento.getNome();
			
			if (nomeMedicamento.equals(nome)) {
				return medicamento;
			}
		}
		return null;
	}

	@Override
	public List<Medicamento> findAll() {
		return medicamentoRepository.findAll();
	}

	@Override
	public HttpStatus save(Medicamento newMedicamento) {
		try {
			Medicamento medicamento = new Medicamento(newMedicamento.getNome(), newMedicamento.getQuantidade(), newMedicamento.getHorario(),
					newMedicamento.getIntervalo(), newMedicamento.getDataInicial(), newMedicamento.getDataFinal(), newMedicamento.getDosagem());
			medicamentoRepository.save(medicamento);
			return HttpStatus.OK;
		} catch (Exception e) {
			return HttpStatus.BAD_REQUEST;
		}
	}

	@Override
	public HttpStatus editNome(String nome, Long id) {
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		if (medicamento.isPresent()) {
			medicamento.get().setNome(nome);
			medicamentoRepository.save(medicamento.get());
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editQuantidade(String quantidade, Long id) {
		Medicamento medicamento = findById(id);
		
		if (medicamento != null) {
			medicamento.setQuantidade(quantidade);
			medicamentoRepository.save(medicamento);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editHorario(String horario, Long id) {
		Medicamento medicamento = findById(id);
		
		if (medicamento != null) {
			medicamento.setHorario(horario);
			medicamentoRepository.save(medicamento);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editIntervalo(String intervalo, Long id) {
		Medicamento medicamento = findById(id);
		
		if (medicamento != null) {
			medicamento.setIntervalo(intervalo);
			medicamentoRepository.save(medicamento);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editDataInicial(String dataInicial, Long id) {
		Medicamento medicamento = findById(id);
		
		if (medicamento != null) {
			medicamento.setDataInicial(dataInicial);
			medicamentoRepository.save(medicamento);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editDataFinal(String dataFinal, Long id) {
		Medicamento medicamento = findById(id);
		
		if (medicamento != null) {
			medicamento.setDataFinal(dataFinal);
			medicamentoRepository.save(medicamento);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus editDosagem(String dosagem, Long id) {
		Medicamento medicamento = findById(id);
		
		if (medicamento != null) {
			medicamento.setDosagem(dosagem);
			medicamentoRepository.save(medicamento);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}

	@Override
	public HttpStatus delete(Long id) {
		if (medicamentoRepository.existsById(id)) {
			medicamentoRepository.deleteById(id);
			return HttpStatus.OK;
		} else {
			return HttpStatus.NOT_FOUND;
		}
	}
}

