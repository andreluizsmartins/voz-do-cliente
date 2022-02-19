package br.com.andremartins.votacaoInterativa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.Altenative;


public class AlternativeDao {

	public AlternativeDao() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Altenative> listarTodasAlterntivas(int id, Connection c) {

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Altenative> alternatives = new ArrayList<Altenative>();

		try {

			//Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from alternatives where questions_id = '"+id+"'");

			while (rs.next()) {

				Altenative alternative = new Altenative(rs.getInt("id"),rs.getString("letter"),rs.getString("text"));

				alternatives.add(alternative);

			}
			//c.close();
			//stmt.close();
		} catch (Exception e) {
			
			System.err.print(e.getMessage()+" -!! "+e.getStackTrace());
		}
		
		return alternatives;
	}
}
