package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LD.MySQLAccess;
import javax.swing.JSpinner;

public class frmRegistro extends JFrame {
	
	private static final long serialVersionUID = 1L;		
	
	private JTextField textField_usuario;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JButton btnRegistrarse;
	private JPasswordField pfContrasena;
	
	MySQLAccess cc = new MySQLAccess();
	Connection con = cc.conexion();
	private JLabel lblId;
	private JLabel lblNombre;
	private JLabel lblTarjetaDeCredito;
	private JLabel lblEdad;
	private JTextField txtNombre;
	private JTextField txtTarjeta;
	private JSpinner spinnerEdad;
	private JSpinner spinnerID;
	
	public frmRegistro()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		setResizable(false);
		createAndShowGUI();
		this.setLocationRelativeTo(null);	
		
	}		
		
	public void esconder(){this.setVisible(false);}
	
	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);
		
		setTitle("BetMe");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(450, 200, 823, 508);
				
		lblLogin = new JLabel("BetMe - Sign In");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 54));
		lblLogin.setBounds(170, 49, 420, 80);
		getContentPane().add(lblLogin);
			
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsuario.setBounds(294, 172, 141, 32);
		getContentPane().add(lblUsuario);
		
		textField_usuario = new JTextField();
		textField_usuario.setBounds(294, 215, 141, 30);
		getContentPane().add(textField_usuario);
		textField_usuario.setColumns(10);
		
		lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContrasena.setBounds(468, 177, 141, 23);
		getContentPane().add(lblContrasena);
		
		pfContrasena = new JPasswordField();
		pfContrasena.setBounds(468, 214, 141, 32);
		getContentPane().add(pfContrasena);
		pfContrasena.setColumns(10);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				esconder();
				int id_apostante = (Integer) spinnerID.getValue();
				String usuario = textField_usuario.getText();
				String contraseña = pfContrasena.getText();	
				String nombre = txtNombre.getText();
				String tarjeta_credito = txtTarjeta.getText();
				int edad = (Integer) spinnerEdad.getValue();
				
				MySQLAccess base = new MySQLAccess();
				
				base.añadirUsuario(id_apostante, usuario, contraseña, nombre, tarjeta_credito, edad);
				
				frmPrincipal home = new frmPrincipal();
				home.setVisible(true);
			}
		});				
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarse.setBounds(294, 403, 141, 23);
		getContentPane().add(btnRegistrarse);
		
		lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblId.setBounds(119, 172, 141, 32);
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
		lblTarjetaDeCredito.setBounds(294, 282, 141, 32);
		getContentPane().add(lblTarjetaDeCredito);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNombre.setBounds(119, 282, 141, 32);
		getContentPane().add(lblNombre);
		
		txtTarjeta = new JTextField();
		txtTarjeta.setColumns(10);
		txtTarjeta.setBounds(294, 325, 141, 30);
		getContentPane().add(txtTarjeta);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(119, 325, 141, 30);
		getContentPane().add(txtNombre);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(504, 317, 74, 38);
		getContentPane().add(spinnerEdad);
		
		spinnerID = new JSpinner();
		spinnerID.setEnabled(false);
		spinnerID.setBounds(157, 215, 74, 38);
		getContentPane().add(spinnerID);
		int N = 100;
		int M = 1;
		int valorEntero = (int) Math.floor(Math.random()*(N-M+1)+M);
		spinnerID.setValue(valorEntero);
		
	}
}
