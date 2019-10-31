package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.Label;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class frmUsuario extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtCantidad;
	private JTextField textField;
	
	private List list;
	
	private Label label;
	
	private JLabel lblFondo;
	private JLabel lblCantidad;
	private JLabel lblCantidadAApostar;
	private JLabel lblCantidad_1;
	private JLabel lblNewLabel;
	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	
	private JButton btnapostar;
	
	public frmUsuario() 
	{
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(46, 139, 87));
		setResizable(true);	
		createAndShowGUI();
		this.setLocationRelativeTo(null);
	}
	
	public void createAndShowGUI()
	{		
		getContentPane().setLayout(null);
		
		setTitle("BetMe - Modo Usuario");	
		this.setIconImage(new ImageIcon(getClass().getResource("/Image/betme.jpg")).getImage());
		setBounds(450, 200, 823, 508);		
		
		list = new List();
		list.setBounds(236, 144, 272, 177);
		getContentPane().add(list);
		this.setLocationRelativeTo(null); 
		
		label = new Label("");
		label.setFont(null);		
		label.setBackground(new Color(46, 139, 87));
		label.setBounds(236, 111, 82, 27);		
		getContentPane().add(label);
		
		lblFondo = new JLabel("");
		lblFondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFondo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFondo.setIcon(new ImageIcon(frmUsuario.class.getResource("/Image/132.jpg")));
		lblFondo.setBounds(0, 0, 230, 469);
		getContentPane().add(lblFondo);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setEnabled(false);
		txtCantidad.setText("\u20AC");
		txtCantidad.setToolTipText("\u20AC");
		txtCantidad.setBounds(564, 69, 61, 26);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblCantidad = new JLabel("SALDO ACTUAL");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setBounds(564, 36, 140, 20);
		getContentPane().add(lblCantidad);
		
		lblCantidadAApostar = new JLabel("EQUIPO");
		lblCantidadAApostar.setForeground(Color.WHITE);
		lblCantidadAApostar.setBounds(564, 111, 82, 20);
		getContentPane().add(lblCantidadAApostar);
		
		comboBox = new JComboBox();
		comboBox.setBounds(564, 147, 105, 26);
		getContentPane().add(comboBox);
		
		lblCantidad_1 = new JLabel("CANTIDAD");
		lblCantidad_1.setForeground(Color.WHITE);
		lblCantidad_1.setBounds(564, 176, 105, 20);
		getContentPane().add(lblCantidad_1);
		
		textField = new JTextField();
		textField.setBounds(564, 212, 50, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnapostar = new JButton("\u00A1APOSTAR!");
		btnapostar.setBounds(564, 287, 172, 29);
		getContentPane().add(btnapostar);
		
		lblNewLabel = new JLabel("DEPORTES");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(236, 36, 115, 20);
		getContentPane().add(lblNewLabel);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(236, 69, 115, 26);
		getContentPane().add(comboBox_1);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

