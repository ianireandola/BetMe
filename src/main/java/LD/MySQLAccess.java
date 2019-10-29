package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
	
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;

  final private String host = "remotemysql.com";
  final private String user = "MkP8exBAnI";
  final private String passwd = "QG6pqIU1QX";
  
  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.cj.jdbc.Driver");
      
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://" + host + "/" + user + "?"
              + "user=" + user + "&password=" + passwd );
      
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from empleados_admin");
      writeResultSet(resultSet);   
                      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }  
  
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
  }

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
  }

}
