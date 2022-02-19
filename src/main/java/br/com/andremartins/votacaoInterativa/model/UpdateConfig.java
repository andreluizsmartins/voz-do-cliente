package br.com.andremartins.votacaoInterativa.model;



public class UpdateConfig {

	private String validaQuestao, validaIp, question;
	
	public UpdateConfig() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UpdateConfig [validaQuestao=" + validaQuestao + ", validaIp="
				+ validaIp + "]";
	}

	public UpdateConfig(String validaQuestao, String validaIp) {
		super();
		this.validaQuestao = validaQuestao;
		this.validaIp = validaIp;
	}

	public UpdateConfig(String question) {
		super();
		this.question = question;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getValidaQuestao() {
		return validaQuestao;
	}

	public void setValidaQuestao(String validaQuestao) {
		this.validaQuestao = validaQuestao;
	}

	public String getValidaIp() {
		return validaIp;
	}

	public void setValidaIp(String validaIp) {
		this.validaIp = validaIp;
	}

}
