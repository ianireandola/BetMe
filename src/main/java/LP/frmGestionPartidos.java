package LP;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.events.MouseEvent;


import LD.MySQLAccess;


public class frmGestionPartidos extends JFrame implements ActionListener, MouseListener{
	
	private JTextField textFieldLocal;
	private JTextField textFieldVisitante;
	private JTextField textFieldFecha;
	private JTextField textFieldCuota;
	private JTable table=null;
	private DefaultTableModel modelo=null;
	
	private JButton btnNuevo=null;
	private JButton btnGuardar=null;
	private JButton btnModificar=null;
	private JButton btnEliminar=null;
	private JTextField textFieldID_partido;
	private JTextField textFieldDeporte;
	

	public frmGestionPartidos()
	{		
		getContentPane().setLayout(null);

		
		JLabel lblParticipante1 = new JLabel("Participante local");
		lblParticipante1.setBounds(434, 30, 149, 16);
		getContentPane().add(lblParticipante1);
		
		textFieldLocal = new JTextField();
		textFieldLocal.setBounds(434, 59, 161, 22);
		getContentPane().add(textFieldLocal);
		textFieldLocal.setColumns(10);
		
		JLabel lblParticipante2 = new JLabel("Participante visitante");
		lblParticipante2.setBounds(669, 30, 187, 16);
		getContentPane().add(lblParticipante2);
		
		textFieldVisitante = new JTextField();
		textFieldVisitante.setBounds(669, 59, 187, 22);
		getContentPane().add(textFieldVisitante);
		textFieldVisitante.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(194, 111, 95, 16);
		getContentPane().add(lblFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(194, 140, 116, 22);
		getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblCuota = new JLabel("Cuota");
		lblCuota.setBounds(30, 111, 56, 16);
		getContentPane().add(lblCuota);
		
		textFieldCuota = new JTextField();
		textFieldCuota.setBounds(30, 140, 116, 22);
		getContentPane().add(textFieldCuota);
		textFieldCuota.setColumns(10);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setBounds(50, 474, 102, 25);
		btnNuevo.addActionListener(this);
		btnNuevo.setActionCommand("NUEVO");
		getContentPane().add(btnNuevo);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(213, 474, 97, 25);
		btnGuardar.addActionListener(this);
		btnGuardar.setActionCommand("GUARDAR");
		getContentPane().add(btnGuardar);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(365, 474, 115, 25);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("MODIFICAR");
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(527, 474, 97, 25);
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("ELIMINAR");
		getContentPane().add(btnEliminar);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(673, 474, 97, 25);
		btnSalir.addActionListener(this);
		btnSalir.setActionCommand("SALIR");
		getContentPane().add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "PARTIDOS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(24, 217, 857, 233);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 18, 845, 199);
		panel.add(scrollPane);
		
		table = new JTable(){
			
			public boolean isCellEditable(int rowIndex, int colIndex) {
				 
				return false; //Las celdas no son editables.
				 
				}
				};
		scrollPane.setViewportView(table);
		
		JLabel lblId_partido = new JLabel("ID Partido");
		lblId_partido.setBounds(30, 30, 102, 20);
		getContentPane().add(lblId_partido);
		
		textFieldID_partido = new JTextField();
		textFieldID_partido.setBounds(33, 59, 146, 26);
		getContentPane().add(textFieldID_partido);
		textFieldID_partido.setColumns(10);
		
		JLabel lblDeporte_1 = new JLabel("Deporte");
		lblDeporte_1.setBounds(220, 28, 102, 20);
		getContentPane().add(lblDeporte_1);
		
		textFieldDeporte = new JTextField();
		textFieldDeporte.setBounds(213, 57, 146, 26);
		getContentPane().add(textFieldDeporte);
		textFieldDeporte.setColumns(10);
		
				
		desabilitar();
		llenar();
		//Detecta si se elige un fila de la tabla mostrando sus correspondiente valores en los texfields. 
		table.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				habilitar();
				textFieldID_partido.setEnabled(false);
				limpiar();
			    
			    int row = table.rowAtPoint(e.getPoint());
			// si uno de los campos de la BD esta vacio, dara un error y no mostrará el registro de la siguientes columnas, poner todos los campos a 0 o null por defecto
			    
			    textFieldID_partido.setText(table.getValueAt(row,0 ).toString());
			    textFieldDeporte.setText(table.getValueAt(row, 1).toString());
			    textFieldLocal.setText(table.getValueAt(row, 2).toString());
			    textFieldVisitante.setText(table.getValueAt(row, 3).toString());			   
			    textFieldCuota.setText(table.getValueAt(row, 4).toString());
			    textFieldFecha.setText(table.getValueAt(row, 5).toString());
			   
			    
			    btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
				btnGuardar.setEnabled(false);
				
			}
			
		});
	
		
		
		setTitle("Gestion de equipo");	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setBounds(300, 100, 917, 600);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		switch(e.getActionCommand()){
			
		case "NUEVO":
			
			btnGuardar.setEnabled(true);
			btnModificar.setEnabled(false);
			btnEliminar.setEnabled(false);
			limpiar();
			habilitar();
			
			break;
			
		case "MODIFICAR":
			
			this.modificar();
			break;
			
		case "GUARDAR":
			
			this.guardar();
			break;
			
		case "ELIMINAR":
			
			this.eliminar();			
			break;
			
		case "SALIR":
			
			this.dispose();

			frmAdmin admin = new frmAdmin();
			admin.setVisible(true);
			admin.toFront();
			break;
		}
	}


	
	//Llama a la base de datos para cargar la tabla con los datos de los jugadores. 
	void llenar()
	{
		int id_partido=0;
		String deporte=null;
		String equipo_local=null;
		String equipo_visit=null;
		String fecha=null;		
		int cuota=0;
		
		
		String[] columnas = {"PARTIDO","DEPORTE", "EQUIPO LOCAL", "EQUIPO VISITANTE", "CUOTA","FECHA" };
		
		modelo = new DefaultTableModel(null,columnas);		
		table.setModel(modelo);
		
		MySQLAccess base=new MySQLAccess();
		base.cargarPartido(id_partido,deporte,equipo_local,equipo_visit,cuota,fecha, modelo);
		
		modelo.addRow( new Object[] {id_partido,deporte,equipo_local,equipo_visit,cuota, fecha} );
		
	}

	
	
	//Metodo que guarda un nuevo partido
	public void guardar()
	{
			
		int fila=table.getSelectedRow();
		int columna=table.getSelectedColumn();
		
		MySQLAccess base=new MySQLAccess();
		
	
		if(textFieldDeporte.getText().toString().isEmpty() || textFieldLocal.getText().isEmpty() ||textFieldVisitante.getText().isEmpty() || textFieldCuota.getText().isEmpty() || textFieldFecha.getText().isEmpty() )
		{
			JOptionPane.showMessageDialog(null, "¡Rellene todos los campos");
		}
		
		else
		{
			int id=0;
			String deporte = textFieldDeporte.getText();
			String local=textFieldLocal.getText();	
			String visitante=textFieldVisitante.getText();
			String fecha=textFieldFecha.getText();			
			int cuota=Integer.parseInt(textFieldCuota.getText().toString());				
			
			
			base.anadirPartido(id,deporte,local,visitante,cuota,fecha, table, fila, columna);
			
			JOptionPane.showMessageDialog(null, "¡Partido añadido correctamente!");
			
			llenar();
			limpiar();
		}
			
		
	}
	
	
	//Metodo que eliminar el partido seleccionado de la tabla
	public void eliminar()
	{
		int fila=table.getSelectedRow();
		
		
		MySQLAccess base=new MySQLAccess();
		base.eliminarPartido(table, fila,0,6);		
	   
	        llenar();
	        JOptionPane.showMessageDialog(null, "Partido eliminado");
	        limpiar();
	   
	}
	
	
	
	//Metodo que modifica y guarda el jugador seleccionado con los nuevos valores
	public void modificar()
	{
		
		int fila=table.getSelectedRow();
		int columna=table.getSelectedColumn();
		
		int id_partido=Integer.parseInt(textFieldID_partido.getText());	
		String deporte=textFieldDeporte.getText();
		String local=textFieldLocal.getText();
		String visitante=textFieldVisitante.getText();		
		int cuota=Integer.parseInt(textFieldCuota.getText());		
		String fecha=textFieldFecha.getText();
		
		MySQLAccess base=new MySQLAccess();
		base.modificarPartido(id_partido, deporte, local, visitante, cuota, fecha, table, fila,columna);
		
	   
	        llenar();
	        JOptionPane.showMessageDialog(null, "Partido modificado");
	        limpiar();
		
		
	}
	
	
	public void desabilitar()
	{
		textFieldDeporte.setEnabled(false);
		textFieldLocal.setEnabled(false);
		textFieldVisitante.setEnabled(false);
		textFieldFecha.setEnabled(false);
		textFieldCuota.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnModificar.setEnabled(false);
		
	}
	
	
	public void habilitar()
	{
		textFieldID_partido.setEnabled(false);
		textFieldDeporte.setEnabled(true);
		textFieldDeporte.requestFocus();
		textFieldLocal.setEnabled(true);
		textFieldVisitante.setEnabled(true);
		textFieldFecha.setEnabled(true);
		textFieldCuota.setEnabled(true);
		
	}
	
	public void limpiar()
	{
		textFieldLocal.setText("");
		textFieldVisitante.setText("");
		textFieldFecha.setText("");
		textFieldCuota.setText("");
		
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

	
	
	
	

