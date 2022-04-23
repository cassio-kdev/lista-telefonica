package br.com.kdev.listatelefonica.service.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import br.com.kdev.listatelefonica.model.Contato;
import br.com.kdev.listatelefonica.model.Operadora;

public class ContatoDto {

	private Long id;
	private String nome;
	private String telefone;
	private LocalDateTime data;
	private OperadoraDto operadoraDto;
	private String serial;
	
	public ContatoDto(Long id, String nome, String telefone, LocalDateTime data,OperadoraDto operadoraDto, String serial) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.data = data;
		this.operadoraDto = operadoraDto;
		this.serial = serial;
	}

	public ContatoDto() {
	}

	public ContatoDto(Contato response) {
		this.id = response.getId();
		this.nome = response.getNome();
		this.telefone = response.getNome();
		this.data = response.getData();
		this.operadoraDto = new OperadoraDto(response.getOperadora());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}

	public OperadoraDto getOperadoraDto() {
		return operadoraDto;
	}

	public void setOperadoraDto(OperadoraDto operadoraDto) {
		this.operadoraDto = operadoraDto;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public List<ContatoDto> listaContatoDto(List<Contato> contatos) {
		
		List<ContatoDto> lista = new ArrayList<>();
		
		contatos.forEach(contato -> {
			Operadora operadora = contato.getOperadora();
			OperadoraDto operadoraDto = new OperadoraDto(operadora);
			ContatoDto dto = new ContatoDto(
					contato.getId(),
					contato.getNome(),
					contato.getTelefone(), 
					contato.getData(),
					operadoraDto, 
					contato.getSerial());
			lista.add(dto);
		});
		return lista;
	}

	public Contato toContato() {
		return new Contato(this.id,this.nome, this.telefone,this.data, this.operadoraDto.toOperadora(), this.serial);
	}


	public static void main(String[] args) {
		System.out.println(LocalDateTime.parse("1286679600000"));
		System.out.println( LocalDateTime.ofInstant(Instant.ofEpochMilli(1286679600000l), ZoneId.systemDefault()));
	}
}
