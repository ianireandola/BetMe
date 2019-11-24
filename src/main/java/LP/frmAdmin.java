package LP;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import org.edisoncor.gui.button.ButtonIcon;
import org.edisoncor.gui.util.Avatar;

public class frmAdmin extends javax.swing.JFrame
{	
	private static final long serialVersionUID = 1L;
	
	public frmAdmin() 
	{
        initComponents();
        this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla.
        llenarMenu();
    }
    
    public void llenarMenu()
    {    	
        List<Avatar> avatars=new ArrayList<Avatar>();
        
        avatars.add(new Avatar("Salir", loadImage("/Image/info.png")));       
        avatars.add(new Avatar("Promociones", loadImage("/Image/promociones.png")));       
        avatars.add(new Avatar("Deportes", loadImage("/Image/minutos.png")));       
        avatars.add(new Avatar("Partidos", loadImage("/Image/gestion.png")));
        avatars.add(new Avatar("Cerrar sesion", loadImage("/Image/recordatorio.png")));       
        
        menu.setAvatars(avatars);
    	
    }
    
    public static Image loadImage(String fileName)
    {
        try 
        {
            return ImageIO.read(frmAdmin.class.getResource(fileName));
        }
        catch (Exception e) 
        {
            return null;
        }
    }
    
    public void llamarMenu()
    {        
    	if(menu.getSelectedtitulo().equals("Salir"))
    	{
    		String ObjButtons[] = {"Si","Cancelar"};
	        int PromptResult = JOptionPane.showOptionDialog(null,"Seguro que deseas salir?","BetMe - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
	        if(PromptResult==JOptionPane.YES_OPTION)
	        {
	            System.exit(0);
	        }
         
    	}    	
    	
    	if(menu.getSelectedtitulo().equals("Promociones"))
    	{
          	frmAdminPromociones frame=new frmAdminPromociones();
          	frame.setVisible(true);        	
          	frame.toFront();
          	this.setVisible(false);
        }    	  
    	  
        if(menu.getSelectedtitulo().equals("Deportes"))
        {
        	frmAdminDeportes frame=new frmAdminDeportes();
        	frame.setVisible(true);
        	frame.toFront();
        	this.setVisible(false);
        }
      
        if(menu.getSelectedtitulo().equals("Partidos"))
        {
        	frmGestionPartidos frame=new frmGestionPartidos();
        	frame.setVisible(true);        	
        	frame.toFront();
        	this.setVisible(false);
        }
        
        if(menu.getSelectedtitulo().equals("Cerrar sesion"))
        {
        	frmPrincipal frame=new frmPrincipal();
        	frame.setVisible(true);        	
        	frame.toFront();
        	this.setVisible(false);
        }    
      
    }
       
    private void initComponents() 
    {
    	setTitle("BetMe - Administrador");
		setBounds(750, 200, 463, 338);

        menu = new org.edisoncor.gui.panel.PanelAvatarChooser();
        //menu.setIcon(new ImageIcon(frmAdmin.class.getResource("/Image/fondo2.png")));
        buttonIpod1 = new org.edisoncor.gui.button.ButtonIpod();
        buttonIpod1.setBounds(409, 220, 79, 76);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);        
  
		addWindowListener(new WindowAdapter() 
		{
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Seguro que deseas salir?","BetMe - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});

        menu.addKeyListener(new java.awt.event.KeyAdapter() 
        {
            public void keyPressed(java.awt.event.KeyEvent evt) 
            {
                menuKeyPressed(evt);
            }
        });

        buttonIpod1.setText(".");
        buttonIpod1.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                buttonIpod1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(menu, GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(menu, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );
        getContentPane().setLayout(layout);
        menu.setLayout(null);
        menu.add(buttonIpod1);
        
        ButtonIcon btnLogOut = new ButtonIcon();
        btnLogOut.setIcon(new ImageIcon(frmAdmin.class.getResource("/Image/logout.png")));
        btnLogOut.setBounds(852, 11, 39, 36);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Quieres cerrar sesion?","BetMe - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	frmPrincipal frm = new frmPrincipal();
	                frm.setVisible(true);
	                frm.toFront();
	                dispose();
		        }                 
            }
        });
        
        menu.add(btnLogOut);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIpod1ActionPerformed(java.awt.event.ActionEvent evt) 
    {//GEN-FIRST:event_buttonIpod1ActionPerformed
    	llamarMenu();
    }//GEN-LAST:event_buttonIpod1ActionPerformed

    private void menuKeyPressed(java.awt.event.KeyEvent evt) 
    {//GEN-FIRST:event_menuKeyPressed
    	if(evt.getKeyCode()==KeyEvent.VK_ENTER)
    	{
    		llamarMenu();
    	}
    }//GEN-LAST:event_menuKeyPressed

    
    public static void main(String args[]) 
    {
        
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) 
        {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) 
        {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) 
        {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(frmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new frmAdmin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonIpod buttonIpod1;
    private org.edisoncor.gui.panel.PanelAvatarChooser menu;
}
