package br.com.andremartins.votacaoInterativa.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.Hierarquia;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;



public class HierarquiaDao {

	public HierarquiaDao() {
		// TODO Auto-generated constructor stub
	}

	public static void insereHierarquia(Hierarquia hie) {
		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarJDBC();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("INSERT INTO hierarquias ");
			sql.append("(categoria_id, descricao) ");

			sql.append("VALUES ('" + hie.getCodCategorias() + "',");
			sql.append("'" + hie.getDescricao() + "')");

			stmt.executeUpdate(sql.toString());
			stmt.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage()
					+ sql.toString());

		}

	}
	
	public ArrayList<Hierarquia> listarTodasHierarquias() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Hierarquia> hies = new ArrayList<Hierarquia>();
		CateoriaDao dao = new CateoriaDao();
		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from hierarquias ");

			while (rs.next()) {
				
				Hierarquia hie = new Hierarquia(rs.getInt("id"),  rs.getInt("categoria_id"), rs.getInt("parent_id"), rs.getString("descricao"));

				hie.setCategoria(dao.listarUnicaCategorias(rs.getInt("categoria_id")).getCategorias());
				hies.add(hie);

			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return hies;
	}
	
	
	public ArrayList<Hierarquia> listarUnicaHierarquias(int id ) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Hierarquia> hies = new ArrayList<Hierarquia>();
		CateoriaDao dao = new CateoriaDao();
		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from hierarquias where categoria_id = '"+id+"'");

			while (rs.next()) {
				
				Hierarquia hie = new Hierarquia(rs.getInt("id"),  rs.getInt("categoria_id"), rs.getInt("parent_id"), rs.getString("descricao"));

				hie.setCategoria(dao.listarUnicaCategorias(rs.getInt("categoria_id")).getCategorias());
				hies.add(hie);

			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return hies;
	}
	
	public Hierarquia listarUnicaHierarquias2(int id ) {

		Statement stmt = null;
		ResultSet rs = null;
		Hierarquia hie = new Hierarquia();
		CateoriaDao dao = new CateoriaDao();
		try {

			Connection c = FabricaConexao.conectarJDBC();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from hierarquias where id = '"+id+"'");

			while (rs.next()) {
				
				hie = new Hierarquia(rs.getInt("id"),  rs.getInt("categoria_id"), rs.getInt("parent_id"), rs.getString("descricao"));

				

			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return hie;
	}

	public void apagarHierarquia(int id) {

		Statement stmt = null;
		StringBuilder sql = null;

		try {
			Connection c = FabricaConexao.conectarJDBC();
			c.setAutoCommit(false);
			stmt = c.createStatement();

			sql = new StringBuilder();
			sql.append("Delete from hierarquias ");
	
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
