package br.com.andremartins.votacaoInterativa.model;



public class PesquisaConciliacao {
	int id;
	private String equipe, numero, descricaoquestao, letra, descricao, ajustes, total; 
	public PesquisaConciliacao(String equipe, String numero,
			String descricaoQuestao, String letra, String descricao,
			String total) {
		super();
		this.equipe = equipe;
		this.numero = numero;
		this.descricaoquestao = descricaoQuestao;
		this.letra = letra;
		this.descricao = descricao;
		this.total = total;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescricaoquestao() {
		return descricaoquestao;
	}


	public void setDescricaoquestao(String descricaoquestao) {
		this.descricaoquestao = descricaoquestao;
	}


	public String getAjustes() {
		return ajustes;
	}


	public void setAjustes(String ajustes) {
		this.ajustes = ajustes;
	}


	public PesquisaConciliacao(String equipe, String numero,
			String descricaoquestao, String letra, String descricao,
			String ajustes, String total) {
		super();
		this.equipe = equipe;
		this.numero = numero;
		this.descricaoquestao = descricaoquestao;
		this.letra = letra;
		this.descricao = descricao;
		this.ajustes = ajustes;
		this.total = total;
	}


	public PesquisaConciliacao() {
		// TODO Auto-generated constructor stub
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescricaoQuestao() {
		return descricaoquestao;
	}
	public void setDescricaoQuestao(String descricaoQuestao) {
		this.descricaoquestao = descricaoquestao;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "PesquisaConciliacao [equipe=" + equipe + ", numero=" + numero
				+ ", descricaoQuestão=" + descricaoquestao + ", letra=" + letra
				+ ", descricao=" + descricao + ", total=" + total + "]";
	}

}
