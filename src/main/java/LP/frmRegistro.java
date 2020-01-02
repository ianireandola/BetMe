package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LD.MySQLAccess;
import javax.swing.JSpinner;

/**
 * Clase para la gestion de registros
 * @author Martin Router King
 *
 */
public class frmRegistro extends JFrame 
{	
	private static final long serialVersionUID = 1L;		
	
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtTarjeta;
	
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JLabel lblContrasenaCon;
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblTarjetaDeCredito;
	private JLabel lblEdad;
	
	private JButton btnRegistrarse;
	private JButton btnVolver;
	
	private JPasswordField pfContrasena;
	private JPasswordField pfContrasenaCon;		
	
	private JSpinner spinnerEdad;
	private JSpinner spinnerID;
		
	MySQLAccess cc = new MySQLAccess();
	Connection con = cc.conexion();
	
	/**
	 * Constructor de la clase
	 */
	public frmRegistro()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		setResizable(false);
		createAndShowGUI();
		this.setLocationRelativeTo(null);	
		
	}		
		
	/**
	 * Metodo para esconde la vista
	 */
	public void esconder()
	{
		this.setVisible(false);
	}
	
	/**
	 * Metodo para cargar la vista de la clase
	 */
	public void createAndShowGUI()
	{		
		setTitle("BetMe - Formulario de registro");	
		this.setIconImage(new ImageIcon(getClass().getResource("/Image/betme.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(450, 200, 823, 508);
				
		lblLogin = new JLabel("BetMe - Sign In");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 54));
		lblLogin.setBounds(238, 46, 420, 80);
		getContentPane().add(lblLogin);
			
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsuario.setBounds(139, 186, 141, 32);
		getContentPane().add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(290, 190, 141, 30);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContrasena.setBounds(122, 247, 141, 23);
		getContentPane().add(lblContrasena);
		
		pfContrasena = new JPasswordField();
		pfContrasena.setBounds(290, 238, 141, 32);
		getContentPane().add(pfContrasena);
		pfContrasena.setColumns(10);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				MySQLAccess base = new MySQLAccess();
				
				int id_apostante = (Integer) spinnerID.getValue();
				
				String contraseña = new String (pfContrasena.getPassword());
				String contraseñacon = new String (pfContrasenaCon.getPassword());
				
				String usuario = txtUsuario.getText();				
				String nombre = txtNombre.getText();
				String tarjeta_credito = txtTarjeta.getText();
				int edad = (Integer) spinnerEdad.getValue();
				
				if(base.existeID(id_apostante)==true)
				{
					JOptionPane.showMessageDialog(null, "¡Ya existe un usuario con ese ID!");					
				}
				else if(usuario.equals("") || pfContrasena.equals("") || pfContrasenaCon.equals("") || nombre.equals("") || tarjeta_credito.equals(""))
				{
					if(edad < 18)
					{
						JOptionPane.showMessageDialog(null, " No se permite el registro a menores de 18 años. ");
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "¡Hay campos vacios! Debe rellenar todos los campos.");
					}
					
				}
				else
				{
					if(contraseña.equals(contraseñacon))
					{
						
						esconder();					
						
						base.añadirUsuario(id_apostante, usuario, contraseña, nombre, tarjeta_credito, edad);
						
						JOptionPane.showMessageDialog(null, "¡Usuario registrado correctamente!");
						
						frmPrincipal home = new frmPrincipal();
						home.setVisible(true);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
					}
				}				
				
			}
		});				
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarse.setBounds(364, 417, 141, 23);
		getContentPane().add(btnRegistrarse);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(139, 143, 141, 32);
		getContentPane().add(lblId);
		
		lblEdad = new JLabel("EDAD");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEdad.setBounds(468, 282, 141, 32);
		getContentPane().add(lblEdad);
		
		lblTarjetaDeCredito = new JLabel("Nº T.CREDITO");
		lblTarjetaDeCredito.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarjetaDeCredito.setForeground(Color.WHITE);
		lblTarjetaDeCredito.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTarjetaDeCredito.setBounds(468, 235, 141, 32);
		getContentPane().add(lblTarjetaDeCredito);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNombre.setBounds(468, 186, 141, 32);
		getContentPane().add(lblNombre);
		
		txtTarjeta = new JTextField();
		txtTarjeta.setColumns(10);
		txtTarjeta.setBounds(616, 239, 141, 30);
		getContentPane().add(txtTarjeta);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(616, 190, 141, 30);
		getContentPane().add(txtNombre);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(619, 282, 74, 38);
		getContentPane().add(spinnerEdad);
		
		spinnerID = new JSpinner();
		spinnerID.setEnabled(true);
		spinnerID.setBounds(290, 141, 74, 38);
		getContentPane().add(spinnerID);
		int N = 100;
		int M = 1;
		int valorEntero = (int) Math.floor(Math.random()*(N-M+1)+M);
		spinnerID.setValue(valorEntero);
		
		lblContrasenaCon = new JLabel("CONFIRMAR CONTRASEÑA");
		lblContrasenaCon.setVerticalAlignment(SwingConstants.TOP);
		lblContrasenaCon.setForeground(Color.WHITE);
		lblContrasenaCon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContrasenaCon.setBounds(10, 337, 270, 32);
		getContentPane().add(lblContrasenaCon);
		
		pfContrasenaCon = new JPasswordField();
		pfContrasenaCon.setColumns(10);
		pfContrasenaCon.setBounds(290, 325, 141, 32);
		getContentPane().add(pfContrasenaCon);
		
		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{				
				String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"¿Deseas volver a la página principal?","BetMe - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	esconder();
		        	frmPrincipal home = new frmPrincipal();
					home.setVisible(true);
		        }
				
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnVolver.setBounds(716, 445, 91, 23);
		getContentPane().add(btnVolver);
		
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
}
