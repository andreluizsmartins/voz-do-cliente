package br.com.andremartins.votacaoInterativa.model;



import java.util.ArrayList;

public class PesquisaQuestion {

	private int id, id_pesquisa, alternative_id, question;
	private String ip;
	
	
	public PesquisaQuestion(int id, int id_pesquisa, int question,
			int alternative_id) {
		super();
		this.id = id;
		this.id_pesquisa = id_pesquisa;
		this.question = question;
		this.alternative_id = alternative_id;
	}

	public PesquisaQuestion(int id_pesquisa, int question, int alternative_id) {
		super();
		this.id_pesquisa = id_pesquisa;
		this.question = question;
		this.alternative_id = alternative_id;
	}

	

	@Override
	public String toString() {
		return "PesquisaQuestion [id=" + id + ", id_pesquisa=" + id_pesquisa
				+ ", alternative_id=" + alternative_id + ", question="
				+ question + ", ip=" + ip + "]";
	}

	public PesquisaQuestion(int id, int id_pesquisa, int alternative_id,
			int question, String ip) {
		super();
		
		this.id_pesquisa = id_pesquisa;
		this.alternative_id = alternative_id;
		this.question = question;
		this.ip = ip;
	}

	public int getAlternative_id() {
		return alternative_id;
	}

	public void setAlternative_id(int alternative_id) {
		this.alternative_id = alternative_id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_pesquisa() {
		return id_pesquisa;
	}

	public void setId_pesquisa(int id_pesquisa) {
		this.id_pesquisa = id_pesquisa;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public int getAnswer() {
		return alternative_id;
	}

	public void setAnswer(int alternative_id) {
		this.alternative_id = alternative_id;
	}

	public PesquisaQuestion() {
		// TODO Auto-generated constructor stub
	}

}
