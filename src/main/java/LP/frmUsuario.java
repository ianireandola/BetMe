package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class frmUsuario extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCantidad;
	private JTextField textField;
	public frmUsuario() {
		
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.BLACK);
		setBounds(100, 100, 941, 457);
		setResizable(true);		
		getContentPane().setLayout(null);
		
		getContentPane().createImage(100, 100);
		
		List list = new List();
		list.setBounds(302, 154, 272, 222);
		getContentPane().add(list);
		this.setLocationRelativeTo(null); 
		
		Label lbl_partido = new Label("PARTIDOS");
		lbl_partido.setForeground(new Color(255, 215, 0));
		lbl_partido.setFont(new Font("Tahoma", Font.BOLD, 16));		
		lbl_partido.setBackground(Color.BLACK);
		lbl_partido.setBounds(302, 121, 152, 27);		
		getContentPane().add(lbl_partido);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setEnabled(false);
		txtCantidad.setText("\u20AC");
		txtCantidad.setToolTipText("\u20AC");
		txtCantidad.setBounds(672, 79, 61, 26);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblCantidad = new JLabel("SALDO ACTUAL");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCantidad.setForeground(new Color(255, 215, 0));
		lblCantidad.setBounds(672, 46, 140, 20);
		getContentPane().add(lblCantidad);
		
		JLabel lblCantidadAApostar = new JLabel("EQUIPO");
		lblCantidadAApostar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCantidadAApostar.setForeground(new Color(255, 215, 0));
		lblCantidadAApostar.setBounds(672, 140, 82, 20);
		getContentPane().add(lblCantidadAApostar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(672, 176, 152, 26);
		getContentPane().add(comboBox);
		
		JLabel lblCantidad_1 = new JLabel("CANTIDAD");
		lblCantidad_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCantidad_1.setForeground(new Color(255, 215, 0));
		lblCantidad_1.setBounds(672, 232, 105, 20);
		getContentPane().add(lblCantidad_1);
		
		textField = new JTextField();
		textField.setBounds(672, 268, 50, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnapostar = new JButton("\u00A1APOSTAR!");
		btnapostar.setBackground(new Color(255, 215, 0));
		btnapostar.setBounds(672, 328, 207, 44);
		getContentPane().add(btnapostar);
		
		JLabel lblNewLabel = new JLabel("DEPORTES");
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getStyle() | Font.BOLD));
		lblNewLabel.setForeground(new Color(255, 215, 0));
		lblNewLabel.setBounds(305, 32, 115, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFondo.setIcon(new ImageIcon(frmUsuario.class.getResource("/Image/piepagina.jpg")));
		lblFondo.setBounds(0, 0, 272, 401);
		getContentPane().add(lblFondo);	
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(305, 65, 115, 26);
		getContentPane().add(comboBox_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

