package martin.router.king.betMe;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import LD.MySQLAccess;
import junit.framework.TestCase;

public class testPromocion extends TestCase{
	
	MySQLAccess base= new MySQLAccess();
	

	@Before
	public void setUp() {
		base.conexion();
	}
	
	

	@Test
	public void promocion() {
		
		int expected=15;
			
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
		//int usuarios=8;
		
		int contar1=base.contarUsuarios();
		base.añadirUsuario(2, "ander", "ander", "ander", "123245", 25);
		int contar2=base.contarUsuarios();
		
		assertEquals(contar1+1,contar2 );
	}
	
	
}
