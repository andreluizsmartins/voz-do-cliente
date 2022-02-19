package br.com.andremartins.votacaoInterativa.dao;



import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.PesquisaConciliacao;
import br.com.andremartins.votacaoInterativa.model.Satisfacao;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;


public class SatisfacaoDao {

	public SatisfacaoDao() {
		// TODO Auto-generated constructor stub
	}

	public static boolean existeSatisfacao(int id, String i) {

		Connection c = FabricaConexao.conectarSQLITE();
		Statement stmt = null;
		ResultSet rs = null;
		

		try {

			
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from campeas where id_equipe = '"+id+"' and tipo = '"+i+"'");

			while (rs.next()) {

				stmt.close();
				c.close();
				return true;

			}
			stmt.close();
			c.close();
			
		} catch (Exception e) {
			
			System.err.print(e.getMessage()+" -!! "+e.getStackTrace());
		}
		
		return false;
	}
	
	public static void insereSatisfacao(PesquisaConciliacao conciliacao, int id_equipe, String tipo) {
		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("INSERT INTO campeas");
			sql.append("(id_equipe, letra, numero,descricaoQuestao,descricao,total, tipo) ");

			sql.append("VALUES ('" + id_equipe + "',");
			sql.append("'" + conciliacao.getLetra() + "',");
			sql.append("'" + conciliacao.getNumero() + "',");
			sql.append("'" + conciliacao.getDescricaoQuestao() + "',");
			sql.append("'" + conciliacao.getDescricao() + "',");
			sql.append("'" + conciliacao.getTotal() + "',");
			sql.append("'" + tipo + "')");

			stmt.executeUpdate(sql.toString());
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

		}

	}
	
	public static void insereSatisfacaoProjeto(PesquisaConciliacao conciliacao, int id_projeto, String tipo, String nomeRelatorio) {
		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("INSERT INTO campeas");
			sql.append("( letra, numero,descricaoQuestao,descricao,total,nome_projeto, tipo) ");

			sql.append("VALUES ('" + conciliacao.getLetra() + "',");
			
			sql.append("'" + conciliacao.getNumero() + "',");
			sql.append("'" + conciliacao.getDescricaoQuestao() + "',");
			sql.append("'" + conciliacao.getDescricao() + "',");
			sql.append("'" + conciliacao.getTotal() + "',");
			sql.append("'" + nomeRelatorio + "',");
			sql.append("'" + tipo + "')");

			stmt.executeUpdate(sql.toString());
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

		}

	}
	
	public static ArrayList<Satisfacao> listarSatisfacao(int id, String i) {
		int countId = 1;
		Connection c = FabricaConexao.conectarSQLITE();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Satisfacao> listaSatisfacao = new ArrayList<Satisfacao>();

		try {

			
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from campeas where id_equipe = '"+id+"' and tipo = '"+i+"'");

			while (rs.next()) {

				Satisfacao satisfacao = new Satisfacao(rs.getInt("id"), rs.getInt("id_equipe"), rs.getString("letra"),rs.getString("numero"), rs.getString("comentario"), rs.getString("ajustes"),rs.getString("descricao"),rs.getString("descricaoQuestao"), rs.getString("total"));
				satisfacao.setCount(countId);
				listaSatisfacao.add(satisfacao);
				countId++;
			}
			stmt.close();
			c.close();
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage()+" -!! "+e.getStackTrace());
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					);
		}
		
		return listaSatisfacao;
	}
	
	
	public static ArrayList<Satisfacao> listarSatisfacaoProjeto(String nome, String i) {
		int countId = 1;
		Connection c = FabricaConexao.conectarSQLITE();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Satisfacao> listaSatisfacao = new ArrayList<Satisfacao>();

		try {

			
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from campeas where nome_projeto = '"+nome+"' and tipo = '"+i+"'");

			while (rs.next()) {

				Satisfacao satisfacao = new Satisfacao(rs.getInt("id"), rs.getInt("id_equipe"), rs.getString("letra"),rs.getString("numero"), rs.getString("comentario"), rs.getString("ajustes"),rs.getString("descricao"),rs.getString("descricaoQuestao"), rs.getString("total"),"",rs.getString("nome_projeto"));
				satisfacao.setCount(countId);
				listaSatisfacao.add(satisfacao);
				countId++;
			}
			stmt.close();
			c.close();
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage()+" -!! "+e.getStackTrace());
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					);
		}
		
		return listaSatisfacao;
	}
	
	public static ArrayList<Satisfacao> listarSatisfacaoProjeto() {

		Connection c = FabricaConexao.conectarSQLITE();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Satisfacao> listaSatisfacao = new ArrayList<Satisfacao>();

		try {

			
			stmt = c.createStatement();
			rs = stmt.executeQuery("select * from campeas WHERE TIPO = 's' group by nome_projeto;");

			while (rs.next()) {

				Satisfacao satisfacao = new Satisfacao(rs.getInt("id"), rs.getInt("id_equipe"), rs.getString("letra"),rs.getString("numero"), rs.getString("comentario"), rs.getString("ajustes"),rs.getString("descricao"),rs.getString("descricaoQuestao"), rs.getString("total"),"", rs.getString("nome_projeto"));
		
				listaSatisfacao.add(satisfacao);

			}
			stmt.close();
			c.close();
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage()+" -!! "+e.getStackTrace());
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					);
		}
		
		return listaSatisfacao;
	}
	public static ArrayList<Satisfacao> listarInsatisfacaoProjeto() {

		Connection c = FabricaConexao.conectarSQLITE();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Satisfacao> listaSatisfacao = new ArrayList<Satisfacao>();

		try {

			
			stmt = c.createStatement();
			rs = stmt.executeQuery("select * from campeas WHERE TIPO = 'i' group by nome_projeto;");

			while (rs.next()) {

				Satisfacao satisfacao = new Satisfacao(rs.getInt("id"), rs.getInt("id_equipe"), rs.getString("letra"),rs.getString("numero"), rs.getString("comentario"), rs.getString("ajustes"),rs.getString("descricao"),rs.getString("descricaoQuestao"), rs.getString("total"),"", rs.getString("nome_projeto"));
				
				listaSatisfacao.add(satisfacao);

			}
			stmt.close();
			c.close();
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage()+" -!! "+e.getStackTrace());
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					);
		}
		
		return listaSatisfacao;
	}
	
	
	public static boolean validaNomeProjeto(String nomeProjeto, String tipo) {

		Connection c = FabricaConexao.conectarSQLITE();
		Statement stmt = null;
		ResultSet rs = null;
		

		try {

			
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from campeas where nome_projeto = '"+nomeProjeto+"' and tipo = '"+tipo+"';");
		
			while (rs.next()) {
				
				return true;

			}
			stmt.close();
			c.close();
			
		} catch (SQLException e) {
			
			System.err.println(e.getMessage()+" -!! "+e.getStackTrace());
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					);
		}
		
		return false;
	}
	
	
	public static void atualizarComentario(int id, int id_equipe, String numero, String letra, String comentario, String ajustes) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE campeas ");
			sql.append("Set ");

			
			sql.append("comentario = '" + comentario + "',");
			sql.append("ajustes = '" + ajustes + "'");
			sql.append(" Where ");
			sql.append("id ='" + id + "' and ");
			sql.append("id_equipe ='" + id_equipe + "' and ");
			sql.append("numero ='" + numero + "' and ");
			sql.append("letra ='" + letra + "'");
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

		

	}
	public static void atualizarComentarioProjetos(int id, int id_equipe, String numero, String letra, String comentario, String ajustes, String nomerelatorios) {

		Statement stmt = null;
		StringBuilder sql = null;
		System.out.println("nome do relatorio: "+nomerelatorios);
		System.out.println("id equipe: "+id_equipe);
		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE campeas ");
			sql.append("Set ");

			
			sql.append("comentario = '" + comentario + "',");
			sql.append("ajustes = '" + ajustes + "'");
			sql.append(" Where ");
			sql.append("id ='" + id + "' and ");
			
			if(nomerelatorios != null){
				
				sql.append("nome_projeto ='" + nomerelatorios + "' and ");
			
			}else{
				
				sql.append("id_equipe ='" + id_equipe + "' and ");	
				
			}
			
			sql.append("numero ='" + numero + "' and ");
			sql.append("letra ='" + letra + "'");
			
			System.out.println(sql.toString());
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

		

	}
	
	public static void apagarProjetosInstisfacao(String nome) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("Delete from campeas ");
	
			sql.append(" Where ");
			sql.append("nome_projeto ='" + nome + "' ");
			sql.append("and tipo ='i'");
			
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

	}
	public static void apagarProjetosSatisfacao(String nome) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("Delete from campeas ");
	
			sql.append(" Where ");
			sql.append("nome_projeto ='" + nome + "' ");
			sql.append("and tipo ='s'");
			
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (SQLException e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}
	}
}
