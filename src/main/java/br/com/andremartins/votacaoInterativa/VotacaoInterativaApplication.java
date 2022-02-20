package br.com.andremartins.votacaoInterativa;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import br.com.andremartins.votacaoInterativa.dao.ProjetosDao;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;

@SpringBootApplication
@Controller
public class VotacaoInterativaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotacaoInterativaApplication.class, args);
		
	}

}
