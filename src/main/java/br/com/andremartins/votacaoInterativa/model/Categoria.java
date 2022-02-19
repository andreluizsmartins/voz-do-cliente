package br.com.andremartins.votacaoInterativa.model;



public class Categoria {

	
	int id, nivel;
	String categorias;
	
	public Categoria(int id, int nivel, String categorias) {
		super();
		this.id = id;
		this.nivel = nivel;
		this.categorias = categorias;
	}

	public Categoria() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getCategorias() {
		return categorias;
	}

	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}

}
