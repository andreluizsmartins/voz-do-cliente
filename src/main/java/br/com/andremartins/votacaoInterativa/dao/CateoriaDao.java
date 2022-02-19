package br.com.andremartins.votacaoInterativa.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.Categoria;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;



public class CateoriaDao {

	public CateoriaDao() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Categoria> listarTodasCategorias() {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from categorias ");

			while (rs.next()) {
				
				Categoria categoria = new Categoria(rs.getInt("id"), rs.getInt("nivel"), rs.getString("categorias"));

				categorias.add(categoria);

			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return categorias;
	}
	
	
	
	public Categoria listarUnicaCategorias(int id) {

		Statement stmt = null;
		ResultSet rs = null;
		Categoria categoria = null;

		try {

			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from categorias where id = '"+id+"'");

			while (rs.next()) {
				
				categoria = new Categoria(rs.getInt("id"), rs.getInt("nivel"), rs.getString("categorias"));

			

			}
			stmt.close();
			c.close();
			

		} catch (Exception e) {

			System.err.print(e.getMessage());
		}

		return categoria;
	}
}
