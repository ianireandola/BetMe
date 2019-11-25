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

import LN.ExcepcionDeporte;

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
      JOptionPane.showMessageDialog(null, "Error de ConexiÃ³n " + e.getMessage());
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
  
  //metodo que carga los partidos en la vista
  public DefaultTableModel cargarPartido(int id_partido, String deporte,String equipo_local, String equipo_visit, int cuota, String fecha,  DefaultTableModel modelo)
	{
	 
		  
      try {
      	//ResultSet rs = stmt.executeQuery("select * from  partido ");
      	ResultSet rs = stmt.executeQuery("select * from  partido INNER JOIN deporte ON partido.id_deporte=deporte.id_deporte INNER JOIN participante ON partido.id_participante1=participante.id_participante INNER JOIN participante P ON partido.id_participante2=P.id_participante ORDER BY partido.id_partido");
      
   
      	
      	 while(rs.next() == true) {  		
      		   		       		
      		
      		  id_partido = rs.getInt("id_partido");        		
      		  deporte = rs.getString("nombre"); 		
      		  equipo_local= rs.getString("participante.nombre");
      		  equipo_visit= rs.getString("P.nombre");
      		  cuota = rs.getInt("cantidad_cuota");
      		  fecha= rs.getString("fecha");   
      		      		
      		 
      		  modelo.addRow( new Object[] {id_partido,deporte,equipo_local,equipo_visit,cuota,fecha} );
      		
      	 }       	     	   	
      	
      	 
      	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
      	
		
    	
		return modelo;
	}   
  
 
  
  //Metodo que anade un nuevo partido
  public void anadirPartido(int id, String deporte, String local,String visitante, int cuota, String fecha, JTable table, int fila, int columna)
	{	

		 int id_deporte= this.obtenerID_deporte(deporte);
		 int id_local=this.obtenerID_local(local);
		 int id_visit= this.obtenerID_visitante(visitante);
		 DefaultTableModel modelo=null;
		
		
			try {
				
							
				String sentencia="insert into partido values('"+id+"', '"+id_deporte+"', '"+id_local+"','"+id_visit+"', '"+cuota+"',  '"+fecha+"')";
				stmt.executeUpdate(sentencia);	
				
				String[] columnas = {"PARTIDO","DEPORTE", "EQUIPO LOCAL", "EQUIPO VISITANTE", "CUOTA","FECHA" };
				
				modelo = new DefaultTableModel(null,columnas);		
				table.setModel(modelo);
				
				MySQLAccess base=new MySQLAccess();
				base.cargarPartido(id,deporte,local,visitante,cuota,fecha, modelo);
				
				
								
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
	
	} 
  
  
//Método para eliminar un partido de la base de datos
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
	public void modificarPartido(int id_partido, String deporte, String local,String visitante, int cuota,  String fecha,JTable table, int fila, int columna)
	{
		columna=0;
		
		int id_deporte= this.obtenerID_deporte(deporte);
		 int id_local=this.obtenerID_local(local);
		 int id_visit= this.obtenerID_visitante(visitante);
		 DefaultTableModel modelo=null;
		
		
		try {
								
			
			String sentencia="update partido set id_partido='"+id_partido+"', id_deporte='"+id_deporte+"', id_participante1='"+id_local+"', id_participante2='"+id_visit+"', cantidad_cuota='"+cuota+"', fecha='"+fecha+"' where id_partido= '"+table.getValueAt(fila,columna)+"'";			
			stmt.executeUpdate(sentencia);
			
			String[] columnas = {"PARTIDO","DEPORTE", "EQUIPO LOCAL", "EQUIPO VISITANTE", "CUOTA","FECHA" };
			
			modelo = new DefaultTableModel(null,columnas);		
			table.setModel(modelo);
			
			MySQLAccess base=new MySQLAccess();
			base.cargarPartido(id_partido,deporte,local,visitante,cuota,fecha, modelo);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
  private int obtenerID_visitante(String visitante) {
	// TODO Auto-generated method stub
	
	  ResultSet rs;
		int id_visit=0;
		try {
			rs = stmt.executeQuery("select * from participante where nombre='"+visitante+"'");		
			
			
			 while(rs.next() == true) {  	
			       		
			 				  		
		 		  id_visit= rs.getInt("id_participante");
		 		  System.out.println(id_visit);
		 		
		 	   			 		      		 
		 		
		 	 }    
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	 	
		return id_visit;
}

private int obtenerID_local(String local) {
	// TODO Auto-generated method stub
	  
	  ResultSet rs;
		int id_local=0;
		try {
			rs = stmt.executeQuery("select * from participante where nombre='"+local+"'");		
			
			
			 while(rs.next() == true) {  	
			       		
			 				  		
		 		  id_local= rs.getInt("id_participante");
		 		  System.out.println(id_local);
		 		
		 	   			 		      		 
		 		
		 	 }    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	 	
		return id_local;
	
}


private int obtenerID_deporte(String deporte)  {
	// TODO Auto-generated method stub
	
	
	
	ResultSet rs;
	int id_deporte=0;
	try {
		rs = stmt.executeQuery("select * from deporte where nombre='"+deporte+"'");
		
				
		 while(rs.next() == true) {  	
		       		
		 				  		
	 		  id_deporte= rs.getInt("id_deporte");
	 		  System.out.println(id_deporte);    			 		      		 
	 		
	 	 }    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}

 	
	return id_deporte;
}

public String cargarPromocion() {
	// TODO Auto-generated method stub
	
	String cantidad=null;
	
		try {
			ResultSet rs = stmt.executeQuery("select * from promocion");
			while(rs.next() == true) {  	
	       		
			  		
		 		 cantidad= rs.getString("cantidad");		 		    			 		      		 
		 		
		 	 }   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cantidad;
}

	//metodo que carga los deportes en la vista
	public DefaultTableModel cargarDeporte(int id_deporte, String nombre, String descripcion, DefaultTableModel modelo)
	{
	 
		  
    try {
    	//ResultSet rs = stmt.executeQuery("select * from  deporte ");
    	ResultSet rs = stmt.executeQuery("select * from  deporte");
    
    	while(rs.next() == true) {  		
    		   		       		
    		id_deporte = rs.getInt("id_deporte");        		
    		nombre = rs.getString("nombre"); 		
    		descripcion= rs.getString("descripcion");
    		    
    		modelo.addRow( new Object[] {id_deporte,nombre,descripcion} );
    		
    	 }       	     	   	
    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		return modelo;
	}   

	//Metodo que anade un nuevo deporte
	public void anadirDeporte(int id_deporte, String nombre, String descripcion, JTable table, int fila, int columna)
		{	

		 DefaultTableModel modelo=null;
		
			try {
				
				String sentencia="insert into deporte values('"+id_deporte+"', '"+nombre+"','"+descripcion+"')";
				stmt.executeUpdate(sentencia);	
				
				String[] columnas = {"ID_DEPORTE","NOMBRE", "DESCRIPCION"};
				
				modelo = new DefaultTableModel(null,columnas);		
				table.setModel(modelo);
				
				MySQLAccess base=new MySQLAccess();
				base.cargarDeporte(id_deporte,nombre,descripcion, modelo);
						
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		} 

	//Método para eliminar un deporte de la base de datos
	public void eliminarDeporte(JTable table, int fila, int columna,int columna2)
	{
		String deporte=table.getValueAt(fila, columna).toString();
		columna=0;
		columna2=6;
		try {
			
			String sentencia="delete from deporte where id_deporte='"+table.getValueAt(fila,columna)+"'";
			stmt.executeUpdate(sentencia);				
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

		//Metodo que modifica un deporte
		public void modificarDeporte(int id_deporte, String nombre, String descripcion,JTable table, int fila, int columna)
		{
			columna=0;
			
			
			 int id_deportee= this.obtenerID_deporte(nombre);
			
		
			 DefaultTableModel modelo=null;
			
			
			try {
									
				
				String sentencia="update deporte set id_deporte='"+id_deporte+"', nombre='"+ nombre +"', descripcion='"+descripcion+"' where id_deporte= '"+table.getValueAt(fila,columna)+"'";			
				stmt.executeUpdate(sentencia);
				
				String[] columnas = {"NOMBRE","DESCRIPCION"};
				
				modelo = new DefaultTableModel(null,columnas);		
				table.setModel(modelo);
				
				MySQLAccess base=new MySQLAccess();
				base.cargarDeporte(id_deporte,nombre,descripcion, modelo);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	


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


}
