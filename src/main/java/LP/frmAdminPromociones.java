package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class frmAdminPromociones extends JFrame implements ActionListener, MouseListener{
	private JTextField textField;
	public frmAdminPromociones() {
		
		
		getContentPane().setLayout(null);
	    this.setLocationRelativeTo(null);
		setTitle("BetMe - Promociones");	
		setBounds(100, 100, 581, 457);	
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "PROMOCIONES", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(15, 30, 529, 233);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JTextArea txtrLosUsuariosQue = new JTextArea();
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
		
		JButton btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setBounds(64, 188, 146, 29);
		btnActualizar.addActionListener(this);
		btnActualizar.setActionCommand("ACTUALIZAR");
		panel.add(btnActualizar);				
		
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(283, 188, 115, 29);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("SALIR");
		panel.add(btnSalir);
		
		JLabel lblEuros = new JLabel("euros");
		lblEuros.setBounds(74, 100, 69, 20);
		panel.add(lblEuros);
		
		llenar();
	}



	private void llenar() {
		// TODO Auto-generated method stub
		
		MySQLAccess base=new MySQLAccess();
		
		String cantidad=base.cargarPromocion();
		textField.setText(cantidad);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
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

	private void actualizar() {
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
