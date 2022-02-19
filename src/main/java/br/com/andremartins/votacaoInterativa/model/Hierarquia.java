package br.com.andremartins.votacaoInterativa.model;



public class Hierarquia {

	
	

	public Hierarquia(int id, int codCategorias, int parentId, String descricao) {
		super();
		this.id = id;
		this.codCategorias = codCategorias;
		this.parentId = parentId;
		this.descricao = descricao;
	}



	int id, codCategorias, parentId;
	String descricao, categoria;
	
	public Hierarquia() {
		// TODO Auto-generated constructor stub
	}

	public Hierarquia(int id, int codCategorias, int parentId,
			String descricao, String categoria) {
		super();
		this.id = id;
		this.codCategorias = codCategorias;
		this.parentId = parentId;
		this.descricao = descricao;
		this.categoria = categoria;
	}



	public Hierarquia( int codCategorias, int parentId, String descricao) {
		super();
		
		this.codCategorias = codCategorias;
		this.parentId = parentId;
		this.descricao = descricao;
	}
	
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodCategorias() {
		return codCategorias;
	}

	public void setCodCategorias(int codCategorias) {
		this.codCategorias = codCategorias;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
