package br.com.andremartins.votacaoInterativa.model;



import java.util.ArrayList;

public class Question {

	private int id, type;
	private String question;
	private String commentary;
	private ArrayList<Altenative> alternatives;
	
	public ArrayList<Altenative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(ArrayList<Altenative> alternatives) {
		this.alternatives = alternatives;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question
				+ ", commentary=" + commentary + "]";
	}

	public Question(int id, String question, String commentary) {
		super();
		this.id = id;
		this.question = question;
		this.commentary = commentary;
	}

	public Question(int id, int type, String question, String commentary) {
		super();
		this.id = id;
		this.type = type;
		this.question = question;
		this.commentary = commentary;
		
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public Question() {
		// TODO Auto-generated constructor stub
	}

}
