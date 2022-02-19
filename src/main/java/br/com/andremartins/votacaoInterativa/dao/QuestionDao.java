package br.com.andremartins.votacaoInterativa.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.andremartins.votacaoInterativa.model.Question;
import br.com.andremartins.votacaoInterativa.util.FabricaConexao;


public class QuestionDao {

	
	public ArrayList<Question> listarTodasQuestoes(){
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Question> questions = new ArrayList<Question>();
		
		try{
			
			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from questions");
			
			while(rs.next()){
				
				Question question = new Question(rs.getInt("id"),rs.getInt("type"), rs.getString("question"), rs.getString("commentary"));
				AlternativeDao dao = new AlternativeDao();
				question.setAlternatives(dao.listarTodasAlterntivas(question.getId(), c));
				questions.add(question);
				
				
			}
			stmt.close();
			c.close();
			
			
			
			
			
			
			
					}catch(Exception e){
			
			
			System.err.print(e.getMessage());
		}
		
		
		
		return questions;
	}
public ArrayList<Question> listarUmaQuestao(int id){
		
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Question> questions = new ArrayList<Question>();
		
		try{
			
			Connection c = FabricaConexao.conectarSQLITE();
			stmt = c.createStatement();
			rs = stmt.executeQuery("Select * from questions where id = "+id);
			
			while(rs.next()){
				
				Question question = new Question(rs.getInt("id"),rs.getInt("type"), rs.getString("question"), rs.getString("commentary"));
				AlternativeDao dao = new AlternativeDao();
				question.setAlternatives(dao.listarTodasAlterntivas(question.getId(), c));
				questions.add(question);
				
				
			}
			stmt.close();
			c.close();
			
			
			
			
			
			
			
					}catch(Exception e){
			
			
			System.err.print(e.getMessage());
		}
		
		
		
		return questions;
	}
}
