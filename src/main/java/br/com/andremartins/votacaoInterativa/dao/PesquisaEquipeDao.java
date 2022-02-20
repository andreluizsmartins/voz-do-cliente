package br.com.andremartins.votacaoInterativa.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.PesquisaEquipe;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;



public class PesquisaEquipeDao {

	public PesquisaEquipeDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<PesquisaEquipe> listarTodasPesquisas() {
		int count = 1;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaEquipe> pesquisas = new ArrayList<PesquisaEquipe>();

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from equipe where deletado = 1 order by id desc");

			while (rs.next()) {
				int id = rs.getInt("id");
				PesquisaEquipe pesquisa = new PesquisaEquipe(id,contaPesquisaRespondida(id, c),
						rs.getString("nomeequipe"), rs.getString("consultor"),
						rs.getString("status"), rs.getString("data"), rs.getInt("qtde"), count);
				pesquisa.setCount(count);
				pesquisas.add(pesquisa);
				count++;
			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return pesquisas;
	}
	
	public ArrayList<PesquisaEquipe> listarTodasPesquisasArquivada() {
		int count = 1;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<PesquisaEquipe> pesquisas = new ArrayList<PesquisaEquipe>();

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from equipe where deletado = 2 order by id desc");

			while (rs.next()) {
				int id = rs.getInt("id");
				PesquisaEquipe pesquisa = new PesquisaEquipe(id,contaPesquisaRespondida(id, c),
						rs.getString("nomeequipe"), rs.getString("consultor"),
						rs.getString("status"), rs.getString("data"), rs.getInt("qtde"), count);
				pesquisa.setCount(count);
				pesquisas.add(pesquisa);
				count++;
			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return pesquisas;
	}

	public static PesquisaEquipe listarPesquisaAtiva() {

		Statement stmt = null;
		ResultSet rs = null;
		PesquisaEquipe pesquisa = null;

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("Select * from equipe where status = 'Ativo'");

			
			
			while (rs.next()) {

				pesquisa = new PesquisaEquipe(rs.getInt("id"),
						rs.getString("nomeequipe"), rs.getString("consultor"),
						rs.getString("status"), rs.getString("data"), rs.getInt("qtde"));

				stmt.close();
				c.close();
				
				
				return pesquisa;

			}

			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return null;
	}
	
	public static PesquisaEquipe listarPesquisaAtivaUnica(int id) {

		Statement stmt = null;
		ResultSet rs = null;
		PesquisaEquipe pesquisa = null;

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			String sql = "Select * from equipe where status = 'Ativo' and id = '"+id+"'";
			System.out.println(sql);
			rs = stmt
					.executeQuery(sql);

			
			
			while (rs.next()) {

				pesquisa = new PesquisaEquipe(rs.getInt("id"),
						rs.getString("nomeequipe"), rs.getString("consultor"),
						rs.getString("status"), rs.getString("data"), rs.getInt("qtde"));

				stmt.close();
				c.close();
				
				
				return pesquisa;

			}

			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return null;
	}
	
	public static PesquisaEquipe listarPesquisaUnica(int id) {

		Statement stmt = null;
		ResultSet rs = null;
		PesquisaEquipe pesquisa = null;

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("Select * from equipe where id = '"+id+"'");

			
			
			while (rs.next()) {

				pesquisa = new PesquisaEquipe(rs.getInt("id"),
						rs.getString("nomeequipe"), rs.getString("consultor"),
						rs.getString("status"), rs.getString("data"), rs.getInt("qtde"));

				stmt.close();
				c.close();
				
				
				return pesquisa;

			}

			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return null;
	}
	
	public static PesquisaEquipe listarPesquisaMultipla(int[] id) {

		Statement stmt = null;
		ResultSet rs = null;
		PesquisaEquipe pesquisa = new PesquisaEquipe();
		
		pesquisa.setQtde(0);

		
		
		try {
			for(int idU : id){
			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("Select * from equipe where id = '"+idU+"'");

			
			
			while (rs.next()) {

				pesquisa.setQtde(pesquisa.getQtde()+rs.getInt("qtde"));
				
				
				

			}
			
		}

			return pesquisa;

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return null;
	}
	
	public static ArrayList<PesquisaEquipe> listarPesquisaAtivaArray() {

		Statement stmt = null;
		ResultSet rs = null;
		PesquisaEquipe pesquisa = null;
		ArrayList<PesquisaEquipe> pesquisas = new ArrayList<PesquisaEquipe>();

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("Select * from equipe where status = 'Ativo'");

			
			
			while (rs.next()) {

				pesquisa = new PesquisaEquipe(rs.getInt("id"),
						rs.getString("nomeequipe"), rs.getString("consultor"),
						rs.getString("status"), rs.getString("data"), rs.getInt("qtde"));

				
				
				pesquisas.add(pesquisa);
				

			}
			
			stmt.close();
			c.close();

			return pesquisas;

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return null;
	}

	public static void inserePesquisa(PesquisaEquipe pesquisa) {
		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("INSERT INTO equipe ");
			sql.append("(nomeequipe, data, qtde, consultor, deletado, status) ");

			sql.append("VALUES ('" + pesquisa.getNomeequipe() + "',");
			sql.append("'" + pesquisa.getData() + "',");
			sql.append("'" + pesquisa.getQtde() + "',");
			sql.append("'" + pesquisa.getConsultor() + "',");
			sql.append("1,");
			sql.append("'" + pesquisa.getStatus() + "')");

			stmt.executeUpdate(sql.toString());
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

		}

	}

	public static void atualizarPesquisa(String status, int id) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE equipe ");
			sql.append("Set ");

			
			sql.append("status = '" + status + "'");
			sql.append(" Where ");
			sql.append("id ='" + id + "'");
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

		

	}
	public static void atualizarQtde(int id, int qtde) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE equipe ");
			sql.append("Set ");

			
			sql.append("qtde = '" + qtde + "'");
			sql.append(" Where ");
			sql.append("id ='" + id + "'");
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

		

	}
	
	public static void atualizarPesquisaOff(String status) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE equipe ");
			sql.append("Set ");

			
			sql.append("status = '" + status + "'");
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

		

	}
	
	public int contaPesquisaRespondida(int id, Connection c) {

		Statement stmt = null;
		ResultSet rs = null;
		PesquisaEquipe pesquisa = null;

		try {

			
			stmt = c.createStatement();
			rs = stmt
					.executeQuery("select count(*) as total from pesquisas where id_equipe = "+id+" and question = 39");

			
			
			while (rs.next()) {

			
				return rs.getInt("total");

			}

			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return 0;
	}

	public void apagarPesquisa(int i, int id) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("UPDATE equipe ");
			sql.append("Set ");

			
			sql.append("deletado = '" + i + "',");
			sql.append(" status = 'Inativo'");
			sql.append(" Where ");
			sql.append("id ='" + id + "'");
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

		
		
		
	}
	
	public void deletarPesquisa(int id) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("Delete from equipe ");
			sql.append(" Where ");
			sql.append("id ='" + id + "'");
			stmt.executeUpdate(sql.toString());

			c.commit();
			
			stmt.close();
			c.close();
			

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

			
		}

		
		
		
	}
	
}
