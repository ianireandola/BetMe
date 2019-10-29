package LP;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;



public class frmPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;	
	
	
	private JTextField textField_usuario;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JButton btnEntrar;
	private JPasswordField pfContrasena;
	private JProgressBar progressBar;
	
	private Timer tiempo;
	int cont;
	public final static int TWO_SECOND = 20;
	
	Connection connection = null;
	private JButton btnRegistrarme;
	
		
	public frmPrincipal()
	{
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		createAndShowGUI();
		this.setLocationRelativeTo(null); //Para que la ventana salga en el centro de la pantalla
		progressBar.setVisible(false);
	//	connection = MySQLAccess.readDataBase();
		
	}
	
	/*
	//Carga de la barra de progreso cuando inicia sesion el adiministrador
	class TimeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cont ++;
			progressBar.setValue(cont);
			if(cont==100)
			{
				tiempo.stop();
				esconder();
				JOptionPane.showMessageDialog(null, "Has iniciado sesi�n correctamente");
				frmAdministrador objAdmin = new frmAdministrador();
				objAdmin.setVisible(true);
			}
			
		}
		
	}
	
	//Carga de la barra de progreso cuando inicia sesion el usuario
	class TimeListener2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			cont ++;
			progressBar.setValue(cont);
			if(cont==100)
			{
				tiempo.stop();
				esconder();
				JOptionPane.showMessageDialog(null, "Has iniciado sesi�n correctamente");
				frmUsuario objUsu = new frmUsuario();
				objUsu.setVisible(true);
			}
			
		}
		
	}
	*/
	
	public void esconder(){this.setVisible(false);}
	public void activar(){tiempo.start();}

	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);
		  
		
		
		progressBar = new JProgressBar();
		progressBar.setBounds(524, 424, 271, 23);
		getContentPane().add(progressBar);
				
		lblLogin = new JLabel("BetMe");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 54));
		lblLogin.setBounds(474, 62, 321, 80);
		getContentPane().add(lblLogin);
			
		lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUsuario.setBounds(497, 172, 100, 32);
		getContentPane().add(lblUsuario);
		
		textField_usuario = new JTextField();
		textField_usuario.setBounds(474, 213, 141, 30);
		getContentPane().add(textField_usuario);
		textField_usuario.setColumns(10);
		
		lblContrasena = new JLabel("CONTRASE\u00D1A");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblContrasena.setBounds(641, 177, 141, 23);
		getContentPane().add(lblContrasena);
		
		pfContrasena = new JPasswordField();
		pfContrasena.setBounds(641, 212, 141, 32);
		getContentPane().add(pfContrasena);
		pfContrasena.setColumns(10);
		
		
		
		btnEntrar = new JButton("ENTRAR");
		
		/*
		//Validacion de la entrada del administrador
		btnEntrar.addActionListener(new ActionListener()
		{
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String query = "select * from LOGIN where USERNAME=? and PASSWORD=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField_usuario.getText());
					pst.setString(2, pfContrase�a.getText());
					
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count = count +1;
					}
					if(count == 1)
					{
						
											
						clsGestorAdministrador objA = new clsGestorAdministrador();	
						
	s
						String nombre = textField_usuario.getText();
						String contrase�a = pfContrase�a.getText();
				
						BD base=new BD();
						
						if(objA.LeerContrase�a(nombre, contrase�a)==true)
						{
							progressBar.setVisible(true);
							cont=-1;
							progressBar.setValue(0);
							progressBar.setStringPainted(true);
							tiempo = new Timer(TWO_SECOND, new TimeListener());
							activar();
													
						}
						else if (base.contrase�a(nombre,contrase�a)==true)
						{	
							progressBar.setVisible(true);
							cont=-1;
							progressBar.setValue(0);
							progressBar.setStringPainted(true);
							tiempo = new Timer(TWO_SECOND, new TimeListener2());
							activar();
							
								
						}
						else if(base.contrase�a(nombre,contrase�a)==false)
						{
							System.out.println("nada");
						}
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Usuario y contrase�a duplicados");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Usuario y/o contrase�a incorrectos");
					}				
					
					rs.close();
					pst.close();
					
				}catch(Exception e1)
				{
					//JOptionPane.showMessageDialog(null, e1);				
				}
							
			}
		});
		
		*/
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(574, 263, 187, 32);
		getContentPane().add(btnEntrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Image/fondo.jpg")));
		lblFondo.setBounds(0, 16, 817, 469);
		getContentPane().add(lblFondo);
		
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(574, 272, 100, 23);
		getContentPane().add(btnEntrar);
		
		btnRegistrarme = new JButton("REGISTRARME");
		btnRegistrarme.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarme.setBounds(559, 322, 137, 23);
		getContentPane().add(btnRegistrarme);
		
		
		setTitle("BetMe");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(450, 200, 823, 508);
		
		
	}
}
