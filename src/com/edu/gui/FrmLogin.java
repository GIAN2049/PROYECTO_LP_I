package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.controlador.MySqlUsuarioDAO;
import com.edu.entidad.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmLogin extends JFrame implements ActionListener, KeyListener {
	
	private MySqlUsuarioDAO usuDao = new MySqlUsuarioDAO();

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelFondo;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtUsuario;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblNewLabel_3;
	private JPasswordField txtContraseña;
	private JButton btnIniciarSesion;
	private JButton btnVisibilidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 731, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 372, 403);
		panel.add(panelFondo);
		panelFondo.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmLogin.class.getResource("/images_proyect/login_img.jpg")));
		lblNewLabel.setBounds(0,0,372,403);
		panelFondo.add(lblNewLabel);
		
		panelFondo.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(371, 0, 366, 403);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 366, 120);
		lblNewLabel_1.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(FrmLogin.class.getResource("/images_proyect/usuario(4).png")));
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("USUARIO");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(46, 131, 134, 31);
		panel_1.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setForeground(Color.BLACK);
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(null);
		txtUsuario.setBackground(Color.WHITE);
		txtUsuario.setBounds(46, 163, 277, 20);
		panel_1.add(txtUsuario);
		
		separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.BLACK);
		separator.setBounds(46, 192, 277, 2);
		panel_1.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(46, 279, 277, 2);
		panel_1.add(separator_1);
		
		lblNewLabel_3 = new JLabel("CONTRASEÑA");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Roboto", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(46, 218, 134, 31);
		panel_1.add(lblNewLabel_3);
		
		txtContraseña = new JPasswordField();
		txtContraseña.addKeyListener(this);
		txtContraseña.setForeground(Color.BLACK);
		txtContraseña.setBorder(null);
		txtContraseña.setBackground(Color.WHITE);
		txtContraseña.setBounds(46, 247, 244, 20);
		panel_1.add(txtContraseña);
		
		btnIniciarSesion = new JButton("INICIAR SESION");
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setForeground(Color.WHITE);
		btnIniciarSesion.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.setBackground(new Color(65, 105, 225));
		btnIniciarSesion.setBounds(127, 315, 122, 31);
		panel_1.add(btnIniciarSesion);
		
		btnVisibilidad = new JButton("");
		btnVisibilidad.setVisible(false);
		btnVisibilidad.addActionListener(this);
		btnVisibilidad.setBackground(new Color(255, 255, 255));
		btnVisibilidad.setIcon(new ImageIcon(FrmLogin.class.getResource("/images_proyect/invisible.png")));
		btnVisibilidad.setFocusable(false);
		btnVisibilidad.setBorder(null);
		btnVisibilidad.setBounds(300, 248, 19, 19);
		panel_1.add(btnVisibilidad);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVisibilidad) {
			actionPerformedBtnVisibilidad(e);
		}
		if (e.getSource() == btnIniciarSesion) {
			actionPerformedBtnIniciarSesion(e);
		}
	}
	protected void actionPerformedBtnIniciarSesion(ActionEvent e) {
		String vusuario, vcontraseña;
		
		vusuario = txtUsuario.getText();
		vcontraseña = txtContraseña.getText();
		
		Usuario bean = usuDao.iniciarSesion(vusuario, vcontraseña);
		
		if(bean == null) {
			JOptionPane.showMessageDialog(null, "USUAIO Y/O CONTRASEÑA INCONRRECTOS");
			txtUsuario.setText("");
			txtContraseña.setText("");
		}else {
			JOptionPane.showMessageDialog(null, "Bievenido");
			FrmInicio frm = new FrmInicio(bean);
			//FrmInfoUsuario frminfo = new FrmInfoUsuario(bean);
			//frm.lblDatosUsuario.setText(bean.getNombre() + " " + bean.getApellido());
			frm.setVisible(true);
			dispose();
		} 		
	}
	
	protected void actionPerformedBtnVisibilidad(ActionEvent e) {
		if(txtContraseña.getEchoChar() == '\u2022') {
			txtContraseña.setEchoChar((char) 0);
			btnVisibilidad.setIcon(new ImageIcon(FrmLogin.class.getResource("/images_proyect/visible.png")));
		}else {
            txtContraseña.setEchoChar('\u2022');
            btnVisibilidad.setIcon(new ImageIcon(FrmLogin.class.getResource("/images_proyect/invisible.png")));
        }
	}
	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtContraseña) {
	        keyReleasedTxtContraseña(e);
	    }
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtContraseña) {
			keyTypedTxtContraseña(e);
		}
	}
	protected void keyTypedTxtContraseña(KeyEvent e) {
		btnVisibilidad.setVisible(true);
	}
	protected void keyReleasedTxtContraseña(KeyEvent e) {
	    String contraseña = txtContraseña.getText().trim();
	    if (contraseña.isEmpty()) {
	        btnVisibilidad.setVisible(false);
	    }
	}
	
	void datosUsuario() {
		
	}
}
