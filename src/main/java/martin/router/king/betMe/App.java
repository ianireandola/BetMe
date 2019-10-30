package martin.router.king.betMe;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import LD.MySQLAccess;
import LP.frmPrincipal;

public class App 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		    MySQLAccess dao = new MySQLAccess();
		    try {
				dao.conexion();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    try {
			    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			        if ("Nimbus".equals(info.getName())) {
			            UIManager.setLookAndFeel(info.getClassName());
			            break;
			        }
			    }
			} catch (Exception e) {
			    // If Nimbus is not available, you can set the GUI to another look and feel.
			}	
		    
		    frmPrincipal objPrincipal=new frmPrincipal();
			objPrincipal.setVisible(true);
		  
	}
}
