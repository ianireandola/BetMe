package martin.router.king.betMe;

import org.junit.Before;

import LD.MySQLAccess;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    

	MySQLAccess base= new MySQLAccess();
	

	@Before
	public void setUp() {
		base.conexion();
	}
	
	

	
	public void promocion() {
		
		int expected=15;
			
		int cantidad=base.getPromocion();	
		assertEquals(expected, cantidad);
		
		
	}
	
		
	public void existeID()
	{
		
		int id_apostante=1;
		
		boolean resultado=base.existeID(id_apostante);
		
		assertEquals(true, resultado);
	}
	
	
	
	public void añadirUsuario()
	{
		//int usuarios=8;
		
		int contar1=base.contarUsuarios();
		base.añadirUsuario(2, "ander", "ander", "ander", "123245", 25);
		int contar2=base.contarUsuarios();
		
		assertEquals(contar1+1,contar2 );
	}
	
}
