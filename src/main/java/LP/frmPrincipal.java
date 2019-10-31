package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import LD.MySQLAccess;

public class frmPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;		
	
	private JTextField textField_usuario;
	private JLabel lblLogin;
	private JLabel lblUsuario;
	private JLabel lblContrasena;
	private JButton btnEntrar;
	private JButton btnRegistrarse;
	private JPasswordField pfContrasena;
	
	MySQLAccess cc = new MySQLAccess();
	Connection con = cc.conexion();
	
	public frmPrincipal()
	{
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		createAndShowGUI();
		this.setLocationRelativeTo(null);	
		
	}		
		
	public void esconder(){this.setVisible(false);}
	
	public void createAndShowGUI()
	{
		getContentPane().setLayout(null);
		
		setTitle("BetMe");	
		this.setIconImage(new ImageIcon(getClass().getResource("/Image/betme.jpg")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(450, 200, 823, 508);
		
		btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				esconder();
				frmRegistro registro = new frmRegistro();
				registro.setVisible(true);
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarse.setBounds(666, 445, 141, 23);
		getContentPane().add(btnRegistrarse);
				
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
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) 
			{
				int control = 0;
				
				try
				{
					String query = "select * from empleados_admin where usuario=? and contraseña=? ";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, textField_usuario.getText());
					pst.setString(2, pfContrasena.getText());				
					
					ResultSet rs = pst.executeQuery();					
					
					int count = 0;
										
					while(rs.next())
					{
						count = count + 1;
					}
					if(count == 1)
					{
						String usuario = textField_usuario.getText();
						String contraseña = pfContrasena.getText();
				
						MySQLAccess base=new MySQLAccess();
						
						if(base.validarAdmin(usuario, contraseña)==true)
						{
							esconder();
							control=1;
							JOptionPane.showMessageDialog(null, "Has iniciado sesión correctamente");
							frmAdmin1 adm = new frmAdmin1();
							adm.setVisible(true);							
						}
						else if(base.validarAdmin(usuario, contraseña)==false)
						{
							System.out.println("nada");
													
						}
					}					
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null, "Usuario y contraseña duplicados");
					}					
										
					rs.close();
					pst.close();					
					
				}
				catch(Exception e1)
				{
					//JOptionPane.showMessageDialog(null, e1);				
				}
				
				try 
				{
					String query2 = "select * from apostante where usuario=? and contraseña=? ";
					PreparedStatement pst2 = con.prepareStatement(query2);
					pst2.setString(1, textField_usuario.getText());
					pst2.setString(2, pfContrasena.getText());
					
					ResultSet rs2 = pst2.executeQuery();
					
					int count2 = 0;
					
					while(rs2.next())
					{
						count2 = count2 + 1;								
					}
					
					if(count2 == 1)
					{
						String usuario2 = textField_usuario.getText();
						String contraseña2 = pfContrasena.getText();
				
						MySQLAccess base2=new MySQLAccess();
						
						if(base2.validarUsuario(usuario2, contraseña2)==true)
						{
							esconder();
							JOptionPane.showMessageDialog(null, "Has iniciado sesión correctamente");
							frmUsuario adm = new frmUsuario();
							adm.setVisible(true);							
						}
						else if(base2.validarUsuario(usuario2, contraseña2)==false)
						{
							System.out.println("nada");														
						}
					}					
					else if(count2>1)
					{
						JOptionPane.showMessageDialog(null, "Usuario y contraseña duplicados");
					}
					else if(control != 1)
					{
						System.out.println("entra en 2");
						JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrectas");
					}
					
					rs2.close();
					pst2.close();
				} 
				catch (Exception e) 
				{
					// TODO: handle exception
				}
			}
		});				
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setBounds(574, 272, 100, 23);
		getContentPane().add(btnEntrar);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setIcon(new ImageIcon(frmPrincipal.class.getResource("/Image/fondo.jpg")));
		lblFondo.setBounds(0, 0, 817, 485);
		getContentPane().add(lblFondo);		
		
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
