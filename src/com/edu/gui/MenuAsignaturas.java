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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.edu.componentes.JcomboBoxCarrera;
import com.edu.componentes.JcomboBoxDocente;
import com.edu.componentes.JcomoBoxNivel;
import com.edu.controlador.MySqlAsignaturaDAO;
import com.edu.controlador.MySqlCarreraDAO;
import com.edu.controlador.MySqlCiclosDAO;
import com.edu.controlador.MySqlDocenteDAO;
import com.edu.entidad.Alumno;
import com.edu.entidad.Asignatura;
import com.edu.entidad.Carrera;
import com.edu.entidad.Ciclos;
import com.edu.entidad.Docente;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MenuAsignaturas extends JFrame implements ActionListener, ItemListener, MouseListener {
	
	private MySqlAsignaturaDAO asignaturaDAO = new MySqlAsignaturaDAO();
	private MySqlCarreraDAO carreraDAO = new MySqlCarreraDAO();
	private MySqlCiclosDAO ciclosDAO = new MySqlCiclosDAO(); 
	private MySqlDocenteDAO docenteDAO = new MySqlDocenteDAO();
	
	Docente beanDoc = new Docente();	
	private ArrayList<Carrera> carrera;
	private ArrayList<Ciclos> ciclo;
	private ArrayList<Docente> docente;

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTabbedPane tabbedPane;
	private JPanel panelListAsignaturas;
	private JPanel panelMAsignaturas;
	private JLabel lblNombreDeAsignatura;
	private JTextField txtNomAsignatura;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JPanel panelFondoR;
	private JLabel lblNewLabel_7;
	private JComboBox cboNivel;
	private JComboBox cboCarrera;
	private JLabel lblCodigoDeAsignatura;
	private JTextField txtCodigo;
	private JScrollPane scrollPane;
	private JTable tableAsignatura;
	private JLabel lblNewLabel;
	private JComboBox cboDocente;
	private JTextField txtNombre;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAsignaturas frame = new MenuAsignaturas();
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
	public MenuAsignaturas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 868, 575);
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
		btnNuevo.setIcon(new ImageIcon(MenuAsignaturas.class.getResource("/images_proyect/nuevo.png")));
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
		btnGuardar.setIcon(new ImageIcon(MenuAsignaturas.class.getResource("/images_proyect/guardar.png")));
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
		btnActualizar.setIcon(new ImageIcon(MenuAsignaturas.class.getResource("/images_proyect/actualizar.png")));
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
		btnEliminar.setIcon(new ImageIcon(MenuAsignaturas.class.getResource("/images_proyect/delete2.png")));
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
		
		panelListAsignaturas = new JPanel();
		tabbedPane.addTab("LISTADO DE ASIGNATURAS", null, panelListAsignaturas, null);
		panelListAsignaturas.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelListAsignaturas.add(scrollPane, BorderLayout.CENTER);
		
		tableAsignatura = new JTable();
		tableAsignatura.addMouseListener(this);
		tableAsignatura.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"CODIGO", "NOMBRE DE ASIGNATURA", "CARRERA", "NIVEL", "DOCENTE"
			}
		));
		scrollPane.setViewportView(tableAsignatura);
		
		panelMAsignaturas = new JPanel();
		panelMAsignaturas.setLayout(null);
		tabbedPane.addTab("MANTENIMIENTO DE ASIGNATURAS", null, panelMAsignaturas, null);
		
		lblNombreDeAsignatura = new JLabel("NOMBRE DE ASIGNATURA");
		lblNombreDeAsignatura.setBounds(36, 71, 153, 30);
		panelMAsignaturas.add(lblNombreDeAsignatura);
		
		txtNomAsignatura = new JTextField();
		txtNomAsignatura.setColumns(10);
		txtNomAsignatura.setBounds(199, 70, 283, 30);
		panelMAsignaturas.add(txtNomAsignatura);
		
		lblNewLabel_1 = new JLabel("CARRERA");
		lblNewLabel_1.setBounds(36, 111, 70, 30);
		panelMAsignaturas.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("NIVEL");
		lblNewLabel_4.setBounds(36, 149, 55, 30);
		panelMAsignaturas.add(lblNewLabel_4);
		
		panelFondoR = new JPanel();
		panelFondoR.setLayout(null);
		panelFondoR.setBounds(519, 11, 306, 400);
		panelMAsignaturas.add(panelFondoR);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(MenuAsignaturas.class.getResource("/images_proyect/img_asignaturas.jpeg")));
		lblNewLabel_7.setBounds(0, 0, 306, 400);
		panelFondoR.add(lblNewLabel_7);
		
		cboNivel = new JComboBox();
		cboNivel.setBounds(199, 149, 223, 30);
		panelMAsignaturas.add(cboNivel);
		
		cboCarrera = new JComboBox();
		cboCarrera.setBounds(199, 111, 223, 30);
		panelMAsignaturas.add(cboCarrera);
		
		lblCodigoDeAsignatura = new JLabel("CODIGO DE ASIGNATURA");
		lblCodigoDeAsignatura.setBounds(36, 30, 153, 30);
		panelMAsignaturas.add(lblCodigoDeAsignatura);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(199, 29, 86, 30);
		panelMAsignaturas.add(txtCodigo);
		
		lblNewLabel = new JLabel("DOCENTE");
		lblNewLabel.setBounds(36, 190, 55, 30);
		panelMAsignaturas.add(lblNewLabel);
		
		cboDocente = new JComboBox();
		cboDocente.setModel(new DefaultComboBoxModel(new String[] {"[seleccione docente]"}));
		cboDocente.addItemListener(this);
		cboDocente.setBounds(199, 190, 223, 30);
		panelMAsignaturas.add(cboDocente);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(36, 231, 386, 30);
		panelMAsignaturas.add(txtNombre);
		
		listarCarrera();
		listarNivel();
		listarDocente();
		listadoCarreras();
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
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboDocente) {
			itemStateChangedCboDocente(e);
		}
	}
	
	protected void itemStateChangedCboDocente(ItemEvent e) {
		
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		
		String codigo = String.valueOf(asignaturaDAO.obtenerCodigo());
		txtCodigo.setText(codigo);
		tabbedPane.setSelectedIndex(1);
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		String codigo, nombre;
		int carrera, nivel, dniDoc;
		
		codigo = txtCodigo.getText();
		nombre = txtNomAsignatura.getText();
		carrera = obtenerarrera();
		nivel = obtenerNivel();
		dniDoc = obtenerDocente();

		
		Asignatura bean = new Asignatura();
		
		bean.setCodigo(Integer.parseInt(codigo));
		bean.setNombre(nombre);
		bean.setCodigoCarrera(carrera);
		bean.setCodigoCiclo(nivel);
		bean.setDniDocente(dniDoc);
		
		int salida = asignaturaDAO.registrar(bean);
		
		if(salida > 0) {
			mensaje("ASIGNATURA REGISTRADA");
			cleaner();
			listadoCarreras();
			tabbedPane.setSelectedIndex(0);
		}else {
			mensaje("ERROR AL REGISTRAR ASIGNATURA");
		}
		
		
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		
		String codigo, nombre;
		int carrera, nivel, dniDoc;
		
		codigo = txtCodigo.getText();
		nombre = txtNomAsignatura.getText();
		carrera = obtenerarrera();
		nivel = obtenerNivel();
		dniDoc = obtenerDocente();
		
		Asignatura bean = new Asignatura();		
		bean.setNombre(nombre);
		bean.setCodigoCarrera(carrera);
		bean.setCodigoCiclo(nivel);
		bean.setDniDocente(dniDoc);
		bean.setCodigo(Integer.parseInt(codigo));
		
		int salida = asignaturaDAO.actualizar(bean);
		
		if(salida > 0) {
			mensaje("ASIGNATURA REGISTRADA");
			listadoCarreras();
			tabbedPane.setSelectedIndex(0);
			cleaner();
		}else {
			mensaje("ERROR AL REGISTRAR ASIGNATURA");
		}
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	
		int codigo, boton;

		codigo = Integer.parseInt(txtCodigo.getText());

		boton = JOptionPane.showConfirmDialog(this, "Sistema", "¿Seguro de eliminar?", JOptionPane.YES_NO_OPTION);

		if (boton == 0) {
			int salida;
			Asignatura bean = new Asignatura();
			bean.setCodigo(codigo);;
			salida = asignaturaDAO.eliminar(codigo);

			if (salida == 1) {
				mensaje("Asignatura Eliminada.....");
				cleaner();
				listadoCarreras();
			} else {
				mensaje("Error al Eliminar Alsignaturas.....");
			}
		}
		
		tabbedPane.setSelectedComponent(panelListAsignaturas);
	
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	
	public int obtenerDocente() {
		int docenteSeleccionado = cboDocente.getSelectedIndex();
		
		if(docenteSeleccionado == 0) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una Docente válido", "Error", JOptionPane.ERROR_MESSAGE);
	        return -1;
		}
		
		docente = docenteDAO.listAll();
		Docente bean = docente.get(docenteSeleccionado  - 1);
		
		return bean.getDni();
	}
	
	public int obtenerarrera() {
		int carreraSeleccionada = cboCarrera.getSelectedIndex();
		
		if(carreraSeleccionada == 0) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una Carrera válida", "Error", JOptionPane.ERROR_MESSAGE);
	        return -1;
		}
		
		carrera = carreraDAO.listAll();
		Carrera bean = carrera.get(carreraSeleccionada -1 );
		return bean.getCodigo();
	}
	
	public int obtenerNivel() {
		int nivelSeleccionado = cboNivel.getSelectedIndex();
		
		if(nivelSeleccionado == 0) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un Ciclo válido", "Error", JOptionPane.ERROR_MESSAGE);
	        return -1;
		}
		
		ciclo = ciclosDAO.ListAll();
		Ciclos bean = ciclo.get(nivelSeleccionado - 1);
		return bean.getCodigo();
	}
	
	void listarCarrera() {
		carrera = carreraDAO.listAll();
		cboCarrera.removeAllItems();
		cboCarrera.addItem("[seleccione carrera]");
		for (Carrera bean : carrera) {
			cboCarrera.addItem(bean.getNombre());
		}
	}
	
	void listarNivel() {
		ciclo = ciclosDAO.ListAll();
		
		cboNivel.removeAllItems();
		cboNivel.addItem("[seleccione ciclo]");
		
		for (Ciclos bean : ciclo) {
			cboNivel.addItem(bean.getNro_ciclo());
		}
	}
	
	void listarDocente() {
		docente = docenteDAO.listAll();
		
		cboDocente.removeAllItems();
		cboDocente.addItem("[seleccione docente]");
		
		for (Docente bean : docente) {
			cboDocente.addItem(bean.getNombre());
		}	
	}
		
	void listadoCarreras() {
		ArrayList<Asignatura> datos = asignaturaDAO.listAll();
		DefaultTableModel modeloAsignatura = (DefaultTableModel) tableAsignatura.getModel();
	
		modeloAsignatura.setRowCount(0);
		
		for (Asignatura bean : datos) {
			Object row[] = {bean.getCodigo(), bean.getNombre(), bean.getNombreCarrera(), bean.getNombreCiclo(),
					bean.getNombreDocente()};
			modeloAsignatura.addRow(row);
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
		txtCodigo.setText("");
		txtNomAsignatura.setText("");
		cboCarrera.setSelectedIndex(0);
		cboNivel.setSelectedIndex(0);
		cboDocente.setSelectedIndex(0);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableAsignatura) {
			mouseClickedTableAsignatura(e);
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
	protected void mouseClickedTableAsignatura(MouseEvent e) {
		
		String codigo, nombre, carrera, nivel, docente;
		int pos;
		
		pos = tableAsignatura.getSelectedRow();
		
		codigo = tableAsignatura.getValueAt(pos, 0).toString();
		nombre = tableAsignatura.getValueAt(pos, 1).toString(); 
		carrera = tableAsignatura.getValueAt(pos, 2).toString();
		nivel = tableAsignatura.getValueAt(pos, 3).toString();
		docente = tableAsignatura.getValueAt(pos, 4).toString();
		
		txtCodigo.setText(codigo);
		txtNomAsignatura.setText(nombre);
		cboCarrera.setSelectedItem(carrera);
		cboNivel.setSelectedItem(nivel);
		cboDocente.setSelectedItem(docente);
		
		tabbedPane.setSelectedComponent(panelMAsignaturas);
	}
}
