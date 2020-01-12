package LP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
import javax.swing.table.DefaultTableModel;

import LD.MySQLAccess;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Clase para la gestion de la vista Usuario
 * @author Martin Router King
 *
 */
public class frmUsuario extends JFrame implements ActionListener 
{	
	private static final long serialVersionUID = 1L;
	
	private JTextField txtCantidad;
	private JTextField textField;
	
	private Label lbl_partido;
	
	private JLabel lblCantidad;
	private JLabel lblCantidadAApostar;
	private JLabel lblCantidad_1;
	private JLabel lblFondo;
	
	private JButton btnapostar;
	private JButton btnSalir;
	
	private JTable table=null;
	
	private DefaultTableModel modelo=null;
	
	private JTextField textFieldEquipo;
	
	private JScrollPane scrollPane;
	
	int id_partido;
	int id_apost;
	
	/**
	 * Constructor de la clase
	 * @param id Recoge el ID del usuario que inicia sesion
	 */
	public frmUsuario(int id) 
	{
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.BLACK);		
		setResizable(true);		
		getContentPane().setLayout(null);
		
		createAndShowGUI(id);
	}
	
	/**
	 * Metodo para cargar la vista de la clase
	 * @param id Recoge el ID del usuario que inicia sesion
	 */
	public void createAndShowGUI(int id)
	{			
		setTitle("BetMe - Apuestas");
		setBounds(100, 100, 941, 458);
		
		getContentPane().createImage(100, 100);
		this.setLocationRelativeTo(null); 
		
		lbl_partido = new Label("PARTIDOS");
		lbl_partido.setForeground(new Color(255, 215, 0));
		lbl_partido.setFont(new Font("Tahoma", Font.BOLD, 16));		
		lbl_partido.setBackground(Color.BLACK);
		lbl_partido.setBounds(287, 0, 152, 27);		
		getContentPane().add(lbl_partido);
		
		txtCantidad = new JTextField();
		txtCantidad.setEditable(false);
		txtCantidad.setEnabled(false);
		txtCantidad.setText("\u20AC");
		txtCantidad.setToolTipText("\u20AC");
		txtCantidad.setBounds(329, 293, 61, 26);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);
		
		lblCantidad = new JLabel("SALDO ACTUAL");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCantidad.setForeground(new Color(255, 215, 0));
		lblCantidad.setBounds(329, 260, 140, 20);
		getContentPane().add(lblCantidad);
		
		lblCantidadAApostar = new JLabel("EQUIPO");
		lblCantidadAApostar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCantidadAApostar.setForeground(new Color(255, 215, 0));
		lblCantidadAApostar.setBounds(493, 257, 82, 20);
		getContentPane().add(lblCantidadAApostar);
		
		lblCantidad_1 = new JLabel("CANTIDAD");
		lblCantidad_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCantidad_1.setForeground(new Color(255, 215, 0));
		lblCantidad_1.setBounds(704, 257, 105, 20);
		getContentPane().add(lblCantidad_1);
		
		textField = new JTextField();
		textField.setBounds(704, 293, 50, 26);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnapostar = new JButton("APOSTAR");
		btnapostar.setBackground(new Color(255, 215, 0));
		btnapostar.setBounds(411, 335, 207, 44);
		getContentPane().add(btnapostar);
		btnapostar.addActionListener(this);
		btnapostar.setActionCommand("APOSTAR");
		
		lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblFondo.setIcon(new ImageIcon(frmUsuario.class.getResource("/Image/piepagina.jpg")));
		lblFondo.setBounds(0, 0, 272, 401);
		getContentPane().add(lblFondo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(287, 32, 620, 199);
		getContentPane().add(scrollPane);
		
		table = new JTable(){
			
		
			
			public boolean isCellEditable(int rowIndex, int colIndex) {
				 
				return false; //Las celdas no son editables.
				 
				}
				};
		table.setBackground(Color.BLACK);
		table.setForeground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(694, 343, 115, 29);
		getContentPane().add(btnSalir);
		btnSalir.setActionCommand("SALIR");
		btnSalir.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
            	String ObjButtons[] = {"Si","Cancelar"};
		        int PromptResult = JOptionPane.showOptionDialog(null,"¿Quieres cerrar sesion?","BetMe - Aviso",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,ObjButtons,ObjButtons[1]);
		        if(PromptResult==JOptionPane.YES_OPTION)
		        {
		        	frmPrincipal frm = new frmPrincipal();
	                frm.setVisible(true);
	                frm.toFront();
	                dispose();
		        }                 
            }
        });
		
		textFieldEquipo = new JTextField();
		textFieldEquipo.setBounds(493, 293, 146, 26);
		getContentPane().add(textFieldEquipo);
		textFieldEquipo.setColumns(10);
		
		
		btnapostar.setEnabled(false);
		llenar();
		cargarSaldo(id);
		id_apost=id;
		
		//Detecta si se elige un fila de la tabla mostrando sus correspondiente valores en los texfields. 
				table.addMouseListener(new MouseAdapter() {
					
					@Override
					public void mouseClicked(java.awt.event.MouseEvent e)
					{
						
					    int row = table.rowAtPoint(e.getPoint());
					// si uno de los campos de la BD esta vacio, dara un error y no mostrará el registro de la siguientes columnas, poner todos los campos a 0 o null por defecto
					    
					    //textFieldID_partido.setText(table.getValueAt(row,0 ).toString());
					  // comboBox.set
					   
					   btnapostar.setEnabled(true);
					   id_partido=(int) (table.getValueAt(row,0 ));
					   
						
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
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
		
		switch(e.getActionCommand()){
		
		case "APOSTAR":
		
		this.apostar(id_partido, id_apost);
		break;
		
		case "SALIR":
		
		this.dispose();
		frmPrincipal admin = new frmPrincipal();
		admin.setVisible(true);
		admin.toFront();
					
		break;
		
		}		

		
	}
	
	/**
	 * Metodo para cargar el saldo del apostante
	 * @param id Recoge el ID del usuario que inicia sesion
	 */
	public void cargarSaldo(int id)
	{
		
		MySQLAccess base=new MySQLAccess();
		int resultado=base.cargarSaldoApostante(id);
	
	
		String cantidad_cuota = resultado+"";
		txtCantidad.setText(cantidad_cuota);
		
			
		
	}
	
	/**
	 * Metodo para realizar una apuesta, donde previamente se validan si todos los campos han sido rellenados, el saldo y la validacion del equipo apostante
	 * @param id_partido Recoge el ID del partido seleccionado
	 * @param id_apost Recoge el ID del apostante
	 */
	private void apostar(int id_partido, int id_apost) {
		// TODO Auto-generated method stub
		
		int apuesta=0;
		int saldo=Integer.parseInt(txtCantidad.getText());
		
		if(textField.getText().isEmpty())
			{
					JOptionPane.showMessageDialog(null, "Rellene todos los campos");
			}
		
		else
		{
			apuesta=Integer.parseInt(textField.getText());
		}
		
		String equipo= textFieldEquipo.getText();
		
	
		
		if(apuesta>saldo)
		{
			JOptionPane.showMessageDialog(null, "No se dispone de saldo sufiente");
			
		}
		
		else if(apuesta==0)
		{
			JOptionPane.showMessageDialog(null, "La cantidad apostada debe ser superior a 0 ");
		}
		
		else if(textFieldEquipo.getText().isEmpty() ) 
		{
			JOptionPane.showMessageDialog(null, "Rellene todos los campos");
		}
		
		else if(apuesta<=saldo )
		{
			MySQLAccess base=new MySQLAccess();		
			
			boolean correcto=base.validarEquipo(id_partido,equipo);
			
			
			
			
			if(correcto==true)
			{
				base.apostar(id_partido,apuesta,equipo,saldo);
				int saldo_actualizado=base.actualizarSaldo(apuesta, id_apost);
				
				cargarSaldo( id_apost);
				limpiar();
				
				JOptionPane.showMessageDialog(null, "Apuesta realizada correctamente, tu saldo actual es: " +saldo_actualizado);
				
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "No existe ningun participante con ese nombre");
			}
			
		}
		
		
		
		
		
	}
	


	/**
	 * Metodo para limpiar los campos
	 */
	private void limpiar() {
		// TODO Auto-generated method stub
		
		
		textField.setText("");
		textFieldEquipo.setText("");
		
	}

	
	/**
	 * Metodo que llama a la base de datos para cargar la tabla con los datos de los partidos
	 */
	void llenar(){
				
				int id_partido=0;
				String deporte=null;
				String equipo_local=null;
				String equipo_visit=null;
				String fecha=null;		
				int cuota=0;
				
				
				String[] columnas = {"PARTIDO","DEPORTE", "LOCAL", "VISITANTE", "CUOTA","FECHA" };
				
				modelo = new DefaultTableModel(null,columnas);		
				table.setModel(modelo);
				
				MySQLAccess base=new MySQLAccess();
				base.cargarPartido(id_partido,deporte,equipo_local,equipo_visit,cuota,fecha, modelo);
				
				modelo.addRow( new Object[] {id_partido,deporte,equipo_local,equipo_visit,cuota, fecha} );
				
				
				
			}
}


