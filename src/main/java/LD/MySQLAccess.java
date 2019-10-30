package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLAccess {
	
  static Connection connect = null;
  static Statement stmt = null;  
  private ResultSet resultSet = null;
  
  final private static String host = "remotemysql.com";
  final private static String user = "MkP8exBAnI";
  final private static String passwd = "QG6pqIU1QX";
  
  public Connection conexion()
  {
    try 
    {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      // Setup the connection with the DB
      Connection connect = DriverManager.getConnection("jdbc:mysql://" + host + "/" + user + "?" + "user=" + user + "&password=" + passwd );        
      
      stmt = connect.createStatement();
      stmt.setQueryTimeout(30);
      
      return connect;
      
    } 
    catch (Exception e) 
    {
      JOptionPane.showMessageDialog(null, "Error de Conexión " + e.getMessage());
      return null;
    }    
    
  } 
  
  public boolean validarAdmin(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		
		boolean retorno = true;
		try {
      	ResultSet rs = stmt.executeQuery("select usuario,contraseña from empleados_admin where usuario='usuario' and contraseña='contraseña'");
      	 while(rs.next() == true) {
      		 
      		 if(rs!=null)
      		 {
      			 retorno=true;
      		 }
      		 
 		
      	 }
      	 
      	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno; 
  }

  public boolean validarUsuario(String usuario, String contraseña) {
		// TODO Auto-generated method stub
		
		boolean retorno = true;
		try {
    	ResultSet rs = stmt.executeQuery("select usuario,contraseña from apostante where usuario='usuario' and contraseña='contraseña'");
    	 while(rs.next() == true) {
    		 
    		 if(rs!=null)
    		 {
    			 retorno=true;
    		 }
    		 
		
    	 }
    	 
    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno; 
	}
  
  /*
  private void writeResultSet(ResultSet resultSet) throws SQLException 
  {
	// ResultSet is initially before the first data set
	while (resultSet.next()) 
	{
	  int id = resultSet.getInt("id_admin");
	  String nombre = resultSet.getString("nombre");
      System.out.println("ID: " + id);
      System.out.println("NOMBRE: " + nombre);
	}
  }*/

  /*
  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }*/

}
