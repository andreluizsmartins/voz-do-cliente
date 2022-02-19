package br.com.andremartins.votacaoInterativa.model;



public class Satisfacao {

	
	private int id, id_equipe, count;
	private String letra, numero, comentario, descricao, ajustes, descricaoQuestao, total, tipo, nomerelatorio;
	
	

	public Satisfacao(int id, int id_equipe, String letra, String numero,
			String comentario,  String ajustes,String descricao,
			String descricaoQuestao, String total, String tipo,
			String nomerelatorio) {
		super();
		this.id = id;
		this.id_equipe = id_equipe;
		this.letra = letra;
		this.numero = numero;
		this.comentario = comentario;
		this.descricao = descricao;
		this.ajustes = ajustes;
		this.descricaoQuestao = descricaoQuestao;
		this.total = total;
		this.tipo = tipo;
		this.nomerelatorio = nomerelatorio;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getNomerelatorio() {
		return nomerelatorio;
	}


	public void setNomerelatorio(String nomerelatorio) {
		this.nomerelatorio = nomerelatorio;
	}


	public String getAjustes() {
		return ajustes;
	}


	public void setAjustes(String ajustes) {
		this.ajustes = ajustes;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDescricaoQuestao() {
		return descricaoQuestao;
	}


	public void setDescricaoQuestao(String descricaoQuestao) {
		this.descricaoQuestao = descricaoQuestao;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	

	@Override
	public String toString() {
		return "Satisfacao [id=" + id + ", id_equipe=" + id_equipe + ", letra="
				+ letra + ", numero=" + numero + ", comentario=" + comentario
				+ ", descricao=" + descricao + ", ajustes=" + ajustes
				+ ", descricaoQuestao=" + descricaoQuestao + ", total=" + total
				+ ", tipo=" + tipo + ", nomerelatorio=" + nomerelatorio + "]";
	}


	public Satisfacao(int id, int id_equipe, String letra, String numero,
			String comentario , String descricao, String descricaoQuestao,
			String total) {
		super();
		this.id = id;
		this.id_equipe = id_equipe;
		this.letra = letra;
		this.numero = numero;
		this.comentario = comentario;
		this.descricao = descricao;
		this.descricaoQuestao = descricaoQuestao;
		this.total = total;
	}
	
	public Satisfacao(int id, int id_equipe, String letra, String numero,
			String comentario, String ajustes, String descricao, String descricaoQuestao,
			String total) {
		super();
		this.id = id;
		this.id_equipe = id_equipe;
		this.letra = letra;
		this.numero = numero;
		this.comentario = comentario;
		this.ajustes = ajustes;
		this.descricao = descricao;
		this.descricaoQuestao = descricaoQuestao;
		this.total = total;
	}




	public Satisfacao(int id, int id_equipe, String letra, String numero,
			String comentario) {
		super();
		this.id = id;
		this.id_equipe = id_equipe;
		this.letra = letra;
		this.numero = numero;
		this.comentario = comentario;
	}


	public Satisfacao(int id, int id_equipe, String letra, String numero,
			String comentario, String descricao, String ajustes,
			String descricaoQuestao, String total, String tipo) {
		super();
		this.id = id;
		this.id_equipe = id_equipe;
		this.letra = letra;
		this.numero = numero;
		this.comentario = comentario;
		this.descricao = descricao;
		this.ajustes = ajustes;
		this.descricaoQuestao = descricaoQuestao;
		this.total = total;
		this.tipo = tipo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_equipe() {
		return id_equipe;
	}


	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}


	public String getLetra() {
		return letra;
	}


	public void setLetra(String letra) {
		this.letra = letra;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}


	public Satisfacao() {
		// TODO Auto-generated constructor stub
	}

}
