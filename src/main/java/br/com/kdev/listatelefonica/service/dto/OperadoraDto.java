package br.com.kdev.listatelefonica.service.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.kdev.listatelefonica.model.Operadora;

public class OperadoraDto {

	private Long id;
	private String nome;
	private Integer codigo;
	private String categoria;
	private BigDecimal preco;
	
	public OperadoraDto() {}
	public OperadoraDto(Operadora operadora) {
		this.id = operadora.getId();
		this.nome = operadora.getNome();
		this.codigo = operadora.getCodigo();
		this.categoria = operadora.getCategoria();
		this.preco = operadora.getPreco();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Operadora toOperadora() {
		return new Operadora(this.nome, this.categoria, this.codigo, this.id);
	}
	public List<OperadoraDto> listaContatoDto(List<Operadora> operadoras) {
		List<OperadoraDto> lista = new ArrayList<>();
		operadoras.forEach(operadora -> {
			OperadoraDto dto = new OperadoraDto(operadora);
			lista.add(dto);
		});
		return lista;
	}
	
}
