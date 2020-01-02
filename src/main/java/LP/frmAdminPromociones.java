package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import LD.MySQLAccess;

import javax.swing.JButton;

/**
 * Clase para la gestión de promociones
 * @author Martin Router King
 *
 */
public class frmAdminPromociones extends JFrame implements ActionListener, MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	
	private JPanel panel;
	
	private JTextArea txtrLosUsuariosQue;
	
	private JButton btnActualizar;
	private JButton btnSalir;
	
	private JLabel lblEuros;
	
	/**
	 * Constructor de la clase
	 */
	public frmAdminPromociones() 
	{		
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		createAndShowGUI();
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Metodo para cargar la vista
	 */
	public void createAndShowGUI()
	{
		setTitle("BetMe - Promociones");	
		setBounds(100, 100, 581, 457);	
		getContentPane().setLayout(null);
		
		panel.setBorder(new TitledBorder(null, "PROMOCIONES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 30, 529, 233);
		getContentPane().add(panel);
		panel.setLayout(null);
						
		txtrLosUsuariosQue.setForeground(Color.BLACK);
		txtrLosUsuariosQue.setBounds(33, 37, 404, 47);
		panel.add(txtrLosUsuariosQue);
		txtrLosUsuariosQue.setFont(new Font("Arial", Font.BOLD, 14));
		txtrLosUsuariosQue.setBackground(SystemColor.control);
		txtrLosUsuariosQue.setEditable(false);
		txtrLosUsuariosQue.setText("Los usuarios que se registren por primera vez, \r\nrecibir\u00E1n como regalo la siguiente cantidad: ");
		
		textField = new JTextField();
		textField.setBounds(33, 87, 38, 37);
		panel.add(textField);
		textField.setColumns(10);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(64, 188, 146, 29);
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand("ACTUALIZAR");
		panel.add(btnActualizar);				
		
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(283, 188, 115, 29);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("SALIR");
		panel.add(btnSalir);
		
		lblEuros = new JLabel("euros");
		lblEuros.setBounds(74, 100, 69, 20);
		panel.add(lblEuros);
		
		llenar();
		
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


	/**
	 * Metodo que nos permite llenar la vista con datos de la BBDD
	 */
	private void llenar() 
	{
		// TODO Auto-generated method stub
		
		MySQLAccess base=new MySQLAccess();
		
		int cantidad=base.cargarPromocion();
		String cantidad_cuota = cantidad + "";
		textField.setText(cantidad_cuota);
	}


	/**
	 * Metodo que responde a las acciones en la vista
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		
		switch(e.getActionCommand()){						
			
		case "ACTUALIZAR":
			
			this.actualizar();
			break;			
			
			
		case "SALIR":
			
			this.dispose();

			frmAdmin admin = new frmAdmin();
			admin.setVisible(true);
			admin.toFront();
			break;
		}
	}
	
	/**
	 * Metodo para actualizar los campos
	 */
	private void actualizar() 
	{
		// TODO Auto-generated method stub
		
		int cantidad=Integer.parseInt(textField.getText().toString());	
		MySQLAccess base=new MySQLAccess();
		
		if(textField.getText().toString().isEmpty()  )
		{
			JOptionPane.showMessageDialog(null, "¡Rellene todos los campos");
		}
		
		else{
			
			base.actualizarCantidad(cantidad);
			llenar();
	        JOptionPane.showMessageDialog(null, "Promocion modificada");
	       // limpiar();
		}
	
	}
	
	/**
	 * Metodo para limpiar los campos
	 */
	public void limpiar()
	{
		textField.setText("");
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
