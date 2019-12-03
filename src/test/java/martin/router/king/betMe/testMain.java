package martin.router.king.betMe;

import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class testMain {
	
	
	@Test
	public void test()
	{
		System.out.println("Entro");
		App.main(null);
		boolean estaSwing = true;
		while (estaSwing)
		{	
			try 
			{
				Thread.sleep(1);  
			} 
			
			catch (InterruptedException e) {	}
			
			Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
			estaSwing = false;
			for (Thread t : threadSet) {
				if ( t.getName().startsWith( "AWT-EventQueue" ) )  {
					estaSwing = true;
					break;
				}
			}
			
			if (estaSwing = true) 
			{
				assertTrue(true);
			}
			
		}
	}

	}

