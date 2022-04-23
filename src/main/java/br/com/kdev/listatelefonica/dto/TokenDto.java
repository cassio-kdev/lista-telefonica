package br.com.kdev.listatelefonica.dto;

public class TokenDto {

	private String token;
	private String tipo;
	private String dataValidade;

	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}

	public TokenDto(String token, String tipo, String dataValidade) {
		this.token = token;
		this.tipo = tipo;
		this.dataValidade = dataValidade;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
}
