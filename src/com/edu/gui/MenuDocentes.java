package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.edu.componentes.JcomboBoxGenero;
import com.edu.controlador.MySqlDocenteDAO;
import com.edu.entidad.Alumno;
import com.edu.entidad.Docente;
import com.edu.entidad.Genero;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MenuDocentes extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTabbedPane tabbedPane;
	private JPanel panelListDocentes;
	private JPanel panelMDocentes;
	private JLabel lblNewLabel;
	private JTextField txtDni;
	private JLabel lblNewLabel_1;
	private JTextField txtApellido;
	private JLabel lblNewLabel_2;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField txtCorreo;
	private JLabel lblNewLabel_6;
	private JTextField txtTelefono;
	private JPanel panelFondoR;
	private JLabel lblNewLabel_7;
	private JComboBox cboGenero;
	private JScrollPane scrollPane;
	private JTable tableDocentes;
	
	private MySqlDocenteDAO docenteDAO = new MySqlDocenteDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuDocentes frame = new MenuDocentes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuDocentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(10, 75));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(MenuDocentes.class.getResource("/images_proyect/nuevo.png")));
		btnNuevo.setIconTextGap(35);
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNuevo.setBorder(new EmptyBorder(0, 20, 0, 0));
		btnNuevo.setBackground(Color.BLACK);
		btnNuevo.setBounds(10, 11, 195, 57);
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(MenuDocentes.class.getResource("/images_proyect/guardar.png")));
		btnGuardar.setIconTextGap(30);
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnGuardar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(225, 11, 195, 57);
		panel.add(btnGuardar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(MenuDocentes.class.getResource("/images_proyect/actualizar.png")));
		btnActualizar.setIconTextGap(25);
		btnActualizar.setHorizontalAlignment(SwingConstants.LEFT);
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnActualizar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setBounds(430, 11, 195, 57);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(MenuDocentes.class.getResource("/images_proyect/delete2.png")));
		btnEliminar.setIconTextGap(30);
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnEliminar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(635, 11, 195, 57);
		panel.add(btnEliminar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panelListDocentes = new JPanel();
		tabbedPane.addTab("LISTA DE DOCENTES REGISTRADOS", null, panelListDocentes, null);
		panelListDocentes.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 835, 400);
		panelListDocentes.add(scrollPane);
		
		tableDocentes = new JTable();
		tableDocentes.addMouseListener(this);
		tableDocentes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"DNI", "NOMBRES", "APELLIDOS", "EDAD", "GENERO", "TELEFONO", "CORREO"
			}
		));
		scrollPane.setViewportView(tableDocentes);
		
		panelMDocentes = new JPanel();
		panelMDocentes.setLayout(null);
		tabbedPane.addTab("MANTENIMIENTO DOCENTE", null, panelMDocentes, null);
		
		lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(35, 26, 46, 30);
		panelMDocentes.add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(100, 23, 164, 30);
		panelMDocentes.add(txtDni);
		
		lblNewLabel_1 = new JLabel("APELLIDO");
		lblNewLabel_1.setBounds(35, 63, 70, 30);
		panelMDocentes.add(lblNewLabel_1);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(100, 60, 164, 30);
		panelMDocentes.add(txtApellido);
		
		lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(280, 26, 59, 30);
		panelMDocentes.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(350, 23, 164, 30);
		panelMDocentes.add(txtNombre);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(350, 60, 164, 30);
		panelMDocentes.add(txtEdad);
		
		lblNewLabel_3 = new JLabel("EDAD");
		lblNewLabel_3.setBounds(280, 63, 70, 30);
		panelMDocentes.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("GENERO");
		lblNewLabel_4.setBounds(35, 96, 55, 30);
		panelMDocentes.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("CORREO");
		lblNewLabel_5.setBounds(35, 133, 55, 30);
		panelMDocentes.add(lblNewLabel_5);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 130, 164, 30);
		panelMDocentes.add(txtCorreo);
		
		lblNewLabel_6 = new JLabel("TELEFONO");
		lblNewLabel_6.setBounds(280, 96, 70, 30);
		panelMDocentes.add(lblNewLabel_6);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(350, 93, 164, 30);
		panelMDocentes.add(txtTelefono);
		
		panelFondoR = new JPanel();
		panelFondoR.setLayout(null);
		panelFondoR.setBounds(519, 11, 306, 400);
		panelMDocentes.add(panelFondoR);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(MenuDocentes.class.getResource("/images_proyect/img_docentes.jpg")));
		lblNewLabel_7.setBounds(0, 0, 306, 400);
		panelFondoR.add(lblNewLabel_7);
		
		cboGenero = new JComboBox();
		cboGenero.setBounds(100, 93, 164, 30);
		panelMDocentes.add(cboGenero);
		
		cargarDatos();
		listado();
		acciones();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		tabbedPane.setSelectedComponent(panelMDocentes);
		cleaner();
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {

		String dni, nombre, apellidos, edad, genero, telefono, correo;
		
		dni = txtDni.getText();
		nombre = txtNombre.getText();
		apellidos = txtApellido.getText();
		edad = txtEdad.getText();
		genero = cboGenero.getSelectedItem().toString();
		telefono = txtTelefono.getText();
		correo = txtCorreo.getText();
		
		
		
		if(dni.isEmpty()) {
			mensaje("CAMPO DNI ES OBLIGATORIO!!!");
			txtDni.requestFocus();
			return;
		}
		else if(dni.matches("\\d{8}")==false) {
			mensaje("DNI DEBE CONTENER 8 DÍGITOS NUMÉRICOS!!!");
			txtDni.requestFocus();
			return;
		}else if(nombre.isEmpty()) {
	        mensaje("CAMPO NOMBRE ES OBLIGATORIO!!!");
	        txtNombre.requestFocus();
	        return;
	    }else if (!nombre.matches("[a-zA-Z ]+")) {
	        mensaje("NOMBRE DEBE CONTENER SOLO LETRAS!!!");
	        txtNombre.requestFocus();
	        return;
	    }else if(apellidos.isEmpty()) {
	        mensaje("CAMPO APELLIDO ES OBLIGATORIO!!!");
	        txtApellido.requestFocus();
	        return;
	    }else if (!apellidos.matches("[a-zA-Z ]+")) {
	        mensaje("APELLIDOS DEBE CONTENER SOLO LETRAS!!!");
	        txtApellido.requestFocus();
	        return;
	    }else if(edad.isEmpty()) {
			mensaje("CAMPO EDAD ES OBLIGATORIO!!!");
			txtEdad.requestFocus();
			return;
		}else if(edad.matches("\\d+")==false) {
			mensaje("EDAD DEBE CONTENER DÍGITOS NUMÉRICOS!!!");
			txtEdad.requestFocus();
			return;
		}else if(telefono.isEmpty()) {
			mensaje("CAMPO TELEFONO ES OBLIGATORIO!!!");
			txtTelefono.requestFocus();
			return;
		}
		else if(telefono.matches("\\d{9}")==false) {
			mensaje("TELEFONO DEBE CONTENER 9 DÍGITOS NUMÉRICOS!!!");
			txtTelefono.requestFocus();
			return;
		}else if(correo.isEmpty()) {
			mensaje("CAMPO CORREO ES OBLIGATORIO");
			txtCorreo.requestFocus();
			return;
		}
		
		Docente bean = new Docente();
		
		bean.setDni(Integer.parseInt(dni));
		bean.setNombre(nombre);
		bean.setApellidos(apellidos);
		bean.setEdad(Integer.parseInt(edad));
		bean.setGenero(genero);
		bean.setTelefono(telefono);
		bean.setCorreo(correo);
		
		int salida;
		salida = docenteDAO.registrar(bean);
		
		if(salida > 0) {
			mensaje("Docente Registrado");
			tabbedPane.setSelectedComponent(panelListDocentes);
			cleaner();
			listado();
		}else {
			mensaje("Ocurrio un error al registrar Docente");
		}
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		String dni, nombre, apellidos, edad, genero, telefono, correo;
		
		dni = txtDni.getText();
		nombre = txtNombre.getText();
		apellidos = txtApellido.getText();
		edad = txtEdad.getText();
		genero = cboGenero.getSelectedItem().toString();
		telefono = txtTelefono.getText();
		correo = txtCorreo.getText();
		
		Docente bean = new Docente();
		
		bean.setNombre(nombre);
		bean.setApellidos(apellidos);
		bean.setEdad(Integer.parseInt(edad));
		bean.setGenero(genero);
		bean.setTelefono(telefono);
		bean.setCorreo(correo);
		bean.setDni(Integer.parseInt(dni));
		
		int salida;
		salida = docenteDAO.actualizar(bean);
		
		if(salida > 0) {
			mensaje("Docente Actualizado");
			tabbedPane.setSelectedComponent(panelListDocentes);
			cleaner();
			listado();
		}else {
			mensaje("Ocurrio un error al Actualizar Docente");
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int dni, boton;

		dni = Integer.parseInt(txtDni.getText());

		boton = JOptionPane.showConfirmDialog(this, "Sistema", "¿Seguro de eliminar?", JOptionPane.YES_NO_OPTION);

		if (boton == 0) {
			int salida;
			Docente doc = new Docente();
			doc.setDni(dni);
			salida = docenteDAO.eliminar(dni);

			if (salida > 0) {
				mensaje("Docente Eliminado.....");
				cleaner();
				listado();
			} else {
				mensaje("Error al Eliminar Docente.....");
			}
		}
		
		tabbedPane.setSelectedComponent(panelListDocentes);
	}
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableDocentes) {
			mouseClickedTableDocentes(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTableDocentes(MouseEvent e) {

		String dni, nombre, apellidos, edad, genero, telefono, correo;
		int pos;

		pos = tableDocentes.getSelectedRow();

		dni = tableDocentes.getValueAt(pos, 0).toString();
		nombre = tableDocentes.getValueAt(pos, 1).toString();
		apellidos = tableDocentes.getValueAt(pos, 2).toString();
		edad = tableDocentes.getValueAt(pos, 3).toString();
		genero = tableDocentes.getValueAt(pos, 4).toString();
		telefono = tableDocentes.getValueAt(pos, 5).toString();
		correo = tableDocentes.getValueAt(pos, 6).toString();

		txtDni.setText(dni);
		txtNombre.setText(nombre);
		txtApellido.setText(apellidos);
		txtEdad.setText(edad);
		cboGenero.setSelectedItem(genero);
		txtTelefono.setText(telefono);
		txtCorreo.setText(correo);

		tabbedPane.setSelectedComponent(panelMDocentes);

	}
	
	
	private void cargarDatos() {
		JcomboBoxGenero bean = new JcomboBoxGenero();
		
		ArrayList<Genero> nombreGenero = bean.obtenerNombre();
		
		for (Genero genero : nombreGenero) {
			cboGenero.addItem(genero.getNombre());
		}
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this,m);
	}
	
	void listado() {
		ArrayList<Docente> datos = docenteDAO.listAll();
		DefaultTableModel modeloAlumnos = (DefaultTableModel) tableDocentes.getModel();
	
		modeloAlumnos.setRowCount(0);
		
		for (Docente doc : datos) {
			Object row[] = {doc.getDni(), doc.getNombre(), doc.getApellidos(), 
					doc.getEdad(), doc.getGenero(), doc.getTelefono(), doc.getCorreo()};
			modeloAlumnos.addRow(row);
		}
	}
	
	void acciones() {
	    ChangeListener tabChangeListener = new ChangeListener() {
	        
			@Override
			public void stateChanged(ChangeEvent e) {
				int selectedIndex = tabbedPane.getSelectedIndex();
	            if (selectedIndex == 0) {
	                cleaner();
	            }
			}
	    };

	    tabbedPane.addChangeListener(tabChangeListener);
	}
	
	void cleaner() {
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEdad.setText("");
		cboGenero.setSelectedItem("");
		txtTelefono.setText("");
		txtCorreo.setText("");
	}
}
