package br.com.andremartins.votacaoInterativa.util;



import java.util.*;



import com.google.gson.*;

import br.com.andremartins.votacaoInterativa.model.PesquisaConciliacao;
import br.com.andremartins.votacaoInterativa.model.PesquisaEquipe;

public class FusionCharts {
	static int valorFontSize = 13;
	static int decimal = 1;
	static int baseFontSize = 13;
	public FusionCharts() {
		
	}

	public static StringBuilder geraXML(int start, int end,
			ArrayList<PesquisaConciliacao> conciliacoes) {

		int countA = 0;
		int numero = 0;
		String letraA = "a";
		String letraB = "b";
		String letraC = "c";
		String letraD = "d";
		StringBuilder xmlChart = new StringBuilder();
		StringBuilder xmlCategorias = new StringBuilder();
		StringBuilder xmlA = new StringBuilder();
		StringBuilder xmlB = new StringBuilder();
		StringBuilder xmlC = new StringBuilder();
		StringBuilder xmlD = new StringBuilder();
		String[][] letraQA = new String[end - start][2];

		xmlChart.append("<chart caption='Questões Apresentadas de "
				+ start
				+ " à "
				+ end
				+ "' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFA500,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#ffffff' placevaluesinside='1' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlCategorias.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= start
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= end) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlCategorias.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		xmlCategorias.append("</categories>");

		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= start
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= end) {

				if (conciliacoes.get(i).getLetra().equals(letraA)) {

					xmlA.append("<dataset seriesname='"
							+ conciliacoes.get(i).getDescricao() + "'>");

					letraA = "";

				}

				if (conciliacoes.get(i).getLetra().equals("a")) {

					xmlA.append("<set value='" + conciliacoes.get(i).getTotal()
							+ "' />");

				}

			}

		}
		xmlA.append("</dataset>");

		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= start
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= end) {

				if (conciliacoes.get(i).getLetra().equals(letraB)) {

					xmlB.append("<dataset seriesname='"
							+ conciliacoes.get(i).getDescricao() + "'>");

					letraB = "";

				}

				if (conciliacoes.get(i).getLetra().equals("b")) {

					xmlB.append("<set value='" + conciliacoes.get(i).getTotal()
							+ "' />");

				}

			}

		}
		xmlB.append("</dataset>");

		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= start
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= end) {

				if (conciliacoes.get(i).getLetra().equals(letraC)) {

					xmlC.append("<dataset seriesname='"
							+ conciliacoes.get(i).getDescricao() + "'>");

					letraC = "";

				}

				if (conciliacoes.get(i).getLetra().equals("c")) {

					xmlC.append("<set value='" + conciliacoes.get(i).getTotal()
							+ "' />");

				}

			}

		}
		xmlC.append("</dataset>");

		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= start
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= end) {

				if (conciliacoes.get(i).getLetra().equals(letraD)) {

					xmlD.append("<dataset seriesname='"
							+ conciliacoes.get(i).getDescricao() + "'>");

					letraD = "";

				}

				if (conciliacoes.get(i).getLetra().equals("d")) {

					xmlD.append("<set value='" + conciliacoes.get(i).getTotal()
							+ "' />");

				}

			}

		}
		xmlD.append("</dataset>");

		xmlChart.append(xmlCategorias);
		xmlChart.append(xmlA);
		xmlChart.append(xmlB);
		xmlChart.append(xmlC);
		xmlChart.append(xmlD);
		xmlChart.append("</chart>");

		
		return xmlChart;

	}

	public static StringBuilder gera15XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "1";
		String questao2 = "2";
		String questao3 = "3";
		String questao4 = "4";
		String questao5 = "5";
	
		StringBuilder xmlChart = new StringBuilder();
		

		xmlChart.append("<chart showPrintMenuItem = '1' baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1'  caption='Questões Apresentadas de "+questao1+" à "+questao5+" - "+conciliacoes.get(1).getEquipe()+" - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"'  valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao5)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
		String str2a = "<set value='0' />";
		String str3a = "<set value='0' />";
		String str4a = "<set value='0' />";
		String str5a = "<set value='0' />";
		
		int teste1a = 0;
		int teste2a = 0;
		int teste3a = 0;
		int teste4a = 0;
		int teste5a = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("a"))&& teste2a == 0){
				str2a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("a"))&& teste3a == 0){
				str3a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("a"))&& teste4a == 0){
				str4a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4a = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("a"))&& teste5a == 0){
				str5a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5a = 1;
			}
		}
		
		xmlChart.append(str1a);
		xmlChart.append(str2a);
		xmlChart.append(str3a);
		xmlChart.append(str4a);
		xmlChart.append(str5a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";
		String str2b = "<set value='0' />";
		String str3b = "<set value='0' />";
		String str4b = "<set value='0' />";
		String str5b = "<set value='0' />";
		
		int teste1b = 0;
		int teste2b = 0;
		int teste3b = 0;
		int teste4b = 0;
		int teste5b = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("b"))&& teste2b == 0){
				str2b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("b"))&& teste3b == 0){
				str3b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("b"))&& teste4b == 0){
				str4b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4b = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("b"))&& teste5b == 0){
				str5b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5b = 1;
			}
		}
		
		xmlChart.append(str1b);
		xmlChart.append(str2b);
		xmlChart.append(str3b);
		xmlChart.append(str4b);
		xmlChart.append(str5b);
		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";
		String str2c = "<set value='0' />";
		String str3c = "<set value='0' />";
		String str4c = "<set value='0' />";
		String str5c = "<set value='0' />";
		
		int teste1c = 0;
		int teste2c = 0;
		int teste3c = 0;
		int teste4c = 0;
		int teste5c = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("c"))&& teste2c == 0){
				str2c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("c"))&& teste3c == 0){
				str3c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("c"))&& teste4c == 0){
				str4c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4c = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("c"))&& teste5c == 0){
				str5c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5c = 1;
			}
		}
		
		xmlChart.append(str1c);
		xmlChart.append(str2c);
		xmlChart.append(str3c);
		xmlChart.append(str4c);
		xmlChart.append(str5c);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";
		String str2d = "<set value='0' />";
		String str3d = "<set value='0' />";
		String str4d = "<set value='0' />";
		String str5d = "<set value='0' />";
		
		int teste1d = 0;
		int teste2d = 0;
		int teste3d = 0;
		int teste4d = 0;
		int teste5d = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("d"))&& teste2d == 0){
				str2d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("d"))&& teste3d == 0){
				str3d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste3d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("d"))&& teste4d == 0){
				str4d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4d = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("d"))&& teste5d == 0){
				str5d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5d = 1;
			}
		}
		
		xmlChart.append(str1d);
		xmlChart.append(str2d);
		xmlChart.append(str3d);
		xmlChart.append(str4d);
		xmlChart.append(str5d);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	
	public static StringBuilder gera610XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "6";
		String questao2 = "7";
		String questao3 = "8";
		String questao4 = "9";
		String questao5 = "10";
	
		StringBuilder xmlChart = new StringBuilder();
		

		xmlChart.append("<chart showPrintMenuItem = '1' baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentadas de "+questao1+" à "+questao5+" - "+conciliacoes.get(1).getEquipe()+"  - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"' legendItemFontSize = '20' valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20'  subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao5)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
		String str2a = "<set value='0' />";
		String str3a = "<set value='0' />";
		String str4a = "<set value='0' />";
		String str5a = "<set value='0' />";
		
		int teste1a = 0;
		int teste2a = 0;
		int teste3a = 0;
		int teste4a = 0;
		int teste5a = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("a"))&& teste2a == 0){
				str2a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("a"))&& teste3a == 0){
				str3a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("a"))&& teste4a == 0){
				str4a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4a = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("a"))&& teste5a == 0){
				str5a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5a = 1;
			}
		}
		
		xmlChart.append(str1a);
		xmlChart.append(str2a);
		xmlChart.append(str3a);
		xmlChart.append(str4a);
		xmlChart.append(str5a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";
		String str2b = "<set value='0' />";
		String str3b = "<set value='0' />";
		String str4b = "<set value='0' />";
		String str5b = "<set value='0' />";
		
		int teste1b = 0;
		int teste2b = 0;
		int teste3b = 0;
		int teste4b = 0;
		int teste5b = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("b"))&& teste2b == 0){
				str2b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("b"))&& teste3b == 0){
				str3b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("b"))&& teste4b == 0){
				str4b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4b = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("b"))&& teste5b == 0){
				str5b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5b = 1;
			}
		}
		
		xmlChart.append(str1b);
		xmlChart.append(str2b);
		xmlChart.append(str3b);
		xmlChart.append(str4b);
		xmlChart.append(str5b);
		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";
		String str2c = "<set value='0' />";
		String str3c = "<set value='0' />";
		String str4c = "<set value='0' />";
		String str5c = "<set value='0' />";
		
		int teste1c = 0;
		int teste2c = 0;
		int teste3c = 0;
		int teste4c = 0;
		int teste5c = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("c"))&& teste2c == 0){
				str2c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("c"))&& teste3c == 0){
				str3c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("c"))&& teste4c == 0){
				str4c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4c = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("c"))&& teste5c == 0){
				str5c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5c = 1;
			}
		}
		
		xmlChart.append(str1c);
		xmlChart.append(str2c);
		xmlChart.append(str3c);
		xmlChart.append(str4c);
		xmlChart.append(str5c);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";
		String str2d = "<set value='0' />";
		String str3d = "<set value='0' />";
		String str4d = "<set value='0' />";
		String str5d = "<set value='0' />";
		
		int teste1d = 0;
		int teste2d = 0;
		int teste3d = 0;
		int teste4d = 0;
		int teste5d = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("d"))&& teste2d == 0){
				str2d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("d"))&& teste3d == 0){
				str3d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste3d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("d"))&& teste4d == 0){
				str4d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4d = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("d"))&& teste5d == 0){
				str5d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5d = 1;
			}
		}
		
		xmlChart.append(str1d);
		xmlChart.append(str2d);
		xmlChart.append(str3d);
		xmlChart.append(str4d);
		xmlChart.append(str5d);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	
	public static StringBuilder gera1115XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "11";
		String questao2 = "12";
		String questao3 = "13";
		String questao4 = "14";
		String questao5 = "15";
	
		StringBuilder xmlChart = new StringBuilder();
		

		xmlChart.append("<chart  showPrintMenuItem = '1' baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentadas de "+questao1+" à "+questao5+" - "+conciliacoes.get(1).getEquipe()+"  - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"' valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao5)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
		String str2a = "<set value='0' />";
		String str3a = "<set value='0' />";
		String str4a = "<set value='0' />";
		String str5a = "<set value='0' />";
		
		int teste1a = 0;
		int teste2a = 0;
		int teste3a = 0;
		int teste4a = 0;
		int teste5a = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("a"))&& teste2a == 0){
				str2a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("a"))&& teste3a == 0){
				str3a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("a"))&& teste4a == 0){
				str4a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4a = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("a"))&& teste5a == 0){
				str5a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5a = 1;
			}
		}
		
		xmlChart.append(str1a);
		xmlChart.append(str2a);
		xmlChart.append(str3a);
		xmlChart.append(str4a);
		xmlChart.append(str5a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";
		String str2b = "<set value='0' />";
		String str3b = "<set value='0' />";
		String str4b = "<set value='0' />";
		String str5b = "<set value='0' />";
		
		int teste1b = 0;
		int teste2b = 0;
		int teste3b = 0;
		int teste4b = 0;
		int teste5b = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("b"))&& teste2b == 0){
				str2b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("b"))&& teste3b == 0){
				str3b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("b"))&& teste4b == 0){
				str4b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4b = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("b"))&& teste5b == 0){
				str5b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5b = 1;
			}
		}
		
		xmlChart.append(str1b);
		xmlChart.append(str2b);
		xmlChart.append(str3b);
		xmlChart.append(str4b);
		xmlChart.append(str5b);
		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";
		String str2c = "<set value='0' />";
		String str3c = "<set value='0' />";
		String str4c = "<set value='0' />";
		String str5c = "<set value='0' />";
		
		int teste1c = 0;
		int teste2c = 0;
		int teste3c = 0;
		int teste4c = 0;
		int teste5c = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("c"))&& teste2c == 0){
				str2c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("c"))&& teste3c == 0){
				str3c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("c"))&& teste4c == 0){
				str4c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4c = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("c"))&& teste5c == 0){
				str5c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5c = 1;
			}
		}
		
		xmlChart.append(str1c);
		xmlChart.append(str2c);
		xmlChart.append(str3c);
		xmlChart.append(str4c);
		xmlChart.append(str5c);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";
		String str2d = "<set value='0' />";
		String str3d = "<set value='0' />";
		String str4d = "<set value='0' />";
		String str5d = "<set value='0' />";
		
		int teste1d = 0;
		int teste2d = 0;
		int teste3d = 0;
		int teste4d = 0;
		int teste5d = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("d"))&& teste2d == 0){
				str2d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("d"))&& teste3d == 0){
				str3d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste3d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("d"))&& teste4d == 0){
				str4d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4d = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("d"))&& teste5d == 0){
				str5d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5d = 1;
			}
		}
		
		xmlChart.append(str1d);
		xmlChart.append(str2d);
		xmlChart.append(str3d);
		xmlChart.append(str4d);
		xmlChart.append(str5d);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	
	public static StringBuilder gera1620XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "16";
		String questao2 = "17";
		String questao3 = "18";
		String questao4 = "19";
		String questao5 = "20";
	
		StringBuilder xmlChart = new StringBuilder();
		

		xmlChart.append("<chart showPrintMenuItem = '1'  baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentadas de "+questao1+" à "+questao5+" - "+conciliacoes.get(1).getEquipe()+" - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"' valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao5)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
		String str2a = "<set value='0' />";
		String str3a = "<set value='0' />";
		String str4a = "<set value='0' />";
		String str5a = "<set value='0' />";
		
		int teste1a = 0;
		int teste2a = 0;
		int teste3a = 0;
		int teste4a = 0;
		int teste5a = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("a"))&& teste2a == 0){
				str2a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("a"))&& teste3a == 0){
				str3a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("a"))&& teste4a == 0){
				str4a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4a = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("a"))&& teste5a == 0){
				str5a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5a = 1;
			}
		}
		
		xmlChart.append(str1a);
		xmlChart.append(str2a);
		xmlChart.append(str3a);
		xmlChart.append(str4a);
		xmlChart.append(str5a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";
		String str2b = "<set value='0' />";
		String str3b = "<set value='0' />";
		String str4b = "<set value='0' />";
		String str5b = "<set value='0' />";
		
		int teste1b = 0;
		int teste2b = 0;
		int teste3b = 0;
		int teste4b = 0;
		int teste5b = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("b"))&& teste2b == 0){
				str2b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("b"))&& teste3b == 0){
				str3b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("b"))&& teste4b == 0){
				str4b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4b = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("b"))&& teste5b == 0){
				str5b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5b = 1;
			}
		}
		
		xmlChart.append(str1b);
		xmlChart.append(str2b);
		xmlChart.append(str3b);
		xmlChart.append(str4b);
		xmlChart.append(str5b);
		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";
		String str2c = "<set value='0' />";
		String str3c = "<set value='0' />";
		String str4c = "<set value='0' />";
		String str5c = "<set value='0' />";
		
		int teste1c = 0;
		int teste2c = 0;
		int teste3c = 0;
		int teste4c = 0;
		int teste5c = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("c"))&& teste2c == 0){
				str2c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("c"))&& teste3c == 0){
				str3c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("c"))&& teste4c == 0){
				str4c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4c = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("c"))&& teste5c == 0){
				str5c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5c = 1;
			}
		}
		
		xmlChart.append(str1c);
		xmlChart.append(str2c);
		xmlChart.append(str3c);
		xmlChart.append(str4c);
		xmlChart.append(str5c);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";
		String str2d = "<set value='0' />";
		String str3d = "<set value='0' />";
		String str4d = "<set value='0' />";
		String str5d = "<set value='0' />";
		
		int teste1d = 0;
		int teste2d = 0;
		int teste3d = 0;
		int teste4d = 0;
		int teste5d = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("d"))&& teste2d == 0){
				str2d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("d"))&& teste3d == 0){
				str3d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste3d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("d"))&& teste4d == 0){
				str4d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4d = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("d"))&& teste5d == 0){
				str5d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5d = 1;
			}
		}
		
		xmlChart.append(str1d);
		xmlChart.append(str2d);
		xmlChart.append(str3d);
		xmlChart.append(str4d);
		xmlChart.append(str5d);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	public static StringBuilder gera2125XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "21";
		String questao2 = "22";
		String questao3 = "23";
		String questao4 = "24";
	
	
		StringBuilder xmlChart = new StringBuilder();
		

		xmlChart.append("<chart baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentadas de "+questao1+" à "+questao4+" - "+conciliacoes.get(1).getEquipe()+" - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"' valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao4)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
		String str2a = "<set value='0' />";
		String str3a = "<set value='0' />";
		String str4a = "<set value='0' />";
		String str5a = "<set value='0' />";
		
		int teste1a = 0;
		int teste2a = 0;
		int teste3a = 0;
		int teste4a = 0;
		int teste5a = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("a"))&& teste2a == 0){
				str2a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("a"))&& teste3a == 0){
				str3a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("a"))&& teste4a == 0){
				str4a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4a = 1;
			}
			
		}
		
		xmlChart.append(str1a);
		xmlChart.append(str2a);
		xmlChart.append(str3a);
		xmlChart.append(str4a);
		
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";
		String str2b = "<set value='0' />";
		String str3b = "<set value='0' />";
		String str4b = "<set value='0' />";
		
		
		int teste1b = 0;
		int teste2b = 0;
		int teste3b = 0;
		int teste4b = 0;
		
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("b"))&& teste2b == 0){
				str2b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("b"))&& teste3b == 0){
				str3b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("b"))&& teste4b == 0){
				str4b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4b = 1;
			}
			
		}
		
		xmlChart.append(str1b);
		xmlChart.append(str2b);
		xmlChart.append(str3b);
		xmlChart.append(str4b);
		
		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";
		String str2c = "<set value='0' />";
		String str3c = "<set value='0' />";
		String str4c = "<set value='0' />";
		
		
		int teste1c = 0;
		int teste2c = 0;
		int teste3c = 0;
		int teste4c = 0;
	
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("c"))&& teste2c == 0){
				str2c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("c"))&& teste3c == 0){
				str3c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("c"))&& teste4c == 0){
				str4c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4c = 1;
			}
			
		}
		
		xmlChart.append(str1c);
		xmlChart.append(str2c);
		xmlChart.append(str3c);
		xmlChart.append(str4c);
		
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";
		String str2d = "<set value='0' />";
		String str3d = "<set value='0' />";
		String str4d = "<set value='0' />";
	
		
		int teste1d = 0;
		int teste2d = 0;
		int teste3d = 0;
		int teste4d = 0;
		
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("d"))&& teste2d == 0){
				str2d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("d"))&& teste3d == 0){
				str3d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste3d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("d"))&& teste4d == 0){
				str4d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4d = 1;
			}
			
		}
		
		xmlChart.append(str1d);
		xmlChart.append(str2d);
		xmlChart.append(str3d);
		xmlChart.append(str4d);
		
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	public static StringBuilder gera2630XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "26";
		String questao2 = "27";
		String questao3 = "28";
		String questao4 = "29";
		String questao5 = "30";
	
		StringBuilder xmlChart = new StringBuilder();
		

		xmlChart.append("<chart  showPrintMenuItem = '1' baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentadas de "+questao1+" à "+questao5+" - "+conciliacoes.get(1).getEquipe()+"  - Participantes: "+equipe.getQtde()+"' valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao5)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
		String str2a = "<set value='0' />";
		String str3a = "<set value='0' />";
		String str4a = "<set value='0' />";
		String str5a = "<set value='0' />";
		
		int teste1a = 0;
		int teste2a = 0;
		int teste3a = 0;
		int teste4a = 0;
		int teste5a = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("a"))&& teste2a == 0){
				str2a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("a"))&& teste3a == 0){
				str3a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("a"))&& teste4a == 0){
				str4a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4a = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("a"))&& teste5a == 0){
				str5a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5a = 1;
			}
		}
		
		xmlChart.append(str1a);
		xmlChart.append(str2a);
		xmlChart.append(str3a);
		xmlChart.append(str4a);
		xmlChart.append(str5a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";
		String str2b = "<set value='0' />";
		String str3b = "<set value='0' />";
		String str4b = "<set value='0' />";
		String str5b = "<set value='0' />";
		
		int teste1b = 0;
		int teste2b = 0;
		int teste3b = 0;
		int teste4b = 0;
		int teste5b = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("b"))&& teste2b == 0){
				str2b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("b"))&& teste3b == 0){
				str3b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("b"))&& teste4b == 0){
				str4b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4b = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("b"))&& teste5b == 0){
				str5b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5b = 1;
			}
		}
		
		xmlChart.append(str1b);
		xmlChart.append(str2b);
		xmlChart.append(str3b);
		xmlChart.append(str4b);
		xmlChart.append(str5b);
		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";
		String str2c = "<set value='0' />";
		String str3c = "<set value='0' />";
		String str4c = "<set value='0' />";
		String str5c = "<set value='0' />";
		
		int teste1c = 0;
		int teste2c = 0;
		int teste3c = 0;
		int teste4c = 0;
		int teste5c = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("c"))&& teste2c == 0){
				str2c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("c"))&& teste3c == 0){
				str3c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("c"))&& teste4c == 0){
				str4c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4c = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("c"))&& teste5c == 0){
				str5c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5c = 1;
			}
		}
		
		xmlChart.append(str1c);
		xmlChart.append(str2c);
		xmlChart.append(str3c);
		xmlChart.append(str4c);
		xmlChart.append(str5c);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";
		String str2d = "<set value='0' />";
		String str3d = "<set value='0' />";
		String str4d = "<set value='0' />";
		String str5d = "<set value='0' />";
		
		int teste1d = 0;
		int teste2d = 0;
		int teste3d = 0;
		int teste4d = 0;
		int teste5d = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("d"))&& teste2d == 0){
				str2d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("d"))&& teste3d == 0){
				str3d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste3d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("d"))&& teste4d == 0){
				str4d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4d = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("d"))&& teste5d == 0){
				str5d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5d = 1;
			}
		}
		
		xmlChart.append(str1d);
		xmlChart.append(str2d);
		xmlChart.append(str3d);
		xmlChart.append(str4d);
		xmlChart.append(str5d);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	
	public static StringBuilder gera3136XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "31";
		String questao2 = "32";
		String questao3 = "33";
		String questao4 = "34";
		String questao5 = "35";
		String questao6 = "36";
	
		StringBuilder xmlChart = new StringBuilder();
		

		xmlChart.append("<chart  showPrintMenuItem = '1' baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentadas de "+questao1+" à "+questao6+" - - "+conciliacoes.get(1).getEquipe()+"  - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"' valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao6)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
		String str2a = "<set value='0' />";
		String str3a = "<set value='0' />";
		String str4a = "<set value='0' />";
		String str5a = "<set value='0' />";
		String str6a = "<set value='0' />";
		
		int teste1a = 0;
		int teste2a = 0;
		int teste3a = 0;
		int teste4a = 0;
		int teste5a = 0;
		int teste6a = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("a"))&& teste2a == 0){
				str2a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("a"))&& teste3a == 0){
				str3a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("a"))&& teste4a == 0){
				str4a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4a = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("a"))&& teste5a == 0){
				str5a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5a = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao6) && pesquisa1.getLetra().equals("a"))&& teste6a == 0){
				str6a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste6a = 1;
			}
		}
		
		xmlChart.append(str1a);
		xmlChart.append(str2a);
		xmlChart.append(str3a);
		xmlChart.append(str4a);
		xmlChart.append(str5a);
		xmlChart.append(str6a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";
		String str2b = "<set value='0' />";
		String str3b = "<set value='0' />";
		String str4b = "<set value='0' />";
		String str5b = "<set value='0' />";
		String str6b = "<set value='0' />";
		
		int teste1b = 0;
		int teste2b = 0;
		int teste3b = 0;
		int teste4b = 0;
		int teste5b = 0;
		int teste6b = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("b"))&& teste2b == 0){
				str2b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("b"))&& teste3b == 0){
				str3b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("b"))&& teste4b == 0){
				str4b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4b = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("b"))&& teste5b == 0){
				str5b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5b = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao6) && pesquisa1.getLetra().equals("b"))&& teste6b == 0){
				str6b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste6b = 1;
			}
		}
		
		xmlChart.append(str1b);
		xmlChart.append(str2b);
		xmlChart.append(str3b);
		xmlChart.append(str4b);
		xmlChart.append(str5b);
		xmlChart.append(str6b);
		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";
		String str2c = "<set value='0' />";
		String str3c = "<set value='0' />";
		String str4c = "<set value='0' />";
		String str5c = "<set value='0' />";
		String str6c = "<set value='0' />";
		
		int teste1c = 0;
		int teste2c = 0;
		int teste3c = 0;
		int teste4c = 0;
		int teste5c = 0;
		int teste6c = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("c"))&& teste2c == 0){
				str2c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("c"))&& teste3c == 0){
				str3c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2c = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("c"))&& teste4c == 0){
				str4c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4c = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("c"))&& teste5c == 0){
				str5c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5c = 1;
			}
			if((pesquisa1.getNumero().equals(questao6) && pesquisa1.getLetra().equals("c"))&& teste6c == 0){
				str6c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste6c = 1;
			}
		}
		
		xmlChart.append(str1c);
		xmlChart.append(str2c);
		xmlChart.append(str3c);
		xmlChart.append(str4c);
		xmlChart.append(str5c);
		xmlChart.append(str6c);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";
		String str2d = "<set value='0' />";
		String str3d = "<set value='0' />";
		String str4d = "<set value='0' />";
		String str5d = "<set value='0' />";
		String str6d = "<set value='0' />";
		
		int teste1d = 0;
		int teste2d = 0;
		int teste3d = 0;
		int teste4d = 0;
		int teste5d = 0;
		int teste6d = 0;
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao2) && pesquisa1.getLetra().equals("d"))&& teste2d == 0){
				str2d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste2d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao3) && pesquisa1.getLetra().equals("d"))&& teste3d == 0){
				str3d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste3d = 1;
			}
			
			if((pesquisa1.getNumero().equals(questao4) && pesquisa1.getLetra().equals("d"))&& teste4d == 0){
				str4d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste4d = 1;
			}
			if((pesquisa1.getNumero().equals(questao5) && pesquisa1.getLetra().equals("d"))&& teste5d == 0){
				str5d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste5d = 1;
			}
			if((pesquisa1.getNumero().equals(questao6) && pesquisa1.getLetra().equals("d"))&& teste6d == 0){
				str6d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste6d = 1;
			}
		}
		
		xmlChart.append(str1d);
		xmlChart.append(str2d);
		xmlChart.append(str3d);
		xmlChart.append(str4d);
		xmlChart.append(str5d);
		xmlChart.append(str6d);
		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	
	public static StringBuilder gera39XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "39";
		
	
		StringBuilder xmlChart = new StringBuilder();
		
	
		xmlChart.append("<chart  showPrintMenuItem = '1' baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentada "+questao1+" - "+conciliacoes.get(1).getEquipe()+" - Participantes: "+equipe.getQtde()+"' valueFontSize ='"+valorFontSize+"' decimals = '"+decimal+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao1)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
	
		
		int teste1a = 0;
	
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			
		}
		
		xmlChart.append(str1a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";

		
		int teste1b = 0;

		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
		}
		
		xmlChart.append(str1b);

		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito'>");
		
		String str1c = "<set value='0' />";

		
		int teste1c = 0;

		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			

		}
		
		xmlChart.append(str1c);

		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não se aplica'>");
		
		String str1d = "<set value='0' />";

		
		int teste1d = 0;

		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			

		}
		
		xmlChart.append(str1d);

		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	
	public static StringBuilder gera25XML(
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		int numero = 0;
		String questao1 = "25";
		
	
		StringBuilder xmlChart = new StringBuilder();
		
	
		xmlChart.append("<chart  showPrintMenuItem = '1' baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questões Apresentada "+questao1+" - "+conciliacoes.get(1).getEquipe()+"  - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"' valueFontSize ='"+valorFontSize+"' xaxisname='Questões' yaxisname='Percentagem' numbersuffix='%' plotfillalpha='80' palettecolors='#32CD32,#FFFF00,#FF0000,#8B8989' basefontcolor='#333333' basefont='Helvetica Neue,Arial' captionfontsize='20' subcaptionfontsize='20' subcaptionfontbold='0' showborder='0' bgcolor='#ffffff' showshadow='0' canvasbgcolor='#ffffff' canvasborderalpha='0' divlinealpha='100' divlinecolor='#999999' divlinethickness='1' divlineisdashed='1' divlinedashlen='1' divlinegaplen='1' useplotgradientcolor='0' showplotborder='0' valuefontcolor='#000000' placevaluesinside='0' showhovereffect='1' rotatevalues='0' showxaxisline='1' xaxislinethickness='1' xaxislinecolor='#999999' showalternatehgridcolor='0' legendbgalpha='0' legendborderalpha='0' legendshadow='0' legenditemfontsize='15' legenditemfontcolor='#666666'>");

		xmlChart.append("<categories>");
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= Integer.parseInt(questao1)
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= Integer.parseInt(questao1)) {

				if (numero != Integer.parseInt(conciliacoes.get(i).getNumero())) {
					xmlChart.append("<category label='"
							+ conciliacoes.get(i).getNumero() + "-"
							+ conciliacoes.get(i).getDescricaoQuestao()
							+ "' />");
					numero = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

			}

		}
		
		xmlChart.append("</categories>");
		
		xmlChart.append("<dataset seriesname='Satisfeito'>");
		
		String str1a = "<set value='0' />";
	
		
		int teste1a = 0;
	
		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("a"))&& teste1a == 0){
				str1a = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1a = 1;
			}
			
			
		}
		
		xmlChart.append(str1a);
		xmlChart.append("</dataset>");
		
		xmlChart.append("<dataset seriesname='Mais ou menos'>");
		
		String str1b = "<set value='0' />";

		
		int teste1b = 0;

		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("b"))&& teste1b == 0){
				str1b = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1b = 1;
			}
			
		}
		
		xmlChart.append(str1b);

		xmlChart.append("</dataset>");
		
	
		
		xmlChart.append("<dataset seriesname='Não Satisfeito, pois o que é exigido está acima das minhas possibilidades'>");
		
		String str1c = "<set value='0' />";

		
		int teste1c = 0;

		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("c"))&& teste1c == 0){
				str1c = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1c = 1;
			}
			

		}
		
		xmlChart.append(str1c);

		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("<dataset seriesname='Não satisfeito, pois o que é exigido está abaixo da minha capacidade'>");
		
		String str1d = "<set value='0' />";

		
		int teste1d = 0;

		for(PesquisaConciliacao pesquisa1 : conciliacoes){
			
			if((pesquisa1.getNumero().equals(questao1) && pesquisa1.getLetra().equals("d"))&& teste1d == 0){
				str1d = "<set value='"+pesquisa1.getTotal()+"' />";
				teste1d = 1;
			}
			

		}
		
		xmlChart.append(str1d);

		xmlChart.append("</dataset>");
		
		
		
		xmlChart.append("</chart>");
		
		
		
		
		return xmlChart;

	}
	public static StringBuilder geraMiltiplaXML(String numeroQuestao,
			ArrayList<PesquisaConciliacao> conciliacoes, PesquisaEquipe equipe) {

		String name = "";
		StringBuilder xmlChart = new StringBuilder();

		xmlChart.append("<chart  showPrintMenuItem = '1'  baseFontSize = '"+baseFontSize+"' exportShowMenuItem='1' exportEnabled = '1' caption='Questào de nàmero " + numeroQuestao
				+ " - - "+conciliacoes.get(1).getEquipe()+" - Participantes: "+equipe.getQtde()+"' decimals = '"+decimal+"' xaxisname='Questào: " + numeroQuestao
				+ "' yaxisname='Percentagem' numbersuffix='%' rotatevalues='0' theme='fint' valueFontSize ='"+valorFontSize+"'>");

		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) == Integer
					.parseInt(numeroQuestao)) {

				xmlChart.append("<set label='" + conciliacoes.get(i).getLetra()
						+ " - " + conciliacoes.get(i).getDescricao()
						+ "' value='" + conciliacoes.get(i).getTotal() + "' />");

				name = numeroQuestao + " - "
						+ conciliacoes.get(i).getDescricaoQuestao();

			}

		}
		xmlChart.append("</chart>");

		return xmlChart;

	}
}
