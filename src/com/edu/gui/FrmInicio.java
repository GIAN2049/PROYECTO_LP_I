package com.edu.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.edu.entidad.Usuario;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class FrmInicio extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelInfoUsuario;
	public JLabel lblDatosUsuario;
	private JButton btnArchivo;
	private JButton btnProceso;
	private JButton btnReportes;
	private JButton btnCerrarSesion;
	private JPanel panelContainer;
	private JButton btnInfoUsuario;
	
	private Usuario bean;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmInicio frame = new FrmInicio(null);
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
	public FrmInicio(Usuario bean) {
		this.bean = bean;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 615);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 197, 576);
		panel.setBackground(new Color(47, 47, 47));
		contentPane.add(panel);
		panel.setLayout(null);
		
		panelInfoUsuario = new JPanel();
		panelInfoUsuario.setBackground(new Color(47, 47, 47));
		panelInfoUsuario.setBounds(0, 0, 197, 162);
		panel.add(panelInfoUsuario);
		panelInfoUsuario.setLayout(null);
		
		lblDatosUsuario = new JLabel("New label");
		lblDatosUsuario.setBackground(new Color(51, 153, 255));
		lblDatosUsuario.setForeground(new Color(255, 255, 255));
		lblDatosUsuario.setBounds(0, 118, 197, 44);
		lblDatosUsuario.setBorder(new EmptyBorder(13, 0, 14, 0));
		lblDatosUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosUsuario.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblDatosUsuario.setText(bean.getNombre() +" "+ bean.getApellido());
		panelInfoUsuario.add(lblDatosUsuario);
		
		btnInfoUsuario = new JButton("");
		btnInfoUsuario.addActionListener(this);
		btnInfoUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInfoUsuario.setBorderPainted(false);
		btnInfoUsuario.setBackground(new Color(47, 47, 47));
		btnInfoUsuario.setIcon(new ImageIcon(FrmInicio.class.getResource("/images_proyect/user_log.png")));
		btnInfoUsuario.setFocusPainted(false);
		btnInfoUsuario.setFocusable(false);
		btnInfoUsuario.setBounds(0, 0, 197, 118);
		panelInfoUsuario.add(btnInfoUsuario);
		
		btnArchivo = new JButton("ARCHIVO");
		btnArchivo.addActionListener(this);
		btnArchivo.setIconTextGap(20);
		btnArchivo.setHorizontalAlignment(SwingConstants.LEFT);
		btnArchivo.setIcon(new ImageIcon(FrmInicio.class.getResource("/images_proyect/folder.png")));
		btnArchivo.setBackground(new Color(0, 0, 0));
		btnArchivo.setForeground(new Color(255, 255, 255));
		btnArchivo.setFont(new Font("Roboto", Font.PLAIN, 13));
		btnArchivo.setFocusable(false);
		btnArchivo.setBorder(new EmptyBorder(0, 19, 0, 0));
		btnArchivo.setBounds(0, 162, 197, 40);
		panel.add(btnArchivo);
		
		btnProceso = new JButton("PROCESO");
		btnProceso.setIcon(new ImageIcon(FrmInicio.class.getResource("/images_proyect/proceso.png")));
		btnProceso.addActionListener(this);
		btnProceso.setIconTextGap(20);
		btnProceso.setHorizontalAlignment(SwingConstants.LEFT);
		btnProceso.setBackground(new Color(0, 0, 0));
		btnProceso.setForeground(new Color(255, 255, 255));
		btnProceso.setFont(new Font("Roboto", Font.PLAIN, 13));
		btnProceso.setFocusable(false);
		btnProceso.setBorder(new EmptyBorder(0, 19, 0, 0));
		btnProceso.setBounds(0, 202, 197, 40);
		panel.add(btnProceso);
		
		btnReportes = new JButton("REPORTES");
		btnReportes.addActionListener(this);
		btnReportes.setHorizontalAlignment(SwingConstants.LEADING);
		btnReportes.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnReportes.setIconTextGap(20);
		btnReportes.setIcon(new ImageIcon(FrmInicio.class.getResource("/images_proyect/report.png")));
		btnReportes.setBackground(new Color(0, 0, 0));
		btnReportes.setForeground(new Color(255, 255, 255));
		btnReportes.setFont(new Font("Roboto", Font.PLAIN, 13));
		btnReportes.setFocusable(false);
		btnReportes.setBorder(new EmptyBorder(0, 19, 0, 0));
		btnReportes.setBounds(0, 242, 197, 40);
		panel.add(btnReportes);
		
		btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.addActionListener(this);
		btnCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		btnCerrarSesion.setIconTextGap(20);
		btnCerrarSesion.setIcon(new ImageIcon(FrmInicio.class.getResource("/images_proyect/salida.png")));
		btnCerrarSesion.setBackground(new Color(0, 0, 0));
		btnCerrarSesion.setForeground(new Color(255, 255, 255));
		btnCerrarSesion.setFont(new Font("Roboto", Font.PLAIN, 13));
		btnCerrarSesion.setFocusable(false);
		btnCerrarSesion.setBorder(new EmptyBorder(0, 19, 0, 0));
		btnCerrarSesion.setBounds(0, 277, 197, 40);
		panel.add(btnCerrarSesion);
		
		panelContainer = new JPanel(){
			private Image imagen;

			{
				imagen = new ImageIcon(getClass().getResource("/images_proyect/fondoPrincipal.jpg")).getImage();
			}
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
			}
		};
		panelContainer.setBounds(195, 0, 870, 576);
		contentPane.add(panelContainer);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnInfoUsuario) {
			actionPerformedBtnInfoUsuario(e);
		}
		if (e.getSource() == btnCerrarSesion) {
			actionPerformedBtnCerrarSesion(e);
		}
		if (e.getSource() == btnReportes) {
			actionPerformedBtnReportes(e);
		}
		if (e.getSource() == btnProceso) {
			actionPerformedBtnProceso(e);
		}
		if (e.getSource() == btnArchivo) {
			actionPerformedBtnArchivo(e);
		}
	}
	protected void actionPerformedBtnArchivo(ActionEvent e) {
		
		FrmArchivo frm = new FrmArchivo();
		frm.setBounds(0, 0, 871, 576);
		frm.setLocation(195,0);
		
		contentPane.remove(panelContainer);
		contentPane.add(frm);
		contentPane.revalidate();
		contentPane.repaint();
	}
	protected void actionPerformedBtnProceso(ActionEvent e) {
		
		FrmProceso p = new FrmProceso();
		//p.setLocationRelativeTo(this);
		p.setLocation(400,170);
		p.setVisible(true);
		
	}
	protected void actionPerformedBtnReportes(ActionEvent e) {
		FrmReportes r = new FrmReportes();
		r.setLocation(400,170);
		//r.setLocationRelativeTo(FrmInicio.this);
		r.setVisible(true);
	}
	protected void actionPerformedBtnCerrarSesion(ActionEvent e) {
		System.exit(0);
	}
	protected void actionPerformedBtnInfoUsuario(ActionEvent e) {	
		FrmInfoUsuario infoUsu = new FrmInfoUsuario(bean);
		infoUsu.setLocationRelativeTo(FrmInicio.this);
		infoUsu.setVisible(true);
	}
}
