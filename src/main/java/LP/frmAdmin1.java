package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class frmAdmin1 extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDesktopPane miDesktop;
	
	public frmAdmin1() {
		
		getContentPane().setBackground(Color.WHITE);
		
		
		setTitle("Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 764, 431);
		setResizable(true);
		this.setLocationRelativeTo(null);
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setIcon(new ImageIcon(frmAdmin1.class.getResource("/Image/deporte.jpg")));
		lblFondo.setBounds(0, 0, 764, 431);
		getContentPane().add(lblFondo);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesin");
		mnInicio.add(mntmCerrarSesion);
		mntmCerrarSesion.addActionListener(this);
		mntmCerrarSesion.setActionCommand("CerrarSesion");
		
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnInicio.add(mntmSalir);
		mntmSalir.addActionListener(this);
		mntmSalir.setActionCommand("Salir");
		
		JMenu mnDeporte = new JMenu("Deporte");
		menuBar.add(mnDeporte);
		
		JMenuItem mntmNuevoDeporte = new JMenuItem("Nuevo");
		mnDeporte.add(mntmNuevoDeporte);
		mntmNuevoDeporte.addActionListener(this);
		mntmNuevoDeporte.setActionCommand("NuevoDeporte");		
		
		
		JMenuItem mntmModificarDeporte = new JMenuItem("Modificar");
		mnDeporte.add(mntmModificarDeporte);
		mntmModificarDeporte.addActionListener(this);
		mntmModificarDeporte.setActionCommand("ModificarDeporte");
		
		JMenuItem mntmEliminarDeporte = new JMenuItem("Eliminar");
		mnDeporte.add(mntmEliminarDeporte);
		mntmEliminarDeporte.addActionListener(this);
		mntmEliminarDeporte.setActionCommand("EliminarDeporte");
		
		JMenu mnPartidos = new JMenu("Partidos");
		menuBar.add(mnPartidos);
		
		JMenuItem mntmNuevoPartido = new JMenuItem("Nuevo");
		mnPartidos.add(mntmNuevoPartido);
		mntmNuevoPartido.addActionListener(this);
		mntmNuevoPartido.setActionCommand("NuevoPartido");
		
		JMenuItem mntmModificarPartido = new JMenuItem("Modificar");
		mnPartidos.add(mntmModificarPartido);
		mntmModificarPartido.addActionListener(this);
		mntmModificarPartido.setActionCommand("ModificarPartido");
		
		
		JMenuItem mntmCancelarPartido = new JMenuItem("Cancelar");
		mnPartidos.add(mntmCancelarPartido);
		mntmCancelarPartido.addActionListener(this);
		mntmCancelarPartido.setActionCommand("CancelarPartido");
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
	



