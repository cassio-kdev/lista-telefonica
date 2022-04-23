package br.com.kdev.listatelefonica.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kdev.listatelefonica.service.ContatoService;
import br.com.kdev.listatelefonica.service.dto.ContatoDto;

@RestController
@CrossOrigin("*")
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@GetMapping
	public ResponseEntity<List<ContatoDto>>  contatos() {
		List<ContatoDto> listaContatos = contatoService.listaContatos();
		
		return ResponseEntity.ok().body(listaContatos);
	}

	@PostMapping
	public ResponseEntity<EntityModel<ContatoDto>> salvar(@RequestBody ContatoDto contatoDto) {
		ContatoDto response = contatoService.salvar(contatoDto);

		EntityModel<ContatoDto> entityModel = EntityModel.of(response);
		URI uri = null;
		try {
			uri = new URI("localhost:8080/operadoras/" + response.getId());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("URI: " + uri);
		return ResponseEntity.created(uri).body(entityModel);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			contatoService.delete(id);
			
		}catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
		}
		return ResponseEntity.status(200).build();
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> contatosPorId(@PathVariable Long id) {
		ContatoDto contato = contatoService.contatosPorId(id);
		return ResponseEntity.ok(contato);
	}
}
