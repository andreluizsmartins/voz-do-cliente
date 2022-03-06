package br.com.andremartins.votacaoInterativa;

import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.andremartins.votacaoInterativa.dao.CateoriaDao;
import br.com.andremartins.votacaoInterativa.dao.HierarquiaDao;
import br.com.andremartins.votacaoInterativa.dao.PesquisaConciliacaoDao;
import br.com.andremartins.votacaoInterativa.dao.PesquisaEquipeDao;
import br.com.andremartins.votacaoInterativa.dao.PesquisaQuestionDao;
import br.com.andremartins.votacaoInterativa.dao.ProjetosDao;
import br.com.andremartins.votacaoInterativa.dao.QuestionDao;
import br.com.andremartins.votacaoInterativa.dao.SatisfacaoDao;
import br.com.andremartins.votacaoInterativa.model.Categoria;
import br.com.andremartins.votacaoInterativa.model.Hierarquia;
import br.com.andremartins.votacaoInterativa.model.PesquisaConciliacao;
import br.com.andremartins.votacaoInterativa.model.PesquisaEquipe;
import br.com.andremartins.votacaoInterativa.model.PesquisaQuestion;
import br.com.andremartins.votacaoInterativa.model.PesquisaQuestionMultipla;
import br.com.andremartins.votacaoInterativa.model.Projeto;
import br.com.andremartins.votacaoInterativa.model.Projetos;
import br.com.andremartins.votacaoInterativa.model.Question;
import br.com.andremartins.votacaoInterativa.model.Satisfacao;
import br.com.andremartins.votacaoInterativa.model.pesquisaFollow;
import br.com.andremartins.votacaoInterativa.util.*;

@Controller
public class VotacaoInterativaController {

	@RequestMapping("/")
	public String index3(Model model, HttpSession session) {
		Random gerador = new Random();
		
		if(session.getAttribute("sessionIP") == null){
		
		session.setAttribute("sessionIP", gerador.nextInt());
		session.setMaxInactiveInterval(20*60);
		
		}
		
		return "redirect:/p?id=1";

	}
	@RequestMapping("/teste99")
	public String index4(Model model, HttpSession session) {
		
		
		return "index";

	}
	
	@RequestMapping("/hie")
	public String index41(Model model, @RequestParam(value = "falhou", required = false) String falhou, HttpSession session) {

		CateoriaDao dao = new CateoriaDao();
		HierarquiaDao hieDao = new HierarquiaDao();
		
		
			
			model.addAttribute("falhouEntidade", falhou);
			
		
		ArrayList<Categoria> categorias = dao.listarTodasCategorias();
		ArrayList<Hierarquia> hie = hieDao.listarTodasHierarquias();
		ProjetosDao projDao = new ProjetosDao();
		PesquisaEquipeDao daoP = new PesquisaEquipeDao();
		model.addAttribute("projetos", projDao.listarTodosProjetos());
		model.addAttribute("pesquisas", daoP.listarTodasPesquisas());
		model.addAttribute("empresas", hieDao.listarUnicaHierarquias(1) );
		model.addAttribute("secretarias", hieDao.listarUnicaHierarquias(2) );
		model.addAttribute("diretorias", hieDao.listarUnicaHierarquias(3) );
		model.addAttribute("coordenacoes", hieDao.listarUnicaHierarquias(4) );
		model.addAttribute("nucleos", hieDao.listarUnicaHierarquias(5) );
		model.addAttribute("cargos", hieDao.listarUnicaHierarquias(6) );
		model.addAttribute("funcoes", hieDao.listarUnicaHierarquias(7) );
		model.addAttribute("satisfacoes", SatisfacaoDao.listarSatisfacaoProjeto() );
		model.addAttribute("insatisfacoes", SatisfacaoDao.listarInsatisfacaoProjeto() );
		model.addAttribute("hierarquias", hie);
		model.addAttribute("categorias", categorias);
		
		
		
		return "cadastrohierarquia";

	}
	
	
	@RequestMapping(value = "/validacao", method = RequestMethod.GET)
	public String validacao(Model model, @RequestParam(value = "id", required = false) int id, HttpSession session) {

		ArrayList<PesquisaQuestion> pesquisas1 = PesquisaQuestionDao.validacaoPesquisa(id,1);
		ArrayList<PesquisaQuestion> pesquisas2 = PesquisaQuestionDao.validacaoPesquisa(id,2);
		ArrayList<PesquisaQuestion> pesquisas3 = PesquisaQuestionDao.validacaoPesquisa(id,3);
		ArrayList<PesquisaQuestion> pesquisas4 = PesquisaQuestionDao.validacaoPesquisa(id,4);
		ArrayList<PesquisaQuestion> pesquisas5 = PesquisaQuestionDao.validacaoPesquisa(id,5);
		ArrayList<PesquisaQuestion> pesquisas6 = PesquisaQuestionDao.validacaoPesquisa(id,6);
		ArrayList<PesquisaQuestion> pesquisas7 = PesquisaQuestionDao.validacaoPesquisa(id,7);
		ArrayList<PesquisaQuestion> pesquisas8 = PesquisaQuestionDao.validacaoPesquisa(id,8);
		ArrayList<PesquisaQuestion> pesquisas9 = PesquisaQuestionDao.validacaoPesquisa(id,9);
		ArrayList<PesquisaQuestion> pesquisas10 = PesquisaQuestionDao.validacaoPesquisa(id,10);
		ArrayList<PesquisaQuestion> pesquisas11 = PesquisaQuestionDao.validacaoPesquisa(id,11);
		ArrayList<PesquisaQuestion> pesquisas12 = PesquisaQuestionDao.validacaoPesquisa(id,12);
		ArrayList<PesquisaQuestion> pesquisas13 = PesquisaQuestionDao.validacaoPesquisa(id,13);
		ArrayList<PesquisaQuestion> pesquisas14 = PesquisaQuestionDao.validacaoPesquisa(id,14);
		ArrayList<PesquisaQuestion> pesquisas15= PesquisaQuestionDao.validacaoPesquisa(id,15);
		ArrayList<PesquisaQuestion> pesquisas16 = PesquisaQuestionDao.validacaoPesquisa(id,16);
		ArrayList<PesquisaQuestion> pesquisas17 = PesquisaQuestionDao.validacaoPesquisa(id,17);
		ArrayList<PesquisaQuestion> pesquisas18 = PesquisaQuestionDao.validacaoPesquisa(id,18);
		ArrayList<PesquisaQuestion> pesquisas19 = PesquisaQuestionDao.validacaoPesquisa(id,19);
		ArrayList<PesquisaQuestion> pesquisas20 = PesquisaQuestionDao.validacaoPesquisa(id,20);
		ArrayList<PesquisaQuestion> pesquisas21 = PesquisaQuestionDao.validacaoPesquisa(id,21);
		ArrayList<PesquisaQuestion> pesquisas22 = PesquisaQuestionDao.validacaoPesquisa(id,22);
		ArrayList<PesquisaQuestion> pesquisas23 = PesquisaQuestionDao.validacaoPesquisa(id,23);
		
		
			
			
		model.addAttribute("pesquisas1", pesquisas1);
		model.addAttribute("pesquisas2", pesquisas2);
		model.addAttribute("pesquisas3", pesquisas3);
		model.addAttribute("pesquisas4", pesquisas4);
		model.addAttribute("pesquisas5", pesquisas5);
		model.addAttribute("pesquisas6", pesquisas6);
		model.addAttribute("pesquisas7", pesquisas7);
		model.addAttribute("pesquisas8", pesquisas8);
		model.addAttribute("pesquisas9", pesquisas9);
		model.addAttribute("pesquisas10", pesquisas10);
		model.addAttribute("pesquisas11", pesquisas11);
		model.addAttribute("pesquisas12", pesquisas12);
		model.addAttribute("pesquisas13", pesquisas13);
		model.addAttribute("pesquisas14", pesquisas14);
		model.addAttribute("pesquisas15", pesquisas15);
		model.addAttribute("pesquisas16", pesquisas16);
		model.addAttribute("pesquisas17", pesquisas17);
		model.addAttribute("pesquisas18", pesquisas18);
		model.addAttribute("pesquisas19", pesquisas19);
		
		
		
		
		return "follow2";

	}

	@RequestMapping(value = "/p", method = RequestMethod.GET)
	public String index(Model model,
			@RequestParam(value = "id", required = false) int id, HttpSession session) {
		
		
		if(session.getAttribute("sessionIP") == null){
			
			return "redirect:/";
			
			}
		
		QuestionDao dao = new QuestionDao();
		PesquisaEquipeDao pDao = new PesquisaEquipeDao();
		ArrayList<Question> question = dao.listarTodasQuestoes();

		ArrayList<PesquisaEquipe> pesquisas = pDao.listarPesquisaAtivaArray();

		if (pesquisas.size() == 0) {

			System.out
					.println("[Alerta] Houve a tentativa de acessar uma pesquisa. Porém, não há pesquisa habilitada a ser respondida. Ative uma pesquisa.");

			return "pesquisaout";
			
		}else if(pesquisas.size() == 1){
	
		String multi = "note";
		model.addAttribute("contatos", dao.listarUmaQuestao(id));
		model.addAttribute("multi", multi);
		model.addAttribute("proximo", id + 1);
		model.addAttribute("pesquisa", pDao.listarPesquisaAtivaArray().get(0));

		System.out
				.println("[Alerta] Um dispositivo acaba de acessar uma pesquisa ativa. "+ session.getAttribute("sessionIP").toString()+" , "+ session.getMaxInactiveInterval());

		
		if(id  == 40 ){
			
			PesquisaQuestionDao.validaPesquisaCompleta(pDao.listarPesquisaAtivaArray().get(0).getId());
			
			return "pesquisasalva"; 
			
		}else if (dao.listarUmaQuestao(id).get(0).getType() == 1) {

			return "pesquisa-pagina";

		} else if (dao.listarUmaQuestao(id).get(0).getType() == 2) {

			return "pesquisa-pagina-multipla";
		}

		return "pesquisaout";
		
		}else if(pesquisas.size() > 1){
			
			model.addAttribute("pesquisas", pDao.listarPesquisaAtivaArray());
			return "pesquisa-pagina-escolha";
		
		}
		
		return "pesquisaout";
		
		
	}

	@RequestMapping(value = "/pesquisaescolha", method = RequestMethod.GET)
	public String pesquisaescolha(Model model,
			@RequestParam(value = "id", required = false) int id,
			@RequestParam(value = "pesquisa", required = false) int pesquisaId, HttpSession session) {

		QuestionDao dao = new QuestionDao();
		PesquisaEquipeDao pDao = new PesquisaEquipeDao();
		ArrayList<Question> question = dao.listarTodasQuestoes();

		PesquisaEquipe pesquisa = pDao.listarPesquisaAtivaUnica(pesquisaId);

		if (pesquisa == null) {

			System.out
					.println("[Alerta] Houve a tentativa de acessar uma pesquisa. Porém, não há pesquisa habilitada a ser respondida. Ative uma pesquisa.");

			return "pesquisaout";
		}
		String multi = "multi";
		model.addAttribute("contatos", dao.listarUmaQuestao(id));
		model.addAttribute("multi", multi);
		model.addAttribute("proximo", id + 1);
		model.addAttribute("pesquisa", pDao.listarPesquisaAtivaUnica(pesquisaId));

		System.out
				.println("[Alerta] Um dispositivo acaba de acessar uma pesquisa ativa.");

		
		if(id  == 40 ){
			
			return "pesquisasalva"; 
			
		}else if (dao.listarUmaQuestao(id).get(0).getType() == 1) {

			return "pesquisa-pagina";

		} else if (dao.listarUmaQuestao(id).get(0).getType() == 2) {

			return "pesquisa-pagina-multipla";
		}

		return "pesquisaout";
		
		
		
	}
	@RequestMapping("/q")
	public String index2(Model model, HttpSession session) {

		QuestionDao dao = new QuestionDao();
		PesquisaEquipeDao pDao = new PesquisaEquipeDao();
		ArrayList<Question> question = dao.listarTodasQuestoes();

		PesquisaEquipe pesquisa = pDao.listarPesquisaAtiva();

		if (pesquisa == null) {

			System.out
					.println("[Alerta] Houve a tentativa de acessar uma pesquisa. Porém, não há pesquisa habilitada a ser respondida. Ative uma pesquisa.");

			return "pesquisaout";
		}

		model.addAttribute("contatos", dao.listarTodasQuestoes());
		model.addAttribute("pesquisa", pDao.listarPesquisaAtiva());

		System.out
				.println("[Alerta] Um dispositivo acaba de acessar uma pesquisa ativa.");

		return "pesquisa";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("NomeEquipe") String nomeEquipe,
			@RequestParam("data") String data,
			@RequestParam("consultor") String consultor,
			@RequestParam("numero") int qtde, Model model, HttpSession session) {

		PesquisaEquipe pesquisa = new PesquisaEquipe(nomeEquipe, consultor,
				"Inativo", data, qtde);

		PesquisaEquipeDao dao = new PesquisaEquipeDao();

		dao.inserePesquisa(pesquisa);

		System.out.println("Pesquisa para a equipe " + nomeEquipe
				+ " cadastrada com sucesso");

		return "redirect:/cadastro";
	}

	@RequestMapping("/cadastro")
	public String cadastroEquipe(Model model, HttpSession session) {
		PesquisaEquipeDao dao = new PesquisaEquipeDao();
		model.addAttribute("pesquisas", dao.listarTodasPesquisas());
		
		
		
			model.addAttribute("validaQuestoes", Utils.consultaValidaQuestao());
			model.addAttribute("validaIp", Utils.consultaValidaIp());
	
		
		

		return "cadastrarpesquisa";
	}
	
	@RequestMapping("/arquivo")
	public String arquivoEquipe(Model model, HttpSession session) {
		PesquisaEquipeDao dao = new PesquisaEquipeDao();
		model.addAttribute("pesquisas", dao.listarTodasPesquisasArquivada());
		
		
		
			model.addAttribute("validaQuestoes", Utils.consultaValidaQuestao());
			model.addAttribute("validaIp", Utils.consultaValidaIp());
	
		
		

		return "arquivarpesquisa";
	}
	
	

	@RequestMapping(value = "/validaip", method = RequestMethod.GET)
	public String validaIP(Model model, @RequestParam("id") String id, HttpSession session) {

		Utils.atualizarValidaIP(id);

		System.out.println("[Sucesso] Configuração realizada com sucesso");

		return "SucessoConfig";
	}
	
	
	@RequestMapping(value = "/validaQuestao", method = RequestMethod.GET)
	public String validaQuestão(Model model, @RequestParam("id") String id, HttpSession session) {

		Utils.atualizarValidaQuestao(id);

		System.out.println("[Sucesso] Configuração realizada com sucesso");

		return "SucessoConfig";
	}
	
	
	@RequestMapping(value = "/criarlog", method = RequestMethod.POST)
	public String criarLog(Model model, @RequestParam("name") int id, HttpSession session) {

		Utils.logsPesquisa(id);

		return "SucessoConfig";
	}
	
	@RequestMapping(value = "/validaQuestaoLoad", method = RequestMethod.GET)
	public String validaQuestão(Model model, HttpSession session) {

		
		
		if(Utils.consultaValidaQuestao()){
			
			
			Utils.atualizarValidaQuestao("false");
			
			model.addAttribute("parametro", "false");
			
		}else {
		
			
			Utils.atualizarValidaQuestao("true");
			model.addAttribute("parametro", "true");
		}

		System.out.println("[Sucesso] Configuração realizada com sucesso");

		return "follow";
	}
	
	
	

	@RequestMapping(value = "/editastatusoff", method = RequestMethod.GET)
	public String editastatusoff(Model model, @RequestParam("id") int id, HttpSession session) {

		PesquisaEquipeDao dao = new PesquisaEquipeDao();
		dao.atualizarPesquisa("Inativo", id);

		System.out.println("[Alerta] Alterado o status da pesquisa");

		return "redirect:/cadastro";
	}

	@RequestMapping(value = "/editastatuson", method = RequestMethod.GET)
	public String editastatuson(Model model, @RequestParam("id") int id, HttpSession session) {

		PesquisaEquipeDao dao = new PesquisaEquipeDao();
		//dao.atualizarPesquisaOff("Inativo");
		dao.atualizarPesquisa("Ativo", id);

		System.out.println("[Alerta] Alterado o status da pesquisa");

		return "redirect:/cadastro";
	}

	@RequestMapping(value = "/apagapesuisa", method = RequestMethod.GET)
	public String apagaPesuisa(Model model, @RequestParam("codigo") int id, HttpSession session) {

		PesquisaEquipeDao dao = new PesquisaEquipeDao();

		dao.apagarPesquisa(2, id);

		System.out.println("[Alerta] Pesquisa foi Arquivada com sucesso");

		return "redirect:/cadastro";
	}
	
	@RequestMapping(value = "/apagapesuisa2", method = RequestMethod.GET)
	public String apagaPesuisa2(Model model, @RequestParam("codigo") int id, HttpSession session) {

		PesquisaEquipeDao dao = new PesquisaEquipeDao();

		dao.apagarPesquisa(1, id);

		System.out.println("[Alerta] Pesquisa foi Arquivada com sucesso");

		return "redirect:/arquivo";
	}
	
	@RequestMapping(value = "/deletarpesquisa", method = RequestMethod.GET)
	public String deletarPesquisa(Model model, @RequestParam("codigo") int id, HttpSession session) {

		PesquisaEquipeDao dao = new PesquisaEquipeDao();

		dao.deletarPesquisa(id);

		System.out.println("[Alerta] Pesquisa foi Apagada com sucesso");

		return "redirect:/arqui";
	}
	
	
	@RequestMapping(value = "/apagaProjetoConciliacao", method = RequestMethod.GET)
	public String apagaProjetoConciliacao(Model model, @RequestParam("idProjeto") int id, HttpSession session) {

		ProjetosDao.apagarProjetos(id);

		System.out.println("[Alerta] Projeto foi apagada com sucesso "+id);

		return "redirect:/hie";
	}
	

	@RequestMapping(value = "/apagaProjetoInsatisfacao", method = RequestMethod.GET)
	public String apagaProjetoInsatisfacao(Model model, @RequestParam("idProjeto") String id, HttpSession session) {

		SatisfacaoDao.apagarProjetosInstisfacao(id);;

		System.out.println("[Alerta] Projeto foi apagada com sucesso "+id);

		return "redirect:/hie";
	}

	@RequestMapping(value = "/apagaProjetoSatisfacao", method = RequestMethod.GET)
	public String apagaProjetoSatisfacao(Model model, @RequestParam("idProjeto") String id, HttpSession session) {

		SatisfacaoDao.apagarProjetosSatisfacao(id);;

		System.out.println("[Alerta] Projeto foi apagada com sucesso "+id);

		return "redirect:/hie";
	}
	@RequestMapping(value = "/atualizaQtde", method = RequestMethod.GET)
	public String apagaPesuisa(Model model, @RequestParam("id") int id, @RequestParam("qtde") int qtde, HttpSession session) {

		PesquisaEquipeDao dao = new PesquisaEquipeDao();

		dao.atualizarQtde(id, qtde);

		System.out.println("[Alerta] Quantidade foi apagada com sucesso");

		return "redirect:/cadastro";
	}
	@RequestMapping(value = "/conciliacao", method = RequestMethod.GET)
	public String conciliacao2(Model model, @RequestParam("id") int id, HttpSession session) {

		System.out
				.println("[Alerta] Solicitação de geração de grafico recebida");

		PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaUnica(id);
		
		
		
		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoes2(id);
		
		ArrayList<PesquisaConciliacao> conciliacoes1 = dao
				.listarTodasConciliacoesPercent(id, conciliacoes);
		
		FusionCharts fc = new FusionCharts();
		
		model.addAttribute("xml1", fc.gera15XML(conciliacoes1, equipe));
		model.addAttribute("xml2", fc.gera610XML(conciliacoes1, equipe));
		model.addAttribute("xml3", fc.gera1115XML(conciliacoes1, equipe));
		model.addAttribute("xml4", fc.gera1620XML(conciliacoes1 , equipe));
		model.addAttribute("xml5", fc.gera2125XML(conciliacoes1, equipe));
		model.addAttribute("xml11", fc.gera25XML(conciliacoes1, equipe));
		model.addAttribute("xml6", fc.gera2630XML(conciliacoes1, equipe));
		model.addAttribute("xml7", fc.gera3136XML(conciliacoes1, equipe));
		model.addAttribute("xml10", fc.gera39XML(conciliacoes1, equipe));
		model.addAttribute("xml8", fc.geraMiltiplaXML("37",conciliacoes1, equipe));
		model.addAttribute("xml9", fc.geraMiltiplaXML("38",conciliacoes1, equipe));
		model.addAttribute("id", id);
		
		model.addAttribute("conciliacoes", conciliacoes1);
		model.addAttribute("title", conciliacoes1.get(1).getEquipe());
		return "conciliacao2";
	}
	
	
	@RequestMapping(value = "/concilicaprojeto", method = RequestMethod.POST)
	public String conciliacao3(Model model, @RequestParam(value = "pesquisa", required = false) int[] id, @RequestParam(value = "nomeConciliacao", required = false) String nomeConciliacao, HttpSession session) {
		
		if(id == null ){
			
			return "redirect:/hie";
			
		}
	
		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoes3(id);
		
		ArrayList<PesquisaConciliacao> conciliacoes1 = dao
				.listarTodasConciliacoesPercent2(id, conciliacoes);
		
		PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaMultipla(id);
		if(nomeConciliacao == null)
			nomeConciliacao = "Sem Nome";
		FusionCharts fc = new FusionCharts();
		model.addAttribute("xml1", fc.gera15XML(conciliacoes1, equipe));
		model.addAttribute("xml2", fc.gera610XML(conciliacoes1, equipe));
		model.addAttribute("xml3", fc.gera1115XML(conciliacoes1, equipe));
		model.addAttribute("xml4", fc.gera1620XML(conciliacoes1 , equipe));
		model.addAttribute("xml5", fc.gera2125XML(conciliacoes1, equipe));
		model.addAttribute("xml11", fc.gera25XML(conciliacoes1, equipe));
		model.addAttribute("xml6", fc.gera2630XML(conciliacoes1, equipe));
		model.addAttribute("xml7", fc.gera3136XML(conciliacoes1, equipe));
		model.addAttribute("xml10", fc.gera39XML(conciliacoes1, equipe));
		model.addAttribute("xml8", fc.geraMiltiplaXML("37",conciliacoes1, equipe));
		model.addAttribute("xml9", fc.geraMiltiplaXML("38",conciliacoes1, equipe));
		model.addAttribute("id", id);
		
		model.addAttribute("conciliacoes", conciliacoes1);
		model.addAttribute("title", nomeConciliacao);
		return "conciliacao3";


		
	}
	
	
	@RequestMapping(value = "/conciliacaoPrinter", method = RequestMethod.GET)
	public String conciliacao2Printer(Model model, @RequestParam("id") int id, HttpSession session) {

		System.out
				.println("[Alerta] Solicitação de geração de grafico recebida");

		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoes2(id);
		PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaUnica(id);
		ArrayList<PesquisaConciliacao> conciliacoes1 = dao
				.listarTodasConciliacoesPercent(id, conciliacoes);
		FusionCharts fc = new FusionCharts();
		model.addAttribute("xml1", fc.gera15XML(conciliacoes1, equipe));
		model.addAttribute("xml2", fc.gera610XML(conciliacoes1, equipe));
		model.addAttribute("xml3", fc.gera1115XML(conciliacoes1, equipe));
		model.addAttribute("xml4", fc.gera1620XML(conciliacoes1 , equipe));
		model.addAttribute("xml5", fc.gera2125XML(conciliacoes1, equipe));
		model.addAttribute("xml11", fc.gera25XML(conciliacoes1, equipe));
		model.addAttribute("xml6", fc.gera2630XML(conciliacoes1, equipe));
		model.addAttribute("xml7", fc.gera3136XML(conciliacoes1, equipe));
		model.addAttribute("xml10", fc.gera39XML(conciliacoes1, equipe));
		model.addAttribute("xml8", fc.geraMiltiplaXML("37",conciliacoes1, equipe));
		model.addAttribute("xml9", fc.geraMiltiplaXML("38",conciliacoes1, equipe));
		model.addAttribute("id", id);
		
		model.addAttribute("conciliacoes", conciliacoes1);
		model.addAttribute("title", conciliacoes1.get(1).getEquipe());
		return "conciliacao2printable";
	}
	
	@RequestMapping(value = "/conciliacaoPrinterProjeto", method = RequestMethod.GET)
	public String conciliacao2PrinterProjeto(Model model, @RequestParam("id") int[] id, HttpSession session) {

		System.out
				.println("[Alerta] Solicitação de geração de grafico recebida");

		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoes3(id);
		PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaMultipla(id);
		ArrayList<PesquisaConciliacao> conciliacoes1 = dao
				.listarTodasConciliacoesPercent2(id, conciliacoes);
		FusionCharts fc = new FusionCharts();
		model.addAttribute("xml1", fc.gera15XML(conciliacoes1, equipe));
		model.addAttribute("xml2", fc.gera610XML(conciliacoes1, equipe));
		model.addAttribute("xml3", fc.gera1115XML(conciliacoes1, equipe));
		model.addAttribute("xml4", fc.gera1620XML(conciliacoes1 , equipe));
		model.addAttribute("xml5", fc.gera2125XML(conciliacoes1, equipe));
		model.addAttribute("xml11", fc.gera25XML(conciliacoes1, equipe));
		model.addAttribute("xml6", fc.gera2630XML(conciliacoes1, equipe));
		model.addAttribute("xml7", fc.gera3136XML(conciliacoes1, equipe));
		model.addAttribute("xml10", fc.gera39XML(conciliacoes1, equipe));
		model.addAttribute("xml8", fc.geraMiltiplaXML("37",conciliacoes1, equipe));
		model.addAttribute("xml9", fc.geraMiltiplaXML("38",conciliacoes1, equipe));
		model.addAttribute("id", id);
		
		model.addAttribute("conciliacoes", conciliacoes1);
		model.addAttribute("title", "Projeto");
		return "conciliacao2printable";
	}
	
	@RequestMapping(value = "/conciliacao2", method = RequestMethod.GET)
	public String conciliacao(Model model, @RequestParam("id") int id, HttpSession session) {

		System.out
				.println("[Alerta] Solicitação de geração de grafico recebida");

		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes1 = dao
				.listarTodasConciliacoes(id);

		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoesPercent(id, conciliacoes1);

		int questoes = 0, compara = 1;

		for (int r = 0; r < conciliacoes.size(); r++) {

			if (compara != Integer.parseInt(conciliacoes.get(r).getNumero())) {

				questoes++;
			}

			compara = Integer.parseInt(conciliacoes.get(r).getNumero());

		}

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 1 a 5////////////////////
		// /////////////////////////////////////////////////////////////
		Utils util = new Utils();
		Object[][] result;

		result = util.geraGrafico(conciliacoes, 1, 5, 5);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result3;

		result3 = util.geraGrafico(conciliacoes, 6, 10, 5);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result4;

		result4 = util.geraGrafico(conciliacoes, 11, 15, 5);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result5;

		result5 = util.geraGrafico(conciliacoes, 16, 20, 5);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result6;

		result6 = util.geraGrafico(conciliacoes, 21, 25, 5);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result7;

		result7 = util.geraGrafico(conciliacoes, 26, 30, 5);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result8;

		result8 = util.geraGrafico(conciliacoes, 31, 36, 6);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result9;

		result9 = util.geraGraficoMulti(conciliacoes1, 17, 37);

		// //////////////////////////////////////////////////////////////
		// ///////////// gráfico da questão de 6 a 10////////////////////
		// /////////////////////////////////////////////////////////////

		Object[][] result10;

		result10 = util.geraGraficoMulti(conciliacoes1, 15, 38);

		// ///////////////////////////////////////////////////////////////
		// ////// Gráfigo da questão 39 - Ponto de Equilibrio ////////////
		// //////////////////////////////////////////////////////////////

		Object[][] result2 = new Object[2][4];

		result2[0][0] = "A Voz Do Cliente";
		result2[0][1] = "Satisfeito";
		result2[0][2] = "Mais ou Menos";
		result2[0][3] = "Não satisfeito";

		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) == 39) {

				result2[1][0] = Integer.parseInt(conciliacoes.get(i)
						.getNumero())
						+ " - "
						+ conciliacoes.get(i).getDescricaoQuestao();

				if (conciliacoes.get(i).getLetra().equals("a"))
					result2[1][1] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("b"))
					result2[1][2] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("c"))
					result2[1][3] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

			}
		}

		model.addAttribute("orientacao", "horizontal");
		model.addAttribute("id", id);
		model.addAttribute("resultado10", result10);
		model.addAttribute("resultado9", result9);
		model.addAttribute("resultado8", result8);
		model.addAttribute("resultado7", result7);
		model.addAttribute("resultado6", result6);
		model.addAttribute("resultado5", result5);
		model.addAttribute("resultado4", result4);
		model.addAttribute("resultado3", result3);
		model.addAttribute("resultado2", result2);
		model.addAttribute("subtitle2", result[1][0]);
		model.addAttribute("resultado", result);
		model.addAttribute("title", conciliacoes.get(1).getEquipe());
		model.addAttribute("subtitle", "Quadro 1");
		model.addAttribute("conciliacoes", conciliacoes);

		System.out
				.println("[Sucesso] Solicitação de geração de grafico finalizada");

		return "conciliacao";
	}

	@RequestMapping(value = "salvarpesquisa", method = RequestMethod.POST)
	public String salvarPesquisa(
			@RequestParam("pesquisaequipe") String pesquisaEquipe,
			@RequestParam("1") String q1, @RequestParam("2") String q2,
			@RequestParam("3") String q3, @RequestParam("4") String q4,
			@RequestParam("5") String q5, @RequestParam("6") String q6,
			@RequestParam("7") String q7, @RequestParam("8") String q8,
			@RequestParam("9") String q9, @RequestParam("10") String q10,
			@RequestParam("11") String q11, @RequestParam("12") String q12,
			@RequestParam("13") String q13, @RequestParam("14") String q14,
			@RequestParam("15") String q15, @RequestParam("16") String q16,
			@RequestParam("17") String q17, @RequestParam("18") String q18,
			@RequestParam("19") String q19, @RequestParam("20") String q20,
			@RequestParam("21") String q21, @RequestParam("22") String q22,
			@RequestParam("23") String q23, @RequestParam("24") String q24,
			@RequestParam("25") String q25, @RequestParam("26") String q26,
			@RequestParam("27") String q27, @RequestParam("28") String q28,
			@RequestParam("29") String q29, @RequestParam("30") String q30,
			@RequestParam("31") String q31, @RequestParam("32") String q32,
			@RequestParam("33") String q33, @RequestParam("34") String q34,
			@RequestParam("35") String q35, @RequestParam("36") String q36,
			@RequestParam(value = "37", required = false) String[] q37,
			@RequestParam(value = "38", required = false) String[] q38,
			@RequestParam("39") String q39, @RequestParam("ip") String ip,
			Model model, HttpSession session) {

		System.out
				.println("[Alerta] O endereço IP "
						+ ip
						+ " acaba de enviar sua resposa. Respostas em processamento... Aguarde!");

		if (Utils.validaIp("validaIp")) {

			if (PesquisaQuestionDao.readyAnswered(pesquisaEquipe, ip)) {

				System.out.println("[Alerta] O ip " + ip
						+ " já respondeu e tentou enviar a questão novamente");
				return "pesquisaduplicada";
			}
		}

		ArrayList<PesquisaQuestion> pesquisasQuestions = new ArrayList<PesquisaQuestion>();
		PesquisaQuestion pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 1, Integer.parseInt(q1));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 2, Integer.parseInt(q2));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 3, Integer.parseInt(q3));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 4, Integer.parseInt(q4));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 5, Integer.parseInt(q5));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 6, Integer.parseInt(q6));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 7, Integer.parseInt(q7));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 8, Integer.parseInt(q8));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 9, Integer.parseInt(q9));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 10, Integer.parseInt(q10));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 11, Integer.parseInt(q11));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 12, Integer.parseInt(q12));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 13, Integer.parseInt(q13));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 14, Integer.parseInt(q14));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 15, Integer.parseInt(q15));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 16, Integer.parseInt(q16));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 17, Integer.parseInt(q17));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 18, Integer.parseInt(q18));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 19, Integer.parseInt(q19));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 20, Integer.parseInt(q20));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 21, Integer.parseInt(q21));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 22, Integer.parseInt(q22));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 23, Integer.parseInt(q23));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 24, Integer.parseInt(q24));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 25, Integer.parseInt(q25));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 26, Integer.parseInt(q26));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 27, Integer.parseInt(q27));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 28, Integer.parseInt(q28));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 29, Integer.parseInt(q29));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 30, Integer.parseInt(q30));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 31, Integer.parseInt(q31));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 32, Integer.parseInt(q32));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 33, Integer.parseInt(q33));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 34, Integer.parseInt(q34));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 35, Integer.parseInt(q35));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 36, Integer.parseInt(q36));
		pesquisasQuestions.add(pesquisaQuestion);

		pesquisaQuestion = new PesquisaQuestion(
				Integer.parseInt(pesquisaEquipe), 39, Integer.parseInt(q39));
		pesquisasQuestions.add(pesquisaQuestion);

		if (q37 != null) {
			for (String qs37 : q37) {

				PesquisaQuestionDao.inserePesquisa(
						new PesquisaQuestion(Integer.parseInt(pesquisaEquipe),
								37, Integer.parseInt(qs37)), ip);

			}
		}

		if (q38 != null) {
			for (String qs38 : q38) {

				PesquisaQuestionDao.inserePesquisa(
						new PesquisaQuestion(Integer.parseInt(pesquisaEquipe),
								38, Integer.parseInt(qs38)), ip);

			}
		}
		for (PesquisaQuestion questions : pesquisasQuestions) {

			PesquisaQuestionDao.inserePesquisa(questions, ip);

		}

		System.out.println("[Sucesso] As respostas endereço IP " + ip
				+ " foram processas com sucesso.");
		PesquisaEquipeDao dao = new PesquisaEquipeDao();
		model.addAttribute("pesquisas", dao.listarTodasPesquisas());

		return "pesquisasalva";
	}

	@RequestMapping("/grafico")
	public String grafico(Model model, HttpSession session) {

		return "grafico";
	}

	@RequestMapping(value = "tabular", method = RequestMethod.GET)
	public String grafico2(Model model, @RequestParam("id") int id, HttpSession session) {
		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoes(id);

		model.addAttribute("conciliacoes", conciliacoes);
		return "conciliacaotabular";
	}

	@RequestMapping(value = "insatisfacao", method = RequestMethod.GET)
	public String insatisfacao(Model model, @RequestParam("id") int id, HttpSession session) {

		if (SatisfacaoDao.existeSatisfacao(id, "i")) {

		} else {

			PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes = dao
					.listarCampoeasInsatisfacao(id);
			
			ArrayList<PesquisaConciliacao> conciliacoes1 = dao
					.listarTodasConciliacoesPercent(id, conciliacoes);

			for (PesquisaConciliacao conciliacao : conciliacoes) {

				SatisfacaoDao.insereSatisfacao(conciliacao, id, "i");

			}

		}

		
		ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacao(
				id, "i");

		model.addAttribute("title", PesquisaEquipeDao.listarPesquisaAtivaUnica(id).getNomeequipe());
		model.addAttribute("conciliacoes", listaSatiscao);
		return "campinsatisf";
	}

	@RequestMapping(value = "satisfacao", method = RequestMethod.GET)
	public String satisfacao(Model model, @RequestParam("id") int id, HttpSession session) {

		if (SatisfacaoDao.existeSatisfacao(id, "s")) {

		} else {

			PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes = dao
					.listarCampoeasSatisfacao(id);
			
			ArrayList<PesquisaConciliacao> conciliacoes1 = dao
					.listarTodasConciliacoesPercent(id, conciliacoes);

			for (PesquisaConciliacao conciliacao : conciliacoes1) {

				SatisfacaoDao.insereSatisfacao(conciliacao, id, "s");

			}

		}

		
		ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacao(
				id, "s");

		model.addAttribute("title", PesquisaEquipeDao.listarPesquisaAtivaUnica(id).getNomeequipe());
		model.addAttribute("conciliacoes", listaSatiscao);
		return "campsatisf";
	}
	
	@RequestMapping(value = "vizualizaSatisfacaoProjeto", method = RequestMethod.GET)
	
	public String vizualizaSatisfacaoProjeto2(Model model, @RequestParam("nomeProjeto") String nome, HttpSession session) {

	
		ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacaoProjeto(
				nome, "s");

		model.addAttribute("title", nome);
		model.addAttribute("conciliacoes", listaSatiscao);
		return "campsatisfprojeto";
	}
	
@RequestMapping(value = "vizualizaSatisfacaoProjetoPrinter", method = RequestMethod.GET)
	
	public String vizualizaSatisfacaoProjetoPrinter(Model model, @RequestParam("nomeProjeto") String nome, HttpSession session) {

	
		ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacaoProjeto(
				nome, "s");
		

		model.addAttribute("title", nome);
		model.addAttribute("conciliacoes4", listaSatiscao);
		return "printableprojeto";
	}

@RequestMapping(value = "vizualizaInsatisfacaoProjetoPrinter", method = RequestMethod.GET)

	public String vizualizaInsatisfacaoProjetoPrinter(Model model, @RequestParam("nomeProjeto") String nome, HttpSession session) {


	ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacaoProjeto(
			nome, "i");
	

	model.addAttribute("title", nome);
	model.addAttribute("conciliacoes3", listaSatiscao);
	return "printableprojeto2";
}

@RequestMapping(value = "vizualizaInsatisfacaoProjetoPrinterCompleto", method = RequestMethod.GET)

	public String vizualizaInsatisfacaoProjetoPrinterCompleto(Model model, @RequestParam("nomeProjeto") String nome, HttpSession session) {


	ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacaoProjeto(
			nome, "i");
	

	model.addAttribute("title", nome);
	model.addAttribute("conciliacoes3", listaSatiscao);
	return "printableprojeto2Complete";
}
	
@RequestMapping(value = "vizualizaInsatisfacaoProjeto", method = RequestMethod.GET)
	
	public String vizualizaInsatisfacaoProjeto2(Model model, @RequestParam("nomeProjeto") String nome, HttpSession session) {

	
		ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacaoProjeto(
				nome, "i");

		model.addAttribute("title", nome);
		model.addAttribute("conciliacoes", listaSatiscao);
		return "campinsatisfprojeto";
	}

	@RequestMapping(value = "satisfacaoprojeto", method = RequestMethod.POST)
	public String satisfacaoProjeto(Model model, @RequestParam("pesquisa") int[] id, @RequestParam("nomerelatorio") String nomeRelatorio, HttpSession session ) {

	

			PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes = dao
					.listarCampoeasSatisfacaoProjeto(id);
			
			ArrayList<PesquisaConciliacao> conciliacoes1 = dao
					.listarTodasConciliacoesPercent2(id, conciliacoes);

			for (PesquisaConciliacao conciliacao : conciliacoes1) {

				SatisfacaoDao.insereSatisfacaoProjeto(conciliacao, 0, "s", nomeRelatorio);

			}

		

	
		
		return "redirect:/hie";
	}
	@RequestMapping(value = "insatisfacaoprojeto", method = RequestMethod.POST)
	public String insatisfacaoProjeto(Model model, @RequestParam("pesquisa") int[] id, @RequestParam("nomerelatorio") String nomeRelatorio, HttpSession session ) {

	

			PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes = dao
					.listarCampoeasInsatisfacaoProjeto(id);
			
			ArrayList<PesquisaConciliacao> conciliacoes1 = dao
					.listarTodasConciliacoesPercent2(id, conciliacoes);

			for (PesquisaConciliacao conciliacao : conciliacoes1) {

				SatisfacaoDao.insereSatisfacaoProjeto(conciliacao, 0, "i", nomeRelatorio);

			}

		

	
		
		return "redirect:/hie";
	}
	@RequestMapping(value = "updatePesquisa", method = RequestMethod.POST)
	public String updatePesquisa( @RequestParam("comentario") String[] comments ,
			@RequestParam("tipo") String[] tipo ,
			@RequestParam("id") int[] id ,
			@RequestParam("id_equipe") int[] id_equipe ,
			@RequestParam("numero") String[] numero ,
			@RequestParam("letra") String[] letra ,
			@RequestParam("ajustes") String[] ajustes ,HttpSession session) {

		for(int i = 0; i < numero.length ; i++ ){
		SatisfacaoDao.atualizarComentario(id[i], id_equipe[i], numero[i], letra[i],
				comments[i], ajustes[i]);
		}
		if (tipo[0].equals("I")) {
			return "redirect:/insatisfacao?id=" + id_equipe[0];

		} else if (tipo[0].equals("S")) {

			return "redirect:/satisfacao?id=" + id_equipe[0];

		}

		return "redirect:/cadastro";
	}

	@RequestMapping(value = "updatePesquisa2", method = RequestMethod.POST)
	@ResponseBody
	public String updatePesquisa2(Satisfacao sas, @RequestParam("comentario") String[] comments ,
			@RequestParam("tipo") String[] tipo ,
			@RequestParam("id") int[] id ,
			@RequestParam("id_equipe") int[] id_equipe ,
			@RequestParam("numero") String[] numero ,
			@RequestParam("letra") String[] letra ,
			@RequestParam("ajustes") String[] ajustes ,
			@RequestParam("nomerelatorio") String[] nomerelatorio ,HttpSession session){

		for(int i = 0; i < numero.length ; i++ ){
		SatisfacaoDao.atualizarComentarioProjetos(id[i], id_equipe[i],
				numero[i], letra[i], comments[i], ajustes[i], nomerelatorio[i]);

		}
		return "Sucesso";
	}
	
	@RequestMapping(value = "updatePesquisa3", method = RequestMethod.POST)
	@ResponseBody
	public String updatePesquisa3( @RequestParam("comentario") String[] comments ,
			@RequestParam("tipo") String[] tipo ,
			@RequestParam("id") int[] id ,
			@RequestParam("id_equipe") int[] id_equipe ,
			@RequestParam("numero") String[] numero ,
			@RequestParam("letra") String[] letra ,
			@RequestParam("ajustes") String[] ajustes ,HttpSession session) {

	
		for(int i = 0; i < numero.length ; i++ ){
		SatisfacaoDao.atualizarComentarioProjetos(id[i], id_equipe[i],
				numero[i], letra[i], comments[i], ajustes[i], "");
		}
		
		return "Sucesso";
	}
	

	@RequestMapping(value = "salvarpesquisa2", method = RequestMethod.POST)
	// @ResponseBody
	public String salvarPesquisa2(PesquisaQuestion pesquisaQuestion, HttpSession session) {

		System.out
				.println("[Alerta] O endereço IP "
						+ pesquisaQuestion.getIp()
						+ " acaba de enviar sua resposa. Respostas em processamento... Aguarde!");

		if (Utils.validaIp("validaIp")) {

			//if (PesquisaQuestionDao.readyAnswered(String.valueOf(pesquisaQuestion.getId_pesquisa()),pesquisaQuestion.getIp())) {
			if (PesquisaQuestionDao.readyAnswered(String.valueOf(pesquisaQuestion.getId_pesquisa()),session.getAttribute("sessionIP").toString())) {
				
				System.out.println("[Alerta] O ip " + pesquisaQuestion.getIp()
						+ " já respondeu e tentou enviar a questão novamente");
				return "pesquisaduplicada";
			}
		}


		
		int qtde =PesquisaEquipeDao.listarPesquisaAtivaUnica(pesquisaQuestion.getId_pesquisa()).getQtde();
        int total =PesquisaQuestionDao.readyFollowed(String.valueOf(PesquisaEquipeDao.listarPesquisaAtivaUnica(pesquisaQuestion.getId_pesquisa()).getId()), String.valueOf(pesquisaQuestion.getQuestion()));
		
        
       
		
		
		if(qtde > total){
			
			//PesquisaQuestionDao.inserePesquisa(pesquisaQuestion,pesquisaQuestion.getIp());
			PesquisaQuestionDao.inserePesquisa(pesquisaQuestion,session.getAttribute("sessionIP").toString());
			System.out.println("[Sucesso] As respostas endereço IP "
					+ pesquisaQuestion.getIp() + " foram processas com sucesso.");
			
			return "Sucesso";
			
		}else{
			
			
			if(!Utils.validaQuestao("validaQuestao")){
				
				
			//	PesquisaQuestionDao.inserePesquisa(pesquisaQuestion,pesquisaQuestion.getIp());
				PesquisaQuestionDao.inserePesquisa(pesquisaQuestion,session.getAttribute("sessionIP").toString());
				System.out.println("[Sucesso] As respostas endereço IP "
						+ pesquisaQuestion.getIp() + " foram processas com sucesso.");
				
				return "Sucesso";
				
				
			}
			
			System.out.println("passou, pode seguir");
			
			return "Falha";
		}
		
		
		

		
	}

	@RequestMapping(value = "salvarpesquisamultipla2", method = RequestMethod.POST)
	// @ResponseBody
	public String salvarPesquisaMultipla2(
			PesquisaQuestionMultipla pesquisaQuestionMultipla, HttpSession session) {

		System.out
				.println("[Alerta] O endereço IP "
						+ pesquisaQuestionMultipla.getIp()
						+ " acaba de enviar sua resposa. Respostas em processamento... Aguarde!");

		if(pesquisaQuestionMultipla.getAlternative_id() == null){
			
			PesquisaQuestion pesquisaQuestion = new PesquisaQuestion(0,
					pesquisaQuestionMultipla.getId_pesquisa(),
					pesquisaQuestionMultipla.getQuestion(),
					0);

			//PesquisaQuestionDao.inserePesquisaNull(pesquisaQuestion,pesquisaQuestionMultipla.getIp());
			PesquisaQuestionDao.inserePesquisaNull(pesquisaQuestion,session.getAttribute("sessionIP").toString());
			
			System.out.println(" [Sucesso] As respostas endereço IP "
					+ pesquisaQuestionMultipla.getIp()
					+ " foram processas com sucesso.");
			
			return "Sucesso";
			
		}
		
		if (Utils.validaIp("validaIp")) {

			//if (PesquisaQuestionDao.readyAnswered(String.valueOf(pesquisaQuestionMultipla.getId_pesquisa()),pesquisaQuestionMultipla.getIp())) {
			if (PesquisaQuestionDao.readyAnswered(String.valueOf(pesquisaQuestionMultipla.getId_pesquisa()),session.getAttribute("sessionIP").toString())) {
				System.out.println("[Alerta] O ip "
						+ pesquisaQuestionMultipla.getIp()
						+ " já respondeu e tentou enviar a questão novamente");
				return "pesquisaduplicada";
			}
		}

		for (int i = 0; i < pesquisaQuestionMultipla.getAlternative_id().size(); i++) {

			PesquisaQuestion pesquisaQuestion = new PesquisaQuestion(0,
					pesquisaQuestionMultipla.getId_pesquisa(),
					pesquisaQuestionMultipla.getQuestion(),
					pesquisaQuestionMultipla.getAlternative_id().get(i));

			//PesquisaQuestionDao.inserePesquisa(pesquisaQuestion,pesquisaQuestionMultipla.getIp());
			PesquisaQuestionDao.inserePesquisa(pesquisaQuestion,session.getAttribute("sessionIP").toString());
			System.out.println(" [Sucesso] As respostas endereço IP "
					+ pesquisaQuestionMultipla.getIp()
					+ " foram processas com sucesso.");

		}

		return "Sucesso";
	}
	
	
	@RequestMapping(value = "aconpanhapesquisa", method = RequestMethod.POST)
	@ResponseBody
	public pesquisaFollow acompanhaPesquisa(PesquisaEquipe equipePesquisa, HttpSession session) {
    pesquisaFollow follow = new pesquisaFollow();
    
    PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaAtivaUnica(equipePesquisa.getId());
    
    if(equipe == null){
    	
    	
    	follow.setSucesso("false");
    	
    	
    	return follow;
    	
    }else{
    	
    	
    	follow.setSucesso("true");
    	
    	
    }
    
    
	follow.setTotal(equipe.getQtde());
	follow.setEquipe(equipe.getNomeequipe());
	for(int i= 1; i<= 39; i++){
	
		
		if(i==1)
			follow.setP1(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==2)
			follow.setP2(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==3)
			follow.setP3(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==4)
			follow.setP4(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==5)
			follow.setP5(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==6)
			follow.setP6(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==7)
			follow.setP7(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==8)
			follow.setP8(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==9)
			follow.setP9(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==10)
			follow.setP10(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==11)
			follow.setP11(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==12)
			follow.setP12(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==13)
			follow.setP13(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==14)
			follow.setP14(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==15)
			follow.setP15(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==16)
			follow.setP16(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==17)
			follow.setP17(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==18)
			follow.setP18(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==19)
			follow.setP19(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==20)
			follow.setP20(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==21)
			follow.setP21(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==22)
			follow.setP22(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==23)
			follow.setP23(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==24)
			follow.setP24(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==25)
			follow.setP25(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==26)
			follow.setP26(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==27)
			follow.setP27(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==28)
			follow.setP28(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==29)
			follow.setP29(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==30)
			follow.setP30(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==31)
			follow.setP31(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==32)
			follow.setP32(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==33)
			follow.setP33(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==34)
			follow.setP34(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==35)
			follow.setP35(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==36)
			follow.setP36(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==37)
			follow.setP37(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==38)
			follow.setP38(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		if(i==39)
			follow.setP39(PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(i)));
		
		
	}

		return follow;
	}
	
	
	
	@RequestMapping(value = "/f", method = RequestMethod.GET)
	public String index4(Model model, @RequestParam("id") int id, HttpSession session) {
		
		PesquisaEquipe pesquisa = PesquisaEquipeDao.listarPesquisaAtivaUnica(id);
		
		boolean x = Utils.consultaValidaQuestao();
		
		if(x){

			model.addAttribute("parametro", "false");
			
		}else {

			model.addAttribute("parametro", "true");
		}
		
		model.addAttribute("pesquisa", pesquisa);
		return "follow";

	}
	
	@RequestMapping(value = "/imprimirCompleto", method = RequestMethod.GET)
	public String imprimirCompleto(Model model, @RequestParam("id") int id, HttpSession sessiond) {

		System.out
				.println("[Alerta] Solicitação de geração de grafico recebida");

		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		
		ArrayList<PesquisaConciliacao> conciliacoes2 = dao
				.listarTodasConciliacoes(id);
		
		ArrayList<PesquisaConciliacao> conciliacoes1 = dao
				.listarTodasConciliacoes(id);

		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoesPercent(id, conciliacoes1);

		int questoes = 0, compara = 1;

		for (int r = 0; r < conciliacoes.size(); r++) {

			if (compara != Integer.parseInt(conciliacoes.get(r).getNumero())) {

				questoes++;
			}

			compara = Integer.parseInt(conciliacoes.get(r).getNumero());

		}

		

		if (SatisfacaoDao.existeSatisfacao(id, "i")) {

		} else {

			PesquisaConciliacaoDao dao3 = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes33 = dao
					.listarCampoeasInsatisfacao(id);
			
			ArrayList<PesquisaConciliacao> conciliacoes3 = dao
					.listarTodasConciliacoesPercent(id, conciliacoes33);

			for (PesquisaConciliacao conciliacao3 : conciliacoes3) {

				SatisfacaoDao.insereSatisfacao(conciliacao3, id, "i");

			}

		}

		PesquisaConciliacaoDao dao3 = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes3 = dao
				.listarCampoeasInsatisfacao(id);
		ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacao(
				id, "i");
		
		if (SatisfacaoDao.existeSatisfacao(id, "s")) {

		} else {

			PesquisaConciliacaoDao dao4 = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes44 = dao4
					.listarCampoeasSatisfacao(id);
			
			
			ArrayList<PesquisaConciliacao> conciliacoes4 = dao
					.listarTodasConciliacoesPercent(id, conciliacoes44);

			for (PesquisaConciliacao conciliacao4 : conciliacoes4) {

				SatisfacaoDao.insereSatisfacao(conciliacao4, id, "s");

			}

		}

		PesquisaConciliacaoDao dao4 = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes4 = dao4
				.listarCampoeasInsatisfacao(id);
		ArrayList<Satisfacao> listaSatiscao4 = SatisfacaoDao.listarSatisfacao(
				id, "s");

		
		model.addAttribute("conciliacoes", listaSatiscao);
		

		model.addAttribute("orientacao", "horizontal");
		model.addAttribute("id", id);
		model.addAttribute("title", conciliacoes.get(1).getEquipe());

		model.addAttribute("conciliacoes", conciliacoes);
		model.addAttribute("conciliacoes1", conciliacoes2);
		model.addAttribute("conciliacoes3", listaSatiscao);
		model.addAttribute("conciliacoes4", listaSatiscao4);

		System.out
				.println("[Sucesso] Solicitação de geração de grafico finalizada");

		return "printableComplete";
	}
	
	@RequestMapping(value = "/imprimir", method = RequestMethod.GET)
	public String imprimir(Model model, @RequestParam("id") int id, HttpSession session) {

		System.out
				.println("[Alerta] Solicitação de geração de grafico recebida");

		PesquisaConciliacaoDao dao = new PesquisaConciliacaoDao();
		
		ArrayList<PesquisaConciliacao> conciliacoes2 = dao
				.listarTodasConciliacoes(id);
		
		ArrayList<PesquisaConciliacao> conciliacoes1 = dao
				.listarTodasConciliacoes(id);

		ArrayList<PesquisaConciliacao> conciliacoes = dao
				.listarTodasConciliacoesPercent(id, conciliacoes1);

		int questoes = 0, compara = 1;

		for (int r = 0; r < conciliacoes.size(); r++) {

			if (compara != Integer.parseInt(conciliacoes.get(r).getNumero())) {

				questoes++;
			}

			compara = Integer.parseInt(conciliacoes.get(r).getNumero());

		}

		

		if (SatisfacaoDao.existeSatisfacao(id, "i")) {

		} else {

			PesquisaConciliacaoDao dao3 = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes33 = dao
					.listarCampoeasInsatisfacao(id);
			
			ArrayList<PesquisaConciliacao> conciliacoes3 = dao
					.listarTodasConciliacoesPercent(id, conciliacoes33);

			for (PesquisaConciliacao conciliacao3 : conciliacoes3) {

				SatisfacaoDao.insereSatisfacao(conciliacao3, id, "i");

			}

		}

		PesquisaConciliacaoDao dao3 = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes3 = dao
				.listarCampoeasInsatisfacao(id);
		ArrayList<Satisfacao> listaSatiscao = SatisfacaoDao.listarSatisfacao(
				id, "i");
		
		if (SatisfacaoDao.existeSatisfacao(id, "s")) {

		} else {

			PesquisaConciliacaoDao dao4 = new PesquisaConciliacaoDao();
			ArrayList<PesquisaConciliacao> conciliacoes44 = dao4
					.listarCampoeasSatisfacao(id);
			
			
			ArrayList<PesquisaConciliacao> conciliacoes4 = dao
					.listarTodasConciliacoesPercent(id, conciliacoes44);

			for (PesquisaConciliacao conciliacao4 : conciliacoes4) {

				SatisfacaoDao.insereSatisfacao(conciliacao4, id, "s");

			}

		}

		PesquisaConciliacaoDao dao4 = new PesquisaConciliacaoDao();
		ArrayList<PesquisaConciliacao> conciliacoes4 = dao4
				.listarCampoeasInsatisfacao(id);
		ArrayList<Satisfacao> listaSatiscao4 = SatisfacaoDao.listarSatisfacao(
				id, "s");

		
		model.addAttribute("conciliacoes", listaSatiscao);
		

		model.addAttribute("orientacao", "horizontal");
		model.addAttribute("id", id);
		model.addAttribute("title", conciliacoes.get(1).getEquipe());

		model.addAttribute("conciliacoes", conciliacoes);
		model.addAttribute("conciliacoes1", conciliacoes2);
		model.addAttribute("conciliacoes3", listaSatiscao);
		model.addAttribute("conciliacoes4", listaSatiscao4);

		System.out
				.println("[Sucesso] Solicitação de geração de grafico finalizada");

		return "printable";
	}
	
	@RequestMapping(value = "updateConfigQuestao", method = RequestMethod.POST)
	@ResponseBody
	public String updateConfigQuestao() {

	
		
		if(Utils.consultaValidaQuestao()){
			
			Utils.atualizarValidaQuestao("false");
			
			return "Falha";
		}else{
			
			Utils.atualizarValidaQuestao("true");
			
			return "Sucesso";
		}
		
	}
	@RequestMapping(value = "updateConfigIp", method = RequestMethod.POST)
	@ResponseBody
	public String updateConfigIp() {

	
		
		if(Utils.consultaValidaIp()){
			
			Utils.atualizarValidaIP("false");
			
			return "Falha";
		}else{
			
			Utils.atualizarValidaIP("true");
			
			return "Sucesso";
		}
		
	}
	
	
	@RequestMapping(value = "monitoraAvancoAuto", method = RequestMethod.POST)
	//@ResponseBody
	public String monitoraAvancoAuto(PesquisaQuestion pesquisaQuestion) {
		PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaAtivaUnica(pesquisaQuestion.getId_pesquisa());
	
		
		if(equipe.getQtde() <= PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(pesquisaQuestion.getQuestion()))){
			
			
			return "Sucesso";
			
		}else{
			
			
			return "Falha";
			
		}
		
	}
	
	@RequestMapping(value = "monitoraAvancoAuto2", method = RequestMethod.POST)
	//@ResponseBody
	public String monitoraAvancoAuto2(PesquisaQuestion pesquisaQuestion) {
		PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaAtivaUnica(pesquisaQuestion.getId_pesquisa());
	
		pesquisaQuestion.getIp();
		if(equipe.getQtde() <= PesquisaQuestionDao.readyFollowed(String.valueOf(equipe.getId()), String.valueOf(pesquisaQuestion.getQuestion()))){
			
			
			return "Sucesso";
			
		}else if(!PesquisaQuestionDao.readyFollowedValidate(String.valueOf(equipe.getId()), String.valueOf(pesquisaQuestion.getQuestion()), pesquisaQuestion.getIp())){
			
			return "Retorna";
			
			
		}else{
			return "Falha";
			
		}
		
	}
	
	@RequestMapping(value = "salvahierarquia", method = RequestMethod.POST)
	public String salvahierarquisa(Hierarquia hie) {

		System.out.println("A entidade : "+hie.getDescricao()+ " Codigo da categoria: "+hie.getCodCategorias());
		
		HierarquiaDao.insereHierarquia(hie);

		return "redirect:/hie";
	}
	
	@RequestMapping(value = "validaNomeProjeto", method = RequestMethod.POST)
	@ResponseBody
	public pesquisaFollow validaNomeProjeto(Projeto sas) {
		pesquisaFollow follow = new pesquisaFollow();
		System.out.println("passou");
		if(SatisfacaoDao.validaNomeProjeto(sas.getNomerelatorio(), sas.getTipo())){
			
			System.out.println("passou true");
			follow.setSucesso("true");
			
			return follow;
			
		}else{
			
			System.out.println("passou false");
			follow.setSucesso("false");
			
			return follow;
			
		}
		

		
	}
	
	
	
	@RequestMapping(value = "salvarpesquisahie", method = RequestMethod.POST)
	public String salvarPesquisa(@RequestParam("NomeEquipe") String nomeEquipe,
			@RequestParam("data") String data,
			@RequestParam("consultor") String consultor,
			@RequestParam("numero") int qtde, Model model, HttpSession session) {

		PesquisaEquipe pesquisa = new PesquisaEquipe(nomeEquipe, consultor,
				"Inativo", data, qtde);

		PesquisaEquipeDao dao = new PesquisaEquipeDao();

		dao.inserePesquisa(pesquisa);

		System.out.println("Pesquisa para a equipe " + nomeEquipe
				+ " cadastrada com sucesso");

		return "redirect:/hie";
	}
	
	
	@RequestMapping(value = "salvaprojeto", method = RequestMethod.POST)
	@ResponseBody
	public String salvaProjeto(@RequestParam("codEmpresa") int codEmpresa,
			@RequestParam("codSecretaria") int codSecretaria,
			@RequestParam("codDiretoria") int codDiretoria,
			@RequestParam("codCoordenacao") int codCoordenacao,
			@RequestParam("codNucleo") int codNucleo,
			@RequestParam("codCargo") int codCargo,
			@RequestParam("codFuncao") int codFuncao,
			@RequestParam("codPesquisa") int codPesquisa, Model model, HttpSession session) {

		Projetos projeto = new Projetos(codEmpresa, codDiretoria, codCoordenacao, codNucleo, codCargo, codFuncao, codPesquisa, codSecretaria);
			
		ProjetosDao dao = new ProjetosDao();

		dao.insereProjeto(projeto);


		return "Sucesso";
	}
	
	
	
	
	@RequestMapping(value = "/apagaentidade", method = RequestMethod.GET)
	public String apagaEntidade(Model model, @RequestParam("codigo") int id, HttpSession session) {

		HierarquiaDao dao = new HierarquiaDao();
		
		if(!ProjetosDao.ValidaProjetos(id)){
		dao.apagarHierarquia(id);

		}else{
			
			return "redirect:/hie?falhou='Impossivel exluir - Objeto associado'";
			
		}
		System.out.println("[Alerta] Hirarquia foi apagada com sucesso");

		
		return "redirect:/hie";
	}
	
	
	@RequestMapping(value = "/saveTeamEdit", method = RequestMethod.GET)
	public String saveTeamEdit(Model model, @RequestParam("id") int id, @RequestParam("nome") String nome, HttpSession session) {

		PesquisaEquipeDao dao = new PesquisaEquipeDao();

		dao.saveTeamEdit(id, nome);

		System.out.println("[Alerta] Nome foi alterado com sucesso");

		return "redirect:/cadastro";
	}
}
