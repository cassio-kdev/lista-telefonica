package br.com.kdev.listatelefonica.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kdev.listatelefonica.service.OperadoraService;
import br.com.kdev.listatelefonica.service.dto.OperadoraDto;

@RestController
@CrossOrigin("*")
@RequestMapping("/operadoras")
public class OperadoraController {

	@Autowired
	private OperadoraService operadoraService;

	@GetMapping
	public ResponseEntity<?> lista() {
		List<OperadoraDto> operadoras = operadoraService.listaOperadora();
		return ResponseEntity.ok().body(operadoras);
	}

	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody OperadoraDto operadoraDto) {

		OperadoraDto dto = operadoraService.salvar(operadoraDto);
		EntityModel<OperadoraDto> entityModel = EntityModel.of(dto);
		URI uri = null;
		try {
			uri = new URI("localhost:8080/operadoras/"+dto.getId());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("URI: " + uri);
		return ResponseEntity.created(uri).body(entityModel);
	}
}
