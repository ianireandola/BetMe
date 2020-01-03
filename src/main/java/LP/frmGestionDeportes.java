package LP;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import LD.MySQLAccess;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

/**
 * Clase para la gestion de deportes
 * @author Martin Router King
 *
 */
public class frmGestionDeportes  extends JFrame implements ActionListener, MouseListener
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo=null;
	
	private JButton btnNuevo=null;
	private JButton btnGuardar=null;
	private JButton btnModificar=null;
	private JButton btnEliminar=null;
	
	private JTextField textFieldID_partido;
	private JTextField textField_nombre;
	
	private JTable table_1;
	
	private JTextArea textArea;
	
	/**
	 * Constructor de la clase
	 */
	public frmGestionDeportes()
	{				
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setResizable(false);
		createAndShowGUI();
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Metodo para cargar la vista de la clase
	 */
	public void createAndShowGUI()
	{
		setTitle("Gestion de deportes");
		getContentPane().setLayout(null);
		setBounds(300, 100, 1070, 608);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		textFieldID_partido = new JTextField();
		textFieldID_partido.setBounds(33, 59, 97, 26);
		getContentPane().add(textFieldID_partido);
		textFieldID_partido.setColumns(10);
		
		JLabel lblIdDeporte = new JLabel("ID deporte");
		lblIdDeporte.setBounds(33, 16, 146, 31);
		getContentPane().add(lblIdDeporte);
		
		JLabel lblNombre = new JLabel("Nombre ");
		lblNombre.setBounds(33, 122, 69, 20);
		getContentPane().add(lblNombre);
		
		textField_nombre = new JTextField();
		textField_nombre.setBounds(33, 167, 254, 26);
		getContentPane().add(textField_nombre);
		textField_nombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(33, 248, 119, 20);
		getContentPane().add(lblDescripcion);
		
		table_1 = new JTable()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int colIndex) {
			 
			return false; }//Las celdas no son editables.
			 
			};
		
		table_1.setBounds(495, 102, 538, 211);
		getContentPane().add(table_1);
		
		JLabel lblListadoDeportes = new JLabel("Listado deportes");
		lblListadoDeportes.setBounds(495, 54, 146, 20);
		getContentPane().add(lblListadoDeportes);
		
		JPanel panel = new JPanel();
		panel.setBounds(495, 102, 412, 211);
		getContentPane().add(panel);
		
		JScrollBar scrollBar = new JScrollBar();
		panel.add(scrollBar);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		panel.add(scrollBar_1);
		
		textArea = new JTextArea();
		textArea.setBounds(33, 284, 393, 142);
		getContentPane().add(textArea);
		
				
		desabilitar();
		llenar();
		
		table_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e)
			{
				habilitar();
				textFieldID_partido.setEnabled(false);
				limpiar();
			    
			    int row = table_1.rowAtPoint(e.getPoint());
			// si uno de los campos de la BD esta vacio, dara un error y no mostrará el registro de la siguientes columnas, poner todos los campos a 0 o null por defecto
			    
			    textFieldID_partido.setText(table_1.getValueAt(row,0 ).toString());
			    textField_nombre.setText(table_1.getValueAt(row, 1).toString());
			    textArea.setText(table_1.getValueAt(row, 2).toString());
			
			    btnEliminar.setEnabled(true);
				btnModificar.setEnabled(true);
				btnGuardar.setEnabled(false);
				
			}
			
		});
		
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

	/**
	 * Metodo que responde a las acciones en la vista
	 */
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


	/**
	 * Metodo que llama a la base de datos para cargar la tabla con los datos de los jugadores
	 */
	void llenar()
	{
		int id_deporte=0;
		String nombre=null;
		String descripcion=null;
		
		String[] columnas = {"ID_DEPORTE", "NOMBRE", "DESCRIPCION" };
		
		modelo = new DefaultTableModel(null,columnas);
		table_1.setModel(modelo);
		
		MySQLAccess base=new MySQLAccess();
		base.cargarDeporte(id_deporte,nombre,descripcion, modelo);
		
		modelo.addRow( new Object[] {id_deporte,nombre,descripcion} );
		
	}
	
	
	/**
	 * Metodo para guardar un nuevo deporte
	 * @param fila Recoge la fila seleccionada
	 * @param columna Recoge la columna seleccionada
	 */
	public void guardar()
	{
			
		int fila=table_1.getSelectedRow();
		int columna=table_1.getSelectedColumn();
		
		MySQLAccess base=new MySQLAccess();
		
		if(textField_nombre.getText().toString().isEmpty() || textArea.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "¡Rellene todos los campos");
		}
		
		else
		{
			int id=0;
			String nombre = textField_nombre.getText();
			String descripcion=textArea.getText();	
				
			base.anadirDeporte(id,nombre,descripcion, table_1, fila, columna);
			
			JOptionPane.showMessageDialog(null, "¡Deporte añadido correctamente!");
			
			llenar();
			limpiar();
			btnGuardar.setEnabled(false);
		}
		
		
		
	}
	
	
	/**
	 * Metodo que elimina el deporte seleccionado de la tabla
	 */
	public void eliminar()
	{
		int fila=table_1.getSelectedRow();
		
		
		MySQLAccess base=new MySQLAccess();
		base.eliminarDeporte(table_1, fila,0,6);		
	   
	        llenar();
	        JOptionPane.showMessageDialog(null, "Deporte eliminado");
	        limpiar();
	   
	}
	
	
	/**
	 * Metodo que modifica y guarda el jugador seleccionado con los nuevos valores
	 */
	public void modificar()
	{
		
		int fila=table_1.getSelectedRow();
		int columna=table_1.getSelectedColumn();
		
		int id_partido=Integer.parseInt(textFieldID_partido.getText());	
		String nombre=textField_nombre.getText();
		String descripcion=textArea.getText();
		
		
		MySQLAccess base=new MySQLAccess();
		base.modificarDeporte(id_partido, nombre, descripcion, table_1, fila,columna);
		
	   
	        llenar();
	        JOptionPane.showMessageDialog(null, "Deporte modificado");
	        limpiar();
		
		
	}
	
	/**
	 * Metodo que deshabilita los elementos de la vista
	 */
	public void desabilitar()
	{
		btnEliminar.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnModificar.setEnabled(false);
		textFieldID_partido.setEnabled(false);
		textField_nombre.setEnabled(false);
		textArea.setEnabled(false);
		
		
	}
	
	/**
	 * Metodo que habilita los elementos de la vista
	 */
	public void habilitar()
	{
		textFieldID_partido.setEnabled(false);
		textField_nombre.setEnabled(true);
		textField_nombre.requestFocus();
		textArea.setEnabled(true);
		
	}
	
	/**
	 * Metodo que limpia los campos
	 */
	public void limpiar()
	{
		textFieldID_partido.setText("");
		textField_nombre.setText("");
		textArea.setText("");
			
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


	
	
	


