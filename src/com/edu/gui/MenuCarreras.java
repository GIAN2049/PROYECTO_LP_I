package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.edu.controlador.MySqlCarreraDAO;
import com.edu.entidad.Carrera;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MenuCarreras extends JFrame implements ActionListener, MouseListener {
	
	MySqlCarreraDAO carreraDAO = new MySqlCarreraDAO();

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JPanel panelDatos;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;
	private JScrollPane scrollPane;
	private JTable tableCarrera;
	private JLabel lblNewLabel_2;
	private JTextField txtCarrera;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCarreras frame = new MenuCarreras();
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
	public MenuCarreras() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 865, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(5, 413, 839, 75);
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(10, 75));
		contentPane.add(panel);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setIcon(new ImageIcon(MenuCarreras.class.getResource("/images_proyect/nuevo.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setIconTextGap(35);
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Roboto", Font.BOLD, 14));
		btnNuevo.setBorder(new EmptyBorder(0, 20, 0, 0));
		btnNuevo.setBackground(Color.BLACK);
		btnNuevo.setBounds(10, 11, 195, 57);
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setIcon(new ImageIcon(MenuCarreras.class.getResource("/images_proyect/guardar.png")));
		btnGuardar.addActionListener(this);
		btnGuardar.setEnabled(false);
		btnGuardar.setIconTextGap(30);
		btnGuardar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnGuardar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnGuardar.setBackground(Color.BLACK);
		btnGuardar.setBounds(225, 11, 195, 57);
		panel.add(btnGuardar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setIcon(new ImageIcon(MenuCarreras.class.getResource("/images_proyect/actualizar.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setEnabled(false);
		btnActualizar.setIconTextGap(25);
		btnActualizar.setHorizontalAlignment(SwingConstants.LEFT);
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnActualizar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setBounds(430, 11, 195, 57);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setIcon(new ImageIcon(MenuCarreras.class.getResource("/images_proyect/delete2.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setEnabled(false);
		btnEliminar.setIconTextGap(30);
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setFont(new Font("Roboto", Font.BOLD, 14));
		btnEliminar.setBorder(new EmptyBorder(0, 15, 0, 0));
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setBounds(635, 11, 195, 57);
		panel.add(btnEliminar);
		
		panelDatos = new JPanel();
		panelDatos.setBounds(5, 5, 480, 81);
		panelDatos.setPreferredSize(new Dimension(10, 52));
		contentPane.add(panelDatos);
		panelDatos.setLayout(null);
		
		lblNewLabel_1 = new JLabel("CODIGO CARRERA");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(16, 10, 150, 30);
		panelDatos.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(189, 10, 265, 25);
		panelDatos.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("NOMBRE DE LA CARRERA");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(0, 40, 179, 30);
		panelDatos.add(lblNewLabel_2);
		
		txtCarrera = new JTextField();
		txtCarrera.setEnabled(false);
		txtCarrera.setColumns(10);
		txtCarrera.setBounds(189, 40, 265, 25);
		panelDatos.add(txtCarrera);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuCarreras.class.getResource("/images_proyect/fondoCarreras.jpg")));
		lblNewLabel.setBounds(495,5,355,408);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 97, 480, 310);
		contentPane.add(scrollPane);
		
		tableCarrera = new JTable();
		tableCarrera.addMouseListener(this);
		tableCarrera.setFont(new Font("Roboto", Font.PLAIN, 13));
		tableCarrera.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"CODIGO CARRERA", "NOMBRE DE LA CARRERA"
			}
		));
		scrollPane.setViewportView(tableCarrera);
		
		listadoCarreras();
		
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
		nuevoCodigo();
		txtCarrera.setEnabled(true);
		txtCarrera.requestFocus();
		btnGuardar.setEnabled(true);
	}
	
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		String codigo, nombre;
		
		codigo = txtCodigo.getText();
		nombre = txtCarrera.getText();
		
		if(nombre.isEmpty()) {
			mensaje("CAMPO CARRERA NO DEBE ESTAR VACIO");
			txtCarrera.requestFocus();
			return;
		}else if (!nombre.matches("[a-zA-zñÑ ]+")) {
			mensaje("CAMPO CARRERA DEBE TENER SOLO LETRAS");
			txtCarrera.requestFocus();
			return;
		}
		
		Carrera bean = new Carrera();
		bean.setCodigo(Integer.parseInt(codigo));
		bean.setNombre(nombre);
		
		int salida;
		salida = carreraDAO.registrar(bean);
		
		if(salida>0) {
			mensaje("CARRERA REGISTRADA!!");
			listadoCarreras();
			clear();
		}		
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		
		String nombre, codigo;
		codigo = txtCodigo.getText();
		nombre = txtCarrera.getText();
		
		Carrera bean = new Carrera();
		bean.setNombre(nombre);
		bean.setCodigo(Integer.parseInt(codigo));
		
		int salida;
		salida = carreraDAO.actualizar(bean);
		
		if(salida>0) {
			mensaje("CARRERA ACTUALIZADA!!");
			listadoCarreras();
			clear();
		}	
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
	
		int codigo, boton;

		codigo = Integer.parseInt(txtCodigo.getText());

		boton = JOptionPane.showConfirmDialog(this, "Sistema", "¿Seguro de eliminar?", JOptionPane.YES_NO_OPTION);

		if (boton == 0) {
			int salida;
			Carrera bean = new Carrera();
			bean.setCodigo(codigo);
			salida = carreraDAO.eliminar(codigo);

			if (salida == 1) {
				mensaje("CARRERA ELIMINADA.....");
				listadoCarreras();
				clear();
			} else {
				mensaje("ERROR AL ELIMINAR CARRERA.....");
			}
		}
	}
	
	void listadoCarreras() {
		ArrayList<Carrera> datos = carreraDAO.listAll();
		DefaultTableModel modeloCarrera = (DefaultTableModel) tableCarrera.getModel();
	
		modeloCarrera.setRowCount(0);
		
		for (Carrera bean : datos) {
			Object row[] = {bean.getCodigo(), bean.getNombre()};
			modeloCarrera.addRow(row);
		}
	}
	
	void mensaje(String m) {
		JOptionPane.showMessageDialog(this, m);
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableCarrera) {
			mouseClickedTableCarrera(e);
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
	protected void mouseClickedTableCarrera(MouseEvent e) {
		
		String codigo, nombre;
		int pos;
		
		pos = tableCarrera.getSelectedRow();
		
		codigo = tableCarrera.getValueAt(pos, 0).toString();
		nombre = tableCarrera.getValueAt(pos, 1).toString();
		
		
		txtCodigo.setText(codigo);
		txtCarrera.setText(nombre);
		txtCarrera.setEnabled(true);
		
		btnEliminar.setEnabled(true);
		btnActualizar.setEnabled(true);
	}
	
	void nuevoCodigo() {
		String codigo = String.valueOf(carreraDAO.ultimoCodigo());
		txtCodigo.setText(codigo);
		txtCarrera.requestFocus();
	}
	
	void clear() {
		txtCodigo.setText("");
		txtCarrera.setText("");
	}
}
