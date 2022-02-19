package br.com.andremartins.votacaoInterativa.model;



public class Altenative {

	private int ind;
	private String letter;
	private String text;
	
	public Altenative(int ind, String letter, String text) {
		super();
		this.ind = ind;
		this.letter = letter;
		this.text = text;
	}

	@Override
	public String toString() {
		return "Altenative [ind=" + ind + ", letter=" + letter + ", text="
				+ text + "]";
	}

	public int getInd() {
		return ind;
	}

	public void setInd(int ind) {
		this.ind = ind;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Altenative() {
		// TODO Auto-generated constructor stub
	}

}
