package br.com.andremartins.votacaoInterativa.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class FabricaConexao {

	public FabricaConexao() {
		// TODO Auto-generated constructor stub
	}

	public static Connection conectarSQLITE2(){
	    Connection c = null;
	    try {
	    //  Class.forName("org.sqlite.JDBC");
	     c = DriverManager.getConnection("jdbc:sqlite:proergon.db");
	     
	     
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.out.println("Opa! houve uma falha ao se conectar com o banco de dados!!! Tentando conectar novamente.../n");
	      conectarSQLITE();
	     
	    }
	    
		return c;
	  }
	public static Connection conectarSQLITE(){
	    Connection c = null;
	    String driver = "org.postgresql.Driver";
        String user = "brgvvhlfmachgx";
        String senha = "025465a81c7bd9d6073be07c6f310bac6fbbf00493a5e875e604afdc4d9aaea1";
        String url = "jdbc:postgresql://ec2-3-224-157-224.compute-1.amazonaws.com:5432/d1mc2j138rhu89";

        try {
            Class.forName(driver);
           

            c = DriverManager.getConnection(url, user, senha);

          
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
	    
		return c;
	  }
		
	public static Connection conectarMySQL() {

	    Connection c = null;
	    try {
	         Class.forName("com.mysql.jdbc.Driver");
	         c = DriverManager.getConnection("jdbc:mysql://localhost:3306/iftech", "root", "");
	         
	    } catch (ClassNotFoundException e) {
		      
	    	e.printStackTrace();
	    } catch (SQLException e) {
	     	
	    	e.printStackTrace();
	    }
	    System.out.println("Conectado");
	    return c;
	}
}
