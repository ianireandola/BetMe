package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class frmAdmin1 extends JFrame implements ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	private JDesktopPane miDesktop;
	
	private JLabel lblFondo;
	
	private JMenuBar menuBar;
	
	private JMenu mnInicio;
	private JMenu mnDeporte;
	private JMenu mnPartidos;
	
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmSalir;
	private JMenuItem mntmNuevoDeporte;
	private JMenuItem mntmModificarDeporte;
	private JMenuItem mntmEliminarDeporte;
	private JMenuItem mntmNuevoPartido;
	private JMenuItem mntmModificarPartido;
	private JMenuItem mntmCancelarPartido;
	
	public frmAdmin1() 
	{
		getContentPane().setBackground(Color.WHITE);
		setResizable(true);
		createAndShowGUI();
		this.setLocationRelativeTo(null);
	}
		
	public void createAndShowGUI()
	{
				
		setTitle("BetMe - Administrador");	
		this.setIconImage(new ImageIcon(getClass().getResource("/Image/betme.jpg")).getImage());
		setBounds(450, 200, 823, 508);
				
		lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setIcon(new ImageIcon(frmAdmin1.class.getResource("/Image/deporte.jpg")));
		lblFondo.setBounds(0, 0, 764, 431);
		getContentPane().add(lblFondo);
		
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mnInicio.add(mntmCerrarSesion);
		mntmCerrarSesion.addActionListener(this);
		mntmCerrarSesion.setActionCommand("CerrarSesion");
		
		
		mntmSalir = new JMenuItem("Salir");
		mnInicio.add(mntmSalir);
		mntmSalir.addActionListener(this);
		mntmSalir.setActionCommand("Salir");
		
		mnDeporte = new JMenu("Deporte");
		menuBar.add(mnDeporte);
		
		mntmNuevoDeporte = new JMenuItem("Nuevo");
		mnDeporte.add(mntmNuevoDeporte);
		mntmNuevoDeporte.addActionListener(this);
		mntmNuevoDeporte.setActionCommand("NuevoDeporte");		
		
		
		mntmModificarDeporte = new JMenuItem("Modificar");
		mnDeporte.add(mntmModificarDeporte);
		mntmModificarDeporte.addActionListener(this);
		mntmModificarDeporte.setActionCommand("ModificarDeporte");
		
		mntmEliminarDeporte = new JMenuItem("Eliminar");
		mnDeporte.add(mntmEliminarDeporte);
		mntmEliminarDeporte.addActionListener(this);
		mntmEliminarDeporte.setActionCommand("EliminarDeporte");
		
		mnPartidos = new JMenu("Partidos");
		menuBar.add(mnPartidos);
		
		mntmNuevoPartido = new JMenuItem("Nuevo");
		mnPartidos.add(mntmNuevoPartido);
		mntmNuevoPartido.addActionListener(this);
		mntmNuevoPartido.setActionCommand("NuevoPartido");
		
		mntmModificarPartido = new JMenuItem("Modificar");
		mnPartidos.add(mntmModificarPartido);
		mntmModificarPartido.addActionListener(this);
		mntmModificarPartido.setActionCommand("ModificarPartido");
		
		
		mntmCancelarPartido = new JMenuItem("Cancelar");
		mnPartidos.add(mntmCancelarPartido);
		mntmCancelarPartido.addActionListener(this);
		mntmCancelarPartido.setActionCommand("CancelarPartido");
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() 
		{
		    @Override
		    public void windowClosing(WindowEvent we)
		    { 
		        String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"¿Seguro que deseas salir?","BetMe - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		            System.exit(0);
		        }
		    }
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getActionCommand())
		{
			case "CerrarSesion"	:
				this.principal();
				break;
			
			case "Salir":
				this.dispose();
				break;
			
			case "NuevoDeporte":
				this.nuevoDeporte();
				break;
				
			case "ModificarDeporte":
				this.modificarDeporte();
				break;
			case "EliminarDeporte":
				this.eliminarDeporte();
				break;
				
			case "NuevoPartido":
				this.nuevoPartido();
				break;
				
			case "ModificarPartido":
				this.modificarPartido();
				break;
			case "CancelarPartido":
				this.cancelarPartido();
				break;
			
				
							
			}
	
		}
	
	
	private void cancelarPartido() {
		// TODO Auto-generated method stub
		frmCancelarPartido frame=new frmCancelarPartido();
		frame.setVisible(true);	
	}

	private void modificarPartido() {
		// TODO Auto-generated method stub
		frmModificarPartido frame=new frmModificarPartido();
		frame.setVisible(true);	
	}

	private void nuevoPartido() {
		// TODO Auto-generated method stub
		frmNuevoPartido frame=new frmNuevoPartido();
		frame.setVisible(true);	
	}

	public void principal()
	{
		this.dispose();
		frmPrincipal frame=new frmPrincipal();
		frame.setVisible(true);		
		
	}
	
	public void nuevoDeporte()
	{
		
		frmAltaDeporte frame=new frmAltaDeporte();
		frame.setVisible(true);		
		
	}
	
	public void modificarDeporte()
	{
		
		frmModificarDeporte frame=new frmModificarDeporte();
		frame.setVisible(true);		
		
	}
	
	public void eliminarDeporte()
	{
		
		frmEliminarDeporte frame=new frmEliminarDeporte();
		frame.setVisible(true);		
		
	}
	
	  
}
	



