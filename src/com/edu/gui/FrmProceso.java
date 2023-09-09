package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import com.edu.componentes.Item;
import com.edu.componentes.JcomoBoxNivel;
import com.edu.componentes.MatriculaAux;
import com.edu.controlador.MySqlAlumnoDAO;
import com.edu.controlador.MySqlAsignaturaDAO;
import com.edu.controlador.MySqlCarreraDAO;
import com.edu.controlador.MySqlCiclosDAO;
import com.edu.controlador.MySqlMatriculaDAO;
import com.edu.controlador.MySqlPeridoDAO;
import com.edu.entidad.Alumno;
import com.edu.entidad.Asignatura;
import com.edu.entidad.Carrera;
import com.edu.entidad.Ciclos;
import com.edu.entidad.Matricula;
import com.edu.entidad.Periodo;
import com.mysql.cj.x.protobuf.MysqlxExpr.ColumnIdentifier;

import javax.management.modelmbean.ModelMBean;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.SystemColor;

public class FrmProceso extends JFrame implements ActionListener, ItemListener {

	private MySqlMatriculaDAO matriculaDAO = new MySqlMatriculaDAO();
	private MySqlAlumnoDAO alumnoDAO = new MySqlAlumnoDAO();
	private MySqlCarreraDAO carreraDAO = new MySqlCarreraDAO();
	private MySqlAsignaturaDAO asignaturaDAO = new MySqlAsignaturaDAO();
	private MySqlCiclosDAO ciclosDAO = new MySqlCiclosDAO();
	private MySqlPeridoDAO peridoDAO = new MySqlPeridoDAO();

	private ArrayList<Matricula> MatriculasTemporales = new ArrayList<>();	
	private ArrayList<Matricula> matriculas;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Carrera> carreras;
	private ArrayList<Asignatura> asignaturas;
	private ArrayList<Ciclos> ciclos;
	private ArrayList<Periodo> periodos;
	
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox cboEstudiante;
	private JLabel lblNewLabel_1;
	private JComboBox cboCarrera;
	private JLabel lblAsignatura;
	private JComboBox cboAsignatura;
	private JLabel lblCiclo;
	private JComboBox cboCiclo;
	private JComboBox cboPeriodo;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	private JTable tableMatricula;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnAgregar;
	private JButton btnQuitar;
	private DefaultTableModel modelMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmProceso frame = new FrmProceso();
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
	public FrmProceso() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 840, 550);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("ESTUDIANTE");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel.setBounds(44, 40, 113, 14);
		contentPane.add(lblNewLabel);
		
		cboEstudiante = new JComboBox();
		cboEstudiante.setModel(new DefaultComboBoxModel(new String[] {"[seleccione estudiante]"}));
		cboEstudiante.setBounds(141, 37, 205, 22);
		contentPane.add(cboEstudiante);
		
		lblNewLabel_1 = new JLabel("CARRRERA");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(44, 68, 113, 14);
		contentPane.add(lblNewLabel_1);
		
		cboCarrera = new JComboBox();
		cboCarrera.setModel(new DefaultComboBoxModel(new String[] {"[seleccione carrera]"}));
		cboCarrera.setBounds(141, 65, 205, 22);
		contentPane.add(cboCarrera);
		
		lblAsignatura = new JLabel("ASIGNATURA");
		lblAsignatura.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblAsignatura.setBounds(44, 96, 113, 14);
		contentPane.add(lblAsignatura);
		
		cboAsignatura = new JComboBox();
		cboAsignatura.setModel(new DefaultComboBoxModel(new String[] {"[seleccione asignatura]"}));
		cboAsignatura.setBounds(141, 93, 205, 22);
		contentPane.add(cboAsignatura);
		
		lblCiclo = new JLabel("CICLO");
		lblCiclo.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblCiclo.setBounds(372, 40, 113, 14);
		contentPane.add(lblCiclo);
		
		cboCiclo = new JComboBox();
		cboCiclo.addItemListener(this);
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"[seleccione ciclo]"}));
		cboCiclo.setBounds(469, 37, 205, 22);
		contentPane.add(cboCiclo);
		
		cboPeriodo = new JComboBox();
		cboPeriodo.setModel(new DefaultComboBoxModel(new String[] {"[seleccione periodo]"}));
		cboPeriodo.setBounds(469, 65, 205, 22);
		contentPane.add(cboPeriodo);
		
		lblNewLabel_4 = new JLabel("PERIODO");
		lblNewLabel_4.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(372, 68, 113, 14);
		contentPane.add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 804, 265);
		contentPane.add(scrollPane);
		
		tableMatricula = new JTable();
		tableMatricula.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ASIGNATURA", "CICLO"
			}
		));
		tableMatricula.setFillsViewportHeight(true);
		scrollPane.setViewportView(tableMatricula);
		
		btnNuevo = new JButton("NUEVA MATRICULA");
		btnNuevo.setIconTextGap(20);
		btnNuevo.setFocusPainted(false);
		btnNuevo.setFocusable(false);
		btnNuevo.setIcon(new ImageIcon(FrmProceso.class.getResource("/images_proyect/nuevo.png")));
		btnNuevo.setBorder(null);
		btnNuevo.setForeground(SystemColor.textHighlightText);
		btnNuevo.setBackground(SystemColor.activeCaptionText);
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 424, 246, 52);
		contentPane.add(btnNuevo);
		
		btnGuardar = new JButton("REGISTRAR MATRICULA");
		btnGuardar.setIconTextGap(20);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setFocusable(false);
		btnGuardar.setIcon(new ImageIcon(FrmProceso.class.getResource("/images_proyect/guardar.png")));
		btnGuardar.setBorder(null);
		btnGuardar.setForeground(SystemColor.textHighlightText);
		btnGuardar.setBackground(SystemColor.activeCaptionText);
		btnGuardar.addActionListener(this);
		btnGuardar.setBounds(298, 424, 246, 52);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setIconTextGap(20);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setFocusable(false);
		btnCancelar.setIcon(new ImageIcon(FrmProceso.class.getResource("/images_proyect/rejection.png")));
		btnCancelar.setBorder(null);
		btnCancelar.setForeground(SystemColor.textHighlightText);
		btnCancelar.setBackground(SystemColor.activeCaptionText);
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(568, 424, 246, 52);
		contentPane.add(btnCancelar);
		
		btnAgregar = new JButton("");
		btnAgregar.setBackground(SystemColor.menu);
		btnAgregar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregar.setBorder(null);
		btnAgregar.setFocusPainted(false);
		btnAgregar.setFocusable(false);
		btnAgregar.setIcon(new ImageIcon(FrmProceso.class.getResource("/images_proyect/plus.png")));
		btnAgregar.addActionListener(this);
		btnAgregar.setBounds(740, 31, 32, 32);
		contentPane.add(btnAgregar);
		
		btnQuitar = new JButton("");
		btnQuitar.setBackground(SystemColor.menu);
		btnQuitar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitar.setBorder(null);
		btnQuitar.setFocusPainted(false);
		btnQuitar.setFocusable(false);
		btnQuitar.setIcon(new ImageIcon(FrmProceso.class.getResource("/images_proyect/minus.png")));
		btnQuitar.addActionListener(this);
		btnQuitar.setBounds(740, 66, 32, 32);
		contentPane.add(btnQuitar);
		
		llenarComboEstudiante();
		llenarComboCarrera();
		//llenarComboAsignatura();
		llenarComboCiclo();
		llenarComboPeriodo();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
		if (e.getSource() == btnQuitar) {
			actionPerformedBtnQuitar(e);
		}
		if (e.getSource() == btnAgregar) {
			actionPerformedBtnAgregar(e);
		}
	}
	
	
	protected void actionPerformedBtnAgregar(ActionEvent e) {
		int alumno, carrera, asignatura, ciclo, periodo;
		String nombreAsignatura, nombreCliclo;
		
		/*String estudiante, carreraV, asignaturaV, cicloV, periodoV;
		
		estudiante = cboEstudiante.getSelectedItem().toString();
		carreraV = cboCarrera.getSelectedItem().toString();
		asignaturaV = cboAsignatura.getSelectedItem().toString();
		cicloV = cboCiclo.getSelectedItem().toString();
		periodoV = cboPeriodo.getSelectedItem().toString();	
		
		if(estudiante.equals("[seleccione estudiante]")) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un Estudiante válido", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
		}
		
		if(carreraV.equals("[seleccione carrera]")) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una carrera válida", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
		}
		
		if (asignaturaV.equals("[seleccione asignatura]")) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar una asignatura válida", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (cicloV.equals("[seleccione ciclo]")) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un ciclo válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (periodoV.equals("[seleccione periodo]")) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un periodo válido", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(MatriculasTemporales.isEmpty()) {
			mensaje("No hay Matriculas para guardar");
			return;
		}
		*/
			
	    // Obtener los códigos seleccionados
	    alumno = obtenerCodigoEstudiante();
	    carrera = obtenerCodigoCarrera();
	    asignatura = obtenerCodigoAsignatura();
	    ciclo = obtenerCodigoCiclo();
	    periodo = obtenerCodigoPeriodo();
	    
	    /*if(MatriculasTemporales.isEmpty()) {
			mensaje("No hay Matriculas para guardar");
			return;
		}*/
	   
	    nombreAsignatura = asignaturaDAO.obtenerNombre(asignatura);
	    nombreCliclo = ciclosDAO.obtenerNombre(ciclo);
	    
	    Matricula bean = new Matricula(alumno, carrera, asignatura, ciclo, periodo, nombreCliclo, nombreAsignatura, nombreCliclo);   
	    MatriculasTemporales.add(bean);
	    
		
	    
	    DefaultTableModel modeloMatriculas = (DefaultTableModel) tableMatricula.getModel();
	    modeloMatriculas.setRowCount(0);
	    
	    for (Matricula matricula : MatriculasTemporales) {
	    	Object row[] = {matricula.getNombreAsignatura(), matricula.getNombreCiclo()};
			modeloMatriculas.addRow(row);	
		}

	    
	}
	protected void actionPerformedBtnQuitar(ActionEvent e) {
		
		int rowCount = tableMatricula.getRowCount();
		
		if(rowCount > 0) {
			int ultimo = rowCount - 1;
			 MatriculasTemporales.remove(ultimo);
		     DefaultTableModel modeloMatriculas = (DefaultTableModel) tableMatricula.getModel();
		     modeloMatriculas.removeRow(ultimo);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		clear();		
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		for (Matricula bean : MatriculasTemporales) {
			int salida = matriculaDAO.registrar(bean);
			if(salida > 0) {
				mensaje("Matriculas Registradas con exito");
				//clear();
			}else {
				mensaje("Error al registrar Matriculas");
			}
		}
		
		MatriculasTemporales.clear();
		
		
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		cboEstudiante.setSelectedIndex(0);
		cboCiclo.setSelectedIndex(0);
		cboPeriodo.setSelectedIndex(0);
		cboCarrera.setSelectedIndex(0);
		cboAsignatura.setSelectedIndex(0);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCiclo) {
			itemStateChangedCboCiclo(e);
		}
	}
	protected void itemStateChangedCboCiclo(ItemEvent e) {		
		if (e.getStateChange() == ItemEvent.SELECTED) {
			int ciclo = obtenerCodigoCiclo();
			
			asignaturas = asignaturaDAO.habilitarAsignatura(ciclo);
		
			
			if(asignaturas != null) {
				llenarComboAsignatura(ciclo);
			}
		}
		
	}
	
	
	public int obtenerCodigoEstudiante() {
		int estSeleccionado = cboEstudiante.getSelectedIndex();
		
		if(estSeleccionado == 0) {
	        return -1;
		}
		
		alumnos = alumnoDAO.listAll();
		Alumno bean = alumnos.get(estSeleccionado - 1);
		
		return bean.getDni();
	}
	
	public int obtenerCodigoCarrera() {
		int carreraSeleccionado = cboCarrera.getSelectedIndex();
		
		if(carreraSeleccionado == 0) {
	        return -1;
		}
		
		carreras = carreraDAO.listAll();
		Carrera bean = carreras.get(carreraSeleccionado - 1);
		
		return bean.getCodigo();
	}
	
	public int obtenerCodigoAsignatura() {
		Item itemSeleccionado = (Item) cboAsignatura.getSelectedItem();
	    
	    if (itemSeleccionado == null || itemSeleccionado.getCodigo() == -1) {
	        return -1;
	    }
	    
	    return itemSeleccionado.getCodigo();
	}	
	
	public int obtenerCodigoCiclo() {
		int cicloSeleccionado = cboCiclo.getSelectedIndex();
		
		if(cicloSeleccionado == 0) {
	        return -1;
		}
		
		ciclos = ciclosDAO.ListAll();
		Ciclos bean = ciclos.get(cicloSeleccionado - 1);
		
		return bean.getCodigo();
	}
	
	public int obtenerCodigoPeriodo() {
		int periodoSeleccionado = cboPeriodo.getSelectedIndex();
		
		if(periodoSeleccionado == 0) {
	        return -1;
		}
		
		periodos = peridoDAO.listAll();
		Periodo bean = periodos.get(periodoSeleccionado - 1);
		
		return bean.getCodigo();
	}
	
	
	void llenarComboEstudiante() {
		alumnos = alumnoDAO.listAll();
		
		cboEstudiante.removeAllItems();
		cboEstudiante.addItem("[seleccione estudiante]");
		for (Alumno bean : alumnos) {
			cboEstudiante.addItem(bean.getNombre() + " " + bean.getApellidos());
		}
	}

	void llenarComboCarrera() {
		carreras = carreraDAO.listAll();
		
		cboCarrera.removeAllItems();
		cboCarrera.addItem("[seleccione carrera]");
		
		for (Carrera bean : carreras) {
			cboCarrera.addItem(bean.getNombre());
		}
	}

	void llenarComboAsignatura(int cod) {
		asignaturas = asignaturaDAO.habilitarAsignatura(cod);
	    
	    DefaultComboBoxModel<Item> model = new DefaultComboBoxModel<>();
	    model.addElement(new Item("[seleccione asignatura]", -1)); // Opción por defecto
	    
	    for (Asignatura bean : asignaturas) {
	        model.addElement(new Item(bean.getNombre(), bean.getCodigo()));
	    }
	    
	    cboAsignatura.setModel(model);
	}
	
	void llenarComboCiclo() {
		ciclos = ciclosDAO.ListAll();
		
		cboCiclo.removeAllItems();
		cboCiclo.addItem("[seleccione ciclo]");
		
		for (Ciclos bean : ciclos) {
			cboCiclo.addItem(bean.getNro_ciclo());
		}
	}
	
	void llenarComboPeriodo() {
		periodos = peridoDAO.listAll();
			
		cboPeriodo.removeAllItems();
		cboPeriodo.addItem("[seleccione periodo]");
		for (Periodo bean : periodos) {
			cboPeriodo.addItem(bean.getFechaInicio() +" / "+ bean.getFechaFin());
		}
	}
	
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	
	
	void clear() {
		cboEstudiante.setSelectedIndex(0);
		cboCarrera.setSelectedIndex(0);
		cboAsignatura.setSelectedIndex(0);
		cboCiclo.setSelectedIndex(0);
		cboPeriodo.setSelectedIndex(0);
	}
	
	
}


