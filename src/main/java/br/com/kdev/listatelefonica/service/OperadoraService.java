package br.com.kdev.listatelefonica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kdev.listatelefonica.model.Operadora;
import br.com.kdev.listatelefonica.repository.OperadoraRepository;
import br.com.kdev.listatelefonica.service.dto.OperadoraDto;

@Service
public class OperadoraService {

	@Autowired
	private OperadoraRepository operadoraRepository;

	public List<OperadoraDto> listaOperadora() {
		List<Operadora> operadoras = operadoraRepository.findAll();

		OperadoraDto dto = new OperadoraDto();
		return dto.listaContatoDto(operadoras);
	}

	public OperadoraDto salvar(OperadoraDto operadoraDto) {

		Operadora operadora = operadoraDto.toOperadora();
		Operadora response = operadoraRepository.save(operadora);
		return new OperadoraDto(response);
	}

}
