package br.com.andremartins.votacaoInterativa.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.PesquisaConciliacao;
import br.com.andremartins.votacaoInterativa.model.PesquisaEquipe;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;

public class PesquisaConciliacaoDao {

	public PesquisaConciliacaoDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<PesquisaConciliacao> listarTodasConciliacoes(int id) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaConciliacao> conciliacoes = new ArrayList<PesquisaConciliacao>();

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			String sql = "select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total "
					+ "from " + "pesquisas p, questions q, alternatives a, equipe e " + "where p.id_equipe = e.id "
					+ "and p.question = q.id " + "and p.alternative_id = a.id " + "and p.id_equipe = '" + id + "' " +

					"group by p.alternative_id,  equipe , numero, descricaoquestao, letra, descriccao "
					+ "order by p.question;";
			System.out.println("1 - " + sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PesquisaConciliacao conciliacao = new PesquisaConciliacao(rs.getString("equipe"),
						rs.getString("numero"), rs.getString("descricaoquestao"), rs.getString("letra"),
						rs.getString("descriccao"), rs.getString("total"));

				conciliacoes.add(conciliacao);

			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacoes;
	}

	public ArrayList<PesquisaConciliacao> listarCampoeasInsatisfacao(int id) {
		int countId = 1;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaConciliacao> conciliacoes = new ArrayList<PesquisaConciliacao>();

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			String sql = "select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total "
					+ "from " + "pesquisas p, questions q, alternatives a, equipe e " + "where p.id_equipe = e.id "
					+ "and p.question = q.id " + "and p.alternative_id = a.id "
					+ "and (a.letter = 'c' or a.letter = 'd') " + "and a.text <> 'N??o se aplica' "
					+ "and p.question not in ('37','38') " + "and p.id_equipe = '" + id + "' "
					+ "group by numero, equipe, descricaoquestao, letra, descriccao " + "order by total desc;";
			System.out.println("2 - " + sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PesquisaConciliacao conciliacao = new PesquisaConciliacao(rs.getString("equipe"),
						rs.getString("numero"), rs.getString("descricaoquestao"), rs.getString("letra"),
						rs.getString("descriccao"), rs.getString("total"));

				conciliacao.setId(countId);
				conciliacoes.add(conciliacao);
				countId++;
			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacoes;
	}

	public ArrayList<PesquisaConciliacao> listarCampoeasSatisfacao(int id) {
		int countId = 1;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaConciliacao> conciliacoes = new ArrayList<PesquisaConciliacao>();

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			String sql = "select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total "
					+ "from " + "pesquisas p, questions q, alternatives a, equipe e " + "where p.id_equipe = e.id "
					+ "and p.question = q.id " + "and p.alternative_id = a.id " + "and a.letter = 'a' "
					+ "and a.text <> 'N??o se aplica' " + "and p.question not in ('37','38') " + "and p.id_equipe = '"
					+ id + "' " + "group by numero, equipe, descricaoquestao, letra, descriccao "
					+ "order by total desc;";

			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PesquisaConciliacao conciliacao = new PesquisaConciliacao(rs.getString("equipe"),
						rs.getString("numero"), rs.getString("descricaoquestao"), rs.getString("letra"),
						rs.getString("descriccao"), rs.getString("total"));

				conciliacao.setId(countId);
				conciliacoes.add(conciliacao);
				countId++;
			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacoes;
	}

	public ArrayList<PesquisaConciliacao> listarCampoeasSatisfacaoProjeto(int[] id) {
		int count = id.length;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaConciliacao> conciliacoes = new ArrayList<PesquisaConciliacao>();
		StringBuilder sql;
		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append(
					"select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total ");
			sql.append("from ");
			sql.append("pesquisas p, questions q, alternatives a, equipe e ");
			sql.append("where p.id_equipe = e.id ");
			sql.append("and p.question = q.id ");
			sql.append("and p.alternative_id = a.id ");
			sql.append("and a.letter = 'a' ");
			sql.append("and a.text <> 'N??o se aplica' ");
			sql.append("and p.question not in ('37','38') ");
			sql.append("and  p.id_equipe in ( ");
			for (int i = 0; i < count; i++) {
				sql.append(" " + id[i] + " ");
				if (i < count - 1) {

					sql.append(", ");

				}
			}
			sql.append(" ) ");
			sql.append("group by numero, equipe, descricaoquestao, letra, descriccao  ");
			sql.append("order by total desc;");

			System.out.println(sql.toString());

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				PesquisaConciliacao conciliacao = new PesquisaConciliacao(rs.getString("equipe"),
						rs.getString("numero"), rs.getString("descricaoquestao"), rs.getString("letra"),
						rs.getString("descriccao"), rs.getString("total"));

				conciliacoes.add(conciliacao);

			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacoes;
	}

	public ArrayList<PesquisaConciliacao> listarCampoeasInsatisfacaoProjeto(int[] id) {
		int count = id.length;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaConciliacao> conciliacoes = new ArrayList<PesquisaConciliacao>();
		StringBuilder sql;
		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append(
					"select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total ");
			sql.append("from ");
			sql.append("pesquisas p, questions q, alternatives a, equipe e ");
			sql.append("where p.id_equipe = e.id ");
			sql.append("and p.question = q.id ");
			sql.append("and p.alternative_id = a.id ");
			sql.append("and (a.letter = 'c' or a.letter = 'd') ");
			sql.append("and a.text <> 'N???o se aplica' ");
			sql.append("and p.question not in ('37','38') ");
			sql.append("and  p.id_equipe in ( ");
			for (int i = 0; i < count; i++) {
				sql.append(" " + id[i] + " ");
				if (i < count - 1) {

					sql.append(", ");

				}
			}
			sql.append(" ) ");
			sql.append("group by numero, equipe, descricaoquestao, letra, descriccao  ");
			sql.append("order by total desc;");

			System.out.println(sql.toString());
			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				PesquisaConciliacao conciliacao = new PesquisaConciliacao(rs.getString("equipe"),
						rs.getString("numero"), rs.getString("descricaoquestao"), rs.getString("letra"),
						rs.getString("descriccao"), rs.getString("total"));

				conciliacoes.add(conciliacao);

			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacoes;
	}

	public String roundValue(Float f) {

		int casasDecimais = 1;
		BigDecimal aNumber = new BigDecimal(f);
		aNumber = aNumber.setScale(casasDecimais, BigDecimal.ROUND_HALF_UP);
		double value = aNumber.doubleValue();
		return String.valueOf(value);
	}

	public ArrayList<PesquisaConciliacao> listarTodasConciliacoesPercent(int id,
			ArrayList<PesquisaConciliacao> conciliacaoQtde) {
		DecimalFormat df = new DecimalFormat("0");
		Statement stmt = null;
		ResultSet rs = null;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaAtivaUnica(id);
			System.out.println(equipe.toString());
			String sql = "select p.question as numero, count(p.alternative_id) as total " + "from "
					+ "pesquisas p, questions q, alternatives a, equipe e " + "where p.id_equipe = e.id "
					+ "and p.question = q.id " + "and p.alternative_id = a.id " + "and p.id_equipe = '" + id + "' "
					+ "group by numero " + "order by p.question;";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				for (int i = 0; i < conciliacaoQtde.size(); i++) {

					if (conciliacaoQtde.get(i).getNumero().equals(rs.getString("numero"))) {

						if (conciliacaoQtde.get(i).getNumero().equals("37")
								|| conciliacaoQtde.get(i).getNumero().equals("38")) {

							conciliacaoQtde.get(i).setTotal(roundValue(
									(Float.parseFloat(conciliacaoQtde.get(i).getTotal()) / equipe.getQtde()) * 100));

						} else {
							conciliacaoQtde.get(i)
									.setTotal(roundValue(Float.parseFloat(conciliacaoQtde.get(i).getTotal())
											/ Float.parseFloat(rs.getString("total")) * 100));

						}

					}

				}

			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacaoQtde;
	}

	public ArrayList<PesquisaConciliacao> listarTodasConciliacoesPercent2(int[] id,
			ArrayList<PesquisaConciliacao> conciliacaoQtde) {
		NumberFormat df = new DecimalFormat("#0.0");
		Statement stmt = null;
		ResultSet rs = null;
		StringBuilder sql;
		int count = id.length;
		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			PesquisaEquipe equipe = PesquisaEquipeDao.listarPesquisaMultipla(id);

			sql = new StringBuilder();
			sql.append(
					"select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total ");
			sql.append("from ");
			sql.append("pesquisas p, questions q, alternatives a, equipe e ");
			sql.append("where p.id_equipe = e.id ");
			sql.append("and p.question = q.id ");
			sql.append("and p.alternative_id = a.id ");
			sql.append("and  p.id_equipe in ( ");
			for (int i = 0; i < count; i++) {
				sql.append(" '" + id[i] + "' ");
				if (i < count - 1) {

					sql.append(", ");

				}
			}
			sql.append(" ) ");
			sql.append("group by numero, equipe, descricaoquestao, letra, descriccao ");
			sql.append("order by p.question;");

			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				for (int i = 0; i < conciliacaoQtde.size(); i++) {

					if (conciliacaoQtde.get(i).getNumero().equals(rs.getString("numero"))) {

						if (conciliacaoQtde.get(i).getNumero().equals("37")
								|| conciliacaoQtde.get(i).getNumero().equals("38")) {

							conciliacaoQtde.get(i).setTotal(df.format(
									((Float.parseFloat(conciliacaoQtde.get(i).getTotal()) / equipe.getQtde()) * 100)));

						} else {
							conciliacaoQtde.get(i)
									.setTotal(df.format((Float.parseFloat(conciliacaoQtde.get(i).getTotal())
											/ Float.parseFloat(rs.getString("total"))) * 100));

						}

					}

				}

			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacaoQtde;
	}

	public ArrayList<PesquisaConciliacao> listarTodasConciliacoes2(int id) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaConciliacao> conciliacoes = new ArrayList<PesquisaConciliacao>();
		ArrayList<PesquisaConciliacao> conciliacoes2 = new ArrayList<PesquisaConciliacao>();

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			String sql = "select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total "
					+ "from " + "pesquisas p, questions q, alternatives a, equipe e " + "where p.id_equipe = e.id "
					+ "and p.question = q.id " + "and p.alternative_id = a.id " + "and p.id_equipe = '" + id + "' "
					+ "group by p.alternative_id,  equipe , numero, descricaoquestao, letra, descriccao "
					+ "order by p.question;";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PesquisaConciliacao conciliacao = new PesquisaConciliacao(rs.getString("equipe"),
						rs.getString("numero"), rs.getString("descricaoquestao"), rs.getString("letra"),
						rs.getString("descriccao"), rs.getString("total"));

				conciliacoes.add(conciliacao);

			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacoes;
	}

	public ArrayList<PesquisaConciliacao> listarTodasConciliacoes3(int[] id) {

		int count = id.length;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaConciliacao> conciliacoes = new ArrayList<PesquisaConciliacao>();
		ArrayList<PesquisaConciliacao> conciliacoes2 = new ArrayList<PesquisaConciliacao>();
		StringBuilder sql;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append(
					"select e.nomeequipe as equipe, p.question as numero, q.question as descricaoquestao,a.letter as letra,a.text as descriccao, count(p.alternative_id) as total ");
			sql.append("from ");
			sql.append("pesquisas p, questions q, alternatives a, equipe e ");
			sql.append("where p.id_equipe = e.id ");
			sql.append("and p.question = q.id ");
			sql.append("and p.alternative_id = a.id ");
			sql.append("and  p.id_equipe in ( ");
			for (int i = 0; i < count; i++) {
				sql.append(" '" + id[i] + "' ");
				if (i < count - 1) {

					sql.append(", ");

				}
			}
			sql.append(" ) ");
			sql.append("group by p.alternative_id,  equipe , numero, descricaoquestao, letra, descriccao ");
			sql.append("order by p.question;");
			System.out.println(sql.toString());
			rs = stmt.executeQuery(sql.toString());

			while (rs.next()) {

				PesquisaConciliacao conciliacao = new PesquisaConciliacao(rs.getString("equipe"),
						rs.getString("numero"), rs.getString("descricaoquestao"), rs.getString("letra"),
						rs.getString("descriccao"), rs.getString("total"));

				conciliacoes.add(conciliacao);

			}
			stmt.close();
			c.close();

		} catch (Exception e) {

			System.err.print(e.getMessage() + " - " + e.getStackTrace());
		}

		return conciliacoes;
	}

}
