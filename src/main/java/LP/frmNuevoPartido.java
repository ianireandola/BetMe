package LP;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.edisoncor.gui.button.ButtonIcon;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class frmNuevoPartido extends JFrame implements ActionListener
{	
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JTextField textField_1;
	
	private JLabel lblDeporte;
	private JLabel lblVisitante;
	private JLabel lblEquipoVisitante;
	private JLabel lblFecha;
	private JLabel lblCuota;
	
	private JComboBox comboBoxDeporte;
	private JComboBox comboBoxLocal;
	private JComboBox comboBoxVisitante;
	
	private JButton btnCrearPartido;
	
	private ButtonIcon btnLogOut;
	
	public frmNuevoPartido() 
	{
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);		
		setResizable(true);	
		this.setLocationRelativeTo(null);	
		
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{
		setTitle("BetMe - Nuevo partido");	
		setBounds(100, 100, 616, 457);
				
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDeporte.setBounds(33, 16, 101, 26);
		getContentPane().add(lblDeporte);
		
		comboBoxDeporte = new JComboBox();
		comboBoxDeporte.setBounds(33, 50, 157, 26);
		getContentPane().add(comboBoxDeporte);
		
		lblVisitante = new JLabel("Equipo local");
		lblVisitante.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblVisitante.setBounds(37, 111, 112, 26);
		getContentPane().add(lblVisitante);
		
		comboBoxLocal = new JComboBox();
		comboBoxLocal.setBounds(33, 153, 157, 26);
		getContentPane().add(comboBoxLocal);
		
		lblEquipoVisitante = new JLabel("Equipo visitante");
		lblEquipoVisitante.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEquipoVisitante.setBounds(269, 111, 169, 26);
		getContentPane().add(lblEquipoVisitante);
		
		comboBoxVisitante = new JComboBox();
		comboBoxVisitante.setBounds(269, 153, 157, 26);
		getContentPane().add(comboBoxVisitante);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFecha.setBounds(269, 16, 69, 20);
		getContentPane().add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(269, 50, 146, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblCuota = new JLabel("Cuota");
		lblCuota.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCuota.setBounds(33, 210, 69, 20);
		getContentPane().add(lblCuota);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("â‚¬");
		textField_1.setBounds(33, 246, 58, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnCrearPartido = new JButton("CREAR PARTIDO");
		btnCrearPartido.setBackground(Color.WHITE);
		btnCrearPartido.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCrearPartido.setIcon(new ImageIcon(frmNuevoPartido.class.getResource("/Image/aÃ±adir equipo.png")));
		btnCrearPartido.setBounds(196, 296, 230, 29);
		getContentPane().add(btnCrearPartido);		
		
		btnLogOut = new ButtonIcon();
        btnLogOut.setIcon(new ImageIcon(frmAdmin.class.getResource("/Image/logout.png")));
        btnLogOut.setBounds(509, 32, 39, 36);
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



