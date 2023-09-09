package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.entidad.Usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmInfoUsuario extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	public JLabel lblNombreUsu;
	public JTextField txtNombreUsuario;
	private JLabel lblApellido;
	public JTextField txtApellidoUsuario;
	private JLabel lblNewLabel_1;
	private JLabel lblApellido_1;
	public JTextField txtCorreoUsuaio;
	public JTextField txtGeneroUsuario;
	private JLabel lblNewLabel_2;
	public JTextField txtTelefonoUsuario;
	private JButton btnActualizar;
	private JButton btnGuardar;
	private JLabel lblNewLabel_3;
	
	private Usuario bean;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInfoUsuario frame = new FrmInfoUsuario(null);
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
	public FrmInfoUsuario(Usuario bean) {
		this.bean = bean;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 574, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 558, 100);
		panel.setBackground(new Color(68, 69, 72));
		panel.setPreferredSize(new Dimension(10, 100));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(68, 69, 72));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(FrmInfoUsuario.class.getResource("/images_proyect/user_log.png")));
		lblNewLabel_3.setBounds(0, 0, 560, 100);
		panel.add(lblNewLabel_3);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 453, 558, 76);
		panel_1.setBackground(new Color(68, 69, 72));
		panel_1.setPreferredSize(new Dimension(10, 65));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnActualizar = new JButton("ACTUALIZAR ");
		btnActualizar.addActionListener(this);
		btnActualizar.setIcon(new ImageIcon(FrmInfoUsuario.class.getResource("/images_proyect/actualizar.png")));
		btnActualizar.setBounds(60, 11, 219, 43);
		panel_1.add(btnActualizar);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(FrmInfoUsuario.class.getResource("/images_proyect/guardar.png")));
		btnGuardar.setBounds(292, 11, 219, 43);
		panel_1.add(btnGuardar);
		
		panel_2 = new JPanel();
		panel_2.setBounds(0, 100, 558, 354);
		panel_2.setBackground(new Color(68, 69, 72));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblNombreUsu = new JLabel("NOMBRE");
		lblNombreUsu.setForeground(new Color(255, 255, 255));
		lblNombreUsu.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNombreUsu.setBounds(100, 50, 90, 14);
		panel_2.add(lblNombreUsu);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setEnabled(false);
		txtNombreUsuario.setBounds(203, 42, 205, 26);
		panel_2.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		lblApellido = new JLabel("APELLIDO");
		lblApellido.setForeground(new Color(255, 255, 255));
		lblApellido.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblApellido.setBounds(100, 85, 90, 14);
		panel_2.add(lblApellido);
		
		txtApellidoUsuario = new JTextField();
		txtApellidoUsuario.setEnabled(false);
		txtApellidoUsuario.setColumns(10);
		txtApellidoUsuario.setBounds(203, 77, 205, 26);
		panel_2.add(txtApellidoUsuario);
		
		lblNewLabel_1 = new JLabel("GENERO");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(100, 118, 90, 14);
		panel_2.add(lblNewLabel_1);
		
		lblApellido_1 = new JLabel("CORREO");
		lblApellido_1.setForeground(new Color(255, 255, 255));
		lblApellido_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblApellido_1.setBounds(100, 153, 90, 14);
		panel_2.add(lblApellido_1);
		
		txtCorreoUsuaio = new JTextField();
		txtCorreoUsuaio.setEnabled(false);
		txtCorreoUsuaio.setColumns(10);
		txtCorreoUsuaio.setBounds(203, 145, 205, 26);
		panel_2.add(txtCorreoUsuaio);
		
		txtGeneroUsuario = new JTextField();
		txtGeneroUsuario.setEnabled(false);
		txtGeneroUsuario.setColumns(10);
		txtGeneroUsuario.setBounds(203, 110, 205, 26);
		panel_2.add(txtGeneroUsuario);
		
		lblNewLabel_2 = new JLabel("TELEFONO");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(100, 186, 90, 14);
		panel_2.add(lblNewLabel_2);
		
		txtTelefonoUsuario = new JTextField();
		txtTelefonoUsuario.setEnabled(false);
		txtTelefonoUsuario.setColumns(10);
		txtTelefonoUsuario.setBounds(203, 178, 205, 26);
		panel_2.add(txtTelefonoUsuario);
		
		txtNombreUsuario.setText(bean.getNombre());
		txtApellidoUsuario.setText(bean.getApellido());
		txtGeneroUsuario.setText(bean.getGenero());
		txtCorreoUsuaio.setText(bean.getCorreo());
		txtTelefonoUsuario.setText(bean.getTelefono());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
	}
	
	protected void actionPerformedBtnActualizar(ActionEvent e) {
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
	}
}
