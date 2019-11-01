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

public class frmAltaDeporte extends JFrame implements ActionListener {
	public frmAltaDeporte() {
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		setBounds(100, 100, 616, 457);
		setResizable(true);	
		this.setLocationRelativeTo(null);	
		
		setTitle("BetMe - Alta Deporte");	
		
		JLabel lblNombreDeporte = new JLabel("NOMBRE DEPORTE");
		lblNombreDeporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNombreDeporte.setBounds(42, 36, 181, 20);
		getContentPane().add(lblNombreDeporte);
		
		textField = new JTextField();
		textField.setBounds(42, 72, 215, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCIÃ“N");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDescripcin.setBounds(42, 126, 155, 20);
		getContentPane().add(lblDescripcin);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(42, 162, 407, 97);
		getContentPane().add(textArea);
		
		JButton btnAltaDeporte = new JButton("AÃ‘ADIR DEPORTE");
		btnAltaDeporte.setBackground(Color.WHITE);
		btnAltaDeporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaDeporte.setIcon(new ImageIcon(frmAltaDeporte.class.getResource("/Image/aÃ±adir equipo.png")));
		btnAltaDeporte.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAltaDeporte.setBounds(244, 306, 191, 29);
		getContentPane().add(btnAltaDeporte);
		
	
		
		ButtonIcon btnLogOut = new ButtonIcon();
        btnLogOut.setIcon(new ImageIcon(frmAdmin.class.getResource("/Image/logout.png")));
        btnLogOut.setBounds(525, 46, 39, 36);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
