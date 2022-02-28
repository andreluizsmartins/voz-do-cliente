package br.com.andremartins.votacaoInterativa.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.PesquisaQuestion;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;



public class PesquisaQuestionDao {

	public PesquisaQuestionDao() {
		// TODO Auto-generated constructor stub
	}

	public static void inserePesquisa(PesquisaQuestion pesquisa, String ip) {
		Statement stmt = null;
		StringBuilder sql = null;
		Integer alternative = null;

		try {
			Connection c = FabricaConexao.conectarJDBC();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("INSERT INTO pesquisas ");
			sql.append("(id_equipe, question, ip, alternative_id) ");

			sql.append("VALUES ('" + pesquisa.getId_pesquisa() + "',");

			sql.append("'" + pesquisa.getQuestion()+ "',");
			sql.append("'" + ip + "',");
			
			
			if(pesquisa.getAnswer() != 0){
				
				
				alternative = pesquisa.getAnswer();
				
			}
			
			sql.append("'" + alternative+ "')");

			stmt.executeUpdate(sql.toString());
			c.commit();
			stmt.close();
			
			c.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());
			System.out.print("Tentando novamente....\n");
			inserePesquisa(pesquisa, ip);
			System.out.print("Sucesso....\n");
		}

	}
	
	public static void inserePesquisaNull(PesquisaQuestion pesquisa, String ip) {
		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarJDBC();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("INSERT INTO pesquisas ");
			sql.append("(id_equipe, question, ip) ");

			sql.append("VALUES ('" + pesquisa.getId_pesquisa() + "',");

			sql.append("'" + pesquisa.getQuestion()+ "',");
			
			sql.append("'" + ip+ "')");

			stmt.executeUpdate(sql.toString());
			c.commit();
			stmt.close();
			
			c.close();
		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());
			System.out.print("Tentando novamente....\n");
			inserePesquisa(pesquisa, ip);
			System.out.print("Sucesso....\n");
		}

	}
	
	public static boolean readyAnswered(String id, String ip) {

		Statement stmt = null;
		ResultSet rs = null;
		

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt.executeQuery("select * from pesquisas where id_equipe = "+id+" and  ip = '"+ip+"' and question = 1;");

			while (rs.next()) {
				
				stmt.close();
				c.close();
				
				return true;

			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return false;
	}
	
	public static ArrayList<PesquisaQuestion> validacaoPesquisa(int id, int questao) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaQuestion> pesquisas = new ArrayList<PesquisaQuestion>();

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt.executeQuery("select * from pesquisas where id_equipe = '"+id+"' and question = '"+questao+"';");

			while (rs.next()) {
				
				
				
				pesquisas.add(new PesquisaQuestion(rs.getInt("id"), rs.getInt("id_equipe"), rs.getInt("alternative_id"), rs.getInt("question"), rs.getString("ip")));

			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return pesquisas;
	}

	public static int readyFollowed(String id, String question) {

		Statement stmt = null;
		ResultSet rs = null;
		int total= 0;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt.executeQuery("select count(distinct ip) as total from pesquisas where id_equipe = "+id+" and  question = "+question);

			while (rs.next()) {
				
				total = rs.getInt("total");

			}
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return total;
	}
	
	public static boolean readyFollowedValidate(String id, String question, String ip) {

		Statement stmt = null;
		ResultSet rs = null;
		int total= 0;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			String query = "select * from pesquisas where id_equipe = "+id+" and  question = "+question+" and  ip = '"+ip+"'"; 
			
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				
				
				stmt.close();
				c.close();
				return true;

			}
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return false;
	}
	
	public static void validaPesquisaCompleta(int id) {

		Statement stmt = null;
		Statement stmtDel = null;
		ResultSet rs = null;
		int total= 0;

		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			stmtDel = c.createStatement();
			
			rs = stmt.executeQuery("select count(*) as total, ip from pesquisas where id_equipe = "+id+" and question not in (37,38) group by ip");

			while (rs.next()) {
				
				if(rs.getInt("total") < 37){
					System.out.println("[Alerta]As respostas do dispositivo "+rs.getString("ip")+" est�o incompletas e ser�o descartadas.");
					stmtDel.executeUpdate("DELETE from pesquisas where id_equipe="+id+" and ip = '"+rs.getString("ip")+"'; ");
					System.out.println("[Alerta]As respostas do dispositivo "+rs.getString("ip")+" foram descartadas.");
				}

			}
			
			stmt.close();
			stmtDel.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		
	}
}
