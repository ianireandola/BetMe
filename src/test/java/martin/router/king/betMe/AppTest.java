package martin.router.king.betMe;

import static org.junit.Assert.assertEquals;

import javax.swing.JTable;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import LD.MySQLAccess;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	   
    MySQLAccess base= new MySQLAccess();
	JTable table;
	int fila;
	int columna;
	int num_deportes;

	
	/**
	 * Establece la conexion con la base de datos antes de empezar cada test
	 */
	@Before
	public void setUp() {
		base.conexion();
		
		
	}
		
	/**
	 * 
	 * Testea la creacion de un nuevo deporte
	 */
	public void testCrear() {
	
		boolean expected=true;
		boolean resultado=base.nuevoDeporte(100, "Curley", "Deporte de hielo", table, fila, columna);
		
		
		assertEquals(expected, resultado);
	}
		
	/**
	 * Testea la modificacion de un deporte
	 */
	public void testModificar() {
		
		boolean expected=true;
		boolean resultado=base.modificarDeporteTest(100, "Curley", "Deporte de riesgo", table, num_deportes, 0);
		
		assertEquals(expected, resultado);
	}
	
	
	/**
	 * Testea la eliminacion de un deporte
	 * 
	 */
	public void testEliminar() {
	
		boolean expected=true;
		
		boolean resultado=base.eliminarDeporteTest(100);
		assertEquals(expected, resultado);
		
	}
	
	/**
	 * Testea la actualizacion de las promociones
	 */	
	public void testPromocion() {
		
		int expected=15;
				
		int cantidad=base.getPromocion();	
		assertEquals(expected, cantidad);
			
			
	}
	
	/**
	 * Testea si existe algun apostante con ese id
	 */
	public void testExisteID()
	{
		
		int id_apostante=1;
		
		boolean resultado=base.existeID(id_apostante);
		
		assertEquals(true, resultado);
	}
	
	/**
	 * Testea el registro de un apostante
	 */
	
	public void testAnadirUsuario()
	{
		
		boolean expected=true;
		
		int contar1=base.contarUsuarios();
		boolean resultado=base.añadirUsuario(contar1+1, "ander", "ander", "ander", "123245", 25);
		
		
		assertEquals(expected,resultado );
	}
}
	
	
	
	
	
	

    

    

	
	

