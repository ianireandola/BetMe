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
		getContentPane().setBackground(new Color(46, 139, 87));
		setBounds(100, 100, 764, 431);
		setResizable(true);		
		getContentPane().setLayout(null);
		
		List list = new List();
		list.setBounds(236, 144, 272, 177);
		getContentPane().add(list);
		this.setLocationRelativeTo(null); 
		
		Label label = new Label("");
		label.setFont(null);		
		label.setBackground(new Color(46, 139, 87));
		label.setBounds(236, 111, 82, 27);		
		getContentPane().add(label);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setIcon(new ImageIcon(frmUsuario.class.getResource("/Image/132.jpg")));
		lblFondo.setBounds(0, 0, 193, 383);
		getContentPane().add(lblFondo);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setEnabled(false);
		txtCantidad.setText("\u20AC");
		txtCantidad.setToolTipText("\u20AC");
		txtCantidad.setBounds(564, 69, 61, 26);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblCantidad = new JLabel("SALDO ACTUAL");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(564, 36, 140, 20);
		getContentPane().add(lblCantidad);
		
		JLabel lblCantidadAApostar = new JLabel("EQUIPO");
		lblCantidadAApostar.setForeground(Color.WHITE);
		lblCantidadAApostar.setBounds(564, 111, 82, 20);
		getContentPane().add(lblCantidadAApostar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(564, 147, 105, 26);
		getContentPane().add(comboBox);
		
		JLabel lblCantidad_1 = new JLabel("CANTIDAD");
		lblCantidad_1.setForeground(Color.WHITE);
		lblCantidad_1.setBounds(564, 176, 105, 20);
		getContentPane().add(lblCantidad_1);
		
		textField = new JTextField();
		textField.setBounds(564, 212, 50, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnapostar = new JButton("\u00A1APOSTAR!");
		btnapostar.setBounds(564, 287, 172, 29);
		getContentPane().add(btnapostar);
		
		JLabel lblNewLabel = new JLabel("DEPORTES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(236, 36, 115, 20);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(236, 69, 115, 26);
		getContentPane().add(comboBox_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

