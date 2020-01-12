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

import org.junit.Test;

import LN.ExcepcionDeporte;

/**
 * Clase para la realizacion de diferentes conexiones con la base de datos
 * @author Martin Router King
 *
 */
public class MySQLAccess 
{
	
  static Connection connect = null;
  static Statement stmt = null;   
  
  final private static String host = "remotemysql.com";
  final private static String user = "MkP8exBAnI";
  final private static String passwd = "QG6pqIU1QX";
  
  /**
   * Método para realizar la conexion a la base de datos
   * @return connect Devuelve la conexion a la base de datos
   */
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
  
  /**
   * Metodo para comprobar si existe el ID
   * @param id_apostante Recoge el ID del apostante
   * @return retorno Devuelve TRUE si existe ID y FALSE si no existe
   */
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
  
  /**
   * Metodo para añadir un nuevo apostante
   * @param id_apostante Recoge el ID del apostante
   * @param usuario Recoge el nombre de usuario del apostante
   * @param contraseña Recoge la contraseña del apostante
   * @param nombre Recoge el nombre del apostante
   * @param tarjeta_credito Recoge el numero de la tarjeta de credito del apostante
   * @param edad Recoge la edad del apostante
   * @return true/false dependiendo si se ha añadido correctamente o no el nuevo apostante
   */
  public boolean añadirUsuario(int id_apostante, String usuario, String contraseña,String nombre, String tarjeta_credito,  int edad)
  {	
	  
	  Connection con = null;     
	  int cuota_promocion=getPromocion();
	
	  try 
	  {
		  con = conexion();
		  PreparedStatement ps;
		  String sql = "INSERT INTO apostante (id_apostante, usuario, contraseña, nombre, tarjeta_credito, edad, saldo) VALUES(?,?,?,?,?,?,?)";
		  	  
		  ps = con.prepareStatement(sql);
          ps.setInt(1, id_apostante);
          ps.setString(2, usuario);
          ps.setString(3, contraseña);
          ps.setString(4, nombre);
          ps.setString(5, tarjeta_credito);
          ps.setInt(6, edad);
          ps.setInt(7, cuota_promocion);
          ps.executeUpdate();
          ps.close();
        
          return true;
				
	  } 
	  catch (SQLException e) 
	  {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  return false;
	  }	
		
	
	
  }  
  
  /**
   * Metodo para contar los usuarios
   * @return filas Cuenta los usuarios dados de alta actualmente
   */
  public int contarUsuarios() {
	// TODO Auto-generated method stub
	  int filas=0;
    try {
		ResultSet rs = stmt.executeQuery("select * from apostante");
		
		 while(rs.next() == true) {  	
	       		
		  	 filas++;
	 		    			 		      		 
	 		
	 	 }    
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	return filas;
  }
  
  /**
   * Metodo para sacar la cantidad de la promocion
   * @return cantidad Devuelve la cantidad de la promocion
   */
  public int getPromocion() 
  {
	// TODO Auto-generated method stub
	  
	
	  	ResultSet rs;
		int cantidad=0;
		try {
			
			rs = stmt.executeQuery("select * from promocion");
			
					
			 while(rs.next() == true) {  	
			       		
			 				  		
		 		  cantidad= rs.getInt("cantidad");
		 		 
		 	 }    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return cantidad;
		
}

  /**
   * Metodo para validar al Admin
   * @param usuario Recoge el nombre de usuario
   * @param contraseña Recoge la contraseña
   * @return retorno Variable booleano que devolvera TRUE si valida como Admin o FALSE si no coincide
   */
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
  
  /**
   * Metodo para validar a un usuario
   * @param usuario Recoge el nombre de usuario
   * @param contraseña Recoge la contraseña
   * @return retorno Variable booleano que devolvera TRUE si coincide el usuario o FALSE si no coincide
   */
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
  
  
  /**
   * Método que carga los partidos en la vista
   * @param id_partido Recoge el ID del partido
   * @param deporte Recoge el tipo de deporte
   * @param equipo_local Recoge el nombre del equipo local
   * @param equipo_visit Recoge el nombre del equipo visitante
   * @param cuota Recoge la cuota asociada a este partido
   * @param fecha Recoge la fecha del partido
   * @param modelo Recoge el modelo TableModel
   * @return modelo Devuelve el DefaultTableModel cargado
   */
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
   
  
  
  /**
   * Metodo que añade un nuevo partido
   * @param id Recoge el ID
   * @param deporte Recoge el tipo de partido
   * @param local Recoge el nombre del equipo local
   * @param visitante Recoge el nombre del equipo visitante
   * @param cuota Recoge la cuota asociada
   * @param fecha Recoge la fecha
   * @param table Recoge la tabla
   * @param fila Recoge la fila asociada
   * @param columna Recoge la columna asociada
   */
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
  

  	/**
  	 * Metodo para eliminar un partido de la base de datos
  	 * @param table 
  	 * @param fila 
  	 * @param columna 
  	 * @param columna2
  	 */
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
	
  
	/**
	 * Metodo que modifica un partido
	 * @param id_partido
	 * @param deporte
	 * @param local
	 * @param visitante
	 * @param cuota
	 * @param fecha
	 * @param table
	 * @param fila
	 * @param columna
	 */
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
	
/**
 * Metodo que devuelve el ID del equipo visitante
 * @param visitante Recoge el nombre del equipo visitante
 * @return id_visit Devuelve el ID del equipo visitante
 */
  public int obtenerID_visitante(String visitante) {
	// TODO Auto-generated method stub
	
	  ResultSet rs;
		int id_visit=0;
		try {
			rs = stmt.executeQuery("select * from participante where nombre='"+visitante+"'");		
			
			
			 while(rs.next() == true) {  	
			       		
			 				  		
		 		  id_visit= rs.getInt("id_participante");
		 		  
		 		
		 	   			 		      		 
		 		
		 	 }    
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	 	
		return id_visit;
}

  /**
   * Metodo que devuelve el ID del equipo local
   * @param local Recoge el nombre del equipo local
   * @return id_local Devuelve el ID del equipo local
   */
private int obtenerID_local(String local) {
	// TODO Auto-generated method stub
	  
	  ResultSet rs;
	  
		int id_local=0;
		try {
			rs = stmt.executeQuery("select * from participante where nombre='"+local+"'");		
			
			
			 while(rs.next() == true) {  	
			       		
			 				  		
		 		  id_local= rs.getInt("id_participante");
		 		 
		 		  
		 		
		 	   			 		      		 
		 		
		 	 }    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	 	
		return id_local;
	
}

/**
 * Metodo que devuelve el ID del deporte seleccionado
 * @param deporte Recoge el nombre del deporte seleccionado
 * @return id_deporte Devuelve el ID del deporte seleccionado
 */
private int obtenerID_deporte(String deporte)  {
	// TODO Auto-generated method stub
	
	
	
	ResultSet rs;
	int id_deporte=0;
	try {
		rs = stmt.executeQuery("select * from deporte where nombre='"+deporte+"'");
		
				
		 while(rs.next() == true) {  	
		       		
		 				  		
	 		  id_deporte= rs.getInt("id_deporte");
	 		  
	 	 }    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}

 	
	return id_deporte;
}

/**
 * Metodo para la carga de la cantidad de promocion
 * @return cantidad Devuelve la cantidad de promocion
 */
public int cargarPromocion() {
	// TODO Auto-generated method stub
	
	int cantidad=0;
	
		try {
			ResultSet rs = stmt.executeQuery("select * from promocion");
			while(rs.next() == true) {  	
	       		
			  		
		 		 cantidad= rs.getInt("cantidad");		 		    			 		      		 
		 		
		 	 }   
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cantidad;
}

	
	/**
	 * Metodo que carga los deportes en la vista
	 * @param id_deporte Recoge el ID del deporte 
	 * @param nombre Recoge el nombre del deporte
	 * @param descripcion Recoge la descripcion del deporte
	 * @param modelo Recoge el modelo del deporte
	 * @return modelo Devulve el DefaultTableModel cargado con los deportes
	 */
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

	
	/**
	 * Metodo que añade un nuevo deporte
	 * @param id_deporte Recoge el ID del deporte
	 * @param nombre Recoge el nombre del deporte
	 * @param descripcion Recoge la descripcion del deporte
	 * @param table Recoge la tabla del deporte
	 * @param fila Recoge la fila
	 * @param columna Recoge la columna
	 */
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
	
	
	/**
	 * Metodo que añade un nuevo deporte test
	 * @param id_deporte Recoge el ID del nuevo deporte
	 * @param nombre Recoge el nombre del deporte
	 * @param descripcion Recoge la descripcion del deporte
	 * @param table Recoge la tabla del deporte
	 * @param fila Recoge la fila
	 * @param columna Recoge la columna
	 * @return true/false Devuelve TRUE o FALSE dependiendo si se ha podido añadir un nuevo deporte o no
	 */
	public boolean nuevoDeporte(int id_deporte, String nombre, String descripcion, JTable table, int fila, int columna)
		{	

		 DefaultTableModel modelo=null;
		
			try {
				
				String sentencia="insert into deporte values('"+id_deporte+"', '"+nombre+"','"+descripcion+"')";
				stmt.executeUpdate(sentencia);	
				
				
				return true;
			
				
						
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				
			}
			
			
		
		} 

	
	/**
	 * Metodo para eliminar un deporte de la base de datos
	 * @param table 
	 * @param fila 
	 * @param columna
	 * @param columna2
	 */
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
	

		
		/**
		 * Metodo para modificar un deporte
		 * @param id_deporte
		 * @param nombre
		 * @param descripcion
		 * @param table
		 * @param fila
		 * @param columna
		 */
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

		/**
		 * Metodo que actuliaza la cantidad de la promocion
		 * @param cantidad Recoge la cantidad de promocion
		 */
		public void actualizarCantidad(int cantidad) {
			// TODO Auto-generated method stub
					
			try {
				String sentencia=("update promocion set cantidad='"+cantidad+"'");	
				stmt.executeUpdate(sentencia);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		/**
		 * Metodo para contar los deportes 
		 * @return filas Devuelve el numero de deportes añadidos
		 */
		public int contarDeportes() {
			// TODO Auto-generated method stub
			
			 int filas=0;
			    try {
					ResultSet rs = stmt.executeQuery("select * from deporte");
					
					 while(rs.next() == true) {  	
				       		
					  	 filas++;
				 		    			 		      		 
				 		
				 	 }    
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				return filas;
			
			
			
			
		}
		
		/**
		 * Metodo para modificar Deportes Test
		 * @param num_deportes
		 * @param nombre
		 * @param descripcion
		 * @param table
		 * @param fila
		 * @param columna
		 * @return true/false Devolvera TRUE o FALSE si el test sale correctamente o no
		 */
		public boolean modificarDeporteTest(int num_deportes, String nombre, String descripcion, JTable table,	int fila, int columna) {
			// TODO Auto-generated method stub
					
			
			try {
									
				
				String sentencia="update deporte set id_deporte='"+num_deportes+"', nombre='"+ nombre +"', descripcion='"+descripcion+"' where id_deporte= '"+num_deportes+"'";			
				stmt.executeUpdate(sentencia);
				
				return true;
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				
			}
			
		}
		
		/**
		 * Metodo para eliminar Deportes Test
		 * @param id_deporte Recoge el ID del deporte seleccionado
		 * @return true/false Devolvera TRUE o FALSE dependiendo si el test sale correctamente o no
		 */
		public boolean eliminarDeporteTest(int id_deporte) {
			// TODO Auto-generated method stub
			
			String sentencia="delete from deporte where id_deporte='"+id_deporte+"'";
			try {
				stmt.executeUpdate(sentencia);
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}	
			
		}
		
		/**
		 * Metodo para obtener el ID de un apostante
		 * @param usuario2 Recoge el nombre de usuario del apostante
		 * @param contraseña2 Recoge la contraseña del apostante
		 * @return id_apostante Devuelve en ID del apostante
		 */
		public int obtenerID(String usuario2, String contraseña2) {
			// TODO Auto-generated method stub
			
			int id_apostante=0;
			
			ResultSet rs;
			try {
				rs = stmt.executeQuery("select * from apostante where usuario='"+usuario2+"' && contraseña='"+contraseña2+"'");
				 while(rs.next() == true) {  	
			       		
					 id_apostante = rs.getInt("id_apostante");    
			 		    			 		      		 
			 		
			 	 }
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return id_apostante;
			
	
			
			
		}
		
		/**
		 * Metodo que carga el saldo del apostante
		 * @param id Recoge el ID del apostante seleccionado
		 * @return saldo_apostante Devuelve el saldo del apostante
		 */
		public int cargarSaldoApostante(int id) {
			// TODO Auto-generated method stub
			
			
			int saldo_apostante=0;
			try {
				ResultSet rs = stmt.executeQuery("select * from apostante where id_apostante='"+id+"'");
				while(rs.next() == true) {  	
		       		
					
					 saldo_apostante = rs.getInt("saldo");  
					 
			 		    			 		      		 
			 		
			 	 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return saldo_apostante;
			
			
		}
		
		/**
		 * Metodo para realizar una apuesta
		 * @param id_partido
		 * @param apuesta
		 * @param equipo
		 * @param saldo
		 */
		public boolean apostar(int id_partido, int apuesta, String equipo, int saldo) {
			// TODO Auto-generated method stub
			
			boolean resultado=false;
			int id_apuesta=0;
			
			String sentencia="insert into apuesta values('"+id_apuesta+"', '"+id_partido+"','"+apuesta+"', '"+equipo+"')";
			try {
				stmt.executeUpdate(sentencia);
				resultado=true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultado;	
			
		}
		
		/**
		 * Metodo para actualizar el saldo de un apostante
		 * @param apuesta
		 * @param id_apost
		 * @return saldo_actualizado Devuelve el saldo actualizado del apostante
		 */
		public int actualizarSaldo(int apuesta, int id_apost) {
			// TODO Auto-generated method stub
			
			
			int saldo=this.cargarSaldoApostante(id_apost);
			
			int saldo_actualizado=saldo-apuesta;
			
			
			
			
			String sentencia="update apostante set saldo='"+saldo_actualizado+"' where id_apostante='"+id_apost+"'";
			try {
				stmt.executeUpdate(sentencia);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return saldo_actualizado;
			
		}
		
		/**
		 * Metodo para validar que el nombre del apostante introducido es correcto
		 * @param equipo
		 * @param id_partido
		 * @return resultado Devuelve un true si existe el equipo, en caso contrario devolvera un false
		 */

		public boolean validarEquipo(int id_partido,String equipo) {
			// TODO Auto-generated method stub
			
			
			
			int id_equipo=obtenerID_local(equipo);
			
			if(id_equipo==0)
			{
				return false;
			}
			
			
			boolean retorno = true;
			try 
			{
				ResultSet rs = stmt.executeQuery("select * from partido where id_partido='id_partido' and id_participante1='id_equipo' or id_participante2='id_equipo'" );
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
				retorno=false;
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return retorno;
			
			
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

