package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.edu.controlador.MySqlCiclosDAO;
import com.edu.entidad.Alumno;
import com.edu.entidad.Ciclos;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class MenuCiclos extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtCodigo;
	private JLabel lblNewLabel_2;
	private JTextField txtNombre;
	private JTable tableCiclos;
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	private MySqlCiclosDAO ciclosDAO = new MySqlCiclosDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCiclos frame = new MenuCiclos();
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
	public MenuCiclos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 327, 55);
		panel_1.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("CODIGO\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 53, 55);
		panel_1.add(lblNewLabel_1);
		
		txtCodigo = new JTextField();
		txtCodigo.setEnabled(false);
		txtCodigo.setBounds(65, 13, 86, 26);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNewLabel_2 = new JLabel("NOMBRE");
		lblNewLabel_2.setBounds(160, 0, 53, 55);
		panel_1.add(lblNewLabel_2);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(213, 13, 104, 26);
		panel_1.add(txtNombre);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 55, 317, 330);
		contentPane.add(scrollPane);
		
		tableCiclos = new JTable();
		tableCiclos.addMouseListener(this);
		tableCiclos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"CODIGO", "NOMBRE"
			}
		));
		scrollPane.setViewportView(tableCiclos);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuCiclos.class.getResource("/images_proyect/img_ciclos.jpg")));
		lblNewLabel.setBounds(326, 0, 295, 385);
		contentPane.add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(0, 386, 621, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(new Color(255, 255, 255));
		btnNuevo.setBackground(new Color(0, 0, 0));
		btnNuevo.addActionListener(this);
		btnNuevo.setBorder(new MatteBorder(1, 10, 1, 1, (Color) null));
		btnNuevo.setIconTextGap(20);
		btnNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		btnNuevo.setIcon(new ImageIcon(MenuCiclos.class.getResource("/images_proyect/nuevo.png")));
		btnNuevo.setBounds(10, 11, 143, 46);
		panel.add(btnNuevo);
		
		btnRegistrar = new JButton("GUARDAR");
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(new Color(0, 0, 0));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBorder(new MatteBorder(1, 10, 1, 1, (Color) null));
		btnRegistrar.setIconTextGap(18);
		btnRegistrar.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistrar.setIcon(new ImageIcon(MenuCiclos.class.getResource("/images_proyect/guardar.png")));
		btnRegistrar.setBounds(163, 11, 143, 46);
		panel.add(btnRegistrar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setBackground(new Color(0, 0, 0));
		btnActualizar.addActionListener(this);
		btnActualizar.setBorder(new MatteBorder(1, 10, 1, 1, (Color) null));
		btnActualizar.setIconTextGap(10);
		btnActualizar.setHorizontalAlignment(SwingConstants.LEFT);
		btnActualizar.setIcon(new ImageIcon(MenuCiclos.class.getResource("/images_proyect/actualizar.png")));
		btnActualizar.setBounds(316, 11, 143, 46);
		panel.add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setForeground(new Color(255, 255, 255));
		btnEliminar.setBackground(new Color(0, 0, 0));
		btnEliminar.addActionListener(this);
		btnEliminar.setBorder(new MatteBorder(1, 10, 1, 1, (Color) null));
		btnEliminar.setIconTextGap(15);
		btnEliminar.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminar.setIcon(new ImageIcon(MenuCiclos.class.getResource("/images_proyect/delete2.png")));
		btnEliminar.setBounds(468, 11, 143, 46);
		panel.add(btnEliminar);
		
		listado();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		nuevoCodigo();
		txtNombre.setText("");
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
		String codigo, nombre;
		
		codigo = txtCodigo.getText();
		nombre = txtNombre.getText();
		
		Ciclos bean = new Ciclos();
		
		bean.setCodigo(Integer.parseInt(codigo));
		bean.setNro_ciclo(nombre);
		
		int salida = ciclosDAO.registrar(bean);
		
		if(salida > 0) {
			JOptionPane.showMessageDialog(null, "CICLO REGISTRADO CORRECTAMENTE");
			txtCodigo.setText("");
			txtNombre.setText("");
			listado();
			//nuevoCodigo();
		}
		else {
			JOptionPane.showMessageDialog(null, "ERROR AL REGISTRAR CICLO");
		}
		
		
	}

	protected void actionPerformedBtnActualizar(ActionEvent e) {
		String codigo, nombre;

		codigo = txtCodigo.getText();
		nombre = txtNombre.getText();

		Ciclos bean = new Ciclos();
		bean.setNro_ciclo(nombre);
		bean.setCodigo(Integer.parseInt(codigo));

		int salida = ciclosDAO.actualizar(bean);

		if (salida > 0) {
			JOptionPane.showMessageDialog(null, "CICLO ACTUALIZADO CORRECTAMENTE");
			txtCodigo.setText("");
			txtNombre.setText("");
			listado();
		} else {
			JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR CICLO");
		}

	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int codigo, boton;
		
		codigo = Integer.parseInt(txtCodigo.getText());
		boton = JOptionPane.showConfirmDialog(this, "SISTEMA" , "¿SEGURO DE ELIMINAR?", JOptionPane.YES_NO_OPTION);
	
		if(boton == 0) {
			int salida;
			Ciclos bean = new Ciclos();
			bean.setCodigo(codigo);
			salida = ciclosDAO.eliminar(codigo);
			
			if(salida > 0) {
				txtCodigo.setText("");
				txtNombre.setText("");
				JOptionPane.showMessageDialog(null, "CICLO ELIMINADO");
				listado();
			}else {
				JOptionPane.showMessageDialog(null, "CICLO REGISTRADO");
			}
			
		}
	}
	
	void nuevoCodigo() {
		String codigo = String.valueOf(ciclosDAO.ultimoCodigo());
		txtCodigo.setText(codigo);
		txtNombre.requestFocus();
	}
	
	void listado() {
		ArrayList<Ciclos> datos = ciclosDAO.ListAll();
		DefaultTableModel modeloCiclos = (DefaultTableModel) tableCiclos.getModel();
	
		modeloCiclos.setRowCount(0);
		
		for (Ciclos ciclo : datos) {
			Object row[] = {ciclo.getCodigo(), ciclo.getNro_ciclo()};
			modeloCiclos.addRow(row);
		}
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableCiclos) {
			mouseClickedTableCiclos(e);
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
	protected void mouseClickedTableCiclos(MouseEvent e) {
		
		String codigo, nombre;
		int pos;
		
		pos = tableCiclos.getSelectedRow();
		
		codigo = tableCiclos.getValueAt(pos, 0).toString();
		nombre =  tableCiclos.getValueAt(pos, 1).toString();
		
		txtCodigo.setText(codigo);
		txtNombre.setText(nombre);
		
		
		
	}
}
