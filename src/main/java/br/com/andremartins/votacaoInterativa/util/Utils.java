package br.com.andremartins.votacaoInterativa.util;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.com.andremartins.votacaoInterativa.model.PesquisaConciliacao;



public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public Object[][] geraGrafico(ArrayList<PesquisaConciliacao> conciliacoes,
			int inicial, int ultimo, int tamanho) {

		Object[][] result = new Object[tamanho + 1][5];

		result[0][0] = "A Voz Do Cliente";
		result[0][1] = "Satisfeito";
		result[0][2] = "Mais ou Menos";
		result[0][3] = "N�o satisfeito";
		result[0][4] = "N�o se Aplica";

		int z = inicial;
		int alternativa = 1;
		int cont = 1;
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) >= inicial
					&& Integer.parseInt(conciliacoes.get(i).getNumero()) <= ultimo) {

				if (z != Integer.parseInt(conciliacoes.get(i).getNumero())
						&& cont <= 5) {
					cont++;

					z = Integer.parseInt(conciliacoes.get(i).getNumero());
				}

				result[cont][0] = z + " - "
						+ conciliacoes.get(i).getDescricaoQuestao();

				if (conciliacoes.get(i).getLetra().equals("a"))
					result[cont][1] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("b"))
					result[cont][2] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("c"))
					result[cont][3] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("d"))
					result[cont][4] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

			}

		}

		return result;
	}

	public Object[][] geraGraficoCompleto(
			ArrayList<PesquisaConciliacao> conciliacoes) {
		Object[][] result = new Object[37][5];

		result[0][0] = "A Voz Do Cliente";
		result[0][1] = "N�o se Aplica";
		result[0][2] = "N�o satisfeito";
		result[0][3] = "Mais ou Menos";
		result[0][4] = "Satisfeito";

		int z = 1;
		int alternativa = 1;
		for (int i = 0; i < conciliacoes.size(); i++) {

			if (Integer.parseInt(conciliacoes.get(i).getNumero()) <= 36) {

				if (z != Integer.parseInt(conciliacoes.get(i).getNumero()))
					z = Integer.parseInt(conciliacoes.get(i).getNumero());

				result[z][0] = z + " - "
						+ conciliacoes.get(i).getDescricaoQuestao();

				if (conciliacoes.get(i).getLetra().equals("d"))
					result[z][1] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("c"))
					result[z][2] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("b"))
					result[z][3] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

				if (conciliacoes.get(i).getLetra().equals("a"))
					result[z][4] = Integer.parseInt(conciliacoes.get(i)
							.getTotal());

			}

		}

		return result;
	}

	public Object[][] geraGraficoMulti(
			ArrayList<PesquisaConciliacao> conciliacoes, int tamanho,
			int questao) {

		Object[][] result = new Object[2][tamanho + 1];
	
		result[0][0] = "A Voz Do Cliente";

		if (questao == 37) {

			result[0][1] = "Humor deprimido: (tristeza prolongada, demorada, por qualquer causa, que demora a passar).";
			result[0][2] = "Sensa��o de fraqueza, fadiga, cansa�o acentuado.";
			result[0][3] = "Irritabilidade, tens�o, nervosismo, inquieta��o.";
			result[0][4] = "Agressividade.";
			result[0][5] = "Mudan�a importante de humor: mudan�a de tristeza para alegria, sem causa aparente ou por qualquer causa.";
			result[0][6] = "Altera��es importantes no apetite:diminui��o ou aumento excessivo/anormal do apetite.";
			result[0][7] = "Altera��es do sono: falta, diminui��o ou excesso de sono.";
			result[0][8] = "Esquecimento f�cil.";
			result[0][9] = "Dificuldade de concentra��o, concentra��o diminu�da.";
			result[0][10] = "Dificuldade de aprendizado; dificuldade em aprender.";
			result[0][11] = "Queda da autoestima; diminui��o do gostar de si pr�prio;";
			result[0][12] = "Pessimismo, desesperan�a.";
			result[0][13] = "Queda da autoconfian�a; inseguran�a.";
			result[0][14] = "Abuso de bebidas alco�licas.";
			result[0][15] = "Uso, ou o aumento do uso de drogas.";
			result[0][16] = "Descaso com cuidados pessoais; desleixo com os cuidados pessoais de higiene, alimenta��o, etc.";
			result[0][17] = "Ideia de autoagress�o ou suic�dio.";

		} else if (questao == 38) {

			result[0][1] = "pesco�o";
			result[0][2] = "ombro";
			result[0][3] = "costas";
			result[0][4] = "bra�os";
			result[0][5] = "cotovelos";
			result[0][6] = "antebra�os";
			result[0][7] = "punhos";
			result[0][8] = "m�os";
			result[0][9] = "dedos";
			result[0][10] = "quadris";
			result[0][11] = "coxas";
			result[0][12] = "joelhos";
			result[0][13] = "pernas";
			result[0][14] = "tornozelos";
			result[0][15] = "p�s";

		}

		for (int x = 1; x < conciliacoes.size(); x++) {

			if (Integer.parseInt(conciliacoes.get(x).getNumero()) == questao) {
				result[1][0] = conciliacoes.get(x).getDescricaoQuestao();
				if (conciliacoes.get(x).getLetra().equals("a"))
					result[1][1] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("b"))
					result[1][2] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("c"))
					result[1][3] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("d"))
					result[1][4] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("e"))
					result[1][5] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("f"))
					result[1][6] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("g"))
					result[1][7] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("h"))
					result[1][8] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("i"))
					result[1][9] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("j"))
					result[1][10] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("k"))
					result[1][11] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("l"))
					result[1][12] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("m"))
					result[1][13] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("n"))
					result[1][14] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("o"))
					result[1][15] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("p"))
					result[1][16] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
				if (conciliacoes.get(x).getLetra().equals("q"))
					result[1][17] = Integer.parseInt(conciliacoes.get(x)
							.getTotal());
			}

		}

		return result;
	}

	public static String[] splitString(String texto) {

		String[] splitado = texto.split(".");

		return splitado;
	}

	public static boolean validaIp(String parametro) {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("select valor from config where parametro = '"
							+ parametro + "';");

			while (rs.next()) {

				if (rs.getString("valor").equals("true")) {
					stmt.close();
					c.close();

					return true;
				}
			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return false;
	}

	public static void atualizarValidaIP(String status) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarJDBC();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE config ");
			sql.append("Set ");

			sql.append("valor = '" + status + "'");
			sql.append(" Where ");
			sql.append("parametro ='validaIp'");
			stmt.executeUpdate(sql.toString());

			c.commit();

			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

		}

	}

	public static boolean validaQuestao(String parametro) {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("select valor from config where parametro = '"
							+ parametro + "';");

			while (rs.next()) {

				if (rs.getString("valor").equals("true")) {
					stmt.close();
					c.close();

					return true;
				}
			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return false;
	}

	public static void atualizarValidaQuestao(String status) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarJDBC();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE config ");
			sql.append("Set ");

			sql.append("valor = '" + status + "'");
			sql.append(" Where ");
			sql.append("parametro ='validaQuestao'");
			stmt.executeUpdate(sql.toString());

			c.commit();

			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

		}

	}
	
	public static boolean consultaValidaQuestao() {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("select valor from config where parametro = 'validaQuestao'");

			while (rs.next()) {

				if (rs.getString("valor").equals("true")) {
					stmt.close();
					c.close();
					
					return true;
				}
			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return false;
	}

	
	public static boolean consultaValidaIp() {

		Statement stmt = null;
		ResultSet rs = null;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("select valor from config where parametro = 'validaIp'");

			while (rs.next()) {

				if (rs.getString("valor").equals("true")) {
					stmt.close();
					c.close();
					
					return true;
				}
			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return false;
	}

	public static String logsPesquisa(int id) {
		int count = 1;
		Statement stmt = null;
		ResultSet rs = null;
		File file = new File(id+" - "+System.currentTimeMillis()+".txt");

		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt.executeQuery("select e.nomeequipe, p.question,a.letter, a.text, p.ip from pesquisas p, equipe e, alternatives a where  p.id_equipe = "+id+" and p.id_equipe = e.id and p.alternative_id = a.id;");

			while (rs.next()) {
			String s = rs.getString("nomeequipe")+", "+ rs.getInt("question")+", "+rs.getString("letter")+", "+rs.getString("text")+", Id do sispositivo = "+rs.getString("ip");
				
				System.out.println(s.replaceAll("\n", ""));
				writer.write(s.replaceAll("\n", "") );	
				writer.newLine();
		
			}
			writer.flush();
			writer.close();
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}
		
		return file.toString();

	}
	
	
}
