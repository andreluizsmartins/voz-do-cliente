package br.com.andremartins.votacaoInterativa.model;



public class Projeto {

	
	String nomerelatorio, nomerelatorio2, tipo;
	
	
	public Projeto(String nomerelatorio, String tipo) {
		super();
		this.nomerelatorio = nomerelatorio;
		this.tipo = tipo;
	}


	public String getNomerelatorio2() {
		return nomerelatorio2;
	}


	public void setNomerelatorio2(String nomerelatorio2) {
		this.nomerelatorio2 = nomerelatorio2;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Projeto(String nomerelatorio) {
		super();
		this.nomerelatorio = nomerelatorio;
	}


	public String getNomerelatorio() {
		return nomerelatorio;
	}


	public void setNomerelatorio(String nomerelatorio) {
		this.nomerelatorio = nomerelatorio;
	}


	public Projeto() {
		// TODO Auto-generated constructor stub
	}

}
