package br.com.andremartins.votacaoInterativa.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.Projetos;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;



public class ProjetosDao {

	public ProjetosDao() {
		// TODO Auto-generated constructor stub
	}
	public static void insereProjeto(Projetos proj) {
		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("INSERT INTO projetos ");
			sql.append("(empresa_id, diretoria_id, coordencao_id, secretaria_id, nucleo_id, cargo_id, funcao_id, pesquisa_id) ");

			sql.append("VALUES ('" + proj.getEmpresa_id() + "',");
			sql.append("'" + proj.getDiretoria_id() + "',");
			sql.append("'" + proj.getCoordencao_id() + "',");
			sql.append("'" + proj.getSecretaria_id() + "',");
			sql.append("'" + proj.getNucleo_id() + "',");
			sql.append("'" + proj.getCargo_id() + "',");
			sql.append("'" + proj.getFuncao_id() + "',");
			sql.append("'" + proj.getPesquisa_id() + "')");

			stmt.executeUpdate(sql.toString());
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

		}

	}
	
	public static ArrayList<Projetos> listarTodosProjetos() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Projetos> projetos = new ArrayList<Projetos>();
		HierarquiaDao hieDao = new HierarquiaDao();
		CateoriaDao dao = new CateoriaDao();
		PesquisaEquipeDao equipe = new PesquisaEquipeDao();
		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from projetos ");

			while (rs.next()) {
				
				Projetos proj = new Projetos(rs.getInt("id"), rs.getInt("empresa_id"), rs.getInt("diretoria_id"), rs.getInt("coordencao_id"), rs.getInt("nucleo_id"), rs.getInt("cargo_id"), rs.getInt("funcao_id"), rs.getInt("pesquisa_id"), rs.getInt("secretaria_id"));
				proj.setEmpresa_desc(hieDao.listarUnicaHierarquias2(proj.getEmpresa_id()).getDescricao());
				proj.setSecretaria_desc(hieDao.listarUnicaHierarquias2(proj.getSecretaria_id()).getDescricao());
				proj.setDiretoria_desc(hieDao.listarUnicaHierarquias2(proj.getDiretoria_id()).getDescricao());
				proj.setCoordencao_desc(hieDao.listarUnicaHierarquias2(proj.getCoordencao_id()).getDescricao());
				proj.setNucleo_desc(hieDao.listarUnicaHierarquias2(proj.getNucleo_id()).getDescricao());
				proj.setCargo_desc(hieDao.listarUnicaHierarquias2(proj.getCargo_id()).getDescricao());
				proj.setFuncao_desc(hieDao.listarUnicaHierarquias2(proj.getFuncao_id()).getDescricao());
				proj.setPesquisa_desc(equipe.listarPesquisaUnica(proj.getPesquisa_id()).getNomeequipe());
				proj.setQuantidadeResposta(equipe.contaPesquisaRespondida(proj.getPesquisa_id(),c));
				System.out.println(proj.toString());
				projetos.add(proj);

			}
			stmt.close();
			c.close();
		

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return projetos;
	}
	
	
	public static boolean ValidaProjetos(int id) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Projetos> projetos = new ArrayList<Projetos>();
		HierarquiaDao hieDao = new HierarquiaDao();
		CateoriaDao dao = new CateoriaDao();
		PesquisaEquipeDao equipe = new PesquisaEquipeDao();
		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from projetos ");

			while (rs.next()) {
				
				if(rs.getInt("empresa_id") == id){
					
					stmt.close();
					c.close();
					return true;
					
				}
				if(rs.getInt("diretoria_id") == id){
					stmt.close();
					c.close();
					return true;
				}
				if(rs.getInt("coordencao_id") == id){
					stmt.close();
					c.close();
					return true;
				}
				if(rs.getInt("nucleo_id") == id){
					stmt.close();
					c.close();
					return true;
				}
				if(rs.getInt("cargo_id") == id){
					stmt.close();
					c.close();
					return true;
				}
				if(rs.getInt("funcao_id") == id){
					stmt.close();
					c.close();
					return true;
				}
				if(rs.getInt("secretaria_id") == id){
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
	
	public static void apagarProjetos(int id) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarSQLITE();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("Delete from projetos ");
	
			sql.append(" Where ");
			sql.append("id ='" + id + "'");
			
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
