package br.com.andremartins.votacaoInterativa.model;



public class Projetos {

	int id, empresa_id, diretoria_id, coordencao_id, nucleo_id, cargo_id, funcao_id, pesquisa_id, secretaria_id, quantidadeResposta;
	String empresa_desc, diretoria_desc, coordencao_desc, nucleo_desc, cargo_desc, funcao_desc, pesquisa_desc, secretaria_desc;
	
	@Override
	public String toString() {
		return "Projetos [id=" + id + ", empresa_id=" + empresa_id
				+ ", diretoria_id=" + diretoria_id + ", coordencao_id="
				+ coordencao_id + ", nucleo_id=" + nucleo_id + ", cargo_id="
				+ cargo_id + ", funcao_id=" + funcao_id + ", pesquisa_id="
				+ pesquisa_id + ", secretaria_id=" + secretaria_id
				+ ", quantidadeResposta=" + quantidadeResposta
				+ ", empresa_desc=" + empresa_desc + ", diretoria_desc="
				+ diretoria_desc + ", coordencao_desc=" + coordencao_desc
				+ ", nucleo_desc=" + nucleo_desc + ", cargo_desc=" + cargo_desc
				+ ", funcao_desc=" + funcao_desc + ", pesquisa_desc="
				+ pesquisa_desc + ", secretaria_desc=" + secretaria_desc + "]";
	}

	public Projetos(int id, String empresa_desc, String diretoria_desc,
			String coordencao_desc, String nucleo_desc, String cargo_desc,
			String funcao_desc, String pesquisa_desc, String secretaria_desc) {
		super();
		this.id = id;
		this.empresa_desc = empresa_desc;
		this.diretoria_desc = diretoria_desc;
		this.coordencao_desc = coordencao_desc;
		this.nucleo_desc = nucleo_desc;
		this.cargo_desc = cargo_desc;
		this.funcao_desc = funcao_desc;
		this.pesquisa_desc = pesquisa_desc;
		this.secretaria_desc = secretaria_desc;
	}

	public Projetos(int id, int empresa_id, int diretoria_id,
			int coordencao_id, int nucleo_id, int cargo_id, int funcao_id,
			int pesquisa_id, int secretaria_id, String empresa_desc, String diretoria_desc,
			String coordencao_desc, String nucleo_desc, String cargo_desc,
			String funcao_desc, String pesquisa_desc, String secretaria_desc) {
		super();
		this.id = id;
		this.empresa_id = empresa_id;
		this.diretoria_id = diretoria_id;
		this.coordencao_id = coordencao_id;
		this.nucleo_id = nucleo_id;
		this.cargo_id = cargo_id;
		this.funcao_id = funcao_id;
		this.pesquisa_id = pesquisa_id;
		this.empresa_desc = empresa_desc;
		this.diretoria_desc = diretoria_desc;
		this.coordencao_desc = coordencao_desc;
		this.nucleo_desc = nucleo_desc;
		this.cargo_desc = cargo_desc;
		this.funcao_desc = funcao_desc;
		this.pesquisa_desc = pesquisa_desc;
		this.secretaria_desc = secretaria_desc;
		this.secretaria_id = secretaria_id;
	}

	public Projetos(int empresa_id, int diretoria_id, int coordencao_id,
			int nucleo_id, int cargo_id, int funcao_id, int pesquisa_id, int secretaria_id) {
		super();
		this.empresa_id = empresa_id;
		this.diretoria_id = diretoria_id;
		this.coordencao_id = coordencao_id;
		this.nucleo_id = nucleo_id;
		this.cargo_id = cargo_id;
		this.funcao_id = funcao_id;
		this.pesquisa_id = pesquisa_id;
		this.secretaria_id = secretaria_id;
	}

	public Projetos(int id, int empresa_id, int diretoria_id,
			int coordencao_id, int nucleo_id, int cargo_id, int funcao_id,
			int pesquisa_id, int secretaria_id) {
		super();
		this.id = id;
		this.empresa_id = empresa_id;
		this.diretoria_id = diretoria_id;
		this.coordencao_id = coordencao_id;
		this.nucleo_id = nucleo_id;
		this.cargo_id = cargo_id;
		this.funcao_id = funcao_id;
		this.pesquisa_id = pesquisa_id;
		this.secretaria_id = secretaria_id;
	}
	
	public int getQuantidadeResposta() {
		return quantidadeResposta;
	}

	public void setQuantidadeResposta(int quantidadeResposta) {
		this.quantidadeResposta = quantidadeResposta;
	}

	public int getSecretaria_id() {
		return secretaria_id;
	}

	public void setSecretaria_id(int secretaria_id) {
		this.secretaria_id = secretaria_id;
	}

	public String getSecretaria_desc() {
		return secretaria_desc;
	}

	public void setSecretaria_desc(String secretaria_desc) {
		this.secretaria_desc = secretaria_desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpresa_id() {
		return empresa_id;
	}

	public void setEmpresa_id(int empresa_id) {
		this.empresa_id = empresa_id;
	}

	public int getDiretoria_id() {
		return diretoria_id;
	}

	public void setDiretoria_id(int diretoria_id) {
		this.diretoria_id = diretoria_id;
	}

	public int getCoordencao_id() {
		return coordencao_id;
	}

	public void setCoordencao_id(int coordencao_id) {
		this.coordencao_id = coordencao_id;
	}

	public int getNucleo_id() {
		return nucleo_id;
	}

	public void setNucleo_id(int nucleo_id) {
		this.nucleo_id = nucleo_id;
	}

	public int getCargo_id() {
		return cargo_id;
	}

	public void setCargo_id(int cargo_id) {
		this.cargo_id = cargo_id;
	}

	public int getFuncao_id() {
		return funcao_id;
	}

	public void setFuncao_id(int funcao_id) {
		this.funcao_id = funcao_id;
	}

	public int getPesquisa_id() {
		return pesquisa_id;
	}

	public void setPesquisa_id(int pesquisa_id) {
		this.pesquisa_id = pesquisa_id;
	}

	public String getEmpresa_desc() {
		return empresa_desc;
	}

	public void setEmpresa_desc(String empresa_desc) {
		this.empresa_desc = empresa_desc;
	}

	public String getDiretoria_desc() {
		return diretoria_desc;
	}

	public void setDiretoria_desc(String diretoria_desc) {
		this.diretoria_desc = diretoria_desc;
	}

	public String getCoordencao_desc() {
		return coordencao_desc;
	}

	public void setCoordencao_desc(String coordencao_desc) {
		this.coordencao_desc = coordencao_desc;
	}

	public String getNucleo_desc() {
		return nucleo_desc;
	}

	public void setNucleo_desc(String nucleo_desc) {
		this.nucleo_desc = nucleo_desc;
	}

	public String getCargo_desc() {
		return cargo_desc;
	}

	public void setCargo_desc(String cargo_desc) {
		this.cargo_desc = cargo_desc;
	}

	public String getFuncao_desc() {
		return funcao_desc;
	}

	public void setFuncao_desc(String funcao_desc) {
		this.funcao_desc = funcao_desc;
	}

	public String getPesquisa_desc() {
		return pesquisa_desc;
	}

	public void setPesquisa_desc(String pesquisa_desc) {
		this.pesquisa_desc = pesquisa_desc;
	}

	public Projetos() {
		// TODO Auto-generated constructor stub
	}

}
