package martin.router.king.betMe;

import static org.junit.Assert.*;

import org.junit.Test;

import LD.MySQLAccess;

public class testPromocion {
	
	MySQLAccess base= new MySQLAccess();
	


	@Test
	public void testPromocion() {
		
		int expected=10;
			
		int cantidad=base.getPromocion();	
		assertEquals(expected, cantidad);
		
		
	}
	
	@Test	
	public void existeID()
	{
		
		int id_apostante=1;
		
		boolean resultado=base.existeID(id_apostante);
		
		assertEquals(true, resultado);
	}
	
	@Test
	
	public void añadirUsuario()
	{
		int usuarios=8;
		
		
		int resultado=base.contarUsuarios();
		
		assertEquals(usuarios,resultado );
	}
	
	
}
