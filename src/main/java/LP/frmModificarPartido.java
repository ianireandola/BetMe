package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.edisoncor.gui.button.ButtonIcon;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class frmModificarPartido extends JFrame implements ActionListener
{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JTextField textField_1;
	
	private JLabel lblDeporte;
	private JLabel lblSeleccionaElPartido;
	private JLabel lblEquipoLocal;
	private JLabel lblEquipoVisitante;
	private JLabel lblCuota;
	private JLabel lblFecha;
	
	private JComboBox comboBoxDeporte;
	private JComboBox comboBoxLocal;
	private JComboBox comboBox;
	
	private JList list;
	
	private JScrollBar scrollBar;
	
	private JButton btnModificarPartido;	
	
	private ButtonIcon btnLogOut;

	public frmModificarPartido() 
	{
		getContentPane().setBackground(SystemColor.menu);
		getContentPane().setLayout(null);		
		setResizable(true);	
		this.setLocationRelativeTo(null);	
		
		createAndShowGUI();
	}
		
	public void createAndShowGUI()
	{	
		setTitle("BetMe - Modificar partido");
		setBounds(100, 100, 922, 491);
				
		lblDeporte = new JLabel("Deporte");
		lblDeporte.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDeporte.setBounds(34, 29, 112, 27);
		getContentPane().add(lblDeporte);
		
		comboBoxDeporte = new JComboBox();
		comboBoxDeporte.setBounds(34, 72, 152, 26);
		getContentPane().add(comboBoxDeporte);
		
		lblSeleccionaElPartido = new JLabel("Selecciona el partido que quiere modificar: ");
		lblSeleccionaElPartido.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSeleccionaElPartido.setBounds(34, 127, 399, 27);
		getContentPane().add(lblSeleccionaElPartido);
		
		list = new JList();
		list.setBounds(44, 185, 351, 224);
		getContentPane().add(list);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(369, 185, 26, 224);
		getContentPane().add(scrollBar);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblFecha.setBounds(466, 29, 97, 25);
		getContentPane().add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(460, 72, 112, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblEquipoLocal = new JLabel("Equipo local");
		lblEquipoLocal.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEquipoLocal.setBounds(463, 127, 109, 25);
		getContentPane().add(lblEquipoLocal);
		
		comboBoxLocal = new JComboBox();
		comboBoxLocal.setBounds(460, 168, 143, 26);
		getContentPane().add(comboBoxLocal);
		
		lblEquipoVisitante = new JLabel("Equipo visitante");
		lblEquipoVisitante.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEquipoVisitante.setBounds(672, 127, 143, 25);
		getContentPane().add(lblEquipoVisitante);
		
		comboBox = new JComboBox();
		comboBox.setBounds(672, 168, 143, 26);
		getContentPane().add(comboBox);
		
		lblCuota = new JLabel("Cuota");
		lblCuota.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCuota.setBounds(467, 229, 96, 27);
		getContentPane().add(lblCuota);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setText("â‚¬");
		textField_1.setBounds(460, 262, 69, 26);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnModificarPartido = new JButton("MODIFICAR PARTIDO");
		btnModificarPartido.setBackground(Color.WHITE);
		btnModificarPartido.setIcon(new ImageIcon(frmModificarPartido.class.getResource("/Image/eliminar equipo.png")));
		btnModificarPartido.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnModificarPartido.setBounds(496, 330, 319, 43);
		getContentPane().add(btnModificarPartido);
				
		btnLogOut = new ButtonIcon();
        btnLogOut.setIcon(new ImageIcon(frmAdmin.class.getResource("/Image/logout.png")));
        btnLogOut.setBounds(834, 29, 39, 36);
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
