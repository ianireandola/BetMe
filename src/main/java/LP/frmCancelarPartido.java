package LP;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.edisoncor.gui.button.ButtonIcon;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class frmCancelarPartido extends JFrame implements ActionListener 
{	
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblDeporte;
	private JLabel lblSeleccioneElPartido;
	
	private JButton btnEliminarPartido;
	
	private ButtonIcon btnLogOut;
	
	private JComboBox comboBox;
	
	private JList list;
	
	public frmCancelarPartido() 
	{
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);		
		setResizable(true);	
		this.setLocationRelativeTo(null);	
		
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{		
		setTitle("BetMe - Cancelar partido");
		setBounds(100, 100, 616, 457);		
		
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDeporte.setBounds(28, 16, 69, 31);
		getContentPane().add(lblDeporte);
		
		comboBox = new JComboBox();
		comboBox.setBounds(28, 63, 141, 26);
		getContentPane().add(comboBox);
		
		list = new JList();
		list.setBounds(28, 151, 321, 176);
		getContentPane().add(list);
		
		lblSeleccioneElPartido = new JLabel("Seleccione el partido que desea eliminar:");
		lblSeleccioneElPartido.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSeleccioneElPartido.setBounds(28, 105, 414, 30);
		getContentPane().add(lblSeleccioneElPartido);
		
		btnEliminarPartido = new JButton("CANCELAR PARTIDO");
		btnEliminarPartido.setIcon(new ImageIcon(frmCancelarPartido.class.getResource("/Image/eliminar equipo.png")));
		btnEliminarPartido.setBackground(Color.WHITE);
		btnEliminarPartido.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminarPartido.setBounds(142, 370, 241, 29);
		getContentPane().add(btnEliminarPartido);			
		
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