package LD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
  
  public void a�adirUsuario(int id_apostante, String usuario, String contrase�a,String nombre, String tarjeta_credito,  int edad)
  {	
	  
	  Connection con = null;     
	
	  try 
	  {
		  con = conexion();
		  PreparedStatement ps;
		  String sql = "INSERT INTO apostante (id_apostante, usuario, contrase�a, nombre, tarjeta_credito, edad) VALUES(?,?,?,?,?,?)";
		  	  
		  ps = con.prepareStatement(sql);
          ps.setInt(1, id_apostante);
          ps.setString(2, usuario);
          ps.setString(3, contrase�a);
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
  
  
  public boolean validarAdmin(String usuario, String contrase�a) 
  {		
		
		boolean retorno = true;
		try 
		{
			ResultSet rs = stmt.executeQuery("select usuario,contrase�a from empleados_admin where usuario='usuario' and contrase�a='contrase�a'");
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

  public boolean validarUsuario(String usuario, String contrase�a) 
  {
				
		boolean retorno = true;
		try 
		{
			ResultSet rs = stmt.executeQuery("select usuario,contrase�a from apostante where usuario='usuario' and contrase�a='contrase�a'");
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
  
  //metodo que carga los partidos en la vista
  public DefaultTableModel cargarPartido(String id_partido, String deporte,String equipo_local, String equipo_visit, int cuota, Date fecha,  DefaultTableModel modelo)
	{
	 
		  
      try {
      	//ResultSet rs = stmt.executeQuery("select * from  partido ");
      	ResultSet rs = stmt.executeQuery("select * from  partido INNER JOIN deporte ON partido.id_deporte=deporte.id_deporte INNER JOIN participante ON partido.id_participante1=participante.id_participante INNER JOIN participante P ON partido.id_participante2=P.id_participante ");
      
   
      	
      	 while(rs.next() == true) {  		
      		   		       		
      		
      		  id_partido = rs.getString("id_partido");        		
      		  deporte = rs.getString("nombre"); 		
      		  equipo_local= rs.getString("participante.nombre");
      		  equipo_visit= rs.getString("P.nombre");
      		  cuota = rs.getInt("cantidad_cuota");
      		  fecha= rs.getDate("fecha");   
      		      		
      		 
      		  modelo.addRow( new Object[] {id_partido,deporte,equipo_local,equipo_visit,cuota,fecha} );
      		
      	 }       	     	   	
      	
      	 
      	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
      	
		
    	
		return modelo;
	}   
  
 
  
  //Metodo que anade un nuevo partido
  public void anadirPartido(int id, String deporte, String local,String visitante, int cuota, String fecha )
	{	
		
		
			try {
				
							
				String sentencia="insert into partido values('"+id+"', '"+deporte+"', '"+local+"','"+visitante+"', '"+cuota+"',  '"+fecha+"')";
				stmt.executeUpdate(sentencia);				
								
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	
	} 
  
  
//M�todo para eliminar un partido de la base de datos
	public void eliminarPartido(JTable table, int fila, int columna,int columna2)
	{
		String partido=table.getValueAt(fila, columna).toString();
		columna=0;
		columna2=6;
		try {
			
			
			
			String sentencia="delete from partido where id_partido='"+table.getValueAt(fila,columna)+"'";
			stmt.executeUpdate(sentencia);				
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  

//Metodo que modifica un partido
	public void modificarPartido(String id_partido, String deporte, String local,String visitante, int cuota,  String fecha,JTable table, int fila, int columna)
	{
		columna=0;
		
		
		
		
		
		try {
			String sentencia1=stmt.executeQuery("select id_deporte from deporte where nombre='"+deporte+"'").toString();
			
			
			String sentencia2=stmt.executeQuery("select id_participante from participante where nombre='"+local+"'").toString();
		
			String sentencia3=stmt.executeQuery("select id_participante from participante where nombre='"+visitante+"'").toString();
			
			ResultSet rs = stmt.executeQuery("select * from  partido INNER JOIN deporte ON partido.id_deporte=deporte.id_deporte INNER JOIN participante ON partido.id_participante1=participante.id_participante INNER JOIN participante P ON partido.id_participante2=P.id_participante ");
		      
			
			String sentencia="update partido set id_partido='"+id_partido+"', id_deporte='"+sentencia1+"', id_participante1='"+sentencia2+"', id_participante2='"+sentencia3+"', cantidad_cuota='"+cuota+"', fecha='"+fecha+"' where id_partido= '"+table.getValueAt(fila,columna)+"'";			
			stmt.executeUpdate(sentencia);
			
					
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
