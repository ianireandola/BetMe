package LP;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import org.edisoncor.gui.button.ButtonIcon;

import java.awt.Scrollbar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollBar;

public class frmEliminarDeporte extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private JLabel lblSeleccioneElDeporte;
	
	private JList list;
	
	private JButton btnEliminar;
	
	private ButtonIcon btnLogOut;
	
	private JScrollBar scrollBar;
	
	public frmEliminarDeporte() 
	{
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);	
		setResizable(true);	
		this.setLocationRelativeTo(null);	
		
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{		
		setTitle("BetMe - Eliminar Deporte");	
		setBounds(100, 100, 581, 457);		
		
		lblSeleccioneElDeporte = new JLabel("Selecciona el deporte que quiere eliminar: ");
		lblSeleccioneElDeporte.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSeleccioneElDeporte.setBounds(43, 36, 386, 40);
		getContentPane().add(lblSeleccioneElDeporte);
		
		list = new JList();
		list.setBounds(48, 92, 342, 220);
		getContentPane().add(list);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setIcon(new ImageIcon(frmEliminarDeporte.class.getResource("/Image/eliminar equipo.png")));
		btnEliminar.setBounds(250, 357, 179, 29);
		getContentPane().add(btnEliminar);
		
		
		btnLogOut = new ButtonIcon();
        btnLogOut.setIcon(new ImageIcon(frmAdmin.class.getResource("/Image/logout.png")));
        btnLogOut.setBounds(453, 41, 39, 36);
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
        
        scrollBar = new JScrollBar();
        scrollBar.setBounds(364, 92, 26, 220);
        getContentPane().add(scrollBar);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
			
	}
}