package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.edu.componentes.JcomboBoxGenero;
import com.edu.controlador.MySqlAlumnoDAO;
import com.edu.entidad.Alumno;
import com.edu.entidad.Docente;
import com.edu.entidad.Genero;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MenuAlumnos extends JFrame implements ActionListener, MouseListener {

	MySqlAlumnoDAO alumnoDAO = new MySqlAlumnoDAO();

	private JPanel contentPane;
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JPanel panelListEstudiantes;
	private JPanel panelMEstudiantes;
	private JScrollPane scrollPane;
	private JTable tableAlumnos;
	private DefaultTableModel modelo;
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
	private JComboBox cboGenero;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAlumnos frame = new MenuAlumnos();
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
	public MenuAlumnos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 866, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 75));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(null);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setIcon(new ImageIcon(MenuAlumnos.class.getResource("/images_proyect/nuevo.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.setIconTextGap(35);
		btnNuevo.setBackground(new Color(0, 0, 0));
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNuevo.setBorder(new EmptyBorder(0, 20, 0, 0));
		btnNuevo.setBounds(10, 11, 195, 57);
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setIcon(new ImageIcon(MenuAlumnos.class.getResource("/images_proyect/guardar.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setIconTextGap(30);
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnGuardar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnGuardar.setBounds(225, 11, 195, 57);
		panel.add(btnGuardar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setIcon(new ImageIcon(MenuAlumnos.class.getResource("/images_proyect/actualizar.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setIconTextGap(25);
		btnActualizar.setHorizontalAlignment(SwingConstants.LEFT);
		btnActualizar.setBackground(new Color(0, 0, 0));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnActualizar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnActualizar.setBounds(430, 11, 195, 57);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(MenuAlumnos.class.getResource("/images_proyect/delete2.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setIconTextGap(30);
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setBackground(new Color(0, 0, 0));
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnEliminar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnEliminar.setBounds(635, 11, 195, 57);
		panel.add(btnEliminar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panelListEstudiantes = new JPanel();
		tabbedPane.addTab("LISTAR ALUMNOS REGISTRADOS", null, panelListEstudiantes, null);
		panelListEstudiantes.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelListEstudiantes.add(scrollPane, BorderLayout.CENTER);
		
		tableAlumnos = new JTable();
		tableAlumnos.addMouseListener(this);
		tableAlumnos.setToolTipText("");
		tableAlumnos.setFocusable(false);
		tableAlumnos.setFillsViewportHeight(true);
		tableAlumnos.setFont(new Font("Roboto", Font.PLAIN, 12));
		tableAlumnos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"DNI", "NOMBRES", "APELLIDOS", "EDAD", "GENERO", "TELEFONO", "CORREO"
			}
		));
		tableAlumnos.getColumnModel().getColumn(0).setPreferredWidth(20);
		tableAlumnos.getColumnModel().getColumn(1).setPreferredWidth(75);
		tableAlumnos.getColumnModel().getColumn(2).setPreferredWidth(75);
		tableAlumnos.getColumnModel().getColumn(3).setPreferredWidth(25);
		tableAlumnos.getColumnModel().getColumn(4).setPreferredWidth(20);
		tableAlumnos.getColumnModel().getColumn(5).setPreferredWidth(25);
		tableAlumnos.getColumnModel().getColumn(6).setPreferredWidth(75);
		scrollPane.setViewportView(tableAlumnos);
		
		panelMEstudiantes = new JPanel();
		tabbedPane.addTab("MATENIMIENTO ALUMNOS", null, panelMEstudiantes, null);
		panelMEstudiantes.setLayout(null);
		
		lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(35, 26, 46, 30);
		panelMEstudiantes.add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setBounds(100, 23, 164, 30);
		panelMEstudiantes.add(txtDni);
		txtDni.setColumns(10);
		
		lblNewLabel_1 = new JLabel("APELLIDO");
		lblNewLabel_1.setBounds(35, 63, 70, 30);
		panelMEstudiantes.add(lblNewLabel_1);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(100, 60, 164, 30);
		panelMEstudiantes.add(txtApellido);
		
		lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(280, 26, 59, 30);
		panelMEstudiantes.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(350, 23, 164, 30);
		panelMEstudiantes.add(txtNombre);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(350, 60, 164, 30);
		panelMEstudiantes.add(txtEdad);
		
		lblNewLabel_3 = new JLabel("EDAD");
		lblNewLabel_3.setBounds(280, 63, 70, 30);
		panelMEstudiantes.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("GENERO");
		lblNewLabel_4.setBounds(35, 96, 55, 30);
		panelMEstudiantes.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("CORREO");
		lblNewLabel_5.setBounds(35, 133, 55, 30);
		panelMEstudiantes.add(lblNewLabel_5);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 130, 164, 30);
		panelMEstudiantes.add(txtCorreo);
		
		lblNewLabel_6 = new JLabel("TELEFONO");
		lblNewLabel_6.setBounds(280, 96, 70, 30);
		panelMEstudiantes.add(lblNewLabel_6);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(350, 93, 164, 30);
		panelMEstudiantes.add(txtTelefono);
		
		panelFondoR = new JPanel();
		panelFondoR.setBounds(519, 11, 306, 400);
		panelMEstudiantes.add(panelFondoR);
		panelFondoR.setLayout(null);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(MenuAlumnos.class.getResource("/images_proyect/FondoMEstudiantes.jpg")));
		lblNewLabel_7.setBounds(0, 0, 306, 400);
		panelFondoR.add(lblNewLabel_7);
		
		cboGenero = new JComboBox();
		cboGenero.setBounds(100, 93, 164, 30);
		panelMEstudiantes.add(cboGenero);
	
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
		tabbedPane.setSelectedComponent(panelMEstudiantes);
		
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
		
		Alumno bean = new Alumno();
		
		bean.setDni(Integer.parseInt(dni));
		bean.setNombre(nombre);
		bean.setApellidos(apellidos);
		bean.setEdad(Integer.parseInt(edad));
		bean.setGenero(genero);
		bean.setTelefono(telefono);
		bean.setCorreo(correo);
		
		int salida;
		salida = alumnoDAO.registrar(bean);
		
		if(salida > 0) {
			mensaje("Alumno Registrado");
			cleaner();
			tabbedPane.setSelectedComponent(panelListEstudiantes);
			listado();
		}else {
			mensaje("Ocurrio un error al registrar Alumno");
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
		
		Alumno bean = new Alumno();
		
		bean.setNombre(nombre);
		bean.setApellidos(apellidos);
		bean.setEdad(Integer.parseInt(edad));
		bean.setGenero(genero);
		bean.setTelefono(telefono);
		bean.setCorreo(correo);
		bean.setDni(Integer.parseInt(dni));
		
		int salida;
		salida = alumnoDAO.actualizar(bean);
		
		if(salida > 0) {
			mensaje("Estudiante Actualizado");
			tabbedPane.setSelectedComponent(panelListEstudiantes);
			cleaner();
			listado();
		}else {
			mensaje("Ocurrio un error al Actualizar Estudiante");
		}

	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		
		int dni, boton;

		dni = Integer.parseInt(txtDni.getText());

		boton = JOptionPane.showConfirmDialog(this, "Sistema", "¿Seguro de eliminar?", JOptionPane.YES_NO_OPTION);

		if (boton == 0) {
			int salida;
			Alumno alu = new Alumno();
			alu.setDni(dni);
			salida = alumnoDAO.eliminar(dni);

			if (salida == 1) {
				mensaje("Alumno Eliminado.....");
				cleaner();
				listado();
			} else {
				mensaje("Error al Eliminar Alumno.....");
			}
		}
		
		tabbedPane.setSelectedComponent(panelListEstudiantes);
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
		ArrayList<Alumno> datos = alumnoDAO.listAll();
		DefaultTableModel modeloAlumnos = (DefaultTableModel) tableAlumnos.getModel();
	
		modeloAlumnos.setRowCount(0);
		
		for (Alumno alumno : datos) {
			Object row[] = {alumno.getDni(), alumno.getNombre(), alumno.getApellidos(), 
					alumno.getEdad(), alumno.getGenero(), alumno.getTelefono(), alumno.getCorreo()};
			modeloAlumnos.addRow(row);
		}
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableAlumnos) {
			mouseClickedTableAlumnos(e);
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
	protected void mouseClickedTableAlumnos(MouseEvent e) {
		
	String dni, nombre, apellidos, edad, genero, telefono, correo;
		int pos;
		
		pos = tableAlumnos.getSelectedRow();
		
		dni = tableAlumnos.getValueAt(pos, 0).toString();
		nombre = tableAlumnos.getValueAt(pos, 1).toString();
		apellidos = tableAlumnos.getValueAt(pos, 2).toString();
		edad = tableAlumnos.getValueAt(pos, 3).toString();
		genero = tableAlumnos.getValueAt(pos, 4).toString();
		telefono = tableAlumnos.getValueAt(pos, 5).toString();
		correo = tableAlumnos.getValueAt(pos, 6).toString();
		
		
		txtDni.setText(dni);
		txtNombre.setText(nombre);
		txtApellido.setText(apellidos);
		txtEdad.setText(edad);
		cboGenero.setSelectedItem(genero);
		txtTelefono.setText(telefono);
		txtCorreo.setText(correo);
		
		tabbedPane.setSelectedComponent(panelMEstudiantes);
		
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
