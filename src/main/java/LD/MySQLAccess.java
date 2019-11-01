package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class MySQLAccess 
{
	
  static Connection connect = null;
  static Statement stmt = null;   
  
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
  
  public boolean existeID(int id_apostante)
  {	
	boolean retorno = false;
	try 
	{
		ResultSet rs = stmt.executeQuery("select id_apostante from apostante where id_apostante = '"+id_apostante+"'");
		
		while(rs.next() == true) 
		{     		 
	   		 if(rs!=null)
	   		 {
	   			 retorno=true;
	   			
	   		 }		
		}     	 
     	
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		
	}
	
	return retorno;
		
  }
  
  public void añadirUsuario(int id_apostante, String usuario, String contraseña,String nombre, String tarjeta_credito,  int edad)
  {	
	  
	  Connection con = null;     
	
	  try 
	  {
		  con = conexion();
		  PreparedStatement ps;
		  String sql = "INSERT INTO apostante (id_apostante, usuario, contraseña, nombre, tarjeta_credito, edad) VALUES(?,?,?,?,?,?)";
		  	  
		  ps = con.prepareStatement(sql);
          ps.setInt(1, id_apostante);
          ps.setString(2, usuario);
          ps.setString(3, contraseña);
          ps.setString(4, nombre);
          ps.setString(5, tarjeta_credito);
          ps.setInt(6, edad);
          ps.executeUpdate();
          ps.close();
          System.out.println("Query executed");
				
	  } 
	  catch (SQLException e) 
	  {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }	
		
	
  }  
  
  
  public boolean validarAdmin(String usuario, String contraseña) 
  {		
		
		boolean retorno = true;
		try 
		{
			ResultSet rs = stmt.executeQuery("select usuario,contraseña from empleados_admin where usuario='usuario' and contraseña='contraseña'");
			while(rs.next() == true) 
			{
      		 
	      		 if(rs!=null)
	      		 {
	      			 retorno=true;
	      		 }
	      		 
 		
			}
      	 
      	
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno; 
  }

  public boolean validarUsuario(String usuario, String contraseña) 
  {
				
		boolean retorno = true;
		try 
		{
			ResultSet rs = stmt.executeQuery("select usuario,contraseña from apostante where usuario='usuario' and contraseña='contraseña'");
			while(rs.next() == true) 
			{    		 
	    		 if(rs!=null)
	    		 {
	    			 retorno=true;
	    		 }		
			}
    	 
    	
		} 
		catch (SQLException e) 
		{
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
