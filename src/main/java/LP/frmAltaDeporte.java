package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.edisoncor.gui.button.ButtonIcon;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class frmAltaDeporte extends JFrame implements ActionListener 
{	
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	
	private JLabel lblNombreDeporte;
	private JLabel lblDescripcion;
	
	private JTextArea textArea;
	
	private JButton btnAltaDeporte;
	
	private ButtonIcon btnLogOut;
	
	public frmAltaDeporte() 
	{
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		setResizable(true);	
		createAndShowGUI();
		this.setLocationRelativeTo(null);
	}
	
	public void createAndShowGUI()
	{
		setTitle("BetMe - Alta Deporte");
		setBounds(100, 100, 616, 457);			
		
		lblNombreDeporte = new JLabel("NOMBRE DEPORTE");
		lblNombreDeporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreDeporte.setBounds(42, 36, 181, 20);
		getContentPane().add(lblNombreDeporte);
		
		textField = new JTextField();
		textField.setBounds(42, 72, 215, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescripcion.setBounds(42, 126, 155, 20);
		getContentPane().add(lblDescripcion);
		
		textArea = new JTextArea();
		textArea.setBounds(42, 162, 407, 97);
		getContentPane().add(textArea);
		
		btnAltaDeporte = new JButton("AGREGAR DEPORTE");
		btnAltaDeporte.setBackground(Color.WHITE);
		btnAltaDeporte.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnAltaDeporte.setIcon(new ImageIcon(frmAltaDeporte.class.getResource("/Image/añadir equipo.png")));
		btnAltaDeporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAltaDeporte.setBounds(244, 306, 191, 29);
		getContentPane().add(btnAltaDeporte);	
		
		btnLogOut = new ButtonIcon();
        btnLogOut.setIcon(new ImageIcon(frmAdmin.class.getResource("/Image/logout.png")));
        btnLogOut.setBounds(525, 46, 39, 36);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"Quieres cerrar sesin?","BetMe - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	frmAdmin1 frm = new frmAdmin1();
	                frm.setVisible(true);
	                frm.toFront();
	                dispose();
		        }                 
            }
        });
        
        getContentPane().add(btnLogOut);
	}	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
