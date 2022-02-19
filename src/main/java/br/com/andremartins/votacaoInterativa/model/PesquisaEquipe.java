package br.com.andremartins.votacaoInterativa.model;

import java.util.Date;

public class PesquisaEquipe {

	private int id, qtdResposta, qtde, index, count;
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private String nomeequipe, consultor, status;
	private String data;
	


	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	
	public int getQtdResposta() {
		return qtdResposta;
	}

	public void setQtdResposta(int qtdResposta) {
		this.qtdResposta = qtdResposta;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeequipe() {
		return nomeequipe;
	}

	public void setNomeequipe(String nomeequipe) {
		this.nomeequipe = nomeequipe;
	}

	public String getConsultor() {
		return consultor;
	}

	public void setConsultor(String consultor) {
		this.consultor = consultor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PesquisaEquipe [id=" + id + ", nomeequipe=" + nomeequipe
				+ ", consultor=" + consultor + ", status=" + status + ", data="
				+ data + "]";
	}

	public PesquisaEquipe(String nomeequipe, String consultor,
			String status, String data, int qtde) {
		super();
		
		this.nomeequipe = nomeequipe;
		this.consultor = consultor;
		this.status = status;
		this.data = data;
		this.qtde = qtde;
	}

	public PesquisaEquipe(int id, String nomeequipe, String consultor,
			String status, String data, int qtde) {
		super();
		this.id = id;
		this.nomeequipe = nomeequipe;
		this.consultor = consultor;
		this.status = status;
		this.data = data;
		this.qtde = qtde;
	}

	public PesquisaEquipe() {
		// TODO Auto-generated constructor stub
	}

	public PesquisaEquipe(int id, int qtdResposta, String nomeequipe,
			String consultor, String status, String data, int qtde, int index) {
		super();
		this.id = id;
		this.qtdResposta = qtdResposta;
		this.nomeequipe = nomeequipe;
		this.consultor = consultor;
		this.status = status;
		this.data = data;
		this.qtde = qtde;
		this.index = index;
	}

}
