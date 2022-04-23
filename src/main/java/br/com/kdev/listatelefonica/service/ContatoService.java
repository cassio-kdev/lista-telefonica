package br.com.kdev.listatelefonica.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.kdev.listatelefonica.model.Contato;
import br.com.kdev.listatelefonica.repository.ContatoRepository;
import br.com.kdev.listatelefonica.service.dto.ContatoDto;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<ContatoDto> listaContatos(){
		List<Contato> todosContatos = contatoRepository.todosContatos();
		ContatoDto dto = new ContatoDto();
		return dto.listaContatoDto(todosContatos);
	}

	public ContatoDto salvar(ContatoDto contatoDto) {
		Contato contato =contatoDto.toContato();
		Contato response = contatoRepository.save(contato);
		return new ContatoDto(response);
	}
	public void delete(Long id) {
		try {
			contatoRepository.deleteById(id);
			
		}catch(EmptyResultDataAccessException ex) {
			System.out.println("passei aqui");
			throw ex;
		}
	}

	public ContatoDto contatosPorId(Long id) throws NoSuchElementException{
		Optional<Contato> find = contatoRepository.findById(id);
		if(find.isPresent()) {
			return new ContatoDto(find.get());
		}
		throw new NoSuchElementException("Não foi localizado o contato com id: " + id);
	}
}
