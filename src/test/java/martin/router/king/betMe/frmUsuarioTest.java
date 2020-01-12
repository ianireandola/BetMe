package martin.router.king.betMe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import LD.MySQLAccess;

public class frmUsuarioTest {
	
	
	 MySQLAccess base= new MySQLAccess();
	/**
	 * Establece la conexion con la base de datos antes de empezar cada test
	 */
	@Before
	public void setUp() {
		base.conexion();
		
		
	}

	@Test

	/**
	 * Testea que la apuesta se registra correctamente
	 */
	
	public void testApuesta()
	{
		boolean expected=true;
		
		boolean resultado= base.apostar(16, 10, "Baskonia", 10);
		
		assertEquals(expected,resultado);
		
	}

}
