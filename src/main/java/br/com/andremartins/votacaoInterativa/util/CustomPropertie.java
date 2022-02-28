package br.com.andremartins.votacaoInterativa.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("tipodatabase")
public class CustomPropertie {
	private String jdbc;

	public CustomPropertie() {
		
	}

	public String getJdbc() {
		return jdbc;
	}

	public void setJdbc(String jdbc) {
		this.jdbc = jdbc;
	}

	public CustomPropertie(String jdbc) {
		super();
		this.jdbc = jdbc;
	}
	

}
